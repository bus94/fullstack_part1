package ThreadSync;

public class TransferThread extends Thread{
	// 공유 영역을 나타내는 ShareArea객체를 가리키는 변수 선언
	ShareArea shareArea;
	
	// 동기화란 작업의 순서를 정한다는 의미로 공유영역을 사용하는 스레드가 실행 중일 때 
	// 같은 영역을 사용하는 다른 스레드가 실행되지 못하도록 하는 것
	// → 스레드 동기화
	
	public TransferThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}

	public TransferThread() {
		super();
	}

	// 동기화를 위해서는 동기화 블록을 사용하고 동기화 블록에는 절대로 스레드 사이에서 작업 전환이 이루어지면 안된다.
	@Override
	public void run() {
		synchronized (shareArea) {
			// 20번 반복
			for(int i = 0; i < 20; i++) {
				// 이익준 계좌 100만원 입금
				shareArea.a1.deposit(1000000);
				System.out.println("익준 계좌 입금!");
				
				// 김준완 계좌 출금
				// 출금 성공 시 메시지를 출력
				if(shareArea.a2.withDraw(1000000) != 0) {
					System.out.println("준완 계좌 출금!");
				}
				
				// 100밀리초(0.1초)동안 스레드를 일시정지
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}
	}
	
}
