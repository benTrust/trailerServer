package com.reactSpring.trailer.test;

import com.reactSpring.trailer.proxy.model.DiscoverMovies;
import com.reactSpring.trailer.rest.MovieRest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieRestTest {

    @Autowired
    MovieRest movieRest;

    @Test
    public void discoverMovie() {
        DiscoverMovies discoverMovies = movieRest.discoverMovie();
        Assert.notNull(discoverMovies, "None movie find");
        Assert.notEmpty(discoverMovies.getResults(), "None movie find");
    }

    @Test
    public void getMovie() {
    }

    @Test
    public void newComment() {
    }

    @Test
    public void recommendationMovies() {
    }

    @Test
    public void searchMovies() {
    }
}