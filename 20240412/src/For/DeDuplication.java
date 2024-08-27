package For;

import java.util.Random;

public class DeDuplication {

	public static void main(String[] args) {

		/*
		 * 중복 제거
		 * 
		 */

		Random random = new Random();

		int[] array = new int[6];

		int index = 0; // 인덱스 번호 선언

		/*
		 * index0부터 값을 random값으로 하나씩 배정할 while문 작성
		 *  아래 코드로 중복 검사하는 경우 random값을 배정할 때 아래의 for문으로 
		 *  random값이 이전 배열에 배정된 값들에 있는지 검사 (ex. 3번째 인덱스면 0~2번째 인덱스까지 검사)
		 *  중복값이 발견되면 검사 그만하고 다시 while문으로 가서 random값 재배정
		 *  중복값이 발견되지 않으면 for문의 if문을 거치지 않고 아래의 if문으로 실행되어 random값이 해당 인덱스에 저장되고
		 *  인덱스를 하나 증가시키고 다시 while문으로 가서 처음부터 위의 과정들을 반복
		 *  이후 배열 길이와 index가 같아지면 while문 종료
		 * 
		 */
		
		while (index < array.length) {
			int rand = random.nextInt(100) + 1;
			boolean check = false;
			
			// 중복 검사 하기 위한 코드
			for (int i = 0; i < index; i++) {
				if (array[i] == rand) {
					/*
					 * 중복값 발견하였기 때문에 반복 더 할 필요 x 
					 * 따라서 break;
					 * 
					 */
					
					check = true;
					break;
				}
				
			}
			
			/*
			 * 중복 아니면 배열에 저장
			 * 중복 이면 저장 안하고 index도 증가 시키지 않는다
			 * 
			 */
			
			if(!check) {
				array[index] = rand;
				index++;
			}
			
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

}
