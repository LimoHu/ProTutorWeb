package com.ssm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/HomePage")
public class HomePageController {

	/**
	 * 访问首页
	 * @return
	 */
	@RequestMapping(value="/toHomePage")
	public ModelAndView toLogin()throws Exception{
		return new ModelAndView("HomePage");
	}
}
