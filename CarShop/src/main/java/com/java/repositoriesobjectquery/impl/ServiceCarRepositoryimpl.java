package com.java.repositoriesobjectquery.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.java.entities.ServiceCar;
import com.java.repositoriesobjectquery.ServiceCarRepositoriesHQL;

@Repository
public class ServiceCarRepositoryimpl implements ServiceCarRepositoriesHQL {

	EntityManagerFactory etmf;
	EntityManager em;

	public ServiceCarRepositoryimpl() {
		// TODO Auto-generated constructor stub
		etmf = Persistence.createEntityManagerFactory("CarShop");
		em = etmf.createEntityManager();
	}

	@Override
	public long getCountByServiceName(String servicename) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<ServiceCar> root = cq.from(ServiceCar.class);
		cq.select(cb.count(root.get("serviceName")));
		cq.where(cb.equal(root.get("serviceName"), servicename));
		Query query = em.createQuery(cq);
		return (long) query.getSingleResult();
	}
}
