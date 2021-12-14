<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<hr width="50%" color="red">
			<h3>EMP　테이블 전체 사원 리스트</h3>
		<hr width="50%" color="red">
		<br> <br>
		
		<table border="1" cellspacing="0" width="450">
			<tr>
				<th>사원번호</th> <th>사원명</th>
				<th>담당업무</th> <th>입사일자</th>
			</tr>
			
			<c:set var="list" value="${List }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td> ${dto.getEmpno() } </td>
						<td> ${dto.getEname() } </td>
						<td> ${dto.getJob() } </td>
						<td> ${dto.getHiredate().substring(0,10) } </td>
					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${empty list }">
				<tr>
					<td colspan="4" align="center">
						<h3>검색된 리스트가 없습니다.</h3>
					</td>
				</tr>
			</c:if>
		</table>
	</div>
</body>
</html>