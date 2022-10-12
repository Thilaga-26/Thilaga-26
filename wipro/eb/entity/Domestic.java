package com.wipro.eb.entity;

public class Domestic extends Connection {

	public Domestic(int previousReading, int currentReading, float[] slabs) {
		//700 820 5.3,4.2...
		
		super(previousReading, currentReading, slabs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float computeBill() {
		
		float finalamount=0.0f;
		int unitsconsumed=currentReading-previousReading;
		
		if(unitsconsumed<=50) {
		finalamount=unitsconsumed*slabs[0];	
		}
		
		//75
		else if(unitsconsumed>50&&unitsconsumed<=100) {
		finalamount=50*slabs[0]+(unitsconsumed-50)*slabs[1];	
		}
		//120=>50+50+20
		else {
		finalamount=(50*slabs[0]+50*slabs[1]+(unitsconsumed-100)*slabs[2]);	
		}
		
		return finalamount;
	}

}
