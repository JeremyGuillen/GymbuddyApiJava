package com.gymbuddy.gymbuddy.Repository;

import com.gymbuddy.gymbuddy.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}
