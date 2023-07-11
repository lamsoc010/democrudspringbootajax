package pxu.vinhlam.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.vinhlam.security.model.Tag;
import pxu.vinhlam.security.repo.TagRepo;

@Service
public class TagService {
	@Autowired
	private TagRepo tagsRepo;
	
	public List<Tag> findAll() {
		return tagsRepo.findAll();
	}
}
