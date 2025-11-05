package com.studymate.backend.user.controller;

import com.studymate.backend.user.dto.LoginRequest;
import com.studymate.backend.user.dto.LoginResponse;
import com.studymate.backend.user.dto.SignupRequest;
import com.studymate.backend.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) {
        userService.signup(request);
        return "회원가입이 완료되었습니다!";
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}