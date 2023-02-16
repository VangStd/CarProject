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

import com.java.entities.Car;
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

	@Override
	public long getCountByProductname(String productName) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<Car> root = cq.from(Car.class);
		cq.select(cb.count(root.get("productName")));
		cq.where(cb.equal(root.get("productName"), productName));
		Query query = em.createQuery(cq);
		return (long) query.getSingleResult();
	}

	@Override
	public List<Car> findAllByStatus() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<Car> root = cq.from(Car.class);
		cq.select(root);
		cq.where(cb.equal(root.get("status"), "1"));
		Query query = em.createQuery(cq);
		return (List<Car>) query.getResultList();
	}
}
