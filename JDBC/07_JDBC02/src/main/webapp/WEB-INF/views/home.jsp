<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<div align="center">
	   <hr width="50%" color="gray">
	      <h3>PRODUCTS 테이블 메인 페이지</h3>
	   <hr width="50%" color="gray">
	   <br> <br>
	   
	   <a href="<%=request.getContextPath() %>/product_list.do">[제품 전체 목록]</a>
	
	</div>
	
</body>
</html>
