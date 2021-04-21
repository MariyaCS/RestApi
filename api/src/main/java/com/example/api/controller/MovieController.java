package com.example.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entity.Movie;
import com.example.api.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping("/category")
	public List<Movie> searchAll(){
		return (List<Movie>) movieRepository.findAll();
	}
	
	@GetMapping("/category/{category}")
	public List <Movie> getMovieById(@PathVariable("category") String category) {
		return movieRepository.findByCategory(category);
	}
	
	@GetMapping("/year/{year}")
	public List<Movie> searchYear(@PathVariable("year") int year){
		return movieRepository.findByYear(year);
	}
	
	@GetMapping("/year/{year}/category/{category}")
	public List<Movie> searchYearCategory(@PathVariable("year") int year, @PathVariable("category") String category){
	     return movieRepository.findByYearAndCategory(year, category);
	}
	
	@GetMapping("/year/{year}/category/{category}/winner")
	public List<Movie> searchWinner(@PathVariable("year") int year, @PathVariable("category") String category){
		
		 return movieRepository.findByYearAndCategoryAndWinner(year, category, true);
	}
}
