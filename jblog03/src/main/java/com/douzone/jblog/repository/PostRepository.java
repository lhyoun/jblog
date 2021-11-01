package com.douzone.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.PostVo;

@Repository
public class PostRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public PostVo findById(Long id) {
		
		return sqlSession.selectOne("post.findById", id);
	}

	public int write(PostVo postVo) {
		
		return sqlSession.insert("post.insert", postVo);
	}

	public List<PostVo> findAllById(String id) {
		
		return sqlSession.selectList("post.findAllById", id);
	}

}
