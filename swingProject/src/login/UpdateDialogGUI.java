package login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JTextField;

public class UpdateDialogGUI extends JDialog implements ActionListener {

	static StudentManageGUI stuManageGUI;
	static JDBC db;

	private final JPanel contentPanel = new JPanel();
	private JTextField noTextField = new JTextField();
	private JTextField nameTextField = new JTextField();
	private JTextField idTextField = new JTextField();
	private JTextField passwordTextField = new JTextField();
	private JTextField phoneNumberTextField = new JTextField();
	private JTextField birthTextField = new JTextField();
	private JTextField nickNameTextField = new JTextField();
	private JTextField courseNameTextField = new JTextField();

	JButton okButton;
	JButton cancelButton;

	int no;
	String name;
	String id;
	String password;
	String phoneNumber;
	String birth;
	String nickName;
	String courseName;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
////					메인메서드의 프레임 위에 작성해야 테마적용됨
//					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//						if ("Nimbus".equals(info.getName())) { // Nimbus, Windows
//							UIManager.setLookAndFeel(info.getClassName());
//							break;
//						}
//					}
//					new UpdateDialogGUI(stuManageGUI, db);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public UpdateDialogGUI(StudentManageGUI stuManageGUI, JDBC db) throws ClassNotFoundException, SQLException {
		super(stuManageGUI, "수정페이지", ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.stuManageGUI = stuManageGUI;
		this.db = db;
		setBounds(100, 200, 800, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("수정페이지");
		contentPanel.setLayout(null);

//		번호패널
		JPanel noPanel = new JPanel();
		noPanel.setBounds(30, 50, 50, 60);
		contentPanel.add(noPanel);
		noPanel.setLayout(null);

		JLabel noLabel = new JLabel("no");
		noLabel.setBounds(18, 5, 24, 15);
		noPanel.add(noLabel);
		noTextField.setEditable(false);

		noTextField.setBounds(5, 25, 40, 30);
		noPanel.add(noTextField);
		noTextField.setColumns(10);
		noTextField.setText(stuManageGUI.no);

//		이름패널
		JPanel namePanel = new JPanel();
		namePanel.setBounds(85, 50, 80, 60);
		contentPanel.add(namePanel);
		namePanel.setLayout(null);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(30, 5, 36, 15);
		namePanel.add(nameLabel);

		nameTextField.setBounds(5, 25, 70, 30);
		namePanel.add(nameTextField);
		nameTextField.setColumns(10);
		nameTextField.setText(stuManageGUI.name);

//		아이디패널~
		JPanel idPanel = new JPanel();
		idPanel.setLayout(null);
		idPanel.setBounds(170, 50, 90, 60);
		contentPanel.add(idPanel);

		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(27, 5, 48, 15);
		idPanel.add(idLabel);

		idTextField.setColumns(10);
		idTextField.setBounds(5, 25, 80, 30);
		idPanel.add(idTextField);
		idTextField.setText(stuManageGUI.id);

//		비밀번호패널
		JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(null);
		passwordPanel.setBounds(265, 50, 100, 60);
		contentPanel.add(passwordPanel);

		JLabel passwordLabel = new JLabel("비밀번호");
		passwordLabel.setBounds(27, 5, 64, 15);
		passwordPanel.add(passwordLabel);

		passwordTextField.setColumns(10);
		passwordTextField.setBounds(5, 25, 90, 30);
		passwordPanel.add(passwordTextField);
		passwordTextField.setText(stuManageGUI.password);

//		전화번호패널
		JPanel phoneNumberPanel = new JPanel();
		phoneNumberPanel.setLayout(null);
		phoneNumberPanel.setBounds(370, 50, 120, 60);
		contentPanel.add(phoneNumberPanel);

		JLabel phoneNumberLabel = new JLabel("전화번호");
		phoneNumberLabel.setBounds(38, 5, 64, 15);
		phoneNumberPanel.add(phoneNumberLabel);

		phoneNumberTextField.setColumns(10);
		phoneNumberTextField.setBounds(5, 25, 110, 30);
		phoneNumberPanel.add(phoneNumberTextField);
		phoneNumberTextField.setText(stuManageGUI.phoneNumber);

//		생년월일패널
		JPanel birthPanel = new JPanel();
		birthPanel.setLayout(null);
		birthPanel.setBounds(495, 50, 85, 60);
		contentPanel.add(birthPanel);

		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setBounds(18, 5, 64, 15);
		birthPanel.add(birthLabel);

		birthTextField.setColumns(10);
		birthTextField.setBounds(5, 25, 75, 30);
		birthPanel.add(birthTextField);
		birthTextField.setText(stuManageGUI.birth);

//		닉네임패널
		JPanel nickNamePanel = new JPanel();
		nickNamePanel.setLayout(null);
		nickNamePanel.setBounds(585, 50, 90, 60);
		contentPanel.add(nickNamePanel);

		JLabel nickNameLabel = new JLabel("닉네임");
		nickNameLabel.setBounds(26, 5, 48, 15);
		nickNamePanel.add(nickNameLabel);

		nickNameTextField.setColumns(10);
		nickNameTextField.setBounds(5, 25, 80, 30);
		nickNamePanel.add(nickNameTextField);
		nickNameTextField.setText(stuManageGUI.nickName);

//		수강명패널
		JPanel courseNamePanel = new JPanel();
		courseNamePanel.setLayout(null);
		courseNamePanel.setBounds(680, 50, 85, 60);
		contentPanel.add(courseNamePanel);

		JLabel courseNameLabel = new JLabel("수강명");
		courseNameLabel.setBounds(25, 5, 48, 15);
		courseNamePanel.add(courseNameLabel);

		courseNameTextField.setColumns(10);
		courseNameTextField.setBounds(5, 25, 75, 30);
		courseNamePanel.add(courseNameTextField);
		courseNameTextField.setText(stuManageGUI.courseName);

		this.addWindowListener(new WindowAdapter() { // 윈도우가 실행되면 name에 포커스주기
			public void windowOpened(WindowEvent e) {
				nameTextField.requestFocus();
			}
		});

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("수정하기");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(this);
			}
			{
				cancelButton = new JButton("돌아가기");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
			}
		}
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == okButton) {

			no = Integer.parseInt(noTextField.getText());
			name = nameTextField.getText();
			id = idTextField.getText();
			password = passwordTextField.getText();
			phoneNumber = phoneNumberTextField.getText();
			birth = birthTextField.getText();
			nickName = nickNameTextField.getText();
			courseName = courseNameTextField.getText();

			try {
				int row = stuManageGUI.table.getSelectedRow();

				stuManageGUI.table.setValueAt(name, row, 1);
				stuManageGUI.table.setValueAt(id, row, 2);
				stuManageGUI.table.setValueAt(password, row, 3);
				stuManageGUI.table.setValueAt(phoneNumber, row, 4);
				stuManageGUI.table.setValueAt(birth, row, 5);
				stuManageGUI.table.setValueAt(nickName, row, 6);
				stuManageGUI.table.setValueAt(courseName, row, 7);

				int result = db.updateDB(no, name, id, password, phoneNumber, birth, nickName, courseName);

				System.out.println("updateDB, " + result);

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
		}

		if (e.getSource() == cancelButton) {
			dispose();
		}
	}
}
