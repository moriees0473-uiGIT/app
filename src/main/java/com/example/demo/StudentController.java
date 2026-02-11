package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository repository;

    // 生徒を追加するURL（例: /add?name=Taro）
    @GetMapping("/add")
    public String addStudent(@RequestParam String name, @RequestParam String email) {
        Student s = new Student();
        s.setName(name);
        s.setEmail(email);
        repository.save(s);
        return "保存完了: " + name;
    }

    // 生徒一覧を表示するURL
    @GetMapping("/list")
    public List<Student> getStudents() {
        return repository.findAll();
    }
}