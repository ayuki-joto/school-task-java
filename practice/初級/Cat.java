/*
544764
Ayuki joto
*/
import java.io.*;
import java.util.*;

public class Cat{
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
					if (Objects.equals(args[i],"--help")) {
						help= true;
						this.showHelp();
						break;

					}
					else if (Objects.equals(args[i],"-h")) {
						help= true;
						this.showHelp();
						break;

					}

				}	
			}	
		
		
	}

	void showHelp(){
		System.out.println("-nもしくは，--numberオプションをつけると行番号を表示する．");
		System.out.println("-Nもしくは，--nameオプションをつけるとファイル名を表示する．");
		System.out.println("-bもしくは，--ignore-blankオプションをつけると空行を無視する．");
		System.out.println("-hもしくは，--helpオプションをつけるとヘルプメッセージを表示し，終了する．");
	}

	void print(String arg,Boolean num,Boolean name,Boolean blank)throws IOException{
	BufferedReader in = new BufferedReader(
		new FileReader(new File(arg)));
	String line;
	Integer number=0;
	if (name==true) {
		System.out.printf("======  %s  ======%n",arg);
	}

	while((line = in.readLine()) != null){
		number++;
		if (blank==true) {
			if (line.length()!=0 ) {
				if (num==true) {
					System.out.printf("	%d: ",number);
					System.out.println(line);		

				}	
				else {
					System.out.println(line);
				}	
			}

				
		}
		else {
			if (num==true) {
				System.out.printf("	%d: ",number);
				System.out.println(line);		

			}	
			else {
				System.out.println(line);
			}
		}

	}
	in.close();
	}



	public static void main(String[] args)throws IOException {
		Cat file =new Cat();
		file.run(args);
	}
}