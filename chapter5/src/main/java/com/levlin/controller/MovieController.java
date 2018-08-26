package com.levlin.controller;

import com.levlin.repository.MovieRepository;
import com.levlin.vo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: levlin
 * @Date: 2018/8/26
 * @version: 1.0
 * @Description:
 */
@RestController
@RequestMapping(value = "/mongodb")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    /*mongodb 查询所有json*/
    @GetMapping(value = "/getMovieList")
    private List<Movie> getMovieList(){
        return movieRepository.findAll(Movie.class);
    }
}
