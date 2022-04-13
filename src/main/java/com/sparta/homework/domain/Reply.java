package com.sparta.homework.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Reply extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "REPLY_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="BOARD_ID")
	private Board board;

	@Column(nullable = false)
	private String writer;

	@Column(nullable = false)
	private String contents;

	public Reply() {

	}

	public Reply(ReplyRequestDTO requestDTO, Board board) {
		this.board = board;
		this.writer = requestDTO.getWriter();
		this.contents = requestDTO.getContents();
	}

	public void update(ReplyRequestDTO requestDTO) {
		this.contents = requestDTO.getContents();
	}




//	public Memo(MemoRequestDTO requestDto) {
//		this.username = requestDto.getUsername();
//		this.contents = requestDto.getContents();
//	}


}
