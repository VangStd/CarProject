package com.java.service;

import javax.transaction.Transactional;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.java.entities.AccountConfig;

public interface AccountConfigService {

	@Transactional
	String addUserAccount(AccountConfig accountConfig, BindingResult br, Model model);

	// admin
	String addAccountByAdmin(Model model);

	String addAccountByAdmin(AccountConfig accountConfig, BindingResult bt, Model model);

}
