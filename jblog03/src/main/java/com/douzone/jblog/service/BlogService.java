package com.douzone.jblog.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.UserVo;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	public BlogVo findById(String id) {
		
		return blogRepository.findById(id);
	}
	
	public boolean updateBlog(BlogVo vo) {
		
		return blogRepository.updateBlog(vo);
	}

	// 회원가입시 블로그 생성
	public boolean join(BlogVo blogVo) {
		
		return blogRepository.join(blogVo) == 1;
	}


}
