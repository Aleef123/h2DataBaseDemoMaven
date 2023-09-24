package com.example.h2databasedemomaven.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDataDeleteDao {
    public static final String STUDENT_DATA_DELETE="delete from STUDENT where ID=:id";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void deleteData(String id){
        try{
            MapSqlParameterSource inputparam = new MapSqlParameterSource();
            inputparam.addValue("id",id);
            namedParameterJdbcTemplate.update(STUDENT_DATA_DELETE,inputparam);
        }catch (Exception e){
            throw new RuntimeException();
        }

    }
}
