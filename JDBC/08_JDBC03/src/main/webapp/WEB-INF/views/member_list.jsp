<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>멤버 리스트</h3>
		<hr width="50%" color="red">
       <br> <br>
       
       <table border="1" cellspacing="0" width="500">
          <tr>
             <th>회원 번호</th> <th>회원 이름</th>
             <th>회원 직업</th> <th>등록일</th>
          </tr>
          
          <c:set var="list" value="${List }" />
          
          <c:if test="${!empty list }">
             <c:forEach items="${list }" var="dto">
                <tr>
                   <td> ${dto.getNum() } </td>
                   <td> <a href="<%=request.getContextPath() %>/member_content.do?num=${dto.getNum() }">
                   ${dto.getMemname() } </a></td>
                   <td> ${dto.getJob() }</td>
                   <td> ${dto.getRegdate() } </td>
                </tr>
             </c:forEach>
          </c:if>
          
          <c:if test="${empty list }">
             <tr>
                <td colspan="4" align="center">
                   <h3>사원 목록이 없습니다.</h3>
                </td>
             </tr>
          </c:if>
          
          <tr>
             <td colspan="4" align="right">
                <input type="button" value="사원등록"
                    onclick="location.href='product_insert.do'">
             </td>
          </tr>
       
       </table>
       <br> <br>
       
       <form method="post"
          action="<%=request.getContextPath() %>/product_search.do">
          <select name="field">
             <option value="id">아이디</option>
             <option value="name">이 름</option>
             <option value="job">직 업</option>
          </select>
          
          <input type="text" name="keyword">&nbsp;&nbsp;
          <input type="submit" value="검색">
       </form>
	
	</div>
</body>
</html>