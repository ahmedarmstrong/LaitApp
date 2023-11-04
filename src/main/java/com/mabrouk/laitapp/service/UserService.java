package com.mabrouk.laitapp.service;


import com.mabrouk.laitapp.model.RoleType;
import com.mabrouk.laitapp.model.Roles;
import com.mabrouk.laitapp.model.Token;
import com.mabrouk.laitapp.model.User;
import com.mabrouk.laitapp.repository.RoleRepository;
import com.mabrouk.laitapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TokenService tokenService;


    public String signUpUser(User user) {

        boolean userExists = userRepository
                .findByEmail(user.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        // Create new user's account

        String encodedPassword =   passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        Roles userRoles = roleRepository.findByName(RoleType.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        user.getRoles().add(userRoles);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();

        Token confirmationToken = new Token(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        tokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }

}
