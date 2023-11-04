package com.mabrouk.laitapp.controller;


import com.mabrouk.laitapp.dto.RegisterUserDto;
import com.mabrouk.laitapp.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v2/auth")
@AllArgsConstructor
public class RegistrController {



    private final RegisterService registrationService;

    @PostMapping("/signup/user")
    public String register(@RequestBody RegisterUserDto request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
