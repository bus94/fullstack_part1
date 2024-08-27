package String;

import java.util.Scanner;

public class StringTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		// 문자열
//		System.out.print("테스트 케이스의 개수: ");
//		int test = sc.nextInt();
//		sc.nextLine();
//		int i = 1;
//		
//		while (i <= test) {
//			System.out.print("문자열: ");
//			String a = sc.nextLine();
//			System.out.println(a.substring(0,1) + a.substring(a.length()-1));
//			i++;
//		}
		
		// charAt()
		// 한 문자씩 가져올 수 있다
//		System.out.println(str.charAt(0));
//		System.out.println(str.charAt(1));
//		System.out.println(str.charAt(2));
//		System.out.println(str.charAt(3));
		
		// 문자열 입력 받아 배열에 넣고, 검색한 문자가 몇 개 들어있는지 개수와 몇 번째 인덱스인지 출력
		// 배열에 넣으려면 한 문자씩 for문으로 넣기
		System.out.print("문자열: ");
		String str = sc.nextLine();
		System.out.print("검색할 문자: ");
		char find = sc.nextLine().charAt(0); // "a" → a + enter
		
//		// 문자 길이 확인해서 입력한 길이만큼 배열 생성
//		char[] list = new char[str.length()];
//		// 문자를 하나씩 저장하기 위해 list에 String이 아닌 char를 이용
//		// for문을 통해 문자 하나씩 배열에 저장
//		for(int i = 0; i < str.length(); i++) {
//			list[i] = str.charAt(i); 
//			System.out.print(list[i] + " ");
//		}
		
		// 문자열을 배열로 반환
		char[] charArr = str.toCharArray();
		
		int count = 0;
		for(int i = 0; i < charArr.length; i++) {
			if(charArr[i] == find) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println();
		System.out.println(find + " 개수 : " + count);
	}

}
