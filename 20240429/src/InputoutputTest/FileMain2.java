package InputoutputTest;

import java.io.*; // 전부 가져온다.

public class FileMain2 {

	public static void main(String[] args) {
		/*
		 * 입출력
		 * - 파일은 데이터는 영구적으로 보존 방법 중에 하나다. 
		 *   프로그램이 종료되더라도 파일에 저장된 데이터는 유지!
		 * - 데이터 공유
		 *   파일을 사용하여 데이터를 다른 프로그램이나 시스템과 공유할 수 있도록 한다.
		 * - 대용량 데이터를 메모리에 모두 로드하는 것은 비효율적일 수 있다. 
		 *   파일 입출력을 이용해서 대용량의 데이터를 조금씩 읽고 처리할 수 있다.
		 * 
		 */

		File file = new File("ex1.txt");
		String str = "hello java programming";

		try {
			// 자바 파일을 바이트를 이용해서 텍스트로 저장
			// exists()
			// 폴더에 위의 파일객체의 정보파일이 있는지 확인하는 메서드
			// 있으면 true, false
			if (!file.exists()) {
				file.createNewFile();
			}

			FileOutputStream fo = new FileOutputStream(file); // 연결통로 생성

			fo.write('A');
			;
			fo.write('\n');
			// 문자를 바이트 배열로 변경해서 보내야된다
			byte[] b = str.getBytes();
			fo.write(b);
			fo.write('\n');

			fo.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// 위에서 저장을 했다면 읽기
		// 또 스트림을 작성하는 이유는 단방향이기 때문에
		// 위의 출력 닫고 새로운 입력 열어야 된다.

		file = new File("ex1.txt");
		try {
			FileInputStream fs = new FileInputStream(file);

			int data;
//			while (true) {
//				data = fs.read();
//				// read()
//				// - 데이터 바이트 단위로 읽는다
//				// - 따라서 숫자로 읽어오기 때문에 문자로 출력하는 것으로 형변환 필요
//				// - ex. A : 65
//				System.out.println((char) data);
//				
//				// 더 이상 읽어올 데이터가 없으면 -1을 돌려준다
//				if(data == -1) {
//					break;
//				}
//			}
//			System.out.println("정상 출력!");
			while ((data = fs.read()) != -1) {
				System.out.print((char) data);
			}
			System.out.println("정상 출력!");
			
			fs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
