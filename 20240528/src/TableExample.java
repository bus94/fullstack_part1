import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TableExample {
    public static void main(String[] args) {
        // 기본 프레임 설정
        JFrame frame = new JFrame("JTable Database Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // 샘플 데이터와 컬럼 이름
        String[][] data = {
            {"1", "John", "22"},
            {"2", "Anna", "28"},
            {"3", "Mike", "32"}
        };
        String[] columnNames = {"ID", "Name", "Age"};

        // JTable 생성
        JTable table = new JTable(data, columnNames);

        // JScrollPane에 JTable 추가
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // 선택 리스너 추가
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        // 선택된 행의 데이터 가져오기
                        int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
                        String name = (String) table.getValueAt(selectedRow, 1);
                        int age = Integer.parseInt((String) table.getValueAt(selectedRow, 2));

                        // 데이터베이스에서 수정
                        try {
                            DatabaseHelper.updateRow(id, name, age);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        // 삭제 버튼 추가
        JButton deleteButton = new JButton("Delete Selected Row");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
                    try {
                        DatabaseHelper.deleteRow(id);
                        // JTable에서 행 삭제
                        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        frame.add(deleteButton, BorderLayout.SOUTH);

        // 프레임을 화면 중앙에 배치
        frame.setLocationRelativeTo(null);
        // 프레임 표시
        frame.setVisible(true);
    }
}

