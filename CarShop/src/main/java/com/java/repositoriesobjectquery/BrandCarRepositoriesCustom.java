package com.java.repositoriesobjectquery;

public interface BrandCarRepositoriesCustom {

	long getCountByBrandname(String brandname);

	long getCountByCompanyname(String companyname);

	long getCountByPhone(String phone);
}
