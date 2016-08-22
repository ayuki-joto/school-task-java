/*
544764
Ayuki Joto
*/


import java.io.*;
import java.util.*;

public class WordCount{
	public void run(String[] args)throws IOException{
		System.out.println("char    word    line");
		Integer size[] ={0,0,0};

		if (args.length != 0){

			for (Integer i=0;args.length-1>=i ;i++ ) {
			 	File dir = new File(args[i]);
         				System.out.println(charcount(dir)+"	"+ wordCount(dir)+"     "+linecount(dir)+"    "+args[i] ); 
         				size[0]+=charcount(dir);
         				size[1]+=wordCount(dir);
         				size[2]+=linecount(dir);	
        			}

		}
		if (args.length>1) {
        			System.out.println(size[0]+"      "+size[1]+"     "+size[2]+"      "+"Total");
		}

			
		
	}

	Integer linecount(File dir)throws IOException{
		BufferedReader in = new BufferedReader(
			new FileReader(dir));
		String line;
		Integer liner=0;
		while((line = in.readLine()) != null){
			if (line.length()!=0) {
				liner++;				
			}
		}
		in.close();
		return  liner;	
	}

	Integer wordCount(File dir)throws IOException{
		BufferedReader in = new BufferedReader(
			new FileReader(dir));
		String line;
		String[] terms ={};
		Integer size=0;
		while((line = in.readLine()) != null){
			 terms = line.split("[ \t]");
			for (String word :terms) {
				 if (word.length() !=0 ) {
				 	size++;
				 }
			}
		}
		
		return size;
	}

	Integer charcount(File dir)throws IOException{
		FileReader freader = new FileReader(dir);
		char buf[] =new char[2048];
		Integer size=freader.read(buf);
		freader.close();
		return size;
	}

	public static void main(String[] args) throws IOException{
		WordCount wc =new WordCount();
		wc.run(args);
	}
}