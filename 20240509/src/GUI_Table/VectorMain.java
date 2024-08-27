package GUI_Table;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VectorMain {

	public static void main(String[] args) {

		JFrame frame = new JFrame("테이블 예제");

		frame.setBounds(20, 20, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 테이블 데이터 생성 (벡터의 벡터) → 이 방법이 복잡해보이면 DefaultTableModel 이용해서 생성해도 된다.
		Vector<Vector<Object>> dataList = new Vector<Vector<Object>>();
		
		Vector<Object> data1 = new Vector<Object>(); // 각각의 행의 data 객체를 생성하고, 
		Vector<Object> data2 = new Vector<Object>(); // 상세 내용을 add로 추가해준다.
		
		data1.add("홍길동");
		data1.add(30);
		data1.add("남자");
		data2.add("이서희");
		data2.add(25);
		data2.add("여자");
		
		// 테이블 열 이름 생성
		Vector<String> columnNames = new Vector<String>();
		
		columnNames.add("이름");
		columnNames.add("나이");
		columnNames.add("성별");
		
		// 위에서 생성한 데이터를 한 곳을 묶는다. (저장 개념)
		dataList.add(data1);
		dataList.add(data2);
		
		// JTable(데이터, 컬럼명)
		JTable table = new JTable(dataList, columnNames); 

		JScrollPane scrollPane = new JScrollPane(table); 

		frame.add(scrollPane);

		frame.setVisible(true);

	}

}

/*
 * Vector는 ArrayList와 같이 List 인터페이스를 상속 받은 컬렉션 프레임워크
 * ArrayList와 크게 다르지 않다.
 * 
 * 가변 개수의 배열이 필요할 때 과거에 사용.
 * 
 * 객체 생성 시 ArrayList 처럼 생성하면 된다.
 * 
 */
