package com.gymbuddy.gymbuddy.Controller;

import com.gymbuddy.gymbuddy.Entity.Exercises;
import com.gymbuddy.gymbuddy.Repository.ExericsesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ExercisesController {
    @Autowired
    ExericsesRepository exericsesRepository;

    @PostMapping("exercise")
    public Exercises createExercise(@RequestBody Exercises exercise) {
        return exericsesRepository.save(exercise);
    }
}
