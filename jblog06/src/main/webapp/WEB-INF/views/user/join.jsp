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
﻿<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>﻿
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script> --%>

<script type="text/javascript">
	//var duplCheck = false;
</script>

<script>
$(function(){
	$("#btn-checkId").click(() => {
		var blogId = $("#blog-id").val();
		if(blogId == '') {
			return;
		}
		
		$.ajax({
			url: "${pageContext.request.contextPath }/user/api/checkId?blogId=" + blogId,
			type: "get",
			dataType: "json",
			error: function(xhr, status, e) {
				console.log(status, e);
			},
			success: function(response) {
				if(response.data) {
					alert("존재하는 ID입니다. 다른 ID를 사용하세요.");
					$("#blog-id").val("").focus();
					return;
				}
				
				$("#btn-checkId").hide();
				$("#img-checkId").show();
				//duplCheck = true;
				console.log(duplCheck);
				
			}
		});		 
	});	
});
</script>

</head>
<body>
	<div class="center-content">
	
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		
		<form class="join-form" id="join-form" method="post" action="${pageContext.request.contextPath }/user/join">
			<label class="block-label" for="name">이름</label>
			<input id="name"name="name" type="text" value="">
			
			<label class="block-label" for="blog-id">아이디</label>
			<input id="blog-id" name="id" type="text"> 
			<input id="btn-checkId" type="button" value="id 중복체크">
			<img id="img-checkId" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">패스워드</label>
			<input id="password" name="password" type="password" />

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">
		</form>
		
		
		
	</div>
</body>
</html>
