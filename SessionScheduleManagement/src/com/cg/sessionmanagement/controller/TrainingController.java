package com.cg.sessionmanagement.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.sessionmanagement.model.TrainingDetails;
import com.cg.sessionmanagement.service.ITrainingService;

@Controller
public class TrainingController {

	@Autowired
	ITrainingService service;

	@RequestMapping("/home")
	public String displayPage(Model model) {
		String view = "ScheduledSessions";
		ArrayList<TrainingDetails> list = service.getAllTrainings();
		model.addAttribute("traininglist", list);
		return view;
	}

	@RequestMapping("/enroll")
	public String successPage(Model model,@ModelAttribute("name")String name) {
		String view = "";
		String trainingName = service.findTrainingName(name);
		model.addAttribute("trainingname", trainingName);
		view = "Success";
		return view;
	}
}
