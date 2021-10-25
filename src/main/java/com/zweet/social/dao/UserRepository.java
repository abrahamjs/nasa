package com.zweet.social.dao;
import com.zweet.social.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
