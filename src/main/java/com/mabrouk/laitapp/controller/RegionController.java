package com.mabrouk.laitapp.controller;

import com.mabrouk.laitapp.controller.api.RegionApi;
import com.mabrouk.laitapp.dto.RegionDto;
import com.mabrouk.laitapp.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionController implements RegionApi {

    @Autowired
    private RegionService regionService;


    @Override
    public RegionDto save(RegionDto dto) {
        return regionService.save(dto);
    }

    @Override
    public RegionDto findById(Long idRegion) {
        return regionService.findById(idRegion);
    }

    @Override
    public RegionDto findByNom(String nomRegion) {
        return regionService.findByNom(nomRegion);
    }

    @Override
    public List<RegionDto> findAll() {
        return regionService.findAll();
    }

    @Override
    public void delete(Long id) {
        regionService.delete(id);
    }
}
