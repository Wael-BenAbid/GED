package com.example.ged.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DOCFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDOCFile;

    private String nomFichier;
    private String pathFichier;
    private Date datecreation;

    @ManyToOne
    @JoinColumn(name = "theme_doc_id")
    private ThemeDOC themeDOC;
}
