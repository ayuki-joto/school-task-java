/*
544764
Ayuki Joto
*/
import java.util.*;

public class EuclideanAlgorithm{

	public void run(String[] args){
		Integer ans;
		Integer num[]=new Integer[2];
		for (Integer i=0;i<args.length;i++ ) {
			num[i] = new Integer(args[i]);
		}

		if (num[0]>num[1]) {
			ans =this.gcd(num[0],num[1]);
		}
		else {
			ans =this.gcd(num[1],num[0]);
		}

		Integer ans2 = num[0]*num[1]/ans;

		System.out.printf("lcn(%s , %s )= %d %n",args[0],args[1],ans2);
		System.out.printf("gcd(%s , %s )= %d %n",args[0],args[1],ans);
	}

	public Integer gcd(Integer num,Integer num1){
		Integer ans;
		while((ans=num%num1 )!= 0){
				num=num1;
				num1=ans;
			}
		return num1;
	}


	public static void main(String[] args) {
		EuclideanAlgorithm euc =new EuclideanAlgorithm();
		euc.run(args);
	}
}