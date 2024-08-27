package JOptionPaneEx;

import javax.swing.JOptionPane;

public class Dialog1 {
	
	// 객체 생성 없이 main에서 메서드 호출하고 싶으면 static 붙이면 된다.
	public static void confirm() {
		/*
		 * 정보와 함께 선택지를 옵션으로 대화 상자를 보여준다. (ex. Yes or No)
		 * 
		 * ex) JOptionPane.showConfirmDialog(parentComponent, message, title, optionType, messageType)
		 * → (부모컴포넌트, 메세지, 제목창, 팝업창에 고를 수 있는 옵션 종류, 메세지타입)
		 * 
		 * 옵션 타입에 따라서 정수를 리턴
		 * OK → 0
		 * YES → 0
		 * NO → 1
		 * CANCEL → 2
		 * X(팝업 종료) → -1
		 * 
		 */
		
		// yes or no
		int choice1 = JOptionPane.showConfirmDialog(null, "계속 진행하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
		
		// 선택의 결과를 출력
		// JOptionPane.YES_OPTION == 0 으로 고정
		System.out.println("YES or NO 결과: " + (choice1 == JOptionPane.YES_OPTION ? "YES" : "NO"));
		
		// yes or no or cancel
		int choice2 = JOptionPane.showConfirmDialog(null, "다음으로 진행하시겠습니까?", "확인", JOptionPane.YES_NO_CANCEL_OPTION);
		switch(choice2) {
		case JOptionPane.YES_OPTION:
			System.out.println("예");
			break;
			
		case JOptionPane.NO_OPTION:
			System.out.println("아니오");
			break;
			
		case JOptionPane.CANCEL_OPTION:
			System.out.println("취소");
			break;
		}
	}
	
	public static void input() {
		// 키보드로 입력 받는 형태 (팝업창에서 입력 받음)
		// Ok를 누르면 자동으로 입력받은 창 안의 내용이 문자열로 넘어온다.
		String input = JOptionPane.showInputDialog(null, "내용", "내용을 입력해주세요");
		System.out.println("콘솔: " + input);
		
		// 여러 개의 드롭다운 메뉴 중에서 하나를 선택해서 보여줘야할 때
		// Object 타입으로 반환이 된다. 따라서 형변환이 필요하다.
		// (parentComponent, message, title, messageType, Icon, value[], initialValue)
		// (부모컴포넌트, 메세지, 타이틀, 메세지타입, 아이콘이미지(지정해서 사용 가능), 배열로 저장된 변수명, 기본적으로 처음 보여줄 데이터)
		String[] list = {"A", "B", "C"};
		String n = (String) JOptionPane.showInputDialog(null, "내용", "타이틀", JOptionPane.WARNING_MESSAGE, null, list, list[0]);
		System.out.println("콘솔: " + n);
		
		
	}

	public static void main(String[] args) {

		//confirm(); // static 함수이기 때문에 new로 객체 생성할 필요없이 호출 가능하다.
		input();
		/*
		 * JOptionPane
		 * - 사용자에게 값을 묻거나 정보를 알려주는 표준 대화상자 (쉽게 말해 팝업창)
		 * 
		 * 4가지
		 * showMessageDialog
		 * showConfirmDialog
		 * showInputDialog
		 * showOptionDialog
		 * 
		 * -----------------------
		 * showMessageDialog
		 * - 단순히 정보만 알려준다.
		 * ex) JOptionPane.showMessageDialog(parentComponent, message);
		 * ex) JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
		 * 
		 * parentComponent
		 * - 주로 null 값으로 들어간다. 
		 * - 부모 컴포넌트로 지정해서 팝업 활성화를 제어할 수 있다.
		 * message
		 * - 문자열 형식으로 입력해야한다.
		 * - 팝업에 표시될 내용이다.
		 * 
		 * title
		 * - 팝업 상자에 표시될 타이틀
		 * 
		 * messageType
		 * - 에러, 정보, 경고, 아무것도 표현 안함 
		 * 
		 * 
		 * 
		 */
		
//		// 정보 메세지 팝업
//		JOptionPane.showMessageDialog(null, "졸려", "정보메시지", JOptionPane.INFORMATION_MESSAGE);
//		
//		// 결과를 보기 위해서 팝업을 설정하면 팝업에 입력을 받거나 확인을 눌러 팝업 실행 다음에 내가 원하는 문장이 실행된다.
//		// 경고 메세지 팝업
//		JOptionPane.showMessageDialog(null, "졸려", "경고메시지", JOptionPane.WARNING_MESSAGE);
//		
//		// 에러 메세지 팝업
//		JOptionPane.showMessageDialog(null, "졸려", "에러메시지", JOptionPane.ERROR_MESSAGE);
//		
//		// 질문 메세지 팝업
//		JOptionPane.showMessageDialog(null, "졸려", "질문메시지", JOptionPane.QUESTION_MESSAGE);
//		
//		// 일반 메세지 팝업 (아이콘 없이 출력)
//		JOptionPane.showMessageDialog(null, "졸려", "일반메시지", JOptionPane.PLAIN_MESSAGE);
		
		
		
		
		
		
		
		
		
		
		
	}

}
