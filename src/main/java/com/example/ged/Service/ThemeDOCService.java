package com.example.ged.Service;

import com.example.ged.Entity.ThemeDOC;
import com.example.ged.Repository.ThemeDOCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThemeDOCService {

    @Autowired
    private ThemeDOCRepository themeDOCRepository;

    public ThemeDOC addThemeDOC(ThemeDOC themeDOC) {
        return themeDOCRepository.save(themeDOC);
    }
    public List<ThemeDOC> getAllThemeDOCs() {
        return themeDOCRepository.findAll();
    }
    public ThemeDOC getThemeDOCById(Long id) {
        return themeDOCRepository.findById(id).orElseThrow(() -> new RuntimeException("ThemeDOC not found"));
    }
    public ThemeDOC updateThemeDOC(ThemeDOC themeDOC) {
        if (!themeDOCRepository.existsById(themeDOC.getIdThemeDOC())) {
            throw new RuntimeException("ThemeDOC not found");
        }
        return themeDOCRepository.save(themeDOC);
    }
    public void deleteThemeDOC(Long id) {
        themeDOCRepository.deleteById(id);
    }

}
