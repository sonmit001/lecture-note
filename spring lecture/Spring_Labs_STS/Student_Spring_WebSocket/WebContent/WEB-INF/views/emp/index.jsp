<%@page import="kr.or.kosta.dto.emp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="https://fonts.googleapis.com/css?family=BioRhyme|Bungee+Hairline|Cinzel:700|Cookie|Great+Vibes|Josefin+Slab:300|Julius+Sans+One|Lobster|Luckiest+Guy|Macondo|Orbitron|Paytone+One|Poiret+One|Sacramento|Tangerine"
	rel="stylesheet">

<c:set var="cpage" value="${requestScope.cpage}"></c:set>
<c:set var="pagecount" value="${requestScope.pagecount}" />

		<div class="container">
				<a href="javascript:popupOpen();" class="btn btn-default" > echo 카톡 문의 </a>
				<a href="javascript:popupOpen2();" class="btn btn-default" > 카톡 문의 </a>
				<h1>EMP LIST</h1>
				<table class="table">
					<tr>
						<th>사번</th>
						<th>이름</th>
						<th>직종</th>
						<th>상사번호</th>
						<th>&nbsp;입사일&nbsp;</th>
						<th>월급</th>
						<th>수당</th>
						<th>부서번호</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
					<c:forEach var="emp" items="${list}">
						<tr>
							<td>${emp.empno}</td>
							<td>${emp.ename}</td>
							<td>${emp.job}</td>
							<td>${emp.mgr}</td>
							<td>${emp.hiredate}</td>
							<td>${emp.sal}</td>
							<td>${emp.comm}</td>
							<td>${emp.deptno}</td>
							<td><a
								href='editEmp.htm?empno=${emp.empno}&ename=${emp.ename}&job=${emp.job}&mgr=${emp.mgr}&hiredate=${emp.hiredate}&sal=${emp.sal}&comm=${emp.comm}&deptno=${emp.deptno}'
								class="btn btn-success">수정</a></td>
							<td><a href='delEmp.htm?empno=${emp.empno}'
								class="btn btn-danger">삭제</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="10" align="center"><c:if test="${cpage>1}">
								<a href="index.htm?cpage=${cpage-1}">이전</a>
								<!--페이지 리스트 구현  -->
							</c:if> <c:forEach var="i" begin="1" end="${pagecount}" step="1">
								<c:choose>
									<c:when test="${cpage==i}">
										<font color='red'>[${i}]</font>
									</c:when>
									<c:otherwise>
										<a href="index.htm?cpage=${i}">[${i}]</a>
									</c:otherwise>
								</c:choose>
							</c:forEach> <!--다음 링크 --> <c:if test="${cpage<pagecount}">
								<a href="index.htm?cpage=${cpage+1}">다음</a>
							</c:if></td>
					</tr>
				</table>
			</div>