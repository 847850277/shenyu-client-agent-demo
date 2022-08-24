package org.example.controller;

import org.example.annotation.ShenyuSpringMvcClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Test1Controller {
    
    /**
     * hello.
     *
     * @return result
     */
    @RequestMapping("/shenyu/client/hello1")
    @ShenyuSpringMvcClient("/shenyu/client/hello1")
    public String hello1() {
        return "hello1";
    }



}
