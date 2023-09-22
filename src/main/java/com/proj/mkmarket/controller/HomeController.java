package com.proj.mkmarket.controller;

import com.proj.mkmarket.dto.UserDTO;
import com.proj.mkmarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "itemList";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "/user/signin";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDTO dto, HttpSession session) {
        UserDTO loginResult = userService.login(dto);
        System.out.println("DTO ::" + dto);
        if (loginResult != null) {
            session.setAttribute("loginId", loginResult.getUserId());
            session.setAttribute("name", loginResult.getName());
            return "redirect:/users/{userId}";
        } else {
            System.out.println("login ::" +loginResult);
            return "redirect:/users/login";
        }
    }
}
