<%@page import="com.sist.vo.NotInBookNameVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.NotInBookNameDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="searchbookname.jsp" method="post">
		�� �̸��� �Է��ϼ��� ==> <input type="text" name="name">
		<input type="submit" value="�˻�">
	</form>
	
	<%
		request.setCharacterEncoding("euc-kr");
		if(request.getParameter("name") != null){
			String name = request.getParameter("name");
			NotInBookNameDAO dao = new NotInBookNameDAO();
			ArrayList <NotInBookNameVo>list = dao.searchBookName(name);
			

			%>
			<table border="1">
				<tr>	
					<td>�����̸�<td>
					 
				</tr>
				<%
					for(NotInBookNameVo o :list){
						%>
							<tr>	
								<td><%= o.getBookname() %></td>								 
							</tr>
						<% 
					}				
				%>
			</table>
	 
		 
		 
			<%
		}
	%>

</body>
</html>