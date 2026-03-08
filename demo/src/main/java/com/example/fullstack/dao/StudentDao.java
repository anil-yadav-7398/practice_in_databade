package com.example.fullstack.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.fullstack.model.StudentEntity;

@Repository
public class StudentDao {
    @Autowired
    JdbcTemplate jdbc;

    public int save(StudentEntity s) {
        String sql = " insert into study(id ,name, address) values(?,?,?)";
        return jdbc.update(sql, s.getId(), s.getName(), s.getAddress());
    }

    public int delete(StudentEntity s) {
        // delete id though in student
        String query = " delete from study where id=?";
        int r = jdbc.update(query, s.getId());

        return r;
    }

    public int update(StudentEntity s) {
        // update student in id though
        String query = " update study set name=?,address=? where id=?";
        int r = jdbc.update(query, s.getName(), s.getAddress(), s.getId());

        return r;
    }

    public List<StudentEntity> getAllStudent() {
        // get all student
        String query = " select * from study";

        // List<StudentEntity> list = jdbc.query(query, new RowMapper());
        return jdbc.query(query, new RowMapper());

    }
}
