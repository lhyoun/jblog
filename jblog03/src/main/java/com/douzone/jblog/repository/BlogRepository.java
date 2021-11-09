package com.douzone.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.UserVo;

@Repository
public class BlogRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public BlogVo findById(String id) {
		
		return sqlSession.selectOne("blog.findById", id);
	}

	public boolean updateBlog(BlogVo vo) {
		
		return sqlSession.update("blog.update", vo) == 1;
	}

	public int join(BlogVo blogVo) {
		
		return sqlSession.insert("blog.join", blogVo);
	}

	public boolean updateBlogTitle(BlogVo blogVo) {
		
		return sqlSession.update("blog.updateTitle", blogVo) == 1;
	}

}
