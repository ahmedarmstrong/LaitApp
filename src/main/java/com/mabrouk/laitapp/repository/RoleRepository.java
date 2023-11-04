package com.mabrouk.laitapp.repository;

import com.mabrouk.laitapp.model.Roles;
import com.mabrouk.laitapp.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {

    Optional<Roles> findByName(RoleType name);
}