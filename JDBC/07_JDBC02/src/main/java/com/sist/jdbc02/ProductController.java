package com.sist.jdbc02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.model.ProductDAO;
import com.sist.model.ProductDTO;

@Controller
public class ProductController {

	@Autowired
	private ProductDAO dao;
	
	@RequestMapping("/product_list.do")
	public String select(Model model) {
		
		List<ProductDTO> list = this.dao.getProductList();
		
		model.addAttribute("List", list);
		
		return "product_list";
	}
	
}
