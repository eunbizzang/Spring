package com.sist.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
// Spring에서 일반적으로 DAO 클래스에 적용되는 애노테이션
public class EmpDAOImpl implements EmpDAO {

	// 자동으로 의존관계를 설정해 주는 애노테이션.
	// 무조건 객체에 대한 의존을 주입해 주는 애노테이션.
	@Autowired
	private JdbcTemplate template;
	
	
	String sql = null;
	
	@Override
	public List<EmpDTO> getEmpList() {
	
		List<EmpDTO> list = null;
		
		sql = "select * from emp order by empno";
		
		return list = template.query(sql, new RowMapper<EmpDTO>() {

			@Override
			public EmpDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setMgr(rs.getInt("mgr"));
				dto.setHiredate(rs.getString("hiredate"));
				dto.setSal(rs.getDouble("sal"));
				dto.setComm(rs.getDouble("comm"));
				dto.setDeptno(rs.getInt("deptno"));
				
				return dto;
			}
		});
		
	}

	@Override
	public int empInsert(EmpDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmpDTO empCont(int empno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int empUpdate(EmpDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int empDelete(int empno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DeptDTO> getDeptList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpDTO> getMgrList() {
		// TODO Auto-generated method stub
		return null;
	}

}
