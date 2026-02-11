package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // RestControllerから変更
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; // PostMappingを追加
import org.springframework.web.bind.annotation.RequestParam;

@Controller // 画面を返すときは @Controller を使います
public class StudentController {

    @Autowired
    private StudentRepository repository;

    // トップ画面（一覧表示）
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", repository.findAll());
        return "index"; // index.html を表示
    }

    // 登録処理（POSTメソッド）
    @PostMapping("/add")
    public String addStudent(@RequestParam String name, @RequestParam String email) {
        Student s = new Student();
        s.setName(name);
        s.setEmail(email);
        repository.save(s);
        return "redirect:/"; // 登録後はトップ画面に自動で戻る
    }
}
