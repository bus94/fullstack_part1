package BookDB;

public class Book {
	
	private int book_no; 
	private int book_kind;
	private String book_title;
	private int book_price; 
	private int book_count; 
	private String book_author; 
	private String book_publishing; 
	private String book_image; 
	private String book_content; 
	private String book_discount_rate; 
	
	public Book() {
	}

	public Book(int book_no, int book_kind, String book_title, int book_price, int book_count, String book_author,
			String book_publishing, String book_image, String book_content, String book_discount_rate) {
		this.book_no = book_no;
		this.book_kind = book_kind;
		this.book_title = book_title;
		this.book_price = book_price;
		this.book_count = book_count;
		this.book_author = book_author;
		this.book_publishing = book_publishing;
		this.book_image = book_image;
		this.book_content = book_content;
		this.book_discount_rate = book_discount_rate;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public int getBook_kind() {
		return book_kind;
	}

	public void setBook_kind(int book_kind) {
		this.book_kind = book_kind;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public int getBook_price() {
		return book_price;
	}

	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}

	public int getBook_count() {
		return book_count;
	}

	public void setBook_count(int book_count) {
		this.book_count = book_count;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_publishing() {
		return book_publishing;
	}

	public void setBook_publishing(String book_publishing) {
		this.book_publishing = book_publishing;
	}

	public String getBook_image() {
		return book_image;
	}

	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}

	public String getBook_content() {
		return book_content;
	}

	public void setBook_content(String book_content) {
		this.book_content = book_content;
	}

	public String getBook_discount_rate() {
		return book_discount_rate;
	}

	public void setBook_discount_rate(String book_discount_rate) {
		this.book_discount_rate = book_discount_rate;
	}

	@Override
	public String toString() {
		return "\n고유 번호: " + book_no + "\n종류: " + book_kind + "\n제목: " + book_title + "\n가격: "
				+ book_price + "\n재고 수량: " + book_count + "\n저자: " + book_author + "\n출판사: "
				+ book_publishing + "\n이미지: " + book_image + "\n내용: " + book_content
				+ "\n할인율: " + book_discount_rate + "\n";
	}
	
}
