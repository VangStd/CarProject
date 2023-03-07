package com.java.service.impl;

import java.security.Principal;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.google.gson.Gson;
import com.java.dto.MonthOfYearDTO;
import com.java.entities.Accounts;
import com.java.entities.OrderService;
import com.java.entities.RequestChangeTechnician;
import com.java.repositories.AccountRepository;
import com.java.repositories.OrderServiceRepository;
import com.java.repositories.RequestChangeTechnicianRepository;
import com.java.repositoriesobjectquery.AccountRepositoriesCustom;
import com.java.repositoriesobjectquery.OrderServiceDetailRepositoriesHQL;
import com.java.repositoriesobjectquery.OrderServiceRepositoriesHQL;
import com.java.service.TechHomeService;

@Service
public class TechHomeServiceimpl implements TechHomeService {

	@Autowired
	private RequestChangeTechnicianRepository requestChangeTechnicianRepository;

	@Autowired
	private OrderServiceRepository orderServiceRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private OrderServiceRepositoriesHQL orderServiceRepositoriesHQL;

	@Autowired
	private OrderServiceDetailRepositoriesHQL orderServiceDetailRepositoriesHQL;

	@Autowired
	private AccountRepositoriesCustom accountRepositoriesCustom;

	@Override
	public String homeTech(Model model, Principal principal) {
		model.addAttribute("amountOrder",
				orderServiceRepositoriesHQL.getCountOrderIDByTechnicianID(principal.getName()));
		model.addAttribute("amountSale", orderServiceDetailRepositoriesHQL.getSumPriceOrder(principal.getName()));

		return "tech_index";
	}

	@Override
	public String drawChartByTech(Model model, Principal principal) {
		String month = "";
		MonthOfYearDTO monthOfYearDTO;
		Gson gson = new Gson();
		long[] saveAmountMonth = new long[12];
		for (int i = 1; i <= 12; i++) {
			if (i < 10) {
				month = "0" + i;
			} else {
				month = i + "";
			}
			long amount = orderServiceDetailRepositoriesHQL.getCountOrderIDByUsernameTechAndMonth(principal.getName(),
					month);
			saveAmountMonth[i - 1] = amount;
		}
		monthOfYearDTO = new MonthOfYearDTO(saveAmountMonth[0] + "", saveAmountMonth[1] + "", saveAmountMonth[2] + "",
				saveAmountMonth[3] + "", saveAmountMonth[4] + "", saveAmountMonth[5] + "", saveAmountMonth[6] + "",
				saveAmountMonth[7] + "", saveAmountMonth[8] + "", saveAmountMonth[9] + "", saveAmountMonth[10] + "",
				saveAmountMonth[11] + "");
		String json = gson.toJson(monthOfYearDTO);
		System.out.println(json);
		return json;
	}

	@Override
	public String sendRequestChangeTech(HttpServletRequest request, Principal principal) {
		LocalDate today = LocalDate.now();
		int orderID = Integer.parseInt(request.getParameter("orderID"));
		long techID = Long.parseLong(request.getParameter("techID"));
		OrderService orderService = orderServiceRepository.findById(orderID).get();
		Accounts techReciever = accountRepository.findById(techID).get();
		Accounts techSender = accountRepositoriesCustom.loadByUsername(principal.getName());
		RequestChangeTechnician requestChangeTechnician = new RequestChangeTechnician();
		requestChangeTechnician.setDate(today.toString());
		requestChangeTechnician.setOrderID(orderService);
		requestChangeTechnician.setTechnicianReceiver(techReciever);
		requestChangeTechnician.setTechnicianSender(techSender);
		requestChangeTechnician.setStatus("0");
		requestChangeTechnicianRepository.save(requestChangeTechnician);
		return "redirect:/tech/home-request";
	}

	@Override
	public String homeNotificationTech(Model model) {
		// TODO Auto-generated method stub
		return "tech_notification";
	}

}
