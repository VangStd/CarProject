package com.java.repositoriesobjectquery.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.java.entities.OrderServiceDetail;
import com.java.repositoriesobjectquery.OrderServiceDetailRepositoriesHQL;

@Repository
public class OrderServiceDetailRepositoriesimpl implements OrderServiceDetailRepositoriesHQL {

	EntityManagerFactory etmf;
	EntityManager em;

	public OrderServiceDetailRepositoriesimpl() {
		etmf = Persistence.createEntityManagerFactory("CarShop");
		em = etmf.createEntityManager();
	}

	@Override
	public double getSumPriceOrder(String username) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<OrderServiceDetail> root = cq.from(OrderServiceDetail.class);
		cq.select(cb.sum(root.get("price")));
		cq.where(cb.equal(root.get("orderID").get("processBookingService").get("technicianID").get("username"),
				username));
		Query query = em.createQuery(cq);
		return (double) query.getSingleResult();
	}

	@Override
	public long getCountOrderIDByUsernameTechAndMonth(String tech, String month) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<OrderServiceDetail> root = cq.from(OrderServiceDetail.class);
		cq.select(cb.count(root.get("orderID").get("orderID")));
		cq.where(cb.and(cb.like(root.get("orderID").get("bookDate"), "%-" + month + "-%"),
				cb.equal(root.get("orderID").get("processBookingService").get("technicianID").get("username"), tech)));
		Query query = em.createQuery(cq);
		return (long) query.getSingleResult();
	}
}
