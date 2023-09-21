package com.proj.mkmarket.domain;

import lombok.Data;

import javax.persistence.*;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Table(name = "mkmarket") // 매핑할 테이블의 이름을 지정
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String user_id;
    private String pwd;
    private String name;
    private String email;
    private String address;
    private String phone;
    private Short grade;
    private Long createDate;
    private Boolean role;
}
