<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="font-size:xx-large; text-align:center;">
<%
	request.setAttribute("name", "개발자");
	out.print("name : " + request.getAttribute("name") + "<br>");
	
	request.setAttribute("count", 0);
	out.print("count : " + request.getAttribute("count") + "<br>");
	
	Object obj = request.getAttribute("count");
	int count = (Integer)obj;
	count += 100;
	
	request.setAttribute("count", count);
	out.print("count : " + request.getAttribute("count") + "<br>");
%>
</div>
</body>
</html>