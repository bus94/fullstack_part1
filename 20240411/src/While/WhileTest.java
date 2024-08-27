package While;

import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1번
//		int i = 0;
//		
//		while(i < 10) {
//			i++;
//			System.out.println("나무를 " + i + " 번 찍었다.");
//		} System.out.println("나무가 넘어갔다.");
		
		// 2번
//		int s = 0;
//		
//		while(s < 8) {
//			s++;
//			System.out.println("계단을 " + s + " 칸 올라갔습니다.");
//		} System.out.println("다음 층에 도착 하였습니다.");
		
		// 3번
//		int sum = 0;
//		System.out.println("덧셈을 하고 싶은 양의 정수들을 입력하세요. 0 입력 시 종료");
//		while(true) {
//			int n = sc.nextInt();
//			sum += n;
//			
//			if(n == 0) {
//				break;
//			}
//			
//		} System.out.println("총 합은 " + sum + " 입니다.");
		
		// A + B - 7
//		System.out.print("횟수 : ");
//		int t = sc.nextInt();
//		int i = 0;
//		
//		while(i < t) {
//			i++;
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			System.out.println("Case #" + i + ": " + (a + b));
//		}
				
		// A + B - 8
//		System.out.print("횟수 : ");
//		int t = sc.nextInt();
//		int i = 0;
//		
//		while(i < t) {
//			i++;
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			System.out.println("Case #" + i + ": " + a + " + " + b + " = "+ (a + b));
//		}
		
//		// 별 찍기 - 1
//		System.out.print("n번째 줄 : ");
//		int line = sc.nextInt();
//		int i = 0;
//		
//		while (i < line) { // 줄의 개수
//			int j = 0;
//			String star = "*";
//				while (j < i + 1) { // 별의 개수
//					System.out.print(star);
//					j++;
//				}
//			System.out.println();
//			i++;
//		}
		
		// 별 찍기 - 2
//		System.out.print("n번째 줄 : ");
//		int line = sc.nextInt();
//		int i = 0;
//		
//		while(i < line) {
//			int j = 0;
//			String star = "*";
//			int k = line - 1;
//			String e = " ";
//				while(k > i) {
//					System.out.print(e);
//					k--;
//				}
//				while(j < i + 1) {
//					System.out.print(star);
//					j++;
//				} System.out.println();
//			i++;
//		} 
		
		// 영수증
		int X = sc.nextInt();
		int N = sc.nextInt();
		int i = 0;
		int sum = 0;
		System.out.print("구매한 물건의 가격, 개수: ");
		
		    while(i < N){
		        int a = sc.nextInt();
	        	int b = sc.nextInt();
	        	sum += a * b;
	        	i++;
	    	}   if(sum == X){
	        	    System.out.println("Yes");
	            }else{
	        	    System.out.println("No");
	        	}
	}

}
