package GUI_Table;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {

	public static void main(String[] args) {

		/*
		 * JTable 클래스
		 * GUI에서 테이블(표) 형식으로 표현하는 컴포넌트 (위젯)
		 * 
		 * - 행, 열 구조로 데이터 저장
		 * - 2차원 배열을 사용해 데이터를 추가하거나 vector객체를 사용하여 추가가 가능
		 * 
		 * - 직접 테이블에 추가하는 것 보다는 Model객체
		 * - 데이터가 많아지면 자동으로 스크롤 생성
		 * - Scrollable 인터페이스 기능 구현
		 * 
		 * - TableModel을 사용한다.
		 * - 테이블 내의 각각의 행과 열이 만나는 공간 셀(cell) 하나의 값만 기억된다.
		 * 
		 * - 데이터를 저장할 모델을 만들고 뷰인 Jtable에 연결해주어서 화면에 출력시켜주는 것!
		 * 
		 * 
		 */
		
		// 윈도우 생성
		JFrame frame = new JFrame("테이블 예제");
		
		frame.setBounds(20, 20, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 테이블 모델 생성
		DefaultTableModel model = new DefaultTableModel();
		
		// addColumn()
		// : 새로운 열을 추가한다. (열의 이름)
		model.addColumn("이름");
		model.addColumn("나이");
		model.addColumn("성별");
		
		// 테이블 생성 및 모델 설정
		JTable table = new JTable(model); // model이라는 객체의 내용으로 table을 만들겠다;
		
		// 테이블 생성 후 스크롤을 사용 가능하도록 설정
		JScrollPane scrollPane = new JScrollPane(table); // table에 scrollPane을 달아주겠다;
		
		// 윈도우에 추가 한다.
		frame.add(scrollPane);
		
		// 데이터 추가
		// addRow(Object[] data)
		// 새로운 행을 추가하고, 각 열의 데이터를 배열 형태로 저장한다. (벡터형식으로)
		model.addRow(new Object[] {"홍길동", 30, "남자"}); // 객체 생성하며 해당 정보를 {} 안에 기입
		model.addRow(new Object[] {"홍길순", 25, "여자"});
		
		// 윈도우를 보이기
		frame.setVisible(true);
		
		
		
		
		
	}

}
