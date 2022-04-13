package com.sparta.homework.domain;

import com.sun.istack.NotNull;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;

@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Board extends Timestamped{	// 생성,수정 시간을 자동으로 만들어줍니다.

	@Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 명령입니다.
	@Column(name = "BOARD_ID")
	private Long id;

	@OneToMany(mappedBy="board")
	private List<Reply> replies = new ArrayList<>();

	@Column(nullable = false)	// 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
	private String title;

	@Column(length = 2000)	// 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
	private String contents;

	@Column(nullable = false)	// 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
	private String writer;

	public Board() {

	}

	public Board(BoardRequestDTO requestDTO) {
		this.title = requestDTO.getTitle();
		this.contents = requestDTO.getContents();
		this.writer = requestDTO.getWriter();

	}

	public void update(BoardRequestDTO requestDTO) {
		this.title = requestDTO.getTitle();
		this.contents = requestDTO.getContents();
		this.writer = requestDTO.getWriter();
	}

}
