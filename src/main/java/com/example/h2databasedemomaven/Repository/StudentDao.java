package com.example.h2databasedemomaven.Repository;

import com.example.h2databasedemomaven.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class StudentDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public static final String SELECT_STUDENT="select NAME1,AGE,EMAIL from " +
            "STUDENT where ID=:id";
    public Student getStudentDetails(String id){
        try{
            MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
            sqlParameterSource.addValue("id",id);
            log.info(String.valueOf(id));
            return namedParameterJdbcTemplate.query(SELECT_STUDENT,sqlParameterSource,rs->{
                Student student=new Student();
                student.setId(id);
                student.setName(rs.getString("NAME1"));
                student.setAge(rs.getInt("AGE"));
                student.setEmail(rs.getString("EMAIL"));
                return student;
            });
        }catch (Exception e){
            throw new RuntimeException();
        }

    }
}
