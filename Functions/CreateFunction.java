package Functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CreateFunction implements ActionListener{
	JTable table;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	JTextField[] txt = new JTextField[10];
	
	public CreateFunction(JTable table, JTextField text1, JTextField text2, JTextField text3 , JTextField text4, JTextField text5, JTextField text6) {
		this.table = table;
		this.txt[0] = text1;
		this.txt[1] = text2;
		this.txt[2] = text3;
		this.txt[3] = text4;
		this.txt[4] = text5;
		this.txt[5] = text6;
=======
	JTextField[] userdata = new JTextField[10];
	
=======
	JTextField[] userdata = new JTextField[10];
	
>>>>>>> parent of 6b4cf4d... Functions Complete
=======
	JTextField[] userdata = new JTextField[10];
	
>>>>>>> parent of 6b4cf4d... Functions Complete
	public CreateFunction(JTable table, JTextField number, JTextField name, JTextField tel , JTextField email, JTextField idNumber, JTextField Job) {
		this.table = table;
		userdata[0] = number;
		userdata[1] = name;
		userdata[2] = tel;
		userdata[3] = email;
		userdata[4] = idNumber;
		userdata[5] = Job;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 6b4cf4d... Functions Complete
=======
>>>>>>> parent of 6b4cf4d... Functions Complete
=======
>>>>>>> parent of 6b4cf4d... Functions Complete
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean FLAG = false;
		String[] userinfo = new String[10] ;
		
		for (int i = 0; i < userinfo.length-4; i++) 
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
			userinfo[i] = this.txt[i].getText();
=======
			userinfo[i] = this.userdata[i].getText();
>>>>>>> parent of 6b4cf4d... Functions Complete
=======
			userinfo[i] = this.userdata[i].getText();
>>>>>>> parent of 6b4cf4d... Functions Complete
=======
			userinfo[i] = this.userdata[i].getText();
>>>>>>> parent of 6b4cf4d... Functions Complete
		
		for (int i = 0; i < userinfo.length-4; i++) {
			if (userinfo[i].length()==0) 			
				FLAG = true;
		}
		if (FLAG) {
			JOptionPane.showMessageDialog(null, "Please Write all information of the TextField", "Error", JOptionPane.ERROR_MESSAGE );
			return ;
		}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		if (ID_NumberCheckExcute.UserIdNumberCheck(this.txt[4].getText())) {
=======
		if (ID_NumberCheckExcute.UserIdNumberCheck(this.userdata[4].getText())) {
>>>>>>> parent of 6b4cf4d... Functions Complete
=======
		if (ID_NumberCheckExcute.UserIdNumberCheck(this.userdata[4].getText())) {
>>>>>>> parent of 6b4cf4d... Functions Complete
=======
		if (ID_NumberCheckExcute.UserIdNumberCheck(this.userdata[4].getText())) {
>>>>>>> parent of 6b4cf4d... Functions Complete
			userinfo[6] = ID_NumberCheckExcute.CheckNumberReturnAge(userinfo[4]);
			userinfo[7] = ID_NumberCheckExcute.CheckNumberReturnGender(userinfo[4]);
			userinfo[8] = ID_NumberCheckExcute.CheckNumberReturnLocation(userinfo[4]);
			userinfo[9] = ID_NumberCheckExcute.CheckNumberReturnBirth(userinfo[4]);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(userinfo);
		
			for (int j = 0; j < userinfo.length-4; j++) 
<<<<<<< HEAD
				txt[j].setText("");
				txt[0].requestFocus();
=======
				userdata[j].setText("");
				userdata[0].requestFocus();
				
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 6b4cf4d... Functions Complete
=======
>>>>>>> parent of 6b4cf4d... Functions Complete
=======
>>>>>>> parent of 6b4cf4d... Functions Complete
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid IDNumber Please Write Again","Invalid IDNumer", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
}






















