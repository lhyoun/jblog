package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.repository.PostRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.PostVo;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	public PostVo findById(Long id) {
		
		return postRepository.findById(id);
	}

	public int write(PostVo postVo) {
		
		return postRepository.write(postVo);
	}

	public List<PostVo> findAllById(String id) {
		return postRepository.findAllById(id);
	}

	public PostVo findByNo(Long postId) {
		
		return postRepository.findByNo(postId);
	}

}
