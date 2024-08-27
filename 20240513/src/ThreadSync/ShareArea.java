package ThreadSync;

// 입출금을 실행하는 스레드와 잔액을 출력하는 스레드가 공유해서 사용할 클래스
public class ShareArea {
	Account a1 = new Account("111-11-1111", "이익준", 1000000);
	Account a2 = new Account("222-22-2222", "김준완", 1000000);
}
