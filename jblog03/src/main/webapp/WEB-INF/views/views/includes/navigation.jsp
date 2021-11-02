<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<h1 class="logo">JBlog</h1>
		<ul class="menu">
			<c:choose>
				<c:when test="${empty authUser }">
					<li><a href="${pageContext.request.contextPath }/user/login">로그인</a></li>
					<li><a href="${pageContext.request.contextPath }/user/join">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
					<li><a href="${pageContext.request.contextPath }/${authUser.id }/1">내블로그</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		
<%-- 		<div id="navigation">
			<ul>
				<c:if test='${not empty authUser }'>
					<c:choose>
						<c:when test='${authUser.role == "ADMIN" }'>
							<li><a href="${pageContext.request.contextPath }/admin">관리자 페이지</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath }">${authUser.name }</a></li>
						</c:otherwise>
					</c:choose>
				</c:if>
				<li><a href="${pageContext.request.contextPath }/guestbook">방명록</a></li>
				<li><a href="${pageContext.request.contextPath }/board">게시판</a></li>
				<li><a href="${pageContext.request.contextPath }/gallery">갤러리</a></li>
			</ul>
		</div> --%>