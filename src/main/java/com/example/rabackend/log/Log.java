package com.example.rabackend.log;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "log")
@Data
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "log_type")
    private String logType;

    @Column(name = "log_type_id")
    private String logTypeId;

    @Column(name = "action")
    private String action;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

}
