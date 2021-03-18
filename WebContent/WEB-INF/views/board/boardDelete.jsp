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
	var delCnt = ${delCnt}
	 if(delCnt>0){
		alert("삭제 되었습니다")
		location.href = "/board/boardList.do?pageNo=1";
	}
	else{
		alert("이미 삭제된 글입니다")
		location.href="/board/boardList.do?pageNo=1";
	} 
	
</script>
<body>
<form class="boardDelete">
	
	<!-- <a href="/board/boardList.do">이미 삭제된 글 입니다 List로 가기</a> -->

	
</form>	
</body>
</html>