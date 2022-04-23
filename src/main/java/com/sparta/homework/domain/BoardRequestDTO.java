package com.sparta.homework.domain;

import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDTO {

	private Long id;

	private String title;

	private String contents;

	private String writer;

}
