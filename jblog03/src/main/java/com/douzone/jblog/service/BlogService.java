package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVo;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	public BlogVo findById(String id) {
		
		return blogRepository.findById(id);
	}
	
	// 블로그 수정 (title, logo)
	public boolean updateBlog(BlogVo vo) {
		
		return blogRepository.updateBlog(vo);
	}

	// 회원가입시 블로그 생성
	public boolean join(BlogVo blogVo) {
		
		return blogRepository.join(blogVo) == 1;
	}

	// 블로그 수정 (title)
	public boolean updateBlogTitle(BlogVo blogVo) {
		// TODO Auto-generated method stub
		return blogRepository.updateBlogTitle(blogVo);
	}


}
