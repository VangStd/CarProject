package com.java.repositoriesobjectquery.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.java.entities.ImageCar;
import com.java.repositoriesobjectquery.ImageCarRepositoriesHQL;

@Repository
public class ImageCarRepositoriesHQLimpl implements ImageCarRepositoriesHQL {

	EntityManagerFactory etmf;
	EntityManager em;

	public ImageCarRepositoriesHQLimpl() {
		// TODO Auto-generated constructor stub
		etmf = Persistence.createEntityManagerFactory("CarShop");
		em = etmf.createEntityManager();
	}

	@Override
	public ImageCar findByCarId(long carID) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<ImageCar> root = cq.from(ImageCar.class);
		cq.select(root);
		cq.where(cb.equal(root.get("carID").get("carID"), carID));
		Query query = em.createQuery(cq);
		return (ImageCar) query.getSingleResult();
	}
}
