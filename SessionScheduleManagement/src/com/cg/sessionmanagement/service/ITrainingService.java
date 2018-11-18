package com.cg.sessionmanagement.service;

import java.util.ArrayList;

import com.cg.sessionmanagement.model.TrainingDetails;

public interface ITrainingService {

	public ArrayList<TrainingDetails> getAllTrainings();

	public String findTrainingName(String name);

}
