
public class VariableTest {

	public static void main(String[] args) {
		// 1번
		// 월급 a, 세전 b, 연봉 c
		int a = 100;
		int b = a * 12;
		int c = b * 90 / 100;
		System.out.println(c);
		
		// 3번
		// 가로 x, 세로 y, 삼각형의 넓이 z
		int x = 3;
		int y = 6;
		int z = (x * y) / 2;
		System.out.println(z);
		
		// 4번
		int sec = 100;
		int min = sec / 60;
		int r = sec % 60;
		System.out.println(min + "분 " + r + "초");
		
		// 5번
		int m = 800;
		int f = m / 500;
		int o = (m-(500*f)) / 100;
		System.out.println("500원(" + f + "개)" + "100원(" + o + "개)");
		
		// 추가 문제
		int num = 275;
		System.out.println(num / 10 % 10);
		
	}

}
