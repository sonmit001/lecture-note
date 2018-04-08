<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : BorrowRequest
    Created on : 2008. 6. 23, 오전 12:23:12
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
                        <webuijsf:staticText id="staticText1" style="height: 48px; left: 32px; top: 24px; position: absolute; width: 456px"
                            styleClass="page-title" text="단행본 대출 신청 화면"/>
                        <webuijsf:button actionExpression="#{lms$borrowandreturn$BorrowRequest.borrowRequestButton_action}"
                            binding="#{lms$borrowandreturn$BorrowRequest.borrowRequestButton}" id="borrowRequestButton"
                            style="height: 24px; left: 71px; top: 384px; position: absolute; width: 144px" tabIndex="1" text="신청"/>
                        <webuijsf:label for="titleTextField" id="label2" style="height: 24px; left: 32px; top: 120px; position: absolute; width: 144px" text="제목:"/>
                        <webuijsf:label id="label3" style="height: 24px; left: 32px; top: 168px; position: absolute; width: 144px" text="발행처:"/>
                        <webuijsf:label id="label4" style="height: 24px; left: 32px; top: 144px; position: absolute; width: 144px" text="저자:"/>
                        <webuijsf:label id="label5" style="height: 24px; left: 32px; top: 96px; position: absolute; width: 144px" text="ISBN"/>
                        <webuijsf:staticText binding="#{lms$borrowandreturn$BorrowRequest.ISBNStaticText}" id="ISBNStaticText" style="height: 24px; left: 200px; top: 96px; position: absolute; width: 288px"/>
                        <webuijsf:staticText binding="#{lms$borrowandreturn$BorrowRequest.titleStaticText}" id="titleStaticText" style="font-weight: bolder; height: 24px; left: 200px; top: 120px; position: absolute; width: 288px"/>
                        <webuijsf:staticText binding="#{lms$borrowandreturn$BorrowRequest.authorStaticText}" id="authorStaticText" style="height: 24px; left: 200px; top: 144px; position: absolute; width: 288px"/>
                        <webuijsf:staticText binding="#{lms$borrowandreturn$BorrowRequest.publisherStaticText}" id="publisherStaticText" style="height: 24px; left: 200px; top: 168px; position: absolute; width: 288px"/>
                        <webuijsf:label id="label7" style="height: 24px; left: 32px; top: 192px; position: absolute; width: 144px" text="발행일:"/>
                        <webuijsf:staticText binding="#{lms$borrowandreturn$BorrowRequest.publicationDateStaticText}" id="publicationDateStaticText" style="height: 24px; left: 200px; top: 192px; position: absolute; width: 288px"/>
                        <webuijsf:label id="label1" style="height: 24px; left: 32px; top: 264px; position: absolute; width: 144px" text="소장처:"/>
                        <webuijsf:staticText binding="#{lms$borrowandreturn$BorrowRequest.locationStaticText}" id="locationStaticText" style="font-weight: bolder; height: 24px; left: 200px; top: 264px; position: absolute; width: 288px"/>
                        <webuijsf:label id="label6" style="height: 24px; left: 32px; top: 288px; position: absolute; width: 144px" text="대출기한일:"/>
                        <webuijsf:staticText binding="#{lms$borrowandreturn$BorrowRequest.borrowDueStaticText}" id="borrowDueStaticText" style="height: 24px; left: 200px; top: 288px; position: absolute; width: 288px"/>
                        <webuijsf:button actionExpression="#{lms$borrowandreturn$BorrowRequest.gotoBookDetailedViewPageButton_action}"
                            binding="#{lms$borrowandreturn$BorrowRequest.gotoBookDetailedViewPageButton}" id="gotoBookDetailedViewPageButton"
                            style="height: 24px; left: 263px; top: 384px; position: absolute; width: 176px" tabIndex="2" text="단행본 상세 조회 화면으로"/>
                        <webuijsf:label id="label8" style="height: 24px; left: 32px; top: 240px; position: absolute; width: 144px" text="등록번호:"/>
                        <webuijsf:staticText binding="#{lms$borrowandreturn$BorrowRequest.registrationNumberStaticText}" id="registrationNumberStaticText" style="height: 24px; left: 200px; top: 240px; position: absolute; width: 288px"/>
                        <webuijsf:label id="label9" style="height: 32px; left: 32px; top: 336px; position: absolute; width: 142px" text="대출신청 결과:"/>
                        <webuijsf:staticText binding="#{lms$borrowandreturn$BorrowRequest.resultStaticText}" id="resultStaticText" style="height: 32px; left: 200px; top: 336px; position: absolute; width: 288px"/>
                        <webuijsf:pageSeparator id="pageSeparator1" style="height: 0px; left: 24px; top: 296px; position: absolute; width: 472px"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
