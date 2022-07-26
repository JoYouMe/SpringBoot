package com.spring.boardweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boardweb.entity.User;
												   //Entity, 키 값 type
public interface UserRepository extends JpaRepository<User, String> {

}
