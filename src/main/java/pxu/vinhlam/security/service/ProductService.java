package pxu.vinhlam.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pxu.vinhlam.security.model.Product;
import pxu.vinhlam.security.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	public void create(Product product) {
		productRepo.save(product);
	}
	
	public List<Product> findAll() {
		return productRepo.findAll();
	}
	
	public List<Product> getAllProductsSortedByPrice(String value) {
		Sort sort = null;
		if(value.equalsIgnoreCase("asc")) {
			sort = Sort.by("price").ascending();			
		} else if(value.equalsIgnoreCase("desc")){
			sort = Sort.by("price").descending();
		}
        return productRepo.findAll(sort);
    }
	
	public List<Product> findProductsByNameContainingOrderByPriceAsc(String name, String priceSort, int idCategory, int fromPrice, int toPrice) {
		name = "%" + name + "%";
		if(priceSort.equalsIgnoreCase("asc")) {
			return productRepo.findByNameContainingOrderByPriceAsc(name, idCategory, fromPrice, toPrice);			
		} else {
			return productRepo.findByNameContainingOrderByPriceDesc(name, idCategory, fromPrice, toPrice);	
		}
    }
	
	public List<Product> findProductsByNameContaining(String name) {
		name = "%" + name + "%";//%n%
        return productRepo.findByNameContaining(name);
    }
	
	public Product findById(int id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public boolean save(Product p) {
		Product pSave = productRepo.save(p);
		return pSave != null ? true : false;
	}
	
	public Product saveReturn(Product p) {
		Product pSave = productRepo.save(p);
		return pSave;
	}
	
	public void remove(int id) {
		productRepo.deleteById(id);
	}
}
