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
<script src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>

<script>
$(function(){
	
	$("#btn-addCategory").click(() => {
		var name = $("#name").val();
		var desc = $("#desc").val();
		
		console.log('==', name, desc, '==');
		
		if(name == '' || desc == '') {
			return;
		}
		
		$.ajax({
			url: "${pageContext.request.contextPath }/category/api/add",
			type: "post",
			dataType: "json",
			contentType: 'application/json',
			data: JSON.stringify({name:$('#name').val(), desc:$('#desc').val()}),
			error: function(xhr, status, e) {
				console.log(status, e);
			},
			success: function(response) {
				console.log(response);
				
				
				if(response == "성공") {
					alert(response);
					return;
				}
				
			}
		});		 
	});
	
});
</script>
<script type="text/javascript"> 

	var delete_category = (no)=>{
		alert(no);
	};
      

</script> 
</head>
<body>
	<div id="container">

		<c:import url="/WEB-INF/views/views/includes/navigation2.jsp" />
		
		<div id="wrapper">
			<div id="content" class="full-screen">
			
				<c:import url="/WEB-INF/views/views/includes/navigation3.jsp" />
				
				
				
		      	<table class="admin-cat">
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
							<td>게시물수조인해서가져오기</td>
							<td>${vo.desc }</td>
							<td><img onclick="delete_category(${vo.no});" src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
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
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>