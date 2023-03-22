package com.devsuperior.movieflix.dto;


import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.Review;


public class ReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank
	private String text;
	private long movieId;
	
	public ReviewDTO() {
	}

	public ReviewDTO(Long id, String text, long movieId) {
		this.id = id;
		this.text = text;
		this.movieId = movieId;
	}
	
//	public ReviewDTO(Review entity) {
//		this.id = entity.getId();
//		this.text = entity.getText();
//		this.movieId = entity.getMovie();
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}






}
