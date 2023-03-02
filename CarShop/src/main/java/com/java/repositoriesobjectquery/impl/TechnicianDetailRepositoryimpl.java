package com.java.repositoriesobjectquery.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.java.entities.TechnicianDetail;
import com.java.repositoriesobjectquery.TechnicianDetailRepositoriesHQL;

@Repository
public class TechnicianDetailRepositoryimpl implements TechnicianDetailRepositoriesHQL {

	EntityManagerFactory etmf;
	EntityManager em;

	public TechnicianDetailRepositoryimpl() {
		etmf = Persistence.createEntityManagerFactory("CarShop");
		em = etmf.createEntityManager();
	}

	@Override
	public TechnicianDetail findByRequestProcessingDESC() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<TechnicianDetail> root = cq.from(TechnicianDetail.class);
		Order order = cb.asc(root.get("request"));
		cq.select(root);
		cq.orderBy(order);
		Query query = em.createQuery(cq);
		return (TechnicianDetail) query.setMaxResults(1).getSingleResult();
	}
}
