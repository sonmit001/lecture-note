<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PublicationList
    Created on : 2008. 6. 21, 오후 7:15:54
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
                        <!-- <div style="left: 0px; top: 0px; position: absolute">
                            <jsp:directive.include file="../../common/LMSMenu.jspf"/>
                        </div>-->
                        <webuijsf:staticText id="staticText1" style="height: 48px; left: 40px; top: 32px; position: absolute; width: 456px"
                            styleClass="page-title" text="도서 관리 메인 화면"/>
                        <webuijsf:button actionExpression="#{lms$book$publication$PublicationList.registerButton_action}" id="registerButton"
                            style="height: 24px; left: 159px; top: 248px; position: absolute; width: 96px" tabIndex="8" text="도서 등록"/>
                        <webuijsf:label id="label1" style="height: 24px; left: 40px; top: 104px; position: absolute; width: 144px" text="도서 유형:"/>
                        <webuijsf:label for="titleTextField" id="label2" style="height: 24px; left: 40px; top: 152px; position: absolute; width: 144px" text="제목:"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationList.titleTextField}" columns="40" id="titleTextField"
                            style="height: 24px; left: 208px; top: 152px; position: absolute; width: 288px" tabIndex="4"/>
                        <webuijsf:label id="label3" style="height: 24px; left: 40px; top: 200px; position: absolute; width: 144px" text="발행처:"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationList.publisherTextField}" id="publisherTextField"
                            style="height: 24px; left: 208px; top: 200px; position: absolute; width: 288px" tabIndex="6"/>
                        <webuijsf:label id="label4" style="height: 24px; left: 40px; top: 176px; position: absolute; width: 144px" text="저자:"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationList.authorTextField}" id="authorTextField"
                            style="height: 24px; left: 208px; top: 176px; position: absolute; width: 288px" tabIndex="5"/>
                        <webuijsf:label id="label5" style="height: 24px; left: 40px; top: 128px; position: absolute; width: 144px" text="ISBN/ISSN"/>
                        <webuijsf:textField binding="#{lms$book$publication$PublicationList.ISBNTextField}" id="ISBNTextField"
                            style="height: 24px; left: 208px; top: 128px; position: absolute; width: 288px" tabIndex="3"/>
                        <webuijsf:button actionExpression="#{lms$book$publication$PublicationList.searchButton_action}" id="searchButton"
                            style="height: 24px; left: 15px; top: 248px; position: absolute; width: 128px" tabIndex="7" text="도서 검색"/>
                        <webuijsf:checkbox binding="#{lms$book$publication$PublicationList.bookCheckBox}" id="bookCheckBox" label="단행본"
                            style="height: 24px; left: 208px; top: 104px; position: absolute; width: 144px" tabIndex="1"/>
                        <webuijsf:checkbox binding="#{lms$book$publication$PublicationList.periodicalCheckBox}" id="periodicalCheckBox" label="연속간행물"
                            style="height: 24px; left: 352px; top: 104px; position: absolute; width: 144px" tabIndex="2"/>
                        <webuijsf:table augmentTitle="false" binding="#{lms$book$publication$PublicationList.searchListTable}" id="searchListTable"
                            style="height: 24px; left: 16px; top: 296px; position: absolute" tabIndex="8" title="도서 검색 결과" width="488">
                            <webuijsf:tableRowGroup emptyDataMsg="해당되는 도서가 검색되지 않습니다" id="tableRowGroup1" rows="10"
                                sourceData="#{SessionBean1.publicationDataProvider}" sourceVar="currentRow">
                                <webuijsf:tableColumn align="center" headerText="유형" id="tableColumn1" width="20">
                                    <webuijsf:staticText binding="#{lms$book$publication$PublicationList.typeStaticText}" id="typeStaticText" text="#{currentRow.value['type']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn align="center" headerText="식별자" id="tableColumn6" width="70">
                                    <webuijsf:staticText binding="#{lms$book$publication$PublicationList.ISBNStaticText}" id="ISBNStaticText" text="#{currentRow.value['publicationNumber']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="서명" id="tableColumn3" width="150">
                                    <webuijsf:hyperlink actionExpression="#{lms$book$publication$PublicationList.bookNameHyperlink_action}"
                                        binding="#{lms$book$publication$PublicationList.bookNameHyperlink}" id="bookNameHyperlink" text="#{currentRow.value['title']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="저자명" id="tableColumn4" width="50">
                                    <webuijsf:staticText id="staticText5" text="#{currentRow.value['author']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="발행처명" id="tableColumn5" width="80">
                                    <webuijsf:staticText id="staticText6" text="#{currentRow.value['publisher']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn align="center" headerText="삭제" id="tableColumn2" width="20">
                                    <webuijsf:button actionExpression="#{lms$book$publication$PublicationList.removeButton_action}"
                                        binding="#{lms$book$publication$PublicationList.removeButton}" id="removeButton" text="삭제"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn align="center" headerText="개별도서" id="itemListColumn" width="20">
                                    <webuijsf:button actionExpression="#{lms$book$publication$PublicationList.itemListButton_action}" id="itemListButton" text="조회"/>
                                    <webuijsf:button actionExpression="#{lms$book$publication$PublicationList.newItemButton_action}" id="newItemButton" text="등록"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                        </webuijsf:table>
                        <webuijsf:hyperlink id="hyperlink1" style="position: absolute; left: 368px; top: 248px; width: 128px; height: 32px" tabIndex="9"
                            text="사서 메인 화면" url="/faces/lms/user/member/LibrarianMenu.jsp"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
