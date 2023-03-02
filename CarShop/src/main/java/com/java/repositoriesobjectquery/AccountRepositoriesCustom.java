package com.java.repositoriesobjectquery;


import com.java.entities.Accounts;

public interface AccountRepositoriesCustom {
	
	Accounts loadByUsername(String username);

	long getCountByUsername(String username);

	long getCountByEmail(String email);

}
