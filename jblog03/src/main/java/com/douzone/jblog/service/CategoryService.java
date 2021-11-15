package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douzone.jblog.repository.CategoryRepository;
import com.douzone.jblog.repository.PostRepository;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.dto.CategoryDto;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PostRepository postRepository;

	// userId로 해당 user의 category List
	public List<CategoryVo> getCategoryListByUserId(String id) {
		
		return categoryRepository.findByBlogId(id);
	}

	public boolean addCategory( CategoryVo categoryVo ) {
		return categoryRepository.insert( categoryVo ) == 1;
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean deleteCategory(int no) {
		postRepository.deleteByCategoryNo(no);

		return categoryRepository.delete(no) == 1;
	}

	public List<CategoryDto> findDtoById(String blogId) {

		return categoryRepository.findDtoByBlogId(blogId);
	}
	
}
