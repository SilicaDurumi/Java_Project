package Functions;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MyTableCellRenderer extends DefaultTableCellRenderer {
		private final Vector<String> vectorrow;
		private final int selectedColumn;
	
		public MyTableCellRenderer(JTable table, String searchtext, int searchColumn) {
			Vector<String> row;
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			row = new Vector<String>();
			
			for (int j = 0; j <model.getRowCount(); j++) {
				System.out.println("Table Value : "+model.getValueAt(j,searchColumn).toString()
				+"\nSearchText : "+searchtext);
				if (model.getValueAt(j, searchColumn).toString().equals(searchtext)) 
					row.add(Integer.toString(j));
				}
			vectorrow = row;
			this.selectedColumn = searchColumn;
		}
		
		@Override
		 public Component getTableCellRendererComponent(JTable table, Object value, boolean 
		isSelected, boolean hasFocus, int row, int column) {

		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		for (int i = 0; i <table.getRowCount() ; i++) {
				if (row == Integer.parseInt(vectorrow.get(i))&& column == selectedColumn) 
					cell.setBackground(Color.blue);
		}
		
		return cell;
		}
}




























