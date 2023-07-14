package pxu.vinhlam.security.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pxu.vinhlam.security.model.Category;
import pxu.vinhlam.security.model.Product;
import pxu.vinhlam.security.model.Tag;
import pxu.vinhlam.security.service.CategoryService;
import pxu.vinhlam.security.service.ProductService;
import pxu.vinhlam.security.service.TagService;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TagService tagsService;
	
	@GetMapping("")
	public ResponseEntity<?> showIndex() {
		List<Product> products = productService.findAll();
		List<Category> categories = categoryService.findAll();
		Map<String, Object> map = new HashMap<>();
		map.put("products", products);
		map.put("categories", categories);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> handleCreate(@ModelAttribute Product product) {
		Category category = categoryService.findById(product.getCategory().getId());
		product.setCategory(category);
		Product productCreate = productService.saveReturn(product);
		return ResponseEntity.ok(productCreate);
	}
	
	@GetMapping("/update")
	public ResponseEntity<?> showUpdate(@RequestParam int id) {
		Product product = productService.findById(id);
		List<Category> categories = categoryService.findAll();
		Map<String, Object> map = new HashMap<>();
		map.put("product", product);
		map.put("categories", categories);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> handleUpdate(@ModelAttribute Product product) {
		Product productUpdate = productService.saveReturn(product);
		return ResponseEntity.ok(productUpdate);
	}
	
	@GetMapping("/delete")
	public ResponseEntity<?> handleDelete(@RequestParam int id) {
		productService.remove(id);
		return ResponseEntity.ok("Delete success");
	}
	
	@GetMapping("/sortPrice")
	public ResponseEntity<?> handleSortPrice(@RequestParam String value) {
		List<Product> products = productService.getAllProductsSortedByPrice(value);
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/findName")
	public ResponseEntity<?> handleFindName(@RequestParam String value) {
		List<Product> products = productService.findProductsByNameContaining(value);
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/sortAndFind")
	public ResponseEntity<?> handleSortAndFind(
			@RequestParam(defaultValue = "DESC") String price,
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") int idCategory,
			@RequestParam(defaultValue = "1000") int fromPrice,
			@RequestParam(defaultValue = "10000000") int toPrice) {
		List<Product> products = productService.findProductsByNameContainingOrderByPriceAsc(name, price, idCategory, fromPrice, toPrice);
		return ResponseEntity.ok(products);
	}
}
