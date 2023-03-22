package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.GenreRepository;


@Service
public class GenreService {


	@Autowired
	private GenreRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public Page<GenreDTO> findAllPaged(Pageable pageable) {
		User user = authService.authenticated();
		Page<Genre> list = repository.findAll(pageable);
		
		return list.map(x -> new GenreDTO(x));

	}
	
}
