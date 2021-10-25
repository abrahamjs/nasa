package com.nasa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="rating_id")
    private Long Id;

    @Column(name="url")
    private String url;

    @Column(name="description")
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    @Column(name="rating")
    private int rating;


    public Rating() {

    }

    public Rating(String url, String description, User user, int rating) {
        this.url = url;
        this.description = description;
        this.user = user;
        this.rating = rating;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return rating == rating1.rating && Objects.equals(Id, rating1.Id) && Objects.equals(url, rating1.url) && Objects.equals(description, rating1.description) && Objects.equals(user, rating1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, url, description, user, rating);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "Id=" + Id +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }
}
