package com.board.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BoardController {

	@Autowired
	private BoardDAO dao;
	

	private final int rowsize = 3; 	// 한 페이지당 보여질 게시물의 수
	private int totalRecord;	// DB상의 게시물 전체 수
	
	@RequestMapping("board_list.do")
	public String list(HttpServletRequest request, Model model) {
		
		int page;	// 현재 페이지 변수	
		
		if(request.getParameter("Page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}else {
			page = 1; 	// 처음으로 게시물 목록 태그를 클릭한 경우
		}
		
		// DB상의 전체 게시물의 수를 확인하는 작업
		totalRecord = this.dao.getBoardCount();
		
		PageDTO dto = new PageDTO(page, rowsize, totalRecord);
		
		// 페이지에 해당하는 게시물을 가져오는 메서드 호출
		List<BoardDTO> pageList = this.dao.getBoardList(dto);
		
		model.addAttribute("List", pageList);
		model.addAttribute("Paging", dto);
		
		return "board_list";
	}
	
	
	@RequestMapping("board_write.do")
	public String insert() {
		
		return "board_write";
		
	}
	
	
	@RequestMapping("board_write_ok.do")
	public void insertOk(BoardDTO dto,
			HttpServletResponse response) throws IOException {
		
		int check = this.dao.insertBoard(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			out.println("<script>");
			out.println("alert('게시물 추가 성공!!!')");
			out.println("location.href='board_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('게시물 추가 실패~~~')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}
	
	
	@RequestMapping("board_content.do")
	public String cont(@RequestParam("no") int no, Model model) {
		
		this.dao.readCount(no);  // 조회수를 증가시켜 주는 메서드 호출
		
		// 글번호에 해당하는 게시글의 상세내역을 조회하는 메서드 호출
		BoardDTO dto = this.dao.boardCont(no);
		
		model.addAttribute("Cont", dto);
		
		return "board_content";
		
	}
	
	@RequestMapping("board_update.do")
	public String modify(@RequestParam("no") int no, Model model) {
		
		// 글번호에 해당하는 게시글의 상세내역을 조회하는 메서드 호출
		BoardDTO dto = this.dao.boardCont(no);
		
		model.addAttribute("modify", dto);
		
		return "board_update";
		
	}
	
	
	@RequestMapping("board_update_ok.do")
	public void modifyOk(BoardDTO dto, @RequestParam("db_pwd") String db_pwd,
				HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(dto.getBoard_pwd().equals(db_pwd)) {
			this.dao.updateBoard(dto);
	
			out.println("<script>");
			out.println("alert('게시물 수정 성공')");
			out.println("location.href='board_content.do?no="+dto.getBoard_no()+"'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('비일번호가 틀립니다. 확인하세요~~~')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	
	
	@RequestMapping("board_delete.do")
	public String delete(@RequestParam("no") int no, Model model) {
		
		BoardDTO dto = this.dao.boardCont(no);
		
		model.addAttribute("delete", dto);
		
		return "board_delete";
		
	}
	
	
	@RequestMapping("board_delete_ok.do")
	public void deleteOk(@RequestParam("board_pwd") String pwd,
			@RequestParam("board_no") int no,
			@RequestParam("db_pwd") String db_pwd,
			HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(pwd.equals(db_pwd)) {
			this.dao.deleteBoard(no);     // 게시물 삭제하는 메서드 호출
			this.dao.updateSequence(no);  // 게시물 번호 정렬 메서드 호출
			
			out.println("<script>");
			out.println("alert('게시물 삭제 성공')");
			out.println("location.href='board_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('비일번호가 틀립니다. 확인하세요~~~')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}
	
	
	@RequestMapping("board_search.do")
	public String search(@RequestParam("field") String field,
			@RequestParam("keyword") String keyword, Model model) {
		
		List<BoardDTO> list = this.dao.searchBoardList(field, keyword);
		
		model.addAttribute("searchList", list);
		
		return "board_search";
	
	}
	
	
}
