package com.example.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.jpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String username);

}
