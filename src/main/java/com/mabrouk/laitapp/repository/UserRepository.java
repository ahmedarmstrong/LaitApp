package com.mabrouk.laitapp.repository;


import com.mabrouk.laitapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findByUsername (String username);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.enabled = false")
    List<User> findByEnabledIsFalse (String enabled);
    Boolean existsByUsername(String username);

    Boolean existsByEmail (String email);

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);

}