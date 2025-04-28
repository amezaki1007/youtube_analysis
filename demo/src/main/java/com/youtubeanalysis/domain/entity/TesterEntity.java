package com.youtubeanalysis.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "test_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TesterEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(unique = true, length = 100)
    private String email;
    
    private Integer age;
    
    @Column(name = "created_at", updatable = false, 
            columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;
}