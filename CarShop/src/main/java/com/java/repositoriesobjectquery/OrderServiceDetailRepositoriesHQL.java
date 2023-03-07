package com.java.repositoriesobjectquery;

public interface OrderServiceDetailRepositoriesHQL {
	
	double getSumPriceOrder(String username);
	
	long getCountOrderIDByUsernameTechAndMonth(String tech,String month);
}
