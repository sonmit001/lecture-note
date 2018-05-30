<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content">
	<form action="" method="post">
		<h2>수정하기</h2>
		<h3 class="hidden">방문페이지 로그</h3>
		
		<h3 class="hidden">수정하기 폼</h3>
		<div id="join-form" class="join-form margin-large">
			<dl class="join-form-row">
				<dt class="join-form-title">아이디</dt>
				<dd class="join-form-data">
					<input type="text" name="userid" value="${member.userid }" readonly/> 
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">비밀번호</dt>
				<dd class="join-form-data">
					<input type="password" name="pwd"/>
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">비밀번호 확인</dt>
				<dd class="join-form-data">
					<input type="password" name="pwd2" />
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">이름</dt>
				<dd class="join-form-data">
					<input type="text" name="name"  value="${member.name}"/>
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">성별</dt>
				<dd class="join-form-data">
					<input type="text" name="gender"  value="${member.gender}" readonly/>
				</dd>
			</dl>
			<dl class="join-form-row birthday">
				<dt class="join-form-title">생년월일</dt>
				<dd class="join-form-data">
					<input type="text" name="birth"  value="${member.birth}" readonly/>
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">이메일</dt>
				<dd class="join-form-data">
					<input type="text" name="email"   value="${member.email}"/>
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">취미</dt>
				<dd class="join-form-data">
					<input type="text" name="habit"   value="${member.habit}"/>
				</dd>
			</dl>
		</div>
		<div id="buttonLine">
			<input class="btn-okay button" type="submit" value="수정하기" />
		</div>
	</form>
</div>
