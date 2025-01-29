package cn.chenxinjie.mx.sys.controller;

import cn.chenxinjie.mx.sys.api.SchoolOpenAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private SchoolOpenAPI schoolOpenAPI;

    @ResponseBody
    @PostMapping("/hello")
    private String hello() {
        return "sys: hello world!";
    }

    @ResponseBody
    @PostMapping("/callSchool")
    private String callSchool() {
        return schoolOpenAPI.hello();
    }
}
