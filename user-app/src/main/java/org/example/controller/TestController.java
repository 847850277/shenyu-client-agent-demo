package org.example.controller;

import org.example.annotation.ShenyuSpringMvcClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    
    /**
     * hello.
     *
     * @return result
     */
    @RequestMapping("/shenyu/client/hello")
    @ShenyuSpringMvcClient("/shenyu/client/hello")
    public String hello() {
        return "hello";
    }



}
