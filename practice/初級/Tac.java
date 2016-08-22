/*
544764
Ayuki joto
*/
import java.io.*;
import java.util.*;

public class Tac{
	void run(String[] args)throws IOException{
		Boolean num=false;
		Boolean name=false;
		Boolean blank=false;
		Boolean help=false;

		for (Integer i=0;args.length>i ;i++ ) {	
			File dir = new File(args[i]);	
			 	if (dir.isFile()) {
			 		this.print(args[i],num,name,blank);
				}
				else {
					if (Objects.equals(args[i],"-n")) {
						num= true;
					}
					
					else if (Objects.equals(args[i],"--number")) {
						num= true;
					}
					if (Objects.equals(args[i],"-N")) {
						name= true;
					}
					else if (Objects.equals(args[i],"--name")) {
						name= true;
					}	
					if (Objects.equals(args[i],"-b")) {
						blank= true;
					}

					else if (Objects.equals(args[i],"--ignore-blank")) {
						blank= true;
					}
			
							
				}

		}
	}

	
	void print(String arg,Boolean num,Boolean name,Boolean blank)throws IOException{	
		BufferedReader in = new BufferedReader(
				new FileReader(new File(arg))
			);
			String line;
			if (name==true) {
				System.out.printf("======  %s  ======%n",arg);
			}

			List<String> word=new ArrayList<String>();
			while((line = in.readLine()) != null){
				word.add(line);
			}
			for (Integer i = word.size()-1;i >=0;i-- ) {

				if (blank==true) {
					if (word.get(i).length()!=0 ) {
						if (num==true) {
							System.out.printf("	%d: ",i);
							System.out.println(word.get(i));		

						}	
						else {
							System.out.println(word.get(i));	
						}	
					}

				
				}		
				else {
					if (num==true) {
						System.out.printf("	%d: ",i);
						System.out.println(word.get(i));	

					}	
					else {
						System.out.println(word.get(i));
					}
				}
			}
		in.close();
	}

	public static void main(String[] args)throws IOException {
		Tac file =new Tac();
		file.run(args);
	}
}