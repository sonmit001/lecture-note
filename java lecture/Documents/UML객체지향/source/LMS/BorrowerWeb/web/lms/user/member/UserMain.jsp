<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : UserMain
    Created on : 2008. 6. 27, 오후 4:35:50
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
                        <webuijsf:staticText id="staticText1" style="height: 48px; left: 24px; top: 24px; position: absolute; width: 696px"
                            styleClass="page-title" text="개인 정보 관리 메인 화면"/>
                        <webuijsf:panelLayout id="layoutPanel1" style="border: 2px solid black; height: 68px; left: 24px; top: 96px; position: absolute; width: 700px; -rave-layout: grid">
                            <webuijsf:label id="label1" style="left: 56px; top: 8px; position: absolute" text="이름:"/>
                            <webuijsf:staticText binding="#{lms$user$member$UserMain.nameStaticText}" id="nameStaticText" style="height: 23px; left: 104px; top: 8px; position: absolute; width: 119px"/>
                            <webuijsf:label id="label2" style="left: 56px; top: 32px; position: absolute" text="소속:"/>
                            <webuijsf:staticText binding="#{lms$user$member$UserMain.organizationStaticText}" id="organizationStaticText" style="height: 24px; left: 104px; top: 32px; position: absolute; width: 144px"/>
                            <webuijsf:label id="label3" style="left: 312px; top: 32px; position: absolute" text="부서:"/>
                            <webuijsf:staticText binding="#{lms$user$member$UserMain.departmentStaticText}" id="departmentStaticText" style="height: 24px; left: 360px; top: 32px; position: absolute; width: 117px"/>
                            <webuijsf:label id="label4" style="left: 496px; top: 32px; position: absolute" text="신분:"/>
                            <webuijsf:staticText binding="#{lms$user$member$UserMain.userTypeStaticText}" id="userTypeStaticText" style="height: 24px; left: 544px; top: 32px; position: absolute; width: 144px"/>
                        </webuijsf:panelLayout>
                        <webuijsf:button actionExpression="#{lms$user$member$UserMain.searchButton_action}" id="searchButton"
                            style="height: 24px; left: 567px; top: 184px; position: absolute; width: 96px" text="도서 검색"/>
                        <webuijsf:hyperlink actionExpression="#{lms$user$member$UserMain.helpHyperlink_action}" id="helpHyperlink"
                            style="left: 680px; top: 184px; position: absolute" target="_blank" text="도움말" url="/lms/help.html"/>
                        <webuijsf:tabSet id="tabSet1" selected="finishedBorrowInfoTab" style="border-width: 2px; border-style: solid; height: 356px; left: 24px; top: 232px; position: absolute; width: 716px">
                            <webuijsf:tab actionExpression="#{lms$user$member$UserMain.userInfoTab_action}" id="userInfoTab" text="인적사항 조회">
                                <webuijsf:panelLayout id="userInfoPanel" style="height: 309px; position: relative; width: 710px; -rave-layout: grid">
                                    <webuijsf:label id="label5" style="height: 22px; left: 16px; top: 64px; position: absolute; width: 102px" text="전자우편주소:"/>
                                    <webuijsf:label id="label6" style="height: 32px; left: 320px; top: 64px; position: absolute; width: 96px" text="전화번호:"/>
                                    <webuijsf:label id="label7" style="height: 22px; left: 312px; top: -168px; position: absolute; width: 96px" text="사용자 아이디:"/>
                                    <webuijsf:label id="label8" style="height: 22px; left: 16px; top: 160px; position: absolute; width: 96px" text="암호:"/>
                                    <webuijsf:textField binding="#{lms$user$member$UserMain.phoneNumberTextField}" id="phoneNumberTextField"
                                        style="height: 32px; left: 448px; top: 64px; position: absolute; width: 144px" tabIndex="3"/>
                                    <webuijsf:textField binding="#{lms$user$member$UserMain.emailTextField}" id="emailTextField"
                                        style="height: 32px; left: 144px; top: 64px; position: absolute; width: 144px" tabIndex="2"/>
                                    <webuijsf:staticText binding="#{lms$user$member$UserMain.userIDStaticText}" id="userIDStaticText" style="height: 22px; left: 416px; top: -168px; position: absolute; width: 144px"/>
                                    <webuijsf:passwordField binding="#{lms$user$member$UserMain.password1PasswordField}" columns="10"
                                        id="password1PasswordField" style="left: 144px; top: 160px; position: absolute" tabIndex="5"/>
                                    <webuijsf:passwordField binding="#{lms$user$member$UserMain.password2PasswordField}" columns="10"
                                        id="password2PasswordField" style="left: 320px; top: 160px; position: absolute" tabIndex="6"/>
                                    <webuijsf:button actionExpression="#{lms$user$member$UserMain.updateUserInfoButton_action}" id="updateUserInfoButton"
                                        style="height: 32px; left: 79px; top: 112px; position: absolute; width: 128px" tabIndex="4" text="인적사항 변경"/>
                                    <webuijsf:button actionExpression="#{lms$user$member$UserMain.updatePasswordButton_action}" id="updatePasswordButton"
                                        style="height: 24px; left: 423px; top: 160px; position: absolute; width: 96px" tabIndex="7" text="암호 변경"/>
                                    <webuijsf:label id="label14" style="height: 14px; left: 240px; top: 160px; position: absolute; width: 70px" text="암호 확인:"/>
                                    <webuijsf:label id="label15" style="height: 30px; left: 16px; top: 24px; position: absolute; width: 88px" text=" 이름:"/>
                                    <webuijsf:textField binding="#{lms$user$member$UserMain.nameTextField}" id="nameTextField"
                                        style="position: absolute; left: 144px; top: 24px; width: 144px; height: 24px" tabIndex="1"/>
                                </webuijsf:panelLayout>
                            </webuijsf:tab>
                            <webuijsf:tab actionExpression="#{lms$user$member$UserMain.onGoingBorrowInfoTab_action}" id="onGoingBorrowInfoTab" text="진행중인 대출 조회">
                                <webuijsf:panelLayout id="onGoingBorrowInfoPanel" style="height: 307px; width: 100%">
                                    <webuijsf:label id="label9" style="left: 16px; top: 8px; position: absolute" text="대출신청 도서수:"/>
                                    <webuijsf:staticText binding="#{lms$user$member$UserMain.requestedBookCountStaticText}" id="requestedBookCountStaticText" style="height: 30px; left: 144px; top: 8px; position: absolute; width: 86px"/>
                                    <webuijsf:label id="label10" style="height: 32px; left: 488px; top: 8px; position: absolute; width: 86px" text="연체도서수:"/>
                                    <webuijsf:staticText binding="#{lms$user$member$UserMain.overDuedBookCountStaticText}" id="overDuedBookCountStaticText" style="height: 32px; left: 584px; top: 8px; position: absolute; width: 104px"/>
                                    <webuijsf:table augmentTitle="false" id="borrowInfoTable" style="height: 216px; left: 16px; top: 48px; position: absolute"
                                        title="대출상황" width="688">
                                        <webuijsf:tableRowGroup id="tableRowGroup1" rows="10" sourceData="#{SessionBean1.onGoingBookBorrowDataProvider}" sourceVar="currentRow">
                                            <webuijsf:tableColumn headerText="상태" id="tableColumn1">
                                                <webuijsf:staticText id="staticText2" text="#{currentRow.value['status']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="대출번호" id="tableColumn2">
                                                <webuijsf:staticText binding="#{lms$user$member$UserMain.bookBorrowIDStaticText}" id="bookBorrowIDStaticText" text="#{currentRow.value['bookBorrowID']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="서명" id="tableColumn3">
                                                <webuijsf:staticText id="staticText4" text="#{currentRow.value['title']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="저자" id="tableColumn4">
                                                <webuijsf:staticText id="staticText5" text="#{currentRow.value['author']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="대출예정일" id="tableColumn5">
                                                <webuijsf:staticText converter="#{lms$user$member$UserMain.dateTimeConverter1}" id="staticText6" text="#{currentRow.value['borrowExpectedDate']}"/>
                                                <webuijsf:button actionExpression="#{lms$user$member$UserMain.cancelRequestButton_action}"
                                                    binding="#{lms$user$member$UserMain.cancelRequestButton}" id="cancelRequestButton"
                                                    rendered="#{currentRow.value['status'] == 'Requested'}" text="신청취소"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="대출일" id="tableColumn6">
                                                <webuijsf:staticText converter="#{lms$user$member$UserMain.dateTimeConverter1}" id="staticText7" text="#{currentRow.value['borrowDate']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="반납예정일" id="tableColumn7">
                                                <webuijsf:staticText converter="#{lms$user$member$UserMain.dateTimeConverter1}" id="staticText8" text="#{currentRow.value['returnExpectedDate']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="반납연장" id="tableColumn8">
                                                <webuijsf:staticText id="staticText9" rendered="#{currentRow.value['status'] == 'Borrowed'}" text="#{currentRow.value['returnExtendCount']} 회"/>
                                                <webuijsf:button actionExpression="#{lms$user$member$UserMain.extendReturnButon_action}"
                                                    binding="#{lms$user$member$UserMain.extendReturnButton}" id="extendReturnButton"
                                                    rendered="#{currentRow.value['status'] == 'Borrowed' and currentRow.value['canExtendReturn'] == true}" text="연장"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                    <webuijsf:label id="label3" style="left: 248px; top: 8px; position: absolute" text="대출중인 도서수:"/>
                                    <webuijsf:staticText binding="#{lms$user$member$UserMain.borrowedBookCountStaticText}" id="borrowedBookCountStaticText" style="height: 24px; left: 360px; top: 8px; position: absolute; width: 94px"/>
                                </webuijsf:panelLayout>
                            </webuijsf:tab>
                            <webuijsf:tab actionExpression="#{lms$user$member$UserMain.finishedBorrowInfoTab_action}" id="finishedBorrowInfoTab" text="완료된 대출 조회">
                                <webuijsf:panelLayout id="finishedBorrowInfoPanel" style="height: 307px; position: relative; width: 708px; -rave-layout: grid">
                                    <webuijsf:label id="label11" style="left: 16px; top: 16px; position: absolute" text="사용자 취소 대출 신청 수:"/>
                                    <webuijsf:staticText binding="#{lms$user$member$UserMain.userCancelledReqestCountStaticText}"
                                        id="userCancelledReqestCountStaticText" style="height: 24px; left: 184px; top: 16px; position: absolute; width: 78px"/>
                                    <webuijsf:label id="label12" style="height: 30px; left: 264px; top: 16px; position: absolute; width: 158px" text="자동 취소 대출 신청 수:"/>
                                    <webuijsf:staticText binding="#{lms$user$member$UserMain.systemCancelledReqestCountStaticText}"
                                        id="systemCancelledReqestCountStaticText" style="height: 30px; left: 424px; top: 16px; position: absolute; width: 78px"/>
                                    <webuijsf:label id="label13" style="height: 24px; left: 504px; top: 16px; position: absolute; width: 126px" text="대출/반납 도서 수:"/>
                                    <webuijsf:staticText binding="#{lms$user$member$UserMain.finishedBorrowedBookCountStaticText}"
                                        id="finishedBorrowedBookCountStaticText" style="height: 24px; left: 632px; top: 16px; position: absolute; width: 80px"/>
                                    <webuijsf:table augmentTitle="false" id="finishedBorrowInfoTable" paginateButton="true" paginationControls="true"
                                        style="height: 192px; left: 8px; top: 56px; position: absolute; width: 696px" title="대출 정보" width="696">
                                        <webuijsf:tableRowGroup id="tableRowGroup2" rows="5" sourceData="#{SessionBean1.finishedBookBorrowDataProvider}" sourceVar="currentRow">
                                            <webuijsf:tableColumn headerText="상태" id="tableColumn9">
                                                <webuijsf:staticText id="staticText10" text="#{currentRow.value['status']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="서명" id="tableColumn10">
                                                <webuijsf:staticText id="staticText11" text="#{currentRow.value['title']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="저자" id="tableColumn11">
                                                <webuijsf:staticText id="staticText12" text="#{currentRow.value['author']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="대출취소일" id="tableColumn12">
                                                <webuijsf:staticText converter="#{lms$user$member$UserMain.dateTimeConverter1}" id="staticText13" text="#{currentRow.value['borrowCancelledDate']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="자동취소" id="tableColumn13">
                                                <webuijsf:staticText id="staticText14" rendered="#{currentRow.value['status'] == 'Cancelled'}" text="#{currentRow.value['isRequestCancelledBySystem']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="대출일" id="tableColumn14">
                                                <webuijsf:staticText converter="#{lms$user$member$UserMain.dateTimeConverter1}" id="staticText15" text="#{currentRow.value['borrowDate']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="반납일" id="tableColumn15">
                                                <webuijsf:staticText converter="#{lms$user$member$UserMain.dateTimeConverter1}" id="staticText16" text="#{currentRow.value['returnDate']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="연체료" id="tableColumn16">
                                                <webuijsf:staticText id="staticText17" rendered="#{currentRow.value['status'] == 'Returned'}" text="#{currentRow.value['overDueFee']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn headerText="연체료납부" id="tableColumn17">
                                                <webuijsf:staticText id="staticText18" rendered="#{currentRow.value['overDueFee'] &gt; 0}" text="#{currentRow.value['overDueFeePaid']}"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </webuijsf:panelLayout>
                            </webuijsf:tab>
                        </webuijsf:tabSet>
                        <webuijsf:button actionExpression="#{lms$user$member$UserMain.logoutButton_action}" id="logoutButton"
                            style="height: 24px; left: 23px; top: 184px; position: absolute; width: 103px" text="로그 아웃"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
