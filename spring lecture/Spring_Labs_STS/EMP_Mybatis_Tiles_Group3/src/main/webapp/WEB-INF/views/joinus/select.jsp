<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
		.col-md-6{
			margin-bottom : 20px;
		}
	
            input[type=text]{
                width: 100%
            }

	</style>
</head>
<body>
	<div style="margin-top: 30px !important;">
		사번으로 검색 : <input class=""type="text" id="search_empno" style="width:100px">
			<input class="btn btn-primary" type="button" id="empno_btn" value="검색">
			<input class="btn btn-primary" type="button" id="emp_btn" value="전체검색"  onclick="listgo()">
			<input class="btn btn-primary" data-toggle="modal" data-target="#myModal1" type="button" id="mamodal1" value="추가">
			
			<div id="myModal1" class="modal fade" role="dialog" >
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">추가하기</h4>
							</div>
							<form action="insert.htm">
								<div class="form-group">
									<div class="form-row">
										<div class="col-md-6">
											<label for="exampleInputName">empno</label> <input
												class="form-control" name="empno" type="text"
												placeholder="Enter empno">
										</div>
										<div class="col-md-6">
											<label for="exampleInputLastName">ename</label> <input
												class="form-control" name="ename" type="text"
												placeholder="Enter ename">
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="form-row">
										<div class="col-md-6">
											<label for="exampleInputEmail1">job</label> <input
												class="form-control" name="job" type="text"
												placeholder="Enter job">
										</div>
										<div class="col-md-6">
											<label for="exampleInputPassword1">mgr</label> <input
												class="form-control" name="mgr" type="text"
												placeholder="Enter mgr">
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="form-row">
										<div class="col-md-6">
											<label for="exampleConfirmPassword">hiredate</label> <input
												class="form-control" name="hiredate" type="text"
												placeholder="Enter hiredate">
										</div>
										<div class="col-md-6">
											<label for="exampleInputPassword1">sal</label> <input
												class="form-control" name="sal" type="text"
												placeholder="Enter sal">
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="form-row">
										<div class="col-md-6">
											<label for="exampleConfirmPassword">comm</label> <input
												class="form-control" name="comm" type="text"
												placeholder="Enter comm">
										</div>
										<div class="col-md-6">
											<label for="exampleInputPassword1">deptno</label> <input
												class="form-control" name="deptno" type="text"
												placeholder="Enter deptno">
										</div>
									</div>
								</div>
								
								<input type="submit" value="추가하기" class="btn btn-primary btn-block">
			
							</form>
						</div>
					</div>
				</div>
			</div>
	

		<div class="table-responsive" style="text-align: center; margin-top: 30px !important;">
		<form action="update.htm" method="post">
		<table class="table  table-striped table-bordered table-hover">
		<tbody>
			<th>EMPNO</th>
			<th>ENAME</th>
			<th>JOB</th>
			<th>MGR</th>
			<th>HIREDATE</th>
			<th>SAL</th>
			<th>COMM</th>
			<th>DEPTNO</th>
			<th>수정하기</th>
			<th>삭제하기</th>
	   </tbody>
				
					<tr>
						<td>${employ.empno}</td>
						<td>${employ.ename}</td>
						<td>${employ.job}</td>
						<td>${employ.mgr}</td>
						<td>${employ.hiredate}</td>
						<td>${employ.sal}</td>
						<td>${employ.comm}</td>
						<td>${employ.deptno}</td>
						<td><a class="btn btn-info" type="button" onclick="edit(this, ${emp.empno}, '${emp.ename}', '${emp.job}', ${emp.mgr}, '${emp.hiredate}', ${emp.sal}, ${emp.comm}, ${emp.deptno})">수정하기</a></td>
						<td><a href="delete.htm?empno=${employ.empno}" class="btn btn-danger" type="button">삭제하기</a></td>
					</tr>
		</table>
		</form>
		</div>
</body>
<script type="text/javascript">
$("#empno_btn").click(function () {
    console.log("안녕")
    console.log($("#search_empno").val());
    if($("#search_empno").val()==""){
        alert("사번을 입력해주세요")
}else{
    location.href="select.htm?empno="+$('#search_empno').val();
}
})
        function listgo(){location.href="emp.htm"};
        
        function edit(obj, empno, ename, job, mgr, hiredate, sal, comm, deptno) {
            var htmlString = '<td><input type=text name="empno" value="'+empno+'" readonly></td><td><input type=text name="ename" value="'+ename+'"></td>'
                            +'<td><input type=text name="job" value="'+job+'"></td><td><input type=text name="mgr" value="'+mgr+'"></td>'
                            +'<td><input type=text name="hiredate" value="'+hiredate+'"></td><td><input type=text name="sal" value="'+sal+'"></td>'
                            +'<td><input type=text name="comm" value="'+comm+'"></td><td><input type=text name="deptno" value="'+deptno+'"></td>'
                            +'<td><input type="submit" class="btn btn-success" value="완료"></td>';
            $(obj).closest("tr").html(htmlString);
        };
     </script>
</html>