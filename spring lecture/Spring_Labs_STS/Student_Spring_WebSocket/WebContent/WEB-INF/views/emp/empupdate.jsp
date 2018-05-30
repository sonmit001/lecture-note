<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link
   href="https://fonts.googleapis.com/css?family=BioRhyme|Bungee+Hairline|Cinzel:700|Cookie|Great+Vibes|Josefin+Slab:300|Julius+Sans+One|Lobster|Luckiest+Guy|Macondo|Orbitron|Paytone+One|Poiret+One|Sacramento|Tangerine"
   rel="stylesheet">
<c:set var="resultdelete" value="${requestScope.resultdelete}"></c:set>
<c:set var="emplist" value="${requestScope.emplist}"></c:set>

<script src="http://code.jquery.com/jquery-2.1.1.js"></script>
<c:set var="empno" value="${param.empno}" />
<c:set var="ename" value="${param.ename}" />
<c:set var="job" value="${param.job}" />
<c:set var="mgr" value="${param.mgr}" />
<c:set var="hiredate" value="${param.hiredate}" />
<c:set var="sal" value="${param.sal}" />
<c:set var="comm" value="${param.comm}" />
<c:set var="deptno" value="${param.deptno}" />
<div id="contents">
   <div id="section1">
      <div class="container">
         <div class="sec1" style="padding-top: 100px">
            <h1>EMP UPDATE</h1>
            <spring:hasBindErrors name="emp"></spring:hasBindErrors>
            <form action="<%= request.getContextPath() %>/editEmp.htm"
               method="post">
               <table class="table table-bordered">
                  <tr>
                     <th style="width: 20%">사번</th>
                     <td><input type="text" id="empno" name="empno"
                        value="${empno}" readonly="readonly">
                        </td>
                  </tr>
                  <tr>
                     <th>이름</th>
                     <td><input type="text" id="ename" name="ename"
                        value="${ename}">
                     <form:errors path="emp.ename"/>   
                     </td>
                  </tr>
                  <tr>
                     <th>직종</th>
                     <td><input type="text" id="job" name="job" value="${job}">
                     <form:errors path="emp.job"/>   
                     </td>
                  </tr>
                  <tr>
                     <th>상사번호</th>
                     <td><input type="text" id="mgr" name="mgr" value="${mgr}">
                     <form:errors path="emp.mgr"/>   
                     </td>
                  </tr>
                  <tr>
                     <th>입사일</th>
                     <td><input type="text" id="hiredate" name="hiredate"
                        value="${hiredate}" readonly="readonly">
                     </td>
                  </tr>
                  <tr>
                     <th>급여</th>
                     <td><input type="text" id="sal" name="sal" value="${sal}">
                     <form:errors path="emp.sal"/>   
                     </td>
                  </tr>
                  <tr>
                     <th>수당</th>
                     <td><input type="text" id="comm" name="comm" value="${comm}">
                     <form:errors path="emp.comm"/>   
                     </td>
                  </tr>
                  <tr>
                     <th>부서번호</th>
                     <td><input type="text" id="deptno" name="deptno"
                        value="${deptno}">
                     <form:errors path="emp.deptno"/>   
                     </td>
                  </tr>
               </table>

               <p style="text-align: center">
                  <input type="submit" value="수정" class="btn btn-default">
               </p>
            </form>

         </div>
      </div>
   </div>
</div>
