package com.sparta.homework.controller;

import com.sparta.homework.domain.Board;
import com.sparta.homework.domain.BoardRequestDTO;
import com.sparta.homework.domain.Reply;
import com.sparta.homework.domain.ReplyRequestDTO;
import com.sparta.homework.service.BoardService;
import com.sparta.homework.service.ReplyService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

	private final BoardService boardService;

	private final ReplyService replyService;

	@Autowired
	public BoardController(BoardService boardService,
		ReplyService replyService) {
		this.boardService = boardService;
		this.replyService = replyService;
	}

	@GetMapping("/")
	public String boardList(Model model) {
		List<Board> boards = boardService.getBoardAll();
		model.addAttribute("boards", boards);
		return "boardList";
	}

	@GetMapping("/api/board/{id}")
	public String boardDetailForm(@PathVariable Long id, Model model) {
		Board board = boardService.getBoardById(id);
		List<Reply> replies = replyService.getReplyList(id);
		if (replies.size() == 0) {
			model.addAttribute("board", board);
		} else {
			model.addAttribute("board", board);
			model.addAttribute("replies", replies);
		}

		return "boardDetailForm";
	}

	@GetMapping("/api/board/writeForm")
	public String writeForm() {
		return "boardWriteForm";
	}

	@GetMapping("/api/board/updateForm/{id}")
	public String updateForm(@PathVariable Long id, Model model) {
		Board board = boardService.getBoardById(id);
		model.addAttribute("board", board);
		return "boardWriteForm";
	}

	@ResponseBody
	@PostMapping("/api/board/write")
	public HashMap<String, String> boardWrite(@RequestBody BoardRequestDTO boardRequestDTO) {
		Board board = new Board(boardRequestDTO);
		HashMap<String, String> result = new HashMap<String, String>();

		try {
			boardService.boardSave(board);
			result.put("res", "success");
			result.put("data", board.getId().toString());
		} catch (Exception e) {
			result.put("res", "fail");
			result.put("data", e.getMessage());
		}
		return result;
	}

	@ResponseBody
	@PutMapping("/api/board/update/{id}")
	public HashMap<String, String> boardUpdate(@PathVariable Long id,
		@RequestBody BoardRequestDTO boardRequestDTO) {

		HashMap<String, String> result = new HashMap<String, String>();

		try {
			boardService.boardUpdate(id, boardRequestDTO);
			result.put("res", "success");
			result.put("data", id.toString());
		} catch (Exception e) {
			result.put("res", "fail");
			result.put("data", e.getMessage());
		}
		return result;
	}

	@ResponseBody
	@DeleteMapping("/api/board/delete/{id}")
	public Long boardDelete(@PathVariable Long id) {
		return boardService.boardDelete(id);
	}

	@ResponseBody
	@PostMapping("/api/reply/write")
	public HashMap<String, String> replyWrite(@RequestBody ReplyRequestDTO replyRequestDTO) {
		Board board = boardService.getBoardById(replyRequestDTO.getBoardId());
		Reply reply = new Reply(replyRequestDTO, board);
		HashMap<String, String> result = new HashMap<String, String>();

		try {
			replyService.replySave(reply);
			result.put("res", "success");
			result.put("data", reply.getId().toString());
		} catch (Exception e) {
			result.put("res", "fail");
			result.put("data", e.getMessage());
		}
		return result;
	}

	@ResponseBody
	@PutMapping("/api/reply/update")
	public HashMap<String, String> replyUpdate(@RequestBody ReplyRequestDTO replyRequestDTO) {
		HashMap<String, String> result = new HashMap<String, String>();

		try {
			replyService.replyUpdate(replyRequestDTO);
			result.put("res", "success");
			result.put("data", replyRequestDTO.getId().toString());
		} catch (Exception e) {
			result.put("res", "fail");
			result.put("data", e.getMessage());
		}

		return result;
	}

	@ResponseBody
	@DeleteMapping("/api/reply/delete")
	public Long replyDelete(@RequestBody ReplyRequestDTO replyRequestDTO) {
		return replyService.replyDelete(replyRequestDTO);
	}

}
