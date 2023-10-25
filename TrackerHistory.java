import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TrackerHistory extends JFrame {
	private RandomAccessFile output;
	private JTextArea textArea;
	private JButton buttons[];
	private Container c = getContentPane();		
	private JPanel panel;
	private String firstName, lastName;
	private Icon deleteIcon, closeIcon;
	private String buttonNames[] = { "Close", "Delete Entry" };		
	
	//clarence stuff
	private JButton deleteBookButton;					

    public TrackerHistory() {
        super( "Tracker History" );
		buttons = new JButton[2];
		textArea = new JTextArea( 25, 40 );
		panel = new JPanel();
		firstName = "";
		lastName = "";
		closeIcon = new ImageIcon( "close_icon.jpg" );
        deleteIcon = new ImageIcon( "delete_icon.jpg" );
		
        //for( int i = 0; i < buttons.length; i++ ) {
        //	buttons[i] = new JButton( buttonNames[i] );
        //}
        buttons[0] = new JButton( buttonNames[0], closeIcon );
        buttons[1] = new JButton( buttonNames[1], deleteIcon );
        
        //clarence stuff
        deleteBookButton = new JButton("Delete Book", deleteIcon);
        
        addWindowListener(
            new WindowAdapter() {    		
                public void windowClosing( WindowEvent e ) {
                	firstName = "";
                	lastName = "";
                	textArea.setText( "" );
                    setVisible( false );
	    		} 
        	}
		);
		
        buttons[0].addActionListener(				// Save Info Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	firstName = "";
                	lastName = "";
                	textArea.setText( "" );
                    setVisible( false );
                }
            }
        );
        
        buttons[1].addActionListener(				// Close w/o Change Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	
                		
                	try {
                    	deleteEntry();
                   	}
                   	catch( IOException ioe ) {
                   		JOptionPane.showMessageDialog( null, "Error @ deleteEntry: Class TrackerHistory.java", 
    						"Error Thrown", JOptionPane.ERROR_MESSAGE );
                   	}		
    			                    
                }
            }
        );
        
        //clarence stuff
        deleteBookButton.addActionListener(				// Close w/o Change Button Pressed
            new ActionListener() {                                   
                public void actionPerformed(ActionEvent e) {
                	
                		
                	try {
                    	deleteBook();
                   	}
                   	catch( IOException ioe ) {
                   		JOptionPane.showMessageDialog( null, "Error @ deleteBook: Class TrackerHistory.java", 
    						"Error Thrown", JOptionPane.ERROR_MESSAGE );
                   	}		
    			                    
                }
            }
        );
		
        c.add( new JScrollPane( textArea), BorderLayout.NORTH );
        textArea.setEditable( false );
        textArea.setFont( new Font( "monospaced", Font.BOLD, 12 ));
    	textArea.setTabSize( 29 );
    	
        panel.add(deleteBookButton);
        panel.add( buttons[0] );
        panel.add( buttons[1] );
        c.add( panel, BorderLayout.SOUTH );
        
        setSize( 700, 530 );
        
        setResizable( false );
        //show();


    }
    
    public void deleteEntry() throws IOException {
    	String fileName = "", tempString = "";
    	int recordCount = 0, entry;
    	double tempAmount = 0.0;
    	int tempMonth = 0, tempYear = 0;
    	
    	String entryNumber = JOptionPane.showInputDialog( "Enter The Entry Number To Be Removed From Tracker History" );
        System.out.println("entryNumber: " + entryNumber );
        if( entryNumber == null ) 
        	return;
        if( entryNumber.compareTo( "" ) == 0 ) {
        	JOptionPane.showMessageDialog( null, "You Must Enter A Number", 
    						"Entry Not Removed", JOptionPane.PLAIN_MESSAGE );
        	return;
        }
        
        try {        	
        	entry = Integer.parseInt( entryNumber );
       	} catch( NumberFormatException nfe ) {
       		JOptionPane.showMessageDialog( null, "You Must Enter A Number", 
    						"Entry Not Removed", JOptionPane.ERROR_MESSAGE );
        	return;
       	}
    	fileName = firstName + "-" + lastName + ".txt";
    	openFile( fileName );
    	
    	output.seek( 0 );
    	recordCount = output.readInt();
    	
    	if( recordCount == 0 || entry > recordCount || entry < 1 ) {
    		JOptionPane.showMessageDialog( null, "Unable To Remove Entry.  Entry Number Might Be Incorrect.", 
    						"Entry Not Removed", JOptionPane.PLAIN_MESSAGE );
    		return;
    	}
    	
    	if( entry == 1 && recordCount == 1 ) {
    		output.seek( 0 );
    		output.writeInt ( 0 );
    		printTrackerHistory( firstName, lastName );
    		return;
    	}
    	
    	for( int i = entry; i < recordCount; i++ ) {
    		output.seek( i * 3000 + 10 );
    		tempString = readString( output, 2000 ).trim();
    		
    		output.seek( (i - 1) * 3000 + 10 );
    		writeString( output, tempString, 2000 );
    	}
    	output.seek( 0 );
    	output.writeInt( recordCount - 1 );
    	closeFile();
    	//print tracker history again to update textarea
    	printTrackerHistory( firstName, lastName );
    	
    }
    
    //clarence stuff
    public void deleteBook() throws IOException {
    	String fileName = "", tempBook = "";
    	int recordCount = 0, entry;
    	
    	String entryNumber = JOptionPane.showInputDialog( "Enter The Book Number To Be Removed From Tracker History" );
        System.out.println("entryNumber: " + entryNumber );
        if( entryNumber == null ) 
        	return;
        if( entryNumber.compareTo( "" ) == 0 ) {
        	JOptionPane.showMessageDialog( null, "You Must Enter A Number", 
    						"Book Not Removed", JOptionPane.PLAIN_MESSAGE );
        	return;
        }
        
        try {        	
        	entry = Integer.parseInt( entryNumber );
       	} catch( NumberFormatException nfe ) {
       		JOptionPane.showMessageDialog( null, "You Must Enter A Number", 
    						"Book Not Removed", JOptionPane.ERROR_MESSAGE );
        	return;
       	}
    	fileName = firstName + "-" + lastName + ".txt";
    	openFile( fileName );
    	
    	output.seek( 1000000 );
    	recordCount = output.readInt();
    	
    	if( recordCount == 0 || entry > recordCount || entry < 1 ) {
    		JOptionPane.showMessageDialog( null, "Unable To Remove Book.  Book Number Might Be Incorrect.", 
    						"Book Not Removed", JOptionPane.PLAIN_MESSAGE );
    		return;
    	}
    	
    	if( entry == 1 && recordCount == 1 ) {
    		output.seek( 1000000 );
    		output.writeInt ( 0 );
    		printTrackerHistory( firstName, lastName );
    		return;
    	}
    	
    	for( int i = entry; i < recordCount; i++ ) {
    		output.seek( i * 80 + 1000010 );
    		tempBook = readString( output, 40 ).trim();
    		
    		output.seek( (i - 1) * 80 + 1000010 );
    		writeString( output, tempBook, 40 );
    	}
    	output.seek( 1000000 );
    	output.writeInt( recordCount - 1 );
    	closeFile();
    	//print tracker history again to update textarea
    	printTrackerHistory( firstName, lastName );
    	
    }
    
    public void printTrackerHistory( String first, String last ) throws IOException {
    	String fileName = "", trackerInfo = "";
    	int recordCount = 0;
    	firstName = first;
    	lastName = last;
    	
    	fileName = firstName + "-" + lastName + ".txt";
    	openFile( fileName );
    	
    	output.seek( 0 );
    	recordCount = output.readInt();
    	
    	trackerInfo += "                           $$Tracker History for " + first + " " + last + "$$\n";
    	if( recordCount == 0 ) 
    		trackerInfo += "No Entries In Tracker History";
  
    	
    	for( int i = 0; i < recordCount; i++ ) {
    		output.seek( i * 3000 + 10 );
    		trackerInfo += "**Entry " + ( i + 1 ) + "**\n" + readString( output, 2000 ).trim() + "\n\n";
    	}
    	
    	//clarence stuff
    	int numSavedBooks = 0;
    	String temp = "";
    	output.seek(1000000);
    	try {
	    	numSavedBooks = output.readInt();
    	} catch(IOException ioe) {
	    	System.out.println("no int at 1mil");
	    	numSavedBooks = 0;
    	}
    	trackerInfo += "*************BOOKS*************BOOKS*************BOOKS*************\n\n";
    	output.seek(1000010);
    	System.out.println(numSavedBooks);
    	for(int i = 0; i < numSavedBooks; i++) {
	    	temp = readString(output, 40).trim();
	    	trackerInfo += "(" + (i+1) + ") " + temp;
	    	if(i % 2 == 1)
	    		trackerInfo += "\n";
	    	else
	    		trackerInfo += "                    ";
	    	System.out.println(temp);
    	}
    	
    	textArea.setText( trackerInfo );
    	
    	textArea.setCaretPosition( 0 );
    	setVisible( true );
    	closeFile();
    	
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
    
    private String readString( RandomAccessFile f, int l ) throws IOException {
        char str[] = new char[ l ], tmp;

        for( int i = 0; i < str.length; i++ ) {
            tmp = f.readChar();
            str[ i ] = tmp;
        }

        return new String( str ).replace( '\0', ' ' );
    }
    
    private void openFile( String s ) {
        try {
        System.out.println( "String in openfile: " + s );
            output = new RandomAccessFile( s, "rw" );
        } catch ( IOException e ) {
            JOptionPane.showMessageDialog(this, "ClassInfoPage:OpenFile File does not exist", "Invalid File Name", 
                                          JOptionPane.ERROR_MESSAGE );
        }
    }
    
    private void closeFile() {
        try {
            output.close();
            //output = null;
        } catch ( IOException ex ) {
            JOptionPane.showMessageDialog(this, "Error closing file", "Error", 
                                          JOptionPane.ERROR_MESSAGE );
        }
    }
    
    public static void main( String args[] ) {
        TrackerHistory th = new TrackerHistory();
		
        th.addWindowListener(
            new WindowAdapter() {    		
                public void windowClosing( WindowEvent e ) {
                    System.exit(0);
	    		} 
        	}
		);
    }
}