package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.ReviewRepository;


@Service
public class ReviewService {


	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private AuthService authService;
	
	
	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		
		Review entity = new Review();
		
		entity.setMovie(dto.get());
		entity.setUser(dto.getName());
		entity.setText(dto.getName());
		
		entity = repository.save(entity);
		return new ReviewDTO(entity);
		
	}
	
	
//	@Transactional(readOnly = true)
//	public MovieDetailsDTO findById(Long id) {
//		Optional<Movie> obj = repository.findById(id);
//		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found") );
//		return new MovieDetailsDTO(entity);
//	}
//
//	@Transactional(readOnly = true)
//	public Page<MovieCardDTO> findAllPaged(Pageable pageable) {
//		Page<Movie> list = repository.findAll(pageable);
//		
//		return list.map(x -> new MovieCardDTO(x));
//
//	}
	
}
