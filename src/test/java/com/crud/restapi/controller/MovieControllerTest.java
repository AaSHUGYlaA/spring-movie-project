package com.crud.restapi.controller;

import com.crud.restapi.model.Movie;
import com.crud.restapi.repository.MovieRepository;
import com.crud.restapi.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MovieControllerTest {

    @Mock
    private MovieService movieService;

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieController movieController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() {
        Model model = mock(Model.class);
        String keyword = "action";

        when(movieService.findByKeyword(keyword)).thenReturn(new ArrayList<>());

        String result = movieController.getAll(model, keyword);

        assertEquals("index", result);
        verify(model).addAttribute("listMovies", new ArrayList<>());
        verify(model).addAttribute("pageTitle", "Movies");
    }

    @Test
    void testViewHomePage() {
        Model model = mock(Model.class);

        when(movieService.getAllMovies()).thenReturn(new ArrayList<>());

        String result = movieController.viewHomePage(model);

        assertEquals("index", result);
        verify(model).addAttribute("listMovies", new ArrayList<>());

    }


    @Test
    void testSaveMovie() {
        Movie movie = new Movie();

        String result = movieController.saveMovie(movie, mock(Model.class));

        assertEquals("redirect:/movies/home", result);
        verify(movieService).saveMovie(movie);
    }

    @Test
    void testShowFormForUpdate() {
        long id = 1L;
        Model model = mock(Model.class);
        Optional<Movie> movie = Optional.of(new Movie());

        when(movieRepository.findById(id)).thenReturn(movie);

        String result = movieController.showFormForUpdate(id, model);

        assertEquals("update_movie", result);
        verify(model).addAttribute("movie", movie);
    }


    @Test
    void testDeleteMovie() {
        long id = 1L;

        String result = movieController.deleteMovie(id);

        assertEquals("redirect:/movies/home", result);
        verify(movieService).deleteMovie(id);
    }

    @Test
    void testViewMovie() {
        long id = 1L;
        Model model = mock(Model.class);
        Optional<Movie> movie = Optional.of(new Movie());

        when(movieRepository.findById(id)).thenReturn(movie);

        String result = movieController.viewMovie(id, model);

        assertEquals("view_movie", result);
        verify(model).addAttribute("movie", movie);
    }

}


