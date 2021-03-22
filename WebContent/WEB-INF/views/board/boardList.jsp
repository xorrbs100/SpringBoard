<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list</title>
</head>
<script type="text/javascript">

	$j(document).ready(function(){
	});

	
	//chkAll 체크박스체크시 전체체크
	 function check(){
		if($j("#chkAll").is(":checked")){
			$j("input[type=checkbox]").prop("checked", true);
		}
		else{
			$j("input[type=checkbox]").prop("checked", false);
		}
	} 
	 
	 //체크박스 체크 해제시 chkAll박스체크해제 , 다체크될시 chkAll박스체크
	 function acheck(){
		 $j("#chkAll").prop("checked",false);
		 if($j("input[type=checkbox]:checked").length==4){
			 $j("#chkAll").prop("checked", true);
		 }
	 }

	  
</script>

<body>
<%
	String userId =null;
	String userName=null;
if(session.getAttribute("ses")!=null){
	userId=(String)session.getAttribute("ses");
	userName=(String)session.getAttribute("name");
}
%>
<table  align="center">
	<tr>
	<%
		if(userId==null){ %>

	<% } else{ 	out.println("<td algin='left'>"+"userID:"+userId+"</td>"); %>
	
	<%} %>
		<td align="right" width ='330'>
			total : ${totalCnt}
		</td>
	</tr>
	</table>
<table align="center">
	<tr>
		<td>
			<table id="boardTable" border = "1">
				<tr>
					<td width="80" align="center">
						Type
					</td>
					<td width="40" align="center">
						No
					</td>
					<td width="300" align="center">
						Title
					</td>
				</tr>
				<c:forEach items="${boardList}" var="list">
				
					<tr>
						<td align="center">
							${list.boardAsType}
							<%-- <input type="hidden" name="boardType" value="${list.boardType}"> --%>
						</td>
						<td>
							${list.boardNum}
						</td>
						<td>
						
							<a href = "/board/${list.boardType}/${list.boardNum}/boardView.do?pageNo=${pageNo}">${list.boardTitle}</a>
							
						</td>
					</tr>	
				</c:forEach>
			</table>
		</td>
	</tr>
	<%if(userId==null){ %>	<!-- 로그인 아닐시 -->
	<tr>
		<td align="right">
			<a href ="/user/userLogin.do">로그인</a>
			<a href="/user/userJoin.do">회원가입</a>
		</td>
	</tr>
	<%}else {%>
		<tr>
		<td align="right">
			<a href ="/board/boardWrite.do">글쓰기</a>
			<a href="/user/userLogout.do">로그아웃</a>
		</td>
	</tr>
	<%} %>
</table>	
<!-- <script type="text/javascript">
	function typeCheckBox(){
		var comType=new Array();
			comType=${comType};
		if(comType=null){
			for(index=0;index<=${comType}.size();index++){
			document.write("<td><input type='checkbox' class='chk' name='chk' id='chk' onclick='acheck()' value='${comType.get(i)}'>${comName.get(i)}</td>");
			}
		}
	}
</script> -->
<form name="boardTypeSel" action="/board/boardList.do" method="get">
<table align='center'>
<tr>
	<td><input type="checkbox" name="chkAll" id="chkAll" onclick="check();">전체</td>
	<c:forEach	var="item" items="${comType}" varStatus="status">
	<td><input type="checkbox" class="chk" name="chk" id="chk" onclick="acheck()" value="${item}">${comName[status.index]}</td>
	</c:forEach>
	<td><input type="submit" value='조회'>
	
	
	</tr>
</table>

</form>
<!-- 페이징 -->
	<script type="text/javascript">
	
	function paging(){
		var totalCnt=${totalCnt};
		var currentPage=1;
		var totalPage=Math.ceil(totalCnt/10);
		var pageCount=5;
		var pageGroup=Math.ceil(totalPage/pageCount);
		
		document.write("<table align='center'><tr>")
		
		 for(var i=1;i<=totalPage;i++){
			document.write("<td><a href='/board/boardList.do?pageNo="+i+"'>"+i+"</a>");
		}
		document.write("</tr></table>");
		
	}
		paging();
	</script>
	
</body>
</html>