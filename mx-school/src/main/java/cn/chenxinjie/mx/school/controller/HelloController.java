package cn.chenxinjie.mx.school.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @ResponseBody
    @PostMapping("/hello")
    private String hello() {
        return "school: hello world!";
    }
}
