/*
544764
Ayuki Joto
*/
import java.util.*;

public class Library{

	List<Book> shelf = new ArrayList<Book>();
	UserManager manager=new UserManager();	
	Map<Book, List<History>> historyMap =new HashMap<Book,List<History>>();


	void run(){
		this.printWelcomeMessage();
		this.addBooks(shelf);
		this.registerUsers();
		System.out.println("-------全ユーザー表示-------");
		Iterator<User> iterator;

		iterator = this.iterator();

		for(; iterator.hasNext();){
			User user=iterator.next();
			this.print(user);
		}






		//this.find("");

		//this.list();

		/*for(Integer i = 0; i < shelf.size(); i++){
			Book book1= shelf.get(i);
			this.printBook(book1);			
		}*/       

		/*Book foundBook = this.find("羅生門");
		//this.printBook(foundBook);
		this.remove(foundBook);
		this.list();
		*/
		List<Book> foundList = this.findAnd( null, null, null, 7);
		for (Book book : foundList) {
			this.printBook(book);
			
		}
		this.remove2("あ","い","う",7);
		this.list();

		this.runLend();
		this.runFindHistory();


		//List<Book> foundList = this.findOr( "羅生門", null, null, 2006);
		//for (Book book : foundList) {
	//		this.printBook(book);
	//	}

		//this.findAndprint("羅生門", null, null, null);
		
	}

	/**************************book.csvの本をリストに追加する*******************************/

	void addBooks(List<Book> shelf){
		LibraryUtil util = new LibraryUtil();
		List<Book> books = util.readFromFile("books.csv");
		for(Integer i = 0; i < books.size(); i++){
		shelf.add(books.get(i));
		}        
	}

	/**************************リスト内を順番に表示*******************************/

	void list(){
		for(Book book: shelf) {
			this.printBook(book);	
		}

	}

	/**************************本の情報を表示*******************************/

	void printBook(Book book){

		System.out.printf("%s (%s) %s, %d%n",
			book.title, book.authors, book.publisher, book.publishYear);

	}

	/**************************タイトルから本を検索する*******************************/

	Book find(String title){

		for (Book book: shelf) {
			if (Objects.equals(title,book.title)) {
				
				return book;			
			}
			
		}

		return null;
	}

	/**************************本を削除する*******************************/

	void remove(Book book){
		shelf.remove(book);
	}

	/**************************本を追加して削除する*******************************/
	void remove2(String title, String author, String publisher, Integer publishYear){
		Book book = createBook(title, author, publisher, publishYear);
		shelf.remove(book);
	}

	/**************************And検索で見つけた本を表示する*******************************/

	void findAndprint(String title, String authors, String publisher, Integer publishYear){
		List<Book> foundList = this.findAnd(title,authors,publisher,publishYear);
		for (Book book : foundList) {
			this.printBook(book);
		}

	}
	/**************************Or検索*******************************/
	List<Book> findOr(String title, String authors, String publisher, Integer publishYear){
		List<Book> result = new ArrayList<Book>();
		for (Book book: shelf) {
			if (this.orMatch(book, title, authors, publisher, publishYear)) {
				result.add(book);
				
			}
			
		}
		return result;

	}
	/**************************Or検索の条件*******************************/
	Boolean orMatch(Book book, String title,String authors, String publisher,Integer publishYear){
		if (title !=null && Objects.equals(book.title, title)) {	
			return true;
			
		}
		if (authors !=null && Objects.equals(book.authors, authors)) {	
			return true;
		}
		if (publisher !=null && Objects.equals(book.publisher, publisher)) {	
			return true;
		}
		if (publishYear !=null && Objects.equals(book.publishYear, publishYear)) {	
			return true;
		}
		return false;	
	}	

	/**************************And検索*******************************/

	List <Book> findAnd(String title, String authors, String publisher, Integer publishYear){
		List<Book> result = new ArrayList<Book>();

		for (Book book: shelf) {
			if (this.isMatch(book, title, authors, publisher, publishYear)) {
				result.add(book);
				
			}
			
		}
		return result;
	}
	
	/**************************And検索の条件*******************************/

	Boolean isMatch(Book book, String title,String authors, String publisher,Integer publishYear){
		if (title !=null && !Objects.equals(book.title, title)) {	
			return false;
			
		}
		if (authors !=null && !Objects.equals(book.authors, authors)) {	
			return false;
		}
		if (publisher !=null && !Objects.equals(book.publisher, publisher)) {	
			return false;
		}
		if (publishYear !=null && !Objects.equals(book.publishYear, publishYear)) {	
			return false;
		}
		return true;
	}
	
	/**************************本を作る*******************************/

	Book createBook(String title, String authors,String publisher,Integer publishYear){
		Book book = new Book();
		book.title = title;
		book.authors = authors;
		book.publisher = publisher;
		book.publishYear = publishYear;

		return book;
	}

	/**************************貸し出しする人の情報を追加する*******************************/

	void registerUsers(){
		manager.add(manager.createUser("三村","女",19));
		manager.add(manager.createUser("田中","女",16));
		manager.add(manager.createUser("川口","女",23));
		manager.add(manager.createUser("山田","女",40));
		manager.add(manager.createUser("木村","女",36));
					
	}

	/**************************Iterator宣言*******************************/

	public Iterator<User> iterator(){
		return manager.iterator();
	}

	/**************************貸し出しデータ作成*******************************/

	History createHistory(User user, Book book){
		History history = new History();
		history.user=user;
		history.book =book;
		history.lendDate= new Date();
		return history;
	}

	/***************************貸し出し履歴を作る******************************/

	Boolean registerHistory(History history){
		List<History> histories = historyMap.get(history.book);
		if (histories ==null) {
			histories=new ArrayList<History>();
			historyMap.put(history.book, histories);			
		}
		if (this.canLend(history,histories)) {
			histories.add(history);
			return true;	
		}
		return false;
	}

	/**************************貸し出し可能かどうかの判定*******************************/

	Boolean canLend(History history,List<History> histories){
		if (!shelf.contains(history.book)) {
			return false;
		}
		if (histories.size() > 0) {
			History lastHistory=histories.get(histories.size() -1);
			if (lastHistory.isLend()) {
				return false;
			}
		}
		return true;
	}

	/**************************貸し出し処理*******************************/

	History lend(User user, Book book){
		History history =new History();
		if(this.registerHistory(this.createHistory(user,book))){
			return history;
		}
		else{
			System.out.print("貸し出し失敗");

			return null;

		}
	}

	/**************************lendを行うための処理*******************************/

	void runLend(){
		User user1=manager.find("三村",null,null).get(0);
		User user2=manager.find("田中",null,null).get(0);
		User user3=manager.find("川口",null,null).get(0);
		User user4=manager.find("山田",null,null).get(0);
		User user5=manager.find("木村",null,null).get(0);
		
		Book book1=this.find("羅生門");
		Book book2=this.find("星の王子さま");
		Book book3=this.find("ハリー・ポッターと賢者の石");
		Book book4=this.find("ダレン・シャン―奇怪なサーカス");
		Book book5=this.find("羅生門");


		this.lend(user1, book1);
		this.lend(user2, book2);
		this.lend(user3, book3);
		this.lend(user4, book4);
		this.lend(user5, book5);

		this.printHistories();

	}

	/**************************貸し出し情報を表示*******************************/

	void printHistories(){

		for (Map.Entry<Book, List<History>> entry:historyMap.entrySet()) {
			Book book =entry.getKey();
			List<History> histories = entry.getValue();
				
			for (History history : histories ) {
				System.out.println("  		");
				history.print();
				
			}

		}	
	}

	/**************************貸し出し履歴表示するための処理*******************************/

	List<History> findHistory(Book book ,User user){
		List<History> history =new ArrayList<History>();
		if (book != null) {
			List<History> map = historyMap.get(book);
			for(History hist:map){
				if (user != null) {
					if (Objects.equals(hist.user,user)) {
						history.add(hist);
					}
				}
				else{
					history.add(hist);
				}
			}
		}
		else{
			for (List<History> map: historyMap.values()) {
				for (History hist :map) {
					if (user != null) {
						if (Objects.equals(hist.user,user)) {
							history.add(hist);		}						
					}
					else{
						map.add(hist);
					}
					
				}
			}

		}
		return history;


	}

	/**************************貸し出し情報を表示*******************************/

	void runFindHistory(){
		Book book =shelf.get(0);
		User user =null;
		List<History> history = this.findHistory(book,user);
		for(Integer i =0; i<history.size(); i++){
			History hist =history.get(i);
			System.out.println(hist.lendDate+","+hist.returnDate+","+hist.book.title);
		}
	}

	/**************************userの情報をプリント*******************************/

	void print(User user){
	System.out.println(user.name+"("+user.gender+";"+user.age+")");	
	}


		/**************************ウェルカムメッセージ*******************************/

	void printWelcomeMessage(){
		System.out.println("ようこそ図書館システムへ.");
	}


	public static void main(String[] args) {
		Library lib = new Library();
		lib.run();
	}

}