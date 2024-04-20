package com.gymbuddy.gymbuddy.Controller;

import com.gymbuddy.gymbuddy.Entity.User;
import com.gymbuddy.gymbuddy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UserController {
  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping("user")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    try {
      User userCreated = userRepository.save(user);
      return ResponseEntity.ok().body(userCreated);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(null);
    }
  }
}
