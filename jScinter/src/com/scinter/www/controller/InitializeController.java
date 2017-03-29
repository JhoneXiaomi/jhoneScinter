package com.scinter.www.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class InitializeController {

	Logger logger = Logger.getLogger(InitializeController.class);
	@RequestMapping("initialize")
	public ModelAndView initialize(
			@RequestParam(value="controlledCompany",defaultValue="sczs")String controlledCompany,
			HttpServletResponse response,HttpSession session){
		
		logger.info("the current company name is: " + controlledCompany);
		ModelAndView model = new ModelAndView();
		session.setAttribute("controlledCompany", controlledCompany);
		if(controlledCompany.equals("rrlzs")){
			
			model.setViewName("admin/designerList");
		}else{
			
			model.setViewName("admin/caseList");
		}
		
		return model;
	}
	
}
