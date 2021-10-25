package com.zweet.social.controller;

import com.zweet.social.dao.RatingRepository;
import com.zweet.social.exception.NotFoundException;
import com.zweet.social.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingRepository ratingRepository;

    @PostMapping//Another way to set the Rest API Post mapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rating createRating(@RequestBody Rating rating) {
        return ratingRepository.save(rating);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Rating getRatingById(@PathVariable Long id) {
        Rating  rating = ratingRepository.findById(id).orElse(null);
        if(rating == null)
            throw new NotFoundException("Not invoice item could be retrieved customer wiht id " + id);

        return rating;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Rating> getAllRatings() {
        List<Rating> userList = new ArrayList<>();
        ratingRepository.findAll().forEach(rating ->{userList.add(rating);});
        if(userList.isEmpty())
            throw new NotFoundException("Not users could be retrieved. ");

        return userList;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRating(@PathVariable Long id, @RequestBody Rating rating) {
        if(rating.getId() == 0)
            rating.setId(id);
        if(rating.getId() != id)
            throw new IllegalArgumentException("User ID on path must match the ID in the User object");

        ratingRepository.save(rating);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRating(@PathVariable Long id) {
        Rating  rating = ratingRepository.findById(id).orElse(null);
        if(rating == null)
            throw new IllegalArgumentException("User ID not valid");
        ratingRepository.delete(rating);
    }

}
