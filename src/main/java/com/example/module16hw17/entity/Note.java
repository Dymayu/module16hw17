package com.example.module16hw17.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Entity
@Data
@Table(name="note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;


}
