<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : UserRegistration
    Created on : 2008. 6. 23, 오전 1:12:33
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
                        <webuijsf:label for="userTypeRadioButtonGroup" id="label1" style="height: 24px; left: 56px; top: 88px; position: absolute; width: 144px" text="사용자 유형:"/>
                        <webuijsf:radioButtonGroup binding="#{lms$user$member$UserRegistration.userTypeRadioButtonGroup}" columns="3"
                            id="userTypeRadioButtonGroup" items="#{lms$user$member$UserRegistration.userTypeRadioButtonGroupDefaultOptions.options}" onClick=""
                            required="true" style="height: 24px; left: 224px; top: 88px; position: absolute; width: 288px" tabIndex="1" valueChangeListenerExpression="#{lms$user$member$UserRegistration.typeRadioButtonGroup_processValueChange}"/>
                        <webuijsf:label for="nameTextField" id="label2" style="height: 24px; left: 56px; top: 192px; position: absolute; width: 144px" text="이름:"/>
                        <webuijsf:textField binding="#{lms$user$member$UserRegistration.nameTextField}" id="nameTextField" required="true"
                            style="height: 24px; left: 224px; top: 192px; position: absolute; width: 288px" tabIndex="5"/>
                        <webuijsf:label for="phoneTextField" id="label3" style="height: 24px; left: 56px; top: 256px; position: absolute; width: 144px" text="전화번호:"/>
                        <webuijsf:textField binding="#{lms$user$member$UserRegistration.phoneTextField}" id="phoneTextField"
                            style="height: 24px; left: 224px; top: 256px; position: absolute; width: 288px" tabIndex="7"/>
                        <webuijsf:label for="deptTextField" id="label4" style="height: 24px; left: 56px; top: 336px; position: absolute; width: 144px" text="소속 부서:"/>
                        <webuijsf:textField binding="#{lms$user$member$UserRegistration.deptTextField}" id="deptTextField"
                            style="height: 24px; left: 224px; top: 336px; position: absolute; width: 288px" tabIndex="10"/>
                        <webuijsf:label for="idTextField" id="label5" style="height: 24px; left: 56px; top: 112px; position: absolute; width: 144px" text="사용자 아이디:"/>
                        <webuijsf:textField binding="#{lms$user$member$UserRegistration.idTextField}" id="idTextField" required="true"
                            style="height: 24px; left: 224px; top: 112px; position: absolute; width: 288px" tabIndex="2"/>
                        <webuijsf:label for="addressTextField" id="label6" style="height: 24px; left: 56px; top: 280px; position: absolute; width: 144px" text="주소"/>
                        <webuijsf:staticText id="staticText1" style="height: 48px; left: 56px; top: 16px; position: absolute; width: 456px"
                            styleClass="page-title" text="도서관 사용자 등록 화면"/>
                        <webuijsf:button actionExpression="#{lms$user$member$UserRegistration.registerButton_action}" id="registerButton"
                            style="height: 24px; left: 79px; top: 376px; position: absolute; width: 120px" tabIndex="11" text="사용자 등록"/>
                        <webuijsf:messageGroup id="msgGroup" style="height: 216px; left: 536px; top: 88px; position: absolute; width: 168px"/>
                        <webuijsf:label for="password1TextField" id="label9" style="height: 24px; left: 56px; top: 136px; position: absolute; width: 144px" text="사용자 암호:"/>
                        <webuijsf:textField binding="#{lms$user$member$UserRegistration.password1TextField}" id="password1TextField" required="true"
                            style="height: 24px; left: 224px; top: 136px; position: absolute; width: 288px" tabIndex="3"/>
                        <webuijsf:textField binding="#{lms$user$member$UserRegistration.password2TextField}" id="password2TextField" required="true"
                            style="height: 24px; left: 224px; top: 160px; position: absolute; width: 288px" tabIndex="4"/>
                        <webuijsf:textField binding="#{lms$user$member$UserRegistration.addressTextField}" id="addressTextField"
                            style="height: 24px; left: 224px; top: 280px; position: absolute; width: 288px" tabIndex="8"/>
                        <webuijsf:label id="label7" style="height: 24px; left: 56px; top: 224px; position: absolute; width: 144px" text="전자우편주소:"/>
                        <webuijsf:textField binding="#{lms$user$member$UserRegistration.emailTextField}" id="emailTextField"
                            style="height: 24px; left: 224px; top: 224px; position: absolute; width: 288px" tabIndex="6"/>
                        <webuijsf:label id="label8" style="position: absolute; left: 56px; top: 312px; width: 144px; height: 24px" text="소속 기관:"/>
                        <webuijsf:textField binding="#{lms$user$member$UserRegistration.organizationTextField}" id="organizationTextField"
                            style="position: absolute; left: 224px; top: 312px; width: 288px; height: 24px" tabIndex="9"/>
                        <webuijsf:hyperlink id="hyperlink1" style="position: absolute; left: 344px; top: 376px; width: 168px; height: 32px" tabIndex="12"
                            text="사용자 관리 메인 화면" url="/faces/lms/user/member/UserList.jsp"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
