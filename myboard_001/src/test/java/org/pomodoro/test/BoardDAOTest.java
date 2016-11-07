package org.pomodoro.test;

import javax.inject.Inject;

import org.junit.FixMethodOrder;	// for Ascending test
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.pomodoro.domain.BoardVO;
import org.pomodoro.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	// for Ascending test
public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void testA_Create() throws Exception {
		
		BoardVO board1 = new BoardVO();
		board1.setTitle("새로운 글 001");
		board1.setContent("첫번째 글입니다.");
		board1.setWriter("user_001");
		dao.create(board1);
		
		BoardVO board2 = new BoardVO();
		board2.setTitle("새로운 글 002");
		board2.setContent("두번째 글입니다.");
		board2.setWriter("user_002");
		dao.create(board2);
	}
	
	@Test
	public void testB_Read() throws Exception {
		
		logger.info(dao.read(1).toString());
		logger.info(dao.read(2).toString());
	}
	
	@Test
	public void testC_Update() throws Exception {
		
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("새로운 글 001을 수정했습니다." );
		board.setContent("첫번째 글을 수정했습니다.");
		dao.update(board);
	}
	
	@Test
	public void testD_Delete() throws Exception {
		
		dao.delete(2);
	}
}
