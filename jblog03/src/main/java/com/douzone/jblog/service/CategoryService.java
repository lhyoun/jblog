package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.CategoryRepository;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.dto.CategoryDto;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public List<CategoryVo> findById(String id) {
		
		return categoryRepository.findByBlogId(id);
	}

	public boolean addCategory( CategoryVo categoryVo ) {
		return categoryRepository.insert( categoryVo ) == 1;
	}

	public boolean deleteCategory(int no) {
		return categoryRepository.delete(no) == 1;
		
	}

	public List<CategoryDto> findDtoById(String blogId) {

		return categoryRepository.findDtoByBlogId(blogId);
	}
	
}
