package com.cyber.CSJ30SpringRestAPI.service;

import java.util.List;

import com.cyber.CSJ30SpringRestAPI.entity.Train;
import com.cyber.CSJ30SpringRestAPI.exception.InvalidTrainNumber;

public interface TrainService {

	public Train addTrain(Train train);
	public List<Train> getAllTrain();
	public Train getTrainByNumber(int trainNumber)throws InvalidTrainNumber;
	public int updateTrain(int trainNumber, Train newTrain) throws InvalidTrainNumber;
	public int deleteTrain(int trainNumber)throws InvalidTrainNumber;
	
}
