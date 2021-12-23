package com.board.model;

import java.util.List;


public interface BoardDAO {

	int getBoardCount();
	List<BoardDTO> getBoardList(PageDTO dto);
	int insertBoard(BoardDTO dto);
	BoardDTO boardCont(int no);
	void readCount(int no);
	int updateBoard(BoardDTO dto);
	int deleteBoard(int no);
	void updateSequence(int no);
	List<BoardDTO> searchBoardList(String field, String keyword);
	
}
