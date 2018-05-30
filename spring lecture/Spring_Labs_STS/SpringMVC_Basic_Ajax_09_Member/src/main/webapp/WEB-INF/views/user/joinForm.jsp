<%@ include file="../include/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript" src="<c:url value="/resources/js/joinCheck.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/joinAjaxData.js"/>"></script>
<script type="text/javascript">
var closePopup = function() {
	$('#joinMask',parent.document).hide();
	$('#mask',parent.document).hide();
}
</script>
<body>
<table width="100%" height="10">
	<tr>
		<td align="right">
			<a href="javascript:closePopup();">
				<img alt="창닫기" src="/web/resources/img/close_btn.gif" style="border: 0">
			</a>
		</td>
	</tr>
</table>
 <form method="post"> 
    <fieldset> 
        <legend><font size="4" style="font-weight: bolder; color:#ABF200; ">회원가입</font></legend> 
        <table id="member_wrap"> 
            <tbody> 
                <tr> 
                    <td class="lb">* 아이디</td> 
                    <td><input type="text" id="id" name="id" style="width: 130px;" value="" /></td>
                    <td></td> 
                </tr> 
                <tr> 
                    <td class="lb">* 비밀번호</td> 
                    <td><input type="password" id="password" name="password" style="width: 130px;" value=""/></td>
                    <td></td> 
                </tr> 
                <tr> 
                    <td class="lb">* 비밀번호 확인</td> 
                    <td><input type="password" id="password2" name="password2" style="width: 130px;" onkeyup="javascript:passwordCheck()" value=""/></td>
                    <td id="passwordCheckTD"></td> 
                </tr> 
                 <tr> 
                    <td class="lb">* 이름</td> 
                    <td><input type="text" id="name" name="name" style="width: 130px;" value=""/></td>
                    <td></td> 
                </tr> 
                <tr> 
                    <td class="lb">* 이메일</td> 
                    <td><input type="text" id="email" name="email" style="width: 130px;" value=""/></td>
                    <td></td> 
                </tr> 
            </tbody> 
        </table> 
    </fieldset> 
	<table cellpadding="0" cellspacing="0" align="center">
		<tr height="5px"><td></td></tr>
		<tr>
			<td>
				<input  type="button" value="가입" tabindex="3" onclick="ajaxPostSend();"
				 style="width: 100px; height: 30px; border-color: #FFFFFF; background-color:#8C8C8C ;
				 font-size: 15pt;font-weight: bold ;font-family: 굴림; color: #FFFFFF; vertical-align:middle; text-align: center;">
				 <input  type="button" value="취소" tabindex="3" onclick="javascript:closePopup()"
				 style="width: 100px; height: 30px; border-color: #FFFFFF; background-color:#8C8C8C ;
				 font-size: 15pt;font-weight: bold ;font-family: 굴림; color: #FFFFFF; vertical-align:middle; text-align: center;">
			</td>
		</tr>
	</table>   
</form> 
</body>
</html>
