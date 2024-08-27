package Class;

import java.util.Scanner;

class Shape {
	int type;
	double height;
	double width;
	String color = "white";

	void shape(int type, double height, double width) {
		type = type;
		height = height;
		width = width;
	}
}

class ShapeMenu {

	Scanner sc = new Scanner(System.in);
	Shape shape = new Shape();
	
	void inputMenu() {
		while (true) {
			System.out.println("===== 도형 프로그램 =====");
			System.out.println("3. 삼각형");
			System.out.println("4. 사각형");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호: ");
			int num = sc.nextInt();
			if (num == 3) {
				triangleMenu();
			} else if (num == 4) {
				squareMenu();
			} else if (num == 9) {
				System.out.println("프로그램 종료");
				return;
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
				break;
			}

			// TriangleController
			// int tc = sc.nextInt();
		}
	}

	void triangleMenu() {
		while (true) {
			System.out.println("===== 삼각형 =====");
			System.out.println("1. 삼각형 면적");
			System.out.println("2. 삼각형 색칠");
			System.out.println("3. 삼각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호: ");
			int scr = sc.nextInt();
			if (scr == 1) {
				inputSize(3, scr);
			} else if (scr == 2) {
				// 삼각형 색칠하는 함수 호출
			} else if (scr == 3) {
				// 삼각형 정보 함수 호출
			} else if (scr == 9) {
				System.out.println("메인으로 돌아갑니다.");
				return;
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
				break;
			}

		}
	}
	
	void squareMenu() {
		while (true) {
			System.out.println("===== 사각형 =====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 면적");
			System.out.println("3. 사각형 색칠");
			System.out.println("4. 사각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호: ");
			int scr = sc.nextInt();
			if (scr == 1) {
				// 사각형 둘레 구하는 함수 호출
			} else if (scr == 2) {
				// 사각형 면적 구하는 함수 호출
			} else if (scr == 3) {
				// 사각형 색칠하는 함수 호출
			} else if (scr == 4) {
				// 사각형 정보 함수 호출
			} else if (scr == 9) {
				System.out.println("메인으로 돌아갑니다.");
				return;
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
				break;
			}

		}
	}
	
	// type = inputMenu, menuNum = triangleMenu 또는 squareMenu
	void inputSize(int type, int menuNum) {
		
		if(type == 3) { //triangleMenu에서 선택한 경우
			if(menuNum == 1) {
				System.out.print("높이 : ");
				shape.height = sc.nextInt();
				System.out.print("너비 : ");
				shape.width = sc.nextInt();
				System.out.println("삼각형 면적 : " + (shape.height * shape.width)/2);
			}else if(menuNum == 2) {
				System.out.println("색깔을 입력하세요 : ");
				shape.color = sc.nextLine();
				System.out.println("색이 수정되었습니다.");
			}else if(menuNum == 3) {
				System.out.println("삼각형 " + shape.height + " " + shape.width + " " + shape.color);
			}else if(menuNum == 9) {
				
			}
		}else if(type == 4) { //squareMenu에서 선택한 경우

			
		}
	}

}

public class ClassArrayTest {

	public static void main(String[] args) {

		ShapeMenu shapemenu = new ShapeMenu();
		shapemenu.inputMenu();

	}

}
