package com.ippoippo.morrison.controller;

import java.net.UnknownHostException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ippoippo.morrison.service.SystemCheckService;

@Controller
@RequestMapping("/sys")
public class HealthCheckController {

	@Inject
	SystemCheckService systemCheckService;

	@RequestMapping(method=RequestMethod.GET, value="/hchk")
	public ModelAndView healthCheck(HttpServletRequest request) {
		
		long startTime = System.currentTimeMillis();
		
		String instanceName = "unknown";
		String status = "error";

		if (systemCheckService.isAlive()) status = "alive";

		String hostName = "unknown";
		try {
			hostName = java.net.InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) { }
		
		long time = System.currentTimeMillis() - startTime;
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("contextPath", request.getContextPath());
		modelAndView.addObject("instanceName", instanceName);
		modelAndView.addObject("hostName", hostName);
		modelAndView.addObject("status", status);
		modelAndView.addObject("time", time);
		modelAndView.setViewName("healthCheck");
		return modelAndView;
	}
}
