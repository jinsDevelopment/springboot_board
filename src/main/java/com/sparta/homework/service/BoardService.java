package com.sparta.homework.service;

import com.sparta.homework.domain.Board;
import com.sparta.homework.domain.BoardRequestDTO;
import com.sparta.homework.repository.BoardRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface BoardService {

	public List<Board> getBoardAll();

	public Board getBoardById(Long id);

	public Long boardSave(Board board);

	public Long boardUpdate(Long id, BoardRequestDTO requestDTO);

	public Long boardDelete(Long id);

}

