<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PublicationDetail
    Created on : 2008. 6. 22, 오전 1:17:31
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
                        <webuijsf:label id="label1" style="height: 24px; left: 144px; top: 144px; position: absolute; width: 144px" text="도서 유형:"/>
                        <webuijsf:label for="titleTextField" id="label2" style="height: 24px; left: 144px; top: 216px; position: absolute; width: 144px" text="제목:"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationViewEdit.titleTextField}" columns="40" id="titleTextField"
                            required="true" style="height: 24px; left: 312px; top: 216px; position: absolute; width: 288px" tabIndex="3"/>
                        <webuijsf:label for="publisherTextField" id="label3" style="height: 24px; left: 144px; top: 264px; position: absolute; width: 144px" text="발행처:"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationViewEdit.publisherTextField}" id="publisherTextField" required="true"
                            style="height: 24px; left: 312px; top: 264px; position: absolute; width: 288px" tabIndex="5"/>
                        <webuijsf:label for="authorTextField" id="label4" style="height: 24px; left: 144px; top: 240px; position: absolute; width: 144px" text="저자:"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationViewEdit.authorTextField}" id="authorTextField" required="true"
                            style="height: 24px; left: 312px; top: 240px; position: absolute; width: 288px" tabIndex="4"/>
                        <webuijsf:label id="label5" style="height: 24px; left: 144px; top: 168px; position: absolute; width: 144px" text="ISBN/ISSN"/>
                        <webuijsf:label id="label6" style="height: 24px; left: 144px; top: 288px; position: absolute; width: 144px" text="발행일:"/>
                        <webuijsf:label for="pageTextField" id="label7" style="height: 24px; left: 144px; top: 336px; position: absolute; width: 144px" text="페이지수:"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationViewEdit.pageTextField}" id="pageTextField"
                            style="height: 24px; left: 312px; top: 336px; position: absolute; width: 288px" tabIndex="7"/>
                        <webuijsf:label for="subscribedRadioButtonGroup" id="label8"
                            style="height: 24px; left: 144px; top: 360px; position: absolute; width: 144px" text="구독여부:"/>
                        <webuijsf:radioButtonGroup binding="#{lms$book$publication$PublicationViewEdit.subscribedRadioButtonGroup}" columns="2"
                            id="subscribedRadioButtonGroup" items="#{lms$book$publication$PublicationViewEdit.subscribedRadioButtonGroupDefaultOptions.options}"
                            style="height: 24px; left: 312px; top: 360px; position: absolute; width: 288px" tabIndex="8"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationViewEdit.pageTitleStaticText}" id="pageTitleStaticText"
                            style="height: 48px; left: 144px; top: 72px; position: absolute; width: 456px" styleClass="page-title"/>
                        <webuijsf:button actionExpression="#{lms$book$publication$PublicationViewEdit.okButton_action}"
                            binding="#{lms$book$publication$PublicationViewEdit.okButton}" id="okButton"
                            style="height: 24px; left: 215px; top: 408px; position: absolute; width: 120px" tabIndex="9"/>
                        <webuijsf:alert binding="#{lms$book$publication$PublicationViewEdit.alert}" id="alert" style="height: 22px; left: 144px; top: 384px; position: absolute; width: 454px"/>
                        <webuijsf:button actionExpression="#{lms$book$publication$PublicationViewEdit.cancelButton_action}"
                            binding="#{lms$book$publication$PublicationViewEdit.cancelButton}" id="cancelButton" style="height: 24px; left: 383px; top: 408px; position: absolute; width: 144px"/>
                        <webuijsf:messageGroup binding="#{lms$book$publication$PublicationViewEdit.msgGroup}" id="msgGroup" style="height: 216px; left: 624px; top: 240px; position: absolute; width: 168px"/>
                        <webuijsf:hiddenField binding="#{lms$book$publication$PublicationViewEdit.editableHidden}" id="editableHidden"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationViewEdit.typeStaticText}" id="typeStaticText" style="position: absolute; left: 312px; top: 144px; width: 288px; height: 24px"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationViewEdit.ISBNStaticText}" id="ISBNStaticText" style="position: absolute; left: 312px; top: 168px; width: 288px; height: 24px"/>
                        <webuijsf:calendar binding="#{lms$book$publication$PublicationViewEdit.publicationDateCalendar}" id="publicationDateCalendar" style="left: 312px; top: 288px; position: absolute"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
