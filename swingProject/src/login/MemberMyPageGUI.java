package login;
//

////마이페이지
//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//public class MemberMyPageGUI extends JFrame {
//
//	String stuId;
//	int numCourse;
//	LoginGUI loginId;
//	
//
//	JLabel name;
//	JLabel signUpId;
//	JLabel signUpPw;
//	JLabel signUpPwCheck;
//	JLabel phoneNumber;
//	JLabel birth;
//	JLabel nickName;
//	JTextField courseName = new JTextField("");
//
//	JButton changePw = new JButton("변경");
//	JButton changePNum = new JButton("변경");
//	JButton changeBirth = new JButton("변경");
//	JButton changeNickName = new JButton("변경");
//
//	JLabel myPage = new JLabel("마이페이지");
//	JLabel nameL = new JLabel("이름");
//	JLabel signUpIdL = new JLabel("아이디");
//	JLabel signupPwL = new JLabel("비밀번호");
//	JLabel signUpPwCheckL = new JLabel("비밀번호 확인");
//	JLabel phoneNumberL = new JLabel("휴대폰 번호");
//	JLabel birthL = new JLabel("생년월일");
//	JLabel nickNameL = new JLabel("닉네임");
//	JLabel courseNameL = new JLabel("수강신청과목");
//	JButton logout = new JButton("로그아웃");
//	JDBC db;
//	MemberMyPageGUI(JDBC db) throws ClassNotFoundException, SQLException {
//		setTitle("MY Page");
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Container c = this.getContentPane();
//		JPanel signupPanel = new JPanel();
//		signupPanel.setLayout(null);
//		c.add(signupPanel, BorderLayout.CENTER);
//
//		
//		// 해당 아이디의 정보 불러오기. ------------------------------
//		MemberData st = db.selectUI(LoginGUI.uid); // 로그인 한 아이디
//		String stuName = st.name;
//		name = new JLabel(stuName);
//
//		String id = st.id;
//		signUpId = new JLabel(id);
//
//		String password = st.password;
//		signUpPw = new JLabel(password);
//
//		String pwCk = st.password;
//		signUpPwCheck = new JLabel(pwCk);
//
//		String phonenumber = st.phonenumber;
//		phoneNumber = new JLabel(phonenumber);
//
//		String birthday = st.birthday;
//		birth = new JLabel(birthday);
//
//		String nickname = st.nickname;
//		nickName = new JLabel(nickname);
//		//------------------------------------------------------------
//
//		signupPanel.add(nameL);
//		nameL.setBounds(320, 45, 100, 30);
//		signupPanel.add(name);
//		name.setBounds(445, 48, 120, 25);
//		signupPanel.add(signUpIdL);
//		signUpIdL.setBounds(320, 115, 100, 30);
//		signupPanel.add(signUpId);
//		signUpId.setBounds(445, 118, 120, 25);
//		signupPanel.add(signupPwL);
//		signupPwL.setBounds(320, 185, 100, 30);
//		signupPanel.add(signUpPw);
//		signUpPw.setBounds(445, 188, 120, 25);
//		signupPanel.add(changePw);
//		changePw.setBounds(568, 255, 82, 25);
//		signupPanel.add(signUpPwCheckL);
//		signUpPwCheckL.setBounds(320, 255, 100, 30);
//		signupPanel.add(signUpPwCheck);
//		signUpPwCheck.setBounds(445, 255, 120, 25);
//		signupPanel.add(changePNum);
//		changePNum.setBounds(568, 325, 82, 25);
//		signupPanel.add(phoneNumberL);
//		phoneNumberL.setBounds(320, 322, 100, 30);
//		signupPanel.add(phoneNumber);
//		phoneNumber.setBounds(445, 325, 120, 25);
//		signupPanel.add(changeBirth);
//		changeBirth.setBounds(568, 395, 82, 25);
//		signupPanel.add(birthL);
//		birthL.setBounds(320, 392, 100, 30);
//		signupPanel.add(birth);
//		birth.setBounds(445, 395, 120, 25);
//		signupPanel.add(nickNameL);
//		nickNameL.setBounds(320, 462, 100, 30);
//		signupPanel.add(nickName);
//		nickName.setBounds(445, 465, 120, 25);
//		signupPanel.add(changeNickName);
//		changeNickName.setBounds(568, 465, 82, 25);
//		signupPanel.add(courseNameL);
//		courseNameL.setBounds(320, 532, 142, 54);
//		signupPanel.add(courseName);
//		courseName.setBounds(320, 575, 327, 85);
//		signupPanel.add(logout);
//		logout.setBounds(536, 696, 111, 23);
//
//		
//		
//		// 해당 아이디의 정보 중 수강 정보 불러오고, 그 수강강좌 정보 불러오기. ----
//		MemberData md = db.selectUI(LoginGUI.uid); // 로그인 한 아이디 값
//		// 내가 수강하는 강좌
//		String stuCourseName = md.coursename; 
//		System.out.println(stuCourseName);
//		String courseList1 = db.selectCI(stuCourseName);
//		System.out.println(courseList1);         //확인용
//		courseName.setText(courseList1);
//		//---------------------------------------------------------
//
//		this.setLocation(200, 200);
//		this.setSize(1000, 800);
//		this.setVisible(true);
//	}
//
////	public static void main(String[] args) throws ClassNotFoundException, SQLException {
////		new MemberMyPageSwing();
////
////	}
//}

//MY PAGE 
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MemberMyPageGUI extends JFrame { // My Page

	JDBC db;

	String stuId;
	int numCourse;
	LoginGUI loginId;

	JLabel name;
	JLabel signUpId;
	JLabel signUpPw;
	JLabel signUpPwCheck;
	JLabel phoneNumber;
	JLabel birth;
	JLabel nickName;
	JTextArea courseName = new JTextArea(2, 5);

	JButton changePw = new JButton("변경"); // 비밀번호확인 변경
	JButton changePNum = new JButton("변경"); // 휴대폰번호 변경
	JButton changeBirth = new JButton("변경"); // 생일 변경
	JButton changeNickName = new JButton("변경"); // 닉네임 변경
	JButton back = new JButton("뒤로");

	JLabel myPage = new JLabel("마이페이지");
	JLabel nameL = new JLabel("이름");
	JLabel signUpIdL = new JLabel("아이디");
	JLabel signUpPwCheckL = new JLabel("비밀번호");
	JLabel phoneNumberL = new JLabel("휴대폰 번호");
	JLabel birthL = new JLabel("생년월일");
	JLabel nickNameL = new JLabel("닉네임");
	JLabel courseNameL = new JLabel("수강신청과목");
	JButton logout = new JButton("로그아웃");

	ChangePasswordGUI pw; // 비밀번호 변경 새 창

	MemberMyPageGUI(JDBC db) throws ClassNotFoundException, SQLException {

		ChangePasswordGUI cp = null;
		setTitle("MY Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		JPanel signupPanel = new JPanel();
		signupPanel.setLayout(null);
		c.add(signupPanel, BorderLayout.CENTER);

		// 해당 아이디의 정보 불러오기. ------------------------------
		MemberData st = db.selectUI(LoginGUI.uid); // 로그인 한 아이디
		String stuName = st.name;
		name = new JLabel(stuName);

		String id = st.id;
		signUpId = new JLabel(id);

		String pwCk = st.password;
		String sumpw = "";
		for (int i = 0; i < pwCk.length(); i++) {
			sumpw += "*";
		}
		;
		signUpPwCheck = new JLabel(sumpw);

		String phonenumber = st.phonenumber;
		phoneNumber = new JLabel(phonenumber);

		String birthday = st.birthday;
		birth = new JLabel(birthday);

		String nickname = st.nickname;
		nickName = new JLabel(nickname);
		// ------------------------------------------------------------

		signupPanel.add(nameL);
		nameL.setBounds(320, 45, 100, 30);
		signupPanel.add(name);
		name.setBounds(445, 45, 120, 25);
		signupPanel.add(signUpIdL);
		signUpIdL.setBounds(320, 125, 100, 30);
		signupPanel.add(signUpId);
		signUpId.setBounds(445, 125, 120, 25);
		signupPanel.add(changePw);
		changePw.setBounds(568, 205, 82, 25);
		signupPanel.add(signUpPwCheckL);
		signUpPwCheckL.setBounds(320, 205, 100, 30);
		signupPanel.add(signUpPwCheck);
		signUpPwCheck.setBounds(445, 205, 120, 25);
		signupPanel.add(changePNum);
		changePNum.setBounds(568, 285, 82, 25);
		signupPanel.add(phoneNumberL);
		phoneNumberL.setBounds(320, 285, 100, 30);
		signupPanel.add(phoneNumber);
		phoneNumber.setBounds(445, 285, 120, 25);
		signupPanel.add(changeBirth);
		changeBirth.setBounds(568, 365, 82, 25);
		signupPanel.add(birthL);
		birthL.setBounds(320, 365, 100, 30);
		signupPanel.add(birth);
		birth.setBounds(445, 365, 120, 25);
		signupPanel.add(nickNameL);
		nickNameL.setBounds(320, 445, 100, 30);
		signupPanel.add(nickName);
		nickName.setBounds(445, 445, 120, 25);
		signupPanel.add(changeNickName);
		changeNickName.setBounds(568, 445, 82, 25);
		signupPanel.add(courseNameL);
		courseNameL.setBounds(232, 512, 142, 54);
		signupPanel.add(courseName);
		courseName.setBounds(215, 555, 565, 85);
		signupPanel.add(logout);
		logout.setBounds(669, 665, 111, 23);
		signupPanel.add(back);
		back.setBounds(550, 665,100,23);
		

        //해당 아이디의 정보 중 수강 정보 불러오고, 그 수강강좌 정보 불러오기. ----
		MemberData md = db.selectUI(LoginGUI.uid); // 로그인 한 아이디 값
		// 내가 수강하는 강좌
		String stuCourseName = md.coursename;
		System.out.println(stuCourseName);
		String courseList1 = db.selectCI(stuCourseName);
		System.out.println(courseList1); // 확인용
		courseName.setText(courseList1);
		// ---------------------------------------------------------

		// 비밀번호 변경 모달창
		changePw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changePw.setEnabled(false);
				try {
					pw = new ChangePasswordGUI();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pw.jp.setVisible(true);

			}

		});
		 logout.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					LoginGUI login = new LoginGUI();
					
					login.jframe.setVisible(true);
					
				}
		    	  
		      });
		 back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					HomePage home = new HomePage(db);
					home.setVisible(true);
					
					
					
				}
		    	  
		      });

		this.setLocation(200, 200);
		this.setSize(1000, 800);
		this.setVisible(true);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//    new MemberMyPageGUI();

	}
}