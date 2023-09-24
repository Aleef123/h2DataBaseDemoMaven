package com.example.h2databasedemomaven.service;

import com.example.h2databasedemomaven.Repository.InsertStudentDao;
import com.example.h2databasedemomaven.Repository.StudentDao;
import com.example.h2databasedemomaven.Repository.StudentDataDeleteDao;
import com.example.h2databasedemomaven.domain.Student;
import com.example.h2databasedemomaven.exception.CustomException;
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
        try{
            insertStudentDao.insertStudentTable(student);
        }catch (Exception e){
            throw new CustomException("error in invoking dao",e);
        }
    }
    public Student returnDatabyId(String id){
        try{
            Student studentData=studentDao.getStudentDetails(id);
            return studentData;
        }catch (Exception e){
            throw new CustomException("error in invoking dao",e);
        }
        }

    public void studentDataDelete(String id){
        try {
            studentDataDeleteDao.deleteData(id);
        }catch(Exception e){
            throw new CustomException("error in invoking dao",e);
        }

    }

}
