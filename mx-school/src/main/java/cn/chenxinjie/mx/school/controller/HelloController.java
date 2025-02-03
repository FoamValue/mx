package cn.chenxinjie.mx.school.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @ResponseBody
    @PostMapping("/hello")
    private String hello(){
//        try {
//            Thread.sleep(60000l); // 模拟延迟
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return "school: hello world!";
    }
}
