package com.fbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fbc.dto.BundesligaDto;


@Mapper
public interface BundesligaMapper {

	List<BundesligaDto> selectBundesligaList();
	
	int selectCount();

	BundesligaDto selectProductByPoints(int points);
	
	BundesligaDto selectTeamByName(String teamName);

	void insertBundesliga(BundesligaDto bundesligaDto);
	
	void updateBundesligaForm(BundesligaDto bundesligaDto);
	
	void delete(String teamName);
}
