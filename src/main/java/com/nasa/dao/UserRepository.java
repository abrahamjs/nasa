package com.nasa.dao;

import com.nasa.model.User;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
