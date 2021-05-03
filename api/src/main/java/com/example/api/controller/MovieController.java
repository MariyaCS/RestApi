package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.api.entity.Movie;
import com.example.api.services.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/movies")
	public String searchAll(Model model){
		model.addAttribute("movies", movieService.searchAll());	
		return "movies.html";
	}
	
	@GetMapping("movies/year/{year}/category/{category}")
	public String searchYearCategory(Model model, @PathVariable("year") int year, @PathVariable("category") String category){
		
		model.addAttribute("movies", movieService.searchYearCategory(year, category));	
	     return "movies.html";
	}
	
	
	@GetMapping("movies/category/{category}")
	public String searchCategory(Model model, @PathVariable("category") String category) {
		
		model.addAttribute("movies", movieService.searchCategory(category));	
		return "movies.html";
	}
	
	@GetMapping("movies/year/{year}")
	public String searchYear(Model model, @PathVariable("year") int year){
		
		model.addAttribute("movies", movieService.searchYear(year));
		return "movies.html";
	}
	
	@GetMapping("movies/year/{year}/category/{category}/winner")
	public String searchWinner(Model model, @PathVariable("year") int year, @PathVariable("category") String category){
		
		model.addAttribute("movies", movieService.searchWinner(year, category, true));
		return "movies.html";
		 
	}
	
										//*****************json********************//
	
	@GetMapping("/api/movies")
	@ResponseBody
	public List<Movie> searchAll(){
		
		return (List<Movie>) movieService.searchAll();
	}
	
	@GetMapping("api/movies/year/{year}/category/{category}/winner")
	@ResponseBody
	public List<Movie> searchWinner(@PathVariable("year") int year, @PathVariable("category") String category){
		
		 return movieService.searchWinner(year, category, true);
	}
	
	@GetMapping("api/movies/category/{category}")
	@ResponseBody
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
	
	@GetMapping("api/movies/year/{year}")
	@ResponseBody
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
	
	@GetMapping("api/movies/year/{year}/category/{category}")
	@ResponseBody
	public List<Movie> searchYearCategory(@RequestParam(value = "winner",required = false)Boolean winner, @PathVariable("year") int year, @PathVariable("category") String category){
		
		if(winner != null)
		{
			boolean win = winner.booleanValue();
			return movieService.searchWinner(year,category,win);
		}
		
	     return movieService.searchYearCategory(year, category);
	}
	
}
