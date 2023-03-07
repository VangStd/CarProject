package com.java.repositoriesobjectquery.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.java.entities.OrderService;
import com.java.repositoriesobjectquery.OrderServiceRepositoriesHQL;

@Repository
public class OrderServiceRepositoriesimpl implements OrderServiceRepositoriesHQL {

	EntityManagerFactory etmf;
	EntityManager em;

	public OrderServiceRepositoriesimpl() {
		etmf = Persistence.createEntityManagerFactory("CarShop");
		em = etmf.createEntityManager();
	}

	@Override
	public long getCountOrderIDByTechnicianID(String username) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<OrderService> root = cq.from(OrderService.class);
		cq.select(cb.count(root.get("orderID")));
		cq.where(cb.equal(root.get("processBookingService").get("technicianID").get("username"), username));
		Query query = em.createQuery(cq);
		return (long) query.getSingleResult();
	}

	@Override
	public double getSumPriceOrder(String username) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<OrderService> root = cq.from(OrderService.class);
		cq.select(cb.sum(root.get("price")));
		cq.where(cb.equal(root.get(""), username));
		return 0;
	}
}
