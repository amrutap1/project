package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Messages;

import java.util.List;

public interface IMessageService {
    List<Messages> getAllMsg();

     Messages save(Messages messages);
}
