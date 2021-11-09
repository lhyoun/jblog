package com.douzone.jblog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.PostVo;

@Repository
public class PostRepository {
	@Autowired
	private SqlSession sqlSession;

	// user의 게시글 중 특정 category에 해당하는 게시글 (+페이징) 
	public List<PostVo> findAllById(Map<String, Object> map) {
		return sqlSession.selectList("post.findAllById", map);
	}
	
	// user의 모든 게시글 (보류)
	public PostVo findById(Long id) {
		return sqlSession.selectOne("post.findById", id);
	}
	
	// 게시글 no로 하나의 게시글
	public PostVo findByNo(Map<String, Object> postVoMap) {
		return sqlSession.selectOne("post.findByNo", postVoMap);
	}
	
	// user의 게시글 수
	public int getCount(Map<String, Object> map) {
		return sqlSession.selectOne("post.getCount", map);
	}
	
	// 글쓰기
	public int write(PostVo postVo) {
		return sqlSession.insert("post.insert", postVo);
	}

}
