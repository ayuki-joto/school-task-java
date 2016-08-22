/*
544764
Ayuki joto
*/
import java.io.*;
import java.util.*;

public class GradeChecker4{



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
		this.fainalscore(student,taskscore,miniscore);
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

 	void fainalscore(List<StudentID> student,List<Integer> taskscore,List<Integer> miniscore){
 		List<Integer> scorelist =new ArrayList<Integer>();
 		Double avgscore=0.0;
 		Double maxscore;
 		Double minscore;
 		Double passAvgscore=0.0;
 		Double passMaxscore;
 		Double passMinscore;
 		Integer pass=0;
 		Grade grade =new Grade();
 		for(Integer i =0; i<student.size(); i++){
			Double scores = Math.ceil(70.0/100.0*student.get(i).score+25.0/60.0*taskscore.get(i)+miniscore.get(i)/14.0*5.0);
			Integer score =scores.intValue();
			scorelist.add(score);
			if(score>=90) {
				if (score>=student.get(i).score.intValue()) {
					System.out.printf("%d, %d, %.3f, %d, %d, 秀%n",student.get(i).id,score,student.get(i).score,taskscore.get(i),miniscore.get(i));
				}
				else{
					System.out.printf("%d, %d, %.3f, %d, %d, 秀%n",student.get(i).id,student.get(i).score.intValue(),student.get(i).score,taskscore.get(i),miniscore.get(i));
				}
				grade.syuu++;
			}
			else if(score>=80) {
				if (90<=Math.ceil(student.get(i).score)) {
					System.out.printf("%d, %d, %.3f, %d, %d, 秀%n",student.get(i).id,student.get(i).score.intValue(),student.get(i).score,taskscore.get(i),miniscore.get(i));
					grade.syuu++;
				}
				else{
					if (score>=student.get(i).score.intValue()) {
						System.out.printf("%d, %d, %.3f, %d, %d, 優%n",student.get(i).id,score,student.get(i).score,taskscore.get(i),miniscore.get(i));
					}
					else{
						System.out.printf("%d, %d, %.3f, %d, %d, 優%n",student.get(i).id,student.get(i).score.intValue(),student.get(i).score,taskscore.get(i),miniscore.get(i));
					}
					grade.yuu++;
			}	}	
			else if(student.get(i).score==0.0000) {
				System.out.printf("%d, %d, %.3f, %d, %d, K%n",student.get(i).id,score,student.get(i).score,taskscore.get(i),miniscore.get(i));
				grade.k++;
			}
			else if(score>=70) {
				if(80<=student.get(i).score.intValue()){
					System.out.printf("%d, %d, %.3f, %d, %d, 優%n",student.get(i).id,student.get(i).score.intValue(),student.get(i).score,taskscore.get(i),miniscore.get(i));
					grade.yuu++;
				}
				else{
					System.out.printf("%d, %d, %.3f, %d, %d, 良%n",student.get(i).id,score,student.get(i).score,taskscore.get(i),miniscore.get(i));
					grade.ryou++;
				}
				
			}
			else if(score>=60) {
				if(80<=student.get(i).score.intValue()){
					System.out.printf("%d, %d, %.3f, %d, %d, 優%n",student.get(i).id,student.get(i).score.intValue(),student.get(i).score,taskscore.get(i),miniscore.get(i));
					grade.yuu++;
				}
				else{
					System.out.printf("%d, %d, %.3f, %d, %d, 可%n",student.get(i).id,score,student.get(i).score,taskscore.get(i),miniscore.get(i));
					grade.ka++;
				}
				
			}
			else if(score<60) {
				if(miniscore.get(i)<=7){
					System.out.printf("%d, %d, %.3f, %d, %d, ※%n",student.get(i).id,score,student.get(i).score,taskscore.get(i),miniscore.get(i));
					grade.kome++;
				}
				else{
					System.out.printf("%d, %d, %.3f, %d, %d, 不可%n",student.get(i).id,score,student.get(i).score,taskscore.get(i),miniscore.get(i));
					grade.huka++;
				}
			}	
		}
		maxscore=scorelist.get(0).doubleValue();
		passMaxscore=scorelist.get(0).doubleValue();
		minscore=scorelist.get(0).doubleValue();
		passMinscore=scorelist.get(0).doubleValue();
		for (Integer j=0;j<scorelist.size();j++ ) {
			if (scorelist.get(j)>=60) {
				passAvgscore+=scorelist.get(j).doubleValue();
				if (passMaxscore<scorelist.get(j)) {
					passMaxscore=scorelist.get(j).doubleValue();
				}
				if (passMinscore>scorelist.get(j)) {
					passMinscore=scorelist.get(j).doubleValue();
				}
				pass++;
			}
			avgscore+=scorelist.get(j).doubleValue();
			if (maxscore<scorelist.get(j)) {
				maxscore=scorelist.get(j).doubleValue();
			}
			if (minscore>scorelist.get(j)) {
				minscore=scorelist.get(j).doubleValue();
			}
		}
		System.out.printf("Avg: %.3f (%.3f)%n",avgscore/scorelist.size(),passAvgscore/pass);
		System.out.println("Max: "+maxscore+" ("+passMaxscore+")");
		System.out.println("Min: "+minscore+" ("+passMinscore+")");
		System.out.println("秀:    "+grade.syuu);
		System.out.println("優:    "+grade.yuu);
		System.out.println("良:    "+grade.ryou);
		System.out.println("可:    "+grade.ka);
		System.out.println("不可:  "+grade.huka);
		System.out.println("K:     "+grade.k);
		System.out.println("※:     "+grade.kome);
		

 	}



 	public static void main(String[] args)throws IOException{
 	GradeChecker4 checker = new GradeChecker4();
 	checker.run(args);	
 	}
}