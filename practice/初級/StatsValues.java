/*
544764
Ayuki Joto
*/
import java.util.*;

public class StatsValues{
	public static void main(String[] args) {
		Number num = new Number();
		for(Integer i=0;i<=100;i++){
			Random rand =new Random();
			Integer value = rand.nextInt(1000);
			num.numbers.add(value);
		}

		num.max = num.numbers.get(0);
		num.minimum = num.numbers.get(0);
		
		for (Integer i=1;i<=100;i++) {
			if (num.max<num.numbers.get(i)) {
				num.max =num.numbers.get(i);
			}	
		}

		for (Integer i=1;i<=100;i++) {
			if (num.minimum>num.numbers.get(i)) {
				num.minimum =num.numbers.get(i);
			}	
		}

		num.sum = num.numbers.get(0);
		for (Integer i=1;i<=100;i++) {
			num.sum+=num.numbers.get(i);	
		}

		num.average=new Double(num.sum/100);

		System.out.printf("合計: "+num.sum+", 最大値: "+num.max+", 最小値: "+num.minimum+", 平均値: "+num.average);
		for (Integer i=0;i<=100;i++) {
			if (i%10==0) {
				System.out.println(num.numbers.get(i));	
			}
			else{
				System.out.print(num.numbers.get(i)+"  ");		
			}
		}
	}
}