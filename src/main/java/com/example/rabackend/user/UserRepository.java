package com.example.rabackend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("https://ra-frontend.herokuapp.com")
public interface UserRepository extends JpaRepository<User, Long> {
}
