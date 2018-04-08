<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PublicationDetailedView
    Created on : 2008. 6. 22, 오후 10:21:06
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
                            styleClass="page-title" text="단행본 상세 조회"/>
                        <webuijsf:button actionExpression="#{lms$book$search$BookDetailedView.searchButton_action}" id="gotoSearchPageButton"
                            style="height: 24px; left: 399px; top: 264px; position: absolute; width: 144px" tabIndex="7" text="도서  검색 페이지로"/>
                        <webuijsf:table augmentTitle="false" id="bookItemListTable" style="height: 24px; left: 32px; top: 312px; position: absolute"
                            tabIndex="8" title="개별 단행본 조회 결과" width="512">
                            <webuijsf:tableRowGroup emptyDataMsg="단행본이 없습니다" id="tableRowGroup1" rows="10" sourceData="#{SessionBean1.bookItemDataProvider}" sourceVar="currentRow">
                                <webuijsf:tableColumn align="center" headerText="등록번호" id="tableColumn1" width="50">
                                    <webuijsf:staticText binding="#{lms$book$search$BookDetailedView.registrationNumberStaticText}"
                                        id="registrationNumberStaticText" text="#{currentRow.value['registrationNumber']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="등록일" id="tableColumn4" width="80">
                                    <webuijsf:staticText converter="#{lms$book$search$BookDetailedView.dateTimeConverter1}" id="staticText2" text="#{currentRow.value['registrationDate']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn align="center" headerText="소장처" id="tableColumn2" width="80">
                                    <webuijsf:staticText id="staticText3" text="#{currentRow.value['location']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="도서상태" id="tableColumn3" width="50">
                                    <webuijsf:staticText binding="#{lms$book$search$BookDetailedView.bookItemStatusStaticText}" id="bookItemStatusStaticText" text="#{currentRow.value['status']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn align="center" headerText="대출신청" id="borrowRequestColumn" width="40">
                                    <webuijsf:button actionExpression="#{lms$book$search$BookDetailedView.borrowRequestButton_action}"
                                        binding="#{lms$book$search$BookDetailedView.borrowRequestButton}" id="borrowRequestButton"
                                        rendered="#{currentRow.value['status']== 'Borrowable'}" text="대출신청"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                        </webuijsf:table>
                        <webuijsf:label for="typeRadioButtonGroup" id="label1" style="height: 24px; left: 32px; top: 96px; position: absolute; width: 144px" text="도서 유형:"/>
                        <webuijsf:label for="titleTextField" id="label2" style="height: 24px; left: 32px; top: 144px; position: absolute; width: 144px" text="제목:"/>
                        <webuijsf:label id="label3" style="height: 24px; left: 32px; top: 192px; position: absolute; width: 144px" text="발행처:"/>
                        <webuijsf:label id="label4" style="height: 24px; left: 32px; top: 168px; position: absolute; width: 144px" text="저자:"/>
                        <webuijsf:label id="label5" style="height: 24px; left: 32px; top: 120px; position: absolute; width: 144px" text="ISBN"/>
                        <webuijsf:staticText binding="#{lms$book$search$BookDetailedView.typeStaticText}" id="typeStaticText"
                            style="height: 24px; left: 200px; top: 96px; position: absolute; width: 288px" text="단행본"/>
                        <webuijsf:staticText binding="#{lms$book$search$BookDetailedView.ISBNStaticText}" id="ISBNStaticText" style="height: 24px; left: 200px; top: 120px; position: absolute; width: 288px"/>
                        <webuijsf:staticText binding="#{lms$book$search$BookDetailedView.titleStaticText}" id="titleStaticText" style="height: 24px; left: 200px; top: 144px; position: absolute; width: 288px"/>
                        <webuijsf:staticText binding="#{lms$book$search$BookDetailedView.authorStaticText}" id="authorStaticText" style="height: 24px; left: 200px; top: 168px; position: absolute; width: 288px"/>
                        <webuijsf:staticText binding="#{lms$book$search$BookDetailedView.publisherStaticText}" id="publisherStaticText" style="height: 24px; left: 200px; top: 192px; position: absolute; width: 288px"/>
                        <webuijsf:label id="label6" style="height: 24px; left: 32px; top: 280px; position: absolute; width: 144px" text="개별 단행본 수:"/>
                        <webuijsf:staticText binding="#{lms$book$search$BookDetailedView.totalNumberStaticText}" id="totalNumberStaticText" style="height: 24px; left: 200px; top: 280px; position: absolute; width: 94px"/>
                        <webuijsf:label id="label7" style="height: 24px; left: 32px; top: 216px; position: absolute; width: 144px" text="발행일:"/>
                        <webuijsf:staticText binding="#{lms$book$search$BookDetailedView.publicationDateStaticText}"
                            converter="#{lms$book$search$BookDetailedView.dateTimeConverter1}" id="publicationDateStaticText" style="height: 24px; left: 200px; top: 216px; position: absolute; width: 288px"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
