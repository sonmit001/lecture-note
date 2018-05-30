<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
        <!-- ******Login Section****** --> 
        <section class="login-section access-section section">
            <div class="container">
                <div class="row">
                    <div class="form-box col-md-offset-3 col-sm-offset-0 xs-offset-0 col-xs-6 col-md-6">     
                        <div class="form-box-inner">
                            <h2 class="title text-center">Log in to Team4</h2>
                            <div class="row">
                                <div class="form-container col-md-offset-3 col-xs-12 col-md-6">
                                	<c:url value="/login" var="loginurl" />
                                    <form class="login-form" action="${loginurl}" method="post">              
                                        <div class="form-group email">
                                            <label class="sr-only" for="login-email">Email</label>
                                            <input id="userid" name="userid" type="text" class="form-control login-email" placeholder="Email">
                                        </div><!--//form-group-->
                                        <div class="form-group password">
                                            <label class="sr-only" for="login-password">Password</label>
                                            <input id="password" name="password" type="password" class="form-control login-password" placeholder="Password">
                                            <p class="forgot-password"><a href="reset-password.html">비밀번호 찾기</a></p>
                                        </div><!--//form-group-->
                                        <button type="submit" class="btn btn-block btn-cta-primary">Log in</button>
                                         <p class="lead">아직 회원이 아니시라면 <br /><a class="signup-link" href="join.htm">회원가입</a></p>  
                                    </form>
                                </div><!--//form-container-->
                            </div><!--//row-->
                        </div><!--//form-box-inner-->
                    </div><!--//form-box-->
                </div><!--//row-->
            </div><!--//container-->
        </section><!--//contact-section-->
    </div><!--//upper-wrapper-->