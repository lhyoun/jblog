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
				<hr style='border: 0; height: 1px;
	  							background-image: linear-gradient(to right, rgba(0, 0, 0, 0.9), rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0));'/>
				<h4 style='padding: 10px; font-size: 1.3em; color: #9D96D0;'> 카테고리: ${category_name } </h4>
				<ul class="blog-list">
					<c:forEach items='${list }' var='postVo' varStatus='status'>
						<li>
																		<!-- 블로그ID/postID/page/categoryNo -->
							<a href="${pageContext.request.contextPath}/${blogVo.id }/${postVo.no}/1/${category_no }">${postVo.title }</a> 
							<span>${postVo.reg_date }</span>
						</li>
					</c:forEach>
				</ul>
				
				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						
						<c:forEach var="num" begin="${page.startPage }" end="${page.endPage }" >
							<c:choose>
								<c:when test="${page.pageNum == num}">
									<li class="selected"> ${num } </li>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${page.realEnd >= num}">
																							<!-- 블로그ID/postID/page/categoryNo -->
											<li><a href="${pageContext.request.contextPath }/${blogVo.id }/1/${num }/${category_no }">${num }</a></li>
										</c:when>
										<c:otherwise>
												<li>${num }</li>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<li><a href="">▶</a></li>
					</ul>
				</div>			
									
				<br/>
			</div>
		</div>

		<div id="extra">
			<br/>
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath }${blogVo.logo }">
			</div>
		</div>

		<div id="navigation">
			<br/>
			<hr style='border: 0; height: 1px;
	  			background-image: linear-gradient(to right, rgba(0, 0, 0, 0.9), rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0));'/>
			<br/>
			<h2 style='color:#9D96D0;'>카테고리</h2>
			<ul>
				<li><a href="${pageContext.request.contextPath}/${blogVo.id }/1/1/0">모든 카테고리</a></li>
				<c:forEach items='${category }' var='category' varStatus='status'>
																	<!-- 블로그ID/postID/page/categoryNo -->
					<li><a href="${pageContext.request.contextPath}/${blogVo.id }/1/1/${category.no }">${category.name }</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<c:import url="/WEB-INF/views/views/includes/footer.jsp" />
		
	</div>
</body>
</html>