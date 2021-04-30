package com.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.api.services.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/all")
	public String searchAll(Model model){
		model.addAttribute("movies", movieService.searchAll());	
		return "movies.html";
	}
	
	@GetMapping("/year/{year}/category/{category}")
	public String searchYearCategory(Model model, @PathVariable("year") int year, @PathVariable("category") String category){
		
		model.addAttribute("movies", movieService.searchYearCategory(year, category));	
	     return "yearCategory.html";
	}
	
	
	@GetMapping("/category/{category}")
	public String searchCategory(Model model, @PathVariable("category") String category) {
		
		model.addAttribute("movies", movieService.searchCategory(category));	
		return "category.html";
	}
	
	@GetMapping("/year/{year}")
	public String searchYear(Model model, @PathVariable("year") int year){
		
		model.addAttribute("movies", movieService.searchYear(year));
		return "year.html";
	}
	
	@GetMapping("/year/{year}/category/{category}/winner")
	public String searchWinner(Model model, @PathVariable("year") int year, @PathVariable("category") String category){
		
		model.addAttribute("movies", movieService.searchWinner(year, category, true));
		return "winner.html";
		 
	}
	
}
