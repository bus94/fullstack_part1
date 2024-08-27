package ObjectTest;

class Member{
	String name;
	int age;
	String id;
	String pw;
	
	public Member(String name, int age, String id, String pw) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.pw = pw;
	}
	
	@Override
	public boolean equals(Object obj) {
		Member temp = (Member) obj;
		if(this == obj) {
			return true;
		}
		
		if(this.name == temp.name && this.age == temp.age && this.id == temp.id && this.pw == temp.pw) {
			return true;
		}else {
			return false;
		}
	}
	
}

public class Test {

	public static void main(String[] args) {
		Member m1 = new Member("이익준", 20, "qwer", "qewr");
		Member m2 = new Member("채송화", 20, "asdf", "asdf");
		Member m3 = new Member("이익준", 20, "qwer", "qewr");
		
		
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(m3));
		
		
		
	}

}
