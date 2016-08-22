/*
544764
Ayuki joto
*/

import java.util.*;

public class UserManager{

	List<User> users= new ArrayList<User>();

	User createUser(String name,String gender,Integer age){
		User user=new User();
		user.name=name;
		user.gender=gender;
		user.age=age;

		return user;
	}
	void print(User user){
		//System.out.print("%s (%s; %d)%n",user.name,user.gender,user.age);
		System.out.println(user.name+"("+user.gender+";"+user.age+")");	
	}

	Integer size(){
		return users.size();
	}

	void add(User user){
		users.add(user);
	}

	Boolean delete(User user){
		Boolean result = users.remove(user);
		return result;
	}

	List<User> find(String name,String gender,Integer age){
		List<User> result = new ArrayList<User>();
		for(User user:users){
			if (isAnyMatch(user,name,gender,age)) {
				result.add(user);
			}
		}
		return result;
	}

	Boolean isAnyMatch(User user ,String name,String gender,Integer age){
		if (name != null && Objects.equals(user.name,name)) {
			return true;
		}
		if (gender != null && Objects.equals(user.gender,gender)) {
			return true;
		}
		if (age != null && Objects.equals(user.age,age)) {
			return true;
		}
		return false;
	}

	public Iterator<User> iterator(){
		return users.iterator();
	}


	void run(){
		User myself = this.createUser("上東","男",19);
		this.add(myself);
		this.add(this.createUser("aaa","male",20));
		this.add(this.createUser("bbb","Female",20));
		this.add(this.createUser("ccc","male",20));
		this.add(this.createUser("ddd","Female",20));
		this.add(this.createUser("eee","male",19));

		List<User>result1 =this.find(null,"Female",null);

		System.out.println("検索結果1");
		for(User user:result1){
			this.print(user);
		}

		List<User>result2 =this.find(null,null,19);

		System.out.println("検索結果2");
		for(User user:result2){
			this.print(user);
		}
		
		System.out.println("全ユーザー表示");
		Iterator<User> iterator;

		iterator = this.iterator();

		for(; iterator.hasNext();){
			User user=iterator.next();
			this.print(user);
		}




	}


	 public static void main(String[] args) {
		UserManager manager = new UserManager();
		manager.run();
	}



}