package com.proj.mkmarket.service;

import com.proj.mkmarket.domain.User;
import com.proj.mkmarket.dto.UserDTO;
import com.proj.mkmarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 회원가입 로직 구현
    public User signup(UserDTO userDTO) {
        User user = User.toUser(userDTO);
        // 필요한 검증 및 비즈니스 로직을 수행하고, userRepository를 사용하여 데이터 저장
        return userRepository.save(user);
    }

    public UserDTO login(UserDTO userDTO) {
        Optional<User> byUserId = userRepository.findByUserId(userDTO.getUserId());
        if (byUserId.isPresent()) {
            User user = byUserId.get();
            if (user.getPwd().equals(userDTO.getPwd())) {
                UserDTO dto = UserDTO.toUserDTO(user);
                return dto;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public UserDTO findById(Long idx) {
        Optional<User> optionalUser = userRepository.findById(idx);
        if (optionalUser.isPresent()) {
//            MemberEntity memberEntity = optionalMemberEntity.get();
//            MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
//            return memberDTO;
            return UserDTO.toUserDTO(optionalUser.get());
        } else {
            return null;
        }

    }
}