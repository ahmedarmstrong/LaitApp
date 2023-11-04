package com.mabrouk.laitapp.dto;

import com.mabrouk.laitapp.model.Client;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDto {

    private Long id ;

    private String firstname ;

    private String lastname;

    private String tel ;

    private String email ;

    private RegionDto region ;

    public static ClientDto fromEntity (Client client) {
        if (client == null){
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .firstname(client.getFirstname())
                .lastname(client.getLastname())
                .tel(client.getTel())
                .email(client.getEmail())
                .region(RegionDto.fromEntity(client.getRegion()))
                .build();
    }

    public static Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setFirstname(clientDto.getFirstname());
        client.setLastname(clientDto.getLastname());
        client.setTel(clientDto.getTel());
        client.setEmail(clientDto.getEmail());
        client.setRegion(RegionDto.toEntity(clientDto.getRegion()));
        return client;
    }
}
