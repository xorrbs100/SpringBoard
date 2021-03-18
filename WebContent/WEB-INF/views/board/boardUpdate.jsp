<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>boardWrite</title>
</head>

<script type="text/javascript">
	$j(document).ready(function(){
	
		$j("#submit").on("click",function(){
			var $frm = $j('.boardUpdate :input');
			var param = $frm.serialize();
			
			$j.ajax({
			    url : "/board/boardUpdateAction.do",
			    dataType: "json",
			    type: "POST",
			    data : param,
			    success: function(data, textStatus, jqXHR)
			    {
					alert("작성완료");
					
					alert("메세지:"+data.success);
					
					location.href = "/board/boardList.do?pageNo=1";
			    },
			    error: function (jqXHR, textStatus, errorThrown)
			    {
			    	alert("실패");
			    }
			});
		});
	});

</script>
<body>
<%
	String userId =null;
	String userName=null;
	if(session.getAttribute("ses")!=null){
		userId=(String)session.getAttribute("ses");
		userName=(String)session.getAttribute("name");
	}
	if(userId == null){	//userID가 null 일때
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 하세요.')");
		script.println("location.href='login.jsp'");
		script.println("</script>");
		
	}
%>
<form class="boardUpdate">
	<table align="center">
		<tr>
			<td align="right">
			<input id="submit" type="button" value="수정">
			</td>
		</tr>
		<tr>
			<td>
				<table border ="1"> 
				<tr>
			
					
				
					<tr>
						<td width="120" align="center">
						Title
						
						
						</td>
						<td width="400">
						
						<input name="boardTitle" type="text" size="50" value="
						${boardUpdate.boardTitle}"> 
						</td>
					</tr>
					<tr>
						<td height="300" align="center">
						Comment
						</td>
						<td valign="top">
						<textarea name="boardComment"  rows="20" cols="55">
						${boardUpdate.boardComment}</textarea>
						</td>
					</tr>
					<tr>
						<td align="center">
						
						Writer
						</td>
						<td>
						${boardUpdate.creator}
						
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="right">
				<a href="/board/boardList.do">List</a>
				
			</td>
		</tr>
	</table>
	<input name="boardNum" type="hidden" value="${boardNum}">
	<input name="boardType" type="hidden" value="${boardType}">
	<input type="hidden" value="${boardUpdate.creator}" name="creator">
	<input type="hidden" value="<%= userName %>" name="modifier">
</form>	
</body>
</html>