package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.Enum.UserRole;
import com.example.learningmanagementsystem.exception.CourseExceptionHandler;
import com.example.learningmanagementsystem.exception.SubExceptionHandler;
import com.example.learningmanagementsystem.model.Course;
import com.example.learningmanagementsystem.model.Submission;
import com.example.learningmanagementsystem.model.User;
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

    @Override
    public List<Submission> getAllSub() {
        List<Submission> submissions=iSubmissionRepo.findAll();
        return submissions;
    }
    @Override
    public Submission save(Submission submission) throws SubExceptionHandler {
//        Submission c=iSubmissionRepo.save(submission);
//        return c;
        User user=repositoryUser.findById(submission.getStudentId().getId()).orElse(null);
        if (user.getRole().equals(UserRole.STUDENT)) {
            submission.getStudentId().setId(user.getId());
            submission.getStudentId().setUserName(user.getUserName());
            submission.getStudentId().setPassword(user.getPassword());
            submission.getStudentId().setRole(user.getRole());
            Submission c = iSubmissionRepo.save(submission);
            return c;
        }else {

            throw new SubExceptionHandler();
        }
    }

    @Override
    public List<Submission> getGradesByStudentId(Long studentId) {
        return iSubmissionRepo.findByStudentId(studentId);
    }

    @Override
    public Submission findById(int subId){

        return iSubmissionRepo.findById(subId).orElse(null);
    }
}
