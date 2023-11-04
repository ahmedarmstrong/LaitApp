package com.mabrouk.laitapp.service.impl;

import com.mabrouk.laitapp.dto.RegionDto;
import com.mabrouk.laitapp.exceptions.EntityNotFoundException;
import com.mabrouk.laitapp.exceptions.ErrorCodes;
import com.mabrouk.laitapp.exceptions.InvalidEntityException;
import com.mabrouk.laitapp.exceptions.InvalidOperationException;
import com.mabrouk.laitapp.model.Client;
import com.mabrouk.laitapp.repository.ClientRepository;
import com.mabrouk.laitapp.repository.RegionRepository;
import com.mabrouk.laitapp.service.RegionService;
import com.mabrouk.laitapp.validator.RegionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository ;

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public RegionDto save(RegionDto dto) {
        List<String> errors = RegionValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Region is not valid {}", dto);
            throw new InvalidEntityException("Le Region n'est pas valide", ErrorCodes.REGION_NOT_VALID, errors);
        }

        return RegionDto.fromEntity(
                regionRepository.save(
                        RegionDto.toEntity(dto)
                )
        );
    }

    @Override
    public RegionDto findById(Long id) {
        if (id == null) {
            log.error("Region ID is null");
            return null;
        }
        return regionRepository.findById(id)
                .map(RegionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune region avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.REGION_NOT_FOUND)
                );
    }

    @Override
    public RegionDto findByNom(String nom) {
        if (!StringUtils.hasLength(nom)) {
            log.error("Region nom is null");
            return null;
        }
        return regionRepository.findRegionByNom(nom)
                .map(RegionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune region avec le nom = " + nom + " n' ete trouve dans la BDD",
                        ErrorCodes.REGION_NOT_FOUND)
                );
    }



    @Override
    public List<RegionDto> findAll() {
        return regionRepository.findAll().stream()
                .map(RegionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Region ID is null");
            return;
        }
        List<Client> clients = clientRepository.findAllByRegionId(id);
        if (!clients.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer cette region qui est deja utilise",
                    ErrorCodes.REGION_ALREADY_IN_USE);
        }
        regionRepository.deleteById(id);
    }
}
