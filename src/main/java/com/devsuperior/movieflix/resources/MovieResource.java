package com.devsuperior.movieflix.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.MovieService;


@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

	@Autowired
	private MovieService service;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping
	public ResponseEntity<Page<MovieCardDTO>> findAll(Pageable pageable) {

		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("title"));
		Page<MovieCardDTO> page = service.findAllPaged(pageRequest);
		
//		Page<MovieCardDTO> list = service.findAllPaged(pageable);
		
		return ResponseEntity.ok().body(page);
	}
	
	
//	@GetMapping
//	public ResponseEntity<Page<ProductDTO>> findAll(
//			@RequestParam(value = "categoryId", defaultValue = "0") Long categoryId,
//			@RequestParam(value = "name", defaultValue = "") String name,
//			Pageable pageable) {
//		
//		Page<ProductDTO> list = service.findAllPaged(categoryId, name.trim(), pageable);		
//		return ResponseEntity.ok().body(list);
//	}
	
	// Buscar categoria por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDetailsDTO> findById(@PathVariable Long id) {
		
		MovieDetailsDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

}