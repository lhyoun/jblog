package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.repository.CategoryRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.BoardVo;
import com.douzone.jblog.vo.CategoryVo;

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
	
}
