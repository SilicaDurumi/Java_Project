package Functions;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class SearchFunction extends DefaultTableCellRenderer {
	
	public static void SearchData(JTable table, JTextField searchtext, int searchColumn) {
		 
		int count = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		for (int j = 0; j <model.getRowCount(); j++) 
			if (searchtext.toString().equals(model.getValueAt(j,searchColumn))) {
				count++;
//			    model.setForeground(Color.red); // Set Right Row Color Red
	}	

}
	
}































