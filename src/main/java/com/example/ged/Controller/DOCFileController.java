package com.example.ged.Controller;

import com.example.ged.Dto.DOCFileDTO;
import com.example.ged.Service.DOCFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docfiles")
public class DOCFileController {

    @Autowired
    private DOCFileService docFileService;

    // Ajouter un nouveau DOCFile
    @PostMapping
    public ResponseEntity<DOCFileDTO> addDOCFile(@RequestBody DOCFileDTO docFileDTO) {
        DOCFileDTO createdDOCFile = docFileService.createDOCFile(docFileDTO);
        return new ResponseEntity<>(createdDOCFile, HttpStatus.CREATED);
    }

    // Récupérer tous les DOCFiles
    @GetMapping
    public ResponseEntity<List<DOCFileDTO>> getAllDOCFiles() {
        List<DOCFileDTO> docFiles = docFileService.getAllDOCFiles();
        return new ResponseEntity<>(docFiles, HttpStatus.OK);
    }

    // Récupérer un DOCFile par ID
    @GetMapping("/{id}")
    public ResponseEntity<DOCFileDTO> getDOCFileById(@PathVariable Long id) {
        DOCFileDTO docFile = docFileService.getDOCFileById(id);
        return new ResponseEntity<>(docFile, HttpStatus.OK);
    }

    // Mettre à jour un DOCFile
    @PutMapping("/{id}")
    public ResponseEntity<DOCFileDTO> updateDOCFile(@PathVariable Long id, @RequestBody DOCFileDTO docFileDTO) {
        DOCFileDTO updatedDOCFile = docFileService.updateDOCFile(id, docFileDTO);
        return new ResponseEntity<>(updatedDOCFile, HttpStatus.OK);
    }

    // Supprimer un DOCFile par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDOCFile(@PathVariable Long id) {
        docFileService.deleteDOCFile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
