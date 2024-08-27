package Function;

import java.util.Scanner;

public class FunctionTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int inputLocation;
		int nowLocation = 1;
		
		while(true) {
			System.out.print("가고자 하는 층: ");
			int floor = sc.nextInt();
			
			if(floor < 1 || floor > 6) {
				System.out.println("다른 층(1~6층)을 눌러 주세요.");
				continue;
			}
			inputLocation = floor;
			
			if(nowLocation < inputLocation) {
				nowLocation = goUpfloor(inputLocation, nowLocation);
			}else {
				nowLocation = goDownfloor(inputLocation, nowLocation);
			}
			
		}
		
		
	}
	
	public static int goUpfloor(int input, int now) {
		for(int i = now; i <= input; i++) { // 현재 층이 포함되기 때문에 i <= input 이다 (i < input 이 아니라)
			System.out.println("현재 층: " + i);
		}
		System.out.println(input + "층에 도착하였습니다.");
		return input;
	}
	
	public static int goDownfloor(int input, int now) {
		for(int i = now; i >= input; i--) {
			System.out.println("현재 층: " + i);
		}
		System.out.println(input + "층에 도착하였습니다.");
		return input;
	}

}
