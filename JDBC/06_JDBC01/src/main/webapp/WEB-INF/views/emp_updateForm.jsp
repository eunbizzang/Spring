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
	   <hr width="50%" color="blue">
	      <h3>EMP 테이블 사원 정보 수정 폼 페이지</h3>
	   <hr width="50%" color="blue">
	   <br> <br>
	   
	   <form method="post"
	      action="<%=request.getContextPath() %>/emp_update_ok.do">
	      <table border="1" cellspacing="0" width="350">
	         <c:set var="dto" value="${Modify }" />
	         <c:if test="${!empty dto }">
	            <tr>
	               <th>사원번호</th>
	               <td> <input name="empno"
	               			value="${dto.getEmpno() }" readonly> </td>
	            </tr>
	            
	            <tr>
	               <th>사원명</th>
	               <td> <input name="ename"
	                        value="${dto.getEname() }" readonly> </td>
	            </tr>
	            
	            <c:set var="list" value="${jobList }" />
	            <tr>
	               <th>담당업무</th>
	               <td>
	                  <select name="job">
	                     <c:if test="${empty list }">
	                        <option value="">:::담당업무 없음:::</option>
	                     </c:if>
	                     
	                     <c:if test="${!empty list }">
	                        <c:forEach items="${list }" var="str">
	                           <c:if test="${dto.getJob() == str }">
	                              <option value="${str }" selected>${str }</option>
	                           </c:if>
	                           
	                           <c:if test="${dto.getJob() != str }">
	                              <option value="${str }">${str }</option>
	                           </c:if>
	                        </c:forEach>
	                     </c:if>
	                  </select>
	               </td>
	            </tr>
	         
	            <c:set var="list" value="${mgrList }" />
	            <tr>
	               <th>관리자 No.</th>
	               <td>
	                  <select name="mgr">
	                     <c:if test="${empty list }">
	                        <option value="">:::관리자 없음:::</option>
	                     </c:if>
	                     
	                     <c:if test="${!empty list }">
	                        <c:forEach items="${list }" var="i">
	                           <c:if test="${dto.getMgr() == i.getEmpno() }">
	                              <option value="${i.getEmpno() }" selected>
	                              		${i.getEname() } [${i.getEmpno() }]</option>
	                           </c:if>
	                           
	                           <c:if test="${dto.getMgr() != i.getEmpno() }">
	                              <option value="${i.getEmpno() }">
	                              		${i.getEname() } [${i.getEmpno() }]</option>
	                           </c:if>
	                        </c:forEach>
	                     </c:if>
	                  </select>
	               </td>
	            </tr>
	         
	            <tr>
	               <th>급 여</th>
	               <td>
	                  <input name="sal" value="${dto.getSal() }">
	               </td>
	            </tr>
	            
	            <tr>
	               <th>보너스</th>
	               <td>
	                  <input name="comm" value="${dto.getComm() }">
	               </td>
	            </tr>
	            
	            <c:set var="list" value="${deptList }" />
	            <tr>
	               <th>부서번호</th>
	               <td>
	                  <select name="deptno">
	                     <c:if test="${empty list }">
	                        <option value="">:::부서번호 없음:::</option>
	                     </c:if>
	                     
	                     <c:if test="${!empty list }">
	                        <c:forEach items="${list }" var="i">
	                           <c:if test="${dto.getDeptno() == i.getDeptno() }">
	                              <option value="${i.getDeptno() }" selected>
	                              		${i.getDname() } [${i.getDeptno() }]</option>
	                           </c:if>
	                           
	                           <c:if test="${dto.getDeptno() != i.getDeptno() }">
	                              <option value="${i.getDeptno() }">
	                              		${i.getDname() } [${i.getDeptno() }]</option>
	                           </c:if>
	                        </c:forEach>
	                     </c:if>
	                  </select>
	               </td>
	            </tr>
	            
	            <tr>
	               <td colspan="2" align="center">
	                  <input type="submit" value="사원수정">&nbsp;&nbsp;&nbsp;
	                  <input type="reset" value="다시작성">
	               </td>
	            </tr>
	         
	         </c:if>
	       
	      </table>
	   
	   
	   </form>
	
	</div>
</body>
</html>