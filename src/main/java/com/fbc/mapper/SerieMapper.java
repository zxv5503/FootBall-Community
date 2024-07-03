package com.fbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fbc.dto.SerieDto;


@Mapper
public interface SerieMapper {

	List<SerieDto> selectSerieList();
	
	int selectCount();

	SerieDto selectProductByPoints(int points);
	
	SerieDto selectTeamByName(String teamName);

	void insertSerie(SerieDto serieDto);
	
	void updateSerieForm(SerieDto serieDto);
	
	void delete(String teamName);
}
