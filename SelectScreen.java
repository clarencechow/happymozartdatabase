import java.awt.image.BufferedImage;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SelectScreen extends JFrame {
	private RandomAccessFile output;
	private JPanel panels[];
	private JLabel labels[];
	private JButton buttons[];
	private JComboBox combo[];
	private Container c = getContentPane();		
	private Icon trackerHistoryIcon, saveIcon, closeIcon, inputIcon;
	private Icon pictureIcon, happyMozartIcon;	
	private JLabel pictureLabel, happyMozartLabel;		
	private JTextArea textArea[];	
	private StudentRecord sr;
	private int pointer = 0;
	private String classDays[] = { "", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
        "Sunday", };
    private String timeHours[] = { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    private String timeMins[] = { "00", "15", "30", "45" };
    private String timeAMPM[] = { "AM", "PM" };
    //private NewStudentInfoPage nsip;
    private HomePage hp;
    private NewClassTracker nct;
    private int srArray[];
    private JButton forwardButton, backwardButton, cancelButton;
    private int matchCount;

    public SelectScreen() {
        super( "Select Screen" );
        textArea = new JTextArea[6];
		buttons = new JButton[6];
		labels = new JLabel[6];
		panels = new JPanel[6];
        Font f = new Font( "", Font.BOLD, 9 );
        sr = new StudentRecord();
        happyMozartLabel = new JLabel( new ImageIcon( "happy_mozart_icon3.jpg" ));
        forwardButton = new JButton( new ImageIcon( "forward1.jpg" ) );
        backwardButton = new JButton( new ImageIcon( "backward1.jpg" ) );
        cancelButton = new JButton( new ImageIcon( "cancel_icon.jpg" ) );
        //nsip = new NewStudentInfoPage();
        //hp = new HomePage();
        
        for( int i = 0; i < 6; i++ ) {
        	buttons[i] = new JButton();
        	labels[i] = new JLabel();
        	panels[i] = new JPanel();
        	textArea[i] = new JTextArea();
        	buttons[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        	panels[i].setBackground( new Color( 243, 198, 196 ) );
        	panels[i].setPreferredSize( new Dimension( 250, 100 ) );
        	textArea[i].setFont( f );
        	textArea[i].setPreferredSize( new Dimension( 150, 80 ) );
        	textArea[i].setBackground( new Color( 243, 198, 196 ) );
        	textArea[i].setForeground( new Color( 150, 77, 41 ) );
        	textArea[i].setEditable( false );
        }
        
        
		
        addWindowListener(
            new WindowAdapter() {    		
                public void windowClosing( WindowEvent e ) {
                    	setVisible( false ); 
                    	hp.setVisible( true );
                    	hp.setEnabled( true );
	    		} 
        	}
		);
		
		forwardButton.addActionListener(				// Save Info Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	//System.out.println( "picture clicked" );
                	try {
                		if( (pointer+6) < matchCount ) {
                			pointer = pointer + 6;
                			Selections( false );
                		}
                	}
                	catch( IOException ioe ) {
                		JOptionPane.showMessageDialog(null, "IOException @ Selections:SelectScreen", 
    						"Invalid Format", JOptionPane.ERROR_MESSAGE );
    					return;
                	}
                }
            }
        );
        
        backwardButton.addActionListener(				// Save Info Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	//System.out.println( "picture clicked" );
                	try {
                		if( (pointer-6) >= 0 ) {
                			pointer = pointer - 6;
                			Selections( false );
                		}
                	}
                	catch( IOException ioe ) {
                		JOptionPane.showMessageDialog(null, "IOException @ Selections:SelectScreen", 
    						"Invalid Format", JOptionPane.ERROR_MESSAGE );
    					return;
                	}
                }
            }
        );
        
        buttons[0].addActionListener(				// Save Info Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	//System.out.println( "picture clicked" );
                	try {
                		nct.viewNewClassTracker( srArray[pointer] );
                		setVisible( false );
                		nct.setVisible( true );
                	}
                	catch( IOException ioe ) {
                		JOptionPane.showMessageDialog(null, "IOException @ viewNewClassTracker:NewClassTracker", 
    						"Invalid Format", JOptionPane.ERROR_MESSAGE );
    					return;
                	}
                }
            }
        );
        
        buttons[1].addActionListener(				// Close w/o Change Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	try {
                		nct.viewNewClassTracker( srArray[pointer+1] );
                		setVisible( false );
                		nct.setVisible( true );
                	}
                	catch( IOException ioe ) {
                		JOptionPane.showMessageDialog(null, "IOException @ viewNewClassTracker:NewClassTracker", 
    						"Invalid Format", JOptionPane.ERROR_MESSAGE );
    					return;
                	}
                }
            }
        );
        
        buttons[2].addActionListener(				// Time Stamp Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                    try {
                		nct.viewNewClassTracker( srArray[pointer+2] );
                		setVisible( false );
                		nct.setVisible( true );
                	}
                	catch( IOException ioe ) {
                		JOptionPane.showMessageDialog(null, "IOException @ viewNewClassTracker:NewClassTracker", 
    						"Invalid Format", JOptionPane.ERROR_MESSAGE );
    					return;
                	}
                }
            }
        );
        
        buttons[3].addActionListener(				// save to history Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	try {
                		nct.viewNewClassTracker( srArray[pointer+3] );
                		setVisible( false );
                		nct.setVisible( true );
                	}
                	catch( IOException ioe ) {
                		JOptionPane.showMessageDialog(null, "IOException @ viewNewClassTracker:NewClassTracker", 
    						"Invalid Format", JOptionPane.ERROR_MESSAGE );
    					return;
                	}
                }
            }
        );
        
        buttons[4].addActionListener(				// save to history Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	try {
                		nct.viewNewClassTracker( srArray[pointer+4] );
                		setVisible( false );
                		nct.setVisible( true );
                	}
                	catch( IOException ioe ) {
                		JOptionPane.showMessageDialog(null, "IOException @ viewNewClassTracker:NewClassTracker", 
    						"Invalid Format", JOptionPane.ERROR_MESSAGE );
    					return;
                	}
                }
            }
        );
        
        buttons[5].addActionListener(				// save to history Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	try {
                		nct.viewNewClassTracker( srArray[pointer+5] );
                		setVisible( false );
                		nct.setVisible( true );
                	}
                	catch( IOException ioe ) {
                		JOptionPane.showMessageDialog(null, "IOException @ viewNewClassTracker:NewClassTracker", 
    						"Invalid Format", JOptionPane.ERROR_MESSAGE );
    					return;
                	}
                }
            }
        );
        
        cancelButton.addActionListener(				// save to history Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	setVisible( false ); 
                    hp.setVisible( true );
                    hp.setEnabled( true );
                }
            }
        );
        
        //String[] labels = {"Name: ", "Fax: ", "Email: ", "Address: "};
		//int numPairs = labels.length;

		//Create and populate the panel.
		SpringLayout layout = new SpringLayout();
		JPanel p = new JPanel(layout);
		
		p.add( happyMozartLabel );
		layout.putConstraint(SpringLayout.NORTH, happyMozartLabel, 10, SpringLayout.NORTH, p);
    	layout.putConstraint(SpringLayout.WEST, happyMozartLabel, 20, SpringLayout.WEST, p);
		
		p.add( panels[0] );
		layout.putConstraint(SpringLayout.NORTH, panels[0], 50, SpringLayout.NORTH, p);
    	layout.putConstraint(SpringLayout.WEST, panels[0], 40, SpringLayout.WEST, p);
    	p.add( panels[1] );
    	layout.putConstraint(SpringLayout.NORTH, panels[1], 20, SpringLayout.SOUTH, panels[0]);
    	layout.putConstraint(SpringLayout.WEST, panels[1], 40, SpringLayout.WEST, p);
    	p.add( panels[2] );
    	layout.putConstraint(SpringLayout.NORTH, panels[2], 20, SpringLayout.SOUTH, panels[1]);
    	layout.putConstraint(SpringLayout.WEST, panels[2], 40, SpringLayout.WEST, p);
    	
    	p.add( panels[3] );
    	layout.putConstraint(SpringLayout.NORTH, panels[3], 50, SpringLayout.NORTH, p);
    	layout.putConstraint(SpringLayout.WEST, panels[3], 20, SpringLayout.EAST, panels[0]);
    	p.add( panels[4] );
    	layout.putConstraint(SpringLayout.NORTH, panels[4], 20, SpringLayout.SOUTH, panels[3]);
    	layout.putConstraint(SpringLayout.WEST, panels[4], 20, SpringLayout.EAST, panels[0]);
    	p.add( panels[5] );
    	layout.putConstraint(SpringLayout.NORTH, panels[5], 20, SpringLayout.SOUTH, panels[4]);
    	layout.putConstraint(SpringLayout.WEST, panels[5], 20, SpringLayout.EAST, panels[0]);
    	
    	p.add( backwardButton );
    	backwardButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    	layout.putConstraint(SpringLayout.NORTH, backwardButton, 30, SpringLayout.NORTH, panels[1]);
    	layout.putConstraint(SpringLayout.WEST, backwardButton, 0, SpringLayout.WEST, p);
    	p.add( forwardButton );
    	forwardButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    	layout.putConstraint(SpringLayout.NORTH, forwardButton, 30, SpringLayout.NORTH, panels[4]);
    	layout.putConstraint(SpringLayout.WEST, forwardButton, 5, SpringLayout.EAST, panels[4]);
    	
    	p.add( cancelButton );
    	cancelButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    	layout.putConstraint(SpringLayout.NORTH, cancelButton, 30, SpringLayout.SOUTH, panels[2]);
    	layout.putConstraint(SpringLayout.WEST, cancelButton, -55, SpringLayout.EAST, panels[2]);
    	
    	/*p.add( textArea[0] );
    	layout.putConstraint(SpringLayout.NORTH, textArea[0], 10, SpringLayout.NORTH, panels[0]);
    	layout.putConstraint(SpringLayout.WEST, textArea[0], 95, SpringLayout.WEST, panels[0]);
    	p.add( textArea[1] );
    	layout.putConstraint(SpringLayout.NORTH, textArea[1], 10, SpringLayout.NORTH, panels[1]);
    	layout.putConstraint(SpringLayout.WEST, textArea[1], 95, SpringLayout.WEST, panels[1]);
    	p.add( textArea[2] );
    	layout.putConstraint(SpringLayout.NORTH, textArea[2], 10, SpringLayout.NORTH, panels[2]);
    	layout.putConstraint(SpringLayout.WEST, textArea[2], 95, SpringLayout.WEST, panels[2]);
    	
    	p.add( textArea[3] );
    	layout.putConstraint(SpringLayout.NORTH, textArea[3], 10, SpringLayout.NORTH, panels[3]);
    	layout.putConstraint(SpringLayout.WEST, textArea[3], 95, SpringLayout.WEST, panels[3]);
    	p.add( textArea[4] );
    	layout.putConstraint(SpringLayout.NORTH, textArea[4], 10, SpringLayout.NORTH, panels[4]);
    	layout.putConstraint(SpringLayout.WEST, textArea[4], 95, SpringLayout.WEST, panels[4]);
    	p.add( textArea[5] );
    	layout.putConstraint(SpringLayout.NORTH, textArea[5], 10, SpringLayout.NORTH, panels[5]);
    	layout.putConstraint(SpringLayout.WEST, textArea[5], 95, SpringLayout.WEST, panels[5]);
    	*/
    	//p.add( buttons[0] );
    	//layout.putConstraint(SpringLayout.NORTH, buttons[0], 10, SpringLayout.NORTH, panels[0]);
    	//layout.putConstraint(SpringLayout.WEST, buttons[0], 10, SpringLayout.WEST, panels[0]);
		panels[0].add( buttons[0], BorderLayout.WEST );
		panels[0].add( textArea[0], BorderLayout.EAST );
		panels[1].add( buttons[1], BorderLayout.WEST );
		panels[1].add( textArea[1], BorderLayout.EAST );
		panels[2].add( buttons[2], BorderLayout.WEST );
		panels[2].add( textArea[2], BorderLayout.EAST );
		panels[3].add( buttons[3], BorderLayout.WEST );
		panels[3].add( textArea[3], BorderLayout.EAST );
		panels[4].add( buttons[4], BorderLayout.WEST );
		panels[4].add( textArea[4], BorderLayout.EAST );
		panels[5].add( buttons[5], BorderLayout.WEST );
		panels[5].add( textArea[5], BorderLayout.EAST );
    	
        p.setBackground( Color.WHITE );
        c.setBackground( Color.WHITE );
        c.add( p );
        setSize( 610, 500 );
        
        int a[] = new int[1];
        a[0] = 0;
        /*
        try {
        	Selections( a );
        }
        catch( IOException ioe ) {
        	JOptionPane.showMessageDialog(this, "IOException in Selection: SelectionScreen.java", 
    			"Invalid Format", JOptionPane.ERROR_MESSAGE );
    		return;
    	}
        */
        setResizable( false );
        //show();


    }
    public void setArrayAndMatchCount( int[] srNumber, int m ) {
    	matchCount = m;
    	srArray = new int[srNumber.length];
    	srArray = srNumber;
    	pointer = 0;
    }
    
    public void Selections( boolean idMatch ) throws IOException {
    	ImageIcon ii;
    	BufferedImage bi;
    	int counter = 0;
    	String tempString = "";
    	
    	if( output == null )
    		openFile();
    	//System.out.println( "1" );
    	for( int i = 0; i < 6; i++ ) {
    		buttons[i].removeAll();
    	}
    	//System.out.println( "2" );
    	//System.out.println( "count = " + count );
    	if( idMatch == true ) {
    		nct.viewNewClassTracker( srArray[pointer] );
    		setVisible( false );
    		nct.setVisible( true );
    		nct.buttons[0].doClick();
    		return;
    	}
    	if( matchCount == 1 ) {
    		nct.viewNewClassTracker( srArray[pointer] );
            setVisible( false );
            nct.setVisible( true );
            return;
        }
                		
    	for( int i = pointer; i < (pointer+6) && i < matchCount; i++ ) {
    		output.seek( srArray[i] * sr.size() + 10 );
    		sr.read( output );
    		
    		ii = new ImageIcon( "pictures\\" + sr.getPictureName().trim() );
        	bi = new BufferedImage(70, 85, BufferedImage.TYPE_INT_ARGB);
			bi.getGraphics().drawImage(ii.getImage(), 0, 0, 70, 85, null);
			buttons[counter].setIcon( new ImageIcon( bi ) );
			buttons[counter].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			
			if( sr.getTelephoneNumber().length() == 10 )
				tempString = sr.getTelephoneNumber();
			else if( sr.getCellPhoneNumber().length() == 10 )
				tempString = sr.getCellPhoneNumber();
			textArea[counter].setText( sr.getFirstName() + " " + sr.getLastName() + "\n\n" +
										sr.getClassName() + "\n" +
										classDays[sr.getClassDay()] + ", " + sr.getClassTimeHour() + ":" + timeMins[sr.getClassTimeMin()] + 
												timeAMPM[sr.getClassTimeAMPM()] + " (" + sr.getClassDuration() + "min)" + "\n" +
										tempString.substring(0, 3) + "-" + tempString.substring(3, 6) + "-" + tempString.substring(6));
			
			counter++;
			//System.out.println("3" );
    	}
    	for( int i = counter; i < 6; i++ ) {
    		buttons[i].setIcon( new ImageIcon( "" ) );
    		textArea[i].setText("" );
    	}
    	//System.out.println( "4" );
    	//closeFile();
    }
    
    public void setNewClassTracker( NewClassTracker n) {
    	nct = n; 
    }
    public void setHomePage( HomePage h ) {
    	hp = h;
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
            //System.exit( 0 );
        } catch ( IOException ex ) {
            JOptionPane.showMessageDialog(this, "Error closing file", "Error", 
                                          JOptionPane.ERROR_MESSAGE );
            System.exit( 1 );
        }
    }
    
    public static void main( String args[] ) {
        SelectScreen ss = new SelectScreen();
		
        ss.addWindowListener(
            new WindowAdapter() {    		
                public void windowClosing( WindowEvent e ) {
                    System.exit(0);
	    		} 
        	}
		);
    }
}