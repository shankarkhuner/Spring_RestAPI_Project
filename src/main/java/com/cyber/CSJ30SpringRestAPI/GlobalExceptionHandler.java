package com.cyber.CSJ30SpringRestAPI;

import java.time.LocalDate;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyber.CSJ30SpringRestAPI.exception.ErrorMessage;
import com.cyber.CSJ30SpringRestAPI.exception.InvalidTrainNumber;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ResponseBody
	@ExceptionHandler(InvalidTrainNumber.class)
	public ErrorMessage checkForInvalidTrain(InvalidTrainNumber e)
	{
		ErrorMessage msg=new ErrorMessage(e.getMessage(),LocalDate.now());
		return msg;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	 public ErrorMessage checkForValidation(MethodArgumentNotValidException e)
	 {
		
		/*MethodArgumentNotValidException is the inbuilt exception class inside
		 * org.springframework.web.bind.MethodArgumentNotValidException; packge.
		 * 
		 * 
		 * The object of the above exception class provides a method called 
		 * getBindingResult()---BindingResult object
		 * from that binding result object we are invoking getFieldError()--- FieldError
		 * Field Error
		 * from that field Error object we can invoked
		 */
ErrorMessage msg=new ErrorMessage(e.getBindingResult().getFieldError().getDefaultMessage(),LocalDate.now())	;
return msg;
	 }

}
