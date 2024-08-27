package Thread;

class Washroom{
	public synchronized void openDoor(String name) {
		System.out.println(name + " 입장!");
		for(int i = 0; i < 1000000; i++) {
			if(i == 1000) {
				System.out.println("끄으응!!");
			}
		}
		System.out.println(name + ": 아~ 시원해!!!");
		System.out.println();
	}
}

class FamilyThread extends Thread{
	private Washroom wr;
	private String who;
	
	public FamilyThread(Washroom wr, String who) {
		this.wr = wr;
		this.who = who;
	}
	
	@Override
	public void run() {
		wr.openDoor(who);
	}
	
}

public class SyncThread {

	public static void main(String[] args) {
		
		/*
		 * 스레드를 사용하다보면 동시 다발적으로 하나의 함수를 사용할 때
		 * "동기화"라는 문제가 발생한다
		 * 
		 */
		
		// 화장실 객체 하나 만들기
		Washroom wr = new Washroom();
		
		FamilyThread father = new FamilyThread(wr, "Father");
		FamilyThread mother = new FamilyThread(wr, "Mother");
		FamilyThread sister = new FamilyThread(wr, "Sister");
		FamilyThread me = new FamilyThread(wr, "Me");
		FamilyThread brother = new FamilyThread(wr, "Brother");
		
		// 각각의 스레드를 실행!
		father.start();
		mother.start();
		sister.start();
		me.start();
		brother.start();
		
		/*
		 * 동기화
		 * - 멀티 스레드를 사용하다 보면 두 개 이상의 스레드가 공유 데이터에 동시에 접근하게 되면
		 *   예상과 벗어난 결과를 나타낼 때가 있다.
		 *   이런 문제를 해결해주는 것이 스레드 동기화!
		 */
		
		
	}

}
