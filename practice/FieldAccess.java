public  class FieldAccess  {
	
	String name;

	void run(){
		name="ayuki";
		System.out.println(name);
	}



	 public static void main(String[] args) {

	 	FieldAccess application = new FieldAccess();
	 	application.run();

	}

	
}