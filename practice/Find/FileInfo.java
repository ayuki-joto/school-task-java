/*
544764
Ayuki joto
*/
import java.io.*;
import java.util.*;

public class FileInfo{
	void run (String[] args){
		for (String arg : args) {
			this.showInfo(new File(arg));
		}
	}

	void showInfo(File file){
		String name = file.getName();
		Long size = file.length();
		if(file.isFile()){
			System.out.println(name+": file, "+size+"　bytes");
		}
		else{
			System.out.println(name+": directory, "+size+"　bytes");
		}
		
	}

	public static void main(String[] args) {
		FileInfo info = new FileInfo();
		info.run(args);
	}
}