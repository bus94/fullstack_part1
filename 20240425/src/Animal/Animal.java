package Animal;

public class Animal {
	private String name;
	private String kinds;
	
	public Animal(){
	}

	public Animal(String name, String kinds) {
		this.name = name;
		this.kinds = kinds;
	}

	@Override
	public String toString() {
		return "저의 이름은 " + name + "이고, 종류는 " + kinds + "입니다.";
	}
	
}

class Dog extends Animal implements Speak{
	private int weight;
	
	public Dog() {
	}

	public Dog(String name, String kinds, int weight) {
		super(name, kinds);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public void speak() {
		System.out.println("몸무게는 " + weight + "kg 입니다.");
	}
	
	
	
}

class Cat extends Animal implements Speak{
	private String location;
	private String color;
	
	public Cat() {
	}

	public Cat(String name, String kinds, String location, String color) {
		super(name, kinds);
		this.location = location;
		this.color = color;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void speak() {
		System.out.println(location + "에 서식하며, 색상은 " + color + "입니다.");
	}

	
}