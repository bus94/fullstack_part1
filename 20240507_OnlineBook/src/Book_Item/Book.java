package Book_Item;

import java.time.LocalDateTime;

public class Book {
		private String bookId;
	    private String bookName;
	    private int bookPrice;
	    private String bookAuthor;
	    private String bookDescription;
	    private String bookCategory;
	    private LocalDateTime bookDate;
	    
	    public Book(){
	    }
	    
		public Book(String bookId, String bookName, int bookPrice, String bookAuthor, String bookDescription,
				String bookCategory, LocalDateTime bookDate) {
			super();
			this.bookId = bookId;
			this.bookName = bookName;
			this.bookPrice = bookPrice;
			this.bookAuthor = bookAuthor;
			this.bookDescription = bookDescription;
			this.bookCategory = bookCategory;
			this.bookDate = bookDate;
		}

		public String getBookId() {
			return bookId;
		}

		public void setBookId(String bookId) {
			this.bookId = bookId;
		}

		public String getBookName() {
			return bookName;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		public int getBookPrice() {
			return bookPrice;
		}

		public void setBookPrice(int bookPrice) {
			this.bookPrice = bookPrice;
		}

		public String getBookAuthor() {
			return bookAuthor;
		}

		public void setBookAuthor(String bookAuthor) {
			this.bookAuthor = bookAuthor;
		}

		public String getBookDescription() {
			return bookDescription;
		}

		public void setBookDescription(String bookDescription) {
			this.bookDescription = bookDescription;
		}

		public String getBookCategory() {
			return bookCategory;
		}

		public void setBookCategory(String bookCategory) {
			this.bookCategory = bookCategory;
		}

		public LocalDateTime getBookDate() {
			return bookDate;
		}

		public void setBookDate(LocalDateTime bookDate) {
			this.bookDate = bookDate;
		}
	    
	    
	    
}
