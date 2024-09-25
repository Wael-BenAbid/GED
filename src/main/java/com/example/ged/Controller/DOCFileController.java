package com.example.ged.Controller;

import com.example.ged.Entity.DOCFile;
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

    @PostMapping
    public ResponseEntity<DOCFile> addDOCFile(@RequestBody DOCFile docFile) {
        DOCFile createdDOCFile = docFileService.addDOCFile(docFile);
        return new ResponseEntity<>(createdDOCFile, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<DOCFile>> getAllDOCFiles() {
        List<DOCFile> docFiles = docFileService.getAllDOCFiles();
        return new ResponseEntity<>(docFiles, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DOCFile> getDOCFileById(@PathVariable Long id) {
        DOCFile docFile = docFileService.getDOCFileById(id);
        return new ResponseEntity<>(docFile, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DOCFile> updateDOCFile(@PathVariable Long id, @RequestBody DOCFile docFile) {
        docFile.setIdDOCFile(id); // Assurez-vous que l'ID est mis à jour
        DOCFile updatedDOCFile = docFileService.updateDOCFile(docFile);
        return new ResponseEntity<>(updatedDOCFile, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDOCFile(@PathVariable Long id) {
        docFileService.deleteDOCFile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
