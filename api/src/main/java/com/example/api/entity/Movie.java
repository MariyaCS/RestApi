package com.example.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	
	@Column(name="title")
	private String title;
	

	@Column(name="year")
	private int year;
	

	@Column(name="category")
	private String category;
	
	@Column(name="imdb")
	private String imdb;
	
	@JsonIgnore
	@Column(name="winner")
	private boolean winner;
	
	public Movie() {}
		
	
	public Movie(Long id, String title, int year, String category, String imdb, boolean winner) {
	
		this.id = id;
		this.title = title;
		this.year = year;
		this.category = category;
		this.imdb = imdb;
		this.winner = winner;
	} 
	


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImdb() {
		return imdb;
	}
	public void setImdb(String imdb) {
		this.imdb = imdb;
	}
	public boolean isWinner() {
		return winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", category=" + category + ", imdb=" + imdb
				+ ", winner=" + winner + "]";
	}

}
