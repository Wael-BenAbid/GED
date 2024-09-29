package com.example.ged.Service;

import com.example.ged.Dto.DOCFileDTO;
import java.util.List;

public interface DOCFileService {

    DOCFileDTO createDOCFile(DOCFileDTO docFileDTO);

    List<DOCFileDTO> getAllDOCFiles();

    DOCFileDTO getDOCFileById(Long id);

    DOCFileDTO updateDOCFile(Long id, DOCFileDTO docFileDTO);

    void deleteDOCFile(Long id);
}
