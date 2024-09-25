package com.example.ged.Repository;

import com.example.ged.Entity.DOCFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DOCFileRepository extends JpaRepository<DOCFile, Long> {
}
