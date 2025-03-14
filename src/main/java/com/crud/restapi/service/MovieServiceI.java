package com.crud.restapi.service;

import com.crud.restapi.model.Movie;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;
import java.util.List;

public interface MovieServiceI {
    List<Movie> getAllMovies();
    void saveMovie(Movie movie);
    Movie getMovieById(long id);
    void deleteMovieById(long id);
    Page<Movie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    @Transactional
    List<Movie> findByKeyword(String keyword);
}
