package pxu.vinhlam.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pxu.vinhlam.security.model.Tag;

@Repository
public interface TagRepo extends JpaRepository<Tag, Integer>{

}
