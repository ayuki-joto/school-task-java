/*
544764
Ayuki joto
*/
import java.io.*;
import java.util.*;


public class GradeChecker2{



	void run(String[] args)throws IOException{
 		List<StudentID> student = new ArrayList<StudentID>();
 		List<Integer> taskscore=new ArrayList<Integer>();
 		List<Integer>miniscore=new ArrayList<Integer>();
 		List<Double>score=new ArrayList<Double>();
		for (Integer i=0;args.length>i ;i++ ) {	
			if (i==0) {
				this.exam(args[i],student);
			}
			else if (i==1) {
				this.task(args[i],taskscore);
			}
			else if(i==2){
				this.mini(args[i],miniscore);
			}	
		

		}
		for (Integer i =0;student.size()>i ;i++ ) {
			this.fainalscore(student.get(i),taskscore.get(i),miniscore.get(i));
		}
 	}

 	void exam(String arg , List<StudentID>student)throws IOException{
 		Integer num =1;
 		BufferedReader in = new BufferedReader(
		new FileReader(new File(arg)));
		String line;
		String[] terms ={};
		while((line = in.readLine()) != null){
			terms = line.split(",");
			for (Integer j =0;j<terms.length ;j+=2 ) {
				if (!Objects.equals(num, terms[j])) {
						for (;num<Integer.parseInt(terms[j]);num++ ) {
							student.add(this.createStudent(num.toString(),"0.0000"));
						}
					}
				student.add(this.createStudent(terms[j],terms[j+1]));
				num++;
			}		
		}
		in.close();
 	}

 	void task(String arg, List<Integer>taskscore)throws IOException{
 		BufferedReader in = new BufferedReader(
		new FileReader(new File(arg)));
		String line;
		String[] terms ={};
		Integer num=0;
		Integer tem;
		while((line = in.readLine()) != null){
			terms = line.split(",");
			for (Integer j =1;j<terms.length ;j++ ){
				if(j%7!=0){
			 		if (terms[j].length()!=0) {
			 			tem = new Integer(terms[j]);
			 			num+=tem;				
			 		}
			 		else{
			 			tem=0;
			 			num+=tem;
			 		}
			 	}				
			}
			taskscore.add(num);
			num=0;
		}		
		
		in.close();
 	}

 	void mini(String arg, List<Integer>miniscore)throws IOException{
 		BufferedReader in = new BufferedReader(
		new FileReader(new File(arg)));
		String line;
		String[] terms ={};
		Integer num=0;
		Integer number=1;
		while((line = in.readLine()) != null){
			terms = line.split(",");
			if (!Objects.equals(terms[0], number)){
				for(;number<Integer.parseInt(terms[0]);number++){
					miniscore.add(0);		
				}
			}	
			
			for (Integer j =1;j<terms.length ;j++ ){
	 			if (terms[j].length()!=0) {
	 				num++;				
	 			}
			}
			
			number++;
			miniscore.add(num);
			
			num=0;	
		}
		in.close();

 	}

 	StudentID createStudent(String id , String score){
 		StudentID student =new StudentID();
 		Integer value =new Integer(id);
 		student.id = value;
 		Double num =new Double(score);
 		student.score = num;

 		return student;

 		
 	}

 	void fainalscore(StudentID student,Integer taskscore,Integer miniscore){
 		
 		Double scores = Math.ceil(70.0/100.0*student.score+25.0/60.0*taskscore+miniscore/14.0*5.0);
 		Integer score =scores.intValue();
			if(score>=90) {
				System.out.println(student.id+", "+score+", "+student.score+", "+taskscore+", "+miniscore+" , 秀");
			}
			else if(score>=80) {
				System.out.println(student.id+", "+score+", "+student.score+", "+taskscore+", "+miniscore+" , 優");
			}		
			else if(student.score==0.0000) {
				System.out.println(student.id+", "+score+", "+student.score+", "+taskscore+", "+miniscore+" , K");
			}
			else if(score>=70) {
				System.out.println(student.id+", "+score+", "+student.score+", "+taskscore+", "+miniscore+" , 良");
			}
			else if(score>=60) {
				System.out.println(student.id+", "+score+", "+student.score+", "+taskscore+", "+miniscore+" , 可");
			}
			else if(score<60) {
				System.out.println(student.id+", "+score+", "+student.score+", "+taskscore+", "+miniscore+" , 不可");
			}

 	}



 	public static void main(String[] args)throws IOException{
 	GradeChecker2 checker = new GradeChecker2();
 	checker.run(args);	
 	}
}