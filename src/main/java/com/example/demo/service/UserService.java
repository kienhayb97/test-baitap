package com.example.demo.service;


import com.example.demo.model.signinSignup.User;

import java.util.Optional;

public interface UserService {
  Optional<User> findById(Long id);
  Optional<User> findByEmail(String email);
  Optional<User> findByUsername(String username);
}
