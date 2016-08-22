/*
544764
Ayuki Joto
*/
import java.util.*;


public class ComparingString{
	public static void main(String[] args) {
		String ksu = "KSU_AP";
		for(String arg: args){
			if (Objects.equals(arg,ksu)) {
				System.out.printf("渡された文字列は KSU_AP です%n");
			}
			else {
				System.out.printf("渡された文字列は KSU_AP ではなく、%s です%n",arg);
			}
		}
	}
}