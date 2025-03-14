package com.crud.restapi.controller;

import com.crud.restapi.model.Movie;
import com.crud.restapi.repository.MovieRepository;
import com.crud.restapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieRepository movieRepository;
    @Autowired
    public MovieController(MovieService movieService, MovieRepository movieRepository) {
        this.movieService = movieService;
        this.movieRepository = movieRepository;
    }

    @GetMapping("/film")
    public String getAll(Model model,String keyword) {
        //List<Movie> movies = movieService.getAll();

        if(keyword != null){
            model.addAttribute("listMovies",movieService.findByKeyword(keyword));

        }else {
            model.addAttribute("listMovies", movieService.getAllMovies());
        }
        model.addAttribute("pageTitle", "Movies");
        return "index";
    }





    @GetMapping("/home")
    public String viewHomePage(Model model){
        model.addAttribute("listMovies", movieService.getAllMovies());
        return "index";
    }

    @GetMapping("/showNewMovieForm")
    public String showNewMovieForm(Model model){
//        Movie movie = new Movie();
//        model.addAttribute("movie",movie);
        return "new_movie";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(Movie movie, Model model){
        model.addAttribute("movie", new Movie());
        movieService.saveMovie(movie);
        return "redirect:/movies/home";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
       // Optional<Movie> movie = Optional.ofNullable(movieService.getMovieById(id));
        Optional<Movie> movie = movieRepository.findById(id);

        model.addAttribute("movie", movie);
        return "update_movie";
    }
    @PostMapping("/updateMovie")
    public String updateMovie(Movie movie, Model model){
        movieService.saveMovie(movie);
        return "redirect:/movies/home";
    }

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable(value = "id") long id){
        this.movieService.deleteMovie(id);
        return "redirect:/movies/home";
    }

    @GetMapping("/view/{id}")
    public String viewMovie(@PathVariable(value = "id") long id, Model model)  {

        Optional<Movie> movie = movieRepository.findById(id);

        model.addAttribute("movie", movie);
        return "view_movie";
    }





//    @GetMapping("/page/{pageNo}")
//    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
//                                @RequestParam("sortField") String sortField,
//                                @RequestParam("sortDir") String sortDir,
//                                Model model) {
//        int pageSize = 5;
//
//        Page<Movie> page = movieService.findPaginated(pageNo, pageSize, sortField, sortDir);
//        List<Movie> listMovies = page.getContent();
//
//        model.addAttribute("currentPage", pageNo);
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//
//        model.addAttribute("sortField", sortField);
//        model.addAttribute("sortDir", sortDir);
//        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
//
//        model.addAttribute("listMovies", listMovies);
//        return "index";
//    }








//
//    @GetMapping
//    public List<Movie> getAllMovies() {
//        return movieService.getAllMovies();
//    }
//
//
//    @GetMapping("/{id}")
//    public Optional<Movie> getMovieById(@PathVariable("id") Long id) {
//        return movieService.getMovieById(id);
//    }
//
//    @PostMapping
//    public Movie createMovie(@RequestBody Movie movie) {
//        return movieService.createMovie(movie);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long id, @RequestBody Movie movieDetails) {
//        Movie updatedMovie = movieService.updateMovie(id, movieDetails);
//        if (updatedMovie != null) {
//            return ResponseEntity.ok(updatedMovie);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//
//    @DeleteMapping("/{id}")
//    public void deleteMovie(@PathVariable("id") Long id) {
//        movieService.deleteMovie(id);
//    }
}

