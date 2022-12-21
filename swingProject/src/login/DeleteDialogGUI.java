package login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteDialogGUI extends JDialog implements ActionListener {

	static StudentManageGUI stuManageGUI;
	static JDBC db;
	DefaultTableModel model;

	private final JPanel contentPanel = new JPanel();

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

	public DeleteDialogGUI(StudentManageGUI stuManageGUI, JDBC db, DefaultTableModel model) {
		this.db = db;
		this.stuManageGUI = stuManageGUI;
		this.model = model;
		
		setTitle("삭제페이지");

		setBounds(300, 200, 450, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("정말 삭제하겠습니까?");
			lblNewLabel.setBounds(140, 30, 173, 19);
			lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("삭제하기");
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
			try {
				no = Integer.parseInt(stuManageGUI.no);
				name = stuManageGUI.name;
				id = stuManageGUI.id;
				password = stuManageGUI.password;
				phoneNumber = stuManageGUI.phoneNumber;
				birth = stuManageGUI.birth;
				nickName = stuManageGUI.nickName;
				courseName = stuManageGUI.courseName;
				
				int result = db.deleteDB(no, name, id, password, phoneNumber, birth, nickName, courseName);

				int row = stuManageGUI.table.getSelectedRow();
				int modelRow = stuManageGUI.table.convertRowIndexToModel(row);
				model = (DefaultTableModel) stuManageGUI.table.getModel();
				model.removeRow(modelRow);

				System.out.println("deleteData(), " + result);

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
