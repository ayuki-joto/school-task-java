/*
544764 
Joto Ayuki

*/


public class FizzBuzz {

	void run(){
		this.printFizzBuzz(100);
	}

	void printFizzBuzz(Integer max){
		for (Integer i=1;i<=max ;i++ ) {
			if (i%15==0) {	System.out.println("FizzBuzz");	}
			else if (i%3==0) { System.out.println("Fizz");	}
			else if (i%5==0) { System.out.println("Buzz");	}
			else{System.out.println(i);}				
		}
	}





	public static void main(String[] args) {
		FizzBuzz application = new FizzBuzz();
		application.run();
	}
}