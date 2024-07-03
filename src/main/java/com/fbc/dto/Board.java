package com.fbc.dto;

import java.time.LocalDateTime;

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
public class Board {
	private int id;
    private String email;
    private String content;
    private int hits;
    private LocalDateTime hiredate;
    private int recommend;
    private String title;
    private String status;
	

}
