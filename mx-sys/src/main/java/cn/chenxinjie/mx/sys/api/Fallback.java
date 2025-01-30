package cn.chenxinjie.mx.sys.api;

import org.springframework.stereotype.Component;

@Component
public class Fallback implements SchoolOpenAPI{
    @Override
    public String hello() {
        throw new RuntimeException("Boom!");
    }
}
