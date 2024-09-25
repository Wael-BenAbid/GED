package com.example.ged.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDirection;

    private String nomDirection;

    private String observation;

    @ManyToMany
    @JoinTable(
            name = "direction_theme_doc",
            joinColumns = @JoinColumn(name = "direction_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_doc_id"))
    private Set<ThemeDOC> themeDocs = new HashSet<>();
}
