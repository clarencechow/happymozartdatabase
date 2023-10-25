import java.awt.image.BufferedImage;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import java.util.ArrayList;

public class Booklist extends JFrame {
	
	private ArrayList bookNames;
	private HomePage hp;
	private RandomAccessFile bl;
	private JTextField list[];
	private JTextField inputs[];
	private JTextField words[];
	private JButton forB, backB, addB, removeB, replaceB, backHome;
	private Container c = getContentPane();
	private int showNum;
	
	public Booklist() {
		
		super("books");
		bookNames = new ArrayList(0);
		list = new JTextField[40];
		inputs = new JTextField[4];
		words = new JTextField[3];
		addB = new JButton(new ImageIcon( "add_book.jpg" ));
		addB.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		replaceB = new JButton(new ImageIcon( "replace.jpg" ));
		replaceB.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		removeB = new JButton(new ImageIcon( "delete_book.jpg" ));
		removeB.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		forB = new JButton(new ImageIcon( "next.jpg"));
		forB.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		backB = new JButton(new ImageIcon("previous.jpg"));
		backB.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		backHome = new JButton( new ImageIcon( "home_page_icon_booklist.jpg" ) );
		backHome.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		try {
			setBookArray();
		} catch(IOException ioe) {
			JOptionPane.showMessageDialog( null, "Error Setting Booklist", 
    						"Error Thrown", JOptionPane.ERROR_MESSAGE );
    						System.exit(0);
		}
		for(int i = 0; i < inputs.length; i++) {
			if(i < 2)
				inputs[i] = new JTextField(30);
			else
				inputs[i] = new JTextField(3);
		}
		
		
		addB.addActionListener(
			new ActionListener() {
                public void actionPerformed(ActionEvent e) {
	                if(inputs[0].getText().trim().length() > 0) {
		                if(inputs[0].getText().trim().length() <= 30) {
			                System.out.println(inputs[0].getText());
			                addBook(inputs[0].getText().trim());
			                int num = ((bookNames.size()-1) / 20) * 20;
			                System.out.println(num);
			                showBooks(num);
			                inputs[0].setText("");
		                } else {
			                JOptionPane.showMessageDialog( null, "MAXIMUM 30 CHARACTERS", 
    						"Error", JOptionPane.ERROR_MESSAGE );
		                }
                	}
                }
            }
		);
		inputs[0].addActionListener(
			new ActionListener() {
                public void actionPerformed(ActionEvent e) {
	                if(inputs[0].getText().trim().length() > 0) {
		                if(inputs[0].getText().trim().length() <= 30) {
			                System.out.println(inputs[0].getText());
			                addBook(inputs[0].getText().trim());
			                int num = ((bookNames.size()-1) / 20) * 20;
			                System.out.println(num);
			                showBooks(num);
			                inputs[0].setText("");
		                } else {
			                JOptionPane.showMessageDialog( null, "MAXIMUM 30 CHARACTERS", 
    						"Error", JOptionPane.ERROR_MESSAGE );
		                }
                	}
                }
            }
		);
		
		replaceB.addActionListener(
			new ActionListener() {
                public void actionPerformed(ActionEvent e) {
	                if(inputs[1].getText().trim().length() > 0) {
			        	if(inputs[1].getText().length() <= 30) {
			                int entry = 0;
			                try {
					    		entry = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Entry Number to Replace", null));
					    	} catch( NumberFormatException nfe ) {
					    		JOptionPane.showMessageDialog(null, "ENTRY NUMBER MUST BE A NUMBER", "Error", 
					                     JOptionPane.ERROR_MESSAGE );
					    	}
						    if(entry > 0 && entry <= bookNames.size()) {
				                setBook(inputs[1].getText().trim(), entry-1);
				                int num = ((entry-1) / 20) * 20;
			                	showBooks(num);
			                	inputs[1].setText("");
		                	} else {
			                	JOptionPane.showMessageDialog( null, "ENTRY DOES NOT EXIST", 
    							"Error", JOptionPane.ERROR_MESSAGE );
		                	}
			            } else {
				                JOptionPane.showMessageDialog( null, "MAXIMUM 30 CHARACTERS", 
	    						"Error", JOptionPane.ERROR_MESSAGE );
			            }
	                }
                }
            }
		);
		inputs[1].addActionListener(
			new ActionListener() {
                public void actionPerformed(ActionEvent e) {
	                if(inputs[1].getText().trim().length() > 0) {
			        	if(inputs[1].getText().length() <= 30) {
			                int entry = 0;
			                try {
					    		entry = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Entry Number to Replace", null));
					    	} catch( NumberFormatException nfe ) {
					    		JOptionPane.showMessageDialog(null, "ENTRY NUMBER MUST BE A NUMBER", "Error", 
					                     JOptionPane.ERROR_MESSAGE );
					    	}
						    if(entry > 0 && entry <= bookNames.size()) {
				                setBook(inputs[1].getText().trim(), entry-1);
				                int num = ((entry-1) / 20) * 20;
			                	showBooks(num);
			                	inputs[1].setText("");
		                	} else {
			                	JOptionPane.showMessageDialog( null, "ENTRY DOES NOT EXIST", 
    							"Error", JOptionPane.ERROR_MESSAGE );
		                	}
			            } else {
				                JOptionPane.showMessageDialog( null, "MAXIMUM 30 CHARACTERS", 
	    						"Error", JOptionPane.ERROR_MESSAGE );
			            }
	                }
                }
            }
		);
		
		removeB.addActionListener(
			new ActionListener() {
                public void actionPerformed(ActionEvent e) {
	                try {
		                removeButtonMethod(inputs[2].getText().trim(), inputs[3].getText().trim());
	                } catch(NumberFormatException nfe) {
		                JOptionPane.showMessageDialog( null, "ENTRY MUST BE A NUMBER", 
    						"Error", JOptionPane.ERROR_MESSAGE );
	                }
	                inputs[2].setText("");
	                inputs[3].setText("");

	                if(showNum == 0 || showNum < bookNames.size())
	                	showBooks(showNum);
	                else
	                	showBooks(showNum-20);
                }
            }
        );
        
        forB.addActionListener(
			new ActionListener() {
                public void actionPerformed(ActionEvent e) {
	                if(showNum + 20 < bookNames.size())
		                showBooks(showNum+20);
                }
            }
        );

        backB.addActionListener(
			new ActionListener() {
                public void actionPerformed(ActionEvent e) {
	                if(showNum - 20 >= 0)
		                showBooks(showNum-20);
                }
            }
        );
        
        addWindowListener(
            new WindowAdapter() {    		
                public void windowClosing( WindowEvent e ) {
                    setVisible( false ); 
                    hp.setVisible( true );
                    hp.setEnabled( true );
                    clearText();
	    		} 
        	}
		);
		
		backHome.addActionListener(
			new ActionListener() {
                public void actionPerformed(ActionEvent e) {
	                setVisible( false ); 
                    hp.setVisible( true );
                    hp.setEnabled( true );
                    clearText();
                }
            }
        );
		
		
		SpringLayout layout = new SpringLayout();
		JPanel p = new JPanel(layout);
		Font f = new Font( "", Font.BOLD, 13 );
		c.add(p);
		p.setBackground( new Color(0, 128, 255) );
		
		for(int i = 0; i < list.length; i++) { //textfields
			if(i % 2 == 0)
				list[i] = new JTextField(3);
			else
				list[i] = new JTextField(28);
			list[i].setBackground( Color.WHITE );
			p.add(list[i]);
    		list[i].setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
    		list[i].setFont( f );
    		list[i].setEditable( false );
		}
		layout.putConstraint(SpringLayout.WEST, list[0], 2, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, list[0], 40, SpringLayout.NORTH, p);
		layout.putConstraint(SpringLayout.WEST, list[1], 5, SpringLayout.EAST, list[0]);
		layout.putConstraint(SpringLayout.NORTH, list[1], 40, SpringLayout.NORTH, p);
		layout.putConstraint(SpringLayout.WEST, list[2], 10, SpringLayout.EAST, list[1]);
		layout.putConstraint(SpringLayout.NORTH, list[2], 40, SpringLayout.NORTH, p);
		layout.putConstraint(SpringLayout.WEST, list[3], 5, SpringLayout.EAST, list[2]);
		layout.putConstraint(SpringLayout.NORTH, list[3], 40, SpringLayout.NORTH, p);
		for(int i = 4; i < list.length; i++) {
				layout.putConstraint(SpringLayout.WEST, list[i], 0, SpringLayout.WEST, list[i-4]);
				layout.putConstraint(SpringLayout.NORTH, list[i], 5, SpringLayout.SOUTH, list[i-4]);
		}
		for(int i = 0; i < inputs.length; i++) {
			inputs[i].setBackground( Color.WHITE );
			p.add(inputs[i]);
    		inputs[i].setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
    		inputs[i].setFont( f );
    		inputs[i].setEditable( true );
		}
		layout.putConstraint(SpringLayout.WEST, inputs[0], 15, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.SOUTH, inputs[0], -100, SpringLayout.SOUTH, p);
		layout.putConstraint(SpringLayout.EAST, inputs[1], -15, SpringLayout.EAST, p);
		layout.putConstraint(SpringLayout.SOUTH, inputs[1], -100, SpringLayout.SOUTH, p);
		layout.putConstraint(SpringLayout.WEST, inputs[2], 325, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.SOUTH, inputs[2], -50, SpringLayout.SOUTH, p);
		layout.putConstraint(SpringLayout.EAST, inputs[3], -325, SpringLayout.EAST, p);
		layout.putConstraint(SpringLayout.SOUTH, inputs[3], -50, SpringLayout.SOUTH, p);
		
		words[0] = new JTextField(10);
		words[0].setBackground(new Color(0, 128, 255));
		words[0].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		words[0].setFont(new Font( "", Font.BOLD, 35 ));
		words[0].setEditable( false );
		words[0].setText("Booklist");
		words[1] = new JTextField(3);
		words[1].setBackground(new Color(0, 128, 255));
		words[1].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		words[1].setFont(f);
		words[1].setEditable( false );
		words[1].setText(" to");
		words[2] = new JTextField(10);
		words[2].setBackground(new Color(0, 128, 255));
		words[2].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		words[2].setFont(f);
		words[2].setEditable( false );
		words[2].setText("");
		p.add(words[0]);
		p.add(words[1]);
		p.add(words[2]);
		layout.putConstraint(SpringLayout.WEST, words[0], 325, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.NORTH, words[0], 0, SpringLayout.NORTH, p);
		layout.putConstraint(SpringLayout.WEST, words[1], 17, SpringLayout.EAST, inputs[2]);
		layout.putConstraint(SpringLayout.NORTH, words[1], 0, SpringLayout.NORTH, inputs[2]);
		layout.putConstraint(SpringLayout.SOUTH, words[2], 1, SpringLayout.NORTH, list[3]);
		layout.putConstraint(SpringLayout.EAST, words[2], 0, SpringLayout.EAST, list[3]);
		
		p.add(addB); //buttons
		layout.putConstraint(SpringLayout.WEST, addB, 150, SpringLayout.WEST, inputs[0]);
		layout.putConstraint(SpringLayout.NORTH, addB, 4, SpringLayout.SOUTH, inputs[0]);
		
		p.add(replaceB);
		layout.putConstraint(SpringLayout.WEST, replaceB, 150, SpringLayout.WEST, inputs[1]);
		layout.putConstraint(SpringLayout.NORTH, replaceB, 4, SpringLayout.SOUTH, inputs[1]);
		
		p.add(removeB);
		layout.putConstraint(SpringLayout.WEST, removeB, 30, SpringLayout.WEST, inputs[2]);
		layout.putConstraint(SpringLayout.NORTH, removeB, 4, SpringLayout.SOUTH, inputs[2]);
		
		p.add(forB);
		layout.putConstraint(SpringLayout.EAST, forB, 10, SpringLayout.EAST, inputs[1]);
		layout.putConstraint(SpringLayout.SOUTH, forB, -10, SpringLayout.NORTH, inputs[1]);
		
		p.add(backB);
		layout.putConstraint(SpringLayout.WEST, backB, -10, SpringLayout.WEST, inputs[0]);
		layout.putConstraint(SpringLayout.SOUTH, backB, -10, SpringLayout.NORTH, inputs[0]);
		
		p.add(backHome);
		layout.putConstraint(SpringLayout.WEST, backHome, 5, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.SOUTH, backHome, -5, SpringLayout.SOUTH, p);
		
		setSize(800, 500);
		setResizable( false );
		
	}
	
	public void removeButtonMethod(String s1, String s2) throws NumberFormatException {
		int entry1 = 0, entry2 = 0;
		if(s1.length() > 0 && s2.length() > 0) {
			entry1 = Integer.parseInt( s1 );
			entry2 = Integer.parseInt( s2 );
			if(entry1 <= entry2) {
				if(entry2 <= bookNames.size() && entry1 > 0) {
					for(int i = 0; i < entry2-entry1+1; i++) {
						removeBook(entry1-1);
					}
				} else {
					JOptionPane.showMessageDialog( null, "ENTRY DOES NOT EXIST", 
    				"Error", JOptionPane.ERROR_MESSAGE );
    				return;
				}
			} else {
				JOptionPane.showMessageDialog( null, "1ST ENTRY CANNOT BE LARGER THAN 2ND", 
    			"Error", JOptionPane.ERROR_MESSAGE );
    			return;
			}
		} else if(s1.length() > 0) {
			entry1 = Integer.parseInt( s1 );
			if(entry1 <= bookNames.size() && entry1 > 0) {
				removeBook(entry1-1);
			} else { 
				JOptionPane.showMessageDialog( null, "ENTRY DOES NOT EXIST", 
				"Error", JOptionPane.ERROR_MESSAGE );
				return;
			}
		} else if(s2.length() > 0) {
			entry1 = Integer.parseInt( s2 );
			if(entry1 <= bookNames.size() && entry1 > 0) {
				removeBook(entry1-1);
			} else { 
				JOptionPane.showMessageDialog( null, "ENTRY DOES NOT EXIST", 
				"Error", JOptionPane.ERROR_MESSAGE );
				return;
			}
		}
	}
		
	public void setBookArray() throws IOException {
		
		System.out.println("1");
		if(bl == null)
			setRAF();
		System.out.println("1");
		bl.seek(0);
		System.out.println("1");
		int entries = bl.readInt();
		System.out.println("1");
		bl.seek(10);
		System.out.println("1");
		for(int i = 0; i < entries; i++) {
			bookNames.add(readString(bl, 30).trim());
		}
		System.out.println("1");
	}
	public void updateBookList() throws IOException {
		if(bl == null)
			setRAF();
		bl.seek(0);
		bl.writeInt(bookNames.size());
		bl.seek(10);
		for(int i = 0; i < bookNames.size(); i++) {
			writeString(bl, bookNames.get(i).toString(), 30);
		}
	}
	public void addBook(String b) {
		System.out.println("ok");
		bookNames.add(b);
		System.out.println("ok");
		try {
			updateBookList();
		} catch(IOException ioe) {
			System.out.println("update book failed");
		}
	}
	public void setBook(String b, int i) {
		bookNames.set(i, b);
		try {
			updateBookList();
		} catch(IOException ioe) {
			System.out.println("update book failed");
		}
	}
	public void removeBook(int i) {
		bookNames.remove(i);
		try {
			updateBookList();
		} catch(IOException ioe) {
			System.out.println("update book failed");
		}
	}
	public String getBook(int i) {
		return bookNames.get(i).toString();
	}
	public int getBookCount() {
		return bookNames.size();
	}
	public void setRAF() throws IOException {
		bl = new RandomAccessFile("BookList.txt", "rw");
	}
	public void setHomePage(HomePage h) {
		hp = h;
	}
	
	public void showBooks(int start) {
		clearText();
		for(int i = start; i < bookNames.size() && i < start + 20; i++) {
			int ind = i % 20;
			String s = "" + (i+1);
			list[ind*2].setText(s);
			list[ind*2+1].setText(getBook(i));
		}
		showNum = start;
		words[2].setText("Total Books: " + bookNames.size());
	}
	public void clearText() {
		for(int i = 0; i < list.length; i++) {
			list[i].setText("");
		}
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
	
    public static void main( String args[] ) {
        Booklist boli = new Booklist();
		
        boli.addWindowListener(
            new WindowAdapter() {    		
                public void windowClosing( WindowEvent e ) {
                    System.exit(0);
	    		} 
        	}
		);
    }
}