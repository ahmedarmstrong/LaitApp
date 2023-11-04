package com.mabrouk.laitapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mabrouk.laitapp.model.Region;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RegionDto {

    private Long id ;

    private String nom;

    @JsonIgnore
    private List<ClientDto> clients ;

    public static RegionDto fromEntity(Region region) {
        if (region == null) {
            return null;
            // TODO throw an exception
        }

        return RegionDto.builder()
                .id(region.getId())
                .nom(region.getNom())
                .build();
    }

    public static Region toEntity(RegionDto regionDto) {
        if (regionDto == null) {
            return null;
            // TODO throw an exception
        }

        Region region = new Region();
        region.setId(regionDto.getId());
        region.setNom(regionDto.getNom());

        return region;
    }
}
