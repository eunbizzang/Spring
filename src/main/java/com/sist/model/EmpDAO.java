package com.sist.model;

import java.util.List;

/*
 * EmpDAO 인터페이스 특징
 * - 호출하는 클래스와 실제 DB에 접근하는 구현 클래스와의
 *   직접적인 의존관계를 느슨하게 하기 위해서 인터페이스를 사용.
 */

public interface EmpDAO {

	List<EmpDTO> getEmpList();    // 전체 사원 목록 관련 추상메서드.
	int empInsert(EmpDTO dto);    // 사원을 등록(추가)하는 추상메서드.
	EmpDTO empCont(int empno);    // 사원번호에 해당하는 사원의 정보를 조회하는 추상메서드.
	int empUpdate(EmpDTO dto);    // 특정 사원의 사원 정보를 수정하는 추상메서드.
	int empDelete(int empno);     // 특정 사원을 emp 테이블에서 삭제하는 추상메서드.
	List<DeptDTO> getDeptList();  // 부서 테이블 전체 리스트 관련 추상메서드.
	List<EmpDTO> getMgrList();    // 관리자만을 조회하는 추상메서드.
	
}
