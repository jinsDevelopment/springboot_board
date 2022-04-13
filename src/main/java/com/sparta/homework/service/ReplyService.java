package com.sparta.homework.service;

import com.sparta.homework.domain.Board;
import com.sparta.homework.domain.Reply;
import com.sparta.homework.domain.ReplyRequestDTO;
import java.util.List;

public interface ReplyService {

	List<Reply> getReplyList(Long id);

	Long replySave(Reply reply);

	Long replyUpdate(ReplyRequestDTO requestDTO);

	Long replyDelete(ReplyRequestDTO requestDTO);



}
