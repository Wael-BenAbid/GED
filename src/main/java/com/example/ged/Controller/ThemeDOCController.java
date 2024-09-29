package com.example.ged.Controller;

import com.example.ged.Entity.ThemeDOC;
import com.example.ged.Service.IMPL.ThemeDOCServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/themedocs")
public class ThemeDOCController {

    @Autowired
    private ThemeDOCServiceImpl themeDOCService;

    @PostMapping
    public ResponseEntity<ThemeDOC> addThemeDOC(@RequestBody ThemeDOC themeDOC) {
        ThemeDOC createdThemeDOC = themeDOCService.addThemeDOC(themeDOC);
        return new ResponseEntity<>(createdThemeDOC, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ThemeDOC>> getAllThemeDOCs() {
        List<ThemeDOC> themeDOCs = themeDOCService.getAllThemeDOCs();
        return new ResponseEntity<>(themeDOCs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThemeDOC> getThemeDOCById(@PathVariable Long id) {
        ThemeDOC themeDOC = themeDOCService.getThemeDOCById(id);
        return new ResponseEntity<>(themeDOC, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ThemeDOC> updateThemeDOC(@PathVariable Long id, @RequestBody ThemeDOC themeDOC) {
        themeDOC.setIdThemeDOC(id);
        ThemeDOC updatedThemeDOC = themeDOCService.updateThemeDOC(themeDOC);
        return new ResponseEntity<>(updatedThemeDOC, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThemeDOC(@PathVariable Long id) {
        themeDOCService.deleteThemeDOC(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
