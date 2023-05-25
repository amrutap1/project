package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.Enum.UserRole;
import com.example.learningmanagementsystem.dto.SubmCl;
import com.example.learningmanagementsystem.exception.SubExceptionHandler;
import com.example.learningmanagementsystem.model.Assignment;
import com.example.learningmanagementsystem.model.Submission;
import com.example.learningmanagementsystem.model.User;
import com.example.learningmanagementsystem.repository.IAssignRepo;
import com.example.learningmanagementsystem.repository.IRepositoryUser;
import com.example.learningmanagementsystem.repository.ISubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService implements ISubmissionService {

    @Autowired
    ISubmissionRepo iSubmissionRepo;

    @Autowired
    IRepositoryUser repositoryUser;
    @Autowired
     IAssignRepo iAssignRepo;

    @Override
    public List<Submission> getAllSub() {
        List<Submission> submissions=iSubmissionRepo.findAll();
        return submissions;
    }
    @Override
    public Submission save(SubmCl submCl) throws SubExceptionHandler {
//        Submission c=iSubmissionRepo.save(submission);
//        return c;
        User user=repositoryUser.findById(submCl.getStudentId()).orElse(null);
        Assignment assignment=iAssignRepo.findById(submCl.getAssignId()).orElse(null);
       if (user.getRole().equals(UserRole.STUDENT)) {
            Submission s=new Submission();
            s.setAssignId(assignment);
            s.setStudentId(user);
            s.setGrade(submCl.getGrade());
            s.setFeedback(submCl.getFeedback());
            return iSubmissionRepo.save(s);
        }else {

            throw new SubExceptionHandler();
        }
    }

    @Override
    public List<Submission> getGradesByStudent(User student) {

        return iSubmissionRepo.findByStudentId(student);
    }

    @Override
    public Submission findById(int subId){

        return iSubmissionRepo.findById(subId).orElse(null);
    }
}
