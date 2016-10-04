package Interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chenglei on 2016/10/4.
 */

@Controller
@RequestMapping("/encoding")
public class EncodingController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPager() {
        return "login";
    }

    @RequestMapping("/demo")
    public String getUser(String name, String psw) {
        System.out.println(name);
        System.out.println(psw);
        return "login_one";
    }
}
