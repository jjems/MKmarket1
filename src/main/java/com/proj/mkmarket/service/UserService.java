package com.proj.mkmarket.service;

import com.proj.mkmarket.domain.UserEntity;
import com.proj.mkmarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 회원가입 로직 구현
    public UserEntity signup(UserEntity user) {
        String encodedPassword = passwordEncoder.encode(user.getPwd());
        user.setPwd(encodedPassword);

        // 필요한 검증 및 비즈니스 로직을 수행하고, userRepository를 사용하여 데이터 저장
        return userRepository.save(user);
    }
}