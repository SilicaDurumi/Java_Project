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
	
	JTextField[] userdata = new JTextField[10];
	
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
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean FLAG = false;
		String[] userinfo = new String[10] ;
		
		for (int i = 0; i < userinfo.length-4; i++) 
			userinfo[i] = this.userdata[i].getText();
		
		for (int i = 0; i < userinfo.length-4; i++) {
			if (userinfo[i].length()==0) 			
				FLAG = true;
		}
		if (FLAG) {
			JOptionPane.showMessageDialog(null, "Please Write all information of the TextField", "Error", JOptionPane.ERROR_MESSAGE );
			return ;
		}
		if (ID_NumberCheckExcute.UserIdNumberCheck(this.userdata[4].getText())) {
			userinfo[6] = ID_NumberCheckExcute.CheckNumberReturnAge(userinfo[4]);
			userinfo[7] = ID_NumberCheckExcute.CheckNumberReturnGender(userinfo[4]);
			userinfo[8] = ID_NumberCheckExcute.CheckNumberReturnLocation(userinfo[4]);
			userinfo[9] = ID_NumberCheckExcute.CheckNumberReturnBirth(userinfo[4]);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(userinfo);
		
			for (int j = 0; j < userinfo.length-4; j++) 
				userdata[j].setText("");
<<<<<<< HEAD
			userdata[0].requestFocus();		
=======
				userdata[0].requestFocus();
				
>>>>>>> parent of 6b4cf4d... Functions Complete
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid IDNumber Please Write Again","Invalid IDNumer", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
}






















