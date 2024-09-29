package com.example.ged.Service;

import com.example.ged.Entity.Direction;
import java.util.List;

public interface DirectionService {
    Direction addDirection(Direction direction);
    List<Direction> getAllDirections();
    Direction getDirectionById(Long id);
    Direction updateDirection(Direction direction);
    void deleteDirection(Long id);
}
