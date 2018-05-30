<%@ include file="../include/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<link href="<c:url value="/resources/css/joinCss.css"/>"  rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/loading.css"/>"  rel="stylesheet" type="text/css">
<script type="text/javascript" src="<c:url value="/resources/js/joinMask.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/loading.js"/>"></script>
<script type="text/javascript">
	var loginSubmit = function(){
		
		if($('#id').val() == "")
		{
			alert("아이디를 입력해주세요");
			$('#id').focus();
			return;
		}
		else if($('#password').val() == "") 
		{
			alert("비밀번호를 입력해주세요");
			$('#id').focus();
			return;
		}
		
		$('#submitForm').attr('action','login.blog').submit();
		return;
		
	} 
</script>
<div id="loadingImage"><img src="<c:url value="/resources/img/loading.gif"/>"></div>
<div id="loadingMask"></div>
<div id="mask"></div>
<div id="joinMask" >
	<iframe id="joinIFrame" src="" name="joinIFrame" width="500" height="300" frameborder="0" leftmargin="0" topmargin="0"scrolling="no"></iframe>
</div> 
<form id="submitForm" name="submitForm" method="post">
	<table width="100%" height="30px" border="0" cellpadding="0px" cellspacing="0px" align="center">
		<tr>
			<td bgcolor="#FFFFFF" style="width: 20%; height: 30px;"></td>
			<td bgcolor="#FFFFFF" style="width: 60%; height: 30px;">
				<font size="5" style="font-weight: bolder; color:#BDBDBD; ">STUDY BLOG</font>
			</td>
			<td bgcolor="#FFFFFF" style="width: 20%; height: 30px;"></td>
		</tr>
	</table>
	<table width="100%" height="70" border="0" cellpadding="0px" cellspacing="0px">
		<tr><td bgcolor="#1DDB16" style="width: 100%; height: 5px;" colspan="3"></td></tr>
		<tr>
			<td bgcolor="#353535" style="width: 20%; height: 65px;"></td>
			<td bgcolor="#353535" style="width: 60%; height: 65px;">
				<font size="5" style="font-weight: bolder; color:#FFFFFF; ">회원></font>
				<font size="5" style="font-weight: bolder; color:#ABF200; ">로그인</font>
			</td>
			<td bgcolor="#353535" style="width: 20%; height: 65px;"></td>
		</tr>
		<tr><td bgcolor="#FFFFFF" style="width: 100%; height: 50px;" colspan="3"></td></tr>
	</table>
	
	<table width="60%" height="101px" border="0" cellpadding="0px" cellspacing="0px" align="center">
		<tr><td bgcolor="#1DDB16" style="width: 100%; height: 1px;"></td></tr>
		<tr><td bgcolor="#FFFFFF" style="width: 100%; height: 100px;"></td></tr>
	</table>
	
	
	<!--ID-->
	<table width="500px" height="50px" border="0" cellpadding="0px" cellspacing="0px" align="center">
		<tr>
			<td bgcolor="#FFFFFF" align="left" style="width: 120px; height: 50px;">
				<font size="5" style="font-weight: bolder; color:#4C4C4C; ">아이디</font>
			</td>
			<td bgcolor="#FFFFFF" style="width: 260; height: 50px;">
				<input type="text" name="id" id="id" value="" tabindex="1"
					style="border: 5px solid #ABF200; height: 30px; width: 250px; 
					font-size: 15pt;font-weight: bold ;font-family: 굴림; color: #BDBDBD; vertical-align:middle; text-align: center; margin: 0; padding:0; 
					outline: none;">
			</td>
			<td rowspan="2" bgcolor="#FFFFFF" align="right" style="width: 50px; height: 50px;">
				<input  type="button" value="GO!!" tabindex="3" id="loginBotton" onclick="loginSubmit()"
				 style="width: 94px; height: 94px; border-color: #FFFFFF; background-color:#4C4C4C ;
				 font-size: 15pt;font-weight: bold ;font-family: 굴림; color: #FFFFFF; vertical-align:middle; text-align: center;">
			</td>
		</tr>
		
		<!--PASSWORD-->
		<tr>
			<td bgcolor="#FFFFFF" align="left" style="width: 120px; height: 50px;">
				<font size="5" style="font-weight: bolder; color:#4C4C4C; ">비밀번호</font>
			</td>
			<td bgcolor="#FFFFFF" style="width: 260; height: 50px;">
				<input type="password" name="password" id="password" tabindex="2"
					style="border: 5px solid #ABF200; height: 30px; width: 250px; 
					font-size: 15pt;fon-weight: bold ;font-family: 굴림; color: #BDBDBD; vertical-align:middle; text-align: center; margin: 0; padding:0;
					outline: none;">
			</td>
		</tr>
		<tr>
			<td style="width: 500px; height: 50px;" colspan="3" >
				<table align="left">
					<tr>
						<td class="openMask"><font size="4" style="font-weight: bolder; color:#8C8C8C; "><a href="javascript:wrapWindowByMask();">회원가입</a></font></td>
						<td><font size="4" style="font-weight: bolder; color:#ABF200; ">|</font></td>
						<td><font size="4" style="font-weight: bolder; color:#8C8C8C; "><a href="javascript:wrapWindowByMask();">아이디/ 비밀번호 찾기</a></font></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	
	
	<table width="60%" height="251px" border="0" cellpadding="0px" cellspacing="0px" align="center">
		<tr><td bgcolor="#FFFFFF" style="width: 100%; height: 100px;"></td></tr>
		<tr><td bgcolor="#1DDB16" style="width: 100%; height: 1px;"></td></tr>
		<tr><td bgcolor="#FFFFFF" style="width: 100%; height: 150px;"></td></tr>
	</table>
	<table width="100%" height="100px" border="0" cellpadding="0px" cellspacing="0px" align="center">
		<tr><td bgcolor="#FFFFFF" style="width: 100%; height: 100px;"></td></tr>
	</table>
	<table width="100%" height="4px" border="0" cellpadding="0px" cellspacing="0px" align="center">
		<tr><td bgcolor="#BDBDBD" style="width: 100%; height: 1px;"></td></tr>
		<tr><td bgcolor="#FFFFFF" style="width: 100%; height: 3px;"></td></tr>
	</table>
</form>
</body>
</html>
<%@ include file="../include/bottom.jsp" %>