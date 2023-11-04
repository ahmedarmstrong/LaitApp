package com.mabrouk.laitapp.controller;

import com.mabrouk.laitapp.controller.api.ClientApi;
import com.mabrouk.laitapp.dto.ClientDto;
import com.mabrouk.laitapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {


    @Autowired
    private ClientService clientService;


    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    public ClientDto findById(Long id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findClientByIdRegion(Long idRegion) {
        return clientService.findClientByIdRegion(idRegion);
    }


    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Long id) {
        clientService.delete(id);
    }
}
