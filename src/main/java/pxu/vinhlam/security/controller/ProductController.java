package pxu.vinhlam.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pxu.vinhlam.security.model.Category;
import pxu.vinhlam.security.model.Product;
import pxu.vinhlam.security.model.Tag;
import pxu.vinhlam.security.service.CategoryService;
import pxu.vinhlam.security.service.ProductService;
import pxu.vinhlam.security.service.TagService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TagService tagsService;
	
	@GetMapping("")
	public String showIndex() {
		return "index3";
	}
	
//	@GetMapping("/create")
//	public String showCreate(Model model) {
//		List<Category> categories = categoryService.findAll();
//		List<Tag> tags = tagsService.findAll();
//		Product product = new Product();
//		model.addAttribute("product", product);
//		model.addAttribute("categories", categories);
//		model.addAttribute("tags", tags);
//		return "create";
//	}
//	
//	@PostMapping("/create")
//	public String handleCreate(Model model, @ModelAttribute Product product) {
//		Category category = categoryService.findById(product.getCategory().getId());
//		product.setCategory(category);
//		productService.save(product);
//		List<Category> categories = categoryService.findAll();
//		model.addAttribute("product", new Product());
//		model.addAttribute("categories", categories);
//		return "create";
//	}
//	
//	@GetMapping("/update/{id}")
//	public String showUpdate(Model model, @PathVariable int id) {
//		Product product = productService.findById(id);
//		List<Category> categories = categoryService.findAll();
//		List<Tag> tags = tagsService.findAll();
//		
//		System.out.println(categories.size());
//		
//		model.addAttribute("product", product);
//		model.addAttribute("categories", categories);
//		model.addAttribute("tagsList", tags);
//		
//		return "update";
//	}
//	
//	@PostMapping("/update")
//	public String handleUpdate(Model model, @ModelAttribute Product product) {
//		productService.save(product);
//		return "redirect:/products";
//	}
//	
//	@GetMapping("/delete/{id}")
//	public String handleDelete(Model model, @PathVariable int id) {
//		productService.remove(id);
//		return "redirect:/products";
//	}
}
