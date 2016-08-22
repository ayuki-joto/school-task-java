/*
544764
Ayuki Joto
*/


import java.io.*;
import java.util.*;


public class FrequencyViewer{

	public void run(String[] args)throws IOException{
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		for (Integer i=0;args.length>i ;i++ ) {	
			BufferedReader in = new BufferedReader(
				new FileReader(new File(args[i]))
			);
			String[] terms ={};
			String line;
			Integer size=0;
			while((line = in.readLine()) != null){
			 terms = line.split("[ \t]");
				for (String word :terms) {					
					if (wordMap.containsKey(word.toLowerCase())) {
						wordMap.put(word.toLowerCase(), wordMap.get(word.toLowerCase())+1);
					}
					else{
						wordMap.put(word.toLowerCase(),1);
					}
				}
			}
			for(Map.Entry<String, Integer> entry : wordMap.entrySet()) {
      				 System.out.println(entry.getKey() + ": " + entry.getValue());
      			 }
		}
	}


	public static void main(String[] args) throws IOException{
		FrequencyViewer vi = new FrequencyViewer();
		vi.run(args);
	}
}