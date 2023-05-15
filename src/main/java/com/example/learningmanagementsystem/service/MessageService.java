package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Messages;
import com.example.learningmanagementsystem.repository.IMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements  IMessageService{

    @Autowired
    IMessageRepo iMessageRepo;

    @Override
    public List<Messages> getAllMsg() {
        List<Messages> messages=iMessageRepo.findAll();
        return messages;
    }
    @Override
    public Messages save(Messages messages){
        Messages c=iMessageRepo.save(messages);
        return c;
    }
}
