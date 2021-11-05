package com.douzone.jblog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.PostRepository;
import com.douzone.jblog.vo.PostVo;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	public List<PostVo> findAllById(Map<String, Object> map) {
		return postRepository.findAllById(map);
	}
	
	// user의 모든 게시글 (보류)
	public PostVo findById(Long id) {
		return postRepository.findById(id);
	}

	// 게시글 no로 하나의 게시글
	public PostVo findByNo(Long postId) {
		return postRepository.findByNo(postId);
	}

	// user의 게시글 수
	public int getCount(Map<String, Object> map) {
		return postRepository.getCount(map);
	}
	
	// 글쓰기
	public int write(PostVo postVo) {
		return postRepository.write(postVo);
	}

}
