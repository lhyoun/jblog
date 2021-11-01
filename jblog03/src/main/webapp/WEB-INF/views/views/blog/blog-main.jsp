<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
	
		<c:import url="/WEB-INF/views/views/includes/navigation2.jsp" />

		<div id="wrapper">
			<div id="content">
				<!-- 상단 게시물 내용 -->
				<div class="blog-content">
					<h4>${postVo.title }</h4>
					<p>
						${postVo.contents }
					<p>
				</div>
				<!-- 하단 게시물 목록 -->
				<ul class="blog-list">
					<c:forEach items='${list }' var='postVo' varStatus='status'>
						<li><a href="">${postVo.title }</a> <span>${postVo.reg_date }</span></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<li><a href="">닥치고 스프링</a></li>
				<li><a href="">스프링 스터디</a></li>
				<li><a href="">스프링 프로젝트</a></li>
				<li><a href="">기타</a></li>
			</ul>
		</div>
		
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>