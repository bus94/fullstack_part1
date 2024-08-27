package InputoutputTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	// 여러 명의 점수를 저장하는 ScoreList의 객체를 생성
	private static ScoreList scoreList = new ScoreList();

	public static void main(String[] args) {

		/*
		 * Score 클래스 생성
		 *  1번, 2번, ... 
		 *   학생 순서 번호: 1
		 *   이름: 박신우
		 *   국어: 100
		 *   영어: 80
		 *   수학: 90
		 *   
		 *  학생들의 데이터를 저장할 수 있는 scoreList를 만들어서 memoList와 같이 파일 저장, 읽기 하기
		 *  파일명 scoreList.txt
		 *   
		 */
		
//		// 이론 강의
//		// 입출력 스트림
//		// 바이트 스트림
//		// - 한 번에 8bit(1byte) 데이터를 처리하고 8bit당 입출력 연산을 수행하므로 주로 바이트 데이터의 입출력을 처리한다
//		
//		// 콘솔이나 소켓이나 파일을 바이트 스트림
//		// 대표적으로 많이 사용하는 것은 스트림(연결 통로) 방향이 한 방향으로 정해져 있다
//		
//		FileInputStream fs = null; // 내보내기
//		FileOutputStream fo = null; // 가져오기
//		
//		// 문자 스트림
//		// PrintWriter 한 번에 16bit(2byte) 유니코드 
//		// 스트림보다 2배의 빠른 연산을 수행할 수 있다
//		
//		FileWriter fw = null;
//		FileReader fr = null;
//		
//		// write() 메서드
//		// 텍스트로 문자로만 저장 줄바꿈이 없다.
//		// \n : new Line 줄을 바꾼다.
//		// \r : carriage return
//		// 		커서를 그 줄의 맨 앞으로 이동한다.
//		
//		// 파일 클래스를 이용해서 파일 객체를 생성
//		// 절대 경로
//		File file = new File("C:\\fullstack\\part1\\io\\scoerlist.txt");
//		
//		// 상대 경로: 작업 중인 파일이 위치한 프로젝트 이름의 폴더(".")부터 작업 중인 파일이 취히만 폴더까지의 경로를 말한다
//		File file2 = new File("./scorelist2.txt");
//		File file3 = new File("./src/inputoutputTest/scorelist2.txt");
//		
//		try { // 예외가 발생할 공간에서 어떤 예외가 발생할 지 모른다. 어떤 예외든 처리하는 부모 클래스인 Exception 타입으로 받는다.
//			// 위에 file의 정보를 저장한 객체를 이용해서 실제 객체를 생성해야한다.
//			// createNewFile();
//			// - 파일을 생성했다면 true, 기존에 존재한다면 false
//			boolean fileRes = file.createNewFile();
//			file2.createNewFile();
//			file3.createNewFile();
//			
//			if(fileRes) {
//				System.out.println("파일 생성 성공!"); // 파일이 없다면
//			} else {
//				System.out.println("파일 생성 실패!"); // 파일이 있다면
//			}
//			
//			System.out.println("파일 이름: " + file.getName());
//			System.out.println("파일 경로: " + file.getAbsolutePath());
//			System.out.println("파일 쓰기 가능: " + file.canWrite());
//			System.out.println("파일 읽기 가능: " + file.canRead());
//			System.out.println("파일 크기: " + file.length());
//			
//			
//			
//		} catch(Exception e) {  
//			e.printStackTrace();
//		}
		
		Scanner sc = new Scanner(System.in);
		
		int menu = 0;
		while(menu != 9) {
			while(true) {
				System.out.println("1. 성적 저장");
				System.out.println("2. 성적 출력");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				menu = sc.nextInt();
				
				if(menu == 1 || menu == 2 || menu == 9) {
					break;
				}
				System.out.println("숫자를 다시 입력해주세요.");
			}
			
			switch(menu) {
			case 1: 
				saveScore(Score.num);
				break;
				
			case 2:
				readScore();
				break;
			}
		}
		sc.close();
		System.out.println("프로그램을 종료합니다.");
		
	}

	private static void readScore() {
		double[] array = new double[Score.num];
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		for(int i = 0; i < Score.num; i++) {
			Score s = scoreList.getScoreList().get(i);
			int k = s.getKorScore();
			int e = s.getEngScore();
			int m = s.getMatScore();
			double sum = (double)(k + e + m);
			array[i] = sum;
			System.out.println(s.getName() + "\t" + k + "\t" + e + "\t" + m + "\t" + sum + "\t"
					+ (double)(sum / 3));
		}
		double arraySum = 0;
		for(int i = 0; i < array.length; i++) {
			arraySum += array[i];
		}
		double arrayAvg = arraySum / (3 * Score.num) ;
		System.out.println("읽은 횟수\t전체 합계\t전체 평균");
		System.out.println(Score.num + "\t" + arraySum + "\t" + arrayAvg);
	}

	private static void saveScore(int num) {
		Scanner sc = new Scanner(System.in);
		System.out.println((num+1) + "번째 학생 정보 기록");
		System.out.print("이름: ");
		String stuName = sc.nextLine();
		System.out.print("국어: ");
		int korSco = sc.nextInt();
		System.out.print("영어: ");
		int engSco = sc.nextInt();
		System.out.print("수학: ");
		int matSco = sc.nextInt();
		
		Score student = new Score(stuName, korSco, engSco, matSco);
		scoreList.addScore(student);
//		위의 두 줄을 한 줄로 만들면 
//		scoreList.addScore(new Score(stuName, korSco, engSco, matSco));
		
		System.out.println("학생 정보 저장 완료!");
		scoreList.writeScore();
		System.out.println("파일 저장 완료!");
	}
	
	// 강사님 풀이
//	private static void print() {
//		// 1. scorelist에서 파일을 읽고 ArrayList에 저장하고 저장된 ArrayList를 반환해서 출력
//		scoreList.readScore();
//		ArrayList<Score> list = scoreList.getScoreList();
//		
//		// 2. 반복문 이용해서 출력
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		
//	}
	

}
