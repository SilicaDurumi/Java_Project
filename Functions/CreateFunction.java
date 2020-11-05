package Functions;


import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CreateFunction{
	
	public static void CreateFunction(JTable table, JTextField number, JTextField name, JTextField tel , JTextField email, JTextField idNumber, JTextField Job) {
		
		JTextField[] userdata = new JTextField[10];
		userdata[0] = number;
		userdata[1] = name;
		userdata[2] = tel;
		userdata[3] = email;
		userdata[4] = idNumber;
		userdata[5] = Job;

		boolean FLAG = false;// FLAG for user input all TextField
		String[] userinfo = new String[10] ;
		
		for (int i = 0; i < userinfo.length-4; i++) 
			userinfo[i] = userdata[i].getText();
		
		for (int i = 0; i < userinfo.length-4; i++) {
			if (userinfo[i].length()==0) 			
				FLAG = true;
		}
		if (FLAG) {
			JOptionPane.showMessageDialog(null, "Please Write all information of the INPUT Field", "Error", JOptionPane.ERROR_MESSAGE );
			return ;
		}
		if (ID_NumberCheckExcute.UserIdNumberCheck(userdata[4].getText())) {
			try {
				userinfo[6] = ID_NumberCheckExcute.CheckNumberReturnAge(userinfo[4]);
				userinfo[7] = ID_NumberCheckExcute.CheckNumberReturnGender(userinfo[4]);
				userinfo[8] = ID_NumberCheckExcute.CheckNumberReturnLocation(userinfo[4]);
				userinfo[9] = ID_NumberCheckExcute.CheckNumberReturnBirth(userinfo[4]);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(userinfo);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please Write Valid Number", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		
			for (int j = 0; j < userinfo.length-4; j++) 
				userdata[j].setText("");
				userdata[0].requestFocus();
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid IDNumber Value Please Write Again","Invalid IDNumer", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

}






















