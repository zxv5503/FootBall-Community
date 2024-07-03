package com.fbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fbc.dto.LaligaRankDto;


@Mapper
public interface LaligaRankMapper {

	List<LaligaRankDto> selectLaligaList();
	
	int selectCount();

	LaligaRankDto selectProductByPoints(int points);
	
	LaligaRankDto selectTeamByName(String teamName);

	void insertLaliga(LaligaRankDto laligaRankDto);
	
	void updateLaligaForm(LaligaRankDto laligaRankDto);
	
	void delete(String teamName);
}
