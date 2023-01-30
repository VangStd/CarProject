package com.java.repositoriesobjectquery;

import com.java.entities.AccountConfig;

public interface AccountConfigRepositoriesCustom {

	long getCountByPhone(String phone);

	AccountConfig getByAccountID(long accountId);
}
