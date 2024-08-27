package Array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx4 {

	public static void main(String[] args) {

		/*
		 * 1차원 배열 한 번 공간을 생성하면 "고정" 되어 "추가와 삭제"가 안된다.
		 * 
		 * 배열의 크기를 추가와 삭제가 가능하도록 만드는 방법은 ArrayList 클래스 이용하는 것이다.
		 * 아래에서는 클래스를 이용하지 않고 배열의 크기 추가와 삭제를 나타내보았다
		 * 
		 */

		int[] arr = new int[3];

		Scanner sc = new Scanner(System.in);

		String[] nameList = { "이익준", "김준완" };

		int valueCount = 2;

		while (true) {
			System.out.println();
			System.out.println("현재 데이터 개수: " + valueCount);
			System.out.println("1. 이름 추가");
			System.out.println("2. 출력");
			System.out.println("3. 삭제");
			System.out.println("4. 정렬");
			System.out.println("5. 종료");
			int sel = sc.nextInt();

			switch (sel) {
			case 1:
				// 1. 기존 배열을 다른 메모리 공간에 저장
				String[] temp = nameList;
				// 2. nameList 변수에
				// 새로운 배열을 만들고, 새로운 데이터를 추가할 공간을 생성 필요
				nameList = new String[valueCount + 1];

				// 기존 배열의 데이터를 새로 생성한 nameList로 복사
				for (int i = 0; i < valueCount; i++) {
					nameList[i] = temp[i];
				}
				// 버퍼 비우기 (enter 비우기 위함)
				sc.nextLine();
				// 기존 배열의 값을 전부 복사해온 후 추가로 만든 공간이 비어있다
				System.out.print("추가할 이름: ");
				nameList[valueCount] = sc.nextLine();
				// 기존 nameList의 인덱스는 0~1이 된다.
				// 여기서 valueCount(기존 nameList의 총 인덱스)의 역할은
				// 1) 새로운 배열을 만들기 위한 기존 인덱스의 기준 (새로 추가할 인덱스인 +1을 하게 되는 것 :38 확인)
				// 2) 인덱스의 총 갯수보다 하나 적은 기존 nameList에서 1의 인덱스가 추가된 새로운 nameList를 만들었기 때문에
				// valueCount라는 인덱스는 새롭게 생성되어 비어있는 공간의 인덱스 번호이다. 그 곳에 값을 입력해서 대입(:46 확인)
				// 데이터 개수가 아직 더해지지 않았기 때문에 valueCount++ 해줘야 한다.
				valueCount++;
				System.out.println("추가되었다.");
				break;

			case 2:
				System.out.println("조회 페이지");
				System.out.print("1. 전부 출력 2. 검색 이름만 출력:");

				sel = sc.nextInt();

				if (sel == 1) {
					for (int i = 0; i < nameList.length; i++) {
						System.out.println((i + 1) + "번 째 이름: " + nameList[i]);
					}
				} else if (sel == 2) {
					System.out.print("검색할 이름: ");
					String find = sc.nextLine();
					sc.nextLine();
					
					boolean check = false;
					
					for (int i = 0; i < valueCount; i++) {
						if(nameList[i].equals(find)) { 
							System.out.println("찾았다");
							System.out.println("공간의 번호: " + i);
							System.out.println(nameList[i]);
							check = true;
						}
					}
					if(check) {
						System.out.println("찾는 이름이 없습니다.");
					}
					
					
				} else {
					System.out.println("잘못 입력하셨습니다.");
					continue;
				}
				break;
				
			case 3:
				System.out.println("삭제 페이지");
				
				
				// 1. 기존 배열 복사
				String[] temp2 = nameList;
				
				// 2. 새로운 배열 생성
				nameList = new String[valueCount - 1];

				// 3. 삭제할 데이터 입력, 검색하기
				System.out.print("삭제할 이름: ");
				String delName = sc.nextLine();
				
				boolean check = false;
				
				// 값이 있으면 삭제할 값의 공간의 번호를 기억
				int delIndex = -1; // 0으로 설정하면 값이 없는 경우 0번을 지울 수 있기 때문에 애초에 존재하지 않는 인덱스로 설정해둔다.
				
				for(int i = 0; i < valueCount; i++) {
					if(temp2[i].equals(delName)) {
						delIndex = i;
						check = true;
					}
				}
				if(check) {
					System.out.println("찾는 이름이 없습니다.");
					break;
				}
				
				// 4. 기존 배열의 값을 복사할 때
				// 삭제할 데이터는 빼고 나머지 복사하기
				// 그대로 i를 쓰게 되면 인덱스 초과 등의 에러가 생기기 때문에 
				// 새로운 변수 j를 사용해서 nameList의 인덱스에 하나씩 채워넣자
				int j = 0;
				for(int i = 0; i < valueCount; i++) {
					if(i != delIndex) {
						nameList[j] = temp2[i];
						j++;
					}
				}
					
				sc.nextLine();
				valueCount--;
				System.out.println("삭제되었다.");
				break;
				
			case 4:
				System.out.println("정렬");
				// sort를 이용하여 자동정렬
				// Arrays.sort(nameList);
				
				// 버블정렬
				for (int i = 0; i < valueCount - 1; i++) {
                    for (int j2 = 0; j2 < valueCount - i - 1; j2++) {
                        if (nameList[j2].compareTo(nameList[j2 + 1]) > 0) {
                            String temp3 = nameList[j2];
                            nameList[j2] = nameList[j2 + 1];
                            nameList[j2 + 1] = temp3;
                        }
                    }
                }
				break;

			case 5:
				System.out.println("종료");
				return;
			}

			/*
			 * 주의 사항 switch문과 while문을 같이 사용할 경우에 대해서 switch문을 종료할 때 break를 사용하는데, switch문을
			 * 빠져 나오지만 while문 안에서는 계속 반복을 하게 된다. ∴ 따라서 프로그램을 종료하기 위한 return을 써야 한다. → 함수의 종료
			 * 의미인 return은 main을 종료한다.
			 * 
			 */

		}

	}

}
