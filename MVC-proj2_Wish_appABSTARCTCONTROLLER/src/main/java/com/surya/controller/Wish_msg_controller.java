package com.surya.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.surya.service.WishMsgService;

public class Wish_msg_controller extends AbstractController {

	private WishMsgService service;
	
	public Wish_msg_controller(WishMsgService service) {
		this.service=service;
	}
	
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String msg=null;
		
		msg=service.generateMsg();
		
		return new ModelAndView("result","wmsg",msg);
	}

}
