package com.example.ged.Service.IMPL;

import com.example.ged.Dto.DOCFileDTO;
import com.example.ged.Entity.DOCFile;
import com.example.ged.Repository.DOCFileRepository;
import com.example.ged.Service.DOCFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DOCFileServiceImpl implements DOCFileService {

    @Autowired
    private DOCFileRepository docFileRepository;

    @Override
    public DOCFileDTO createDOCFile(DOCFileDTO docFileDTO) {
        DOCFile docFile = docFileDTO.toEntity();
        DOCFile savedDocFile = docFileRepository.save(docFile);
        return DOCFileDTO.fromEntity(savedDocFile);
    }

    @Override
    public List<DOCFileDTO> getAllDOCFiles() {
        return docFileRepository.findAll().stream()
                .map(DOCFileDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public DOCFileDTO getDOCFileById(Long id) {
        DOCFile docFile = docFileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DOCFile not found"));
        return DOCFileDTO.fromEntity(docFile);
    }

    @Override
    public DOCFileDTO updateDOCFile(Long id, DOCFileDTO docFileDTO) {
        DOCFile existingDocFile = docFileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DOCFile not found"));

        existingDocFile.setNomFichier(docFileDTO.getNomFichier());
        existingDocFile.setPathFichier(docFileDTO.getPathFichier());
        existingDocFile.setDatecreation(docFileDTO.getDatecreation());

        DOCFile updatedDocFile = docFileRepository.save(existingDocFile);
        return DOCFileDTO.fromEntity(updatedDocFile);
    }

    @Override
    public void deleteDOCFile(Long id) {
        DOCFile docFile = docFileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DOCFile not found"));
        docFileRepository.delete(docFile);
    }
}
