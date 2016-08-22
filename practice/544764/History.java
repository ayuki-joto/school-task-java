/*
544764
Ayuki Joto
*/
import java.util.*;

public class History{

	Date lendDate;
	Date returnDate;
	Book book;
	User user;
	String lend;



	Boolean isLend(){
		if (returnDate  == null) {
			return true;
		}
		return false;
	}

	void print(){
		if (this.isLend()) {
			 lend="貸し出し中";
			System.out.println(book.title+","+book.authors+","+book.publisher+","+book.publishYear
			+"("+lend+")"+user.name+"("+user.gender+";"+user.age+")"+lendDate+"~");


		}
		else{ lend = "配架中";

			System.out.println(book.title+","+book.authors+","+book.publisher+","+book.publishYear
				+"("+lend+")"+user.name+"("+user.gender+";"+user.age+")"+lendDate+"~"+returnDate);


		}


	}


}
