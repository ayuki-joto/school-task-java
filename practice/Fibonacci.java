public class Fibonacci  {
	void run(){
		printFibonacciSeries(20);

	}
	void printFibonacciSeries(Integer max){
		Integer f1=0;
		Integer f0=1;

		for (int i=0;i<=20 ;i++ ) {
			if(i==0){
				System.out.printf("%d : %d %n",0,0);
			}
			else if (i==1) {
				System.out.printf("%d : %d%n",0,1);
			}
			else{
				Integer f2= f1+f0;
				System.out.printf("%d : %d%n",i,f2);
				f0=f1;
				f1=f2;
			}
		}
	}

	public static void main(String[] args) {
		Fibonacci fibonacci =new Fibonacci();
		fibonacci.run();
	}

		
}