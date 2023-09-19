package com.proj.mkmarket.repository;

import com.proj.mkmarket.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
