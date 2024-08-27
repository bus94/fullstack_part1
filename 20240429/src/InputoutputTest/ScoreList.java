package InputoutputTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreList {
	private ArrayList<Score> scoreList = new ArrayList<Score>();

	public ArrayList<Score> getScoreList() {
		return scoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}

	// 성적 데이터 추가하는 메서드
	public void addScore(Score score) {
		scoreList.add(score);
		// 파일에 추가하기 위해서는 파일의 이름 입력받기
	}

//	// 파일에 추가하는 메서드 (강사님 풀이)
//	public void save(String fileName) {
//		PrintWriter pw = null;
//		String filePath = fileName + ".txt";
//		System.out.println(filePath);
//
//		try {
//			pw = new PrintWriter(filePath);
//
//			// PrintWriter 사용하는 가장 큰 이유는 스트림을 사용하게 되면 각각 데이터를 래퍼클래스를 이용해서 변경해야 된다.
//			// PrintWriter는 이미 print(),println() 오버로딩으로 구현이 되어있어서
//			// 편하게 데이터만 넣으면 알아서 변경해서 문자로 저장한다.
//			for (int i = 0; i < scoreList.size(); i++) {
//				Score temp = scoreList.get(i);
//				pw.print(temp.getIndex() + "/");
//				pw.print(temp.getName() + "/");
//				pw.print(temp.getKorScore() + "/");
//				pw.print(temp.getEngScore() + "/");
//				pw.print(temp.getMatScore());
//				pw.println();
//			}
//
//			System.out.println("정상 저장 되었습니다.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (pw != null) {
//				pw.close();
//			}
//		}
//	}

	public void writeScore() {
//		PrintWriter printWriter = null;
//		
//		try {
//			printWriter = new PrintWriter(fileName);
//			
//			for(int i = 0; i < scoreList.size(); i++) {
//				Score s = scoreList.get(i);
//				printWriter.print(s.getIndex() + " ");
//				printWriter.print(s.getName() + " ");
//				printWriter.print(s.getKorScore() + " ");
//				printWriter.print(s.getEngScore() + " ");
//				printWriter.print(s.getMatScore() + " ");
//			}
//			
//		} catch(FileNotFoundException e) {
//			System.out.println("파일이 없거나 경로를 잘못 지정했습니다.");
//		} finally {
//			if(printWriter != null) {
//				printWriter.close();
//			}
//		}
		PrintWriter printWriter = null;
		File file = new File("scoreList.txt");

		try {
			printWriter = new PrintWriter(file);
//			System.out.println(file);
			if (!file.exists()) {
				file.createNewFile();
			}

			for (int i = 0; i < scoreList.size(); i++) {
				Score s = scoreList.get(i);
				printWriter.print("학생 순서 번호: " + s.getIndex() + "\n");
				printWriter.print("이름: " + s.getName() + "\n");
				printWriter.print("국어: " + s.getKorScore() + "\n");
				printWriter.print("영어: " + s.getEngScore() + "\n");
				printWriter.print("수학: " + s.getMatScore() + "\n");
				printWriter.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				printWriter.close();
			}
		}

	}

//	// 강사님 풀이
//	public void readScore() {
//		// 프로그램이 동작 중에 새로운 데이터를 저장을 하고 출력을 눌렀을 때
//		// 파일을 불러오다 보니 ArrayList가 비어있지 않아서 중복적인 데이터가 보일 수 있다
//		
//		// 리스트 비우기
//		scoreList.clear(); // 파일을 지우는 것이 아니다
//		
//		Scanner scan = null;
//		
//		try {
//			scan = new Scanner(new File("scorelist.txt"));
//			while(scan.hasNextLine()) {
//				// 텍스트 한 줄을 읽어 들인다
//				String str = scan.nextLine().trim();
//				System.out.println(str);
//				// 한 줄로 되어있는 문장을 잘라서 score 객체에 저장한다
//				Score score = new Score();
//				String[] temp = str.split(" ");
//				
//				// 문자 → 숫자 변경
//				score.setIndex(Integer.parseInt(temp[0]));
//				score.setName(temp[1]);
//				score.setKorScore(Integer.parseInt(temp[2]));
//				score.setEngScore(Integer.parseInt(temp[3]));
//				score.setMatScore(Integer.parseInt(temp[4]));
//				
//				// ArrayList에 추가
//				scoreList.add(score);
//			}
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		} 
//	}

	// try-with-resources 구문 (finally 안 써도 됨)
//	try(PrintWriter pw = new PrintWriter(filePath)){
//		for (int i = 0; i < scoreList.size(); i++) {
//			Score temp = scoreList.get(i);
//			pw.print(temp.getIndex() + "/");
//			pw.print(temp.getName() + "/");
//			pw.print(temp.getKorScore() + "/");
//			pw.print(temp.getEngScore() + "/");
//			pw.print(temp.getMatScore());
//			pw.println();
//		}
//		System.out.println("정상 저장 되었습니다.");
//	} catch(Exception e){
//		e.printStackTrace();
//	}

}
