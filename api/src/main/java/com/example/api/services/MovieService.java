package com.example.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.api.entity.Movie;
import com.example.api.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> searchAll(){
		
		return (List<Movie>) movieRepository.findAll();
	}
	
	
	public List <Movie> searchCategory(String category) {
		
		return movieRepository.findByCategory(category);
	}
	

	public List<Movie> searchYear(@PathVariable("year") int year){
	
		return movieRepository.findByYear(year);
	}
	
	
	public List<Movie> searchYearCategory(int year, String category){
		
	     return movieRepository.findByYearAndCategory(year, category);
	}
	
	public List<Movie> searchWinner(int year, String category, boolean winner){
		
		 return movieRepository.findByYearAndCategoryAndWinner(year, category, true);
	}
 
}
