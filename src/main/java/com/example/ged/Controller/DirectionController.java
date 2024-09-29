package com.example.ged.Controller;

import com.example.ged.Entity.Direction;
import com.example.ged.Service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directions")
public class DirectionController {

    @Autowired
    private DirectionService directionService;
    @PostMapping
    public ResponseEntity<Direction> addDirection(@RequestBody Direction direction) {
        Direction createdDirection = directionService.addDirection(direction);
        return new ResponseEntity<>(createdDirection, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Direction>> getAllDirections() {
        List<Direction> directions = directionService.getAllDirections();
        return new ResponseEntity<>(directions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direction> getDirectionById(@PathVariable Long id) {
        Direction direction = directionService.getDirectionById(id);
        return new ResponseEntity<>(direction, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direction> updateDirection(@PathVariable Long id, @RequestBody Direction direction) {
        direction.setIdDirection(id); // Assurez-vous que l'ID est mis à jour
        Direction updatedDirection = directionService.updateDirection(direction);
        return new ResponseEntity<>(updatedDirection, HttpStatus.OK);
    }

    // Méthode pour supprimer une direction
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirection(@PathVariable Long id) {
        directionService.deleteDirection(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
