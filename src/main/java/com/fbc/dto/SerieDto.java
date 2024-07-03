package com.fbc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class SerieDto {
	private String teamName;
	private int matchesPlayed;
	private int wins;
	private int draws;
	private int losses;
	private String goalsPlusMinus;
	private int goalsSum;
	private int points;
}
