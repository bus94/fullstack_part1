package Thread;

class MusicThread extends Thread{
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("배경음악 나오는 중~");
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class DaemonThread {

	public static void main(String[] args) {

		MusicThread mt = new MusicThread();
		/*
		 * 다른 스레드가 종료 될 때 모든 스레드가 종료 될 수 있도록 작성
		 * 단! 설정은 스레드 시작 전에 설정해야한다.
		 * 기본값이 false로 되어있다.
		 * true로 변경하기!
		 * 
		 */
		mt.setDaemon(true); // 스레드 실행 전 설정
		mt.start();
		
		for(int i = 0; i < 100; i++) {
			System.out.println("열심히 게임 중!!!!!!");
			if(i == 50) {
				System.out.println("앗! 엄마다!!");
				break;
			}
		}
		
		System.out.println("열심히 공부 중이었어요~");
		
		// 데몬 스레드
		//  일반 스레드랑은 다른 특성을 가진다.
		//  백그라운드에서 동작하며 주로 서비스 스레드의 보조역할 수행하거나 특정 작업을 주기적으로 처리하는 목적으로 사용된다.
		
		
		
	}

}
