package com.java.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.entities.AccountConfig;
import com.java.entities.Accounts;
import com.java.service.AccountConfigService;
import com.java.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountConfigService accountConfigService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/login-success")
	public String loginSuccess(Principal principal) {
		Accounts accounts = accountService.loadByUsername(principal.getName());
		if (accounts.getRoles().contains("ADMIN")) {
			return "redirect:/admin/home";
		} else {
			return "redirect:/home";
		}
	}

	@GetMapping("/logout-success")
	public String logout() {
		return "redirect:/login";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		AccountConfig accountConfig = new AccountConfig();
		model.addAttribute("acc", accountConfig);
		return "signup";
	}

	@PostMapping("/signup")
	public String post_signup(@ModelAttribute("acc") @Valid AccountConfig accountConfig, BindingResult br,
			Model model) {
		return accountConfigService.addUserAccount(accountConfig, br, model);

	}

	@GetMapping("/403")
	public String page403(Principal principal,Model model) {
		if(principal == null) {
			model.addAttribute("msg", "You");
		}else {
			model.addAttribute("msg", principal.getName());
		}
		return "403";
	}

}
