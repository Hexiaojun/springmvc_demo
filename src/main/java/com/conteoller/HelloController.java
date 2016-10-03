package com.conteoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * Created by chenglei on 2016/9/17.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(HashMap<String, Object> model) {
        model.put("hello", "你好");
        return "hello";
    }

    @RequestMapping("/world")
    public String world() {
        return "world";
    }
}
