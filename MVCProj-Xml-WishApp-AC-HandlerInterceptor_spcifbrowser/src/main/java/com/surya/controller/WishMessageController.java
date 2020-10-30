package com.surya.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.surya.service.WishMessageService;

public class WishMessageController extends AbstractController {
	  private WishMessageService service;
	  
	  public WishMessageController(WishMessageService service) {   //cosntructor Injection
		  this.service=service;
	}
	  
	  
		@Override
		public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
				throws Exception {
			String msg=null;
			//use service
			msg=service.generateMessage();
	          //return MAV	     
			return new ModelAndView("result","wmsg",msg);
		}

	}