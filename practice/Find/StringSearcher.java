/*
544764
Ayuki joto
*/

import java.io.*;
import java.util.*;

public class StringSearcher{
	void run(String[] args){
		List<Character> chars1 = this.getChars(args[0]);
		List<Character> chars2 = this.getChars(args[1]);

		// Long startTime1 = System.currentTimeMillis();
		// Boolean contain1 =this.contains(chars1, chars2);
		// Long elapsedTime1 =System.currentTimeMillis();

		// Long startTime2 = System.currentTimeMillis();
		// Boolean contain2 =arg[0].contains(args[1]);
		// Long elapsedTime2 =System.currentTimeMillis();
		
		Long startTime1 = System.nanoTime();
		Boolean contain1 =this.contains(chars1, chars2);
		Long elapsedTime1 =System.nanoTime();

		Long startTime2 = System.nanoTime();
		Boolean contain2 =args[0].contains(args[1]);
		Long elapsedTime2 =System.nanoTime();
			
		Long startTime3= System.nanoTime();
		Long elapsedTime3 =System.nanoTime();

		Long startTime4= System.nanoTime();
		Boolean contain3 =this.bmMethod(chars1,chars2);
		Long elapsedTime4 =System.nanoTime();
			

		System.out.printf(
			"%s.contains(%s) : %s%n"
			,args[0],args[1],contain1	
		);
		System.out.println("作成した contains の所要時間 : " +(elapsedTime1- startTime1));
		System.out.println("システムの contains の所要時間 : " +(elapsedTime2- startTime2));
		System.out.println("nanoTime自体の所要時間 : " +(elapsedTime3- startTime3));
		System.out.println("bmMethod の所要時間 : " +(elapsedTime4- startTime4));
	}	

	Boolean bmMethod(List<Character> list1, List<Character> list2){
	// 上記の説明を参考に，skipTableを作成する．
		Map<Character, Integer> skipTable = buildSkipTable(list2);
		for(Integer i = 0; i < list1.size(); ){
			Boolean foundFlag = true;
			for(Integer j = list2.size() - 1; j >= 0; j--){
	    			Integer index = i + j; // list1のインデックス．
	    // indexがlist1の範囲を超えていないかを確認する．
	    // list1.get(index) と list2.get(j) を比較して，一致
	    // しなければ，skipTableからずらす数を取得してiに加算する．
	    // foundFlagもfalseにしてから内側のループを抜ける．
	    			if (index>=list1.size()) {
		    			return false;
		    		}	
		    		
		    		if (list1.get(index) != list2.get(j)) {
		    			Integer num= this.takeMap(skipTable,list1.get(index));
		    			i+=num;
		    			foundFlag=false;
			    		break;
		    		}
		    		

			}
			if (foundFlag) {
				return true;
			}
		}
		return false;
	}

	Integer takeMap(Map<Character,Integer> skipTable, Character list1 ){
		Integer skip;
		skip= skipTable.get(list1);
		if (skip == null) {
			skip=skipTable.get(null);
		}
		return skip;
	}
	
	Map<Character, Integer> buildSkipTable(List<Character> list2){
		Map<Character, Integer> skipTable = new HashMap<Character, Integer>();
		skipTable.put(null , list2.size());
		for(Integer i = 0; i < list2.size(); i++){
			skipTable.put(list2.get(i), list2.size() - i - 1);
		}
		return skipTable;
	}

	Boolean contains(List<Character> list1,List<Character> list2){
		Integer length = list1.size()-list2.size()+1;
		for(Integer i=0 ; i<length;i++){
			if(this.checkSubseqluence(list1,list2,i)){
				return true;
			}

		}
		return false;
	}

	Boolean checkSubseqluence(List<Character> list1,
					List<Character> list2,
					Integer begin){
		for (Integer i=0;i<list2.size() ;i++) {
			Character c1 = list1.get(begin+i);
			Character c2 = list2.get(i);
			if(c1 !=c2){
				return false;
			}
			
		}
		return true;
	}

	List<Character> getChars(String string){
		List<Character> list =new ArrayList<Character>();
		for(Integer i=0; i<string.length(); i++){
			list.add(string.charAt(i));
		}
		return list;
	}


	public static void main(String[] args) {
		StringSearcher string =new StringSearcher();
		string.run(args);
	}
}