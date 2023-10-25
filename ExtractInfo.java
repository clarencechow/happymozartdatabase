import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;


public class ExtractInfo extends JFrame {
	
	private JTable TA;
	private DefaultTableModel model;
	private DefaultTableCellRenderer cellRenderer;
	private JTextField sB;
	private JScrollPane SP;
	private String[] info = {"", ""};
	private Container c = getContentPane();
	private SpringLayout layout;
	private boolean order = true;
	private int lines;
	
	public ExtractInfo() {
		
		TA = new JTable();
		SP = new JScrollPane(TA);
		model = (DefaultTableModel)TA.getModel();
      	model.addColumn("Student");
      	model.addColumn("Parent");
      	model.addColumn("Email");
		
		layout = new SpringLayout();
		c.add(SP, BorderLayout.NORTH);
        TA.setFont( new Font( "Calibri", Font.PLAIN, 13 ));
    	TA.getColumnModel().getColumn(0).setPreferredWidth(30);
    	TA.getColumnModel().getColumn(1).setPreferredWidth(30);
    	TA.getColumnModel().getColumn(2).setPreferredWidth(30);
    	
    	sB = new JTextField();
    	sB.setSize(100, 50);
    	c.add(sB, BorderLayout.SOUTH);
    	sB.setEditable( false );
    	sB.setText("                                              Swtich to Order by Birthdays");
    	sB.setFont( new Font( "Times New Roman", Font.BOLD, 30));
    	sB.setBackground(Color.yellow);
    	
    	sB.addMouseListener(new MouseListener() {
	    	public void mouseClicked(MouseEvent mouseEvent) {
		    	setList(order);
	    	}
	    	public void mouseReleased(MouseEvent e) {}

		    public void mouseEntered(MouseEvent e) {}
		
		    public void mouseExited(MouseEvent e) {}
		    
		    public void mousePressed(MouseEvent e) {}
		
    	});

		
		setSize( 900, 500 );
		setResizable(false);
		
		
	}
	
	public void addInfo1(String s) {
		info[0] += s;
		lines++;
	}
	public void addInfo2(String s) {
		info[1] += s;
		lines++;
	}
	public void clearInfo() {
		info[0] = "";
		info[1] = "";
	}
	
	public void setList(boolean b) {
		order = !b;
		if(b) {
			for(int i = 0; i< lines; i++) {
				try {
					model.setValueAt("", i, 0);
					model.setValueAt("", i, 1);
					model.setValueAt("", i, 2);
				} catch(ArrayIndexOutOfBoundsException aioobe) {
					break;
				}
			}
			for(int i = 0; i < lines; i++) {
				try {
					model.addRow(new Object[0]);
	        		//model.setValueAt(i+1, i, 0);
			        model.setValueAt(info[0].substring(i*120, i*120+40), i, 0);
			        model.setValueAt(info[0].substring(i*120+40, i*120+80), i, 1);
			        model.setValueAt(info[0].substring(i*120+80, i*120+120), i, 2);
		        } catch(StringIndexOutOfBoundsException sioobe) {
			        
		        }
			}
			sB.setText("                                 Switch to Order by Birthdays");
		} else {
			//TA.setText(info[1]);
			for(int i = 0; i< lines; i++) {
				try {
					model.setValueAt("", i, 0);
					model.setValueAt("", i, 1);
					model.setValueAt("", i, 2);
				} catch(ArrayIndexOutOfBoundsException aioobe) {
					break;
				}
			}
			for(int i = 0; i < lines; i++) {
				try {
	        		//model.setValueAt(i+1, i, 0);
			        model.setValueAt(info[1].substring(i*120, i*120+40), i, 0);
			        model.setValueAt(info[1].substring(i*120+40, i*120+80), i, 1);
			        model.setValueAt(info[1].substring(i*120+80, i*120+120), i, 2);
		        } catch(StringIndexOutOfBoundsException sioobe) {
			        
		        }
			}
			sB.setText("                        Switch to Alphabetical Order by Last Name");
		}
	}
	
	
	
	
	public static void main( String args[] ) {
        ExtractInfo ei = new ExtractInfo();
		
        ei.addWindowListener(
            new WindowAdapter() {    		
                public void windowClosing( WindowEvent e ) {
                    System.exit(0);
	    		} 
        	}
		);
    }
	
}