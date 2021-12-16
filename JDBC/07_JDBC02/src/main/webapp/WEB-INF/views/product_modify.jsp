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
		<c:set var="dto" value="${modify }" />
		<hr width="50%" color="gray">
			<h3>PRODUCTS 테이블 ${dto.getProducts_name() } 제품 수정 폼 페이지</h3>
		<hr width="50%" color="gray">
		<br> <br>
		
		<form method="post"
			action="<%=request.getContextPath() %>/product_modify_ok.do">
			<c:set var="list" value="${cartList }" />
			<input type="hidden" name="pnum" value="${dto.getPnum() }">
			<table border="1" cellspacing="0" width="400">
				<tr>
					<th>카테고리 코드</th>
					<td>
						<select name="category_fk">
							<c:if test="${empty list }">
								<option value="">:::카테고리 코드 없음:::</option>
							</c:if>
							<c:if test="${!empty list }">
								<c:forEach items="${list }" var="i">
									<c:if test="${dto.getCategory_fk() == i.getCategory_code() }">
										<option value="${i.getCategory_code() }" selected>
										${i.getCategory_name() } [${i.getCategory_code() }]
									</c:if>
									
									<c:if test="${dto.getCategory_fk() != i.getCategory_code() }">
										<option value="${i.getCategory_code() }" disabled>
										${i.getCategory_name() } [${i.getCategory_code() }]
									</c:if>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>제품명</th>
					<td> <input name="products_name"
							value="${dto.getProducts_name() }" readonly> </td>
				</tr>
				<tr>
					<th>제품 코드</th>
					<td> <input name="ep_code_fk"
							value="${dto.getEp_code_fk() }" readonly> </td>
				</tr>
				<tr>
					<th>제품 입고가</th>
					<td> <input name="input_price"
							value="${dto.getInput_price() }">원</td>
				</tr>
				<tr>
					<th>제품 출고가</th>
					<td> <input name="output_price"
							value="${dto.getOutput_price() }">원</td>
				</tr>
				<tr>
					<th>제품 배송비</th>
					<td> <input name="trans_cost"
							value="${dto.getTrans_cost() }">원</td>
				</tr>
				<tr>
					<th>제품 마일리지</th>
					<td> <input name="mileage"
							value="${dto.getMileage() }">포인트</td>
				</tr>
				<tr>
					<th>제품 제조사</th>
					<td> <input name="company"
							value="${dto.getCompany() }" readonly></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="제품수정">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시 작성">
					</td>
				</tr>
				
			</table>
		</form>
		
	</div>

</body>
</html>