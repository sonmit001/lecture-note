<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PublicationMain
    Created on : 2008. 6. 21, 오후 3:01:56
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
                        <webuijsf:label for="typeRadioButtonGroup" id="label1" style="height: 24px; left: 40px; top: 80px; position: absolute; width: 144px" text="도서 유형:"/>
                        <webuijsf:radioButtonGroup binding="#{lms$book$publication$PublicationRegistration.typeRadioButtonGroup}" columns="2"
                            id="typeRadioButtonGroup" immediate="true"
                            items="#{lms$book$publication$PublicationRegistration.typeRadioButtonGroupDefaultOptions.options}" onClick="" required="true"
                            style="height: 24px; left: 208px; top: 80px; position: absolute; width: 288px" tabIndex="1" valueChangeListenerExpression="#{lms$book$publication$PublicationRegistration.typeRadioButtonGroup_processValueChange}"/>
                        <webuijsf:label for="titleTextField" id="label2" style="height: 24px; left: 40px; top: 152px; position: absolute; width: 144px" text="제목:"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationRegistration.titleTextField}" columns="40" id="titleTextField"
                            required="true" style="height: 24px; left: 208px; top: 152px; position: absolute; width: 288px" tabIndex="3"/>
                        <webuijsf:label for="publisherTextField" id="label3" style="height: 24px; left: 40px; top: 200px; position: absolute; width: 144px" text="발행처:"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationRegistration.publisherTextField}" id="publisherTextField"
                            style="height: 24px; left: 208px; top: 200px; position: absolute; width: 288px" tabIndex="5"/>
                        <webuijsf:label for="authorTextField" id="label4" style="height: 24px; left: 40px; top: 176px; position: absolute; width: 144px" text="저자:"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationRegistration.authorTextField}" id="authorTextField" required="true"
                            style="height: 24px; left: 208px; top: 176px; position: absolute; width: 288px" tabIndex="4"/>
                        <webuijsf:label for="ISBNTextField" id="label5" style="height: 24px; left: 40px; top: 104px; position: absolute; width: 144px" text="ISBN/ISSN"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationRegistration.ISBNTextField}" id="ISBNTextField" required="true"
                            style="height: 24px; left: 208px; top: 104px; position: absolute; width: 288px" tabIndex="2"/>
                        <webuijsf:label id="label6" style="height: 24px; left: 40px; top: 224px; position: absolute; width: 144px" text="발행일:"/>
                        <webuijsf:label id="label7" style="height: 24px; left: 40px; top: 272px; position: absolute; width: 144px" text="페이지수:"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationRegistration.pageTextField}" id="pageTextField"
                            style="height: 24px; left: 208px; top: 272px; position: absolute; width: 288px" tabIndex="7"/>
                        <webuijsf:label id="label8" style="height: 24px; left: 40px; top: 296px; position: absolute; width: 144px" text="구독여부:"/>
                        <webuijsf:radioButtonGroup binding="#{lms$book$publication$PublicationRegistration.subscribedRadioButtonGroup}" columns="2"
                            id="subscribedRadioButtonGroup"
                            items="#{lms$book$publication$PublicationRegistration.subscribedRadioButtonGroupDefaultOptions.options}"
                            style="height: 24px; left: 208px; top: 296px; position: absolute; width: 288px" tabIndex="8"/>
                        <webuijsf:staticText id="staticText1" style="height: 48px; left: 40px; top: 8px; position: absolute; width: 456px"
                            styleClass="page-title" text="도서 등록 화면"/>
                        <webuijsf:button actionExpression="#{lms$book$publication$PublicationRegistration.registerButton_action}" id="registerButton"
                            style="height: 24px; left: 55px; top: 384px; position: absolute; width: 120px" tabIndex="9" text="도서 등록"/>
                        <webuijsf:messageGroup binding="#{lms$book$publication$PublicationRegistration.msgGroup}" id="msgGroup" style="height: 54px; left: 40px; top: 320px; position: absolute; width: 454px"/>
                        <webuijsf:hyperlink actionExpression="#{lms$book$publication$PublicationRegistration.publicationListHyperlink_action}"
                            id="publicationListHyperlink" style="font-weight: bolder; height: 24px; left: 280px; top: 384px; position: absolute; width: 184px"
                            tabIndex="10" text="도서 정보 관리 메인 화면으로" url="/faces/lms/book/publication/PublicationList.jsp"/>
                        <webuijsf:calendar binding="#{lms$book$publication$PublicationRegistration.publicationDateCalendar}" id="publicationDateCalendar"
                            style="left: 208px; top: 224px; position: absolute" tabIndex="6"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
