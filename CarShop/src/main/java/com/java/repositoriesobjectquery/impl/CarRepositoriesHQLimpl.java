package com.java.repositoriesobjectquery.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.java.entities.CarDetail;
import com.java.repositoriesobjectquery.CarRepositoriesHQL;

@Repository
public class CarRepositoriesHQLimpl implements CarRepositoriesHQL {
	EntityManagerFactory etmf;
	EntityManager em;

	public CarRepositoriesHQLimpl() {
		// TODO Auto-generated constructor stub
		etmf = Persistence.createEntityManagerFactory("CarShop");
		em = etmf.createEntityManager();
	}

	@Override
	public CarDetail findByCarID(long cadid) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<CarDetail> root = cq.from(CarDetail.class);
		cq.select(root);
		cq.where(cb.equal(root.get("carID").get("carID"), cadid));
		Query query = em.createQuery(cq);
		return (CarDetail) query.getSingleResult();
	}
}
