package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
	public List<BoardVO> getList();

	public BoardVO get(Long bno);

	public int insert(BoardVO board);

	public int delete(Long bno);

	public int update(BoardVO board);
}
