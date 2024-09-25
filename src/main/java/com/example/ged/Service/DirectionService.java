package com.example.ged.Service;

import com.example.ged.Entity.Direction;
import com.example.ged.Repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionService {

    @Autowired
    private DirectionRepository directionRepository;
    public Direction addDirection(Direction direction) {
        return directionRepository.save(direction);
    }

    public List<Direction> getAllDirections() {
        return directionRepository.findAll();
    }

    public Direction getDirectionById(Long id) {
        return directionRepository.findById(id).orElseThrow(() -> new RuntimeException("Direction not found"));
    }

    public Direction updateDirection(Direction direction) {
        if (!directionRepository.existsById(direction.getIdDirection())) {
            throw new RuntimeException("Direction not found");
        }
        return directionRepository.save(direction);
    }
    public void deleteDirection(Long id) {
        directionRepository.deleteById(id);
    }

}
