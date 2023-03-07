package com.java.service;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface TechHomeService {

	String homeTech(Model model, Principal principal);

	String drawChartByTech(Model model, Principal principal);

	String sendRequestChangeTech(HttpServletRequest request,Principal principal);
	
	String homeNotificationTech(Model model);
}
