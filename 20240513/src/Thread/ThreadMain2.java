package Thread;

class MyThread extends Thread {
	// 각각의 객체가 동작할 수 있도록 실행되는 코드를 작성한다.
	// → run() 메서드에 정의하면 된다.
	// start() 메서드 : 스레드를 시작하는 메서드
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println((i + 1) + "초");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadMain2 {

	public static void main(String[] args) {

//		// 멀티 스레드
//		System.out.println("main 스레드 실행!"); // 1
//
//		// 스레드 객체를 가지고 있는 MyThread를 생성한다.
//		MyThread mt = new MyThread();
//		mt.start();
//		// mt.run(); 으로 작성하면 순차대로 1 실행 - run() 실행 - 2 실행
//		// mt.start(); 로 작성하면 1,2 실행할 때 strat()가 동시에 실행
//
//		System.out.println("main 스레드 실행 끝!"); // 2
		
		Car c1 = new Car(1000, "BMW");
		Car c2 = new Car(1200, "Benz");
		Car c3 = new Car(1500, "Audi");
		
		c1.start();
		c2.start();
		c3.start();
	
	}

}

class Car extends Thread {
	int time; // 지연시키는 시간을 저장
	String name; // 차 이름

	public Car(int time, String name) {
		super();
		this.time = time;
		this.name = name;
	}

	// 스레드를 실행하는 코드
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + " " + (i+1) + "만큼 움직였다.");

			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + " 도착했다.");
	}
	
	

}