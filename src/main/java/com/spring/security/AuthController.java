package com.spring.security;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JWTResponseDto>  login(@RequestBody LoginRequestDTO loginRequest){
        JWTResponseDto jwtResponseDto = authService.login(loginRequest.getLogin() , loginRequest.getPassword());
        return ResponseEntity.ok(jwtResponseDto);
    }
}
