package Functions;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OpenFileFunction {
	public static void OpenFile(JFrame frame, JTable table) {//use vector
		FileDialog openFile;
		openFile = new FileDialog(frame, "OPEN", FileDialog.LOAD);
	    openFile.setVisible(true); 
	    
	    String path = openFile.getDirectory()+ openFile.getFile();
	    try{
	    	int count =0;
	    	String strforcount ="";
	    	String str = "";
	    	Vector<String> userdataInput = new Vector<String>();
	        BufferedReader buffread, reader;
	        Vector<Vector<String>> userdata = new Vector<Vector<String>>();
	        DefaultTableModel model = (DefaultTableModel) table.getModel();	      
	        StringTokenizer stringTokenizer;
	        
	        for (int i = 0; i < model.getRowCount(); i++) {
		    	   for (int j = 0; j < model.getColumnCount(); j++)
		    		   table.getModel().setValueAt(null, i, j);
		    model.removeRow(i);
	        }
	      
	        userdata.setSize(model.getColumnCount());
	        
	        reader = new BufferedReader(new FileReader(path));
	        while ((strforcount=reader.readLine())!= null) {
	        	stringTokenizer = new StringTokenizer(strforcount);
	        	if (stringTokenizer.nextToken("\n")!= null) {
					count++;
				}
	        }
	        reader.close();
	        
	        buffread = new BufferedReader(new FileReader(path));
	        
	        while ((str=buffread.readLine())!= null) {
	        	stringTokenizer = new StringTokenizer(str);
	        		if (userdataInput.isEmpty()) {
	        		userdataInput.setSize(model.getColumnCount());
	        		}
	        		for (int i = 0; i < model.getColumnCount(); i++) {
						userdataInput.set(i,stringTokenizer.nextToken(" ### "));
						userdata.set(i, userdataInput);
	        		}
	        		stringTokenizer.nextToken("\n");
	        }
			
	       	model.addRow(userdata);
	        buffread.close();
	        String Filename = openFile.getFile();
	        frame.setTitle(Filename);
	       } catch(Exception e1){System.out.println(e1.toString());}
	}
}














