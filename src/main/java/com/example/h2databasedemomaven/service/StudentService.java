package com.example.h2databasedemomaven.service;

import com.example.h2databasedemomaven.Repository.InsertStudentDao;
import com.example.h2databasedemomaven.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    InsertStudentDao insertStudentDao;
    public void studentDataUpdateService(Student student){
        insertStudentDao.insertStudentTable(student);
    }
}
