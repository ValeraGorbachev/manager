package com.example.manager.entity;

import lombok.Data;
import lombok.Generated;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Data
@Entity
@Table(name = "page")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String pageName;
private String published_at;
private Integer priority;
private boolean published;
}
