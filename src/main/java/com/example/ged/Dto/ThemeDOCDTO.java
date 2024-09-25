package com.example.ged.Dto;

import com.example.ged.Entity.ThemeDOC;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThemeDOCDTO {

    private Long idThemeDOC;
    private String nomTheme;
    private String description;

    // Méthode toEntity
    public ThemeDOC toEntity() {
        return ThemeDOC.builder()
                .idThemeDOC(this.idThemeDOC)
                .nomTheme(this.nomTheme)
                .description(this.description)
                .build();
    }

    // Méthode fromEntity
    public static ThemeDOCDTO fromEntity(ThemeDOC themeDOC) {
        return ThemeDOCDTO.builder()
                .idThemeDOC(themeDOC.getIdThemeDOC())
                .nomTheme(themeDOC.getNomTheme())
                .description(themeDOC.getDescription())
                .build();
    }
}
