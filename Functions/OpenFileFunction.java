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
	    	String[][] userdataInput;
	        BufferedReader buffread, reader;
	        Vector<String[][]> userdata = new Vector<String[][]>();
	        DefaultTableModel model = (DefaultTableModel) table.getModel();	      
	        StringTokenizer stringTokenizer;
	        
	        for (int i = 0; i < model.getRowCount(); i++) {
		    	   for (int j = 0; j < model.getColumnCount(); j++)
		    		   table.getModel().setValueAt(null, i, j);
		    model.removeRow(i);
	        }
	      
	        reader = new BufferedReader(new FileReader(path));
	        strforcount=reader.readLine();
	        stringTokenizer = new StringTokenizer(strforcount);

	        while (stringTokenizer.nextToken(" ### ")!=null) {
	        		if (stringTokenizer.hasMoreElements()==false) 
						break;
	        		count++;
				}
	        	reader.close();
	        
	        buffread = new BufferedReader(new FileReader(path));
	        
	        userdataInput = new String[model.getColumnCount()][count+1];
	        int j = 0;
	        while ((str=buffread.readLine())!= null) {
	        	stringTokenizer = new StringTokenizer(str);
	        		
	        		for (int i = 0; i <= count; i++) 
						userdataInput[j][i]= stringTokenizer.nextToken(" ### ");
	        		
	        		if (j>model.getColumnCount()) 
						break;
	        		
						userdata.add(j, userdataInput);
	        		
	        		stringTokenizer.nextToken("\n");
	        		j++;
	        }
			
	       	model.addRow(userdata);
	        buffread.close();
	        String Filename = openFile.getFile();
	        frame.setTitle(Filename);
	       } catch(Exception e1){System.out.println(e1.toString());}
	}
}














