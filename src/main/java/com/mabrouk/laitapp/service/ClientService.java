package com.mabrouk.laitapp.service;

import com.mabrouk.laitapp.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto save (ClientDto dto);

    ClientDto findById (Long id);

    List<ClientDto>  findClientByIdRegion (Long id);

    List<ClientDto> findAll();



    void delete(Long id) ;
}
