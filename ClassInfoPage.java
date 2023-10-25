import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ClassInfoPage extends JFrame {
    private String comboBoxNames[] = { "Music Together", "Music 4 Young Children", "Private Lesson", "Semi-Private Lesson", "Group Class: Art", "Group Class: Sing" };
    private String registeredComboBoxNames[] = { " ", " Yes ", " No " };
    private String classDays[] = { "", "  Monday  ", "  Tuesday  ", "  Wednesday  ", "  Thursday  ", "  Friday  ", "  Saturday  ",
        "  Sunday  ", "Mon & Wedn", "Tues & Thurs", "Wedn & Fri", "Thurs & Sat" };
    private String timeHours[] = { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    private String timeMins[] = { "00", "15", "30", "45" };
    private String timeAMPM[] = { "AM", "PM" };
    private String periodNumber[] = { "", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    private String dateMonths[] = { "", "January", "Febuary", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December" };
    private String dateDays[] = { "0", " 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", "11", "12", "13", "14", "15", "16",
        "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    private String dateYears[] = { "2008", "2009", "2010", "2011", "2012", "2013", "2014" };
    private JComboBox comboBox, classDayComboBox, timeHourComboBox, timeMinComboBox, timeAMPMComboBox,
        dateMonthComboBox[], dateDayComboBox[], dateYearComboBox[], testComboBox[], registeredComboBox, periodComboBox;
    private JCheckBox discontinued, paid, invoiceSent;
    //private String radioButtonNames[] = { "Paid", "Discontinued",  };
    private String labelNames[] = { "Instructor", " Day ", "          Time ", "Start ", "    End ", "CURRENT SESSION", 
        "           Amount Paid", "Payment Alert ", "Payments Left", "Class Comment ( 50 letters max )", "~~~>" ,"~~~>", "~~~>", 
        "Payment Made", "~~~~~~> Amount ", "NEXT SESSION", "Start ", "    End ", "Payment Made", 
        "           Amount Paid", "             ", "Registered? ", "           Duration(min.)", "          Period#"}; //total 20
    private String buttonNames[] = { "Save Changes", "Close w/o Change", "Update Session", "??" };
    private JLabel labels[];
    private JTextField textFields[];
    private JPanel panels[];
    private JButton buttons[];
    public StudentRecord sr;
    //public StudentInfoPage sip;
    private ButtonGroup radioGroup;
    private String message;
    private RandomAccessFile output;
    private Icon updateSessionIcon, saveIcon, closeIcon;

    public ClassInfoPage() {
        super( "Class Information" );
        //System.out.println( "length = " + labelNames.length );       
        Container c = getContentPane();
		panels = new JPanel[20];
		buttons = new JButton[4];
		labels = new JLabel[labelNames.length];
		textFields = new JTextField[7];
        //radioButtons = new JRadioButton[2]; 
        discontinued = new JCheckBox( "Discontinued" );
        paid = new JCheckBox( "Paid" );
        invoiceSent = new JCheckBox( "Invoice Sent" );
        comboBox = new JComboBox( comboBoxNames ); 
        classDayComboBox = new JComboBox( classDays );
        timeHourComboBox = new JComboBox( timeHours );
        timeMinComboBox = new JComboBox( timeMins );
        periodComboBox = new JComboBox( periodNumber );
        registeredComboBox = new JComboBox( registeredComboBoxNames );
        timeAMPMComboBox = new JComboBox( timeAMPM );
        dateMonthComboBox = new JComboBox[13];    //( dateMonths );
        dateDayComboBox  = new JComboBox[13];     //( dateDays );
        dateYearComboBox = new JComboBox[13];     //( dateYears );
        closeIcon = new ImageIcon( "close_icon.jpg" );
        saveIcon = new ImageIcon( "save_icon.jpg" );
        updateSessionIcon = new ImageIcon( "update_session_icon.jpg" );
        
        //for( int i = 0; i < 4; i++ ) {
        //	buttons[i] = new JButton( buttonNames[i] );
        //}
        buttons[0] = new JButton( buttonNames[0], saveIcon );
        buttons[1] = new JButton( buttonNames[1], closeIcon );
        buttons[2] = new JButton( buttonNames[2], updateSessionIcon );
        buttons[3] = new JButton( buttonNames[3] );
        
        for( int i = 0; i < 13; i++ ) {
        	dateMonthComboBox[i] = new JComboBox( dateMonths );
        	dateDayComboBox[i] = new JComboBox( dateDays );
        	dateYearComboBox[i] = new JComboBox( dateYears );
        }

        /*for( int i = 2; i < radioButtons.length; i++ ) {
            radioButtons[(i-2)] = new JRadioButton( radioButtonNames[i] );
            radioButtons[i] = new JRadioButton( radioButtonNames[i] );
        }
        */
        
        for( int i = 0; i < labelNames.length; i++) {
            labels[i] = new JLabel( labelNames[i] );         
        }

        for( int i = 0; i < panels.length; i++ ) {
            panels[i] = new JPanel();
        }
        
        /* set text field width*/
        for( int i = 0; i < 4; i++ ) {
        	textFields[i] = new JTextField( 10 );
        }
        textFields[4] = new JTextField( 30 );
        textFields[5] = new JTextField( 5 );
        textFields[6] = new JTextField( 5 );

        addWindowListener(
            new WindowAdapter() {    		
                public void windowClosing( WindowEvent e ) {
                    clearFields();
                    setVisible( false );
                    sip.setEnabled( true );
	    		} 
        	}
		);
		
        buttons[0].addActionListener(				// Save Info Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("helllo");
                    //addNewClass();
                    //sip.setVisible( true );
                    updateStudentRecord();
                    
                }
            }
        );
        
        buttons[1].addActionListener(				// Close w/o Change Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	int n = 0;
                	if( changesMade() == true ) {
    					n = JOptionPane.showConfirmDialog( null, "Changes Have Been Made.  Exit w/o Saving Changes?", "Exit Confirmation",
    							JOptionPane.YES_NO_OPTION);
    				}
    					
    			    if( n == 0 ) {
                    	clearFields();
                    	setVisible( false ); 
                    	sip.setEnabled( true );
                    	sip.setVisible( true );
                    }               
                	                
                }
            }
        );
        
        buttons[2].addActionListener(				// Update Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	message = "Clicking \"Yes\" Will Update Record And Save Tracker To File. \n This Will Reset Tracker Information, But It Can Be Viewed @ Tracker History. \n Do You Wish To Continue?";
    				int n = JOptionPane.showConfirmDialog( null, message, "Exit Confirmation",
    							JOptionPane.YES_NO_OPTION);
                	if( n == 0 ) {
                		//saveTrackerInfoToHistory();
                		if( sip.newOrOld == -1 )
                			JOptionPane.showMessageDialog(null, "Can Not Update Session For New Student Who Has Not Been Saved", "IOException Error", JOptionPane.ERROR_MESSAGE );
                		else
                			updateSession();
                	}
    				              
                }
            }
        );
        
        

        panels[0].setLayout( new GridLayout( 15, 1, 5, 3) );          

        // instructor panel
        
        panels[1].add( labels[21] );
        panels[1].add( registeredComboBox );
        
        panels[2].add( labels[0] ); 
        panels[2].add( textFields[0] );
		panels[2].add( labels[20] );
        panels[2].add( comboBox );
        panels[2].add( labels[23] );
        panels[2].add( periodComboBox );
        
        // class day panel
        panels[3].add( labels[1] );
        panels[3].add( classDayComboBox );
        //panels[2].add( textFields[1] );

        // class time panel
        panels[3].add( labels[2] );
        panels[3].add( timeHourComboBox );
        panels[3].add( timeMinComboBox );
        panels[3].add( timeAMPMComboBox );
        panels[3].add( labels[22] );
        panels[3].add( textFields[5] );
        
        
        
        // current class label
        panels[5].add( labels[5] );

        // start date and end date panel
        panels[6].add( labels[3] );
        panels[6].add( dateMonthComboBox[0] );
        panels[6].add( dateDayComboBox[0] );
        panels[6].add( dateYearComboBox[0] );
  
        panels[6].add( labels[4] );
        panels[6].add( dateMonthComboBox[1] );
        panels[6].add( dateDayComboBox[1] );
        panels[6].add( dateYearComboBox[1] );
        //panels[5].add( labels[11] );
        
        //payment and amount panel
        panels[7].add( labels[13] );
        panels[7].add( dateMonthComboBox[9] );
        panels[7].add( dateDayComboBox[9] );
        panels[7].add( dateYearComboBox[9] );
        panels[7].add( labels[6] );
        panels[7].add( textFields[1] );
        
        //next payment panel
        panels[8].add( labels[7] );
        panels[8].add( dateMonthComboBox[8] );
        panels[8].add( dateDayComboBox[8] );
        panels[8].add( dateYearComboBox[8] );
        panels[8].add( labels[14] );
        panels[8].add( textFields[3] );
        
        //radioGroup = new ButtonGroup();
        //radioGroup.add( radioButtons[0] );
        //radioGroup.add( radioButtons[1] );
        panels[9].add( discontinued );
        panels[9].add( paid );
        panels[9].add( invoiceSent );
        
        //next session panel
        panels[11].add( labels[15] );
        
        //next session start and end panel
        panels[12]. add( labels[16] );
        panels[12].add( dateMonthComboBox[10] );
        panels[12].add( dateDayComboBox[10] );
        panels[12].add( dateYearComboBox[10] );
        panels[12].add( labels[17] );
        panels[12].add( dateMonthComboBox[11] );
        panels[12].add( dateDayComboBox[11] );
        panels[12].add( dateYearComboBox[11] );
        
        //next session payment and amount panel
        panels[13].add( labels[18] );
        panels[13].add( dateMonthComboBox[12] );
        panels[13].add( dateDayComboBox[12] );
        panels[13].add( dateYearComboBox[12] );
        panels[13].add( labels[19] );
        panels[13].add( textFields[2] );
        
        //comment
        panels[15].add( labels[9] );
        panels[15].add( textFields[4] );
        
        //missed and make-up panels
        
        //button panel
        panels[17].add( buttons[0] );
        panels[17].add( buttons[1] );
        panels[17].add( buttons[2] );
        
		

        for( int i = 1; i < 16; i++) {
            panels[0].add( panels[i] );
        }
        
		clearFields();

        c.add( panels[0], BorderLayout.NORTH );
        c.add( panels[17], BorderLayout.SOUTH );
       
        setSize( 600, 680 );
        
        setResizable( false );
        //show();


    }
	
    public void setSIP( StudentInfoPage s ) {
    	sip = s;
    }
    
    public void saveTrackerInfoToHistory() throws IOException {
    	
    }
    
    public void clearFields() {
    	textFields[0].setText("");
    	textFields[1].setText("0.0");
    	textFields[2].setText("0.0");
    	textFields[3].setText("0.0");
    	textFields[4].setText("");
    	textFields[5].setText("");
    	textFields[6].setText("");
    	classDayComboBox.setSelectedIndex( 0 );
    	timeHourComboBox.setSelectedIndex( 0 );
    	timeMinComboBox.setSelectedIndex( 0 );
    	timeAMPMComboBox.setSelectedIndex( 0 );
    	registeredComboBox.setSelectedIndex( 0 );
    	periodComboBox.setSelectedIndex( 0 );
    	comboBox.setSelectedIndex( 0 );
    	for( int i = 0; i < dateMonthComboBox.length; i++ ) {
    		dateMonthComboBox[i].setSelectedIndex( 0 );
    		dateDayComboBox[i].setSelectedIndex( 0 );
    		dateYearComboBox[i].setSelectedIndex( 0 );
    	}
    	discontinued.setSelected( false );
    	paid.setSelected( false );
    	invoiceSent.setSelected( false );
    }
    
    private void updateSession() {
    
    	//capture all errors
    	if( dateMonthComboBox[10].getSelectedIndex() == 0 || dateDayComboBox[10].getSelectedIndex() == 0 || 
    		dateMonthComboBox[11].getSelectedIndex() == 0 || dateDayComboBox[11].getSelectedIndex() == 0 || 
    		dateMonthComboBox[12].getSelectedIndex() == 0 || dateDayComboBox[12].getSelectedIndex() == 0 ) {
    		JOptionPane.showMessageDialog(null, "Information For Next Session Incomplete", "Incomplete Information", 
                                          JOptionPane.PLAIN_MESSAGE );
            return;
        }
        
        try {
    		Double.parseDouble( textFields[2].getText() );
    	} catch ( NumberFormatException nfe ) {
            JOptionPane.showMessageDialog(this, "Encountered Envalid Number.  Please Check Next Session Amount Field.", "Number Format Error", 
                                          JOptionPane.ERROR_MESSAGE );
            return;
        }
    	
    	try {
    		saveTracker();
    	} catch ( IOException e ) {
            JOptionPane.showMessageDialog(this, "ClassInfoPage:SaveTracker()", "IOException Error", 
                                          JOptionPane.ERROR_MESSAGE );
            return;
        }
        
        //reset class tracker page
        sip.sr.setTrackerInput1( "" );
        sip.sr.setTrackerInput2( "" );
        sip.sr.setTrackerInput3( "" );
        sip.sr.setTrackerInput4( "" );
        sip.sr.setTrackerInput5( "" );
        sip.sr.setTrackerInput6( "" );
        sip.sr.setTrackerInput7( "" );
        sip.sr.setTrackerInput8( "" );
        sip.sr.setTrackerInput9( "" );
        sip.sr.setTrackerInput10( "" );
        sip.sr.setTrackerInput11( "" );
        sip.sr.setTrackerInput12( "" );
        sip.sr.setTrackerMissed1( "" );
        sip.sr.setTrackerMakeup1( "" );
        sip.sr.setTrackerMissed2( "" );
        sip.sr.setTrackerMakeup2( "" );
        
    	dateMonthComboBox[0].setSelectedIndex( dateMonthComboBox[10].getSelectedIndex() ); 
    	dateDayComboBox[0].setSelectedIndex( dateDayComboBox[10].getSelectedIndex() ); 
    	dateYearComboBox[0].setSelectedIndex( dateYearComboBox[10].getSelectedIndex() ); 
    	dateMonthComboBox[1].setSelectedIndex( dateMonthComboBox[11].getSelectedIndex() ); 
    	dateDayComboBox[1].setSelectedIndex( dateDayComboBox[11].getSelectedIndex() ); 
    	dateYearComboBox[1].setSelectedIndex( dateYearComboBox[11].getSelectedIndex() );
    	dateMonthComboBox[9].setSelectedIndex( dateMonthComboBox[12].getSelectedIndex() ); 
    	dateDayComboBox[9].setSelectedIndex( dateDayComboBox[12].getSelectedIndex() ); 
    	dateYearComboBox[9].setSelectedIndex( dateYearComboBox[12].getSelectedIndex() );
    	textFields[1].setText( textFields[2].getText() );
    	dateMonthComboBox[8].setSelectedIndex( 0 ); 
    	dateDayComboBox[8].setSelectedIndex( 0 ); 
    	dateYearComboBox[8].setSelectedIndex( 0 );
    	textFields[2].setText( "0.0" );
    	
    	dateMonthComboBox[10].setSelectedIndex( 0 ); 
    	dateDayComboBox[10].setSelectedIndex( 0 ); 
    	dateYearComboBox[10].setSelectedIndex( 0 ); 
    	dateMonthComboBox[11].setSelectedIndex( 0 ); 
    	dateDayComboBox[11].setSelectedIndex( 0 ); 
    	dateYearComboBox[11].setSelectedIndex( 0 );
    	dateMonthComboBox[12].setSelectedIndex( 0 ); 
    	dateDayComboBox[12].setSelectedIndex( 0 ); 
    	dateYearComboBox[12].setSelectedIndex( 0 );
    	textFields[3].setText( "0.0" );
    	//textFields[4].setText( "" );
    	
    	discontinued.setSelected( false );
    	paid.setSelected( false );
    	invoiceSent.setSelected( false );
    	
    	sip.sr.setInstructorName( textFields[0].getText().toUpperCase().trim() );
    	sip.sr.setClassType( comboBox.getSelectedIndex() );
    	sip.sr.setClassDay( classDayComboBox.getSelectedIndex() );
    	sip.sr.setClassTimeHour( timeHourComboBox.getSelectedIndex() );
    	sip.sr.setClassTimeMin( timeMinComboBox.getSelectedIndex() );
    	sip.sr.setClassTimeAMPM( timeAMPMComboBox.getSelectedIndex() );
    	sip.sr.setStartMonthCurrent( dateMonthComboBox[0].getSelectedIndex() );
    	sip.sr.setStartDayCurrent( dateDayComboBox[0].getSelectedIndex() );
    	sip.sr.setStartYearCurrent( dateYearComboBox[0].getSelectedIndex() );
    	sip.sr.setEndMonthCurrent( dateMonthComboBox[1].getSelectedIndex() );
    	sip.sr.setEndDayCurrent( dateDayComboBox[1].getSelectedIndex() );
    	sip.sr.setEndYearCurrent( dateYearComboBox[1].getSelectedIndex() );
        
        sip.sr.setPaymentMonthCurrent( dateMonthComboBox[9].getSelectedIndex() );
    	sip.sr.setPaymentDayCurrent( dateDayComboBox[9].getSelectedIndex() );
    	sip.sr.setPaymentYearCurrent( dateYearComboBox[9].getSelectedIndex() );
    	//double d = new double( textFields[1].getText() );
    	sip.sr.setAmountPaidCurrent( Double.parseDouble(textFields[1].getText()) );
    	
        sip.sr.setNextPaymentMonth( dateMonthComboBox[8].getSelectedIndex() );
        sip.sr.setNextPaymentDay( dateDayComboBox[8].getSelectedIndex() );
        sip.sr.setNextPaymentYear( dateYearComboBox[8].getSelectedIndex() );
        sip.sr.setNextPaymentAmount( Double.parseDouble(textFields[3].getText()) );
        sip.sr.setNextPaymentPaid( paid.isSelected() );
        sip.sr.setNextPaymentDiscontinued( discontinued.isSelected() );
        
        sip.sr.setStartMonthNext( dateMonthComboBox[10].getSelectedIndex() );
    	sip.sr.setStartDayNext( dateDayComboBox[10].getSelectedIndex() );
    	sip.sr.setStartYearNext( dateYearComboBox[10].getSelectedIndex() );
    	sip.sr.setEndMonthNext( dateMonthComboBox[11].getSelectedIndex() );
    	sip.sr.setEndDayNext( dateDayComboBox[11].getSelectedIndex() );
    	sip.sr.setEndYearNext( dateYearComboBox[11].getSelectedIndex() );
        
        sip.sr.setPaymentMonthNext( dateMonthComboBox[12].getSelectedIndex() );
    	sip.sr.setPaymentDayNext( dateDayComboBox[12].getSelectedIndex() );
    	sip.sr.setPaymentYearNext( dateYearComboBox[12].getSelectedIndex() );
    	sip.sr.setAmountPaidNext( Double.parseDouble(textFields[2].getText()) );
    	sip.sr.setClassInfoComment( textFields[4].getText() );
    	
    	sip.sr.setClassDuration( Integer.parseInt( textFields[5].getText().trim()) );
    	sip.sr.setClassPeriod( periodComboBox.getSelectedIndex() );
    	
    	if( registeredComboBox.getSelectedIndex() == 1 )
    		sip.sr.setIsRegistered( true );
    	else if ( registeredComboBox.getSelectedIndex() == 2 )
    		sip.sr.setIsRegistered( false );
    	
    	
    	sip.updateClassInfo();
    	//updateStudentRecord();
    	JOptionPane.showMessageDialog(this, "Please Set Payment Alert Date Before Exiting This Page", "Set Payment Alert", 
                                          JOptionPane.PLAIN_MESSAGE );
    }
    
    private void saveTracker() throws IOException {
    	String fileName = "", trackerInfo = "";
    	int recordCount = 0;
    	
    	//open file w/ student's name
    	fileName = sip.sr.getFirstName() + "-" + sip.sr.getLastName() + ".txt";
    	openFile( fileName );
    	
    	//find right location of file to input string
    	output.seek( 0 );
    	recordCount = output.readInt();
    	output.seek( recordCount * sip.sr.trackerSize() + 10 );
    	
    	//save all info to string
    	trackerInfo = "Class Type: " + comboBoxNames[sip.sr.getClassType()] + "     Instructor: " + sip.sr.getInstructorName().trim() + 
    		"     Time: " + timeIntToString( sip.sr.getClassTimeHour(), sip.sr.getClassTimeMin(), sip.sr.getClassTimeAMPM() ) + "\n";
    	trackerInfo += "Started: " + dateIntToString( sip.sr.getStartMonthCurrent(), sip.sr.getStartDayCurrent(), sip.sr.getStartYearCurrent() ) +
    		"     Ended: " + dateIntToString( sip.sr.getEndMonthCurrent(), sip.sr.getEndDayCurrent(), sip.sr.getEndYearCurrent() ) + "\n";
    	trackerInfo += "Payment of $" + Double.toString( sip.sr.getAmountPaidCurrent() ) + " made on " + dateIntToString( sip.sr.getPaymentMonthCurrent(), 
    		sip.sr.getPaymentDayCurrent(), sip.sr.getPaymentYearCurrent() ) + "\n";
    	trackerInfo += "Class Name: " + sip.sr.getTrackerClassName().trim() + "\n";
    	trackerInfo += " 1. " + sip.sr.getTrackerInput1() + "\n";
    	trackerInfo += " 2. " + sip.sr.getTrackerInput2() + "\n";
    	trackerInfo += " 3. " + sip.sr.getTrackerInput3() + "\n";
    	trackerInfo += " 4. " + sip.sr.getTrackerInput4() + "\n";
    	trackerInfo += " 5. " + sip.sr.getTrackerInput5() + "\n";
    	trackerInfo += " 6. " + sip.sr.getTrackerInput6() + "\n";
    	trackerInfo += " 7. " + sip.sr.getTrackerInput7() + "\n";
    	trackerInfo += " 8. " + sip.sr.getTrackerInput8() + "\n"; 
    	trackerInfo += " 9. " + sip.sr.getTrackerInput9() + "\n"; 
    	trackerInfo += "10. " + sip.sr.getTrackerInput10() + "\n"; 
    	trackerInfo += "11. " + sip.sr.getTrackerInput11() + "\n"; 
    	trackerInfo += "12. " + sip.sr.getTrackerInput12() + "\n"; 
    	
    	
    	//System.out.println( "-------------------------\n" + trackerInfo );
    	//write string to file using writeString in StudentRecord
    	writeToTrackerFile( output, trackerInfo );
    	
    	output.seek( 0 );
    	output.writeInt( recordCount + 1 );
    	
    	closeFile();
    }
    
    
    
    private void writeToTrackerFile( RandomAccessFile f, String s ) throws IOException {
    	f.writeInt( sip.sr.getPaymentMonthCurrent() );
    	f.writeInt( (sip.sr.getPaymentYearCurrent() + 2008) );
    	f.writeDouble( sip.sr.getAmountPaidCurrent() );
    	writeString( f, s, 800 );
    }
    
    private void writeString( RandomAccessFile f, String s, int length ) throws IOException{
        StringBuffer buf = null;

        if( s != null ) 
            buf = new StringBuffer( s );
        else 
            buf = new StringBuffer( length );
        
        buf.setLength( length );
        f.writeChars( buf.toString() );
    }
    
    private String addToLength( String s, int len ) {
    	for( int i = s.length(); i <= len; i++ ) {
    		s += " ";
    	}
    	return s;
    }
    
    private String dateIntToString( int a, int b, int c ) {
    	String s = "";
    	s = dateMonths[a] + " " + dateDays[b] + ", " + dateYears[c];
    	return s;
    }
    
    private String timeIntToString( int a, int b, int c ) {
    	String s = "";
    	s = timeHours[a] + ":" +  timeMins[b] + " " + timeAMPM[c];
    	return s;
    }
    
    private void openFile( String s ) {
        try {
        //System.out.println( "String in openfile: " + s );
            output = new RandomAccessFile( s, "rw" );
        } catch ( IOException e ) {
            JOptionPane.showMessageDialog(this, "ClassInfoPage:OpenFile File does not exist", "Invalid File Name", 
                                          JOptionPane.ERROR_MESSAGE );
        }
    }

    private void closeFile() {
        try {
            output.close();
            //System.exit( 0 );
        } catch ( IOException ex ) {
            JOptionPane.showMessageDialog(this, "Error closing file", "Error", 
                                          JOptionPane.ERROR_MESSAGE );
            //System.exit( 1 );
        }
    }
    
    private void updateStudentRecord() {
    
    	try {
    		for( int i = 1; i < 4; i++ ) {
    			Double.parseDouble( textFields[i].getText() );
    		}
    	}
    	catch( NumberFormatException nfe ) {
    		JOptionPane.showMessageDialog( this, "Error Occured With Input Amount.  Please Check Inputs And Make Corrections.", 
    			"Not Enough Information", JOptionPane.ERROR_MESSAGE );
    		return;
    	}
    	
    	if( classDayComboBox.getSelectedIndex() == 0 || timeHourComboBox.getSelectedIndex() == 0 || registeredComboBox.getSelectedIndex() == 0 ||
    		textFields[5].getText().compareTo( "" ) == 0 ) {
    		JOptionPane.showMessageDialog( this, "Day, Time, Duration Of Class And Is Student Currently Registered Must Be Entered", 
    			"Not Enough Information", JOptionPane.ERROR_MESSAGE );
    		return;
    	}
    	
    	if( (comboBox.getSelectedIndex() == 0 || comboBox.getSelectedIndex() == 1) && periodComboBox.getSelectedIndex() == 0 ) {
    		JOptionPane.showMessageDialog( this, "Music Together Or Music For Young Children Requires Period#", "Not Enough Information", JOptionPane.ERROR_MESSAGE );
    		return;
    	}
    	else if ( !(comboBox.getSelectedIndex() == 0 || comboBox.getSelectedIndex() == 1) && !(periodComboBox.getSelectedIndex() == 0) ) {
    		JOptionPane.showMessageDialog( this, "Only Music Together Or Music For Young Children Requires Period#.  Please Remove Period#.", "Invalid Information Entered", JOptionPane.ERROR_MESSAGE );
    		return;
    	}
    	
    	try {
    		Integer.parseInt( textFields[5].getText() );
    	}
    	catch( NumberFormatException nfe ) {
    		JOptionPane.showMessageDialog( this, "Incorrect Information Entered For Class Duration.", 
    			"Not Enough Information", JOptionPane.ERROR_MESSAGE );
    		return;
    	}
    	
    	
    	if( paid.isSelected() == true && discontinued.isSelected() == true ) {
    		JOptionPane.showMessageDialog( this, "Paid and Discontinued Check Boxes Can Not Be Both Selected", 
    			"Not Enough Information", JOptionPane.ERROR_MESSAGE );
    		return;
    	}
    	if( paid.isSelected() == true && ( dateMonthComboBox[12].getSelectedIndex() == 0 || dateDayComboBox[12].getSelectedIndex() == 0 || 
    			Double.parseDouble(textFields[2].getText()) == 0.0 ) ) {
    		JOptionPane.showMessageDialog( this, "Must Input Payment Made Information For Next Session If \"Paid\" Check Box Is Selected", 
    			"Not Enough Information", JOptionPane.ERROR_MESSAGE );
    		return;
    	}
    	for( int i = 0; i < 2; i++ ) {
    		if( dateMonthComboBox[i].getSelectedIndex() == 0 || dateDayComboBox[i].getSelectedIndex() == 0 ) {
    			JOptionPane.showMessageDialog( this, "Must Input Start And End Dates Of Current Session", 
    				"Not Enough Information", JOptionPane.ERROR_MESSAGE );
    			return;
    		}
    	}
    	for( int i = 8; i < 10; i++ ) {
    		if( (dateMonthComboBox[i].getSelectedIndex() == 0 || dateDayComboBox[i].getSelectedIndex() == 0) && discontinued.isSelected() != true ) {
    			JOptionPane.showMessageDialog( this, "Must Input Current Session Payment Date and Payment Alert Date", 
    				"Not Enough Information", JOptionPane.ERROR_MESSAGE );
    			return;
    		}
    	}
    	
    	
    	sip.sr.setInstructorName( textFields[0].getText().toUpperCase().trim() );
    	sip.sr.setClassType( comboBox.getSelectedIndex() );
    	sip.sr.setClassDay( classDayComboBox.getSelectedIndex() );
    	sip.sr.setClassTimeHour( timeHourComboBox.getSelectedIndex() );
    	sip.sr.setClassTimeMin( timeMinComboBox.getSelectedIndex() );
    	sip.sr.setClassTimeAMPM( timeAMPMComboBox.getSelectedIndex() );
    	sip.sr.setStartMonthCurrent( dateMonthComboBox[0].getSelectedIndex() );
    	sip.sr.setStartDayCurrent( dateDayComboBox[0].getSelectedIndex() );
    	sip.sr.setStartYearCurrent( dateYearComboBox[0].getSelectedIndex() );
    	sip.sr.setEndMonthCurrent( dateMonthComboBox[1].getSelectedIndex() );
    	sip.sr.setEndDayCurrent( dateDayComboBox[1].getSelectedIndex() );
    	sip.sr.setEndYearCurrent( dateYearComboBox[1].getSelectedIndex() );
    	sip.sr.setClassDuration( Integer.parseInt( textFields[5].getText().trim()) );
    	sip.sr.setClassPeriod( periodComboBox.getSelectedIndex() );
        
        sip.sr.setPaymentMonthCurrent( dateMonthComboBox[9].getSelectedIndex() );
    	sip.sr.setPaymentDayCurrent( dateDayComboBox[9].getSelectedIndex() );
    	sip.sr.setPaymentYearCurrent( dateYearComboBox[9].getSelectedIndex() );
    	//double d = new double( textFields[1].getText() );
    	sip.sr.setAmountPaidCurrent( Double.parseDouble(textFields[1].getText()) );
    	
        sip.sr.setNextPaymentMonth( dateMonthComboBox[8].getSelectedIndex() );
        sip.sr.setNextPaymentDay( dateDayComboBox[8].getSelectedIndex() );
        sip.sr.setNextPaymentYear( dateYearComboBox[8].getSelectedIndex() );
        sip.sr.setNextPaymentAmount( Double.parseDouble(textFields[3].getText()) );
        sip.sr.setNextPaymentPaid( paid.isSelected() );
        sip.sr.setNextPaymentDiscontinued( discontinued.isSelected() );
        sip.sr.setInvoiceSent( invoiceSent.isSelected() );
        
        sip.sr.setStartMonthNext( dateMonthComboBox[10].getSelectedIndex() );
    	sip.sr.setStartDayNext( dateDayComboBox[10].getSelectedIndex() );
    	sip.sr.setStartYearNext( dateYearComboBox[10].getSelectedIndex() );
    	sip.sr.setEndMonthNext( dateMonthComboBox[11].getSelectedIndex() );
    	sip.sr.setEndDayNext( dateDayComboBox[11].getSelectedIndex() );
    	sip.sr.setEndYearNext( dateYearComboBox[11].getSelectedIndex() );
        
        sip.sr.setPaymentMonthNext( dateMonthComboBox[12].getSelectedIndex() );
    	sip.sr.setPaymentDayNext( dateDayComboBox[12].getSelectedIndex() );
    	sip.sr.setPaymentYearNext( dateYearComboBox[12].getSelectedIndex() );
    	sip.sr.setAmountPaidNext( Double.parseDouble(textFields[2].getText()) );
    	sip.sr.setClassInfoComment( textFields[4].getText() );
    	if( registeredComboBox.getSelectedIndex() == 1 )
    		sip.sr.setIsRegistered( true );
    	else if ( registeredComboBox.getSelectedIndex() == 2 )
    		sip.sr.setIsRegistered( false );
    		
    	
    	
    	clearFields();
    	setVisible( false );
    	sip.setEnabled( true );
    	sip.setVisible( true );
    	sip.updateClassInfo();
    }
    
    private boolean changesMade() {
    
    	if( textFields[0].getText().toUpperCase().compareTo( sip.sr.getInstructorName() ) != 0 )
    		return true;
    	if( comboBox.getSelectedIndex() != sip.sr.getClassType() )
    		return true;
    	if( classDayComboBox.getSelectedIndex() != sip.sr.getClassDay() )
    		return true;
    	if( timeHourComboBox.getSelectedIndex() != sip.sr.getClassTimeHour() )
    		return true;
    	if( timeMinComboBox.getSelectedIndex() != sip.sr.getClassTimeMin() )
    		return true;
    	if( timeAMPMComboBox.getSelectedIndex() != sip.sr.getClassTimeAMPM() )
    		return true;
    	if( dateMonthComboBox[0].getSelectedIndex() != sip.sr.getStartMonthCurrent() )
    		return true;
    	if( dateDayComboBox[0].getSelectedIndex() != sip.sr.getStartDayCurrent() )
    		return true;
    	if( dateYearComboBox[0].getSelectedIndex() != sip.sr.getStartYearCurrent() )
    		return true;
    	if( dateMonthComboBox[1].getSelectedIndex() != sip.sr.getEndMonthCurrent() )
    		return true;
    	if( dateDayComboBox[1].getSelectedIndex() != sip.sr.getEndDayCurrent() )
    		return true;
    	if( dateYearComboBox[1].getSelectedIndex() != sip.sr.getEndYearCurrent() )
    		return true;        
        if( dateMonthComboBox[9].getSelectedIndex() != sip.sr.getPaymentMonthCurrent() )
        	return true;  
    	if( dateDayComboBox[9].getSelectedIndex() != sip.sr.getPaymentDayCurrent() )
    		return true;  
    	if( dateYearComboBox[9].getSelectedIndex() != sip.sr.getPaymentYearCurrent() )   
    		return true;    		
    	//
    		
    	
    	if( Double.parseDouble(textFields[1].getText()) != sip.sr.getAmountPaidCurrent() )    	
    		return true;  
        if( dateMonthComboBox[8].getSelectedIndex() != sip.sr.getNextPaymentMonth() )
        	return true;  
        if( dateDayComboBox[8].getSelectedIndex() != sip.sr.getNextPaymentDay() )
        	return true;  
        if( dateYearComboBox[8].getSelectedIndex() != sip.sr.getNextPaymentYear() )
        	return true;  
        if( Double.parseDouble(textFields[3].getText()) != sip.sr.getNextPaymentAmount() )
        	return true;  
        if( paid.isSelected() != sip.sr.getNextPaymentPaid() )
        	return true;  
        if( discontinued.isSelected() != sip.sr.getNextPaymentDiscontinued() )        
        	return true;  
        if( invoiceSent.isSelected() != sip.sr.getInvoiceSent() )
        	return true;
        if( dateMonthComboBox[10].getSelectedIndex() != sip.sr.getStartMonthNext() )
        	return true;  
    	if( dateDayComboBox[10].getSelectedIndex() != sip.sr.getStartDayNext() )
    		return true;  
    	if( dateYearComboBox[10].getSelectedIndex() != sip.sr.getStartYearNext() )
    		return true;  
    	//
    	if( dateMonthComboBox[11].getSelectedIndex() != sip.sr.getEndMonthNext() )
    		return true;  
    	if( dateDayComboBox[11].getSelectedIndex() != sip.sr.getEndDayNext() )
    		return true;  
    	if( dateYearComboBox[11].getSelectedIndex() != sip.sr.getEndYearNext() )        
    		return true;  
        if( dateMonthComboBox[12].getSelectedIndex() != sip.sr.getPaymentMonthNext() )
        	return true;  
    	if( dateDayComboBox[12].getSelectedIndex() != sip.sr.getPaymentDayNext() )
    		return true;  
    	if( dateYearComboBox[12].getSelectedIndex() != sip.sr.getPaymentYearNext() )
    		return true;  
    	if( Double.parseDouble(textFields[2].getText()) != sip.sr.getAmountPaidNext() )
    		return true;  
    	//System.out.println( "changesMade" );
    	if( textFields[4].getText().trim().compareTo( sip.sr.getClassInfoComment() ) != 0 )
    		return true;  
    	
    	
    	boolean tmpB = false;
    	if( registeredComboBox.getSelectedIndex() == 1 )
    		tmpB = true; //sip.sr.setIsRegistered( true );
    	else if ( registeredComboBox.getSelectedIndex() == 2 )
    		tmpB = false; //sip.sr.setIsRegistered( false );
    	if( tmpB != sip.sr.getIsRegistered() )
    		return true;
    		
    	return false;
    }
    
    public void viewEditClass() {
    System.out.println( "in viewEditClass" );
    	textFields[0].setText( sip.sr.getInstructorName().trim() );//sip.sr.setInstructorName( textFields[0].getText().trim() );
    	comboBox.setSelectedIndex( sip.sr.getClassType() );//sip.sr.setClassType( comboBox.getSelectedIndex() );
    	classDayComboBox.setSelectedIndex( sip.sr.getClassDay() );//sip.sr.setClassDay( classDayComboBox.getSelectedIndex() );
    	timeHourComboBox.setSelectedIndex( sip.sr.getClassTimeHour() );//sip.sr.setClassTimeHour( timeHourComboBox.getSelectedIndex() );
    	timeMinComboBox.setSelectedIndex( sip.sr.getClassTimeMin() ); //sip.sr.setClassTimeMin( timeMinComboBox.getSelectedIndex() );
    	timeAMPMComboBox.setSelectedIndex( sip.sr.getClassTimeAMPM() );//sip.sr.setClassTimeAMPM( timeAMPMComboBox.getSelectedIndex() );
    	dateMonthComboBox[0].setSelectedIndex( sip.sr.getStartMonthCurrent() ); //sip.sr.setStartMonthCurrent( dateMonthComboBox[0].getSelectedIndex() );
    	dateDayComboBox[0].setSelectedIndex( sip.sr.getStartDayCurrent() ); //sip.sr.setStartDayCurrent( dateDayComboBox[0].getSelectedIndex() );
    	dateYearComboBox[0].setSelectedIndex( sip.sr.getStartYearCurrent() ); //sip.sr.setEndYearCurrent( dateYearComboBox[0].getSelectedIndex() );
    	dateMonthComboBox[1].setSelectedIndex( sip.sr.getEndMonthCurrent() ); //sip.sr.setEndMonthCurrent( dateMonthComboBox[1].getSelectedIndex() );
    	dateDayComboBox[1].setSelectedIndex( sip.sr.getEndDayCurrent() ); //sip.sr.setEndDayCurrent( dateDayComboBox[1].getSelectedIndex() );
    	dateYearComboBox[1].setSelectedIndex( sip.sr.getEndYearCurrent() );
    	periodComboBox.setSelectedIndex( sip.sr.getClassPeriod() );
        textFields[5].setText( Integer.toString( sip.sr.getClassDuration()) );
    	
        dateMonthComboBox[9].setSelectedIndex( sip.sr.getPaymentMonthCurrent() ); //sip.sr.setPaymentMonthCurrent( dateMonthComboBox[9].getSelectedIndex() );
    	dateDayComboBox[9].setSelectedIndex( sip.sr.getPaymentDayCurrent() ); //sip.sr.setPaymentDayCurrent( dateDayComboBox[9].getSelectedIndex() );
    	dateYearComboBox[9].setSelectedIndex( sip.sr.getPaymentYearCurrent() );//sip.sr.setPaymentYearCurrent( dateMonthComboBox[9].getSelectedIndex() );
    	
    	textFields[1].setText( Double.toString(sip.sr.getAmountPaidCurrent()) ); //sip.sr.setAmountPaidCurrent( Double.parseDouble(textFields[1].getText()) );
    	
    	dateMonthComboBox[8].setSelectedIndex( sip.sr.getNextPaymentMonth() ); //sip.sr.setNextPaymentMonth( dateMonthComboBox[8].getSelectedIndex() );
    	dateDayComboBox[8].setSelectedIndex( sip.sr.getNextPaymentDay() ); //sip.sr.setNextPaymentMonth( dateDayComboBox[8].getSelectedIndex() );
    	dateYearComboBox[8].setSelectedIndex( sip.sr.getNextPaymentYear() ); //sip.sr.setNextPaymentMonth( dateMonthComboBox[8].getSelectedIndex() );
        
        textFields[3].setText( Double.toString(sip.sr.getNextPaymentAmount()) ); //sip.sr.setNextPaymentAmount( Double.parseDouble(textFields[3].getText()) );
        paid.setSelected( sip.sr.getNextPaymentPaid() ); //sip.sr.setNextPaymentPaid( radioButtons[0].isSelected() );
        discontinued.setSelected( sip.sr.getNextPaymentDiscontinued() ); //sip.sr.setNextPaymentDiscontinued( radioButtons[1].isSelected() );
        invoiceSent.setSelected( sip.sr.getInvoiceSent() );
        
        dateMonthComboBox[10].setSelectedIndex( sip.sr.getStartMonthNext() ); //sip.sr.setNextPaymentMonth( dateMonthComboBox[10].getSelectedIndex() );
    	dateDayComboBox[10].setSelectedIndex( sip.sr.getStartDayNext() ); //sip.sr.setNextPaymentMonth( dateDayComboBox[10].getSelectedIndex() );
    	dateYearComboBox[10].setSelectedIndex( sip.sr.getStartYearNext() ); //sip.sr.setNextPaymentMonth( dateMonthComboBox[10].getSelectedIndex() );
        
    	dateMonthComboBox[11].setSelectedIndex( sip.sr.getEndMonthNext() ); //sip.sr.setEndMonthNext( dateMonthComboBox[11].getSelectedIndex() );
    	dateDayComboBox[11].setSelectedIndex( sip.sr.getEndDayNext() ); //sip.sr.setEndDayNext( dateDayComboBox[11].getSelectedIndex() );
    	dateYearComboBox[11].setSelectedIndex( sip.sr.getEndYearNext() );//sip.sr.setEndYearNext( dateYearComboBox[11].getSelectedIndex() );
    	
    	dateMonthComboBox[12].setSelectedIndex( sip.sr.getPaymentMonthNext() ); //sip.sr.setPaymentMonthNext( dateMonthComboBox[12].getSelectedIndex() );
    	dateDayComboBox[12].setSelectedIndex( sip.sr.getPaymentDayNext() ); //sip.sr.setPaymentDayNext( dateDayComboBox[12].getSelectedIndex() );
    	dateYearComboBox[12].setSelectedIndex( sip.sr.getPaymentYearNext() );//sip.sr.setPaymentYearNext( dateYearComboBox[12].getSelectedIndex() );
    	
    	textFields[2].setText( Double.toString(sip.sr.getAmountPaidNext()) ); //sip.sr.setAmountPaidNext( Double.parseDouble(textFields[2].getText()) );
    	textFields[4].setText( sip.sr.getClassInfoComment().trim() );
    	if( sip.sr.getIsRegistered() == true )
    		registeredComboBox.setSelectedIndex( 1 );
    	else if ( sip.sr.getIsRegistered() == false )
    		registeredComboBox.setSelectedIndex( 2 );
    	setVisible( true );
    }
    
    public static void main( String args[] ) {
        ClassInfoPage cip = new ClassInfoPage();
		
        cip.addWindowListener(
            new WindowAdapter() {    		
                public void windowClosing( WindowEvent e ) {
                    System.exit(0);
	    		} 
        	}
		);
    }
}
