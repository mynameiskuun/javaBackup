package login;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

public class StudentManageGUI extends JFrame implements ActionListener{
	JDBC db;
	UpdateDialogGUI updateDial;
	DeleteDialogGUI deleteDial;
	InsertDialogGUI insertDial;
	JTable table;
	DefaultTableModel model;
	static StudentManageGUI stuManageGUI;
	JPanel contentPane;
	JLabel lbTitle = new JLabel("학생관리");
	
	final int COL_LENGTH = 8;
	
	JButton searchAllBtn = new JButton("전체조회");
	JComboBox searchComboBox = new JComboBox();
	JTextField searchTextField = new JTextField();
	JButton searchBtn = new JButton("검색");
	JButton insertBtn = new JButton("추가");
	JButton updateBtn = new JButton("수정");
	JButton deleteBtn = new JButton("삭제");

	String no;
	String name;
	String id;
	String password;
	String phoneNumber;
	String birth;
	String nickName;
	String courseName;

	String[] rowValues;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {

//					메인메서드의 프레임 위에 작성해야 테마적용됨
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) { // Nimbus, Windows
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
					UIManager.getLookAndFeelDefaults().put("defaultFont",
							new FontUIResource(new Font("나눔고딕", Font.PLAIN, 14))); // 기본폰트 설정인데 잘안됨
					stuManageGUI = new StudentManageGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public StudentManageGUI() throws ClassNotFoundException, SQLException {
//		setFont(new Font("나눔고딕", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("관리자페이지");

		setBounds(100, 100, 800, 665);
		db = new JDBC();
		String[] cols = db.showDBcolsUI();
		model = new DefaultTableModel(cols, 0) {
//			더블클릭했을때 셀 수정 불가능하게
			 @Override 
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		};
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(40); // no
		table.getColumnModel().getColumn(1).setPreferredWidth(90); // name
		table.getColumnModel().getColumn(2).setPreferredWidth(100); // id
		table.getColumnModel().getColumn(3).setPreferredWidth(130); // password
		table.getColumnModel().getColumn(4).setPreferredWidth(85); // phoneNumber
		table.getColumnModel().getColumn(5).setPreferredWidth(100); // // birth
		table.getColumnModel().getColumn(6).setPreferredWidth(100); // nickName
//		table.getColumnModel().getColumn(7).setPreferredWidth(100); // courseName
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN); // courseName (마지막컬럼 자동정렬)
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		contentPane = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 135, 660, 400);
		contentPane.add(scrollPane);

		searchComboBox.setModel(new DefaultComboBoxModel(cols));

		scrollPane.setViewportView(table);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lbTitle.setBounds(380, 28, 64, 24);
		searchAllBtn.setBounds(65, 70, 90, 40);
		searchComboBox.setBounds(175, 70, 80, 40);
		searchTextField.setBounds(260, 70, 100, 40);
		searchTextField.setColumns(10);
		searchBtn.setBounds(365, 70, 80, 40);
		insertBtn.setBounds(465, 70, 80, 40);
		updateBtn.setBounds(555, 70, 80, 40);
		deleteBtn.setBounds(645, 70, 80, 40);

		contentPane.setLayout(null);
		contentPane.add(lbTitle);
		contentPane.add(searchAllBtn);
		contentPane.add(searchComboBox);
		contentPane.add(searchTextField);
		contentPane.add(searchBtn);
		contentPane.add(insertBtn);
		contentPane.add(updateBtn);
		contentPane.add(deleteBtn);

		searchAllBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ArrayList rows = db.getDBAllRowsUI();
					model.setRowCount(0); // 열의 개수를 0으로 만든다.

					for (int i = 0; i < rows.size(); i++) { // rows의 크기만큼 데이터 출력
						model.addRow((String[]) rows.get(i));
					}
					table.setModel(model);
					System.out.println("전체조회완료");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		searchTextField.addActionListener(this);
		searchBtn.addActionListener(this);
		insertBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == searchTextField || e.getSource() == searchBtn) { // 엔터 또는 검색버튼 눌렀을때 검색하기
			String comboBoxValue = searchComboBox.getSelectedItem().toString();
			String inputText = searchTextField.getText();

			if (inputText.equals("") || inputText == null) {
				System.out.println("값을 입력하세요");
			} else {
				try {
					ArrayList rows = db.showSearchRows(comboBoxValue, inputText);
					model.setRowCount(0);
					for (int i = 0; i < rows.size(); i++) {
						model.addRow((String[]) rows.get(i)); // 열을 모델에 삽입
					}
					table.setModel(model);
					System.out.println("검색완료");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		if (e.getSource() == insertBtn) {
			insertDial = new InsertDialogGUI(db);
		}

		if (e.getSource() == updateBtn) {
			int row = table.getSelectedRow();
			
			if (0 <= row) { // 선택한 행이 있을때
				String[] rowValues = new String[COL_LENGTH];
				for (int i = 0; i < COL_LENGTH; i++) { // 선택한 열의 값들 가져오기
					rowValues[i] = (String) table.getValueAt(row, i);
				}

				no = rowValues[0];
				name = rowValues[1];
				id = rowValues[2];
				password = rowValues[3];
				phoneNumber = rowValues[4];
				birth = rowValues[5];
				nickName = rowValues[6];
				courseName = rowValues[7];

				try {
					updateDial = new UpdateDialogGUI(this, db);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		if (e.getSource() == deleteBtn) {
			int row = table.getSelectedRow();
			if (0 <= row) {
				String[] rowValues = new String[COL_LENGTH];
				for (int i = 0; i < COL_LENGTH; i++) { // 선택한 열의 값들 가져오기
					rowValues[i] = (String) table.getValueAt(row, i);
				}

				no = rowValues[0];
				name = rowValues[1];
				id = rowValues[2];
				password = rowValues[3];
				phoneNumber = rowValues[4];
				birth = rowValues[5];
				nickName = rowValues[6];
				courseName = rowValues[7];

				deleteDial = new DeleteDialogGUI(this, db, model);
			}

		}
	}
}
