/*
544764
Ayuki Joto
*/
import java.util.*;

public class MontecarloPi{

	public void  run(String[] args){
		Double hit=0.0;
		Double num;
		if (args.length == 0) {
			num=1000.0;
		}	
		else{
			num=Double.parseDouble(args[0]); 
		}

		for (Double i =num; i>0 ; i-- ) {
				Double x =this.rand();
				Double y =this.rand();
				if (this.math(x,y)) {
					hit++;			
				}
			}

		Double pi =hit/num*4;
		System.out.printf("pi  =  %f %n",pi);

	}

	public Double rand(){
		Random rand =new Random();
		Double value = rand.nextDouble();
		return value;
	}

	public Boolean math(Double x,Double y){
		Double num =Math.sqrt(x*x+y*y);
		if (num<1.0) {
			return true;
		}
		else{
			return false;
		}
	}



	public static void main(String[] args) {
		MontecarloPi monte =new MontecarloPi();
		monte.run(args);
	}
}