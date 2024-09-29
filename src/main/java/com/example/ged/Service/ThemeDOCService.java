package com.example.ged.Service;

import com.example.ged.Entity.ThemeDOC;
import java.util.List;

public interface ThemeDOCService {

    ThemeDOC addThemeDOC(ThemeDOC themeDOC);

    List<ThemeDOC> getAllThemeDOCs();

    ThemeDOC getThemeDOCById(Long id);

    ThemeDOC updateThemeDOC(ThemeDOC themeDOC);

    void deleteThemeDOC(Long id);
}
