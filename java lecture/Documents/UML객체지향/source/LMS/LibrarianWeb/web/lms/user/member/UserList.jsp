<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : UserList
    Created on : 2008. 6. 23, 오전 12:45:39
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
                        <webuijsf:staticText id="staticText1" style="height: 48px; left: 96px; top: 48px; position: absolute; width: 456px"
                            styleClass="page-title" text="도서관 사용자 관리 메인 화면"/>
                        <webuijsf:button actionExpression="#{lms$user$member$UserList.registerButton_action}" id="registerButton"
                            style="height: 24px; left: 311px; top: 192px; position: absolute; width: 96px" tabIndex="4" text="사용자 등록"/>
                        <webuijsf:label for="titleTextField" id="label2" style="height: 24px; left: 96px; top: 144px; position: absolute; width: 144px" text="이름:"/>
                        <webuijsf:textField binding="#{lms$user$member$UserList.nameTextField}" columns="40" id="nameTextField"
                            style="height: 24px; left: 264px; top: 144px; position: absolute; width: 288px" tabIndex="2"/>
                        <webuijsf:label id="label5" style="height: 24px; left: 96px; top: 120px; position: absolute; width: 144px" text="사용자 아이디:"/>
                        <webuijsf:textField binding="#{lms$user$member$UserList.idTextField}" id="idTextField"
                            style="height: 24px; left: 264px; top: 120px; position: absolute; width: 288px" tabIndex="1"/>
                        <webuijsf:button actionExpression="#{lms$user$member$UserList.searchButton_action}" id="searchButton"
                            style="height: 24px; left: 95px; top: 192px; position: absolute; width: 168px" tabIndex="3" text="사용자 검색"/>
                        <webuijsf:table augmentTitle="false" id="table1" style="left: 96px; top: 240px; position: absolute; width: 456px" title="사용자 검색 결과" width="456">
                            <webuijsf:tableRowGroup emptyDataMsg="해당되는 사용자가 없습니다" id="tableRowGroup1" rows="10" sourceData="#{SessionBean1.userDataProvider}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="유형" id="tableColumn1" width="20">
                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['userType']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="아이디" id="tableColumn2" width="50">
                                    <webuijsf:staticText binding="#{lms$user$member$UserList.searchedUserIDStaticText}" id="searchedUserIDStaticText" text="#{currentRow.value['id']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="이름" id="tableColumn3" width="80">
                                    <webuijsf:staticText binding="#{lms$user$member$UserList.searchedUserNameStaticText}" id="searchedUserNameStaticText" text="#{currentRow.value['name']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="부서" id="tableColumn4" width="100">
                                    <webuijsf:staticText id="staticText5" text="#{currentRow.value['dept']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="전화" id="tableColumn5" width="100">
                                    <webuijsf:staticText id="staticText6" text="#{currentRow.value['phone']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn binding="#{lms$user$member$UserList.tableColumn6}" headerText="삭제" id="tableColumn6">
                                    <webuijsf:button actionExpression="#{lms$user$member$UserList.removeButton_action}"
                                        binding="#{lms$user$member$UserList.removeButton}" id="removeButton" text="삭제"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="대출상황" id="tableColumn7">
                                    <webuijsf:button actionExpression="#{lms$user$member$UserList.bookBorrowStatusButton_action}"
                                        binding="#{lms$user$member$UserList.bookBorrowStatusButton}" id="bookBorrowStatusButton" text="대출상황"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                        </webuijsf:table>
                        <webuijsf:hyperlink id="hyperlink1" style="left: 456px; top: 192px; position: absolute" tabIndex="5" text="사서 메인 화면" url="/faces/lms/user/member/LibrarianMenu.jsp"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
