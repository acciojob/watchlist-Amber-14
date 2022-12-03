package com.example.WatchlistRestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody(required = true) Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody(required = true) Director director){
        movieService.addDirector(director);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PostMapping("/add-movie-director-pair")
    public ResponseEntity addMovieAndDirector(@RequestParam(required = true) String movie,@RequestParam(required = true)String director){
        movieService.addMovieAndDirector(movie,director);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        //movieService.getMovieByName(name);
        return new ResponseEntity(movieService.getMovieByName(name),HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Movie> getDirectorByName(@PathVariable String name){
        //movieService.getMovieByName(name);
        return new ResponseEntity(movieService.getDirectorByName(name),HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> findMoveFromDirector(@PathVariable String name){
        //movieService.getMovieByName(name);
        return new ResponseEntity(movieService.findMoviesFromDirector(name),HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> getAllMovie(){
        return new ResponseEntity<>(movieService.getAllMovie(),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-director-by-name/{name}")
    public ResponseEntity<String> deleteDirector(@PathVariable String name){
        movieService.deleteDirector(name);
        return new ResponseEntity("Deleted Succesfully", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirector(){
        movieService.deleteAllDirector();
        return new ResponseEntity("All director deleted",HttpStatus.ACCEPTED);
    }

}
