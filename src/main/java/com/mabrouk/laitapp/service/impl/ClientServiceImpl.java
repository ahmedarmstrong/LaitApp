package com.mabrouk.laitapp.service.impl;

import com.mabrouk.laitapp.dto.ClientDto;
import com.mabrouk.laitapp.exceptions.EntityNotFoundException;
import com.mabrouk.laitapp.exceptions.ErrorCodes;
import com.mabrouk.laitapp.exceptions.InvalidEntityException;
import com.mabrouk.laitapp.repository.ClientRepository;
import com.mabrouk.laitapp.service.ClientService;
import com.mabrouk.laitapp.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("Le Client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }

        return ClientDto.fromEntity(
                clientRepository.save(
                        ClientDto.toEntity(dto)
                )
        );
    }

    @Override
    public ClientDto findById(Long id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }

        return clientRepository.findById(id).map(ClientDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun client avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<ClientDto> findClientByIdRegion(Long id) {
        if (id == null) {
            log.error("Region nom is null");
            return null;
        }
        return clientRepository.findAllByRegionId(id)
                .stream().map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        if (id == null){
            log.error("Client ID is null");
            return;
        }

        clientRepository.deleteById(id);
    }
}
