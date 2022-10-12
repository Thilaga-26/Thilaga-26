package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	boolean result=false;
	boolean conreading=false;
	boolean contype=false;
	
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
	if((currentReading <previousReading) || (currentReading <0)||(previousReading<0)) {
		throw new InvalidReadingException();
	}
	
	else {
		conreading=true;
	}
	if(!(type.equals("Domestic")||type.equals("Commercial"))) {
	throw new InvalidConnectionException();
	}
	else {
		contype=true;
	}
	
	if(conreading&&contype) {
		result=true;
	}
	
	return result;
}
	
	public float calculateBillAmt(int currentReading, int previousReading, String type) 

	{
		boolean value=false;
		try {
			value=validate(currentReading, previousReading, type);
		} 
		catch (InvalidReadingException e) {
			// TODO Auto-generated catch block
			return -1;
		}
		
		catch (InvalidConnectionException e) {
			// TODO Auto-generated catch block
			return -2;
		}
		
		float bill=0.0f;
		
		if(value==true) {
			if(type.equals("Domestic")) {
				Domestic domestic=new Domestic(previousReading, currentReading,new float[] {2.3f,4.2f,5.5f});
				bill=domestic.computeBill();
			}
			else if(type.equals("Commercial")){
				Commercial commericial=new Commercial(previousReading, currentReading,new float[] {5.2f,6.8f,8.3f} );
				bill=commericial.computeBill();
			}
		
	}
		
	return bill;
}
	
	public String generateBill(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException

	{
		float generatedBill=0.0f;
		
		generatedBill=calculateBillAmt(currentReading, previousReading, type);
		if(generatedBill==-1) {
			throw new InvalidReadingException();
		}
		else if(generatedBill==-2) {
			throw new InvalidConnectionException();
		}
		else {
			return "Amount to be paid: "+generatedBill;
		}
		
		
	}}
