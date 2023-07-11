package pxu.vinhlam.security.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pxu.vinhlam.security.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	List<Product> findAll(Sort sort);
	
	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    List<Product> findByNameContaining(String name);
	
	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1% ORDER BY p.price ASC")
    List<Product> findByNameContainingOrderByPriceAsc(String name);
	
	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1% ORDER BY p.price DESC")
    List<Product> findByNameContainingOrderByPriceDesc(String name);
}
