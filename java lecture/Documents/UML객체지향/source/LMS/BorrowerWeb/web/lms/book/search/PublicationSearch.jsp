<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PublicationSearch
    Created on : 2008. 6. 22, 오후 10:20:42
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
                        <webuijsf:staticText id="staticText1" style="height: 48px; left: 32px; top: 80px; position: absolute; width: 456px"
                            styleClass="page-title" text="도서 검색"/>
                        <webuijsf:label id="label1" style="height: 24px; left: 32px; top: 152px; position: absolute; width: 144px" text="도서 유형:"/>
                        <webuijsf:label for="titleTextField" id="label2" style="height: 24px; left: 32px; top: 200px; position: absolute; width: 144px" text="제목:"/>
                        <webuijsf:textField binding="#{lms$book$search$PublicationSearch.titleTextField}" columns="40" id="titleTextField"
                            style="height: 24px; left: 200px; top: 200px; position: absolute; width: 288px" tabIndex="3"/>
                        <webuijsf:label id="label3" style="height: 24px; left: 32px; top: 248px; position: absolute; width: 144px" text="발행처:"/>
                        <webuijsf:textField binding="#{lms$book$search$PublicationSearch.publisherTextField}" id="publisherTextField"
                            style="height: 24px; left: 200px; top: 248px; position: absolute; width: 288px" tabIndex="5"/>
                        <webuijsf:label id="label4" style="height: 24px; left: 32px; top: 224px; position: absolute; width: 144px" text="저자:"/>
                        <webuijsf:textField binding="#{lms$book$search$PublicationSearch.authorTextField}" id="authorTextField"
                            style="height: 24px; left: 200px; top: 224px; position: absolute; width: 288px" tabIndex="4"/>
                        <webuijsf:label id="label5" style="height: 24px; left: 32px; top: 176px; position: absolute; width: 144px" text="ISBN/ISSN"/>
                        <webuijsf:textField binding="#{lms$book$search$PublicationSearch.ISBNTextField}" id="ISBNTextField"
                            style="height: 24px; left: 200px; top: 176px; position: absolute; width: 288px" tabIndex="2"/>
                        <webuijsf:button actionExpression="#{lms$book$search$PublicationSearch.searchButton_action}"
                            binding="#{lms$book$search$PublicationSearch.searchButton}" id="searchButton"
                            style="height: 24px; left: 31px; top: 296px; position: absolute; width: 168px" tabIndex="6" text="검색"/>
                        <webuijsf:checkbox binding="#{lms$book$search$PublicationSearch.bookCheckBox}" id="bookCheckBox" label="단행본"
                            style="height: 24px; left: 200px; top: 152px; position: absolute; width: 144px" tabIndex="1" valueChangeListenerExpression="#{lms$book$search$PublicationSearch.bookCheckBox_processValueChange}"/>
                        <webuijsf:checkbox binding="#{lms$book$search$PublicationSearch.periodicalCheckBox}" id="periodicalCheckBox" label="연속간행물"
                            style="height: 24px; left: 344px; top: 152px; position: absolute; width: 144px" tabIndex="2"/>
                        <webuijsf:table augmentTitle="false" binding="#{lms$book$search$PublicationSearch.searchListTable}" id="searchListTable"
                            style="height: 24px; left: 32px; top: 344px; position: absolute; width: 464px" tabIndex="8" title="도서 검색 결과" width="464">
                            <webuijsf:tableRowGroup emptyDataMsg="해당되는 도서가 검색되지 않습니다" id="tableRowGroup1" rows="10"
                                sourceData="#{SessionBean1.publicationDataProvider}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="유형" id="typeColumn" width="15">
                                    <webuijsf:staticText binding="#{lms$book$search$PublicationSearch.typeStaticText}" id="typeStaticText" text="#{currentRow.value['type']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="식별자" id="ISBNColumn" width="30">
                                    <webuijsf:staticText binding="#{lms$book$search$PublicationSearch.ISBNStaticText}" id="ISBNStaticText" text="#{currentRow.value['publicationNumber']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="서명" id="bookNameColumn" width="100">
                                    <webuijsf:hyperlink actionExpression="#{lms$book$search$PublicationSearch.bookNameHyperlink_action}"
                                        binding="#{lms$book$search$PublicationSearch.bookNameHyperlink}" id="bookNameHyperlink" text="#{currentRow.value['title']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="저자명" id="authorColumn" width="50">
                                    <webuijsf:staticText id="authorStaticText" text="#{currentRow.value['author']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="발행처명" id="publisherColumn" width="50">
                                    <webuijsf:staticText id="publisherStaticText" text="#{currentRow.value['publisher']}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                        </webuijsf:table>
                        <webuijsf:button actionExpression="#{lms$book$search$PublicationSearch.loginButton_action}"
                            binding="#{lms$book$search$PublicationSearch.loginButton}" id="loginButton"
                            style="height: 32px; left: 263px; top: 24px; position: absolute; width: 89px" text="로그인"/>
                        <webuijsf:button actionExpression="#{lms$book$search$PublicationSearch.userMainButton_action}"
                            binding="#{lms$book$search$PublicationSearch.userMainButton}" id="userMainButton"
                            style="position: absolute; left: 32px; top: 24px; width: 128px; height: 32px" text="개인정보 관리"/>
                        <webuijsf:button actionExpression="#{lms$book$search$PublicationSearch.logoutButton_action}"
                            binding="#{lms$book$search$PublicationSearch.logoutButton}" id="logoutButton" style="height: 32px; left: 375px; top: 24px; position: absolute; width: 113px"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
