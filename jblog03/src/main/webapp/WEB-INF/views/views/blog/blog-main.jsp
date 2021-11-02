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
					<h4>[카테고리]${postVo.title }</h4>
					<p>
						${postVo.contents }
					<p>
				</div>
				<!-- 하단 게시물 목록 -->
				<hr style='border: 0; height: 1px;
	  							background-image: linear-gradient(to right, rgba(0, 0, 0, 0.9), rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0));'/>
				<h4 style='padding: 10px; font-size: 1.3em; color: #9D96D0;'> 카테고리: 모든 카테고리 </h4>
				<ul class="blog-list">
					<c:forEach items='${list }' var='postVo' varStatus='status'>
						<li><a href="${pageContext.request.contextPath}/${authUser.id}/${postVo.no}">${postVo.title }</a> <span>${postVo.reg_date }</span></li>
					</c:forEach>
				</ul>
				
				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li class="selected"><a href="">1</a></li>
						<li>2</li>
						<li><a href="">3</a></li>
						<li>4</li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>
									
				<br/>
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
				<c:forEach items='${category }' var='category' varStatus='status'>
					<li><a href="${pageContext.request.contextPath}/${authUser.id }/1/${category.no }">${category.name }</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<c:import url="/WEB-INF/views/views/includes/footer.jsp" />
		
	</div>
</body>
</html>