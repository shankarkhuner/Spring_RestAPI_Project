package com.cyber.CSJ30SpringRestAPI.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cyber.CSJ30SpringRestAPI.dao.TrainServiceImpl;
import com.cyber.CSJ30SpringRestAPI.entity.Train;
import com.cyber.CSJ30SpringRestAPI.exception.InvalidTrainNumber;
import com.cyber.CSJ30SpringRestAPI.service.TrainService;

/*
 *@RestController is class level annotation
 *It is the combination of @Controller annotation and
 *@ResponseBody annotation
 *The annotated can able to create, update ,delete,patch
 *and fetch a resource using 
 *@PostMapping---create a resource
 *@GetMapping---fetch a resource
 * */
 @RestController
public class TrainController
{
	/*
	 *POST-CREATE
	 *PUT-UPDATE-COMPLTE RESOURCE
	 *PATCH-UPDATE PARTIAL RESOURCE
	 *DELETE- DELETE A RESOURCE
	 *GET-FETCH A RESOURCE
	 *
	 * 
*If I will send http request using post method then @PostMapping annoated web method will invoked.
*
* If I will send http request using put  method then @PostMapping annoated web method will invoked.
* If I will send http request using patch method then @PostMapping annoated web method will invoked. 
* If I will send http request using delete method then @PostMapping annoated web method will invoked.
* If I will send http request using get method then @PostMapping annoated web method will invoked.
	*/
	
	@Autowired
	private TrainServiceImpl trainService;
	@PostMapping ("/addTrain")
	public Train createTrainResource(@Valid @RequestBody Train train)
	{
		Train trainObj= trainService.addTrain(train);
		return trainObj;
	}
	
	//url: localhost:5677/getAllTrain
	@GetMapping(path="/getAllTrains")
		
	public Train getAllTrains()
	{
		Train train=new Train();
		train.setTrainNumber(1223);
		train.setTrainName("PUNE-HWH DURONTO EXPRESS");
		train.setSourceStation("PUNE");
		train.setDestinationStation("HOWRAH");
		train.setTrainPrice(5200.00);
		train.setTrainStatus("RUNNING ON MONADY and saturday");
		train.setJourneyDate(LocalDate.now());
		return train;
	}
	
	@GetMapping(path="/getAllTrain")
	public List<Train> getAllTrain()
	{
		return trainService.getAllTrain();
	}
	//url:localhost:5677//getTrainByNumber/1223
	@GetMapping("/getTrainByNumber/{tno}")
	
	public Train getTrainByNumber(@PathVariable int tno) throws InvalidTrainNumber
	{
		return trainService.getTrainByNumber(tno);
	}
	//url:localhost:5677/updateTrain/93
	@PutMapping("/updateTrain/{tno}")
	 public String updateTrainByNumber(@PathVariable int tno, @RequestBody Train train) throws InvalidTrainNumber
	 { int status= trainService.updateTrain(tno, train);
		 if(status>0)
		 {
			 return"train data updated Successfully";
		 }
		 else
		 {
			 return "not able to update";
		 }
	 }
	//url:localhost:5677/deleteTrain/93
	@DeleteMapping("/deleteTrain/{tno}")
	public String deleteTrainDetails(int trainNumber)
	{
		int status=trainService.deleteTrain(trainNumber);
		if(status>0)
		{
			return "train details deleted successfully";
		}
		return "not able to delete";
	}
}
