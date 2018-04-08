<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PublicationItemRegistration
    Created on : 2008. 6. 22, 오후 1:46:51
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
                        <webuijsf:label for="typeRadioButtonGroup" id="label1" style="height: 24px; left: 144px; top: 120px; position: absolute; width: 144px" text="도서 유형:"/>
                        <webuijsf:label for="titleTextField" id="label2" style="height: 24px; left: 144px; top: 168px; position: absolute; width: 144px" text="제목:"/>
                        <webuijsf:label id="label3" style="height: 24px; left: 144px; top: 216px; position: absolute; width: 144px" text="발행처:"/>
                        <webuijsf:label id="label4" style="height: 24px; left: 144px; top: 192px; position: absolute; width: 144px" text="저자:"/>
                        <webuijsf:label id="label5" style="height: 24px; left: 144px; top: 144px; position: absolute; width: 144px" text="ISBN/ISSN"/>
                        <webuijsf:calendar binding="#{lms$book$publication$PublicationItemRegistration.registrationDateCalendar}" id="registrationDateCalendar"
                            style="height: 24px; left: 312px; top: 312px; position: absolute; width: 288px" tabIndex="3"/>
                        <webuijsf:label for="registrationDateCalendar" id="label6"
                            style="height: 24px; left: 144px; top: 312px; position: absolute; width: 144px" text="등록일:"/>
                        <webuijsf:staticText id="staticText1" style="height: 48px; left: 144px; top: 48px; position: absolute; width: 456px"
                            styleClass="page-title" text="개별 도서 등록 화면"/>
                        <webuijsf:button actionExpression="#{lms$book$publication$PublicationItemRegistration.registerButton_action}"
                            binding="#{lms$book$publication$PublicationItemRegistration.registerButton}" id="registerButton"
                            style="height: 24px; left: 215px; top: 360px; position: absolute; width: 120px" tabIndex="4" text="등록"/>
                        <webuijsf:alert binding="#{lms$book$publication$PublicationItemRegistration.alert}" id="alert" style="height: 22px; left: 144px; top: 408px; position: absolute; width: 454px"/>
                        <webuijsf:messageGroup binding="#{lms$book$publication$PublicationItemRegistration.msgGroup}" id="msgGroup" style="height: 216px; left: 624px; top: 120px; position: absolute; width: 168px"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationItemRegistration.typeStaticText}" id="typeStaticText" style="position: absolute; left: 312px; top: 120px; width: 288px; height: 24px"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationItemRegistration.ISBNStaticText}" id="ISBNStaticText" style="position: absolute; left: 312px; top: 144px; width: 288px; height: 24px"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationItemRegistration.titleStaticText}" id="titleStaticText" style="height: 24px; left: 312px; top: 168px; position: absolute; width: 288px"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationItemRegistration.authorStaticText}" id="authorStaticText" style="height: 24px; left: 312px; top: 192px; position: absolute; width: 288px"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationItemRegistration.publisherStaticText}" id="publisherStaticText" style="height: 24px; left: 312px; top: 216px; position: absolute; width: 288px"/>
                        <webuijsf:label for="locationTextField" id="label9" style="height: 24px; left: 144px; top: 288px; position: absolute; width: 144px" text="소장처명:"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationItemRegistration.locationTextField}" id="locationTextField"
                            style="height: 24px; left: 312px; top: 288px; position: absolute; width: 288px" tabIndex="2"/>
                        <webuijsf:label for="registrationNumberTextField" id="label7"
                            style="position: absolute; left: 144px; top: 264px; width: 144px; height: 24px" text="등록번호:"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationItemRegistration.registrationNumberTextField}"
                            id="registrationNumberTextField" required="true" style="position: absolute; left: 312px; top: 264px; width: 288px; height: 24px" tabIndex="1"/>
                        <webuijsf:hyperlink id="hyperlink1" style="position: absolute; left: 408px; top: 360px; width: 184px; height: 24px" tabIndex="5"
                            text="도서관리 메인 화면" url="/faces/lms/book/publication/PublicationList.jsp"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
