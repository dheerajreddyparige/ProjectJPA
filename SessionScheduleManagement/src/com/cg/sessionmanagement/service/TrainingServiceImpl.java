package com.cg.sessionmanagement.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.sessionmanagement.dao.ITrainingDAO;
import com.cg.sessionmanagement.model.TrainingDetails;

@Service
@Transactional
public class TrainingServiceImpl implements ITrainingService{

	@Autowired
	ITrainingDAO bookingDao;
	
	@Override
	public ArrayList<TrainingDetails> getAllTrainings() {
		return bookingDao.getAllTrainings();
	}

	@Override
	public String findTrainingName(String name) {
		return bookingDao.findTrainingName(name);
	}

}
