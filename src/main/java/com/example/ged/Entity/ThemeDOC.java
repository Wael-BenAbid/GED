package com.example.ged.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThemeDOC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idThemeDOC;

    private String nomTheme;

    private String description;

    @ManyToMany(mappedBy = "themeDocs")
    private Set<Direction> Directions = new HashSet<>();

    @OneToMany(mappedBy = "themeDOC", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DOCFile> docFiles = new ArrayList<>();

}
