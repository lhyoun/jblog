<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

				<ul class="admin-menu">
					<li><a href="${pageContext.request.contextPath }/blog/admin">기본설정</a></li>
					<li class="selected"><a href="${pageContext.request.contextPath }/blog/category">카테고리</a></li>
					<li><a href="${pageContext.request.contextPath }/blog/write">글작성</a></li>
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