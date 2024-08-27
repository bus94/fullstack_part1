package GUI_Table_Test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

// 내가 작성해본 코드
class MyFrame extends JFrame {

	public MyFrame() {

		// 윈도우 생성
		setTitle("게시글");
		setLayout(null);

		setBounds(50, 50, 1000, 1000);

		JPanel tablePan = new JPanel();
		tablePan.setBounds(300, 10, 400, 200);

		JLabel label01 = new JLabel("글 제목: ");
		JTextField text01 = new JTextField(30);
		tablePan.add(label01);
		tablePan.add(text01);

		JLabel label02 = new JLabel("작성자 : ");
		JTextField text02 = new JTextField(30);
		tablePan.add(label02);
		tablePan.add(text02);

		JLabel label03 = new JLabel("글 내용: ");
		JTextField text03 = new JTextField(30);
		tablePan.add(label03);
		tablePan.add(text03);

		JPanel selPan = new JPanel(new GridLayout(1, 2, 50, 0));
		selPan.setBounds(350, 210, 300, 50);
		JButton btn01 = new JButton("글 추가");
		JButton btn02 = new JButton("글 삭제");
		selPan.add(btn01);
		selPan.add(btn02);

		JPanel checkPan = new JPanel(new GridLayout());
		checkPan.setBounds(0, 300, 1000, 500);
		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("글번호");
		model.addColumn("글제목");
		model.addColumn("글내용");
		model.addColumn("조회수");

		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		checkPan.add(scrollPane);

		add(tablePan);
		add(selPan);
		add(checkPan);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}

// 강사님 풀이
public class TableController extends JFrame implements ActionListener {

	/*
	 * 윈도우 창을 띄우고 입력 받는 것! 이벤트 설정해서 이벤트 발생 시 TableController에서 처리
	 * 
	 */

//	MyFrame frame = new MyFrame();

	private JPanel inputPanel;
	private JPanel tablePanel;

	// 텍스트 입력
	private JTextField titleField;
	private JTextField writerField;
	private JTextField contentField;

	// 텍스트필드 앞에 글씨
	private JLabel title;
	private JLabel writer;
	private JLabel content;

	// 추가버튼, 삭제버튼
	private JButton addBtn;
	private JButton removeBtn;

	// 테이블 생성하는 클래스 변수
	private JTable table;
	private DefaultTableModel tableModel;
	// 위의 처럼 전역변수로 선언하면 어떤 메서드에서든 접근해서 컴포넌트를 조작할 수 있다.
	
	private TableService service = new TableService();

	TableController() {
		// 윈도우 설정
		setBounds(30, 30, 1000, 500);
		setLayout(new GridLayout(2, 1));

		// 컴포넌트들 설정
		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void init() {
		// inputPanel 생성 (공간 생성)
		// 라벨, 버튼, 입력
		// 객체를 생성할 때 레이아웃 객체를 생성해서 넘겨주면 자동으로 레이아웃 설정되어서 setLayout()메서드 안 써도 된다.
//		inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

		// JPanel 공간 분리하는 클래스
		// 기본 배치는 FlowLayout으로 한 줄에 배치 된다.
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4, 2));

		Font font = new Font("굴림체", Font.BOLD, 25);

		title = new JLabel("글 제목: ");
		title.setFont(font);
		titleField = new JTextField(10);

		writer = new JLabel("작성자 : ");
		writer.setFont(font);
		writerField = new JTextField(10);

		content = new JLabel("글 내용: ");
		content.setFont(font);
		contentField = new JTextField(10);

		addBtn = new JButton("추가");
		addBtn.setFont(font);
		removeBtn = new JButton("삭제");
		removeBtn.setFont(font);

		// 패널에 추가
		inputPanel.add(title);
		inputPanel.add(titleField);
		inputPanel.add(writer);
		inputPanel.add(writerField);
		inputPanel.add(content);
		inputPanel.add(contentField);
		inputPanel.add(addBtn);
		inputPanel.add(removeBtn);

		// 윈도우에 패널 추가
		add(inputPanel);

		// 테이블 생성
		// 테이블이 올라간 영역을 생성
		tablePanel = new JPanel();
		// JFrame 윈도우 창은 기본적으로 BorderLayout - 가운데로 컴포넌트 하나가 올라간다.
		tablePanel.setLayout(new BorderLayout());

		// 데이터를 저장하는 표 생성 (어떤 형태로 저장할 것인지)
		String[] header = { "글 제목", "작성자", "글 내용" };
		tableModel = new DefaultTableModel(header, 0);

		// 테이블 생성
		table = new JTable(tableModel);

		// 스크롤 생성
		JScrollPane scrollPane = new JScrollPane(table);  

		// 테이블 영역에 추가
		tablePanel.add(scrollPane);

		// 테이블 영역을 윈도우에 추가
		add(tablePanel);

		// 버튼을 클릭했을 때 실행하는 메서드 연결하기
		// - 하나의 메서드를 이용해서 추가버튼을 클릭했는지 삭제버튼을 클릭했는지 구별을 해야된다.
		addBtn.addActionListener(this); // this: actionPerformed() 이 메서드를 실행하겠다의 의미
		removeBtn.addActionListener(this);
		
		/*
		 * 테이블에서 특정 행이 선택 되었을 때 발생하는 이벤트를 처리하는
		 * TableSelectionListener
		 * 
		 * getSelectionModel()
		 * - 선택 모델(데이터를 저장하는 표)
		 *   행을 선택하는 방법을 관리하는 메서드
		 * 
		 */
		table.getSelectionModel().addListSelectionListener(new TableSelectionListener());
		
	}
	class TableSelectionListener implements ListSelectionListener{
		
		// 마우스로 테이블의 행을 조작하고 있니?
		// 값을 조정 중인지 아닌지 확인해서 값을 조정하고 있지 않을 때 실행 할 수 있도록!
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// 테이블의 값이 조정되지 않고 한 번 클릭했을 때 실행해라! 라는 뜻으로 사용된다.
			// - 테이블에 한 행을 더블 클릭을 하면 수정 상태
			// - 한 번 클릭했다면 아래의 실행문을 실행하는 역할
			if(!e.getValueIsAdjusting()) { // adjust: 조정하다
				// getSelectedRow()
				// - 선택된 행의 공간번호(인덱스) 가져온다.
				int selectRow = table.getSelectedRow() + 1;
				
				// -1일 경우에는 선택된 행이 없다는 뜻
				if(selectRow != -1) {
					/*
					 * 클릭을 했을 때 조회수를 하나 증가 해서 팝업 창에 띄우기
					 * 현재 클릭된 행의 정보를 readCount로 매개변수를 넘겨
					 * 
					 */
					int readCount1 = service.readCount(selectRow);
					
					// 테이블에서 인덱스 번호로 데이터를 가져와야하므로 selectRow에서 -1을 해서 인덱스 번호를 변경 후 가져와야한다
					String title = table.getValueAt(selectRow, 0).toString();
					String writer = table.getValueAt(selectRow, 1).toString();
					String content = table.getValueAt(selectRow, 2).toString();
					
					// 팝업에 출력
					String message = "글 제목: " + title + "\n" + "작성자 : " + writer+ "\n" 
									+ "글 내용: " + content + "\n" + "조회수 : " + readCount1;
					
					JOptionPane.showMessageDialog(TableController.this, message.toString());
					
				}
			}
		}
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. 어떤 버튼이 눌렸는지 정보를 가져온다.
		// 어떤 컴포넌트가 눌렸는지 모르기 때문에 Object로 받는다.
		Object src = e.getSource();

		// 2. src 변수에 저장된 주소값을 이용해서 삭제버튼과 추가버튼을 구별한다.
		if (src == addBtn) {
//			// 추가 버튼을 클릭했을 때 실행
//			System.out.println("추가 버튼!");

//			// 각각 텍스트 필드에서 데이터 가져오기
//			String title = titleField.getText();
//			String writer = writerField.getText();
//			String content = contentField.getText();
//			
//			// DB로 전송하기 위해서 여러 개의 변수를 하나로 묶는다.
//			Board board = new Board(title, writer, content);
//			// 텍스트 필드에서 데이터 가져와서 바로 변수로 묶기
			Board board = new Board(titleField.getText(), writerField.getText(), contentField.getText());
//			
//			// 현재 board를 테이블에 추가하기!
//			String[] rowData = {board.getTitle(), board.getWriter(), 
//					board.getContent(), String.valueOf(board.getReadCount())};
//			// valueOf() : 괄호 안의 해당 객체를 String 객체로 변환시키는 역할. (String의 객체로 형변환)
//			
//			// 한 행을 추가하기
//			tableModel.addRow(rowData);
//			
			// 기존 input 창들을 비우기
			titleField.setText("");
			writerField.setText("");
			contentField.setText("");

			TableDAO tableDAO = new TableDAO();
			
			// 팝업 띄움
			if (tableDAO.insert(board) > 0) {
				JOptionPane.showMessageDialog(null, "게시글이 추가 되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "게시글 추가에 실패하였습니다.");
			}
			// 팝업 메뉴를 꼭 닫고 실행된다.
			String[][] rowData = service.select();
			
			// 2차원 배열의 주소값을 그대로 저장하면 안된다. → 주소값으로 출력되기 때문이다.
//			tableModel.addRow(rowData);
			// 1차원 배열의 주소값을 하나씩 꺼내서 index(공간 번호)를 이용해서 한 줄 씩 row에 추가해야된다.
			for(String[] row : rowData) {
				tableModel.addRow(row);
			}

		} else if (src == removeBtn) {
//			System.out.println("삭제 버튼!");
		}

	}

}

