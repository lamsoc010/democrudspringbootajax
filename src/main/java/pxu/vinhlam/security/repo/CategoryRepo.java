package pxu.vinhlam.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pxu.vinhlam.security.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
