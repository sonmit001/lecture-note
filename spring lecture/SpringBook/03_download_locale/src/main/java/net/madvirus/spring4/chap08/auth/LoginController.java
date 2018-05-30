package net.madvirus.spring4.chap08.auth;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/auth/login")
    public String loginForm() {
        return "auth/loginForm";
    }
}