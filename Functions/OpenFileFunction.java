package Functions;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

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
	    	int count =0;
	    	String strforcount ="";
	    	String str = "";
	    	Object[][] userdataInput ;
	        BufferedReader buffread, reader;
	        DefaultTableModel model = (DefaultTableModel) table.getModel();	      
	        StringTokenizer stringTokenizer, tokenizer;
	        
	        for (int i = 0; i < model.getRowCount(); i++)
	        	model.removeRow(i);
	      
	        reader = new BufferedReader(new FileReader(path));

	        while ((strforcount = reader.readLine())!=null) {
	        	tokenizer = new StringTokenizer(strforcount);
	        	count++;
	        	tokenizer.nextToken("\n");
			}
        	reader.close();
	        
        	
	        buffread = new BufferedReader(new FileReader(path));
	        userdataInput = new Object[count][model.getColumnCount()];
	        int j = 0;
	        while ((str=buffread.readLine())!= null) {
	        	stringTokenizer = new StringTokenizer(str);
	        		for (int i = 0; i < model.getColumnCount(); i++) 
						userdataInput[j][i]= stringTokenizer.nextToken(" ### ");
	        		stringTokenizer.nextToken("\n");
	        		 model.addRow(userdataInput[j]);
	        		if (j>count) 
						break;
	        		j++;
	        }
	        buffread.close();
	        String Filename = openFile.getFile();
	        frame.setTitle(Filename);
	       
	       } catch(Exception e1){System.out.println(e1.toString());}
	}
}














