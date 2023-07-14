package pxu.vinhlam.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pxu.vinhlam.security.model.Category;
import pxu.vinhlam.security.repo.CategoryRepo;
import pxu.vinhlam.security.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public ResponseEntity<?> findAll() {
		List<Category> categories = categoryService.findAll();
		System.out.println("hello");
		return ResponseEntity.ok(categories);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@ModelAttribute Category category) {
		Category cCreate = categoryService.create(category);
		return ResponseEntity.ok(cCreate);
	}
}
