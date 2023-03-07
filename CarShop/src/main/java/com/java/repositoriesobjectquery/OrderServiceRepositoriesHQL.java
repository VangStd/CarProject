package com.java.repositoriesobjectquery;

public interface OrderServiceRepositoriesHQL {

	long getCountOrderIDByTechnicianID(String username);

	double getSumPriceOrder(String username);
}
