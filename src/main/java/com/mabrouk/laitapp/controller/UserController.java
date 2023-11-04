package com.mabrouk.laitapp.controller;

import com.mabrouk.laitapp.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v2/users")
@RequiredArgsConstructor
public class UserController {

    private final RegisterService service;


    @GetMapping("/hh")
   public ResponseEntity<String> hello( Long userId) {
        String userEmail = service.getEmailFromToken(userId);

        if (userEmail != null) {
            return ResponseEntity.ok(userEmail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}