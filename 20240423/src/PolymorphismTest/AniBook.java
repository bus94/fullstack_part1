package PolymorphismTest;

public class AniBook extends Book {
	private int accessAge;

	public AniBook() {
	}

	public AniBook(String title, String author, String publisher, int acc) {
		super(title, author, publisher);
		this.accessAge = acc;
	}

	// 오버라이딩 (덮어쓰기) : 부모 클래스의 내용을 자식 클래스에서 재정의해서 사용
	// 사용방법: 부모 클래스에서 사용하고 싶은 함수명을 적고 Ctrl + SpaceBar
//	@Override
//	void show() {
//		super.show();
//		System.out.println("연령 제한: " + accessAge);
//	}
	
	@Override
	public String toString() {
		return super.toString() + "연령 제한: " + accessAge;
	}

}

class CookBook extends Book {
	private boolean coupon;

	public CookBook() {
	}

	public CookBook(String title, String author, String publisher, boolean coupon) {
		super(title, author, publisher);
		this.coupon = coupon;
	}

//	@Override
//	void show() {
//		super.show();
//		char c1 = (coupon) ? 'O' : 'X';
//		System.out.println("쿠폰: " + c1);
//	}
	
	@Override
	public String toString() {
		char c1 = (coupon) ? 'O' : 'X';
		return super.toString() + "쿠폰: " + c1;
	}
	
}

class ItBook extends Book {
	private boolean videoCoupon;
	private boolean exampleCode;

	public ItBook() {
	}

	public ItBook(String title, String author, String publisher, boolean videoCoupon, boolean exampleCode) {
		super(title, author, publisher);
		this.videoCoupon = videoCoupon;
		this.exampleCode = exampleCode;
	}
	
	// it 책의 정보 출력
//	@Override
//	void show() {
//		super.show();
//		char c2 = (videoCoupon)? 'O' : 'X';
//		char c3 = (exampleCode)? 'O' : 'X';
//		System.out.println("동영상 쿠폰: " + c2);
//		System.out.println("예제 코드: " + c3);
//	}

	public boolean isVideoCoupon() {
		return videoCoupon;
	}

	public void setVideoCoupon(boolean videoCoupon) {
		this.videoCoupon = videoCoupon;
	}

	public boolean isExampleCode() {
		return exampleCode;
	}

	public void setExampleCode(boolean exampleCode) {
		this.exampleCode = exampleCode;
	}
	
	@Override
	public String toString() {
		char c2 = (videoCoupon)? 'O' : 'X';
		char c3 = (exampleCode)? 'O' : 'X';
		return super.toString() + "동영상 쿠폰: " + c2 + " 예제 코드: " + c3;
	}
	
}
