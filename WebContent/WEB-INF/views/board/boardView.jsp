<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>boardView</title>
<script>
	function del(seq) {
		var chk = confirm("정말 삭제하시겠습니까?");
		if (chk) {
			location.href='/board/${boardNum}/${boardType}/boardDelete.do';
		}
	}	
</script>
</head>
<body>
<%
	String userId =null;
	
	if(session.getAttribute("ses")!=null){
		userId=(String)session.getAttribute("ses");
	}
	
%>
<table align="center">
	<tr>
		<td>
			<table border ="1">
				
				<tr>
					<td width="120" align="center">
					Title
					</td>
					<td width="400">
					${board.boardTitle}
					</td>
				</tr>
				<tr>
					<td height="300" align="center">
					Comment
					</td>
					<td>
					
					${board.boardComment}
					</td>
				</tr>
				<tr>
					<td align="center">
					Writer
					</td>
					<td>
					${board.creator}
					<%-- <c:set var ="creator" value="${board.creator}"/>
					<%String creator =(String)pageContext.getAttribute("creator"); %> --%>
					</td>
				</tr>
				<tr>
					<td align="center">
					Modifier
					</td>
					<td>
					${board.modifier}
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="right">
		<% if(userId==null){%>
			<a href="/board/boardList.do">List</a>
		<% } else{ %>
			<input type="button" value="삭제" onclick="del(${board.boardNum})">
			<a href="/board/${board.boardNum}/${board.boardType}/boardUpdate.do">Update</a>
			<a href="/board/boardList.do">List</a>
		<%}%>
			
			
			
		</td>
	</tr>
</table>	
</body>
</html>