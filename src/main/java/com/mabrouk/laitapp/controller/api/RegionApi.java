package com.mabrouk.laitapp.controller.api;

import com.mabrouk.laitapp.dto.RegionDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mabrouk.laitapp.utils.Constants.APP_ROOT;

public interface RegionApi {

    @PostMapping(value = APP_ROOT + "/region/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RegionDto save(@RequestBody RegionDto dto);

    @GetMapping(value = APP_ROOT + "/region/{idRegion}", produces = MediaType.APPLICATION_JSON_VALUE)
    RegionDto findById(@PathVariable("idRegion") Long idRegion);

    @GetMapping(value = APP_ROOT + "/region/filter/{nomRegion}", produces = MediaType.APPLICATION_JSON_VALUE)
    RegionDto findByNom(@PathVariable("nomRegion") String nomRegion);

    @GetMapping(value = APP_ROOT + "/region/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<RegionDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/region/delete/{idRegion}")
    void delete(@PathVariable("idRegion") Long id);
}
