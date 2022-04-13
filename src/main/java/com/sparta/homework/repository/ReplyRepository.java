package com.sparta.homework.repository;

import com.sparta.homework.domain.Board;
import com.sparta.homework.domain.Reply;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
	List<Reply> findByBoardIdOrderByCreatedAtDesc(Long id);

	Optional<Reply> findByBoardId(Long id);

	Optional<Reply> deleteAllByBoardId(Long id);
}
