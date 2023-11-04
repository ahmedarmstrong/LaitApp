package com.mabrouk.laitapp.validator;

import com.mabrouk.laitapp.dto.RegionDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RegionValidator {

    public static List<String> validate (RegionDto regionDto){
        List<String> errors = new ArrayList<>();

        if (regionDto == null || !StringUtils.hasLength(regionDto.getNom())){
            errors.add("Veuillez renseigner le nom de la region");
        }
        return errors;
    }
}
