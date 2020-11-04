package Functions;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class SearchFunction extends DefaultTableCellRenderer {
	
	public static void SearchData(JTable table, String searchtext, int searchColumn) {
		Vector<Integer> row;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		row = new Vector<Integer>();
		
		for (int j = 0; j <model.getRowCount(); j++) {
			System.out.println("Table Value : "+model.getValueAt(j,searchColumn).toString()
			+"\nSearchText : "+searchtext);
			if (model.getValueAt(j, searchColumn).toString().equals(searchtext)) 
				row.add(j);
			}
		
		TableCellRenderer renderer = new MyTableCellRenderer(row, searchColumn);
		try {table.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);} 		
		catch (ClassNotFoundException e1) {e1.printStackTrace();}
		
	}	
}































