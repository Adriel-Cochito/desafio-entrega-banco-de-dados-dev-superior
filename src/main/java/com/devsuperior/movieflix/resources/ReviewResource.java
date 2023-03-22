package com.devsuperior.movieflix.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.ReviewService;


@RestController
@RequestMapping(value = "/reviews")
public class ReviewResource {

	@Autowired
	private ReviewService service;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	
	// POST Insere nova review
	@PostMapping 
	public ResponseEntity<ReviewDTO> insert(@Valid @RequestBody ReviewDTO dto) {
		
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
//	@GetMapping
//	public ResponseEntity<Page<MovieCardDTO>> findAll(Pageable pageable) {
//
//		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("title"));
//		Page<MovieCardDTO> page = service.findAllPaged(pageRequest);
//		
////		Page<MovieCardDTO> list = service.findAllPaged(pageable);
//		
//		return ResponseEntity.ok().body(page);
//	}
	
	
//	@GetMapping
//	public ResponseEntity<Page<ProductDTO>> findAll(
//			@RequestParam(value = "categoryId", defaultValue = "0") Long categoryId,
//			@RequestParam(value = "name", defaultValue = "") String name,
//			Pageable pageable) {
//		
//		Page<ProductDTO> list = service.findAllPaged(categoryId, name.trim(), pageable);		
//		return ResponseEntity.ok().body(list);
//	}
	
//	// Buscar categoria por id
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<MovieDetailsDTO> findById(@PathVariable Long id) {
//		
//		MovieDetailsDTO dto = service.findById(id);
//		return ResponseEntity.ok().body(dto);
//	}

}