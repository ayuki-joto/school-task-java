import java.util.*;

public class BigAndSmall{
	public static void main(String[] args) {
	Random rand = new Random();
	Integer value = rand.nextInt(10);
	System.out.println(value);
	if(value>4){
	System.out.println("Big");		
	}
	else{
	System.out.println("Small");}
	}
}