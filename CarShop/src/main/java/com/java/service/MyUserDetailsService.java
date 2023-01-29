package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.entities.Accounts;
import com.java.repositories.AccountRepositoriesCustom;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepositoriesCustom accountRepositories;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Accounts accounts = accountRepositories.loadByUsername(username);
		System.out.println(accounts.getUsername());
		UserDetails details = new User(accounts.getUsername(), accounts.getPassword(), accounts.getListGrant());
		return details;
	}

}
