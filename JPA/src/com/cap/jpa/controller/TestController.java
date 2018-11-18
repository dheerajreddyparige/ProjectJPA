package com.cap.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cap.jpa.model.TestBean;
import com.cap.jpa.service.ITestService;

@Controller
public class TestController {
	@Autowired
	ITestService service;

	/*@RequestMapping("/home")
	public String home(Model model) {
		String view = "technicalform";
		ArrayList<HotelDetails> list = service.getAllHotels();
		model.addAttribute("hotellist", list);
		return view;
	}*/

	@RequestMapping("/home")
	public ModelAndView answer(@RequestParam("queryID") Integer queryID){
		
		TestBean query= service.findqueryID(queryID);
		
		return new ModelAndView("answerform","all",query.getQueryID());
	}
	/*@RequestMapping("/feed")
	public String feed(@PathVariable("all"),Model model){
		String view = "";
		TestBean query= (TestBean)service.findqueryID(queryID);
		model.addAttribute("queryID", query);
		view = "answerfrom";
		return view;*/
	}



