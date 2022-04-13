package com.sparta.homework;

import com.sparta.homework.domain.Board;
import com.sparta.homework.domain.BoardRequestDTO;
import com.sparta.homework.service.BoardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(BoardService boardService) {
//		return (args) -> {
//
//			BoardRequestDTO requestDTO = new BoardRequestDTO();
//			requestDTO.setTitle("제목");
//			requestDTO.setContents("내용");
//			requestDTO.setWriter("진서");
//			boardService.boardSave(new Board(requestDTO));
//
//			requestDTO.setTitle("제목22");
//			requestDTO.setContents("내용22");
//			requestDTO.setWriter("진서22");
//			boardService.boardSave(new Board(requestDTO));
//
//			requestDTO.setTitle("제목33");
//			requestDTO.setContents("내용33");
//			requestDTO.setWriter("진서33");
//			boardService.boardSave(new Board(requestDTO));
//
//		};
//	}

}
