/*
544764
Ayuki joto
*/


import java.io.*;
import java.util.*;

public class FileFinder{
	void run(String[] args)throws IOException{
		this.printArgs(args);
		Arguments arguments = parseArguments(args);
		List<File> resultList =find(arguments);
		this.printResult(resultList,arguments);
	}

	void traverse(Arguments arguments,List<File> files,File folder)throws IOException{
		  if(this.isTarget(arguments, folder)){
       			 files.add(folder);
       			}
		//System.out.printf("traverse(%s)%n",folder);
		if(folder.isDirectory()){
			if(arguments.help == null){
				for (File item : folder.listFiles()) {	
					this.traverse(arguments,files,item);
				}
			}
		}
	}

	Boolean isTarget(Arguments args, File file)throws IOException{
		if(args.type != null){
			if (Objects.equals(args.type,"d") && !file.isDirectory()) {
				return false;
			}
			if (Objects.equals(args.type,"f") && !file.isFile()) {
				return false;
			}
		}
		if (args.name != null) {
			if (!Objects.equals(file.getName(),args.name)) {
				return false;			
			}		
		}
		if(args.maximum != null){
			Long size = file.length();
			if (size>args.maximum){
				return false;
			}
		}
		if (args.minimum !=null) {	
			Long size= file.length();
			if (size<args.minimum) {
				return false;
			}
		}

		if(args.grep != null && file.isFile()){
			if (!this.isContaiined(args.grep, file)) {
				return false;
			}
		}
	
	return true;
	}

	Boolean isContaiined(String keyword, File file)throws IOException{
		BufferedReader in =new BufferedReader(
			new FileReader(file)
		);
		Boolean flag =false;
		String line;
		while((line=in.readLine()) != null){
			if (line.contains(keyword)) {
				flag=true;
				break;
			}
			
		}
		in.close();
		return flag;
	}


	Arguments parseArguments(String[] args){
		Arguments arguments =new Arguments();
		arguments.directory =new File(args[0]);
		for (Integer i=0 ;i<args.length ;i++ ) {
			if(Objects.equals(args[i],"-help")){
				this.showHelp();
				arguments.help=true;
			}
			else if(Objects.equals(args[i],"-type")){
				i++;
				arguments.type=args[i];
			}			
			else if(Objects.equals(args[i],"-name")){
				i++;
				arguments.name=args[i];
			}			
			else if(Objects.equals(args[i],"-maximum")){
				i++;
				arguments.maximum=new Integer(args[i]);;
			}			
			else if(Objects.equals(args[i],"-minimum")){
				i++;
				arguments.minimum=new Integer(args[i]);
			}		
			else if(Objects.equals(args[i],"-grep")){
				i++;
				arguments.grep=args[i];
			}
			else if(Objects.equals(args[i],"-output")){
				i++;
				arguments.output=args[i];
			}
			


		}

		return arguments;
	}

	void showHelp(){
		System.out.println("java FileFinder [OPTIONS] <DIR>");
		System.out.println("DIR:");
		System.out.println("    検索を開始するディレクトリを指定する．必須項目．");
		System.out.println("OPTIONS:");
		System.out.println("    -help:            ヘルプメッセージを表示して終了する（検索しない）．");
		System.out.println("    -name <NAME>:     ファイル名・ディレクトリ名で検索する．NAMEは必須．");
		System.out.println("    -type <d|f>:      ファイルの種別で検索する．dはディレクトリ，fはファイルを指す．");
		System.out.println("                      dもしくはfのどちらかを必ず指定する．");
		System.out.println("                      このオプション自体を指定しない場合，両方を検索する．");
		System.out.println("    -maximum <SIZE>:  ファイルサイズが指定のサイズ（SIZE）より小さいものを検索する．");
		System.out.println("    -minimum <SIZE>:  ファイルサイズが指定のサイズ（SIZE）より大きいものを検索する．");
		System.out.println("    -grep <STRING>:   内容に指定された文字列（STRING）が含まれているファイルを検索する．");
	}


	List<File> find(Arguments arguments)throws IOException{
		List<File> file =new ArrayList<File>();
		this.traverse(arguments,file,arguments.directory);
		return file;
	}

	void printResult(List<File> file, Arguments arguments)throws FileNotFoundException{
		PrintWriter out;
		if(arguments.output == null){
		    out = new PrintWriter(System.out);
		}
		else{
		    out = new PrintWriter(arguments.output);
		}
	
		for(File directory : file){
			out.println(directory);
			//System.out.println(directory);
		}	
		out.close();
	}

	void printArgs(String[] args){
		Integer num =0;
		for (String arg: args) {
			System.out.println(num+":"+arg);
			num++;
		}
	}

	public static void main(String[] args)throws IOException {
		FileFinder lib =new FileFinder();
		lib.run(args);
	}
}