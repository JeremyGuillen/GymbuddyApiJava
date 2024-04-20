package com.gymbuddy.gymbuddy.Controller;

import com.gymbuddy.gymbuddy.Entity.Exercises;
import com.gymbuddy.gymbuddy.Repository.ExericsesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ExercisesController {
  private final ExericsesRepository exericsesRepository;

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
    System.out.println(exerciseId);
    Optional<Exercises> exercise = exericsesRepository.findById(Long.parseLong(exerciseId));
    return exercise.map(exercises -> ResponseEntity.ok().body(exercises)).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
