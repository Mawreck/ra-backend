package com.example.rabackend.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface LogRepository extends JpaRepository<Log, Long> {
}
