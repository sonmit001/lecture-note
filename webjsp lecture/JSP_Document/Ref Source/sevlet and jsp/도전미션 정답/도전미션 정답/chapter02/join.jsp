<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> ȸ�� ���� </title>
<style type="text/css">
label {
	width:160px;
	display: inline-block;
	float: left;
}
#button{
	text-align: center;
}
</style> 
<script type="text/javascript">

	function check_ok() {
		if (document.reg_frm.name.value.length == 0) {
			alert("�̸���  ���ּ���.");
			reg_frm.name.focus();
			return false;
		}
		if (document.reg_frm.jumin_1.length == 6) {
			alert("�ֹι�ȣ 6�����̾�� �մϴ�.");
			reg_frm.jumin_1.focus();
			return false;
		}
		if (document.reg_frm.jumin_2.length == 7) {
			alert("�ֹι�ȣ 7�����̾�� �մϴ�.");
			reg_frm.jumin_2.focus();
			return false;			
		}
		if (document.reg_frm.id.value.length == 0) {
			alert("���̵� ���ּ���");
			reg_frm.id.focus();
			return false;
		}
		
		if (document.reg_frm.id.value.length < 4) {
			alert("���̵�� 4�����̻��̾�� �մϴ�.");
			reg_frm.id.focus();
			return false;
		}
		
		if (document.reg_frm.pwd.value == "") {
			alert("�н������ �ݵ�� �Է��ؾ� �մϴ�.");
			reg_frm.pwd.focus();
			return false;
		}
		//��й�ȣ Ȯ�ΰ���� ������ üũ 
		if (document.reg_frm.pwd.value != document.pwd_re.value) {
			alert("�н����尡 ��ġ���� �ʽ��ϴ�.");
			reg_frm.pwd_re.focus();
			return false;
		}

		return true;
	}
</script>
</head>
<body>
<form name="frm" id="reg_frm" action="JoinServlet">
   <label for="name"> �̸� </label><span style="color:red;"> * </span> 
   <input type="text" id="name" name="name" value="������"> <br>
  
   <label>�ֹε�Ϲ�ȣ  </label><span style="color:red;"> * </span>
   <input type="text" name="jumin_1" value="890719"> - 
   <input type="password" name="jumin_2" value="2012123"> <br>
   
   <label for="id"> ���̵�  </label><span style="color:red;"> * </span>
   <input type="text" id="id" name="id" value="pinksung"><br>
    
    <label for="pwd"> ��й�ȣ </label><span style="color:red;"> * </span> 
    <input type="password" id="pwd" name="pwd" value="1234"><br>
    
    <label for="pwd_re"> ��й�ȣ Ȯ��  </label><span style="color:red;"> * </span>
    <input type="password" id="pwd_re" name="pwd_re" value="1234"><br>
    
    <label for="email">�̸��� </label> &nbsp;
    <input type="text" name="email" value="pinksung"> @ 
    <input type="text" name="email_dns" value="">
    <select name="emailaddr">
        <option value="">�����Է�</option>
        <option value="daum.net">daum.net</option>
        <option value="empal.com">empal.com</option>
        <option value="gmail.com">gmail.com</option>
        <option value="hanmail.net">hanmail.net</option>
        <option value="msn.com">msn.com</option>
        <option value="naver.com">naver.com</option>
        <option value="nate.com" selected="selected">nate.com</option>                
    </select><br>    
    
    <label for="zip">�����ȣ</label> &nbsp;
    <input type="text" id="zip" name="zip" value="321-212"><br>
           
    <label for="addr1">�ּ�</label> &nbsp;
    <input type="text" id="addr1" name="addr1"  value="����� ���ı� ���2��">
    <input type="text" name="addr2" value="���� ����Ʈ 201�� 1203ȣ"><br>
    
    <label for="phone">�ڵ�����ȣ</label>  &nbsp;
    <input type="tel" id="phone" name="phone" value="010-2321-2312"><br>
    
    <label for="job">����</label>  &nbsp;
    <select id="job" name="job" size="3">  
       <option value="�л�">�л�</option> 
       <option value="��ǻ��/���ͳ�">��ǻ��/���ͳ�</option> 
       <option value="���">���</option> 
       <option value="������" selected="selected">������</option> 
       <option value="����">����</option> 
       <option value="���񽺾�">���񽺾�</option> 
       <option value="����">����</option> 
    </select><br>
    
    <label for="chk_mail">����/SMS ���� ����</label>  &nbsp;
    <input type="radio" id="chk_mail" name="chk_mail" checked> ���� 
    <input type="radio" id="chk_mail" name="chk_mail"> ���Űź�<br>

    <label for="interest">���ɺо�</label>  &nbsp;
      <input type="checkbox" id="interest" name="interest" value="����"> ����         
      <input type="checkbox" id="interest" name="interest" value="����" checked> ����         
      <input type="checkbox" id="interest" name="interest" value="�ν���"> �ν���         
      <input type="checkbox" id="interest" name="interest" value="�ڵ�帳" checked> �ڵ�帳         
      <input type="checkbox" id="interest" name="interest" value="����������" checked> ����������         
      <input type="checkbox" id="interest" name="interest" value="â��"> â��<br><br>
    
 <div id="button">
    <input type="submit" value="ȸ������" onclick="return check_ok()">
    <input type="reset" value="���">
 </div>
</form>
</body>
</html>