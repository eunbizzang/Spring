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
	   <c:set var="dto" value="${Cont }" />
	   <hr width="50%" color="tomato">
	      <h3>EMP 테이블 ${dto.getEname() } 사원 정보 상세 내역 페이지</h3>
	   <hr width="50%" color="tomato">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="350">
	      <tr>
	         <th>사원번호</th>
	         <td> ${dto.getEmpno() } </td>
	      </tr>
	      
	      <tr>
	         <th>사원명</th>
	         <td> ${dto.getEname() } </td>
	      </tr>
	      
	      <tr>
	         <th>담당업무</th>
	         <td> ${dto.getJob() } </td>
	      </tr>
	      
	      <tr>
	         <th>관리자 No.</th>
	         <td> ${dto.getMgr() } </td>
	      </tr>
	      
	      <tr>
	         <th>급 여</th>
	         <td> <fmt:formatNumber value="${dto.getSal() }" /> </td>
	      </tr>
	      
	      <tr>
	         <th>보너스</th>
	         <td> <fmt:formatNumber value="${dto.getComm() }"
	         			pattern="#,###,###,###.00" /> </td>
	      </tr>
	      
	      <tr>
	         <th>부서번호</th>
	         <td> ${dto.getDeptno() } </td>
	      </tr>
	      
	      <tr>
	         <th>입사일자</th>
	         <td> ${dto.getHiredate() } </td>
	      </tr>
	      
	      <c:if test="${empty dto }">
	         <tr>
	            <td colspan="2" align="center">
	               <h3>검색된 사원에 대한 정보가 없습니다.....</h3>
	            </td>
	         </tr>
	      </c:if>
	      
	      <tr>
	         <td colspan="2" align="center">
	            <input type="button" value="사원수정"
	                onclick="location.href='emp_update.do?no=${dto.getEmpno() }'">&nbsp;
	            <input type="button" value="사원 삭제"
	                onclick="if(confirm('정말로 삭제하시겠습니까?')) {
	                             location.href='emp_delete.do?no=${dto.getEmpno() }'
	                         }else { return;  }">&nbsp;
	            <input type="button" value="사원목록"
	                onclick="location.href='emp_list.do'">     
	         </td>
	      </tr>
	   </table>
	</div>
</body>
</html>