import java.awt.image.BufferedImage;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class WithdrawPage extends JFrame {
	private RandomAccessFile output;
	private JPanel panels[];
	private JButton buttons[];
	private JLabel labels[];
	private JTextField textFields[], idTextField;
	private String classNames[] = { " Music Together ", "Music 4 Young Children", " Private Lesson ", "  Semi-Private Lesson  " };
	private String dateMonths[] = { "", "January", "Febuary", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December" };
    private String dateDays[] = { "", " 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", "11", "12", "13", "14", "15", "16",
        "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    private String numberToData[] = { "", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
        "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    private String yearToData[] = { "", "91", "92", "93", "94", "95", "96", "97", "98", "99", "00", "01", "02", "03", "04", "05", "06", 
    								"07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18" };
    private String dateYears[] = { "", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" };
    private String birthdayYears[] = { "", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", 
    									"1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
    									"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018" };
    private JComboBox birthdayMonthComboBox, birthdayDayComboBox, birthdayYearComboBox;
    private JComboBox lastdayMonthComboBox, lastdayDayComboBox, lastdayYearComboBox;
	private String comboBoxNames[] = { "     Music Together     ", "Music 4 Young Children", "     Private Lesson     " };
    private String classDays[] = { "", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
        "Sunday", };
    private String timeHours[] = { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    private String timeMins[] = { "00", "15", "30", "45" };
    private String timeAMPM[] = { "AM", "PM" };
	private String labelNames[] = { "Withdraw filing date", "Last lesson date", "Reason for withdraw(50 letters max)" }; 

    private String buttonNames[] = { "Add Class", "Class Information", "Delete Class", "Save Info", "Close w/o Save", "View Credit Card#" };
    private String teacherNames = "";
    //private ClassInfoPage cip;
    public StudentRecord sr;
    public NewClassTracker nct;
    //private school s;
    private HomePage hp;
    public int newOrOld, teacherOrStudent;
    private Icon viewClassIcon, saveIcon, closeIcon, newStudentTopIcon, happyMozartIcon, clearAllIcon;
    private JLabel WithdrawTopLabel, HappyMozartLabel, pictureLabel;
    private Graphics g;
    private MyTextField tf;
    private JButton loadPixButton, deleteButton;
    private JButton clearButton1, clearButton2, todayDateButton1, todayDateButton2;
    public int studentOrTeacher, todayMonth, todayYear, todayDay, recordNumber;
        
    public WithdrawPage() {
		super( "Withdraw Information" );
		//cip = new ClassInfoPage();
		sr = new StudentRecord();
		Container c = getContentPane();
		panels = new JPanel[19];
		buttons = new JButton[5];
		labels = new JLabel[labelNames.length];
		textFields = new JTextField[23];
		birthdayMonthComboBox = new JComboBox( dateMonths );
		birthdayDayComboBox = new JComboBox( dateDays );
		birthdayYearComboBox = new JComboBox( dateYears );
		lastdayMonthComboBox = new JComboBox( dateMonths );
		lastdayDayComboBox = new JComboBox( dateDays );
		lastdayYearComboBox = new JComboBox( dateYears );
		closeIcon = new ImageIcon( "cancel_icon.jpg" );
        saveIcon = new ImageIcon( "new_save_icon.jpg" );
        clearAllIcon = new ImageIcon( "clear_all_icon.jpg" );
        viewClassIcon = new ImageIcon( "view_class_icon.jpg" );
        newStudentTopIcon = new ImageIcon( "new_student_top_icon.jpg" );
        WithdrawTopLabel = new JLabel( new ImageIcon( "withdraw_top_icon.jpg" ) );
        HappyMozartLabel = new JLabel( new ImageIcon( "happy_mozart_icon2.jpg" ) );
        tf = new MyTextField( 50, 50 );
        loadPixButton = new JButton( new ImageIcon( "load_pix_icon.jpg" ) );
        idTextField = new JTextField();
        studentOrTeacher = 1;
        deleteButton = new JButton( new ImageIcon( "delete_record_icon.jpg" ) );
        clearButton1 = new JButton( new ImageIcon( "small_clear_all_icon.jpg" ) );
        clearButton2 = new JButton( new ImageIcon( "small_clear_all_icon.jpg" ) );
        todayDateButton1 = new JButton( new ImageIcon( "today_date_icon.jpg" ) );
        todayDateButton2 = new JButton( new ImageIcon( "today_date_icon.jpg" ) );
        JPanel classPanel = new JPanel();
		JPanel parentPanel = new JPanel();
		todayMonth = todayYear = todayDay = recordNumber = 0;
		getDateTime();
        
        ImageIcon ii = new ImageIcon( "pictures\\" + "load_pix_icon2.jpg" );
        BufferedImage bi = new BufferedImage(110, 125, BufferedImage.TYPE_INT_ARGB);
		bi.getGraphics().drawImage(ii.getImage(), 0, 0, 110, 125, null);
		pictureLabel = new JLabel( new ImageIcon( bi ));
		
		/*
		try {
			createTrackerFileCurrentStudent();
		}
		catch( IOException ioe ) {
			System.out.println("I should be deleted" );
		}
        */
		
		//for( int i = 0; i < buttons.length; i++ ) {
        // /  	buttons[i] = new JButton( buttonNames[i] );
		//}
		buttons[0] = new JButton( buttonNames[0] );
		buttons[2] = new JButton( clearAllIcon );
		buttons[1] = new JButton( buttonNames[1], viewClassIcon );
		buttons[3] = new JButton( saveIcon );
		buttons[4] = new JButton( closeIcon ); 
		addWindowListener(
			new WindowAdapter() {
				public void windowClosing( WindowEvent e ) {
					setVisible( false );
					
					nct.setVisible( true );
				} 
			}
		);
		
		clearButton1.addActionListener(				
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	birthdayMonthComboBox.setSelectedIndex( 0 );
					birthdayDayComboBox.setSelectedIndex( 0 );
					birthdayYearComboBox.setSelectedIndex( 0 );
                           
                }
            }
        );
        
        clearButton2.addActionListener(				
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
					lastdayMonthComboBox.setSelectedIndex( 0 );          
					lastdayDayComboBox.setSelectedIndex( 0 );                   
					lastdayYearComboBox.setSelectedIndex( 0 );                                    
                }
            }
        );
        
        todayDateButton1.addActionListener(				
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	birthdayMonthComboBox.setSelectedIndex( todayMonth );
                	birthdayDayComboBox.setSelectedIndex( todayDay );
					birthdayYearComboBox.setSelectedIndex( getYear() );
                           
                }
            }
        );
        
        todayDateButton2.addActionListener(				
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
					lastdayMonthComboBox.setSelectedIndex( todayMonth );
                	lastdayDayComboBox.setSelectedIndex( todayDay );
					lastdayYearComboBox.setSelectedIndex( getYear() );                           
                }
            }
        );
        
        buttons[3].addActionListener(				// Save Info Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                    try {
                    	saveWithdrawInfo();
                    	System.out.println( "SAVED WITHDRAW INFO" );
                    	
                   	}
                   	catch( IOException ioe ) {
                   		JOptionPane.showMessageDialog( null, "Error At WithdrawPage.saveWthdrawInfo", 
    						"Error Thrown", JOptionPane.ERROR_MESSAGE );
                   	}
                    
                }
            }
        );
        
        buttons[4].addActionListener(				// Save Info Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                    	setVisible( false );
                    	nct.setVisible( true );
                    	clearAllFields();
                }
            }
        );
		
/*		
		loadPixButton.addActionListener(				// Save Info Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	File file;
                	String str = "C:\\j2sdk1.4.2_16\\bin\\pictures";
                	JFileChooser fileChooser = new JFileChooser( str );
					fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
                	int result = fileChooser.showOpenDialog( null );
                	if( result == JFileChooser.CANCEL_OPTION ) 
                		return;
                	else
                		file = fileChooser.getSelectedFile();
                		
                	System.out.println( file.getName() );
                	
                	ImageIcon aa = new ImageIcon( "pictures\\" + file.getName() );
        			BufferedImage ba = new BufferedImage(110, 125, BufferedImage.TYPE_INT_ARGB);
					ba.getGraphics().drawImage(aa.getImage(), 0, 0, 110, 125, null);
					pictureLabel.setIcon( new ImageIcon( ba ));
					sr.setPictureName( file.getName() );
					
                }
            }
        );
        
		
        
        buttons[4].addActionListener(				
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	if( newOrOld == -1 ) {
                		int n = 0;
                		if( changesMade() == true ) {
    						n = JOptionPane.showConfirmDialog( null, "Changes Have Been Made.  Exit w/o Saving Changes?", "Exit Confirmation",
    							JOptionPane.YES_NO_OPTION);
    					}
    					
    			    	if( n == 0 ) {
                    		clearFields();
                    		setVisible( false ); 
                    		hp.setEnabled( true );
                    		hp.setVisible( true );
                    		//s.setVisible( true );
                    	}       
                    }
                    else {
                    	clearFields();
                    	setVisible( false );
                    	nct.setEnabled( true );
                    	nct.setVisible( true );
                    }
                }
            }
        );
        
        buttons[2].addActionListener(				
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                
                    	clearFields();
                           
                }
            }
        );
        
        
        
        birthdayMonthComboBox.addItemListener( 
        	new ItemListener() {
        		public void itemStateChanged( ItemEvent e ) {
        			if( newOrOld == -1 )
        				createID();
        			else if( newOrOld != -1 && sr.getBirthdayMonth() != birthdayMonthComboBox.getSelectedIndex() )
        				createID();
        		}
        	}
        );
        birthdayDayComboBox.addItemListener( 
        	new ItemListener() {
        		public void itemStateChanged( ItemEvent e ) {
        			if( newOrOld == -1 )
        				createID();
        			else if( newOrOld != -1 && sr.getBirthdayDay() != birthdayDayComboBox.getSelectedIndex() )
        				createID();
        		}
        	}
        );
        birthdayYearComboBox.addItemListener( 
        	new ItemListener() {
        		public void itemStateChanged( ItemEvent e ) {
        			if( newOrOld == -1 )
        				createID();
        			else if( newOrOld != -1 && sr.getBirthdayYear() != birthdayYearComboBox.getSelectedIndex() )
        				createID();
        		}
        	}
        );
        
        
        
*/
        
        for( int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
        }
		
		for( int i = 0; i < labels.length; i++ ) {
			labels[i] = new JLabel( labelNames[i] );				
        }
/*
        textFields[0] = new JTextField( 13 );   // first name text field
        textFields[1] = new JTextField( 14 );   // last name text field
        textFields[2] = new JTextField( 27 );   // address text field
        textFields[3] = new JTextField( 13 );   // city text field
        textFields[4] = new JTextField( 9 );   // zip code text field
        textFields[5] = new JTextField( 3 );    // phone number text field 1
        textFields[6] = new JTextField( 3 );    // phone number text field 2
        textFields[7] = new JTextField( 4 );    // phone number text field 3
        textFields[8] = new JTextField( 23 );   // e-mail text field
        textFields[9] = new JTextField( 20 );   // father's name text field
        textFields[10] = new JTextField( 10 );  // mother's name text field
        textFields[11] = new JTextField( 20 );  // parent's e-mail text field
        textFields[12] = new JTextField( 3 );  // student cell phone 1
        textFields[13] = new JTextField( 3 );   // student cell phone 2
        textFields[14] = new JTextField( 4 );   // student cell phone 3
        textFields[15] = new JTextField( 32 );   // comment text field
        textFields[16] = new JTextField( 3 );	// parent cell phone number text field 1
        textFields[17] = new JTextField( 3 );	// parent cell phone number text field 2
        textFields[18] = new JTextField( 4 );	// parent cell phone number text field 3
        textFields[19] = new JTextField( 13 );	// instrument
        textFields[20] = new JTextField( 16 );	// teacher's name
        textFields[21] = new JTextField( 5 );	// class duration
        textFields[22] = new JTextField( 5 );	// secord class duration
    	textFields[5].setText( "650" );
    	textFields[4].setText( "94402" );
                
        for( int i = 0; i < 23; i++ ) {
           	textFields[i].setText("");
        }
*/
		SpringLayout layout = new SpringLayout();
		JPanel p = new JPanel(layout);
		
		Font f = new Font( "", Font.BOLD, 11 );
		for( int i = 0; i < labels.length; i++ ) {
			labels[i].setFont( f );
		}
		/*
		for( int i = 0; i < 23; i++ ) {
			textFields[i].setFont( f );
			textFields[i].setBackground( Color.LIGHT_GRAY );
		}
		*/
		tf.setFont( f );
		tf.setBackground( Color.LIGHT_GRAY );
		
		
		p.add( WithdrawTopLabel );
		layout.putConstraint(SpringLayout.WEST, WithdrawTopLabel, 0, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, WithdrawTopLabel, 0, SpringLayout.NORTH, p);
		
		p.add( HappyMozartLabel );
		layout.putConstraint(SpringLayout.WEST, HappyMozartLabel, 20, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, HappyMozartLabel, 20, SpringLayout.SOUTH, WithdrawTopLabel);
		
		p.add( pictureLabel );
		layout.putConstraint(SpringLayout.WEST, pictureLabel, 200, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, pictureLabel, 10, SpringLayout.NORTH, HappyMozartLabel);
/*		
		p.add( loadPixButton );
		loadPixButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		layout.putConstraint(SpringLayout.WEST, loadPixButton, 30, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, loadPixButton, 5, SpringLayout.SOUTH, pictureLabel);
*/		
		p.add( idTextField );
		idTextField.setFont( f );
		idTextField.setPreferredSize( new Dimension( 100, 16 ) );
		idTextField.setBackground( Color.WHITE );
    	idTextField.setForeground( Color.RED );
    	idTextField.setEditable( false );
    	idTextField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		layout.putConstraint(SpringLayout.WEST, idTextField, 0, SpringLayout.WEST, pictureLabel);
		layout.putConstraint(SpringLayout.SOUTH, idTextField, -1, SpringLayout.NORTH, pictureLabel);
/*		
		p.add( labels[0] );
		p.add( labels[1] );
		p.add( labels[6] );
		layout.putConstraint(SpringLayout.WEST, labels[0], 130, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, labels[0], 4, SpringLayout.SOUTH, HappyMozartLabel);
		layout.putConstraint(SpringLayout.WEST, labels[1], 65, SpringLayout.EAST, labels[0]);
		layout.putConstraint(SpringLayout.NORTH, labels[1], 4, SpringLayout.SOUTH, HappyMozartLabel);
		layout.putConstraint(SpringLayout.WEST, labels[6], 75, SpringLayout.EAST, labels[1]);
		layout.putConstraint(SpringLayout.NORTH, labels[6], 4, SpringLayout.SOUTH, HappyMozartLabel);
		
		p.add( textFields[0] );
		p.add( textFields[1] );
		layout.putConstraint(SpringLayout.WEST, textFields[0], 130, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, textFields[0], 1, SpringLayout.SOUTH, labels[0] );
		layout.putConstraint(SpringLayout.WEST, textFields[1], 65, SpringLayout.EAST, labels[0]);
		layout.putConstraint(SpringLayout.NORTH, textFields[1], 1, SpringLayout.SOUTH, labels[0]);
*/		
		p.add( labels[0] );
		layout.putConstraint(SpringLayout.WEST, labels[0], 10, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, labels[0], 30, SpringLayout.SOUTH, pictureLabel);		

		p.add( birthdayMonthComboBox );
		p.add( birthdayDayComboBox );
		p.add( birthdayYearComboBox );
		birthdayMonthComboBox.setFont( f );
		birthdayDayComboBox.setFont( f );
		birthdayYearComboBox.setFont( f );
		birthdayMonthComboBox.setPreferredSize( new Dimension( 90, 18 ) );
		birthdayDayComboBox.setPreferredSize( new Dimension( 43, 18 ) );
		birthdayYearComboBox.setPreferredSize( new Dimension( 60, 18 ) );
		birthdayMonthComboBox.setBackground( Color.LIGHT_GRAY );
		birthdayDayComboBox.setBackground( Color.LIGHT_GRAY );
		birthdayYearComboBox.setBackground( Color.LIGHT_GRAY );
		layout.putConstraint(SpringLayout.WEST, birthdayMonthComboBox, 0, SpringLayout.WEST, labels[0]);
		layout.putConstraint(SpringLayout.NORTH, birthdayMonthComboBox, 3, SpringLayout.SOUTH, labels[0]);
		layout.putConstraint(SpringLayout.WEST, birthdayDayComboBox, 4, SpringLayout.EAST, birthdayMonthComboBox);
		layout.putConstraint(SpringLayout.NORTH, birthdayDayComboBox, 3, SpringLayout.SOUTH, labels[0]);
		layout.putConstraint(SpringLayout.WEST, birthdayYearComboBox, 4, SpringLayout.EAST, birthdayDayComboBox);
		layout.putConstraint(SpringLayout.NORTH, birthdayYearComboBox, 3, SpringLayout.SOUTH, labels[0]);
		
		p.add( clearButton1 );
		p.add( todayDateButton1 );
		clearButton1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		layout.putConstraint(SpringLayout.WEST, clearButton1, 0, SpringLayout.WEST, birthdayMonthComboBox);
		layout.putConstraint(SpringLayout.NORTH, clearButton1, 5, SpringLayout.SOUTH, birthdayMonthComboBox );
		todayDateButton1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		layout.putConstraint(SpringLayout.WEST, todayDateButton1, 10, SpringLayout.EAST, clearButton1);
		layout.putConstraint(SpringLayout.NORTH, todayDateButton1, 0, SpringLayout.NORTH, clearButton1 );
		
		
		p.add( labels[1] );
		layout.putConstraint(SpringLayout.WEST, labels[1], 250, SpringLayout.WEST, labels[0]);
		layout.putConstraint(SpringLayout.NORTH, labels[1], 0, SpringLayout.NORTH, labels[0]);		

		p.add( lastdayMonthComboBox );
		p.add( lastdayDayComboBox );
		p.add( lastdayYearComboBox );
		lastdayMonthComboBox.setFont( f );
		lastdayDayComboBox.setFont( f );
		lastdayYearComboBox.setFont( f );
		lastdayMonthComboBox.setPreferredSize( new Dimension( 90, 18 ) );
		lastdayDayComboBox.setPreferredSize( new Dimension( 43, 18 ) );
		lastdayYearComboBox.setPreferredSize( new Dimension( 60, 18 ) );
		lastdayMonthComboBox.setBackground( Color.LIGHT_GRAY );
		lastdayDayComboBox.setBackground( Color.LIGHT_GRAY );
		lastdayYearComboBox.setBackground( Color.LIGHT_GRAY );
		layout.putConstraint(SpringLayout.WEST, lastdayMonthComboBox, 0, SpringLayout.WEST, labels[1]);
		layout.putConstraint(SpringLayout.NORTH, lastdayMonthComboBox, 3, SpringLayout.SOUTH, labels[1]);
		layout.putConstraint(SpringLayout.WEST, lastdayDayComboBox, 4, SpringLayout.EAST, lastdayMonthComboBox);
		layout.putConstraint(SpringLayout.NORTH, lastdayDayComboBox, 3, SpringLayout.SOUTH, labels[1]);
		layout.putConstraint(SpringLayout.WEST, lastdayYearComboBox, 4, SpringLayout.EAST, lastdayDayComboBox);
		layout.putConstraint(SpringLayout.NORTH, lastdayYearComboBox, 3, SpringLayout.SOUTH, labels[1]);
		
		p.add( clearButton2 );
		p.add( todayDateButton2 );
		clearButton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		layout.putConstraint(SpringLayout.WEST, clearButton2, 0, SpringLayout.WEST, lastdayMonthComboBox);
		layout.putConstraint(SpringLayout.NORTH, clearButton2, 5, SpringLayout.SOUTH, lastdayMonthComboBox );
		todayDateButton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		layout.putConstraint(SpringLayout.WEST, todayDateButton2, 10, SpringLayout.EAST, clearButton2);
		layout.putConstraint(SpringLayout.NORTH, todayDateButton2, 0, SpringLayout.NORTH, clearButton2 );
		
		p.add( labels[2] );
		p.add( tf );
		layout.putConstraint(SpringLayout.WEST, labels[2], 0, SpringLayout.WEST, labels[0]);
		layout.putConstraint(SpringLayout.NORTH, labels[2], 100, SpringLayout.NORTH, labels[0]);
		layout.putConstraint(SpringLayout.WEST, tf, 0, SpringLayout.WEST, labels[2]);
		layout.putConstraint(SpringLayout.NORTH, tf, 3, SpringLayout.SOUTH, labels[2] );
/*
		p.add( labels[3] );
		p.add( labels[4] );
		p.add( labels[5] );
		layout.putConstraint(SpringLayout.WEST, labels[3], 130, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, labels[3], 5, SpringLayout.SOUTH, textFields[0]);
		layout.putConstraint(SpringLayout.WEST, labels[4], 0, SpringLayout.WEST, textFields[3]);
		layout.putConstraint(SpringLayout.NORTH, labels[4], 5, SpringLayout.SOUTH, textFields[0]);
		layout.putConstraint(SpringLayout.WEST, labels[5], 121, SpringLayout.EAST, labels[4]);
		layout.putConstraint(SpringLayout.NORTH, labels[5], 5, SpringLayout.SOUTH, textFields[0]);
		
		p.add( textFields[2] );
		p.add( textFields[3] );
		p.add( textFields[4] );
		layout.putConstraint(SpringLayout.WEST, textFields[2], 130, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, textFields[2], 1, SpringLayout.SOUTH, labels[3] );
		layout.putConstraint(SpringLayout.WEST, textFields[3], 5, SpringLayout.EAST, textFields[2]);
		layout.putConstraint(SpringLayout.NORTH, textFields[3], 1, SpringLayout.SOUTH, labels[3]);
		layout.putConstraint(SpringLayout.WEST, textFields[4], 5, SpringLayout.EAST, textFields[3]);
		layout.putConstraint(SpringLayout.NORTH, textFields[4], 1, SpringLayout.SOUTH, labels[3]);
		
		p.add( labels[2] );
		p.add( labels[18] );
		p.add( labels[17] );
		layout.putConstraint(SpringLayout.WEST, labels[2], 130, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, labels[2], 5, SpringLayout.SOUTH, textFields[2]);
		layout.putConstraint(SpringLayout.WEST, labels[18], 83, SpringLayout.EAST, labels[2]);
		layout.putConstraint(SpringLayout.NORTH, labels[18], 5, SpringLayout.SOUTH, textFields[2]);
		layout.putConstraint(SpringLayout.WEST, labels[17], 95, SpringLayout.EAST, labels[18]);
		layout.putConstraint(SpringLayout.NORTH, labels[17], 5, SpringLayout.SOUTH, textFields[2]);
		
		p.add( textFields[5] );
		p.add( textFields[6] );
		p.add( textFields[7] );
		p.add( textFields[12] );
		p.add( textFields[13] );
		p.add( textFields[14] );
		p.add( textFields[8] );
		layout.putConstraint(SpringLayout.WEST, textFields[5], 130, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, textFields[5], 1, SpringLayout.SOUTH, labels[2] );
		layout.putConstraint(SpringLayout.WEST, textFields[6], 4, SpringLayout.EAST, textFields[5]);
		layout.putConstraint(SpringLayout.NORTH, textFields[6], 1, SpringLayout.SOUTH, labels[2]);
		layout.putConstraint(SpringLayout.WEST, textFields[7], 4, SpringLayout.EAST, textFields[6]);
		layout.putConstraint(SpringLayout.NORTH, textFields[7], 1, SpringLayout.SOUTH, labels[2]);
		
		layout.putConstraint(SpringLayout.WEST, textFields[12], 85, SpringLayout.EAST, labels[2]);
		layout.putConstraint(SpringLayout.NORTH, textFields[12], 1, SpringLayout.SOUTH, labels[2] );
		layout.putConstraint(SpringLayout.WEST, textFields[13], 4, SpringLayout.EAST, textFields[12]);
		layout.putConstraint(SpringLayout.NORTH, textFields[13], 1, SpringLayout.SOUTH, labels[2]);
		layout.putConstraint(SpringLayout.WEST, textFields[14], 4, SpringLayout.EAST, textFields[13]);
		layout.putConstraint(SpringLayout.NORTH, textFields[14], 1, SpringLayout.SOUTH, labels[2]);
		
		layout.putConstraint(SpringLayout.WEST, textFields[8], 98, SpringLayout.EAST, labels[18]);
		layout.putConstraint(SpringLayout.NORTH, textFields[8], 1, SpringLayout.SOUTH, labels[2]);
		
		p.add( labels[19] );
		p.add( tf );// );
		layout.putConstraint(SpringLayout.WEST, labels[19], 130, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, labels[19], 5, SpringLayout.SOUTH, textFields[8]);
		layout.putConstraint(SpringLayout.WEST, tf, 130, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, tf, 1, SpringLayout.SOUTH, labels[19] );
		
		Font title = new Font( "", Font.BOLD, 13 );
		p.add( labels[12] );
		labels[12].setFont( title );
		labels[12].setForeground( new Color( 150, 77, 41 ) );
		layout.putConstraint(SpringLayout.WEST, labels[12], 30, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, labels[12], 247, SpringLayout.NORTH, p);
		
		p.add( labels[10] );
		p.add( textFields[19] );
		layout.putConstraint(SpringLayout.WEST, labels[10], 30, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, labels[10], 5, SpringLayout.SOUTH, labels[12]);
		layout.putConstraint(SpringLayout.WEST, textFields[19], 30, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, textFields[19], 1, SpringLayout.SOUTH, labels[10] );
		
		p.add( labels[11] );
		p.add( textFields[20] );
		layout.putConstraint(SpringLayout.WEST, labels[11], 10, SpringLayout.EAST, textFields[19]);
		layout.putConstraint(SpringLayout.NORTH, labels[11], 5, SpringLayout.SOUTH, labels[12]);
		layout.putConstraint(SpringLayout.WEST, textFields[20], 10, SpringLayout.EAST, textFields[19]);
		layout.putConstraint(SpringLayout.NORTH, textFields[20], 1, SpringLayout.SOUTH, labels[10] );
		
		p.add( labels[7] );
		p.add( classDayComboBox );
		classDayComboBox.setPreferredSize( new Dimension( 100, 18 ) );
		classDayComboBox.setFont( f );
		classDayComboBox.setSize( 100, 100 );
		layout.putConstraint(SpringLayout.WEST, labels[7], 30, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, labels[7], 5, SpringLayout.SOUTH, textFields[19]);
		layout.putConstraint(SpringLayout.WEST, classDayComboBox, 30, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, classDayComboBox, 1, SpringLayout.SOUTH, labels[7] );
		
		p.add( labels[8] );
		timeHourComboBox.setPreferredSize( new Dimension( 45, 18 ) );
		timeMinComboBox.setPreferredSize( new Dimension( 45, 18 ) );
		timeAMPMComboBox.setPreferredSize( new Dimension( 50, 18 ) );
		p.add( timeHourComboBox );
		p.add( timeMinComboBox );
		p.add( timeAMPMComboBox );
		timeHourComboBox.setFont( f );
		timeMinComboBox.setFont( f );
		timeAMPMComboBox.setFont( f );
		layout.putConstraint(SpringLayout.WEST, labels[8], 10, SpringLayout.EAST, classDayComboBox);
		layout.putConstraint(SpringLayout.NORTH, labels[8], 5, SpringLayout.SOUTH, textFields[19]);
		layout.putConstraint(SpringLayout.WEST, timeHourComboBox, 10, SpringLayout.EAST, classDayComboBox);
		layout.putConstraint(SpringLayout.NORTH, timeHourComboBox, 1, SpringLayout.SOUTH, labels[8] );
		layout.putConstraint(SpringLayout.WEST, timeMinComboBox, 2, SpringLayout.EAST, timeHourComboBox);
		layout.putConstraint(SpringLayout.NORTH, timeMinComboBox, 1, SpringLayout.SOUTH, labels[8] );
		layout.putConstraint(SpringLayout.WEST, timeAMPMComboBox, 2, SpringLayout.EAST, timeMinComboBox);
		layout.putConstraint(SpringLayout.NORTH, timeAMPMComboBox, 1, SpringLayout.SOUTH, labels[8] );
		
		p.add( labels[9] );
		p.add( textFields[21] );
		layout.putConstraint(SpringLayout.WEST, labels[9], 10, SpringLayout.EAST, timeAMPMComboBox);
		layout.putConstraint(SpringLayout.NORTH, labels[9], 5, SpringLayout.SOUTH, textFields[19]);
		layout.putConstraint(SpringLayout.WEST, textFields[21], 10, SpringLayout.EAST, timeAMPMComboBox);
		layout.putConstraint(SpringLayout.NORTH, textFields[21], 1, SpringLayout.SOUTH, labels[9] );
		
		
		p.add( labels[20] );
		p.add( classDayComboBox2 );
		classDayComboBox2.setPreferredSize( new Dimension( 100, 18 ) );
		classDayComboBox2.setFont( f );
		classDayComboBox2.setSize( 100, 100 );
		layout.putConstraint(SpringLayout.WEST, labels[20], 30, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, labels[20], 5, SpringLayout.SOUTH, classDayComboBox);
		layout.putConstraint(SpringLayout.WEST, classDayComboBox2, 30, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, classDayComboBox2, 1, SpringLayout.SOUTH, labels[20] );
		
		p.add( labels[21] );
		timeHourComboBox2.setPreferredSize( new Dimension( 45, 18 ) );
		timeMinComboBox2.setPreferredSize( new Dimension( 45, 18 ) );
		timeAMPMComboBox2.setPreferredSize( new Dimension( 50, 18 ) );
		p.add( timeHourComboBox2 );
		p.add( timeMinComboBox2 );
		p.add( timeAMPMComboBox2 );
		timeHourComboBox2.setFont( f );
		timeMinComboBox2.setFont( f );
		timeAMPMComboBox2.setFont( f );
		layout.putConstraint(SpringLayout.WEST, labels[21], 10, SpringLayout.EAST, classDayComboBox2);
		layout.putConstraint(SpringLayout.NORTH, labels[21], 5, SpringLayout.SOUTH, classDayComboBox);
		layout.putConstraint(SpringLayout.WEST, timeHourComboBox2, 10, SpringLayout.EAST, classDayComboBox2);
		layout.putConstraint(SpringLayout.NORTH, timeHourComboBox2, 1, SpringLayout.SOUTH, labels[21] );
		layout.putConstraint(SpringLayout.WEST, timeMinComboBox2, 2, SpringLayout.EAST, timeHourComboBox2);
		layout.putConstraint(SpringLayout.NORTH, timeMinComboBox2, 1, SpringLayout.SOUTH, labels[21] );
		layout.putConstraint(SpringLayout.WEST, timeAMPMComboBox2, 2, SpringLayout.EAST, timeMinComboBox2);
		layout.putConstraint(SpringLayout.NORTH, timeAMPMComboBox2, 1, SpringLayout.SOUTH, labels[21] );
		
		p.add( labels[22] );
		p.add( textFields[22] );
		layout.putConstraint(SpringLayout.WEST, labels[22], 10, SpringLayout.EAST, timeAMPMComboBox2);
		layout.putConstraint(SpringLayout.NORTH, labels[22], 5, SpringLayout.SOUTH, classDayComboBox);
		layout.putConstraint(SpringLayout.WEST, textFields[22], 10, SpringLayout.EAST, timeAMPMComboBox2);
		layout.putConstraint(SpringLayout.NORTH, textFields[22], 1, SpringLayout.SOUTH, labels[22] );
		
		
		p.add( labels[13] );
		labels[13].setFont( title );
		labels[13].setForeground( new Color( 13, 115, 46 ) );
		layout.putConstraint(SpringLayout.WEST, labels[13], 385, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, labels[13], 10, SpringLayout.NORTH, parentPanel);
		
		p.add( labels[14] );
		p.add( textFields[9] );
		layout.putConstraint(SpringLayout.WEST, labels[14], 0, SpringLayout.WEST, labels[13]);
		layout.putConstraint(SpringLayout.NORTH, labels[14], 10, SpringLayout.SOUTH, labels[13]);
		layout.putConstraint(SpringLayout.WEST, textFields[9], 0, SpringLayout.WEST, labels[13]);
		layout.putConstraint(SpringLayout.NORTH, textFields[9], 1, SpringLayout.SOUTH, labels[14] );
		
		p.add( labels[16] );
		p.add( textFields[11] );
		layout.putConstraint(SpringLayout.WEST, labels[16], 0, SpringLayout.WEST, labels[13]);
		layout.putConstraint(SpringLayout.NORTH, labels[16], 10, SpringLayout.SOUTH, textFields[9]);
		layout.putConstraint(SpringLayout.WEST, textFields[11], 0, SpringLayout.WEST, labels[13]);
		layout.putConstraint(SpringLayout.NORTH, textFields[11], 1, SpringLayout.SOUTH, labels[16] );
		
		p.add( labels[15] );
		p.add( textFields[16] );
		p.add( textFields[17] );
		p.add( textFields[18] );
		layout.putConstraint(SpringLayout.WEST, labels[15], 30, SpringLayout.WEST, labels[13]);
		layout.putConstraint(SpringLayout.NORTH, labels[15], 10, SpringLayout.SOUTH, textFields[11]);
		layout.putConstraint(SpringLayout.WEST, textFields[16], 30, SpringLayout.WEST, labels[13]);
		layout.putConstraint(SpringLayout.NORTH, textFields[16], 1, SpringLayout.SOUTH, labels[15] );
		layout.putConstraint(SpringLayout.WEST, textFields[17], 4, SpringLayout.EAST, textFields[16]);
		layout.putConstraint(SpringLayout.NORTH, textFields[17], 1, SpringLayout.SOUTH, labels[15]);
		layout.putConstraint(SpringLayout.WEST, textFields[18], 4, SpringLayout.EAST, textFields[17]);
		layout.putConstraint(SpringLayout.NORTH, textFields[18], 1, SpringLayout.SOUTH, labels[15]);
		
		//Panel for class information
		
		
		classPanel.setPreferredSize( new Dimension( 340, 150 ));
		parentPanel.setPreferredSize( new Dimension( 220, 185 ));
		
		p.add( classPanel );
		layout.putConstraint(SpringLayout.WEST, classPanel, 20, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, classPanel, 245, SpringLayout.NORTH, p );
		classPanel.setBackground( new Color( 243, 189, 186 ) );
		//classPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		p.add( parentPanel );
		layout.putConstraint(SpringLayout.WEST, parentPanel, 375, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, parentPanel, 210, SpringLayout.NORTH, p );
		parentPanel.setBackground( new Color( 193, 233, 145 ) );
		//classPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		
*/		
		p.add( buttons[3] );
		buttons[3].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		layout.putConstraint(SpringLayout.WEST, buttons[3], 100, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, buttons[3], 360, SpringLayout.NORTH, p );
		
		p.add( buttons[4] );
		buttons[4].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		layout.putConstraint(SpringLayout.EAST, buttons[4], -100, SpringLayout.EAST, p);
		layout.putConstraint(SpringLayout.NORTH, buttons[4], 360, SpringLayout.NORTH, p );
		
		p.setBackground( Color.WHITE );
		c.setBackground( Color.WHITE );
		
		c.add( p );
		
		//containerLayout.putConstraint(SpringLayout.WEST, classPanel, 130, SpringLayout.WEST, c);
		//containerLayout.putConstraint(SpringLayout.NORTH, classPanel, 10, SpringLayout.NORTH, p );
		
		//clearFields();
		setSize( 500, 430 );
		
        setResizable( false );
		//show();
		
    }

    public void setNewClassTracker( NewClassTracker n ) {
    	nct = n;
    }
     
    private int getYear() {
    	if( todayYear == 2021 )
    		return 14;
    	else if( todayYear == 2022 )
    		return 15;
    	else if( todayYear == 2023 )
    		return 16;
    	else if( todayYear == 2024 )
    		return 17;
    	else if( todayYear == 2025 )
    		return 18;
    	else if( todayYear == 2026 )
    		return 19;
    	else if( todayYear == 2027 )
    		return 20;
    	else if( todayYear == 2028 )
    		return 21;
    	else if( todayYear == 2029 )
    		return 22;
    	else if( todayYear == 2030 )
    		return 23;
    		
    	return 0;
    }
    
    public void saveWithdrawInfo() throws IOException {
    	int count = 0;
    	String filingDate = "";
    	String lastdayDate = "";
    	
    	String filingMonth, filingYear, filingDay, lastMonth, lastYear, lastDay;
    	
    	if( birthdayMonthComboBox.getSelectedIndex() != 0 )
    		count++;
    	if( birthdayDayComboBox.getSelectedIndex() != 0 )
    		count++;
    	if( birthdayYearComboBox.getSelectedIndex() != 0 )
    		count++;
    	if( count == 1 || count == 2 ) {
    		JOptionPane.showMessageDialog(this, "Incomplete Withdraw Filing Date.  Please Check And Try Again. ", "Incomplete Information", 
                                          JOptionPane.ERROR_MESSAGE );
            return;
    	}
    	
    	count = 0;
    	if( lastdayMonthComboBox.getSelectedIndex() != 0 )
    		count++;
    	if( lastdayDayComboBox.getSelectedIndex() != 0 )
    		count++;
    	if( lastdayYearComboBox.getSelectedIndex() != 0 )
    		count++;
    	if( count == 1 || count == 2 ) {
    		JOptionPane.showMessageDialog(this, "Incomplete Lastday Date.  Please Check And Try Again. ", "Incomplete Information", 
                                          JOptionPane.ERROR_MESSAGE );
            return;
    	}
    	
    	filingMonth = Integer.toString( birthdayMonthComboBox.getSelectedIndex() );
    	filingDay = Integer.toString( birthdayDayComboBox.getSelectedIndex() );
    	filingYear = Integer.toString( birthdayYearComboBox.getSelectedIndex() + 7);
    	lastMonth = Integer.toString( lastdayMonthComboBox.getSelectedIndex() );
    	lastDay = Integer.toString( lastdayDayComboBox.getSelectedIndex() );
    	lastYear = Integer.toString( lastdayYearComboBox.getSelectedIndex() + 7);
    	
    	if( filingMonth.length() == 1 )
    		filingMonth = "0" + filingMonth;
    	if( filingDay.length() == 1 )
    		filingDay = "0" + filingDay;
    	if( filingYear.length() == 1 )
    		filingYear = "0" + filingYear;
    		
    	if( lastMonth.length() == 1 )
    		lastMonth = "0" + lastMonth;
    	if( lastDay.length() == 1 )
    		lastDay = "0" + lastDay;
    	if( lastYear.length() == 1 )
    		lastYear = "0" + lastYear;
    	
    	filingDate = filingMonth + filingDay + filingYear;
    	lastdayDate = lastMonth + lastDay + lastYear;
    	System.out.println( "filingDate: " + filingDate );
    	System.out.println( "lastdayDate: " + lastdayDate );
    	
    	sr.setWithdrawFilingDate( filingDate );
    	sr.setLastdayDate( lastdayDate );
    	sr.setWithdrawReason( tf.getText() );
    
    	if( output == null )
			openFile();
			
		output.seek( recordNumber * sr.size() + 10 );
		sr.write( output );
		
		setVisible( false );
        nct.setVisible( true );
        clearAllFields();
    }
    
    public void openWithdrawPage( int rNumber ) throws IOException {
    	String str = "";
    	if( output == null ) 
    		openFile();
    		
    	clearAllFields();
    	
    	recordNumber = rNumber;
    	sr.resetAllFields();
    	output.seek( rNumber * sr.size() + 10 );
    	sr.read( output );
    	
    	String filingDate = sr.getWithdrawFilingDate();
    	String lastDay = sr.getLastdayDate();
    	if( filingDate.length() == 6 ) {
			birthdayMonthComboBox.setSelectedIndex( Integer.parseInt( filingDate.substring( 0, 2 ) ) );
			birthdayDayComboBox.setSelectedIndex( Integer.parseInt( filingDate.substring( 2, 4 ) ) );
			birthdayYearComboBox.setSelectedIndex( Integer.parseInt( filingDate.substring( 4 ) ) - 7 );
		}
		if( lastDay.length() == 6 ) {
			lastdayMonthComboBox.setSelectedIndex( Integer.parseInt( lastDay.substring( 0, 2 ) ) );
			lastdayDayComboBox.setSelectedIndex( Integer.parseInt( lastDay.substring( 2, 4 ) ) );
			lastdayYearComboBox.setSelectedIndex( Integer.parseInt( lastDay.substring( 4 ) ) - 7 );
		}
		tf.setText( sr.getWithdrawReason() );
    	
    	ImageIcon aa = new ImageIcon( "pictures\\" + sr.getPictureName() );
        BufferedImage ba = new BufferedImage(110, 125, BufferedImage.TYPE_INT_ARGB);
		ba.getGraphics().drawImage(aa.getImage(), 0, 0, 110, 125, null);
		pictureLabel.setIcon( new ImageIcon( ba ));

		idTextField.setText( "ID: " + sr.getStudentTeacherId() );
    	
    	setVisible( true );
    }
    
    private void getDateTime() {
        DateFormat dateFormatYear = new SimpleDateFormat("yyyy");
        DateFormat dateFormatMonth = new SimpleDateFormat( "MM" );
        DateFormat dateFormatDay = new SimpleDateFormat( "dd" );
        DateFormat dateFormatDayOfWeek = new SimpleDateFormat( "EEE" );
        Date date = new Date();
        todayMonth = Integer.parseInt( dateFormatMonth.format( date ) );
        todayYear = Integer.parseInt( dateFormatYear.format( date ) );
        todayDay = Integer.parseInt( dateFormatDay.format( date ) );
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
    
    public void clearAllFields() {
    	birthdayMonthComboBox.setSelectedIndex( 0 );
		birthdayDayComboBox.setSelectedIndex( 0 );
		birthdayYearComboBox.setSelectedIndex( 0 );
		lastdayMonthComboBox.setSelectedIndex( 0 );
		lastdayDayComboBox.setSelectedIndex( 0 );
		lastdayYearComboBox.setSelectedIndex( 0 );
		tf.setText("");
    }
    
	public static void main( String args[] ) {
		WithdrawPage wp = new WithdrawPage();
		
		wp.addWindowListener(
			new WindowAdapter() {
				public void windowClosing( WindowEvent e ) {
				System.out.println("Closing SIP");
					System.exit(0);
				} 
			}
		);
	}
	
}
/*
class MyTextField extends JTextField {
	int limit;

	MyTextField(int show,int limit) {
		super(show);

		this.limit = limit;

		addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				if (getText().length() >= MyTextField.this.limit)
					evt.consume();
			}
		});
	}
} 
*/