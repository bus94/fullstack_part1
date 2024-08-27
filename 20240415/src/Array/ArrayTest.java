package Array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("현재 회원 수: ");
		int count = sc.nextInt();

		String[] idList = new String[count];
		String[] pwList = new String[count];

		sc.nextLine();

		for (int i = 0; i < count; i++) {
			System.out.print("회원 ID: ");
			idList[i] = sc.nextLine();
			System.out.print("회원 PW: ");
			pwList[i] = sc.nextLine();
		}

		boolean check = true;

		while (check) {
			System.out.println("=====================");
			System.out.println("현재 회원 수: " + count);
			System.out.println("1. 추가");
			System.out.println("2. 삭제");
			System.out.println("3. 정렬");
			System.out.println("4. 출력");
			System.out.println("0. 종료");
			System.out.print("메뉴 번호 : ");

			int num = sc.nextInt();

			String[] temId = new String[count];
			String[] temPw = new String[count];

			String delId = "";

			switch (num) {
			case 1:
				if (count >= 5) {
					System.out.println("최대 가능 인원 5명이 넘어 가입이 불가능합니다.");
					return;
				}
				temId = idList;
				temPw = pwList;
				idList = new String[count + 1];
				pwList = new String[count + 1];
				for (int i = 0; i < count; i++) {
					idList[i] = temId[i];
					pwList[i] = temPw[i];
				}
				sc.nextLine();
				System.out.print("추가할 ID: ");
				idList[count] = sc.nextLine();
				System.out.print("추가할 PW: ");
				pwList[count] = sc.nextLine();
				System.out.println("추가되었습니다.");
				count++;
				break;

			case 2:
				sc.nextLine();
				temId = idList;
				temPw = pwList;
				System.out.print("삭제할 ID: ");
				delId = sc.nextLine();

				int j = 0;
				for (int i = 0; i < count; i++) {
					if (!idList[i].equals(delId)) {
						idList[j] = temId[i];
						pwList[j] = temPw[i];
						j++;
					}
				}

				idList = new String[count - 1];
				pwList = new String[count - 1];

				System.out.println("삭제되었습니다.");
				count--;
				break;

			case 3:
					for (int k = 0; k < count - 1; k++) {
						if (idList[k].compareTo(idList[k + 1]) > 0) {
							temId[k] = idList[k + 1];
							idList[k + 1] = idList[k];
							idList[k] = temId[k];
							temPw[k] = pwList[k + 1];
							pwList[k + 1] = pwList[k];
							pwList[k] = temPw[k];
						}
						System.out.println((k+1) + ") ID: " + idList[k] + ", " + "PW: " + pwList[k] + " ");
					}
					
				
				
				System.out.println("정렬을 완료하였습니다.");
				continue;

			case 4:
				System.out.println("회원 목록: ");
				for (int i = 0; i < count; i++) {
					System.out.println((i+1) + ") ID: " + idList[i] + ", " + "PW: " + pwList[i] + " ");
				}
				break;

			case 0:
				sc.nextLine();
				System.out.print("정말 종료하시겠습니까(y/n)? : ");
				String q = sc.nextLine();
				if (q.equals("y")) {
					System.out.println("종료 되었습니다.");
					return;
				}
			}
		}

		System.out.println("최대 가입 가능 인원보다 많습니다.");

		// 1. 추가
		// 2. 삭제
		// 3. 정렬
		// 4. 출력
		// 0. 종료
		// 정말 종료하시겠습니까?
		// y / n y: 정말 종료, n: 메뉴로 돌아가기
		// 현재 회원 2명, 최대 가입 가능 인원 5명
		// 5명을 다 저장하면 가입이 불가능합니다. 출력
	}

}
