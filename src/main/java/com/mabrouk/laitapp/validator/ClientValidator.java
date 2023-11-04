package com.mabrouk.laitapp.validator;

import com.mabrouk.laitapp.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {


    public static List<String> validate (ClientDto clientDto) {
        List<String> errors = new ArrayList<>();

        if (clientDto == null){
            errors.add("Veuillez donner un prenom");
            errors.add("Veuillez donner un nom");
            errors.add("Veuillez donner un num tel");
            errors.add("Veuillez donner un email");
            errors.add("Veuillez selectionner une region");
            return errors;
        }

        if (!StringUtils.hasLength(clientDto.getFirstname())) {
            errors.add("Veuillez donner un prenom");
        }
        if (!StringUtils.hasLength(clientDto.getLastname())) {
            errors.add("Veuillez donner un nom");
        }
        if (!StringUtils.hasLength(clientDto.getTel())) {
            errors.add("Veuillez donner un num tel");
        }
        if (!StringUtils.hasLength(clientDto.getEmail())) {
            errors.add("Veuillez donner un email");
        }
        if (clientDto.getRegion() == null || clientDto.getRegion().getId() == null) {
            errors.add("Veuillez selectionner une region");
        }
        return errors;
    }
}
