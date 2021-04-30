package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entity.Movie;
import com.example.api.services.MovieService;


@RestController
@RequestMapping("/api/movies")
public class MovieRestController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public List<Movie> searchAll(){
		
		return (List<Movie>) movieService.searchAll();
	}
	
	@GetMapping("/year/{year}/category/{category}/winner")
	public List<Movie> searchWinner(@PathVariable("year") int year, @PathVariable("category") String category){
		
		 return movieService.searchWinner(year, category, true);
	}
	
	//*************************************parameter searches*****************************************//
	
	@GetMapping("/category/{category}")
	public List <Movie> searchCategory(@RequestParam(value = "year",required = false)Integer year, @RequestParam(value = "winner",required = false)Boolean winner, @PathVariable("category") String category) {
		
		if(year != null)
		{
			int date = year.intValue();
			if(winner != null)
			{
				boolean win = winner.booleanValue();
				return movieService.searchWinner(date,category,win);
			}
			return movieService.searchYearCategory(date,category);
		}
		
		return movieService.searchCategory(category);
	}
	
	@GetMapping("/year/{year}")
	public List<Movie> searchYear(@RequestParam(value = "winner",required = false)Boolean winner, @RequestParam(value = "category",required = false)String category, @PathVariable("year") int year){
		
		if(category != null)
		{
			if(winner != null)
			{
				boolean win = winner.booleanValue();
				return movieService.searchWinner(year,category,win);
			}
			return movieService.searchYearCategory(year,category);
		}
		
		return movieService.searchYear(year);
	}
	
	@GetMapping("/year/{year}/category/{category}")
	public List<Movie> searchYearCategory(@RequestParam(value = "winner",required = false)Boolean winner, @PathVariable("year") int year, @PathVariable("category") String category){
		
		if(winner != null)
		{
			boolean win = winner.booleanValue();
			return movieService.searchWinner(year,category,win);
		}
		
	     return movieService.searchYearCategory(year, category);
	}
	

}
