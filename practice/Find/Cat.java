/*
544764
Ayuki joto
*/
import java.io.*;
import java.util.*;

public class Cat{
	void run(String[] args)throws IOException{
		for (String arg : args ) {

			BufferedReader in = new BufferedReader(
				new FileReader(new File(arg))
			);
			String line;
			while((line = in.readLine()) != null){
				System.out.println(line);
			}
		in.close();
							
		}
	}

	
	

	public static void main(String[] args)throws IOException {
		Cat file =new Cat();
		file.run(args);
	}
}