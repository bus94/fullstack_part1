package ThreadSync;

//잔액 출력 스레드 
public class PrintThread extends Thread {

	ShareArea shareArea;

	public PrintThread() {
	}

	public PrintThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}

	@Override
	public void run() {
		synchronized (shareArea) {
			
			for(int i = 0; i < 3; i++) {
				int sum = shareArea.a1.money + shareArea.a2.money;
				System.out.println("예금 합계: " + sum);
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
	}
}
