package com.example.h2databasedemomaven.Repository;

import com.example.h2databasedemomaven.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public class InsertStudentDao {
    public static final String INSERT_STUDENT="INSERT INTO STUDENT(ID, NAME1, AGE,EMAIL)\n" +
            "VALUES (:id,:name1,:age,:email);";
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public void insertStudentTable(Student student){
        MapSqlParameterSource inputParam=new MapSqlParameterSource();
        inputParam.addValue("id",student.getId());
        inputParam.addValue("name1",student.getName());
        inputParam.addValue("age",student.getAge());
        inputParam.addValue("email",student.getEmail());
        namedParameterJdbcTemplate.update(INSERT_STUDENT,inputParam);
    }
}
