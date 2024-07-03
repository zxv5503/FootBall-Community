package com.fbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fbc.dto.Board;

@Mapper
public interface BoardMapper {
	
	List<Board> selectBoardList();
	
	void insertBoard(Board board);
	
	Board selectById(Integer id);
	
	List<Board> selectByStatus(String status);
	
	Board selectByEmail(String email);
	
	void deleteList(Integer id);
	
//	void deleteList2(String hiredate);
	
	 void updateHits(Integer id);

	 String getAuthorEmailById(Integer id);

	 void updateList(Board board);

	

}
