package com.crud.restapi.service;

import com.crud.restapi.model.Movie;
import com.crud.restapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements MovieServiceI{

    private final MovieRepository movieRepository;


    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }



    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movieDetails) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setDescription(movieDetails.getDescription());
            movie.setGenre(movieDetails.getGenre());
            movie.setLanguageOption(movieDetails.getLanguageOption());
            movie.setMedia(movieDetails.getMedia());
            movie.setName(movieDetails.getName());
            movie.setNameOfActors(movieDetails.getNameOfActors());
            movie.setReleaseYear(movieDetails.getReleaseYear());
            return movieRepository.save(movie);
        }
        return null;
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public void saveMovie(Movie movie) {
        this.movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(long id) {
        return null;
    }

    @Override
    public void deleteMovieById(long id) {

    }


    @Override
    public Page<Movie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.movieRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public List<Movie> findByKeyword(String keyword) {
        return movieRepository.findByName(keyword);
    }


}
