package com.proj.mkmarket.dto;

import com.proj.mkmarket.domain.User;
import lombok.Data;

@Data
public class UserDTO {
    private Long idx;
    private String userId;
    private String pwd;
    private String name;

    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setIdx(user.getIdx());
        userDTO.setUserId(user.getUserId());
        userDTO.setPwd(user.getPwd());
        userDTO.setName(user.getName());
        return userDTO;
    }
}
