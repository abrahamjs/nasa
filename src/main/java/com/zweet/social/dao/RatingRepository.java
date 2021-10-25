package com.zweet.social.dao;
import com.zweet.social.model.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
}
