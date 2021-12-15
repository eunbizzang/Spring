package com.sist.jdbc01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sist.model.DeptDTO;
import com.sist.model.EmpDAO;
import com.sist.model.EmpDTO;

@Controller
public class EmpController {

	@Autowired
	private EmpDAO dao;
	
	@RequestMapping("/emp_list.do")
	public String list(Model model) {
		
		List<EmpDTO> list = this.dao.getEmpList();
		
		model.addAttribute("List", list);
		
		return "emp_list";
	
	}
	
	
	@RequestMapping("/emp_insert.do")
	public String insert(Model model) {
		
		// 관리자 목록을 DB에서 가져오는 메서드 호출
		List<EmpDTO> mgrList = this.dao.getMgrList();
		
		// 부서 테이블의 부서번호 목록을 가져오는 메서드 호출
		List<DeptDTO> deptList = this.dao.getDeptList();
		
		// 담당업무 목록을 DB에서 가져오는 메서드 호출
		List<String> jobList = this.dao.getJobList();
		
		model.addAttribute("mgrList", mgrList);
		
		model.addAttribute("deptList", deptList);
		
		model.addAttribute("jobList", jobList);
		
		return "emp_insertForm";
	
	}
	
	
	@RequestMapping("/emp_insert_ok.do")
	public void insertOk(EmpDTO dto,
			HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		int res = this.dao.empInsert(dto);
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('사원 등록 성공')");
			out.println("location.href='emp_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('사원 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}
	
	
	@RequestMapping("/emp_cont.do")
	public String content(@RequestParam("no") int empno, Model model) {
		
		EmpDTO dto = this.dao.empCont(empno);
		
		model.addAttribute("Cont", dto);
		
		return "emp_content";
		
	}
	
	
	
	@RequestMapping("/emp_update.do")
	public ModelAndView modify(@RequestParam("no") int empno) {
		
		// 사원번호에 해당하는 사원의 상세 정보를 조회하는 메서드 호출
		EmpDTO dto = this.dao.empCont(empno);
		
		// 관리자 목록을 DB에서 가져오는 메서드 호출
		List<EmpDTO> mgrList = this.dao.getMgrList();
		
		// 부서 테이블의 부서번호 목록을 가져오는 메서드 호출
		List<DeptDTO> deptList = this.dao.getDeptList();
		
		// 담당업무 목록을 DB에서 가져오는 메서드 호출
		List<String> jobList = this.dao.getJobList();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("mgrList", mgrList);
		
		mav.addObject("jobList", jobList);
		
		mav.addObject("deptList", deptList);
		
		mav.addObject("Modify", dto);
		
		mav.setViewName("emp_updateForm");
		
		return mav;
	}
	
	
	@RequestMapping("/emp_update_ok.do")
	public void modifyOk(EmpDTO dto, 
				HttpServletResponse response) throws IOException {
		
		int result = this.dao.empUpdate(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.println("<script>");
			out.println("alert('사원 정보 수정 성공')");
			out.println("location.href='emp_cont.do?no="+dto.getEmpno()+"'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('사원 정보 수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	
	@RequestMapping("/emp_delete.do")
	public void delete(@RequestParam("no") int empno,
			HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int res = this.dao.empDelete(empno);
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('사원 삭제 성공')");
			out.println("location.href='emp_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('사원 삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}
	
}
