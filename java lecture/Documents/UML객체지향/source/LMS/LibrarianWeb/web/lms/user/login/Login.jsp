<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Login
    Created on : 2008. 6. 24, 오전 2:04:40
    Author     : chae
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <webuijsf:label for="idTextField" id="label2" style="height: 24px; left: 32px; top: 144px; position: absolute; width: 144px" text="사용자 아이디:"/>
                        <webuijsf:textField binding="#{lms$user$login$Login.idTextField}" id="idTextField" required="true"
                            style="height: 24px; left: 200px; top: 144px; position: absolute; width: 288px" tabIndex="1"/>
                        <webuijsf:staticText binding="#{lms$user$login$Login.titleStaticText}" id="titleStaticText"
                            style="height: 48px; left: 32px; top: 24px; position: absolute; width: 456px" styleClass="page-title" text="사서 로그인 화면"/>
                        <webuijsf:label for="passwordPassword" id="label3" style="height: 24px; left: 32px; top: 168px; position: absolute; width: 144px" text="사용자 암호:"/>
                        <webuijsf:messageGroup binding="#{lms$user$login$Login.msgGroup}" id="msgGroup" style="height: 70px; left: 32px; top: 232px; position: absolute; width: 454px"/>
                        <webuijsf:button actionExpression="#{lms$user$login$Login.loginButton_action}" id="loginButton"
                            style="height: 24px; left: 87px; top: 208px; position: absolute; width: 120px" tabIndex="3" text="로그인"/>
                        <webuijsf:passwordField binding="#{lms$user$login$Login.passwordPassword}" id="passwordPassword" required="true"
                            style="left: 200px; top: 168px; position: absolute" tabIndex="2"/>
                        <webuijsf:button actionExpression="#{lms$user$login$Login.btnReset_action}" binding="#{lms$user$login$Login.btnReset}" id="btnReset"
                            style="left: 287px; top: 208px; position: absolute; width: 104px" tabIndex="4" text="원래대로"/>
                        <webuijsf:staticText id="staticText1" style="position: absolute; left: 32px; top: 88px; width: 464px; height: 24px" text="아이디/암호는 임의의 문자열을 입력해도 됩니다. 지금은 아이디/암호 확인을 하지 않습니다."/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
