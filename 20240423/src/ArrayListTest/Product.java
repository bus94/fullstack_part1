package ArrayListTest;

import java.time.LocalDateTime;

public class Product {

	private String name; // 상품명
	private int price; // 가격
	private LocalDateTime date; // 배송일
	private int reviewCount; // 리뷰 평점
	
	public Product(String name, int price, LocalDateTime date, int reviewCount) {
		this.name = name;
		this.price = price;
		this.date = date;
		this.reviewCount = reviewCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	@Override
	public String toString() {
		return "상품명: " + name + " 가격: " + price + " 배송일: " + date + " 리뷰평점: " + reviewCount;
	}
	
}

// 옷 상품 (사이즈, 색상)
class Clothes extends Product{
	private String size; // 사이즈
	private String color; // 색상
	
	public Clothes(String name, int price, LocalDateTime date, int reviewCount, String size, String color) {
		super(name, price, date, reviewCount);
		this.size = size;
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() + " 사이즈: " + size + " 색상: " + color;
	}
	
}

// 음식 상품 (유통기한)
class Food extends Product{
	private LocalDateTime exDate; // 유통기한

	public Food(String name, int price, LocalDateTime date, int reviewCount, LocalDateTime exDate) {
		super(name, price, date, reviewCount);
		this.exDate = exDate;
	}
	
	@Override
	public String toString() {
		return super.toString() + " 유통기한: " + exDate;
	}
		
}
