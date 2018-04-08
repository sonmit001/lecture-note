<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PublicationItemList
    Created on : 2008. 6. 22, 오후 1:53:10
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
                        <webuijsf:staticText id="staticText1" style="height: 48px; left: 32px; top: 32px; position: absolute; width: 456px"
                            styleClass="page-title" text="개별 도서 관리 메인 화면"/>
                        <webuijsf:button actionExpression="#{lms$book$publication$PublicationItemList.registerButton_action}"
                            binding="#{lms$book$publication$PublicationItemList.registerButton}" id="registerButton"
                            style="height: 24px; left: 239px; top: 240px; position: absolute; width: 120px" tabIndex="9" text="개별 도서 등록"/>
                        <webuijsf:button actionExpression="#{lms$book$publication$PublicationItemList.searchButton_action}"
                            binding="#{lms$book$publication$PublicationItemList.listButton}" id="listButton"
                            style="height: 24px; left: 31px; top: 240px; position: absolute; width: 192px" tabIndex="7" text="개별 도서 다시 조회"/>
                        <webuijsf:table augmentTitle="false" id="itemListTable" style="height: 24px; left: 32px; top: 304px; position: absolute; width: 480px"
                            tabIndex="8" title="개별 도서 조회 결과" width="480">
                            <webuijsf:tableRowGroup emptyDataMsg="해당되는 개별도서가 검색되지 않습니다" id="tableRowGroup1" rows="10"
                                sourceData="#{SessionBean1.bookItemDataProvider}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="등록번호" id="tableColumn1" width="40">
                                    <webuijsf:staticText binding="#{lms$book$publication$PublicationItemList.ISBNTextField}" id="ISBNTextField" text="#{currentRow.value['registrationNumber']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="소장처" id="tableColumn2" width="40">
                                    <webuijsf:staticText id="staticText3" text="#{currentRow.value['location']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="도서상태" id="tableColumn3" width="20">
                                    <webuijsf:staticText id="staticText4" text="#{currentRow.value['status']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn align="center" headerText="삭제" id="removeColumn" width="20">
                                    <webuijsf:button actionExpression="#{lms$book$publication$PublicationItemList.removeButton_action}" id="removeButton" text="삭제"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                        </webuijsf:table>
                        <webuijsf:label for="typeRadioButtonGroup" id="label1" style="height: 24px; left: 32px; top: 104px; position: absolute; width: 144px" text="도서 유형:"/>
                        <webuijsf:label for="titleTextField" id="label2" style="height: 24px; left: 32px; top: 152px; position: absolute; width: 144px" text="제목:"/>
                        <webuijsf:label id="label3" style="height: 24px; left: 32px; top: 200px; position: absolute; width: 144px" text="발행처:"/>
                        <webuijsf:label id="label4" style="height: 24px; left: 32px; top: 176px; position: absolute; width: 144px" text="저자:"/>
                        <webuijsf:label id="label5" style="height: 24px; left: 32px; top: 128px; position: absolute; width: 144px" text="ISBN/ISSN"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationItemList.typeStaticText}" id="typeStaticText" style="height: 24px; left: 200px; top: 104px; position: absolute; width: 288px"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationItemList.ISBNStaticText}" id="ISBNStaticText" style="height: 24px; left: 200px; top: 128px; position: absolute; width: 288px"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationItemList.titleStaticText}" id="titleStaticText" style="height: 24px; left: 200px; top: 152px; position: absolute; width: 288px"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationItemList.authorStaticText}" id="authorStaticText" style="height: 24px; left: 200px; top: 176px; position: absolute; width: 288px"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationItemList.publisherStaticText}" id="publisherStaticText" style="height: 24px; left: 200px; top: 200px; position: absolute; width: 288px"/>
                        <webuijsf:label id="label6" style="height: 24px; left: 32px; top: 280px; position: absolute; width: 144px" text="개별도서 수:"/>
                        <webuijsf:staticText binding="#{lms$book$publication$PublicationItemList.totalNumberStaticText}" id="totalNumberStaticText" style="height: 24px; left: 200px; top: 280px; position: absolute; width: 288px"/>
                        <webuijsf:hyperlink id="hyperlink1" style="left: 376px; top: 240px; position: absolute" text="도서관리 메인 화면" url="/faces/lms/book/publication/PublicationList.jsp"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
