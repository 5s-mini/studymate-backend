package com.studymate.backend.user.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String nickname;
    private String interest;
    private LocalDateTime createdAt = LocalDateTime.now();

    protected User() {}

    public User(String email, String password, String nickname, String interest) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.interest = interest;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getNickname() { return nickname; }
    public String getInterest() { return interest; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getPassword() { return password; }
    public void setId(Long id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setInterest(String interest) { this.interest = interest; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setPassword(String password) { this.password = password; }
}