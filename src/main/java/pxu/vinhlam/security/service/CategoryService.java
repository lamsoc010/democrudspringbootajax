package pxu.vinhlam.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.vinhlam.security.model.Category;
import pxu.vinhlam.security.repo.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	
	public Category findById(int id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	public Category create(Category category) {
		Category cCreate = categoryRepo.save(category);
		return cCreate;
	}
	
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}
}
