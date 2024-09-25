package com.example.ged.Dto;

import com.example.ged.Entity.DOCFile;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DOCFileDTO {
    private Long idDOCFile;

    private String nomFichier;
    private String pathFichier;
    private Date datecreation;

    public DOCFile toEntity() {
        return DOCFile.builder()
                .idDOCFile(this.idDOCFile)
                .nomFichier(this.nomFichier)
                .pathFichier(this.pathFichier)
                .datecreation(this.datecreation)
                .build();
    }

    public static DOCFileDTO fromEntity(DOCFile docFile) {
        return DOCFileDTO.builder()
                .idDOCFile(docFile.getIdDOCFile())
                .nomFichier(docFile.getNomFichier())
                .pathFichier(docFile.getPathFichier())
                .datecreation(docFile.getDatecreation())
                .build();
    }

}