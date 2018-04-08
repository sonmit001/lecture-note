<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : UserBorrowStatus
    Created on : 2008. 6. 27, 오후 6:53:53
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
                        <webuijsf:staticText id="staticText1" style="height: 48px; left: 56px; top: 24px; position: absolute; width: 456px"
                            styleClass="page-title" text="사용자 대출 상황"/>
                        <webuijsf:label id="label1" style="height: 32px; left: 304px; top: 88px; position: absolute; width: 70px" text="이름:"/>
                        <webuijsf:staticText binding="#{lms$user$member$UserBorrowStatus.userNameStaticText}" id="userNameStaticText" style="height: 32px; left: 384px; top: 88px; position: absolute; width: 128px"/>
                        <webuijsf:label id="label2" style="height: 32px; left: 56px; top: 88px; position: absolute; width: 102px" text="사용자 아이디:"/>
                        <webuijsf:staticText binding="#{lms$user$member$UserBorrowStatus.userIDStaticText}" id="userIDStaticText" style="height: 32px; left: 160px; top: 88px; position: absolute; width: 118px"/>
                        <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true"
                            style="height: 176px; left: 8px; top: 200px; position: absolute; width: 800px" title="대출 상황" width="700">
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="5" sourceData="#{SessionBean1.bookBorrowDataProvider}" sourceVar="currentRow">
                                <webuijsf:tableColumn headerText="도서등록번호" id="tableColumn4">
                                    <webuijsf:staticText binding="#{lms$user$member$UserBorrowStatus.registrationNumberStaticText}"
                                        id="registrationNumberStaticText" text="#{currentRow.value['registrationNumber']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="bookBorrowID" id="tableColumn2" rendered="false">
                                    <webuijsf:staticText binding="#{lms$user$member$UserBorrowStatus.bookBorrowIDStaticText}" id="bookBorrowIDStaticText" text="#{currentRow.value['bookBorrowID']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="서명" id="tableColumn14" width="100">
                                    <webuijsf:staticText id="staticText15" text="#{currentRow.value['title']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="저자" id="tableColumn1" width="60">
                                    <webuijsf:staticText id="staticText2" text="#{currentRow.value['author']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="상태" id="tableColumn10">
                                    <webuijsf:staticText id="staticText4" text="#{currentRow.value['status']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="대출신청일" id="tableColumn6" width="60">
                                    <webuijsf:staticText converter="#{lms$user$member$UserBorrowStatus.dateTimeConverter1}" id="borrowRequestedDateStaticText" text="#{currentRow.value['borrowRequestedDate']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="대출예정일" id="tableColumn5" width="60">
                                    <webuijsf:staticText converter="#{lms$user$member$UserBorrowStatus.dateTimeConverter1}" id="borrowExpectedDateStaticText" text="#{currentRow.value['borrowExpectedDate']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn binding="#{lms$user$member$UserBorrowStatus.requestCancelColumn2}" headerText="신청취소"
                                    id="requestCancelColumn2" width="60">
                                    <webuijsf:staticText converter="#{lms$user$member$UserBorrowStatus.dateTimeConverter1}" id="requestCancelledDateStaticText"
                                        rendered="#{currentRow.value['status'] == 'Cancelled'}" text="#{currentRow.value['borrowCancelledDate']}"/>
                                    <webuijsf:button actionExpression="#{lms$user$member$UserBorrowStatus.requestCancelButton_action}"
                                        binding="#{lms$user$member$UserBorrowStatus.requestCancelButton}" id="requestCancelButton"
                                        rendered="#{currentRow.value['status'] == 'Requested'}" text="취소"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="자동취소" id="tableColumn7">
                                    <webuijsf:staticText id="staticText8" rendered="#{currentRow.value['status'] == 'Cancelled'}" text="#{currentRow.value['isRequestCancelledBySystem']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="대출" id="borrowColumn" width="60">
                                    <webuijsf:staticText converter="#{lms$user$member$UserBorrowStatus.dateTimeConverter1}" id="borrowDateStaticText" text="#{currentRow.value['borrowDate']}"/>
                                    <webuijsf:button actionExpression="#{lms$user$member$UserBorrowStatus.borrowButton_action}" id="borrowButton"
                                        rendered="#{currentRow.value['status'] == 'Requested'}" text="대출"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="반납예정일" id="tableColumn12" width="60">
                                    <webuijsf:staticText converter="#{lms$user$member$UserBorrowStatus.dateTimeConverter1}" id="returnExpectedDateStaticText" text="#{currentRow.value['returnExpectedDate']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="반납일" id="returnColumn" width="60">
                                    <webuijsf:staticText converter="#{lms$user$member$UserBorrowStatus.dateTimeConverter1}" id="returnDateStaticText"
                                        rendered="#{currentRow.value['status'] == 'Returned'}" text="#{currentRow.value['returnDate']}"/>
                                    <webuijsf:button actionExpression="#{lms$user$member$UserBorrowStatus.returnButton_action}"
                                        binding="#{lms$user$member$UserBorrowStatus.returnButton}" id="returnButton"
                                        rendered="#{currentRow.value['status'] == 'Borrowed'}" text="반납"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="연체료" id="tableColumn8">
                                    <webuijsf:staticText id="staticText9" rendered="#{currentRow.value['status'] == 'Returned'}" text="#{currentRow.value['overDueFee']}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="연체료납부" id="tableColumn9">
                                    <webuijsf:staticText id="payFeeStaticText" rendered="#{currentRow.value['overDueFee']&gt;0}" text="#{currentRow.value['overDueFeePaid']}"/>
                                    <webuijsf:button actionExpression="#{lms$user$member$UserBorrowStatus.payFeeButton_action}" id="payFeeButton"
                                        rendered="#{currentRow.value['overDueFee'] &gt; 0 and currentRow.value['overDueFeePaid'] == false}" text="납부"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="연장회수" id="tableColumn3">
                                    <webuijsf:staticText id="staticText3" text="#{currentRow.value['returnExtendCount']}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                        </webuijsf:table>
                        <webuijsf:button actionExpression="#{lms$user$member$UserBorrowStatus.gotoUserListPageButton_action}" id="gotoUserListPageButton"
                            style="height: 32px; left: 359px; top: 160px; position: absolute; width: 160px" text="사용자 관리 메인 화면"/>
                        <webuijsf:label id="label3" style="height: 32px; left: 304px; top: 120px; position: absolute; width: 70px" text="전자우편:"/>
                        <webuijsf:staticText binding="#{lms$user$member$UserBorrowStatus.emailStaticText}" id="emailStaticText" style="height: 32px; left: 384px; top: 120px; position: absolute; width: 128px"/>
                        <webuijsf:label id="label4" style="height: 32px; left: 56px; top: 120px; position: absolute; width: 102px" text="사용자 유형:"/>
                        <webuijsf:staticText binding="#{lms$user$member$UserBorrowStatus.userTypeStaticText}" id="userTypeStaticText" style="height: 32px; left: 160px; top: 120px; position: absolute; width: 118px"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
