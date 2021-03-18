<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>boardWrite</title>
<script type="text/javascript">
	var idC=${resultId}
	var pwC=${resultPw}
	
	if(idC==0&&pwC==0){
		alert("id와 pw를 확인하세요");
		location.href="/user/userLogin.do";
	}else if(idC==0&&pwC==1){
		alert("id를 확인하세요");
		location.href="/user/userLogin.do";
	}else if(idC==1&&pwC==0){
		alert("pw를 확인하세요");
		location.href="/user/userLogin.do";
	}else if(idC==1&&pwC==1){
		alert("로그인 되었습니다.")
		location.href="/board/boardList.do";
	}
	
</script>
</head>

<script type="text/javascript">
	var resultCnt=${resultCnt};
	if(resultCnt=!null){
		alert("회원가입완료");
	}
</script>
<body>
<script type="text/javascript">
	$j(document).ready(function(){
		$j("userId").focus;
		$j("#submit").on("click", function(){
			if($j("#userId").val()==""){
				alert("id를 입력해 주세요")
				$j("userId").focus;
				return false;
			}
			if($j("#userPw").val()==""){
				alert("pw를 입력해 주세요")
				$j("userId").focus;
				return false;
			}
		})
	})

</script>
<form name="userLogin" action="/user/userLoginAction.do" method="post">
<table align="center" border='1'>
	<tr><a href="/user/userJoin.do">회원가입</a></tr>
	<tr>
		<td width='100'>ID</td>
		<td width='300'><input type="text" id="userId" name="userId"></td>
	</tr>
	
	<tr>
		<td>PW</td>
		<td><input type="password" id="userPw" name="userPw"></td>
		<td><input type="submit" id="submit" value="확인"></td>
	</tr>
</table>

</form>
</body>
</html>