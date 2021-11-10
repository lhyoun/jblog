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

<script>
$(function(){
	
	$("#btn-addCategory").click(() => {
		var name = $("#name").val();
		var desc = $("#desc").val();
		var blog_id = $("#blog_id").val();
		
		console.log('==', name, desc, blog_id, '==');
		
		if(name == '' || desc == '' || blog_id == '') {
			return;
		}
		
		$.ajax({
			url: "${pageContext.request.contextPath }/category/api/add",
			type: "post",
			dataType: "json",
			contentType: 'application/json',
			data: JSON.stringify({name:name, desc:desc, blog_id:blog_id}),
			error: function(xhr, status, e) {
				console.log(status, e);
			},
			success: function(response) {
				console.log(response);
				
				if(response.result == "success") {
					alert('추가되었습니다');
					
					$('#mytable > tbody:last').append(
					  '<td>new</td>'
					+ '<td>' + $('#name').val() + '</td>'
					+ '<td>0</td>'
					+ '<td>' + $('#desc').val() + '</td>'
					+ '<td><img onclick="delete_category(1);" src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>');
					
					$('#name').val('');
					$('#desc').val('');
					
					return;
				}
			}
		});		 
	});
	
	$(".deleteImg").click(() => {
		var thisTmp = $(this);
		$(thisTmp).parent().remove();
		console.log(thisTmp);
		/* $.ajax({
			url: "${pageContext.request.contextPath }/category/api/delete/"+no,
			type: "delete",
			error: function(xhr, status, e) {
				console.log(status, e);
			},
			success: function(response) {
				
				if(response.result == "success") {
					alert('삭제되었습니다');
					
					$(thisTmp).parent().remove();
					
					return;
				}
			}
		}); */
	});		 
	
});
</script>

</head>
<body>
	<div id="container">

		<c:import url="/WEB-INF/views/includes/navigation2.jsp" />
		
		<div id="wrapper">
			<div id="content" class="full-screen">
			
				<c:import url="/WEB-INF/views/includes/navigation3.jsp" />
				
		      	<table id="mytable" class="admin-cat">
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      		
		      		<c:forEach items='${list }' var='vo' varStatus='status'>
						<tr>
							<td>${status.index+1 }</td>
							<td>${vo.name }</td>
							<td>${vo.cnt }</td>
							<td>${vo.desc }</td>
							<td><img class="deleteImg" src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
						</tr>  
					</c:forEach>
									  
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" id="name" name="name"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" id="desc" name="desc"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input id="btn-addCategory" type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
		<input type="hidden" id="blog_id" name="blog_id" value="${blogVo.id }">
	</div>
</body>
</html>