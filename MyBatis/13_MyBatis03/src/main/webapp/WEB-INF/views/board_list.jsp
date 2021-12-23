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
	      <h3>BOARD 테이블 게시판 전체 리스트 페이지</h3>
	   <hr width="50%" color="red">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="450">
	      <tr>
	         <th>게시글 No.</th> <th>글 제 목</th>
	      	 <th>조 회 수</th> <th>작성일자</th>
	      </tr>
	      
	      <c:set var="list" value="${List }" />
	      <c:set var="dto" value="${Paging }" />
	      <c:if test="${!empty list }">
	         <c:forEach items="${list }" var="i">
	            <tr>
	               <td> ${i.getBoard_no() } </td>
	               <td> <a href="<%=request.getContextPath() %>/board_content.do?no=${i.getBoard_no() }"> 
	               				${i.getBoard_title() } </a></td>
	               <td> ${i.getBoard_hit() } </td>
	               <td> ${i.getBoard_date().substring(0,10) } </td>
	            </tr>
	         </c:forEach>
	      </c:if>
	      
	      <c:if test="${empty list }">
	         <tr>
	            <td colspan="4" align="center">
	               <h3>검색된 내역이 없습니다.....</h3>
	            </td>
	         </tr>
	      </c:if>
	      
	      <tr>
	         <td colspan="4" align="right">
	            <input type="button" value="글쓰기"
	                 onclick="location.href='board_write.do'">
	         </td>
	      </tr>
	   </table>
	   <br> <br>
	   
	   <!-- 페이징 처리 부분 -->
		<c:if test="${dto.getPage() > dto.getBlock() }">
			<a href="board_list.do?page=1">◁◁</a>
			<a href="board_list.do?page=${dto.getStartBlock() - 1 }">◁</a>
		</c:if>
		
		<c:forEach begin="${dto.getStartBlock() }"
					end="${dto.getEndBlock() }" var="i">
			<c:if test="${i == dto.getPage() }">
				<b> <a href="board_list.do?page=${i }">[${i }]</a></b>
			</c:if>
			
			<c:if test="${i != dto.getPage() }">
				<a href="board_list.do?page=${i }">[${i }]</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${dto.getEndBlock() < dto.getAllPage() }">
			<a href="board_list.do?page=${dto.getEndBlock() + 1 }">▷</a>
			<a href="board_list.do?page=${dto.getAllPage() }">▷▷</a>
		</c:if>
	   <form method="post"
	      action="<%=request.getContextPath() %>/board_search.do">
	      <select name="field">
	         <option value="title">제목</option>
	         <option value="cont">내용</option>
	         <option value="title_cont">제목+내용</option>
	         <option value="writer">작성자</option>
	      </select>
	      
	      <input type="text" name="keyword">
	      <input type="submit" value="검색">
	   </form>
	   
	</div>
	
</body>
</html>