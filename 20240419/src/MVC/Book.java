package MVC;

public class Book {
	private String title; // 책 제목
	private String author; // 저자
	private String category; // 분류
	int price;
	
	// 기본 생성자 생성
	public Book() {
	}

	// 매개 변수를 받아서 원하는 값으로 초기화 하는 생성자 생성
	public Book(String title, String author, String category, int price) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	// private을 대비한 getter & setter 생성
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
//	@Override
//	public String toString() {
//		return "책 이름: " + title + "\n책 저자: " + author + "\n책 분류: " + category + "\n책 가격: " + price;
//	}
	
	public void print() {
		System.out.println("          (" + title + "/" + author + "/" + category + "/" + price + ")");
	}
	
}
