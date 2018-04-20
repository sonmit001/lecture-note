<%@ page pageEncoding="euc-kr" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@page import="mvjsp.chap22.pds.service.IncreaseDownloadCountService"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="mvjsp.chap22.pds.service.PdsItemNotFoundException"%>
<%@page import="mvjsp.chap22.pds.file.FileDownloadHelper"%>
<%@page import="mvjsp.chap22.pds.model.PdsItem"%>
<%@page import="mvjsp.chap22.pds.service.GetPdsItemService"%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	try {
		PdsItem item = GetPdsItemService.getInstance().getPdsItem(id);

		// ���� ��� �ٿ�ε�� ����
		response.reset();
		
		String fileName = new String(item.getFileName().getBytes("euc-kr"), 
				"iso-8859-1");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", 
				"attachment; filename=\"" + fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setContentLength((int)item.getFileSize());
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");

		FileDownloadHelper.copy(item.getRealPath(), 
				response.getOutputStream());
		
		response.getOutputStream().close();
		
		IncreaseDownloadCountService.getInstance().increaseCount(id);
	} catch (PdsItemNotFoundException ex) {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}
%>