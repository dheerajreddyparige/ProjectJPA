package com.capgemini.trg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import com.capgemini.trg.exception.QueryException;
import com.capgemini.trg.model.Query;
import com.capgemini.trg.service.IQueryService;

@Controller
public class QueryController {

	@Autowired
	private IQueryService queryService;
	
	@RequestMapping(value="home")
	public  String showUserForm() {
		/*Query c=new Query();
		return new ModelAndView("home","query",c);*/
		return "home";
	}
	
	@RequestMapping(value="answerthequery", method=RequestMethod.GET)
	public ModelAndView processForm(  @ModelAttribute("query") Integer query,@ModelAttribute("solution")String solution,@ModelAttribute("option") String option) throws QueryException{

		    Query q=queryService.getQueryAnswers(query);
		    try{
			Integer dh=queryService.updateQueryDetails(query,solution,option);
			return new ModelAndView("success","update",q.getQueryId());
		    }catch(QueryException e){
		    	return new ModelAndView("home","update",new Query());
		    }
	}
				
}
