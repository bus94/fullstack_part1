package Map;


public class Member {

	public String name;
	public String password;

	public Member() {
	}

	public Member(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public void print() {
		System.out.println("이름: " + name);
		System.out.println("비밀번호: " + password);
	}

}

class Vip extends Member{
	
	int couponCount;
	boolean privateParking;
	
	public Vip() {
		couponCount = 5;
		privateParking = true;
	}
	
	@Override
	public void print() {
		System.out.println("이름: " + name);
		System.out.println("비밀번호: " + password);
		System.out.println("쿠폰개수: " + couponCount);
		System.out.println("전용주차 공간유무: " + (privateParking? "O":"X"));
	}
	
}
