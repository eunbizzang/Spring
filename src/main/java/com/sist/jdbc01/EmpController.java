package com.sist.jdbc01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
}
