package com.example.ged.Service.IMPL;

import com.example.ged.Entity.Direction;
import com.example.ged.Repository.DirectionRepository; // Assurez-vous d'importer le bon repository
import com.example.ged.Service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionServiceImpl implements DirectionService {

    @Autowired
    private DirectionRepository directionRepository;

    @Override
    public Direction addDirection(Direction direction) {
        return directionRepository.save(direction);
    }

    @Override
    public List<Direction> getAllDirections() {
        return directionRepository.findAll();
    }

    @Override
    public Direction getDirectionById(Long id) {
        return directionRepository.findById(id).orElseThrow(() -> new RuntimeException("Direction not found"));
    }

    @Override
    public Direction updateDirection(Direction direction) {
        // Assurez-vous que l'ID est correct avant d'appeler la méthode
        if (!directionRepository.existsById(direction.getIdDirection())) {
            throw new RuntimeException("Direction not found");
        }
        return directionRepository.save(direction);
    }

    @Override
    public void deleteDirection(Long id) {
        directionRepository.deleteById(id);
    }
}
