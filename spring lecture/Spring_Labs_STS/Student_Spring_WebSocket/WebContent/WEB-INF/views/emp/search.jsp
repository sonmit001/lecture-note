<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="resultdelete" value="${requestScope.resultdelete}"></c:set>
<c:set var="emplist" value="${requestScope.emplist}"></c:set>
<div id="contents">
	<div id="section1">
		<div class="container">
			<div class="sec1" style="padding-top: 100px">
				<h1>EMP LIST</h1>
				<div style="margin-bottom: 15px">
					<label>특정 사원 검색</label>
					<form action="searchEmp.htm" method="post">
						<select id="selectsearch"
							style="color: black; padding: 3px; font-size: 12pt">
							<option>이름</option>
							<option>부서</option>
						</select> <input type="hidden" id="searchtype" name="searchtype"
							value="ename"> <input type="text" id="search"
							name="search"> <input type="submit" value="검색">
					</form>

					<form action="multiSearchEmp.htm" method="post">
						<input type="checkbox" name="ename" value="ename" checked>이름
						<input type="checkbox" name="deptno" value="deptno">부서 <input
							type="checkbox" name="empno" value="empno">사번 <br>
						검색어:<input type="text" name="keyvalue"> <input
							type="submit" value="검색">
					</form>

				</div>
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
							<td><a href='empupdate.htm?empno=${emp.empno}&cp=${cpage}'
								class="btn btn-success">수정</a></td>
							<td><a href='empdelete.htm?empno=${emp.empno}'
								class="btn btn-danger">삭제</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="10" align="center"><c:if test="${cpage>1}">
								<a href="index.htm?cpstr=${cpage-1}">이전</a>
								<!--페이지 리스트 구현  -->
							</c:if> <c:forEach var="i" begin="1" end="${pagecount}" step="1">
								<c:choose>
									<c:when test="${cpage==i}">
										<font color='red'>[${i}]</font>
									</c:when>
									<c:otherwise>
										<a href="index.htm?cpstr=${i}">[${i}]</a>
									</c:otherwise>
								</c:choose>
							</c:forEach> <!--다음 링크 --> <c:if test="${cpage<pagecount}">

								<a href="index.htm?cpstr=${cpage+1}">다음</a>
							</c:if></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>
