<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
        <!-- ******Join Section****** --> 
        <section class="login-section access-section section">
            <div class="container">
                <div class="row">
                    <div class="form-box col-md-offset-3 col-sm-offset-0 xs-offset-0 col-xs-6 col-md-6">     
                        <div class="form-box-inner">
                            <h2 class="title text-center">Join into Team4</h2>                 
                            <div class="row">
                                <div class="form-container col-md-offset-2 col-xs-12 col-md-8">
                                    <form class="login-form" method="post">              
                                        <div class="form-group email">
                                            <label class="sr-only" for="login-email">아이디</label>
                                            <input id="userid" name="userid" type="text" class="form-control login-email" placeholder="id">
                                        </div><!--//form-group-->
                                        <div class="form-group password">
                                            <label class="sr-only" for="login-password">비밀번호</label>
                                            <input id="password" name="password" type="password" class="form-control login-password" placeholder="Password">
                                        </div>
                                        <div class="form-group text">
                                        	<label class="sr-only" for="login-name">사랑의 서약</label>
                                        	<input id="nickname" name="nickname" type="text" class="form-control login-text" value="보람4조" readonly="readonly">
                                        </div><!--//form-group-->
                                        <button type="submit" class="btn btn-block btn-cta-primary">Join</button> 
                                    </form>
                                </div><!--//form-container-->
                            </div><!--//row-->
                        </div><!--//form-box-inner-->
                    </div><!--//form-box-->
                </div><!--//row-->
            </div><!--//container-->
        </section><!--//contact-section-->
    </div><!--//upper-wrapper-->