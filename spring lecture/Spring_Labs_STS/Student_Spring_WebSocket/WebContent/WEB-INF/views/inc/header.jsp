<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li class="active"><a href="index.htm">HOME</a></li>
			<li><a href="<%=request.getContextPath()%>/index.htm">EMP
					List</a></li>
			<li><a href="<%=request.getContextPath()%>/joinEmp.htm">JOIN
					Emp</a></li>
			<li><a href="<%=request.getContextPath()%>/searchEmp.htm">SEARCH
					Emp</a></li>
		</ul>
	</div>
</nav>