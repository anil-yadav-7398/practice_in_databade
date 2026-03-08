package com.example.fullstack.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.fullstack.model.StudentEntity;

public class RowMapper implements org.springframework.jdbc.core.RowMapper<StudentEntity> {

    public StudentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentEntity s = new StudentEntity();
        s.setId(rs.getInt("id"));
        s.setName(rs.getString("name"));
        s.setAddress(rs.getString("address"));
        return s;

    }
}