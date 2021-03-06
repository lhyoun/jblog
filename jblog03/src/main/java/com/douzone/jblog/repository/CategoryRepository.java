package com.douzone.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.dto.CategoryDto;

@Repository
public class CategoryRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public List<CategoryVo> findByBlogId(String id) {
		
		return sqlSession.selectList("category.findByBlogId", id);
	}
	
	public int insert( CategoryVo categoryVo ) {
		
		return sqlSession.insert( "category.insert", categoryVo );
		
	}

	public int delete(int no) {
		
		return sqlSession.delete("category.delete", no);
	}

	public List<CategoryDto> findDtoByBlogId(String blogId) {
		
		return sqlSession.selectList("category.findDtoByBlogId", blogId);
	}

}
