package com.example.h2databasedemomaven.service;

import com.example.h2databasedemomaven.Repository.InsertStudentDao;
import com.example.h2databasedemomaven.Repository.StudentDao;
import com.example.h2databasedemomaven.Repository.StudentDataDeleteDao;
import com.example.h2databasedemomaven.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    InsertStudentDao insertStudentDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    StudentDataDeleteDao studentDataDeleteDao;
    public void studentDataUpdateService(Student student){
        insertStudentDao.insertStudentTable(student);
    }
    public Student returnDatabyId(String id){
        Student studentData=studentDao.getStudentDetails(id);
        return studentData;
    }
    public void studentDataDelete(String id){
        studentDataDeleteDao.deleteData(id);
    }

}
