package com.proj.mkmarket.controller;

import com.proj.mkmarket.domain.UserEntity;
import com.proj.mkmarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

   /* @GetMapping("/")
    @ResponseBody
    public String main(){
        return "하위~";
    }*/

    @GetMapping("/signup")
    public String signupForm() {
        // 회원가입 폼을 보여주는 코드
//        model.addAttribute("user", new UserEntity());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(UserEntity user) {
        // 회원가입 로직을 수행하고 데이터베이스에 저장
        userService.signup(user);
        return "redirect:/index"; // 회원가입 완료 후 로그인 페이지로 이동. 일단은 index로 이동
    }
}
