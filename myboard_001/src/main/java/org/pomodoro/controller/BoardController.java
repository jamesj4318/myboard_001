package org.pomodoro.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.pomodoro.domain.BoardVO;
import org.pomodoro.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
		
		logger.info("register get.............");
	}
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public String registPOST(BoardVO board, Model model) throws Exception {
//		
//		logger.info("register post.............");
//		logger.info(board.toString());
//		
//		service.regist(board);
//		
//		model.addAttribute("result", "success");
//		
//		//return "/board/success";	// 결과를 '/board/success'에 해당하는 뷰로 전송
//		return "redirect:/board/listAll";	// 새로고침 방지를 위해 리다이렉트 사용
//	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		
		logger.info("register post.............");
		logger.info(board.toString());
		
		service.regist(board);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listAll";	// 새로고침 방지를 위해 리다이렉트 사용
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		
		logger.info("show all list......................");
		model.addAttribute("list", service.listAll());	// BoardService와의 연결
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		
		model.addAttribute(service.read(bno));
	}
}
