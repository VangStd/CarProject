package com.java.repositoriesobjectquery.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.java.entities.Accounts;
import com.java.repositoriesobjectquery.AccountRepositoriesCustom;

@Repository
public class AccountRepositoriesimpl implements AccountRepositoriesCustom {

	EntityManagerFactory etM;
	EntityManager em;

	public AccountRepositoriesimpl() {
		etM = Persistence.createEntityManagerFactory("CarShop");
		em = etM.createEntityManager();
	}

	@Override
	public Accounts loadByUsername(String username) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<Accounts> root = cq.from(Accounts.class);
		cq.select(root);
		cq.where(cb.and(cb.equal(root.get("username"), username), cb.equal(root.get("status"), 1)));
		Query query = em.createQuery(cq);
		return (Accounts) query.getSingleResult();
	}

	@Override
	public long getCountByUsername(String username) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<Accounts> root = cq.from(Accounts.class);
		cq.select(cb.count(root.get("username")));
		cq.where(cb.equal(root.get("username"), username));
		Query query = em.createQuery(cq);
		return (long) query.getSingleResult();
	}

	@Override
	public long getCountByEmail(String email) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<Accounts> root = cq.from(Accounts.class);
		cq.select(cb.count(root.get("email")));
		cq.where(cb.equal(root.get("email"), email));
		Query query = em.createQuery(cq);
		return (long) query.getSingleResult();
	}

	@Override
	public List<Accounts> findAllByRolesTech() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<Accounts> root = cq.from(Accounts.class);
		cq.select(root);
		cq.where(cb.equal(root.get("roles"), "ROLE_TECH"));
		Query query = em.createQuery(cq);
		return query.getResultList();
	}
}
