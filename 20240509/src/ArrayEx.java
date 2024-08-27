import java.util.Arrays;

public class ArrayEx {

	public static void main(String[] args) {

		// 2차원 배열
		// 이름을 저장하는 배열 생성
		// 5개를 저장
		String[] nameList = {"이서희", "이익준", "채송화", "김준완", "양석형"};
		
		System.out.println(Arrays.toString(nameList));
		
		// 하나의 행에 정보를 문자열로 저장
		String[] info = {"이서희", "A"};
		String[] info1 = {"이익준", "O"};
		String[] info2 = {"채송화", "B"};
		String[] info3 = {"김준완", "AB"};
		String[] info4 = {"양석형", "O"};
		
		// 문자열 배열을 이용해서 각각의 문자열 배열 관리
		String[][] infoList = {info, info1, info2, info3, info4};
		
		// 2차원 배열 같은 경우에는 행을 기준으로 값을 뽑아오면 된다.
		for(int i = 0; i < infoList.length; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(infoList[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
