/*
544764
Ayuki joto
*/


public class Fibonacci2{
	void run(){
		this.printFibonacciSeries(20);
	}

	void printFibonacciSeries(Integer number){
		for (Integer i=0;i<=number ;i++ ) {
			Integer num=this.getFibonacciValues(i);
			System.out.printf("FibonacciValues (%s)%n",num);

		}

	}
	Integer getFibonacciValues(Integer number){
		if (number==0) {
			return 0;
		}
		if (number==1) {
			return 1;
		}
		else{
			return getFibonacciValues(number-2)+getFibonacciValues(number-1);
		}
	}

	public static void main(String[] args) {
		new Fibonacci2().run();
	}
}