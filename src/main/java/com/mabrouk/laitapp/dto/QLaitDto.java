package com.mabrouk.laitapp.dto;


import com.mabrouk.laitapp.model.QLait;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Builder
@Data
public class QLaitDto {

    private Long id ;

    private Date date ;

    private double quantitejour ;

    private double quantitesoir ;

    private ClientDto client ;


    public static QLaitDto fromEntity (QLait qLait) {
        if (qLait == null){
            return null;
        }
        return QLaitDto.builder()
                .id(qLait.getId())
                .date(qLait.getDate())
                .quantitejour(qLait.getQuantitejour())
                .quantitesoir(qLait.getQuantitesoir())
                .client(ClientDto.fromEntity(qLait.getClient()))
                .build();
    }

    public static QLait toEntity(QLaitDto qLaitDto) {
        if (qLaitDto == null) {
            return null;
        }
        QLait qlait = new QLait();
        qlait.setId(qLaitDto.getId());
        qlait.setDate(qLaitDto.getDate());
        qlait.setQuantitejour(qLaitDto.getQuantitejour());
        qlait.setQuantitesoir(qLaitDto.getQuantitesoir());
        qlait.setClient(ClientDto.toEntity(qLaitDto.getClient()));
        return qlait;
    }
}
