package org.zerock.service;

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
public class BoardServiceTests {

	@Autowired
	private BoardService service;

	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}

	@Test
	public void testGet() {
		log.info(service.get(1L));
	}

	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("테스트 삽입");
		board.setContent("테스트 삽입");
		board.setWriter("nozomi");
		log.info("REGISTER RESULT: " + service.register(board));
		log.info(board);
	}

	@Test
	public void testDelete() {
		BoardVO board = service.get(22L);
		if (board == null) {
			return;
		}
		log.info("DELETE RESULT: " + service.remove(22L));
	}

	@Test
	public void testModify() {
		BoardVO board = service.get(27L);
		if (board == null) {
			return;
		}
		board.setTitle("제목변경이요이요");
		log.info("MODIFY RESULT: " + service.modify(board));
		log.info(board);
	}
}
