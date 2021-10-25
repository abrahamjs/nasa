package com.nasa.dao;
import com.nasa.model.Rating;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
}
