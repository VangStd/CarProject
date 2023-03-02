package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.java.entities.AccountConfig;
import com.java.entities.Accounts;
import com.java.entities.TechnicianDetail;
import com.java.repositories.AccountConfigRepository;
import com.java.repositories.AccountRepository;
import com.java.repositories.TechnicianDetailRepository;
import com.java.repositoriesobjectquery.AccountConfigRepositoriesCustom;
import com.java.repositoriesobjectquery.AccountRepositoriesCustom;
import com.java.service.AccountConfigService;

@Service
public class AccountConfigServiceimpl implements AccountConfigService {

	@Autowired
	private AccountRepositoriesCustom accountRepositories;
	@Autowired
	private AccountConfigRepositoriesCustom accountConfigRepositories;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AccountConfigRepository accountConfigRepository;
	@Autowired
	private TechnicianDetailRepository technicianDetailRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public String addUserAccount(AccountConfig accountConfig, BindingResult br, Model model) {
		// TODO Auto-generated method stub
		boolean checkPassword = accountConfig.getAccountID().getPassword()
				.equals(accountConfig.getAccountID().getConfirmpass());
		long checkUsername = accountRepositories.getCountByUsername(accountConfig.getAccountID().getUsername());
		long checkEmail = accountRepositories.getCountByEmail(accountConfig.getAccountID().getEmail());
		long checkPhone = accountConfigRepositories.getCountByPhone(accountConfig.getPhone());
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
		if (checkEmail > 0) {
			br.rejectValue("accountID.email", "Email exist ", "Email exist");
		}
		if (checkPhone > 0) {
			br.rejectValue("phone", "Phone exist ", "Phone exist");
		}
		if (!checkPassword || checkUsername > 0 || checkEmail > 0 || checkPhone > 0) {
			model.addAttribute("acc", accountConfig);
			return "signup";
		} else {
			Accounts accounts = accountConfig.getAccountID();
			accounts.setPassword(bCryptPasswordEncoder.encode(accounts.getConfirmpass()));
			accounts.setRoles("ROLE_USER");
			accounts.setStatus(1);
			System.out.println(accounts.toString());
			accountRepository.save(accounts);
			accountConfig.setAccountID(accounts);
			accountConfigRepository.save(accountConfig);
			return "redirect:/login";
		}
	}

	@Override
	public String addAccountByAdmin(AccountConfig accountConfig, BindingResult br, Model model) {
		// TODO Auto-generated method stub
		long checkUsername = accountRepositories.getCountByUsername(accountConfig.getAccountID().getUsername());
		long checkEmail = accountRepositories.getCountByEmail(accountConfig.getAccountID().getEmail());
		long checkPhone = accountConfigRepositories.getCountByPhone(accountConfig.getPhone());
		if (br.hasErrors()) {
			model.addAttribute("acc", accountConfig);
			return "ad_add_account";
		}

		if (checkUsername > 0) {
			br.rejectValue("accountID.username", "Username exist ", "Username exist");
		}
		if (checkEmail > 0) {
			br.rejectValue("accountID.email", "Email exist ", "Email exist");
		}
		if (checkPhone > 0) {
			br.rejectValue("phone", "Phone exist ", "Phone exist");
		}
		if (checkUsername > 0 || checkEmail > 0 || checkPhone > 0) {
			model.addAttribute("acc", accountConfig);
			System.out.println("Hello");
			return "ad_add_account";
		} else {
			Accounts accounts = accountConfig.getAccountID();
			accounts.setPassword(bCryptPasswordEncoder.encode(accounts.getPassword()));
			accounts.setStatus(1);
			System.out.println(accounts.toString());
			accountRepository.save(accounts);
			accountConfig.setAccountID(accounts);
			accountConfigRepository.save(accountConfig);
			if (accounts.getRoles().contains("TECH")) {
				TechnicianDetail technicianDetail = new TechnicianDetail();
				technicianDetail.setTechnicianID(accounts.getAccountID());
				technicianDetail.setRequest(0);
				technicianDetail.setRequestProcessing(0);
				technicianDetail.setRequestCompleted(0);
				technicianDetail.setMark(0);
				technicianDetailRepository.save(technicianDetail);
			}
			return "redirect:/admin/account-home";
		}
	}

	@Override
	public String addAccountByAdmin(Model model) {
		// TODO Auto-generated method stub
		AccountConfig acc = new AccountConfig();
		model.addAttribute("acc", acc);
		return "ad_add_account";
	}
}
