package com.example.learningmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(CourseExceptionHandler.class)
        public ResponseEntity<String> RoleNotFound(){
        return new ResponseEntity<>("Enter Valid Teacher Id", HttpStatus.EXPECTATION_FAILED);
         }

         @ExceptionHandler(ClassExceptionHandler.class)
        public ResponseEntity<String> ClassROle(){
            return new ResponseEntity<>("Enter Valid Teacher Id", HttpStatus.EXPECTATION_FAILED);
        }
        @ExceptionHandler(SubExceptionHandler.class)
        public ResponseEntity<String> subRole(){
            return new ResponseEntity<>("Enter Valid Student Id", HttpStatus.EXPECTATION_FAILED);
        }

        @ExceptionHandler(AssignExceptionHandler.class)
        public ResponseEntity<String> AssignCourse(){
            return new ResponseEntity<>("Enter Valid Course Id", HttpStatus.EXPECTATION_FAILED);
        }


}
