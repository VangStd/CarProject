package com.java.service.impl;

import java.security.Principal;
import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.google.gson.Gson;
import com.java.dto.BookServiceDTO;
import com.java.dto.ServiceCarDTO;
import com.java.entities.Accounts;
import com.java.entities.OrderService;
import com.java.entities.OrderServiceDetail;
import com.java.entities.ProcessBookingService;
import com.java.entities.ServiceCar;
import com.java.entities.TechnicianDetail;
import com.java.repositories.AccountRepository;
import com.java.repositories.CarRepository;
import com.java.repositories.OrderServiceDetailRepository;
import com.java.repositories.OrderServiceRepository;
import com.java.repositories.ProcessBookingServiceRepository;
import com.java.repositories.ServiceCarRepository;
import com.java.repositories.TechnicianDetailRepository;
import com.java.repositoriesobjectquery.AccountRepositoriesCustom;
import com.java.repositoriesobjectquery.ServiceCarRepositoriesHQL;
import com.java.repositoriesobjectquery.TechnicianDetailRepositoriesHQL;
import com.java.service.ServiceCar_ServiceLayer;

@Service
public class ServiceCar_ServiceLayerimpl implements ServiceCar_ServiceLayer {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ServiceCarRepository serviceCarRepository;

	@Autowired
	private OrderServiceRepository orderServiceRepository;

	@Autowired
	private OrderServiceDetailRepository orderServiceDetailRepository;

	@Autowired
	private ProcessBookingServiceRepository processBookingServiceRepository;

	@Autowired
	private TechnicianDetailRepository technicianDetailRepository;

	@Autowired
	private ServiceCarRepositoriesHQL serviceCarRepositoriesHQL;

	@Autowired
	private TechnicianDetailRepositoriesHQL technicianDetailRepositoriesHQL;

	@Autowired
	private AccountRepositoriesCustom accountRepositoriesCustom;

	@Override
	public String homeServiceCar(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("listServiceCar", serviceCarRepository.findAll());
		return "ad_index_servicecar";
	}

	@Override
	public String addServiceCar(Model model) {
		// TODO Auto-generated method stub
		ServiceCar serviceCar = new ServiceCar();
		model.addAttribute("servicecar", serviceCar);
		return "ad_add_servicecar";
	}

	@Override
	public String addServiceCar(ServiceCar serviceCar, BindingResult br, Model model) {
		// TODO Auto-generated method stub
		long checkServiceName = serviceCarRepositoriesHQL.getCountByServiceName(serviceCar.getServiceName());
		if (br.hasErrors()) {
			model.addAttribute("servicecar", serviceCar);
			return "ad_add_servicecar";
		}
		if (checkServiceName > 0) {
			br.rejectValue("serviceName", "500", "Service name exist ");
			model.addAttribute("servicecar", serviceCar);
			return "ad_add_servicecar";
		} else {
			serviceCarRepository.save(serviceCar);
		}
		return "redirect:/admin/home-servicecar";
	}

	@Override
	public String editServiceCar(Model model, long id) {
		// TODO Auto-generated method stub
		ServiceCar serviceCar = serviceCarRepository.findById(id).get();
		model.addAttribute("servicecar", serviceCar);
		return "ad_edit_servicecar";
	}

	@Override
	public String editServiceCar(ServiceCar serviceCar, BindingResult br, Model model, HttpServletRequest request,
			long id) {
		// TODO Auto-generated method stub
		String oldNameService = request.getParameter("oldNameService");
		boolean checkServiceName = oldNameService.equals(serviceCar.getServiceName());
		if (br.hasErrors()) {
			model.addAttribute("servicecar", serviceCar);
			return "ad_edit_servicecar";
		}
		if (!checkServiceName) {
			long checkServiceNameExist = serviceCarRepositoriesHQL.getCountByServiceName(serviceCar.getServiceName());
			if (checkServiceNameExist > 0) {
				br.rejectValue("serviceName", "500", "Service name exist ");
				model.addAttribute("servicecar", serviceCar);
				return "ad_edit_servicecar";
			} else {
				serviceCarRepository.save(serviceCar);
			}
		} else {
			serviceCarRepository.save(serviceCar);
		}
		return "redirect:/admin/home-servicecar";
	}

	@Override
	public String deleteServiceCar(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		long id = Long.parseLong(request.getParameter("ServiceID"));
		serviceCarRepository.deleteById(id);
		return "redirect:/admin/home-servicecar";
	}

	@Override
	public String serviceCarUser(Model model) {
		// TODO Auto-generated method stub
		BookServiceDTO bookServiceDTO = new BookServiceDTO();
		model.addAttribute("listService", serviceCarRepository.findAll());
		model.addAttribute("booking", bookServiceDTO);
		return "service";
	}

	@Override
	public String bookingService(BookServiceDTO bookServiceDTO, BindingResult br, Model model, Principal principal) {
		// TODO Auto-generated method stub
		if (br.hasErrors()) {
			model.addAttribute("listService", serviceCarRepository.findAll());
			model.addAttribute("booking", bookServiceDTO);
			return "service";
		}
		LocalDate now = LocalDate.now();
		Date dateNowSql = Date.valueOf(now);
		LocalDate bookDate = LocalDate.parse(bookServiceDTO.getDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		boolean checkDate = now.isAfter(bookDate);
		long checkRange = now.compareTo(bookDate);
		System.out.println(now.compareTo(bookDate) + " " + checkDate);
		if (checkDate) {
			model.addAttribute("listService", serviceCarRepository.findAll());
			model.addAttribute("booking", bookServiceDTO);
			br.rejectValue("date", "500", "Date must to day 3 days");
			return "service";
		} else {
			ServiceCar serviceCar = serviceCarRepository.findById(bookServiceDTO.getServiceid()).get();
			Accounts accounts = accountRepositoriesCustom.loadByUsername(principal.getName());
			OrderService orderService = new OrderService();
			TechnicianDetail technicianDetail = technicianDetailRepositoriesHQL.findByRequestProcessingDESC();
			Accounts technician = accountRepository.findById(technicianDetail.getTechnicianID()).get();
			orderService.setBookDate(now + "");
			orderService.setCustomerID(accounts);
			orderService.setNote(bookServiceDTO.getNote());
			orderService.setOrderDate(bookDate + "");
			orderService.setNameOnInvoice(bookServiceDTO.getYourname());
			orderService.setPhoneOnInvoice(bookServiceDTO.getYourphone());
			orderService.setEmailOnInvoice(bookServiceDTO.getYouremail());
			orderService.setStatus("None");
			orderServiceRepository.save(orderService);
			// orderDetail
			OrderServiceDetail orderServiceDetail = new OrderServiceDetail();
			orderServiceDetail.setOrderID(orderService);
			orderServiceDetail.setPrice(serviceCar.getPrice());
			orderServiceDetail.setServiceID(serviceCar);
			orderServiceDetailRepository.save(orderServiceDetail);
			// processing-booking
			ProcessBookingService processBookingService = new ProcessBookingService();
			processBookingService.setOrderID(orderService.getOrderID());
			processBookingService.setReceivedDate(dateNowSql);
			processBookingService.setTechnicianID(technician);
			processBookingService.setStatus("None");
			processBookingServiceRepository.save(processBookingService);
			// process-detail
			technicianDetail.setRequest(technicianDetail.getRequest() + 1);
			technicianDetailRepository.save(technicianDetail);
		}
		return "redirect:/service";
	}

	@Override
	public String changeStatusBookingServiceByTech(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int orderID = Integer.parseInt(request.getParameter("orderID"));
		String status = request.getParameter("status");
		System.out.println("--------------------" + orderID + " " + status);
		OrderService orderService = orderServiceRepository.findById(orderID).get();
		System.out.println("--------------------" + orderService.getCustomerID().getAccountID());
		TechnicianDetail technicianDetail = technicianDetailRepository
				.findById(orderService.getProcessBookingService().getTechnicianID().getAccountID()).get();
		orderService.setStatus(status);
		orderServiceRepository.save(orderService);
		technicianDetail.setRequest(technicianDetail.getRequest() - 1);
		if (status.equals("Processing")) {
			technicianDetail.setRequestProcessing(technicianDetail.getRequestProcessing() + 1);
		}
		if (status.equals("Completed")) {
			technicianDetail.setRequestCompleted(technicianDetail.getRequestCompleted() + 1);
			sendMailNotifComplete(orderService.getEmailOnInvoice(), orderService.getNameOnInvoice(), technicianDetail.getAccounts().getUsername());
		}
		technicianDetailRepository.save(technicianDetail);
		
		return "redirect:/tech/home-request";
	}

	@Override
	public String serviceCarDetailUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		long id = Long.parseLong(request.getParameter("serviceID"));
		ServiceCar serviceCar = serviceCarRepository.findById(id).get();
		ServiceCarDTO serviceCarDTO = new ServiceCarDTO(serviceCar.getServiceID(), serviceCar.getServiceName(),
				serviceCar.getPrice(), serviceCar.getServiceDescription());
		Gson gson = new Gson();
		String json = gson.toJson(serviceCarDTO);
		return json;
	}

	private void sendMailNotifComplete(String email, String user, String tech) {
		try {
			Properties mailServerProperties;
			Session getMailSession;
			MimeMessage mailMessage;
			mailServerProperties = System.getProperties();
			mailServerProperties.put("mail.smtp.port", "587");
			mailServerProperties.put("mail.smtp.auth", "true");
			mailServerProperties.put("mail.smtp.starttls.enable", "true");
			getMailSession = Session.getDefaultInstance(mailServerProperties, null);
			mailMessage = new MimeMessage(getMailSession);
			mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			mailMessage.setSubject("Vang Service Car");
			mailMessage.setText("Hello " + user + " ! Your car has by Technician " + tech);
			Transport transport = getMailSession.getTransport("smtp");
			transport.connect("smtp.gmail.com", "dkquanga20139@cusc.ctu.edu.vn", "0984961735");
			transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("------------"+e);
		}
	}

}
