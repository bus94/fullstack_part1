package Memo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemoGUI extends JFrame {

	private JTable table;
	private DefaultTableModel model;
	private ArrayList<MemoVO> list;
	private JButton btn;
	private JButton btnWriter;
	private JButton btnDelete;
	
	// 선택된 행들만 모아놓은 리스트
	private ArrayList<MemoVO> selectList = new ArrayList<MemoVO>();
	Scanner sc = new Scanner(System.in);

	public MemoGUI() {
		setBounds(0, 0, 700, 500);

		// 기존에 있는 데이터 가져오기
		list = DAO.select();

		// 테이블 모델 생성
		model = new DefaultTableModel();

		// 열이름
		model.addColumn("idx");
		model.addColumn("name");
		model.addColumn("password");
		model.addColumn("memo");
		model.addColumn("writeDate");

		// MemoVO 클래스를 한 행씩 추가하기
		for (MemoVO temp : list) {
			// 한 행씩
			model.addRow(new Object[] { temp.getIdx(), temp.getName(), temp.getPassword(), temp.getMemo(),
					temp.getWriteDate() });
		}

		// 테이블 생성 및 모델 설정
		table = new JTable(model);

		// 스크롤 가능한 테이블 패널을 생성
		JScrollPane s = new JScrollPane(table);
		add(s);

		/*
		 * 버튼을 하나 더 추가해서 글쓰기 새로운 창을 열어서 글제목, 내용, 비밀번호 입력 받아 그 안에 글 쓰기 버튼을 다시 누르면 DB, 기존
		 * 게시글 맨 마지막에 추가되는 코드 작성
		 * 
		 */

		// 버튼 눌렀을 때 원하는 데이터 가져와서 다른 테이블에 추가하는 것
		btn = new JButton("추가");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 테이블에서 선택한 행 가져오기
				int selectRow = table.getSelectedRow();
				System.out.println("선택한 행: " + selectRow); // 버튼을 눌렀을 때 선택한 행으로 출력됨

//				// 중복 선택시 (미완성)
//				int[] arrSelRow = new int[DAO.select().size()];
//				
//				for(int i = 0; i < arrSelRow.length; i++) {
//					arrSelRow[i] = selectRow;
//				}

				// 선택한 행이 있는지 확인
				if (selectRow != -1) {
//					// 선택된 행에서 MemoVO 객체 가져오기
//					MemoVO selectMemo = list.get(selectRow);

					// 선택된 행에서 MemoVO 객체 가져와서 선택된 리스트에 추가하기
					selectList.add(list.get(selectRow));

					// 새로운 JFrame 생성(새로운 창)
					JFrame newFrame = new JFrame("New Table");

					// 새로운 테이블을 생성 해야되므로 데이터를 저장하는 표 형식 필요
					DefaultTableModel newModel = new DefaultTableModel();
					newModel.addColumn("idx");
					newModel.addColumn("name");
					newModel.addColumn("password");
					newModel.addColumn("memo");
					newModel.addColumn("writeDate");

					// 선택된 행이 여러 개일 경우에 반복하면서 출력하기
					for (MemoVO selectMemo : selectList) {
						newModel.addRow(new Object[] { selectMemo.getIdx(), selectMemo.getName(),
								selectMemo.getPassword(), selectMemo.getMemo(), selectMemo.getWriteDate() });
					}

					// 새로운 테이블 생성 및 설정
					JTable newTable = new JTable(newModel);
					JScrollPane newSc = new JScrollPane(newTable);

					// 추가
					newFrame.add(newSc);

					// 새로운 JFrame의 크기 설정하고 화면에 표시
					newFrame.setSize(700, 200);
					newFrame.setVisible(true);

				}
			}
		});
		
		btnWriter = new JButton("글쓰기");
		btnWriter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame writerFrame = new JFrame("새로운 글 추가하기");
//				newFrame1.setBounds(10, 10, 600, 400);
//				writerFrame.setSize(600, 400);

//				JPanel panel = new JPanel();
//				panel.setBounds(0, 0, 500, 50);
//				JLabel titleLabel = new JLabel("글  제목: ");
//				JTextField titleText = new JTextField(10);
//				panel.add(titleLabel);
//				panel.add(titleText);
//				writerFrame.add(panel);
//
//				JPanel memoPanel = new JPanel();
//				memoPanel.setBounds(0, 50, 500, 100);
//				JLabel memoLabel = new JLabel("내    용: ");
//				JTextField memoText = new JTextField(100);
//				memoPanel.add(titleLabel);
//				memoPanel.add(memoText);
//				writerFrame.add(memoPanel);
//				
//				JPanel passwordPanel = new JPanel();
//				passwordPanel.setBounds(0, 150, 500, 50);
//				JLabel passwordLabel = new JLabel("비밀번호: ");
//				JTextField passwordText = new JTextField(10);
//				passwordPanel.add(passwordLabel);
//				passwordPanel.add(passwordText);
//				writerFrame.add(passwordPanel);

				JPanel panel = new JPanel();

				JLabel titleLabel = new JLabel("글쓰기");
				JTextField titleField = new JTextField(20);

				JLabel contentLabel = new JLabel("내    용");
				JTextArea contentArea = new JTextArea(10, 20);
				JScrollPane contentScroller = new JScrollPane(contentArea);

				JLabel passwordLabel = new JLabel("비밀번호");
				JPasswordField passwordField = new JPasswordField(20);

				JButton submitButton = new JButton("가입하기");

				submitButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 텍스트 필드에 있는 모든 내용을 가져오기
						String title = titleField.getText();
						String content = contentArea.getText();
						String password = new String(passwordField.getPassword());

						// DB에 추가하는 내용
						MemoVO vo = new MemoVO(title, password, content);
						DAO.insert(vo);

						// 추가 후 새로고침
						refreshTable();
					}

				});
				
				// 패널에 컴포넌트 추가
				panel.add(titleField);
				panel.add(contentLabel);
				panel.add(contentScroller);
				panel.add(passwordLabel);
				panel.add(passwordField);
				panel.add(submitButton);
				
				// 글쓰기 새 창에 추가하기
				writerFrame.add(panel);
				writerFrame.setSize(400, 300);
				writerFrame.setVisible(true);
//				add(writerFrame);
			}
		});
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectRow = table.getSelectedRow();
				System.out.println("선택한 행: " + selectRow);

				if (selectRow != -1) {
					int selRow = selectRow + 1;
					
					MemoVO vo = list.get(selRow);
					
					int result = DAO.delete(vo);
					if(result > 0) {
						System.out.println("삭제가 완료되었습니다!");
					}else {
						System.out.println("삭제를 실패하였습니다.");
					}
					
					
				}
			}
		});

		JPanel btnPanel = new JPanel();
		add("South", btnPanel);

		// 버튼을 아래 쪽에 추가한다.
		btnPanel.add(btn);
		btnPanel.add(btnWriter);
		btnPanel.add(btnDelete);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void refreshTable() {
		// 데이터를 새로고침하고 테이블 모델에 새로운 데이터를 설정한다.
		list = DAO.select();
		
		// 모든 행이 삭제된다.
		model.setRowCount(0);
		
		for(MemoVO temp : list) {
			// 한 행씩 추가하기
			model.addRow(new Object[] {
					temp.getIdx(),
					temp.getName(),
					temp.getPassword(),
					temp.getMemo(),
					temp.getWriteDate()
			});
		}
		
	}

	public static void main(String[] args) {

		new MemoGUI();

	}

}
