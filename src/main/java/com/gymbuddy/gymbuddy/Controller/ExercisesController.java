package com.gymbuddy.gymbuddy.Controller;

import com.gymbuddy.gymbuddy.Entity.Exercises;
import com.gymbuddy.gymbuddy.Repository.ExericsesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@CrossOrigin("*")
public class ExercisesController {
  private final ExericsesRepository exericsesRepository;
  Logger logger = Logger.getLogger(getClass().getName());

  @Autowired
  public ExercisesController(ExericsesRepository exericsesRepository) {
    this.exericsesRepository = exericsesRepository;
  }

  @PostMapping("exercises")
  public Exercises createExercise(@RequestBody Exercises exercise) {
    return exericsesRepository.save(exercise);
  }

  @GetMapping("exercises/{exerciseId}")
  public ResponseEntity<Exercises> getExercises(@PathVariable String exerciseId) {
    Optional<Exercises> exercise = exericsesRepository.findById(Long.parseLong(exerciseId));
    return exercise.map(exercises -> ResponseEntity.ok().body(exercises)).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PutMapping("exercises/{exerciseId}")
  public ResponseEntity<Exercises> updateExercise(@PathVariable String exerciseId, @RequestBody Exercises exercise) {
    try {
      logger.log(Level.INFO, "Starting update exercise by id with exercise id: {}", exerciseId);
      Optional<Exercises> exerciseToUpdate = exericsesRepository.findById(Long.parseLong(exerciseId));
      if (exerciseToUpdate.isEmpty()) {
        return ResponseEntity.notFound().build();
      }
      exerciseToUpdate.get().setName(exercise.getName());
      exerciseToUpdate.get().setDescription(exercise.getDescription());
      exerciseToUpdate.get().setVideUrl(exercise.getVideUrl());
      Exercises savedExercise = exericsesRepository.save(exerciseToUpdate.get());
      return ResponseEntity.ok().body(savedExercise);
    } catch (Exception e) {
      logger.severe(e.getMessage());
      return ResponseEntity.internalServerError().build();
    }

  }
}
