package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}

	@Test
	public void testGet() {
		log.info(mapper.get(1L));
	}

	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("매퍼연습제목");
		board.setContent("매퍼연습내용");
		board.setWriter("매퍼연습쟁이");
		log.info("INSERT RESULT: " + mapper.insert(board));
		log.info(board);
	}

	@Test
	public void testDelete() {
		log.info("DELETE RESULT: " + mapper.delete(24L));
	}

	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(21L);
		board.setTitle("매퍼수정테스트제목");
		board.setContent("매퍼수정테스트내용");
		board.setWriter("매퍼수정테스트작성자");
		log.info("UPDATE RESULT: " + mapper.update(board));
		log.info(board);
	}
}
