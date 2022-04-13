package com.sparta.homework.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyRequestDTO {

	private Long id;

	private Long boardId;

	private String writer;

	private String contents;

}
