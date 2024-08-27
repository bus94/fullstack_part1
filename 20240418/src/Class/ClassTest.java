package Class;

// 클래스는 데이터 값을 저장하고 실행할 수 있다
class Product{
	String pName;
	int price;
	String brand;
	
	void information(String n, int p, String b) {
		pName = n;
		price = p;
		brand = b;
	}
	
//	 출력을 바로 하고 싶은 경우
//	 클래스 내에서의 변수명은 그대로 가져와서 써도 됨 (매개변수 설정 필요없음)
	void print() {
		System.out.println(pName);
		System.out.println(price);
		System.out.println(brand);
	}
}

class Circle{
	double PI;
	int radius;
	
	void getAreaOfCircle(double PI, int radius) {
		double getAreaOfCircle = 2 * radius * PI;
		System.out.println(getAreaOfCircle);
	}
	
	void getSizeOfCircle(double PI, int radius) {
		double getSizeOfCircle = radius * radius * PI;
		System.out.println(getSizeOfCircle);
	}
}

class Student{
	int grade;
	int classroom;
	String name;
	double height;
	char gender;
	
	void information(int g, int c, String n, double h, char ge) {
		grade = g;
		classroom = c;
		name = n;
		height = h;
		gender = ge;
	}

	// 클래스 내 마우스 오른쪽 - Source - Generate toString()
	// : 객체 데이터 정렬해서 return 값으로 설정해줌
	@Override
	public String toString() {
		return "Student [grade=" + grade + ", classroom=" + classroom + ", name=" + name + ", height=" + height
				+ ", gender=" + gender + "]";
	}
}

public class ClassTest {

	public static void main(String[] args) {

		// 1. 제품에 대한 클래스 작성, 객체 생성, 데이터 저장
		Product p1 = new Product();
		p1.information("스윙칩", 2000, "오리온");
		System.out.println(p1.pName + " " + p1.price + " " + p1.brand);
		p1.print();
		
		// 2. Circle 클래스 작성 후 원의 넓이 출력
		Circle c1 = new Circle();
		c1.getAreaOfCircle(3.14, 1);
		c1.getSizeOfCircle(3.14, 1);
		
		// 3. Student 클래스 작성 후 정보 출력
		Student s1 = new Student();
		s1.information(1, 1, "홍길동", 200, 'M');
		System.out.println(s1.grade + " " + s1.classroom + " " + s1.name + " " + s1.height + " " + s1.gender);
		System.out.println(s1);
		
		
	}

}
