/*
544764
Ayuki Joto
*/
import java.util.*;

public class TrapezoidalRulePi{
	public void run(String[] args){
		Double size;
		if (args.length==0) {
			size = 0.01;
		}
		else{
			size=Double.parseDouble(args[0]);
		}

		Double sum =0.0;

		for (Double i=0.0; i+size<1 ; i+=size) {

			sum += this.math(i,i+size);
		}
		
		Double pi =sum*4;	
		System.out.println("pi = "+pi);
	}

	public Double math(Double x1,Double x2){

		Double high1 =Math.sqrt(1-x1*x1);
		Double high2 =Math.sqrt(1-x2*x2);
		Double sum = (x2-x1)*(high1+high2)/2;

		return sum;
	}

	public static void main(String[] args) {
		TrapezoidalRulePi tra = new TrapezoidalRulePi();
		tra.run(args);
	}
}