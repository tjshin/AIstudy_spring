<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="java.util.*" %>
<%
	boolean flag = (boolean)request.getAttribute("flag");
%>

<!DOCTYPE html> 
<html> 
<head>
  <title>게시판 답변</title>
  <meta charset="utf-8">
  <script>
  function list() {
		let url = 'list.do';
		url += "?col=<%=request.getParameter("col")%>";
		url += "&word=<%=request.getParameter("word")%>";
		url += "&nowPage=<%=request.getParameter("nowPage")%>";
		
		location.href=url;
	}
  </script>
</head>
<body> 
<div class="container">
<div class="well well-lg">
	<%
		if(flag) {
			out.print("답변 등록 성공입니다.");
		}else{
			out.print("답변 등록 실패입니다.");
		}
	%>
</div>
	<button class="btn" onclick="location.href='create.do'">새로운 게시글 등록</button>
	<button class="btn" onclick="list()">목록</button>
</div>
</body> 
</html>