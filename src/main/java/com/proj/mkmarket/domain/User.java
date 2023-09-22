package com.proj.mkmarket.domain;

import com.proj.mkmarket.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
//@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String userId;
    private String pwd;
    private String name;
    private String email;
    private String address;
    private String phone;
    private Short grade;
    private Long createDate;
    private Boolean role;

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setPwd(userDTO.getPwd());
        user.setName(userDTO.getName());
        return user;
    }

//    public static MemberEntity toUpdateMemberEntity(MemberDTO memberDTO) {
//        MemberEntity memberEntity = new MemberEntity();
//        memberEntity.setId(memberDTO.getId());
//        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
//        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
//        memberEntity.setMemberName(memberDTO.getMemberName());
//        return memberEntity;
//    }

}


