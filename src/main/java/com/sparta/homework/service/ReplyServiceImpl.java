package com.sparta.homework.service;

import com.sparta.homework.domain.Board;
import com.sparta.homework.domain.Reply;
import com.sparta.homework.domain.ReplyRequestDTO;
import com.sparta.homework.repository.ReplyRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

	private final ReplyRepository replyRepository;

	public ReplyServiceImpl(ReplyRepository replyRepository) {
		this.replyRepository = replyRepository;
	}

	@Override
	public List<Reply> getReplyList(Long id) {

		return replyRepository.findByBoardIdOrderByCreatedAtDesc(id);

	}

	@Override
	public Long replySave(Reply reply) {
		replyRepository.save(reply);
		return reply.getId();
	}

	@Override
	public Long replyUpdate(ReplyRequestDTO requestDTO) {
		Reply reply = replyRepository.findById(requestDTO.getId()).orElseThrow(
			() -> new IllegalArgumentException("해당하는 ID가 없습니다.")
		);
		reply.update(requestDTO);
		return reply.getId();
	}

	@Override
	public Long replyDelete(ReplyRequestDTO requestDTO) {
		Reply reply = replyRepository.findById(requestDTO.getId()).orElseThrow(
			() -> new IllegalArgumentException("해당하는 ID가 없습니다.")
		);
		replyRepository.deleteById(reply.getId());
		return reply.getId();
	}
}
