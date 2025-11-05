package com.studymate.backend.user.dto;

public class SignupRequest {
    private String email;
    private String password;
    private String nickname;
    private String interest;

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getNickname() { return nickname; }
    public String getInterest() { return interest; }
}