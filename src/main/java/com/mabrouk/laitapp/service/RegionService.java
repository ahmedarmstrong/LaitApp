package com.mabrouk.laitapp.service;

import com.mabrouk.laitapp.dto.RegionDto;

import java.util.List;

public interface RegionService {

    RegionDto save(RegionDto dto);

    RegionDto findById(Long id);

    RegionDto findByNom(String nom);



    List<RegionDto> findAll();

    void delete(Long id);
}
