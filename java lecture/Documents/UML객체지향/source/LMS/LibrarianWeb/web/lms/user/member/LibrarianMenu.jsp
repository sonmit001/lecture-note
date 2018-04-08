<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : LibrarianMenu
    Created on : 2008. 8. 3, 오전 3:23:30
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
                        <webuijsf:staticText id="staticText1" style="position: absolute; left: 96px; top: 32px; width: 328px; height: 48px"
                            styleClass="page-title" text="사서 메뉴 화면"/>
                        <webuijsf:hyperlink id="publicationMgtHyperlink" style="height: 32px; left: 104px; top: 160px; position: absolute; width: 328px"
                            text="도서 정보 / 개별 도서 관리" url="/faces/lms/book/publication/PublicationList.jsp"/>
                        <webuijsf:hyperlink disabled="true" id="orderMgtHyperlink"
                            style="height: 40px; left: 104px; top: 208px; position: absolute; width: 326px" text="도서 주문 관리: 현재 구현되어 있지 않습니다." url="/faces/lms/book/order/OrderList.jsp"/>
                        <webuijsf:hyperlink id="userMgtHyperlink" style="position: absolute; left: 104px; top: 112px; width: 328px; height: 32px"
                            text="도서관 사용자 관리" url="/faces/lms/user/member/UserList.jsp"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
