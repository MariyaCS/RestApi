package com.example.api.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.api.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
	
	 List<Movie> findByYear(int year);

	 List<Movie> findByCategory(String category);
	 
	 List<Movie> findByYearAndCategory(int year, String category);
	 
	 List<Movie> findByYearAndCategoryAndWinner(int year, String category, boolean winner);
 
}
