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
	
	@Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    List<Product> findByNameContaining(String name);
	
	@Query("SELECT p FROM Product p WHERE (p.category.id = :idCategory OR :idCategory = -1) AND p.name LIKE :name AND (p.price BETWEEN :fromPrice AND :toPrice) ORDER BY p.price ASC")
    List<Product> findByNameContainingOrderByPriceAsc(String name, int idCategory, int fromPrice, int toPrice);
	
	@Query("SELECT p FROM Product p WHERE (p.category.id = :idCategory OR :idCategory = -1) AND p.name LIKE :name AND (p.price BETWEEN :fromPrice AND :toPrice) ORDER BY p.price DESC")
    List<Product> findByNameContainingOrderByPriceDesc(String name, int idCategory,  int fromPrice, int toPrice);
}
