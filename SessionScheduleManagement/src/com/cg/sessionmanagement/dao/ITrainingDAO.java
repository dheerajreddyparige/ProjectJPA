package com.cg.sessionmanagement.dao;

import java.util.ArrayList;

import com.cg.sessionmanagement.model.TrainingDetails;

public interface ITrainingDAO {
	public ArrayList<TrainingDetails> getAllTrainings();

	public String findTrainingName(String name);
}
