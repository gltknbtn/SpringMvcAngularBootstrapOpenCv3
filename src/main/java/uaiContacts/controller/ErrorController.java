package uaiContacts.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
	@RequestMapping(value = "/error")
	@ResponseBody
	public ModelAndView handle(ModelMap model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("errorPage");
		modelAndView.addObject("status", request.getAttribute("javax.servlet.error.status_code"));
		modelAndView.addObject("reason", request.getAttribute("javax.servlet.error.message"));
		modelAndView.addObject("exception", request.getAttribute("javax.servlet.error.exception"));
		
		return modelAndView;
	}
}
