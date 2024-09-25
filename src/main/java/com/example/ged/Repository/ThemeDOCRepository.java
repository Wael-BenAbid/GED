package com.example.ged.Repository;

import com.example.ged.Entity.ThemeDOC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeDOCRepository extends JpaRepository<ThemeDOC, Long> {
}
