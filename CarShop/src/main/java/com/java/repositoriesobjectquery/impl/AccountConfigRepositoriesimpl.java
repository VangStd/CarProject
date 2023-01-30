package com.java.repositoriesobjectquery.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.java.entities.AccountConfig;
import com.java.repositoriesobjectquery.AccountConfigRepositoriesCustom;

@Repository
public class AccountConfigRepositoriesimpl implements AccountConfigRepositoriesCustom {

	EntityManagerFactory etmf;
	EntityManager em;

	public AccountConfigRepositoriesimpl() {
		etmf = Persistence.createEntityManagerFactory("CarShop");
		em = etmf.createEntityManager();
	}

	@Override
	public long getCountByPhone(String phone) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<AccountConfig> root = cq.from(AccountConfig.class);
		cq.select(cb.count(root.get("phone")));
		cq.where(cb.equal(root.get("phone"), phone));
		Query query = em.createQuery(cq);
		return (long) query.getSingleResult();
	}

	@Override
	public AccountConfig getByAccountID(long accountId) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<AccountConfig> root = cq.from(AccountConfig.class);
		cq.select(root);
		cq.where(cb.equal(root.get("accountID"), accountId));
		Query query = em.createQuery(cq);
		return (AccountConfig) query.getSingleResult();
	}
}
