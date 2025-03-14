package com.crud.restapi.repository;

import com.crud.restapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

     @Query(value = "SELECT * FROM movie m WHERE m.name LIKE %:keyword% OR m.name_of_actors LIKE %:keyword% OR m.genre LIKE %:keyword%", nativeQuery = true)
        List<Movie> findByName(@Param("keyword") String keyword);


}
