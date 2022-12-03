package com.example.WatchlistRestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MovieService {
    // where all the loic is supposed to be happen;

    @Autowired
    MovieRepository movieRepository;

    //add movie
    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    //add director
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    //add movie and director
    public void addMovieAndDirector(String movie,String director){
        movieRepository.addMovieAndDirector(movie,director);
    }
    //get movie by name;
    public Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    }
    //get Director by name
    public Director getDirectorByName(String name){
        return movieRepository.getDirectorByName(name);
    }
    //get movies name by director name;
    public List<String> findMoviesFromDirector(String name){
        return movieRepository.findMoviesFromDirector(name);
    }
    // get list of all movie added
    public List<String> getAllMovie(){
        return movieRepository.getAllMovie();
    }
    // delete a director and its movie from record
    public void deleteDirector(String name){
        movieRepository.deleteDirector(name);
    }
    // delete all directors and movie from records
    public void deleteAllDirector(){
        movieRepository.deleteAllDirector();
    }

}
