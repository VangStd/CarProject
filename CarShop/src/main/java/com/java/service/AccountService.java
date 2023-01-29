package com.java.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.entities.AccountConfig;
import com.java.entities.Accounts;

public interface AccountService {

	List<Accounts> findAll();

	Accounts loadByUsername(String username);

	//admin
	
	String addUserAccount(AccountConfig accountConfig, BindingResult br, Model model);

	String changeStatus(Model model, HttpServletRequest request);
	
	String homeAccount(Model model);
	
	String editAccount(Model model,long id);
	
	String editAccount( Accounts accounts,BindingResult br,Model model);
	
	String deleteAccount(HttpServletRequest request);
	

}
