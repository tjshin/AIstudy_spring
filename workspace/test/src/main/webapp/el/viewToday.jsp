<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="elfunc" uri="/ELFunctions"%>
<%
	Date today = new Date();
	request.setAttribute("today", today);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>
	오늘은 <b>${elfunc:dateFormat(today)}</b> 입니다. <br>
	오늘은 <b><%=today %></b> 입니다. <br>
</h2>
</body>
</html>