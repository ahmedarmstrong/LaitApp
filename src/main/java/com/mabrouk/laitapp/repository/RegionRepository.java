package com.mabrouk.laitapp.repository;


import com.mabrouk.laitapp.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {

    Optional<Region> findRegionByNom(String nom);
}
