/*
544764
Ayuki joto
*/
import java.io.*;

public class FileViewer{
	void run() throws IOException{
		BufferedReader in = new BufferedReader(
		    new FileReader(new File("file.txt"))
		);
		String line;
		while((line = in.readLine()) != null){
			System.out.println(line);
		}
		in.close();
	}

	public static void main(String[] args) throws IOException{
		FileViewer file =new FileViewer();
		file.run();
	}
}