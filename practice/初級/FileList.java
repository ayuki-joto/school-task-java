/*
544764
Ayuki Joto
*/


import java.io.*;
import java.util.*;


public class FileList{
	public void run(String[] args)throws ArrayIndexOutOfBoundsException{
		

		if (args.length != 0) {
			for (Integer i=0;args.length-1>=i ;i++ ) {
			 	File dir = new File(args[i]);	
			 	if (dir.isDirectory()) {
					for(File file: dir.listFiles()){

         						System.out.println(file);
         					}
				}
				else if(dir.isFile()) {

         					System.out.println(dir);
				}		
			}
		}

		else {
			File  dir = new File(".");
			for(File file: dir.listFiles()){

         				System.out.println(file);
         			}
		}

	}

	public static void main(String[] args)throws ArrayIndexOutOfBoundsException {
		FileList file =new FileList();
		file.run(args);
	}
}