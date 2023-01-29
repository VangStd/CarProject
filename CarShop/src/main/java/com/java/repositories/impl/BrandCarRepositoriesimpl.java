package com.java.repositories.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.java.entities.BrandCar;
import com.java.repositories.BrandCarRepositoriesCustom;

@Repository
public class BrandCarRepositoriesimpl implements BrandCarRepositoriesCustom {

	EntityManagerFactory etmf;
	EntityManager em;

	public BrandCarRepositoriesimpl() {
		// TODO Auto-generated constructor stub
		etmf = Persistence.createEntityManagerFactory("CarShop");
		em = etmf.createEntityManager();
	}

	@Override
	public long getCountByBrandname(String brandname) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<BrandCar> root = cq.from(BrandCar.class);
		cq.select(cb.count(root.get("brandName")));
		cq.where(cb.equal(root.get("brandName"), brandname));
		Query query = em.createQuery(cq);
		return (long) query.getSingleResult();
	}

	@Override
	public long getCountByCompanyname(String companyname) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<BrandCar> root = cq.from(BrandCar.class);
		cq.select(cb.count(root.get("companyName")));
		cq.where(cb.equal(root.get("companyName"), companyname));
		Query query = em.createQuery(cq);
		return (long) query.getSingleResult();
	}
}
