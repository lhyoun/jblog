package com.douzone.jblog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.douzone.jblog.repository.PostRepository;
import com.douzone.jblog.vo.PostVo;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	// 블로그 메인화면에 보여줄 게시물 (1개)
	public PostVo getMainPost(Map<String, Object> postVoMap) {
		return postRepository.findByNo(postVoMap);
	}

	public List<PostVo> findAllById(Map<String, Object> map) {
		return postRepository.findAllById(map);
	}
	
	// user의 모든 게시글 (보류)
	public PostVo findById(Long id) {
		return postRepository.findById(id);
	}

	// user의 게시글 수
	public int getCount(Map<String, Object> map) {
		return postRepository.getCount(map);
	}
	
	// 글쓰기
	public int write(PostVo postVo) {
		return postRepository.write(postVo);
	}

	// 검색
	public List<PostVo> getSearchList(String keyword) {
		return postRepository.findByKwd(keyword);
		
	}

}
