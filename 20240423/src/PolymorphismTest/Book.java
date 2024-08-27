package PolymorphismTest;

public class Book {
	// 책의 정보를 저장하는 클래스
	private String title;
	private String author;
	private String publisher;
	
	public Book() {}
	
	public Book(String title, String author, String publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	// Book에 대해 출력할 수 있는 함수
//	void show() {
//		System.out.println("책 제목: <" + title + ">");
//		System.out.println("책 저자: " + author);
//		System.out.println("책 출판사: " + publisher);
//	}

	@Override
	public String toString() {
		return "책 제목: <" + title + "> 책 저자: " + author + " 책 출판사: " + publisher + " ";
	}
	
}
