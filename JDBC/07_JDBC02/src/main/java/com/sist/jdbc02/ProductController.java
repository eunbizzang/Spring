package com.sist.jdbc02;

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

import com.sist.model.CategoryDTO;
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
	
	@RequestMapping("/product_insert.do")
	public String insert(Model model) {
		
		List<CategoryDTO> list = this.dao.categoryList();
		
		model.addAttribute("cartList", list);
		
		return "product_insert";
	}
	
	@RequestMapping("/product_insert_ok.do")
	public void insertOk(ProductDTO dto, HttpServletResponse response) throws IOException {
		
		int res = this.dao.insertProduct(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(res>0) {
			out.println("<script>");
			out.println("alert('제품등록성공')");
			out.println("location.href='product_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('제품등록실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("/product_content.do")
	public ModelAndView content(@RequestParam("num") int pnum) {
		
		ProductDTO dto = this.dao.getProductCont(pnum);

		ModelAndView mav = new ModelAndView();
		
		mav.addObject("Cont", dto);
		
		mav.setViewName("product_content");
		
		return mav;
		
	}
	
	@RequestMapping("/product_modify.do")
	public ModelAndView modify(@RequestParam("num") int pnum) {
		
		ProductDTO dto = this.dao.getProductCont(pnum);
		
		List<CategoryDTO> list = this.dao.categoryList();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("modify", dto);
		
		mav.addObject("cartList", list);
		
		mav.setViewName("product_modify");
		
		return mav;
		
	}
	
	@RequestMapping("/product_modify_ok")
	public void modifyOk(ProductDTO dto,
			HttpServletResponse response) throws IOException {
		
		int res = this.dao.updateProduct(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('제품 수정 성공')");
			out.println("location.href='product_content.do?num="+dto.getPnum()+"'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('제품 수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("/product_delete")
	public void delete(@RequestParam("num") int pnum,
			HttpServletResponse response) throws IOException {
		
		int res = this.dao.deleteProduct(pnum);		// 제품 삭제 메서드 호출
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(res>0) {
			// 삭제된 제품번호보다 큰 번호를 다시 재작업 하는 메서드 호출
			this.dao.updateSeq(pnum);
			
			out.println("<script>");
			out.println("alert('제품삭제성공')");
			out.println("location.href='product_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('제품삭제실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("/product_search.do")
	public ModelAndView search(@RequestParam("field") String field, 
			@RequestParam("keyword") String keyword) {
		
		List<ProductDTO> list = this.dao.searchProduct(field, keyword);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchList", list);
		
		mav.setViewName("product_searchList");
		
		return mav;
	}
}
