package com.wipro.eb.entity;

public class Commercial extends Connection{

	public Commercial(int previousReading, int currentReading, float[] slabs) {
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
	
	float billamount=0.0f;
	if(finalamount>=10000) {
		billamount=(float) (finalamount+(finalamount*0.09));
	}
	else if((finalamount>=5000)&&(finalamount <10000)) {
		billamount=(float) (finalamount+(finalamount*0.06));
	}
	else {
		billamount=(float) (finalamount+(finalamount*0.02));
	}
	
	return billamount;
	}

}
