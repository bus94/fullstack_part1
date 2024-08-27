package Polymorphism_Coffee;

public class Main {

	public static void main(String[] args) {
		Customer me = new Customer();
		
		me.buyCoffee(new Americano());
		me.buyCoffee(new CaffeLatte());
		System.out.println();
		System.out.println("현재 잔액: " + me.money + "원 입니다.");
	}

}
