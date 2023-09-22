package com.proj.mkmarket.controller;

import com.proj.mkmarket.domain.User;
import com.proj.mkmarket.dto.UserDTO;
import com.proj.mkmarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.Optional;

import static javax.swing.text.html.HTML.Tag.U;

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

    @GetMapping("/{idx}")
    public String findById(@PathVariable Long idx, Model model) {
        UserDTO userDTO = userService.findById(idx);
        model.addAttribute("user", userDTO);
        return "/user/userPage";
    }
}
