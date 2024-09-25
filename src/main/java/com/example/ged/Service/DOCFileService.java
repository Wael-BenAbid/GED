package com.example.ged.Service;

import com.example.ged.Entity.DOCFile;
import com.example.ged.Repository.DOCFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DOCFileService {

    @Autowired
    private DOCFileRepository docFileRepository;

    public DOCFile addDOCFile(DOCFile docFile) {
        return docFileRepository.save(docFile);
    }

    public List<DOCFile> getAllDOCFiles() {
        return docFileRepository.findAll();
    }
    public DOCFile getDOCFileById(Long id) {
        return docFileRepository.findById(id).orElseThrow(() -> new RuntimeException("DOCFile not found"));
    }
    public DOCFile updateDOCFile(DOCFile docFile) {
        if (!docFileRepository.existsById(docFile.getIdDOCFile())) {
            throw new RuntimeException("DOCFile not found");
        }
        return docFileRepository.save(docFile);
    }

    public void deleteDOCFile(Long id) {
        docFileRepository.deleteById(id);
    }
}
