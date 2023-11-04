package com.mabrouk.laitapp.controller.api;

import com.mabrouk.laitapp.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mabrouk.laitapp.utils.Constants.APP_ROOT;

public interface ClientApi {

    @PostMapping(value = APP_ROOT + "/client/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save (@RequestBody ClientDto dto);

    @GetMapping(value = APP_ROOT + "/client/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("idClient") Long id);

    @GetMapping(value = APP_ROOT + "/client/filter/{idRegion}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findClientByIdRegion (@PathVariable("idRegion") Long idRegion);

    @GetMapping(value = APP_ROOT + "/client/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/client/delete/{idClient}")
    void delete(@PathVariable("idClient") Long id);
}
