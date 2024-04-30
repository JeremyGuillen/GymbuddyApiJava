package com.gymbuddy.gymbuddy.Controller;

import com.gymbuddy.gymbuddy.Entity.User;
import com.gymbuddy.gymbuddy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class UserController {
  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping("users")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    try {
      User userCreated = userRepository.save(user);
      return ResponseEntity.ok().body(userCreated);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(null);
    }
  }

  @GetMapping("users/{userId}")
  public ResponseEntity<User> getUserById(@PathVariable String userId) {
    try {
      Optional<User> user = userRepository.findById(Long.parseLong(userId));
      if (user.isEmpty()) {
        return ResponseEntity.notFound().build();
      } else {
        return ResponseEntity.ok().body(user.get());
      }
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(null);
    }
  }

  @PutMapping("users/{userID}")
  public ResponseEntity<User> updateUser(@PathVariable String userID, @RequestBody User userBody) {
    try {
      Optional<User> user = userRepository.findById(Long.parseLong(userID));
      if (user.isEmpty()) {
        return ResponseEntity.notFound().build();
      }
      user.get().setName(userBody.getName());
      user.get().setEmail(userBody.getEmail());
      user.get().setLastName(userBody.getLastName());
      user.get().setPhoneNumber(userBody.getPhoneNumber());
      userRepository.save(user.get());
      return ResponseEntity.ok().body(user.get());
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }
}
