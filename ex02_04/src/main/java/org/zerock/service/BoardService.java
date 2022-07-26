package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> getList();

	public BoardVO get(Long bno);

	public boolean register(BoardVO board);

	public boolean remove(Long bno);

	public boolean modify(BoardVO board);
	
}
