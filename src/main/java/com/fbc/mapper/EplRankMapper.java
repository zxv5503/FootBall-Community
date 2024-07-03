package com.fbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fbc.dto.EplRankDto;


@Mapper
public interface EplRankMapper {

	List<EplRankDto> selectEplList();
	
	int selectCount();

	EplRankDto selectProductByPoints(int points);
	
	EplRankDto selectTeamByName(String teamName);

	void insertEpl(EplRankDto eplRankDto);
	
	void updateEplForm(EplRankDto eplRankDto);
	
	void delete(String teamName);
}
