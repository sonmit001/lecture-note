<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><!-- form태그 사용위한 taglib -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link
	href="https://fonts.googleapis.com/css?family=BioRhyme|Bungee+Hairline|Cinzel:700|Cookie|Great+Vibes|Josefin+Slab:300|Julius+Sans+One|Lobster|Luckiest+Guy|Macondo|Orbitron|Paytone+One|Poiret+One|Sacramento|Tangerine"
	rel="stylesheet">
<c:set var="resultdelete" value="${requestScope.resultdelete}"></c:set>
<script type="text/javascript">
  	$(function(){
  		$('#hiredate').datepicker(
				{
					dateFormat:"yy-mm-dd",
					numberOfMonths:1,
				}		
			);
  		
  	});
</script>
<div id="contents">
	<div id="section1">
		<div class="container">
			<div class="sec1" id="emplist" style="padding-top: 80px">
				<h1>EMP Insert</h1>
				<h5>보너스빼고 null허용 안해요</h5>
				<div style="margin: 0 auto; width: 100%;">
				<spring:hasBindErrors name="emp"/>
				<form method="post">
						<div class="form-group row">
							<label class="col-sm-4" for="empno">사번:</label>
								<input class="col-sm-4" type="text" id="empno" name="empno" placeholder="" value="${emp.empno}">
								<form:errors path="emp.empno" class="col-sm-4"/>
							</div>
						<div class="form-group row">
							<label class="col-sm-4" for="ename">이름:</label>
								<input class="col-sm-4" type="text" id="ename" name="ename">
								<form:errors path="emp.ename" class="col-sm-4"/>
						</div>
						<div class="form-group row">
							<label class="col-sm-4" for="job">직종:</label>
								<input type="text" id="job" name="job" class="col-sm-4">
								<form:errors path="emp.job" class="col-sm-4"/>
						</div>
						<div class="form-group row">
							<label for="mgr" class="col-sm-4">사수:</label>
								<input type="text" id="mgr" name="mgr" class="col-sm-4">
								<form:errors path="emp.mgr" class="col-sm-4"/>
						</div>
						<div class="form-group row">
							<label for="hiredate" class="col-sm-4">입사일:</label>
								<input type="text" id="hiredate" name="hiredate" class="col-sm-4">
								<form:errors path="emp.hiredate" class="col-sm-4"/>
						</div>
						<div class="form-group row">
							<label for="sal" class="col-sm-4">급여:</label>
								<input type="text" id="sal" name="sal" class="col-sm-4">
								<form:errors path="emp.sal" class="col-sm-4"/>
						</div>
						<div class="form-group row">
							<label for="comm" class="col-sm-4">보너스:</label>
								<input type="text" id="comm" name="comm" class="col-sm-4">
						</div>
						<div class="form-group row">
							<label for="deptno" class="col-sm-4">부서번호:</label>
								<input type="text" id="deptno" name="deptno" class="col-sm-4">
								<form:errors path="emp.deptno" class="col-sm-4"/>
						</div>
						<div class="form-group row">
							<div class="col-sm-offset-5 col-sm-7">
								<input type="submit" value="등록" class="btn btn-default">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

