package cn.chenxinjie.mx.sys.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "mx-school", fallback = Fallback.class)
public interface SchoolOpenAPI {
    @PostMapping("/hello")
    String hello();
}