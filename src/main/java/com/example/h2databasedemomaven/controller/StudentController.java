package com.example.h2databasedemomaven.controller;

import com.example.h2databasedemomaven.domain.Student;
import com.example.h2databasedemomaven.exception.CustomException;
import com.example.h2databasedemomaven.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value="/h2demo")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/datainsert")
    public ResponseEntity<String> studentDataInsert(@RequestBody Student student){
        try{
            studentService.studentDataUpdateService(student);
            return new ResponseEntity<>("successfully inserted", HttpStatus.OK);
        }catch (CustomException e){
            log.info("error in getting response");
            return new ResponseEntity<>("error in getting data",HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping("/studentDetails")
    public ResponseEntity<Student> getStudentDataById(@RequestParam(name = "id") String id){
        try{
            Student student=studentService.returnDatabyId(id);
            return new ResponseEntity<>(student,HttpStatus.OK);
        }catch (CustomException e){
            log.info("error in getting response");
            return new ResponseEntity<>(null,null,HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/deleteData")
    public ResponseEntity<String> deleteData(@RequestParam(name="id") String id){
        try{
            studentService.studentDataDelete(id);
            return new ResponseEntity<>("Successfully deleted data",HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(null,null,HttpStatus.BAD_REQUEST);
        }

    }
}
