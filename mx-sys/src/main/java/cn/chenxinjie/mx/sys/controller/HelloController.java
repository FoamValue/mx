package cn.chenxinjie.mx.sys.controller;

import cn.chenxinjie.mx.sys.api.SchoolOpenAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private SchoolOpenAPI schoolOpenAPI;

    @ResponseBody
    @PostMapping("/hello")
    private String hello() {
        String s = "sys: hello world!";
        logger.info(s);
        return s;
    }

    @ResponseBody
    @PostMapping("/callSchool")
    private String callSchool() {
        String s = "callSchool";
        logger.info(s);
        return schoolOpenAPI.hello();
    }
}
