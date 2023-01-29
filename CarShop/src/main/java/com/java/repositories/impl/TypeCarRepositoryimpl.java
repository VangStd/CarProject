package com.java.repositories.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.java.entities.TypeCar;
import com.java.repositories.TypeCarRepositoriesCustom;
@Repository
public class TypeCarRepositoryimpl implements TypeCarRepositoriesCustom {
	EntityManagerFactory etmf;
	EntityManager em;

	public TypeCarRepositoryimpl() {
		// TODO Auto-generated constructor stub
		etmf = Persistence.createEntityManagerFactory("CarShop");
		em = etmf.createEntityManager();
	}

	@Override
	public long getCountByTypeName(String typeName) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<TypeCar> root = cq.from(TypeCar.class);
		cq.select(cb.count(root.get("typeName")));
		cq.where(cb.equal(root.get("typeName"), typeName));
		Query query = em.createQuery(cq);
		return (long) query.getSingleResult();
	}
}
