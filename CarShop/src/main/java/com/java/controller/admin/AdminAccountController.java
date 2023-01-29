package com.java.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.entities.AccountConfig;
import com.java.entities.Accounts;
import com.java.service.AccountConfigService;
import com.java.service.AccountService;

@Controller
public class AdminAccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountConfigService accountConfigService;

	@GetMapping("/admin/account-home")
	public String homeAccount(Model model) {
		// process by entity account
		return accountService.homeAccount(model);
	}

	@GetMapping("/admin/account-create")
	public String addAccount(Model model) {
		// process by entity accountconfig
		return accountConfigService.addAccountByAdmin(model);
	}

	@PostMapping("/admin/account-create")
	public String addAccount(@ModelAttribute("acc") @Valid AccountConfig accountConfig, BindingResult br, Model model) {
		// process by entity accountconfig
		return accountConfigService.addAccountByAdmin(accountConfig, br, model);
	}

	@PostMapping("/admin/account-change-status")
	public String changeStatus(Model model, HttpServletRequest request) {
		// process by entity account
		return accountService.changeStatus(model, request);
	}

	@GetMapping("/admin/account-edit")
	public String editAccount(Model model, @RequestParam("id") long id) {
		return accountService.editAccount(model, id);
	}

	@PostMapping("/admin/account-edit")
	public String editAccount(@ModelAttribute("accEdit") @Valid Accounts accounts, BindingResult br, Model model) {
		return accountService.editAccount(accounts, br, model);
	}

	@PostMapping("/admin/account-delete")
	public String deleteAccount(HttpServletRequest request) {
		return accountService.deleteAccount(request);
	}
}
