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
	      <h3>PRODUCTS 테이블 ${dto.getProducts_name() } 제품 상세 내역 페이지</h3>
	   <hr width="50%" color="tomato">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="350">
	      <tr>
	         <th>제품 번호</th>
	         <td> ${dto.getPnum() } </td>
	      </tr>
	      
	      <tr>
	         <th>카테고리 번호</th>
	         <td> ${dto.getCategory_fk() } </td>
	      </tr>
	      
	      <tr>
	         <th>제품 이름</th>
	         <td> ${dto.getProducts_name() } </td>
	      </tr>
	      
	      <tr>
	         <th>Epcode</th>
	         <td> ${dto.getEp_code_fk() } </td>
	      </tr>
	      
	      <tr>
	         <th>입고가</th>
	         <td> <fmt:formatNumber value="${dto.getInput_price() }" 
	         			pattern="#,###,###,###" /> 원</td>
	      </tr>
	      
	      <tr>
	         <th>출고가</th>
	         <td> <fmt:formatNumber value="${dto.getOutput_price() }"
	         			pattern="#,###,###,###" /> 원</td>
	      </tr>
	      <tr>
	         <th>배송비</th>
	         <td> <fmt:formatNumber value="${dto.getTrans_cost() }"
	         			pattern="#,###,###,###" /> 원</td>
	      </tr>
	      <tr>
	         <th>마일리지</th>
	         <td> <fmt:formatNumber value="${dto.getMileage() }"
	         			pattern="#,###,###,###" /> 포인트</td>
	      </tr>
	      <tr>
	         <th>회사</th>
	         <td> ${dto.getCompany() } </td>
	      </tr>
	      <c:if test="${empty dto }">
	         <tr>
	            <td colspan="2" align="center">
	               <h3>검색된 제품에 대한 정보가 없습니다.....</h3>
	            </td>
	         </tr>
	      </c:if>
	      
	      <tr>
	         <td colspan="2" align="center">
	            <input type="button" value="제품수정"
	                onclick="location.href='product_modify.do?num=${dto.getPnum() }'">&nbsp;
	            <input type="button" value="제품 삭제"
	                onclick="if(confirm('정말로 삭제하시겠습니까?')) {
	                             location.href='product_delete.do?num=${dto.getPnum() }'
	                         }else { return;  }">&nbsp;
	            <input type="button" value="제품목록"
	                onclick="location.href='product_list.do'">     
	         </td>
	      </tr>
	   </table>
	</div>
</body>
</html>