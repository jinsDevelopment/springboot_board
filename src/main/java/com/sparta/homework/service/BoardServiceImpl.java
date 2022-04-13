package com.sparta.homework.service;

import com.sparta.homework.domain.Board;
import com.sparta.homework.domain.BoardRequestDTO;
import com.sparta.homework.repository.BoardRepository;
import com.sparta.homework.repository.ReplyRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;

	private final ReplyRepository replyRepository;

	@Autowired
	public BoardServiceImpl(BoardRepository boardRepository,
		ReplyRepository replyRepository) {
		this.boardRepository = boardRepository;
		this.replyRepository = replyRepository;
	}

	@Override
	public List<Board> getBoardAll() {
		return boardRepository.findAllByOrderByCreatedAtDesc();
	}

	@Override
	public Board getBoardById(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(
			() -> new IllegalArgumentException("해당하는 ID가 없습니다.")
		);
		return board;
	}

	@Override
	public Long boardSave(Board board) {

		boardRepository.save(board);
		return board.getId();
	}
	@Override
	public Long boardUpdate(Long id, BoardRequestDTO requestDTO){
		Board board = this.getBoardById(id);
		board.update(requestDTO);
		return board.getId();
	}

	@Override
	public Long boardDelete(Long id){
		Board board = this.getBoardById(id);
		replyRepository.deleteAllByBoardId(board.getId());
		boardRepository.deleteById(board.getId());
		return board.getId();
	}
}
