package login;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI {
	JFrame jframe = new JFrame();
	JPanel jpanel = new JPanel();
	JPanel signupPanel = new JPanel();
	JTextField idf = new JTextField();
	JPasswordField pwf = new JPasswordField();
	JButton login, signup; 
	JLabel idLabel = new JLabel("  ID   : ");
	JLabel pwLabel = new JLabel("PASSWORD  : ");
	JDBC db = new JDBC();
	static String uid;
	
	JFrame jf;
	public LoginGUI() {
		jframe.setTitle("중앙정보처리학원");
		jframe.setBounds(50, 50, 1000, 800); // 전체 창 크기
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 누르면 꺼지게 설정
		jframe.setVisible(true);
		
		jpanel.setLayout(null);
		jpanel.setVisible(true);
		jframe.add(jpanel);
	
		
		//아이디,패스워드 입력칸
		jpanel.add(idf);
		jpanel.add(pwf);
		idf.setBounds(420, 450, 140, 30);
		pwf.setBounds(420, 500, 140, 30);
		
		//아이디,패스워드 라벨
		jpanel.add(idLabel);
		jpanel.add(pwLabel);
		idLabel.setBounds(370, 450, 140, 30);
		pwLabel.setBounds(320, 500, 140, 30);
		
		//로그인,회원가입 버튼
		jpanel.add(login=new JButton("로 그 인"));
		jpanel.add(signup=new JButton("회 원 가 입"));
		login.setBounds(600, 445, 140, 60);
		signup.setBounds(600, 505, 140, 30);
		
		
		 signup.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
						jf = new SignUpGUI(db, jframe);
					} catch (ClassNotFoundException | SQLException e1) {
				
						e1.printStackTrace();
					}
	                jframe.setVisible(false); // 창 안보이게 하기 
	            }
		 });
		 
		
		 login.addActionListener(new ActionListener() {
			//로그인버튼 이벤트
			 
			@Override
			public void actionPerformed(ActionEvent e) {
				 JButton b = (JButton)e.getSource();
				uid = idf.getText();
				String upw = "";
				for(int i = 0; i<pwf.getPassword().length; i++) {     
					upw = upw + pwf.getPassword()[i];
				}
				if(b.getText().equals("로 그 인")) {
					if(uid.equals("") || upw.equals("")) {
						JOptionPane.showMessageDialog(null, "아이디, 비밀번호 모두 입력","로그인 실패",JOptionPane.ERROR_MESSAGE);
						System.out.println("로그인 실패 > 로그인 정보 미입력");
					}else if(uid != null && upw != null) {
						try {
							if(db.checkId(uid, upw)) {   
								System.out.println("로그인 성공");
								JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.");
								JFrame jf = new HomePage(db);
								jframe.setVisible(false);	
							}else if(uid.equals("master") && upw.equals("master")){
								jframe.setVisible(false);
								try {
									new StudentManageGUI();
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}else {
								System.out.println("로그인 실패");
								JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
							}
						} catch (HeadlessException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				
				}

				
			}
			 
		 });
	
	}
}	
