package If;

// java.util 폴더 안에 있는 랜덤 기능을 사용
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {

		// 난수 (랜덤값) 설정하는 방법
		
		// 1. Scanner와 같이 만들어진 기능을 사용 : Random Class
		Random ran = new Random();
		
		// 정수 뽑기
		// int 범위 -21억 ~ +21억 사이
		System.out.println(ran.nextInt());
		
		// 0, 1, 2 사이에서 정수 뽑기 (3개 중에 하나 뽑기)
		// nextInt(n) : 0 ~ n-1 사이의 수 (총 n개)
		System.out.println(ran.nextInt(3));
		
		// 로또 : 1 ~ 45 사이
		// n = 45 로 잡으면 0 ~ 44 이므로, 시작 수를 잡아야한다
		// nextInt(n) + 시작수
		// 시작수부터 n개
		System.out.println(ran.nextInt(45) + 1);
		
		// -6 ~ 6 사이 숫자 뽑기
		System.out.println(ran.nextInt(13) - 6);
		
	}

}
