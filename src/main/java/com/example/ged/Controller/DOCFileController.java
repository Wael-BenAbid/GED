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

    @PostMapping
    public ResponseEntity<DOCFileDTO> addDOCFile(@RequestBody DOCFileDTO docFileDTO) {
        DOCFileDTO createdDOCFile = docFileService.createDOCFile(docFileDTO);
        return new ResponseEntity<>(createdDOCFile, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<DOCFileDTO>> getAllDOCFiles() {
        List<DOCFileDTO> docFiles = docFileService.getAllDOCFiles();
        return new ResponseEntity<>(docFiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DOCFileDTO> getDOCFileById(@PathVariable Long id) {
        DOCFileDTO docFile = docFileService.getDOCFileById(id);
        return new ResponseEntity<>(docFile, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DOCFileDTO> updateDOCFile(@RequestBody DOCFileDTO docFileDTO) {
        DOCFileDTO updatedDOCFile = docFileService.updateDOCFile(docFileDTO);
        return new ResponseEntity<>(updatedDOCFile, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDOCFile(@PathVariable Long id) {
        docFileService.deleteDOCFile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
