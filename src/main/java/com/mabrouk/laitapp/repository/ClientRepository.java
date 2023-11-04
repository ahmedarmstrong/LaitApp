package com.mabrouk.laitapp.repository;

import com.mabrouk.laitapp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository <Client, Long> {

    List<Client> findAllByRegionId(Long region_id);
}
