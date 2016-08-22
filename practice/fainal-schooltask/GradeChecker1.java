/*
544764
Ayuki joto
*/
import java.io.*;
import java.util.*;

public class GradeChecker1{

 	void run(String[] args)throws IOException{
 		List<StudentID> student = new ArrayList<StudentID>();
 		for (Integer i=0;args.length>i ;i++ ) {	
			 BufferedReader in = new BufferedReader(
			new FileReader(new File(args[i])));
			String line;
			String[] terms ={};
			while((line = in.readLine()) != null){
				 terms = line.split(",");
				for (Integer j =0;j<terms.length ;j+=2 ) {
					student.add(this.createStudent(terms[j],terms[j+1]));
				}			
			
			}
		in.close();
		}
		this.checke(student);
 	}

 	StudentID createStudent(String id , String score){
 		StudentID student =new StudentID();
 		Integer value =new Integer(id);
 		student.id = value;
 		Double num =new Double(score);
 		student.score = num;

 		return student;

 		
 	}

 	void checke(List<StudentID> student){
 		Integer num =1;
 		StudentID stu = new StudentID();
 		for (Integer i = 0;student.size()>i ;i++) {
 			stu=student.get(i);
 			if (!Objects.equals(num, stu.id)) {
 				for (;num<stu.id ;num++ ) {
 					System.out.println(num+", 0.000 ,K,"z); 					
 				}
 				
 			}

			if(stu.score>=90) {
				System.out.println(stu.id+", "+stu.score+" , 秀");
			}
			else if(stu.score>=80) {
				System.out.println(stu.id+", "+stu.score+" , 優");
			}
			else if(stu.score>=70) {
				System.out.println(stu.id+", "+stu.score+" , 良");
			}
			else if(stu.score>=60) {
				System.out.println(stu.id+", "+stu.score+" , 可");
			}
			else if(stu.score<60) {
				System.out.println(stu.id+", "+stu.score+" , 不可");
			}
			num++;
 		}

 	}



 	public static void main(String[] args)throws IOException{
 	GradeChecker1 checker = new GradeChecker1();
 	checker.run(args);	
 	}
 }