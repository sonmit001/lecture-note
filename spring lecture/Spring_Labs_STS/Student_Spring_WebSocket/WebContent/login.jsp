<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>   
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.1/animate.css">

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well login-box">
                <form action="login.htm" method="post">
                    <legend>Login</legend>
                    <div class="form-group">
                        <label for="username-email">Ename</label>
                        <input id="empno" name="id"  placeholder="Please enter your ID" type="text" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="password">Empno</label>
                        <input id="deptno" name="pw"  placeholder="Please enter your Paasword" type="text" class="form-control" />
                    </div>
                    <div class="form-group text-center">
                        <button class="btn btn-danger btn-cancel-action">Cancel</button>
                        <input type="submit" class="btn btn-success btn-login-submit" value="login" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>