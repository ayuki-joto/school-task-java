/*
上東　亜佑稀　
544764

*/



public class DrawX{
	public static void main(String[] args) {
		Integer i,x;
		System.out.println("  0123456789");
		for (i=0;i<10;i++) {
			System.out.print(i+":");
			for (x=0;x<10 ;x++ ) {
				if(x==i){
					System.out.print("X");
				}
				else if(i+x==9){
					System.out.print("X");
				
				}
				else{
					System.out.print(" ");}
				

				if (x==9) {
					System.out.println(" ");	
				}
			}

		}

	}
	
}