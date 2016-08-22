

public class MethodAccess  {




	void run(){
		this.greet("ayuki");
			
	}


	void greet(String name){
		
		System.out.print("Hello");
		System.out.println(name);

	}




	public static void main(String[] args) {

		MethodAccess application = new MethodAccess();
	 	application.run();

		
	}
	
}