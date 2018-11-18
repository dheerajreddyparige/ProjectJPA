package com.cg.sessionmanagement.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.SetAttribute;

import org.springframework.stereotype.Repository;

import com.cg.sessionmanagement.model.TrainingDetails;

@Repository
public class TrainingDAOImpl implements ITrainingDAO {

	@PersistenceContext
	EntityManager manager;

	@Override
	public ArrayList<TrainingDetails> getAllTrainings() {
		ArrayList<TrainingDetails> list = new ArrayList<>();
		String jpql = "Select training from TrainingDetails training";
		TypedQuery<TrainingDetails> query = manager.createQuery(jpql, TrainingDetails.class);
		list = (ArrayList<TrainingDetails>) query.getResultList();
		return list;
	}

	@Override
	public String findTrainingName(String name) {
		String jpql ="Select training.name from TrainingDetails training where training.name =:pname";
		TypedQuery<String> query = manager.createQuery(jpql,String.class);
		query.setParameter("pname", name);
		String trainingName = query.getSingleResult();
		return trainingName;
	}
}
