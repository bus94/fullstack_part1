package ArrayListTest;

import java.util.ArrayList;

// 쇼핑몰 사이트 회원가입시 한 명의 정보를 저장하는 클래스
public class Member {

	private String email; // 이메일
	private String pass; // 비밀번호
	private String name; // 이름
	private String phone; // 핸드폰 번호
	
	// 장바구니에 물건 담기
	// 어떤 종류(타입)의 물건이든 담아야하므로 부모 클래스인 Product로 업캐스팅해서 배열 선언 (자식 클래스 객체로 저장하기 위해)
	ArrayList<Product> cart = new ArrayList<Product>(); 
	
	// 모두 필수 입력해야하는 데이터이므로 생성자 만들기
	public Member(String email, String pass, String name, String phone){
		this.email = email;
		this.pass = pass;
		this.name = name;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "이메일: " + email + " 비밀번호: " + pass + " 이름: " + name + " 핸드폰 번호: " + phone;
	}
}

class Vip extends Member{
	private double point;
	private double discount;
	private int couponCount;
	
	public Vip(String email, String pass, String name, String phone, double point, double discount, int couponCount) {
		super(email, pass, name, phone);
		this.point = point;
		this.discount = discount;
		this.couponCount = couponCount;
	}
	
}
