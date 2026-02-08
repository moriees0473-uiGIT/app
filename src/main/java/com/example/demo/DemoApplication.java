package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping; // 追加
import org.springframework.web.bind.annotation.RestController; // 追加

@SpringBootApplication
@RestController // 追加: Webアプリとして動くようにする
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // 追加: ブラウザでアクセスした時の処理
    @GetMapping("/")
    public String hello() {
        return "after noon Docker World! by Mori good!!";
    }
}