package com.example.fullstack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.fullstack.dao.StudentDao;
import com.example.fullstack.model.StudentEntity;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @Autowired
    StudentDao dao;

    @PostMapping("/student")
    public String saveStudent(StudentEntity s, RedirectAttributes sa) {
        dao.save(s);
        sa.addFlashAttribute("save", "saved successfull");
        return "redirect:/student";
    }

    @PostMapping("/delete")

    public String delete(StudentEntity s, RedirectAttributes sa) {
        dao.delete(s);
        sa.addFlashAttribute("delete", "deleted successfull");
        return "redirect:/student";
    }

    @PostMapping("/update")
    public String update(StudentEntity s, RedirectAttributes sa) {
        dao.update(s);
        sa.addFlashAttribute("update", "updated successfull");
        return "redirect:/student";
    }

    @GetMapping("/student")
    public String getMethodName(Model model) {
        List<StudentEntity> list = dao.getAllStudent();
        model.addAttribute("student", list);
        return "student";
    }

}
