package com.example.ged.Dto;

import com.example.ged.Entity.Direction;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DirectionDTO {

    private Long idDirection;
    private String nomDirection;
    private String observation;

    public Direction toEntity() {
        return Direction.builder()
                .idDirection(this.idDirection)
                .nomDirection(this.nomDirection)
                .observation(this.observation)
                .build();
    }

    public static DirectionDTO fromEntity(Direction direction) {
        return DirectionDTO.builder()
                .idDirection(direction.getIdDirection())
                .nomDirection(direction.getNomDirection())
                .observation(direction.getObservation())
                .build();
    }
}