import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
import javax.swing.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.TableColumn;
import java.io.*;

    


/**
 * 
 * 
 * @author 
 * @version 
 */
public class updateSystem extends JFrame{

    private JTable table;
    private JScrollPane scroller;
    private JPanel buttonPanel;
    private JPanel radioButtonPanel;
    private JPanel searchPanel, radioPanel1, radioPanel2, radioPanel3, searchListPanel;
    private JButton buttons[];
    private JButton search;
    private JLabel label, label2; 
    private String birthdayYears[] = { "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", 
    									"1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
    									"2010", "2011", "2012", "2013", "2014", "2015" };
    private String dateMonths[] = { "", "January", "Febuary", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December" };
    private String dateDays[] = { "0", " 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", "11", "12", "13", "14", "15", "16",
        "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    private String dateYears[] = { "2008", "2009", "2010", "2011", "2012" };
    private String buttonNames[] = { "Add Student", "Class Tracker", "View/Edit Record", "Delete Student", "Exit" };
    private JRadioButton radioButtons[];
    private String radioButtonNames[] = { "Last Name", "First Name", "Birthday Month", "Class Type", "Instructor", "Payment Alert", "Update Class Info" , "Class Day", 
    	"Incomp. Payment Alert Info"};
    private String comboBoxNames[] = { " Phone Number ", " Student's 1st Name ", " Parent's 1st Name ", " Last Name ", " Class Day ", "School Earnings"};
    String[] columnNames = {"Child's Name", "Parent's Name", "Class Type", "Class End",
            "Registered", "Telephone#", " Birthday ", " Class Day - Period", "Teacher's Name", "Invoice"};
    private String classDays[] = { "", "  Monday  ", "  Tuesday  ", "  Wednesday  ", "  Thursday  ", "  Friday  ", "  Saturday  ",
        "  Sunday  ", "Mon & Wedn", "Tues & Thurs", "Wedn & Fri", "Thurs & Sat" };
    private JComboBox comboBox;
    //private Container c;
    private GridBagLayout gbLayout;
    private GridBagConstraints gbConstraints;
    //private JLabel label;
    private StudentRecord sr;
    private StudentInfoPage sip;
    private RandomAccessFile output, trackerFile;
    private ClassTracker ct;
    private JTextField textField;
    //private RadioButtonHandler handler;
    private ButtonGroup radioGroup;
    private int todayMonth, todayYear, todayDay;
    private int[] listedRecord;
    private Icon viewStudentIcon, addStudentIcon, deleteStudentIcon, closeIcon, classTrackerIcon, searchIcon;
    //private Dimension dimension;

    public updateSystem()
    {
        super( "Happy Mozart" );
System.out.println("hello world" );
        //c = getContentPane();
        //gbLayout = new GridBagLayout();
        //gbConstraints = new GridBagConstraints();
        //c.setLayout( gbLayout );
        buttons = new JButton[5];             
        radioButtons = new JRadioButton[9];
        //JScrollPane scroller;
        comboBox = new JComboBox( comboBoxNames );
        buttonPanel = new JPanel();
        radioButtonPanel = new JPanel();
        searchPanel = new JPanel();
        radioPanel1 = new JPanel();
        radioPanel2 = new JPanel();
        radioPanel3 = new JPanel();
        searchListPanel = new JPanel();
        //sr = new StudentRecord();
        //sip = new StudentInfoPage();
        //ct = new ClassTracker();
        //ct.s = this;
        //sip.setSchool( this );
        //sip.setVisible( false );
        textField = new JTextField( 10 );
        label = new JLabel("                     LIST BY:  ");
        label2 = new JLabel( "       LIST:                        " );
        //getDateTime();
        //dimension = new Dimension( 1000, 530 );
        viewStudentIcon = new ImageIcon( "view_student_icon.jpg" );
        closeIcon = new ImageIcon( "exit_icon.jpg" );
        addStudentIcon = new ImageIcon( "add_student_icon.jpg" );
        deleteStudentIcon = new ImageIcon( "delete_student_icon.jpg" );
        classTrackerIcon = new ImageIcon( "class_tracker_icon.jpg" );
        searchIcon = new ImageIcon( "search_icon.jpg" );

        
        buttonPanel.setLayout( new GridLayout( 1, buttons.length ) );
        
        search = new JButton( "   Search   ", searchIcon );
        buttons[0] = new JButton( buttonNames[0], addStudentIcon );
        buttons[1] = new JButton( buttonNames[1], classTrackerIcon );
        buttons[2] = new JButton( buttonNames[2], viewStudentIcon );
        buttons[3] = new JButton( buttonNames[3], deleteStudentIcon );
        buttons[4] = new JButton( buttonNames[4], closeIcon );
        for( int i = 0; i < buttons.length; i++) {
        	
            //buttons[i] = new JButton( buttonNames[i] );
            buttonPanel.add( buttons[i] );
        }

        
		openFile();
		StudentRecord temp = new StudentRecord();
		try {
			output.seek(0);
			//output.writeInt( 0 );
			//output.seek(0);
			//System.out.println( "hello" );
			int count = output.readInt();
			for( int i = 0; i < count; i++ ) {
System.out.println( "File PT: " + output.getFilePointer() );
				output.seek( i * temp.size() + 10 );
        		temp.OldRead( output );
        		output.seek( i * temp.size() + 10 );
        		temp.write( output );
        		temp.resetAllFields();
			}
			closeFile();
		}
		catch ( IOException ex ) {
            JOptionPane.showMessageDialog(this, "IOException", "Error", 
                                          JOptionPane.ERROR_MESSAGE );
        }
        catch( NumberFormatException nfe ){
        	JOptionPane.showMessageDialog(this, "NumberFormatException", "Error", 
                                          JOptionPane.ERROR_MESSAGE );
        }
		
       
    }
    
    
    
    private void openFile() {
        try {
            output = new RandomAccessFile( "SchoolData.txt", "rw" );
        } catch ( IOException e ) {
            JOptionPane.showMessageDialog(this, "File does not exist", "Invalid File Name", 
                                          JOptionPane.ERROR_MESSAGE );
        }
    }

    
    private void closeFile() {
        try {
            output.close();
            System.exit( 0 );
        } catch ( IOException ex ) {
            JOptionPane.showMessageDialog(this, "Error closing file", "Error", 
                                          JOptionPane.ERROR_MESSAGE );
            System.exit( 1 );
        }
    }
    
    public static void main( String args[] )
    {
    System.out.println( "Starting" );
        new updateSystem();
	System.out.println( "After new School" );
	/*
        a.addWindowListener(
            new WindowAdapter() {
                public void WindowClosing( WindowEvent e )
                {
                	System.out.println( "System closing" );
                    System.exit(0);
                }
            }
        );
        */
    }
    

}
