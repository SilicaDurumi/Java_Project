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
	public static void OpenFile(JFrame frame, JTable table, Vector<String> title) {//use vector
		FileDialog openFile;
		openFile = new FileDialog(frame, "OPEN", FileDialog.LOAD);
	    openFile.setVisible(true); 
	    
	    String path = openFile.getDirectory()+ openFile.getFile();
	    try{
//	    	int count =0;
	    	String strforcount ="";
	    	String str = "";
	    	String[] userdataInput = new String[table.getColumnCount()];
	    	Vector<String> tempinput = new Vector<String>();
	        Vector<Vector<String>> userdata = new Vector<Vector<String>>();
	        DefaultTableModel model = (DefaultTableModel) table.getModel();	      
	        StringTokenizer stringTokenizer;
	        BufferedReader buffread, reader;
	        
//	        for (int i = 0; i < model.getRowCount(); i++) {
//		    	   for (int j = 0; j < model.getColumnCount(); j++)
//		    		   table.getModel().setValueAt(null, i, j);
//		    model.removeRow(i);
//	        }
	      
//	        reader = new BufferedReader(new FileReader(path));
//	        strforcount=reader.readLine();
//	        stringTokenizer = new StringTokenizer(strforcount);
//
//	        while (strforcount!=null) {
//	        	count++;
//	        	stringTokenizer.nextToken("\n");
//			}
	        						
	        		
//	        	reader.close();
	        
	        buffread = new BufferedReader(new FileReader(path));
	        
	        int j = 0;
	        while ((str=buffread.readLine())!= null) {
	        	stringTokenizer = new StringTokenizer(str);
	        		
	        		for (int i = 0; i < model.getColumnCount(); i++) {
						userdataInput[i]=stringTokenizer.nextToken(" ### ");
	        			tempinput.add(userdataInput[i]);}
	        		
	        		userdata.add(j, tempinput);
	        		stringTokenizer.nextToken("\n");
	        		if (j>model.getColumnCount()) 
						break;
	        		j++;
	        }
	        
	        System.out.println(userdata);
	       	model.setDataVector(userdata, title);
	        buffread.close();
	        String Filename = openFile.getFile();
	        frame.setTitle(Filename);
	       
	       } catch(Exception e1){System.out.println(e1.toString());}
	}
}














