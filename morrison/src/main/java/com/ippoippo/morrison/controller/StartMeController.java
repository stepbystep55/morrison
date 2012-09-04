package com.ippoippo.morrison.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ippoippo.morrison.dto.StartMe;
import com.ippoippo.morrison.exception.RecoverableException;
import com.ippoippo.morrison.service.StartMeService;

@Controller
@RequestMapping("/startme")
public class StartMeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	StartMeService startMeService;

	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/list")
	public ModelAndView list() {

		List<StartMe> startMeList = startMeService.list();
		logger.info("startMe list size: " + startMeList.size());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("startMeList", startMeList);
		modelAndView.setViewName("list");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
	public ModelAndView get(@PathVariable Integer id) {

		try {
			StartMe startMe = startMeService.get(id);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("startMe", startMe);
			modelAndView.setViewName("show");
			return modelAndView;

		} catch (RecoverableException e) {
			logger.info(e.getMessage());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("forward:/startme/list");
			return modelAndView;
		}
	}

	@Transactional(rollbackForClassName = "java.lang.Exception")
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/new")
	public ModelAndView create() {

		StartMe startMe = startMeService.newObject();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("startMe", startMe);
		modelAndView.setViewName("create");
		return modelAndView;
	}

	@Transactional(rollbackForClassName = "java.lang.Exception")
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public ModelAndView create(@Valid StartMe startMe, BindingResult result) {

		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("startMe", startMe);
			modelAndView.setViewName("create");
			return modelAndView;
		}

		startMeService.create(startMe);
		logger.info("created successfully: " + startMe);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/startme/get/"+startMe.getId());
		return modelAndView;
	}

	@Transactional(rollbackForClassName = "java.lang.Exception")
	@RequestMapping(method = RequestMethod.POST, value = "/delete")
	public ModelAndView delete(@RequestParam("id") Integer id) {

		startMeService.delete(id);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forward:/startme/list");
		return modelAndView;
	}
}
