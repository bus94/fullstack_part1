package ThreadSync;

public class Main {

	public static void main(String[] args) {

		ShareArea shareArea = new ShareArea();
		
		TransferThread transfer = new TransferThread(shareArea);
		
		PrintThread print = new PrintThread(shareArea);
		
		transfer.start();
		print.start();
		
	}

}
