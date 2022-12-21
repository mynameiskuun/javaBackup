////
package login;

//수강신청 페이지

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MemberRequestClassGUI extends JFrame {

//	MemDao memdb = new MemDao();
//	CourseDB courseDB;
	JDBC db;

	String java = "자바";
	String ai = "AI";
	String bigData = "빅데이터";
	String python = "파이썬";
	String noStr = "-";
	String str;

	Component Component = null;
	JPanel contentPane;
	JTable table;
	JButton jb1;
	JButton jb2;

	JRadioButton cb1 = new JRadioButton(java);
	JRadioButton cb2 = new JRadioButton(ai);
	JRadioButton cb3 = new JRadioButton(bigData);
	JRadioButton cb4 = new JRadioButton(python);
	ButtonGroup buttonGroup = new ButtonGroup();

	MemberRequestClassGUI(JDBC db) throws ClassNotFoundException, SQLException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 68, 855, 221);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		jb1 = new JButton("수강신청 가능 강좌");
		jb1.setBounds(749, 304, 150, 30);
		contentPane.add(jb1);

		jb2 = new JButton("수강신청");
		jb2.setBounds(749, 471, 150, 30);
		contentPane.add(jb2);

		JPanel jp1 = new JPanel();
		jp1.setBounds(96, 346, 776, 132);
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER, 70, 50));
		contentPane.add(jp1);

		JButton jb3 = new JButton("뒤로가기");
		jb3.setBounds(70, 600, 100, 23);
		contentPane.add(jb3);

		JButton jb4 = new JButton("로그아웃");
		jb4.setBounds(180, 600, 100, 23);
		contentPane.add(jb4);

		// 강좌 테이블--------------------------------------------------

		DefaultTableModel model;
//		courseDB = new CourseDB();
		String[] cols = db.showDBcolsCI();

		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(23);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(180);
		table.getColumnModel().getColumn(6).setPreferredWidth(200);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		scrollPane.setViewportView(table);
		// ----------------------------------------------------------

		buttonGroup.add(cb1);
		buttonGroup.add(cb2);
		buttonGroup.add(cb3);
		buttonGroup.add(cb4);

		jp1.add(cb1);
		jp1.add(cb2);
		jp1.add(cb3);
		jp1.add(cb4);

		this.setLocation(200, 200);
		this.setSize(1000, 800);
		this.setVisible(true);

		// 수강신청가능강좌 버튼 눌렀을 경우 ----------------------------------
		jb1.addActionListener((e1) -> {
			try {
				ArrayList rows = db.getDBAllRowsCI();
				model.setRowCount(0);
				for (int i = 0; i < rows.size(); i++) {
					model.addRow((String[]) rows.get(i));
				}
				table.setModel(model);
				System.out.println("전체조회완료");

			} catch (SQLException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
		});

		// --------------------------------------------------------------

		// 수강신청 버튼 눌렀을 경우
		// 이벤트--------------------------------------------------------------------------------------
		jb2.addActionListener((e2) -> {
			try {
				String courseName = boxvalue(e2);
				MemberData st = db.selectUI(LoginGUI.uid);

				String stuCourseName = st.coursename;

				if (courseName.equals(noStr)) {
					JOptionPane.showMessageDialog(this, "다시 선택해주세요", "Message", JOptionPane.INFORMATION_MESSAGE);
				} else {

					if (courseName.equals(stuCourseName)) {
						JOptionPane.showMessageDialog(this, "이미 수강신청한 강좌 입니다", "Message",
								JOptionPane.INFORMATION_MESSAGE);
					} else {

						if (stuCourseName.equals(java) || stuCourseName.equals(ai) || stuCourseName.equals(bigData)
								|| stuCourseName.equals(python)) {
							int a = JOptionPane.showConfirmDialog(this,
									"이미" + stuCourseName + "수강신청 하셨습니다" + courseName + "로 변경하시겠습니까?", "수강신청",
									JOptionPane.YES_NO_OPTION);
							if (a == 0) {
								db.update(courseName, LoginGUI.uid); // ----> "aaal" 로그인 한 아이디 값 변수로 넣기.
							}

						} else {
							db.update(courseName, LoginGUI.uid); // ----> "aaal" 로그인 한 아이디 값 변수로 넣기.
							JOptionPane.showMessageDialog(this, courseName + "수강신청이 완료되었습니다", "Message",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}

			} catch (SQLException ee) {
				ee.printStackTrace();
			}

		});
		// -------------------로그아웃------------------------------

		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginGUI login = new LoginGUI();
				
				login.jframe.setVisible(true);
				
			}
			
		});
		//-----뒤로가기-------
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HomePage home = new HomePage(db);
				home.setVisible(true);
				
				
				
			}
			
		});
	}

//	수강신청 버튼 눌렀을 경우 체크박스 체크된 값 불러와서 넘겨주는 부분----------
	public String boxvalue(ActionEvent e) {
		String courseName;
		if (cb1.isSelected()) {
			courseName = java;
		} else if (cb2.isSelected()) {
			courseName = ai;
		} else if (cb3.isSelected()) {
			courseName = bigData;
		} else if (cb4.isSelected()) {
			courseName = python;
		} else {
			courseName = noStr;
		}
		return courseName;
	}
//---------------------------------------------------------------

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		new MemberRequestClassGUI();
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//
//	}
}
