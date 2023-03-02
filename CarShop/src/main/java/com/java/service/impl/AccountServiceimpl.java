package com.java.service.impl;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.java.entities.AccountConfig;
import com.java.entities.Accounts;
import com.java.repositories.AccountConfigRepository;
import com.java.repositories.AccountRepository;
import com.java.repositoriesobjectquery.AccountConfigRepositoriesCustom;
import com.java.repositoriesobjectquery.AccountRepositoriesCustom;
import com.java.service.AccountService;

@Service
public class AccountServiceimpl implements AccountService {

	@Autowired
	private AccountRepositoriesCustom accountRepositories;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountConfigRepositoriesCustom accountConfigRepositoriesCustom;

	@Autowired
	private AccountConfigRepository accountConfigRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<Accounts> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Accounts loadByUsername(String username) {
		// TODO Auto-generated method stub
		return accountRepositories.loadByUsername(username);
	}

	@Override
	public String homeAccount(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("listAccount", accountRepository.findAll());
		return "ad_index_account";
	}

	@Override
	public String addUserAccount(AccountConfig accountConfig, BindingResult br, Model model) {
		// TODO Auto-generated method stub
		boolean checkPassword = accountConfig.getAccountID().getPassword()
				.equals(accountConfig.getAccountID().getConfirmpass());
		long checkUsername = accountRepositories.getCountByUsername(accountConfig.getAccountID().getUsername());
		if (br.hasErrors()) {
			model.addAttribute("acc", accountConfig);
			return "signup";
		}
		if (!checkPassword) {
			br.rejectValue("accountID.confirmpass", "Confirm Password incorrect ", "Confirm Password incorrect ");
		}
		if (checkUsername > 0) {
			br.rejectValue("accountID.username", "Username exist ", "Username exist");
		}
		if (!checkPassword || checkUsername > 0) {
			model.addAttribute("acc", accountConfig);
			return "signup";
		}

		return "signup";
	}

	@Override
	public String changeStatus(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		long id = Long.parseLong(request.getParameter("accID"));
		System.out.println("-----------------------" + id);
		Accounts accounts = accountRepository.findById(id).get();
		if (accounts != null) {
			if (accounts.getStatus() == 1) {
				accounts.setStatus(0);
			} else {
				accounts.setStatus(1);
			}
			accountRepository.save(accounts);
		}
		return "redirect:/admin/account-home";
	}

	@Override
	public String editAccount(Model model, long id) {
		// TODO Auto-generated method stub
		Accounts accounts = accountRepository.findById(id).get();
		String[] roles = { "ROLE_POST", "ROLE_USER", "ROLE_STAFF" };
		model.addAttribute("listRoles", roles);
		model.addAttribute("accEdit", accounts);
		System.out.println(accounts.getUsername());
		return "ad_edit_account";
	}

	@Override
	public String editAccount(Accounts accounts, BindingResult br, Model model) {
		// TODO Auto-generated method stub
		if (!accounts.getConfirmpass().equals("")) {
			accounts.setPassword(bCryptPasswordEncoder.encode(accounts.getConfirmpass()));
		}
		accountRepository.save(accounts);
		return "redirect:/admin/account-home";
	}

	@Override
	public String deleteAccount(HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			long id = Long.parseLong(request.getParameter("accID"));
			AccountConfig accountConfig = accountConfigRepositoriesCustom.getByAccountID(id);
			accountConfigRepository.deleteById(accountConfig.getId());
			accountRepository.deleteById(id);
			return "redirect:/admin/account-home";
		} catch (Exception e) {
			// TODO: handle exception
			return "err";
		}
	}

	@Override
	public String homeRequestTech(Model model, Principal principal) {
		String[] status = { "None", "Processing", "Completed" };
		Accounts techAccount = accountRepositories.loadByUsername(principal.getName());
		model.addAttribute("tech", techAccount);
		model.addAttribute("listStatus", status);
		return "tech_index_request";
	}

}
