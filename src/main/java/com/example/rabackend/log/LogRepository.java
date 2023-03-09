package com.example.rabackend.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("https://ra-frontend.herokuapp.com")
public interface LogRepository extends JpaRepository<Log, Long> {
}
