package com.proj.mkmarket.controller;

import com.proj.mkmarket.domain.User;
import com.proj.mkmarket.dto.UserDTO;
import com.proj.mkmarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping("/signup")
    public String signupForm() {
        // 회원가입 폼을 보여주는 코드
//        model.addAttribute("user", new UserEntity());
        return "/user/signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute UserDTO userDTO) {
        // 회원가입 로직을 수행하고 데이터베이스에 저장
        userService.signup(userDTO);
        return "redirect:/users/login"; // 회원가입 완료 후 로그인 페이지로 이동. 일단은 index로 이동
    }

    @GetMapping("/main")
    public String main() {
        return "/user/main";
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
            return "redirect:/";
        } else {
            System.out.println("login ::" +loginResult);
            return "redirect:/users/login";
        }
    }
}
