import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import javax.swing.JTextArea;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.Container;
import java.awt.image.ImageObserver;
import java.awt.Graphics;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.io.RandomAccessFile;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

public class HomePage extends JFrame
{
    private JTable table;
    private JScrollPane scroller;
    private JPanel buttonPanel;
    private JPanel radioButtonPanel;
    private JPanel searchPanel;
    private JPanel radioPanel1;
    private JPanel radioPanel2;
    private JPanel radioPanel3;
    private JPanel searchListPanel;
    private JPanel iconPanel;
    private JButton[] buttons;
    private JButton search;
    private JButton scanButton;
    private JButton newStudentButton;
    private JButton newTeacherButton;
    private JButton makeupListButton;
    private JButton administratorButton;
    private JButton deleteRecordButton;
    private JButton administratorSmileButton;
    private JButton searchInactiveButton;
    private JButton enrollmentFeeButton;
    private JLabel label;
    private JLabel label2;
    private String[] birthdayYears;
    private String[] dateMonths;
    private String[] dateDays;
    private String[] dateYears;
    private String[] buttonNames;
    private JRadioButton[] radioButtons;
    private String[] radioButtonNames;
    private String[] comboBoxNames;
    String[] columnNames;
    private String[] classDays;
    private JComboBox comboBox;
    private GridBagLayout gbLayout;
    private GridBagConstraints gbConstraints;
    private StudentRecord sr;
    private NewStudentInfoPage nsip;
    private RandomAccessFile output;
    private RandomAccessFile trackerFile;
    private NewClassTracker nct;
    private JTextField textField;
    private JTextField scanTextField;
    private ButtonGroup radioGroup;
    private int todayMonth;
    private int todayYear;
    private int todayDay;
    private int[] listedRecord;
    private Icon viewStudentIcon;
    private Icon addStudentIcon;
    private Icon deleteStudentIcon;
    private Icon closeIcon;
    private Icon classTrackerIcon;
    private Icon searchIcon;
    private Icon happyMozartIcon;
    private Icon searchIcon2;
    private Icon newTeacherIcon;
    private Icon newStudentIcon;
    private Icon makeupListIcon;
    private Icon administratorIcon;
    private Icon adminSmileIcon;
    private JLabel HMLabel;
    private JLabel scanLabel;
    private SelectScreen ss;
    private MakeupList ml;
    private boolean adminSignedIn;
    private Booklist bl;
    private JButton bookButton;
    private JButton renewAllButton;
    private JLabel mRecentBirthdays;
    private JPanel mRecentBirthdayPanel;
    private ImageIcon mRecentBDBG;
    private String mRecentBirthdayList;
    private SpringLayout mRecentBGlayout;
    private ExtractInfo ei;
    private JButton infoListButton;
    
    private String[][] studentArray;
    
    public HomePage() {
        super("Happy Mozart");
        this.birthdayYears = new String[] { "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015" };
        this.dateMonths = new String[] { "", "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        this.dateDays = new String[] { "0", " 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        this.dateYears = new String[] { "2008", "2009", "2010", "2011", "2012" };
        this.buttonNames = new String[] { "Add Student", "Class Tracker", "View/Edit Record", "Delete Student", "Exit" };
        this.radioButtonNames = new String[] { "Last Name", "First Name", "Birthday Month", "Class Type", "Instructor", "Payment Alert", "Update Class Info", "Class Day", "Incomp. Payment Alert Info" };
        this.comboBoxNames = new String[] { " Phone Number ", " Student's 1st Name ", " Parent's 1st Name ", " Last Name ", " Class Day ", "School Earnings" };
        this.columnNames = new String[] { "Child's Name", "Parent's Name", "Class Type", "Class End", "Registered", "Telephone#", " Birthday ", " Class Day - Period", "Teacher's Name", "Invoice" };
        this.classDays = new String[] { "", "  Monday  ", "  Tuesday  ", "  Wednesday  ", "  Thursday  ", "  Friday  ", "  Saturday  ", "  Sunday  ", "Mon & Wedn", "Tues & Thurs", "Wedn & Fri", "Thurs & Sat" };
        this.adminSignedIn = false;
        (this.bookButton = new JButton(new ImageIcon("booklist_icon.jpg"))).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        (this.renewAllButton = new JButton(new ImageIcon("renew_all_icon.jpg"))).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.buttons = new JButton[5];
        this.radioButtons = new JRadioButton[9];
        this.comboBox = new JComboBox(this.comboBoxNames);
        this.buttonPanel = new JPanel();
        this.radioButtonPanel = new JPanel();
        this.searchPanel = new JPanel();
        this.radioPanel1 = new JPanel();
        this.radioPanel2 = new JPanel();
        this.radioPanel3 = new JPanel();
        this.iconPanel = new JPanel();
        this.searchListPanel = new JPanel();
        this.sr = new StudentRecord();
        this.nsip = new NewStudentInfoPage();
        this.nct = new NewClassTracker();
        this.ss = new SelectScreen();
        this.ml = new MakeupList();
        this.bl = new Booklist();
        (this.ei = new ExtractInfo()).setVisible(false);
        this.nsip.setHomePage(this, this.nct, this.bl);
        this.nct.setHomePage(this, this.nsip, this.ml, this.bl);
        this.ss.setNewClassTracker(this.nct);
        this.ss.setHomePage(this);
        this.ml.setHomePage(this);
        this.bl.setHomePage(this);
        this.textField = new JTextField(10);
        this.label = new JLabel("                     LIST BY:  ");
        this.label2 = new JLabel("       LIST:                        ");
        this.getDateTime();
        this.viewStudentIcon = new ImageIcon("view_student_icon.jpg");
        this.closeIcon = new ImageIcon("exit_icon.jpg");
        this.addStudentIcon = new ImageIcon("add_student_icon.jpg");
        this.deleteStudentIcon = new ImageIcon("delete_student_icon.jpg");
        this.classTrackerIcon = new ImageIcon("class_tracker_icon.jpg");
        this.searchIcon = new ImageIcon("search_icon.jpg");
        this.happyMozartIcon = new ImageIcon("happy_mozart_icon.jpg");
        this.HMLabel = new JLabel(this.happyMozartIcon);
        this.scanLabel = new JLabel("     Scan or enter name of student:        ");
        this.scanTextField = new JTextField(30);
        this.scanButton = new JButton(this.searchIcon);
        this.searchIcon2 = new ImageIcon("search_icon2.jpg");
        this.newStudentIcon = new ImageIcon("new_student_icon.jpg");
        this.newTeacherIcon = new ImageIcon("new_teacher_icon.jpg");
        this.makeupListIcon = new ImageIcon("makeup_list_icon.jpg");
        this.administratorIcon = new ImageIcon("administrator_icon.jpg");
        this.adminSmileIcon = new ImageIcon("administrator_smile_icon.jpg");
        this.scanButton = new JButton(this.searchIcon2);
        this.newStudentButton = new JButton(this.newStudentIcon);
        this.newTeacherButton = new JButton(this.newTeacherIcon);
        this.makeupListButton = new JButton(this.makeupListIcon);
        this.searchInactiveButton = new JButton(new ImageIcon("search_inactive_student_icon.jpg"));
        this.deleteRecordButton = new JButton(new ImageIcon("delete_student_icon2.jpg"));
        this.administratorButton = new JButton(this.administratorIcon);
        this.enrollmentFeeButton = new JButton(new ImageIcon("enrollment_fee_icon.jpg"));
        this.search = new JButton("   Search   ", this.searchIcon);
        this.buttons[0] = new JButton(this.buttonNames[0], this.addStudentIcon);
        this.buttons[1] = new JButton(this.buttonNames[1], this.classTrackerIcon);
        this.buttons[2] = new JButton(this.buttonNames[2], this.viewStudentIcon);
        this.buttons[3] = new JButton(this.buttonNames[3], this.deleteStudentIcon);
        this.buttons[4] = new JButton(this.buttonNames[4], this.closeIcon);
        for (int i = 0; i < this.buttons.length; ++i) {}
        this.bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                HomePage.this.bl.clearText();
                HomePage.this.bl.showBooks(0);
                HomePage.this.setVisible(false);
                HomePage.this.bl.setVisible(true);
            }
        });
        
        try {
	        setStudentArray();
        } catch(IOException ioe) {
	        JOptionPane.showMessageDialog(null, "IOException @ School:SearchRecord()", "Error", 0);
        }
        
        this.renewAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                if (HomePage.this.adminSignedIn) {
                    if (JOptionPane.showConfirmDialog(null, "Are you sure you want to renew all?", "Confirmation", 0) == 0 && JOptionPane.showConfirmDialog(null, "Are you REALLY sure you want to renew all?", "Confirmation", 0) == 0) {
                        JOptionPane.showMessageDialog(null, "This will take some time (~2-3 min) and the program will exit when complete. Press OK to begin.", null, -1);
                        try {
                            HomePage.this.renewAll();
                        }
                        catch (ArrayIndexOutOfBoundsException ex) {
                            System.exit(0);
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Must Be An Administrator To Edit Record..", "Warning", 0);
                }
            }
        });
        this.administratorButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                if (HomePage.this.adminSignedIn) {
                    HomePage.this.adminSignedIn = false;
                    HomePage.this.nct.setAdminSignedIn(false);
                    HomePage.this.administratorButton.setIcon(HomePage.this.administratorIcon);
                    JOptionPane.showMessageDialog(null, "Administrator Signed Out", "Access", -1);
                }
                else if (JOptionPane.showInputDialog(null, "Enter Password", null).trim().equals("henry2")) {
                    HomePage.this.adminSignedIn = true;
                    HomePage.this.nct.setAdminSignedIn(true);
                    HomePage.this.administratorButton.setIcon(HomePage.this.adminSmileIcon);
                }
                else {
                    JOptionPane.showMessageDialog(null, "INCORRECT PASSWORD", "Access", -1);
                }
            }
        });
        this.scanButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                HomePage.this.comboBox.getSelectedIndex();
                final String text = HomePage.this.scanTextField.getText();
                try {
                    //HomePage.this.searchRecord(1, text, true);
                    //searchLastName(text, true);
                    searchStudents(text, true);
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "IOException @ School:SearchRecord()", "Error", 0);
                }
            }
        });
        this.searchInactiveButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                final String showInputDialog = JOptionPane.showInputDialog(null, "Please enter name or id number: ", "Search Inactive List", 1);
                if (showInputDialog == null) {
                    return;
                }
                try {
                    //HomePage.this.searchRecord(1, showInputDialog, false);
                    searchStudents(showInputDialog, false);
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "IOException @ School:SearchRecord()", "Error", 0);
                }
            }
        });
        this.enrollmentFeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                HomePage.this.feeList();
            }
        });
        this.newStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                HomePage.this.addStudentButtonPressed();
            }
        });
        this.newTeacherButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
	            ei.clearInfo();
	            try {
                	listExtractInfoBirthday();
                	listExtractInfoAlpha();
            	} catch(IOException ioe) {
	            	JOptionPane.showMessageDialog(null, "IOException @ ExtractInfo.java", "Error", 0);
            	}
                HomePage.this.ei.setList(true);
                HomePage.this.ei.setVisible(true);
            }
        });
        this.makeupListButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                try {
                    HomePage.this.ml.clearFields();
                    HomePage.this.ml.displayList();
                    HomePage.this.setVisible(false);
                    HomePage.this.ml.setVisible(true);
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "IOException @ HomePage::MakeupListButton Pressed", "Error", 0);
                }
            }
        });
        this.buttons[1].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                final int selectedRow = HomePage.this.table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please Select One Of The Records From List", "More Information Needed", 0);
                }
                else {
                    try {
                        HomePage.this.nct.viewNewClassTracker(HomePage.this.listedRecord[selectedRow]);
                        HomePage.this.setEnabled(false);
                        HomePage.this.setVisible(false);
                    }
                    catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "IOException @ ClassTracker:ViewEditClassTracker", "Error", 0);
                    }
                }
            }
        });
        this.deleteRecordButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
            }
        });
        this.buttons[4].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                if (HomePage.this.output != null) {
                    HomePage.this.closeFile();
                }
                System.exit(0);
            }
        });
        final Container contentPane = this.getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout());
        contentPane.add(this.HMLabel);
        this.searchPanel.add(this.scanLabel);
        this.searchPanel.add(this.scanTextField);
        this.searchPanel.add(this.scanButton);
        this.searchPanel.setBackground(Color.WHITE);
        this.scanButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        contentPane.add(this.searchPanel, "Center");
        final FlowLayout layout = new FlowLayout();
        layout.setHgap(20);
        this.buttonPanel.add(this.newStudentButton);
        this.buttonPanel.add(this.makeupListButton);
        this.buttonPanel.add(this.searchInactiveButton);
        this.buttonPanel.add(this.enrollmentFeeButton);
        this.buttonPanel.add(this.bookButton);
        this.buttonPanel.add(this.newTeacherButton);
        this.buttonPanel.add(this.renewAllButton);
        this.buttonPanel.add(this.administratorButton);
        this.buttonPanel.setBackground(Color.WHITE);
        this.newStudentButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.newTeacherButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.makeupListButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.administratorButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.searchInactiveButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.enrollmentFeeButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.buttonPanel.setLayout(layout);
        contentPane.add(this.buttonPanel, "South");
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent windowEvent) {
                if (HomePage.this.output != null) {
                    HomePage.this.closeFile();
                }
                System.out.println("System closing");
                System.exit(0);
            }
        });
        this.scanTextField.addActionListener(new ScanFieldHandler());
        this.mRecentBGlayout = new SpringLayout();
        this.mRecentBDBG = new ImageIcon("birthday_bg.jpg");
        this.mRecentBirthdayPanel = new JPanel();
        this.mRecentBirthdays = new JLabel() {
            public void paintComponent(final Graphics g) {
                g.drawImage(HomePage.this.mRecentBDBG.getImage(), 0, 0, null);
                super.paintComponent(g);
            }
        };
        this.mRecentBirthdayList = "";
        this.mRecentBirthdayPanel.add(this.mRecentBirthdays);
        this.mRecentBirthdayPanel.add(this.HMLabel);
        this.mRecentBirthdayPanel.setBackground(Color.WHITE);
        final FlowLayout layout2 = new FlowLayout();
        layout2.setHgap(-200);
        this.mRecentBirthdayPanel.setLayout(layout2);
        contentPane.add(this.mRecentBirthdayPanel, "North");
        this.setSize(1150, 550);
        try {
            this.listRecentBirthday();
        }
        catch (IOException ex) {}
        this.show();
        
    }
    
    public void setAdminSignedIn(final boolean adminSignedIn) {
        this.adminSignedIn = adminSignedIn;
        if (adminSignedIn) {
            this.administratorButton.setIcon(this.adminSmileIcon);
        }
        else {
            this.administratorButton.setIcon(this.administratorIcon);
        }
    }
    
    private void listInfo() {
    }
    
    private void openTrackerFile(final String s) {
        try {
            System.out.println("String in openfile: " + s);
            this.trackerFile = new RandomAccessFile(s, "rw");
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "ClassInfoPage:OpenFile File does not exist", "Invalid File Name", 0);
        }
    }
    
    public void renewAll() {
        try {
            for (int i = 0; i > -1; ++i) {
                this.nct.clearFields();
                this.nct.viewNewClassTracker(i);
                this.nct.saveTracker();
                this.nct.saveToHistory();
            }
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOEXCEPTION WHILE RENEWING", null, 0);
        }
    }
    
    private void closeTrackerFile() {
        try {
            this.trackerFile.close();
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error closing file", "Error", 0);
        }
    }
    
    private int monthToInt(final String s) {
        if (s.compareTo("JAN") == 0) {
            return 1;
        }
        if (s.compareTo("FEB") == 0) {
            return 2;
        }
        if (s.compareTo("MAR") == 0) {
            return 3;
        }
        if (s.compareTo("APR") == 0) {
            return 4;
        }
        if (s.compareTo("MAY") == 0) {
            return 5;
        }
        if (s.compareTo("JUN") == 0) {
            return 6;
        }
        if (s.compareTo("JUL") == 0) {
            return 7;
        }
        if (s.compareTo("AUG") == 0) {
            return 8;
        }
        if (s.compareTo("SEP") == 0) {
            return 9;
        }
        if (s.compareTo("OCT") == 0) {
            return 10;
        }
        if (s.compareTo("NOV") == 0) {
            return 11;
        }
        if (s.compareTo("DEC") == 0) {
            return 12;
        }
        return 0;
    }
    /*private void searchLastName(String s, boolean b) throws IOException {
	    System.out.println("1");
	    int n2 = 0;
        String str = s.toUpperCase().trim();
        final StudentRecord studentRecord = new StudentRecord();
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        if (int1 == 0) {
            JOptionPane.showMessageDialog(null, "There Are No Records In File At This Time", "Not Enough Informaion", 0);
            this.comboBox.setSelectedIndex(0);
            this.textField.setText("");
            return;
        }
        System.out.println("2");
        
        final int[] array = new int[int1];
        int low = 0;
        int high = int1;
        int i = int1/2;
        
        
        while(high - low > 1) {
	        System.out.println(low + " " + i + " " + high);
	        output.seek(i * StudentRecord.size() + 10);
	        studentRecord.read(this.output);
            String lastName = studentRecord.getLastName();
            System.out.println(lastName);
            studentRecord.getIsRegistered();
            str = str.trim();
            String lastdayDate = studentRecord.getLastdayDate();
            boolean b2 = false;
            if (lastdayDate.length() == 6) {
                final int int2 = Integer.parseInt(lastdayDate.substring(2, 4));
                final int int3 = Integer.parseInt(lastdayDate.substring(0, 2));
                final int n3 = Integer.parseInt(lastdayDate.substring(4)) + 2000;
                if (int2 != 0 && (int3 != 0 & n3 != 2007) && (n3 < this.todayYear || (n3 == this.todayYear && int3 < this.todayMonth) || (n3 == this.todayYear && int3 == this.todayMonth && int2 < this.todayDay))) {
                    b2 = true;
                }
            }
            int up = 0;
            while(lastName.indexOf(str) == 0) {
	             if(b != b2) {
		            array[n2] = i;
            		++n2;
            		System.out.println("++++");
	            }
	            if(i < int1) {
		           	i++;
		            up++;
		            System.out.println(i);
		            
		            output.seek(i * StudentRecord.size() + 10);
			        studentRecord.read(this.output);
		            lastName = studentRecord.getLastName();
		            str = str.trim();
		            lastdayDate = studentRecord.getLastdayDate();
		            b2 = false;
		            if (lastdayDate.length() == 6) {
		                final int int2 = Integer.parseInt(lastdayDate.substring(2, 4));
		                final int int3 = Integer.parseInt(lastdayDate.substring(0, 2));
		                final int n3 = Integer.parseInt(lastdayDate.substring(4)) + 2000;
		                if (int2 != 0 && (int3 != 0 & n3 != 2007) && (n3 < this.todayYear || (n3 == this.todayYear && int3 < this.todayMonth) || (n3 == this.todayYear && int3 == this.todayMonth && int2 < this.todayDay))) {
		                    b2 = true;
		                }
		            }
	            } else {
		            System.out.println("too big");
	            	break;
            	}
            }
            if(up != 0) {
	            i -= up;
	            up = 0;
	            if(i > 0) {
	            	i--;
	            	System.out.println(i);
	            	up--;
		            output.seek(i * StudentRecord.size() + 10);
			        studentRecord.read(this.output);
		            lastName = studentRecord.getLastName();
		            str = str.trim();
		            lastdayDate = studentRecord.getLastdayDate();
		            b2 = false;
		            if (lastdayDate.length() == 6) {
		                final int int2 = Integer.parseInt(lastdayDate.substring(2, 4));
		                final int int3 = Integer.parseInt(lastdayDate.substring(0, 2));
		                final int n3 = Integer.parseInt(lastdayDate.substring(4)) + 2000;
		                if (int2 != 0 && (int3 != 0 & n3 != 2007) && (n3 < this.todayYear || (n3 == this.todayYear && int3 < this.todayMonth) || (n3 == this.todayYear && int3 == this.todayMonth && int2 < this.todayDay))) {
		                    b2 = true;
		                }
		            }
	            } else {
		            System.out.println("too small");
	            	break;
            	}
	            while(lastName.indexOf(str) == 0) {
		             System.out.println(b != b2);
		             if(b != b2) {
			            array[n2] = i;
	            		++n2;
	            		System.out.println("-----");
		            }
		            if(i > 0) {
			            i--;
			            System.out.println(i);
			            up--;
			            
			            output.seek(i * StudentRecord.size() + 10);
				        studentRecord.read(this.output);
			            lastName = studentRecord.getLastName();
			            str = str.trim();
			            lastdayDate = studentRecord.getLastdayDate();
			            b2 = false;
			            if (lastdayDate.length() == 6) {
			                final int int2 = Integer.parseInt(lastdayDate.substring(2, 4));
			                final int int3 = Integer.parseInt(lastdayDate.substring(0, 2));
			                final int n3 = Integer.parseInt(lastdayDate.substring(4)) + 2000;
			                if (int2 != 0 && (int3 != 0 & n3 != 2007) && (n3 < this.todayYear || (n3 == this.todayYear && int3 < this.todayMonth) || (n3 == this.todayYear && int3 == this.todayMonth && int2 < this.todayDay))) {
			                    b2 = true;
			                }
			            }
		            } else {
			            System.out.println("too small");
		            	break;
	            	}
            	}
            	if (n2 == 0) {
            		JOptionPane.showMessageDialog(this, "No Match Found In Record", "Check Format", 0);
            		this.scanTextField.setText("");
            		return;
        		}
        		System.out.println("=====");
        		this.comboBox.setSelectedIndex(0);
        		this.scanTextField.setText("");
        		System.out.println("n2 " + n2);
		        this.ss.setArrayAndMatchCount(array, n2);
		        this.ss.setVisible(true);
		        this.ss.Selections(false);
		        this.setEnabled(false);
		        this.setVisible(false);
                return;
        	}
        	if(lastName.compareTo(str) > 0) {
        		high = i;
        		i = (low+high)/2;
        	} else {
	        	low = i;
	        	i = (low+high)/2;
        	}
        }
        JOptionPane.showMessageDialog(this, "No Match Found In Record", "Check Format", 0);
    }*/
    
    public void setStudentArray() throws IOException {
	    int totalNum;
        
        StudentRecord sr = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        output.seek(0L);
        totalNum = output.readInt();
        studentArray = new String[totalNum][6];
        for(int i = 0; i < totalNum; i++) {
	        this.output.seek(i * StudentRecord.size() + 10);
            sr.read(this.output);
            studentArray[i][0] = sr.getStudentTeacherId();
            studentArray[i][1] = sr.getLastName();
            studentArray[i][2] = sr.getFirstName();
            studentArray[i][3] = sr.getFirstName() + " " + sr.getLastName();
            studentArray[i][4] = sr.getDadName();
            studentArray[i][5] = sr.getLastdayDate();
            System.out.println(studentArray[i][1]);
        }
        System.out.println(studentArray.length);
    }
    
    private void searchStudents(String s, boolean b) throws IOException {
	    String str = s.toUpperCase().trim();
	    int n2 = 0;
	    final int[] array = new int[studentArray.length];
	    
	    for (int i = 0; i < studentArray.length; ++i) {
            final String studentTeacherId = studentArray[i][0];
            final String lastName = studentArray[i][1];
            final String firstName = studentArray[i][2];
            final String string = studentArray[i][3];
            final String dadName = studentArray[i][4];
            final String lastdayDate = studentArray[i][5];
            
            str = str.trim();
            if (studentTeacherId.compareTo(str) == 0) {
                array[n2] = i;
                ++n2;
                this.ss.setArrayAndMatchCount(array, n2);
                this.ss.setVisible(true);
                this.ss.Selections(true);
                this.setEnabled(false);
                this.setVisible(false);
                this.scanTextField.setText("");
                return;
            }

            boolean b2 = false;
            if (lastdayDate.length() == 6) {
                final int int2 = Integer.parseInt(lastdayDate.substring(2, 4));
                final int int3 = Integer.parseInt(lastdayDate.substring(0, 2));
                final int n3 = Integer.parseInt(lastdayDate.substring(4)) + 2000;
                if (int2 != 0 && (int3 != 0 & n3 != 2007) && (n3 < this.todayYear || (n3 == this.todayYear && int3 < this.todayMonth) || (n3 == this.todayYear && int3 == this.todayMonth && int2 < this.todayDay))) {
                    b2 = true;
                }
            }
            if (!b || !b2) {
                if (b || b2) {
                    if (lastName.compareTo(str) == 0 || studentTeacherId.compareTo(str) == 0 || str.compareTo("ALL") == 0 || firstName.compareTo(str) == 0 || string.indexOf(str) != -1 || dadName.indexOf(str) != -1) {
                        array[n2] = i;
                        ++n2;
                    }
                }
            }
        }
        System.out.println("5");
        if (n2 == 0) {
            JOptionPane.showMessageDialog(this, "No Match Found In Record", "Check Format", 0);
            this.scanTextField.setText("");
            return;
        }
        System.out.println("6");
        this.comboBox.setSelectedIndex(0);
        this.scanTextField.setText("");
        this.ss.setArrayAndMatchCount(array, n2);
        this.ss.setVisible(true);
        this.ss.Selections(false);
        this.setEnabled(false);
        this.setVisible(false);
    }
    
    private void searchRecord(final int n, final String s, final boolean b) throws IOException {
        int n2 = 0;
        String str = s.toUpperCase().trim();
        final StudentRecord studentRecord = new StudentRecord();
        System.out.println("1");
        if ((n == 0 || n == 1 || n == 2 || n == 3 || n == 4) && str.compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Search Text Area Needs To Be Filled Out", "More Information Needed", 0);
            return;
        }
        System.out.println("2");
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        if (int1 == 0) {
            JOptionPane.showMessageDialog(null, "There Are No Records In File At This Time", "Not Enough Informaion", 0);
            this.comboBox.setSelectedIndex(0);
            this.textField.setText("");
            return;
        }
        final int[] array = new int[int1];
        System.out.println("3");
        if (n == 0) {
            if (s.length() != 12) {
                JOptionPane.showMessageDialog(null, "Search By Telephone Number: Wrong Format. Correct Format XXX-XXX-XXXX", "Invalid Search Format", 0);
                return;
            }
            str = s.substring(0, 3) + s.substring(4, 7) + s.substring(8, 12);
            System.out.println("phone number: " + str);
        }
        else if (n == 4 && this.dayOfWeekStringToInt(str) == 0) {
            JOptionPane.showMessageDialog(null, "Search By Class Day: Wrong Format. Please Enter First 3 Letters Of Day Of Week.", "Invalid Search Format", 0);
            this.textField.setText("Example: mon");
            return;
        }
        System.out.println("4");
        for (int i = 0; i < int1; ++i) {
            this.output.seek(i * StudentRecord.size() + 10);
            studentRecord.read(this.output);
            final String studentTeacherId = studentRecord.getStudentTeacherId();
            final String lastName = studentRecord.getLastName();
            final String firstName = studentRecord.getFirstName();
            final String string = studentRecord.getFirstName() + " " + studentRecord.getLastName();
            final String dadName = studentRecord.getDadName();
            studentRecord.getIsRegistered();
            str = str.trim();
            if (studentTeacherId.compareTo(str) == 0) {
                array[n2] = i;
                ++n2;
                this.ss.setArrayAndMatchCount(array, n2);
                this.ss.setVisible(true);
                this.ss.Selections(true);
                this.setEnabled(false);
                this.setVisible(false);
                this.scanTextField.setText("");
                return;
            }
            final String lastdayDate = studentRecord.getLastdayDate();
            boolean b2 = false;
            if (lastdayDate.length() == 6) {
                final int int2 = Integer.parseInt(lastdayDate.substring(2, 4));
                final int int3 = Integer.parseInt(lastdayDate.substring(0, 2));
                final int n3 = Integer.parseInt(lastdayDate.substring(4)) + 2000;
                if (int2 != 0 && (int3 != 0 & n3 != 2007) && (n3 < this.todayYear || (n3 == this.todayYear && int3 < this.todayMonth) || (n3 == this.todayYear && int3 == this.todayMonth && int2 < this.todayDay))) {
                    b2 = true;
                }
            }
            if (!b || !b2) {
                if (b || b2) {
                    if (lastName.compareTo(str) == 0 || studentTeacherId.compareTo(str) == 0 || str.compareTo("ALL") == 0 || firstName.compareTo(str) == 0 || string.indexOf(str) != -1 || dadName.indexOf(str) != -1) {
                        array[n2] = i;
                        ++n2;
                    }
                }
            }
        }
        System.out.println("5");
        if (n2 == 0) {
            JOptionPane.showMessageDialog(this, "No Match Found In Record", "Check Format", 0);
            this.scanTextField.setText("");
            return;
        }
        System.out.println("6");
        this.comboBox.setSelectedIndex(0);
        this.scanTextField.setText("");
        this.ss.setArrayAndMatchCount(array, n2);
        this.ss.setVisible(true);
        this.ss.Selections(false);
        this.setEnabled(false);
        this.setVisible(false);
    }
    
    private void listExtractInfoAlpha() throws IOException {
        final StudentRecord studentRecord = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        for (int int1 = this.output.readInt(), i = 0; i < int1; ++i) {
            this.output.seek(i * StudentRecord.size() + 10);
            studentRecord.read(this.output);
            final String lastdayDate = studentRecord.getLastdayDate();
            boolean b = false;
            if (lastdayDate.length() == 6) {
                final int int2 = Integer.parseInt(lastdayDate.substring(2, 4));
                final int int3 = Integer.parseInt(lastdayDate.substring(0, 2));
                final int n = Integer.parseInt(lastdayDate.substring(4)) + 2000;
                if (int2 != 0 && (int3 != 0 & n != 2007) && (n < this.todayYear || (n == this.todayYear && int3 < this.todayMonth) || (n == this.todayYear && int3 == this.todayMonth && int2 < this.todayDay))) {
                    b = true;
                }
            }
            if (!b) {
                final String string = studentRecord.getFirstName() + " " + studentRecord.getLastName();
                final String string2 = studentRecord.getDadName();
                final String string3 = studentRecord.getParentEMail();
                final String str = string;
                String string4 = "";
                for (int j = 40; j > string.length(); --j) {
                    string4 += " ";
                }
                final String string5 = str + string4 + string2;
                String string6 = "";
                for (int k = 40; k > string2.length(); --k) {
                    string6 += " ";
                }
                String string7 = "";
                for (int k = 40; k > string3.length(); --k) {
                    string7 += " ";
                }
                this.ei.addInfo1(string5 + string6 + string3 + string7);
            }
        }
    }
    
    private void listExtractInfoBirthday() throws IOException {
	    
	    ArrayList[][] dayList = new ArrayList[13][32];
	    for(int i = 0; i < 13; i++) {
		    for(int j = 0; j < 32; j++) {
		    	dayList[i][j] = new ArrayList();
	    	}
	    }
	    
        final StudentRecord studentRecord = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        for (int int1 = this.output.readInt(), i = 0; i < int1; ++i) {
            this.output.seek(i * StudentRecord.size() + 10);
            studentRecord.read(this.output);
            final String lastdayDate = studentRecord.getLastdayDate();
            boolean b = false;
            if (lastdayDate.length() == 6) {
                final int int2 = Integer.parseInt(lastdayDate.substring(2, 4));
                final int int3 = Integer.parseInt(lastdayDate.substring(0, 2));
                final int n = Integer.parseInt(lastdayDate.substring(4)) + 2000;
                if (int2 != 0 && (int3 != 0 & n != 2007) && (n < this.todayYear || (n == this.todayYear && int3 < this.todayMonth) || (n == this.todayYear && int3 == this.todayMonth && int2 < this.todayDay))) {
                    b = true;
                }
            }
            if (!b) {
	            int tempMonth = studentRecord.getBirthdayMonth();
	            int tempDay = studentRecord.getBirthdayDay();
                final String string = studentRecord.getFirstName() + " " + studentRecord.getLastName();
                final String string2 = studentRecord.getDadName();
                final String string3 = studentRecord.getParentEMail();
                final String str = string;
                String string4 = "";
                for (int j = 34; j > string.length(); --j) {
                    string4 += " ";
                }
                final String string5 = str + string4 + string2;
                String string6 = "";
                for (int k = 40; k > string2.length(); --k) {
                    string6 += " ";
                }
                String string7 = tempMonth + "/" + tempDay;
                while(string7.length() < 6) {
	                string7 += " ";
                }
                String string8 = "";
                for (int k = 40; k > string3.length(); --k) {
                    string8 += " ";
                }
                dayList[tempMonth][tempDay].add(string7 + string5 + string6 + string3 + string8);
            }
        }
        //String tempEverything = "";
        String stringMonth = "";
        for(int i = 1; i < 13; i++) {
	        stringMonth = "";
	        for(int l = 120; l > dateMonths[i].length(); l--) {
		        stringMonth += " ";
	        }
	        ei.addInfo2(dateMonths[i] + stringMonth);
	        for(int j = 0; j < 32; j++) {
		        for(int k = 0; k < dayList[i][j].size(); k++) {
			        //tempEverything = dayList[i][j].get(k).toString();
			        ei.addInfo2(dayList[i][j].get(k).toString());
		        }
	        }
        }
    }
    
    private int dayOfWeekStringToInt(final String s) {
        if (s.equals("MON")) {
            return 1;
        }
        if (s.equals("TUE")) {
            return 2;
        }
        if (s.equals("WED")) {
            return 3;
        }
        if (s.equals("THU")) {
            return 4;
        }
        if (s.equals("FRI")) {
            return 5;
        }
        if (s.equals("SAT")) {
            return 6;
        }
        if (s.equals("SUN")) {
            return 7;
        }
        return 0;
    }
    
    private void getDateTime() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM");
        final SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("dd");
        final Date date = new Date();
        this.todayMonth = Integer.parseInt(simpleDateFormat2.format(date));
        this.todayYear = Integer.parseInt(simpleDateFormat.format(date));
        this.todayDay = Integer.parseInt(simpleDateFormat3.format(date));
    }
    
    private void feeList() {
        Calendar.getInstance();
        int n = -1;
        final String[] selectionValues = { "Find Enrollment Fee", "Create/Change School Year Variables", "View Fee List" };
        try {
            while (true) {
                final String string = JOptionPane.showInputDialog(null, "Select Action", "Input", 3, null, selectionValues, selectionValues[0]).toString();
                for (int i = 0; i < 3; ++i) {
                    if (string.compareTo(selectionValues[i]) == 0) {
                        n = i;
                    }
                }
                if (n == 0) {
                    try {
                        this.findEnrollmentFee(Integer.parseInt(JOptionPane.showInputDialog("Enter first year of school year \n  (i.e 2011-2012 Enter 2011)")));
                        continue;
                    }
                    catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "IOException in findEnrollmentFee", "Error", 0);
                        continue;
                    }
                    catch (NumberFormatException ex2) {
                        continue;
                    }
                }
                if (n == 1) {
                    try {
                        this.editSchoolYearFeeList(Integer.parseInt(JOptionPane.showInputDialog("Enter first year of school year \n  (i.e 2011-2012 Enter 2011)")));
                        continue;
                    }
                    catch (IOException ex3) {
                        JOptionPane.showMessageDialog(this, "IOException in editSchoolYearFeeList", "Error", 0);
                        continue;
                    }
                    catch (NumberFormatException ex4) {
                        continue;
                    }
                }
                if (n == 2) {
                    try {
                        this.viewFeeList(Integer.parseInt(JOptionPane.showInputDialog("Enter first year of school year \n  (i.e 2011-2012 Enter 2011)")));
                    }
                    catch (IOException ex5) {
                        JOptionPane.showMessageDialog(this, "IOException in editSchoolYearFeeList", "Error", 0);
                    }
                    catch (NumberFormatException ex6) {}
                }
            }
        }
        catch (NullPointerException ex7) {}
    }
    
    private void findEnrollmentFee(final int n) throws IOException {
        final Calendar instance = Calendar.getInstance();
        final Calendar instance2 = Calendar.getInstance();
        final String string = n + "_" + (n + 1);
        if (!new File(string + ".txt").exists()) {
            System.out.println("file does not exist");
            JOptionPane.showConfirmDialog(this, "Fee list for " + string + "is unavailable.  To create please goto \"Create/Change School Year Variables\" ");
            return;
        }
        final RandomAccessFile randomAccessFile = new RandomAccessFile(string + ".txt", "rw");
        randomAccessFile.seek(0L);
        if (randomAccessFile.readInt() != 1) {
            JOptionPane.showConfirmDialog(this, "Information for school year " + string + " is incomplete.  To edit please goto \"Create/Change School Year Variables\" ");
            return;
        }
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int i = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        final int n8 = randomAccessFile.readInt() - 1;
        final int int1 = randomAccessFile.readInt();
        final int int2 = randomAccessFile.readInt();
        final int int3 = randomAccessFile.readInt();
        final int int4 = randomAccessFile.readInt();
        int date = int1;
        int n9 = n8;
        int n10 = n;
        final int n11 = int3 * int4 / 12;
        final int int5 = randomAccessFile.readInt();
        final int[] array = new int[int5];
        final int[] array2 = new int[int5];
        for (int j = 0; j < int5; ++j) {
            array[j] = randomAccessFile.readInt();
            array2[j] = randomAccessFile.readInt();
        }
        final int int6 = randomAccessFile.readInt();
        final int[] array3 = new int[int6];
        final int[] array4 = new int[int6];
        for (int k = 0; k < int6; ++k) {
            array3[k] = randomAccessFile.readInt();
            array4[k] = randomAccessFile.readInt();
        }
        int int7;
        int int8;
        int int9;
        try {
            int7 = Integer.parseInt(JOptionPane.showInputDialog("Enter student start \"MONTH\"\n (ie. Jun. 11, 2011 - Enter 6)"));
            int8 = Integer.parseInt(JOptionPane.showInputDialog("Enter student start \"DAY\"\n (ie. Jun. 11, 2011 - Enter 11"));
            int9 = Integer.parseInt(JOptionPane.showInputDialog("Enter student start \"YEAR\"\n (ie. Jun. 11, 2011 - Enter 2011"));
        }
        catch (NumberFormatException ex) {
            return;
        }
        int n12 = 0;
        int n13 = 0;
        int l = int3;
        instance.set(n10, n9, 1);
        int n14 = instance.getActualMaximum(5);
        int n15 = -1;
        int n16 = -1;
        boolean b = true;
        String string2 = "";
        while (true) {
            if (date < n14) {
                ++n12;
                if (b) {
                    b = !b;
                }
                else {
                    ++date;
                }
                for (int n17 = 0; n17 < int5; ++n17) {
                    if (array[n17] - 1 == n9 && array2[n17] == date && n == n10) {
                        --n12;
                        n15 = 1;
                        break;
                    }
                }
                for (int n18 = 0; n18 < int6; ++n18) {
                    if (array3[n18] - 1 == n9 && array4[n18] == date && n + 1 == n10) {
                        --n12;
                        n15 = 1;
                        break;
                    }
                }
            }
            else {
                if (date == n14) {
                    ++n12;
                    ++date;
                    for (int n19 = 0; n19 < int5; ++n19) {
                        if (array[n19] - 1 == n9 && array2[n19] == date && n == n10) {
                            --n12;
                            n15 = 1;
                            break;
                        }
                    }
                    for (int n20 = 0; n20 < int6; ++n20) {
                        if (array3[n20] - 1 == n9 && array4[n20] == date && n + 1 == n10) {
                            --n12;
                            n15 = 1;
                            break;
                        }
                    }
                    continue;
                }
                date = 1;
                if (n9 == 11) {
                    n9 = 0;
                    ++n10;
                    instance.set(n10, n9, 1);
                    n14 = instance.getActualMaximum(5);
                }
                else {
                    ++n9;
                    instance.set(n10, n9, 1);
                    n14 = instance.getActualMaximum(5);
                }
            }
            if (n15 == 1) {
                n15 = -1;
            }
            else {
                instance2.set(n10, n9, date);
                final int value = instance2.get(7);
                if (value == 2) {
                    if (n2 <= int3 - 1 && int7 - 1 == instance2.get(2) && int8 == instance2.get(5) && int9 == instance2.get(1)) {
                        n16 = 1;
                    }
                    ++n2;
                }
                else if (value == 3) {
                    if (n3 <= int3 - 1 && int7 - 1 == instance2.get(2) && int8 == instance2.get(5) && int9 == instance2.get(1)) {
                        n16 = 2;
                    }
                    ++n3;
                }
                else if (value == 4) {
                    if (n4 <= int3 - 1 && int7 - 1 == instance2.get(2) && int8 == instance2.get(5) && int9 == instance2.get(1)) {
                        n16 = 3;
                    }
                    ++n4;
                }
                else if (value == 5) {
                    if (i <= int3 - 1 && int7 - 1 == instance2.get(2) && int8 == instance2.get(5) && int9 == instance2.get(1)) {
                        n16 = 4;
                    }
                    ++i;
                }
                else if (value == 6) {
                    if (n5 <= int3 - 1 && int7 - 1 == instance2.get(2) && int8 == instance2.get(5) && int9 == instance2.get(1)) {
                        n16 = 5;
                    }
                    ++n5;
                }
                else if (value == 7) {
                    if (n6 <= int3 - 1 && int7 - 1 == instance2.get(2) && int8 == instance2.get(5) && int9 == instance2.get(1)) {
                        n16 = 6;
                    }
                    ++n6;
                }
                else if (value == 1) {
                    if (n7 <= int3 - 1 && int7 - 1 == instance2.get(2) && int8 == instance2.get(5) && int9 == instance2.get(1)) {
                        n16 = 7;
                    }
                    ++n7;
                }
                if (n2 > int3 - 1 && n3 > int3 - 1 && n4 > int3 - 1 && i > int3 - 1 && n5 > int3 - 1 && n6 > int3 - 1 && n7 > int3 - 1) {
                    break;
                }
                if (n16 >= 1) {
                    System.out.println("total_lesson" + int3 + "  Thu: " + i);
                    if (n16 == 1) {
                        l = int3 - n2 + 1;
                    }
                    else if (n16 == 2) {
                        l = int3 - n3 + 1;
                    }
                    else if (n16 == 3) {
                        l = int3 - n4 + 1;
                    }
                    else if (n16 == 4) {
                        l = int3 - i + 1;
                    }
                    else if (n16 == 5) {
                        l = int3 - n5 + 1;
                    }
                    else if (n16 == 6) {
                        l = int3 - n6 + 1;
                    }
                    else if (n16 == 7) {
                        l = int3 - n7 + 1;
                    }
                    int m = l * int4 % n11;
                    int i2 = l * int4 / n11;
                    if (m == 0) {
                        m = n11;
                        --i2;
                    }
                    else if (m < int4) {
                        --i2;
                        m += n11;
                    }
                    int i3 = int2 + 1 - i2;
                    if (i3 < 0) {
                        i3 += 12;
                    }
                    else if (i3 == 0) {
                        i3 = 12;
                    }
                    int i4;
                    if ((int7 == 11 || int7 == 12) && i3 == 1) {
                        i4 = int9 + 1;
                    }
                    else {
                        i4 = int9;
                    }
                    string2 = string2 + "For student starting on " + int7 + "-" + int8 + "-" + int9 + "\n" + "\n(Weeks left: " + l + ") (Installments left: " + i2 + ") (Next Payment in: " + i3 + "-1-" + i4 + ") (Enrollment fee: $" + m + ")";
                    break;
                }
                if (n12 != 7) {
                    continue;
                }
                n12 = 0;
                ++n13;
            }
        }
        JOptionPane.showMessageDialog(this, string2, "Enrollment Fee" + n + "-" + (n + 1), 1);
    }
    
    private void viewFeeList(final int n) throws IOException {
        final Calendar instance = Calendar.getInstance();
        final Calendar instance2 = Calendar.getInstance();
        final String string = n + "_" + (n + 1);
        String string2 = "";
        if (!new File(string + ".txt").exists()) {
            System.out.println("file does not exist");
            JOptionPane.showConfirmDialog(this, "Fee list for " + string + " is unavailable.  To create please goto \"Create/Change School Year Variables\" ");
            return;
        }
        final RandomAccessFile randomAccessFile = new RandomAccessFile(string + ".txt", "rw");
        randomAccessFile.seek(0L);
        if (randomAccessFile.readInt() != 1) {
            JOptionPane.showConfirmDialog(this, "Information for school year " + string + " is incomplete.  To edit please goto \"Create/Change School Year Variables\" ");
            return;
        }
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        final int n9 = randomAccessFile.readInt() - 1;
        final int int1 = randomAccessFile.readInt();
        final int int2 = randomAccessFile.readInt();
        final int int3 = randomAccessFile.readInt();
        final int int4 = randomAccessFile.readInt();
        final Calendar[][] array = new Calendar[int3][7];
        for (int i = 0; i < int3; ++i) {
            for (int j = 0; j < 7; ++j) {
                array[i][j] = Calendar.getInstance();
            }
        }
        int date = int1;
        int n10 = n9;
        int n11 = n;
        final int n12 = int3 * int4 / 12;
        final int int5 = randomAccessFile.readInt();
        final int[] array2 = new int[int5];
        final int[] array3 = new int[int5];
        for (int k = 0; k < int5; ++k) {
            array2[k] = randomAccessFile.readInt();
            array3[k] = randomAccessFile.readInt();
        }
        final int int6 = randomAccessFile.readInt();
        final int[] array4 = new int[int6];
        final int[] array5 = new int[int6];
        for (int l = 0; l < int6; ++l) {
            array4[l] = randomAccessFile.readInt();
            array5[l] = randomAccessFile.readInt();
        }
        int n13 = 0;
        int n14 = 0;
        instance.set(n11, n10, 1);
        int n15 = instance.getActualMaximum(5);
        int n16 = -1;
        boolean b = true;
        while (true) {
            if (date < n15) {
                ++n13;
                if (b) {
                    b = !b;
                }
                else {
                    ++date;
                }
                for (int n17 = 0; n17 < int5; ++n17) {
                    if (array2[n17] - 1 == n10 && array3[n17] == date && n == n11) {
                        --n13;
                        n16 = 1;
                        break;
                    }
                }
                for (int n18 = 0; n18 < int6; ++n18) {
                    if (array4[n18] - 1 == n10 && array5[n18] == date && n + 1 == n11) {
                        --n13;
                        n16 = 1;
                        break;
                    }
                }
            }
            else {
                if (date == n15) {
                    ++n13;
                    ++date;
                    for (int n19 = 0; n19 < int5; ++n19) {
                        if (array2[n19] - 1 == n10 && array3[n19] == date && n == n11) {
                            --n13;
                            n16 = 1;
                            break;
                        }
                    }
                    for (int n20 = 0; n20 < int6; ++n20) {
                        if (array4[n20] - 1 == n10 && array5[n20] == date && n + 1 == n11) {
                            --n13;
                            n16 = 1;
                            break;
                        }
                    }
                    continue;
                }
                date = 1;
                if (n10 == 11) {
                    n10 = 0;
                    ++n11;
                    instance.set(n11, n10, 1);
                    n15 = instance.getActualMaximum(5);
                }
                else {
                    ++n10;
                    instance.set(n11, n10, 1);
                    n15 = instance.getActualMaximum(5);
                }
            }
            if (n16 == 1) {
                n16 = -1;
            }
            else {
                instance2.set(n11, n10, date);
                final int value = instance2.get(7);
                if (value == 2) {
                    if (n2 <= int3 - 1) {
                        array[n2][0].set(instance2.get(1), instance2.get(2), instance2.get(5));
                    }
                    ++n2;
                }
                else if (value == 3) {
                    if (n3 <= int3 - 1) {
                        array[n3][1].set(instance2.get(1), instance2.get(2), instance2.get(5));
                    }
                    ++n3;
                }
                else if (value == 4) {
                    if (n4 <= int3 - 1) {
                        array[n4][2].set(instance2.get(1), instance2.get(2), instance2.get(5));
                    }
                    ++n4;
                }
                else if (value == 5) {
                    if (n5 <= int3 - 1) {
                        array[n5][3].set(instance2.get(1), instance2.get(2), instance2.get(5));
                    }
                    ++n5;
                }
                else if (value == 6) {
                    if (n6 <= int3 - 1) {
                        array[n6][4].set(instance2.get(1), instance2.get(2), instance2.get(5));
                    }
                    ++n6;
                }
                else if (value == 7) {
                    if (n7 <= int3 - 1) {
                        array[n7][5].set(instance2.get(1), instance2.get(2), instance2.get(5));
                    }
                    ++n7;
                }
                else if (value == 1) {
                    if (n8 <= int3 - 1) {
                        array[n8][6].set(instance2.get(1), instance2.get(2), instance2.get(5));
                    }
                    ++n8;
                }
                if (n2 > int3 - 1 && n3 > int3 - 1 && n4 > int3 - 1 && n5 > int3 - 1 && n6 > int3 - 1 && n7 > int3 - 1 && n8 > int3 - 1) {
                    break;
                }
                if (n13 != 7) {
                    continue;
                }
                n13 = 0;
                ++n14;
            }
        }
        int m = 12;
        int i2 = n;
        for (int n21 = 0; n21 < int3; ++n21) {
            String s = string2 + "(WEEK " + (n21 + 1) + ")\n";
            for (int n22 = 0; n22 < 7; ++n22) {
                s = s + "(" + (array[n21][n22].get(2) + 1) + "-" + array[n21][n22].get(5) + "-" + array[n21][n22].get(1) + ")";
            }
            final int i3 = int3 - n21;
            int i4 = i3 * int4 % n12;
            if (i4 == 0) {
                i4 = n12;
                --m;
            }
            else if (i4 < int4) {
                --m;
                i4 += n12;
            }
            int i5 = int2 + 1 - m;
            if (i5 < 0) {
                i5 += 12;
            }
            else if (i5 == 0) {
                i5 = 12;
            }
            if (i5 == 1) {
                i2 = n + 1;
            }
            string2 = s + "\n(Weeks left: " + i3 + ") (Installments left: " + m + ") (Next Payment in: " + i5 + "-1-" + i2 + ") (Enrollment fee: $" + i4 + ")\n--------------------------------------\n";
        }
        final JTextArea view = new JTextArea(30, 50);
        final JScrollPane message = new JScrollPane(view);
        view.setText(string2);
        JOptionPane.showMessageDialog(this, message, "Fee List " + n + "-" + (n + 1), 1);
    }
    
    private void editSchoolYearFeeList(final int i) throws IOException {
        final String string = i + "_" + (i + 1);
        if (!new File(string + ".txt").exists()) {
            System.out.println("file does not exist");
            final int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Fee list for " + string + "is unavailable.  Do you wish to create a list for" + string + "?");
            if (showConfirmDialog == 1 || showConfirmDialog == 2) {
                return;
            }
            if (showConfirmDialog == 0) {
                final RandomAccessFile randomAccessFile = new RandomAccessFile(string + ".txt", "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeInt(-1);
                randomAccessFile.close();
            }
        }
        final RandomAccessFile randomAccessFile2 = new RandomAccessFile(string + ".txt", "rw");
        randomAccessFile2.seek(0L);
        final int int1 = randomAccessFile2.readInt();
        if (int1 == -1) {
            final String showInputDialog = JOptionPane.showInputDialog("Enter start date of school year using \"-\" \n (ie. 6-20 for Jun. 20th) ");
            final int int2 = Integer.parseInt(showInputDialog.substring(0, showInputDialog.indexOf(45)));
            final int int3 = Integer.parseInt(showInputDialog.substring(showInputDialog.indexOf(45) + 1));
            System.out.println("month: " + int2 + "  day: " + int3);
            randomAccessFile2.seek(0L);
            randomAccessFile2.writeInt(-1);
            randomAccessFile2.writeInt(int2);
            randomAccessFile2.writeInt(int3);
            randomAccessFile2.writeInt(Integer.parseInt(JOptionPane.showInputDialog("Enter month the last auto payment will be made")));
            randomAccessFile2.writeInt(Integer.parseInt(JOptionPane.showInputDialog("Enter total # of lessons in this school year ")));
            randomAccessFile2.writeInt(Integer.parseInt(JOptionPane.showInputDialog("Enter cost($) per lesson - No decimals ")));
            final int int4 = Integer.parseInt(JOptionPane.showInputDialog("Enter total # of vacation days in " + i + "\n(Please remember vacation days in " + i + " ONLY"));
            final int[] array = new int[int4];
            final int[] array2 = new int[int4];
            for (int j = 0; j < int4; ++j) {
                final String showInputDialog2 = JOptionPane.showInputDialog("Enter date of vacation day #" + (j + 1) + "in " + i + "\n (ie. 6-20 for Jun. 20th) ");
                array[j] = Integer.parseInt(showInputDialog2.substring(0, showInputDialog2.indexOf(45)));
                array2[j] = Integer.parseInt(showInputDialog2.substring(showInputDialog2.indexOf(45) + 1));
                System.out.println("month: " + array[j] + "  day: " + array2[j]);
            }
            randomAccessFile2.writeInt(int4);
            for (int k = 0; k < int4; ++k) {
                randomAccessFile2.writeInt(array[k]);
                randomAccessFile2.writeInt(array2[k]);
            }
            final int int5 = Integer.parseInt(JOptionPane.showInputDialog("Enter total # of vacation days in " + (i + 1) + "\n(Please remember vacation days in " + i + " ONLY"));
            final int[] array3 = new int[int5];
            final int[] array4 = new int[int5];
            for (int l = 0; l < int5; ++l) {
                final String showInputDialog3 = JOptionPane.showInputDialog("Enter date of vacation day #" + (l + 1) + "in " + (i + 1) + "\n (ie. 6-20 for Jun. 20th) ");
                array3[l] = Integer.parseInt(showInputDialog3.substring(0, showInputDialog3.indexOf(45)));
                array4[l] = Integer.parseInt(showInputDialog3.substring(showInputDialog3.indexOf(45) + 1));
                System.out.println("month: " + array3[l] + "  day: " + array4[l]);
            }
            randomAccessFile2.writeInt(int5);
            for (int n = 0; n < int5; ++n) {
                randomAccessFile2.writeInt(array3[n]);
                randomAccessFile2.writeInt(array4[n]);
            }
            randomAccessFile2.seek(0L);
            randomAccessFile2.writeInt(1);
        }
        else if (int1 == 1) {
            int m = randomAccessFile2.readInt();
            int i2 = randomAccessFile2.readInt();
            int n2 = randomAccessFile2.readInt();
            int n3 = randomAccessFile2.readInt();
            int n4 = randomAccessFile2.readInt();
            int i3 = randomAccessFile2.readInt();
            int[] array5 = new int[i3];
            int[] array6 = new int[i3];
            for (int n5 = 0; n5 < i3; ++n5) {
                array5[n5] = randomAccessFile2.readInt();
                array6[n5] = randomAccessFile2.readInt();
            }
            int i4 = randomAccessFile2.readInt();
            int[] array7 = new int[i4];
            int[] array8 = new int[i4];
            for (int n6 = 0; n6 < i4; ++n6) {
                array7[n6] = randomAccessFile2.readInt();
                array8[n6] = randomAccessFile2.readInt();
            }
            String str = "SCHOOL YEAR " + i + "-" + (i + 1) + "\n\n1. start date: " + m + "-" + i2 + "\n2. last AUTO PAYMENT month of school year: " + n2 + "\n3. total # of lessons in school year: " + n3 + "\n4. cost($) per lesson: $" + n4 + "\n5. total vacation days in " + i + ": " + i3 + "\nvacation dates: ";
            for (int n7 = 0, n8 = 0; n7 < i3; ++n7, ++n8) {
                if (n8 == 4) {
                    str += "\n   ";
                    n8 = 0;
                }
                str = str + array5[n7] + "-" + array6[n7] + "-" + i + ", ";
            }
            String str2 = str + "\n6. total vacation days in " + (i + 1) + ": " + i4 + "\nvacation dates: ";
            for (int n9 = 0, n10 = 0; n9 < i4; ++n9, ++n10) {
                if (n10 == 4) {
                    str2 += "\n   ";
                    n10 = 0;
                }
                str2 = str2 + array7[n9] + "-" + array8[n9] + "-" + (i + 1) + ", ";
            }
            switch (Integer.parseInt(JOptionPane.showInputDialog(str2 + "\n\nEnter number to make changes"))) {
                case 1: {
                    final String showInputDialog4 = JOptionPane.showInputDialog("Enter start date of school year using \"-\" \n (ie. 6-20 for Jun. 20th) ");
                    m = Integer.parseInt(showInputDialog4.substring(0, showInputDialog4.indexOf(45)));
                    i2 = Integer.parseInt(showInputDialog4.substring(showInputDialog4.indexOf(45) + 1));
                    break;
                }
                case 2: {
                    n2 = Integer.parseInt(JOptionPane.showInputDialog("Enter month the last payment will be made"));
                    randomAccessFile2.writeInt(n2);
                    break;
                }
                case 3: {
                    n3 = Integer.parseInt(JOptionPane.showInputDialog("Enter total # of lessons in this school year "));
                    randomAccessFile2.writeInt(n3);
                    break;
                }
                case 4: {
                    n4 = Integer.parseInt(JOptionPane.showInputDialog("Enter cost($) per lesson - No decimals "));
                    randomAccessFile2.writeInt(n4);
                    break;
                }
                case 5: {
                    i3 = Integer.parseInt(JOptionPane.showInputDialog("Enter total # of vacation days in " + i + "\n(Please remember vacation days in " + i + " ONLY"));
                    array5 = new int[i3];
                    array6 = new int[i3];
                    for (int n11 = 0; n11 < i3; ++n11) {
                        final String showInputDialog5 = JOptionPane.showInputDialog("Enter date of vacation day #" + (n11 + 1) + "in " + i + "\n (ie. 6-20 for Jun. 20th) ");
                        array5[n11] = Integer.parseInt(showInputDialog5.substring(0, showInputDialog5.indexOf(45)));
                        array6[n11] = Integer.parseInt(showInputDialog5.substring(showInputDialog5.indexOf(45) + 1));
                        System.out.println("month: " + array5[n11] + "  day: " + array6[n11]);
                    }
                    break;
                }
                case 6: {
                    i4 = Integer.parseInt(JOptionPane.showInputDialog("Enter total # of vacation days in " + (i + 1) + "\n(Please remember vacation days in " + i + " ONLY"));
                    array7 = new int[i4];
                    array8 = new int[i4];
                    for (int n12 = 0; n12 < i4; ++n12) {
                        final String showInputDialog6 = JOptionPane.showInputDialog("Enter date of vacation day #" + (n12 + 1) + "in " + (i + 1) + "\n (ie. 6-20 for Jun. 20th) ");
                        array7[n12] = Integer.parseInt(showInputDialog6.substring(0, showInputDialog6.indexOf(45)));
                        array8[n12] = Integer.parseInt(showInputDialog6.substring(showInputDialog6.indexOf(45) + 1));
                        System.out.println("month: " + array7[n12] + "  day: " + array8[n12]);
                    }
                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(this, "Invalid value entered");
                    return;
                }
            }
            randomAccessFile2.seek(0L);
            randomAccessFile2.writeInt(1);
            randomAccessFile2.writeInt(m);
            randomAccessFile2.writeInt(i2);
            randomAccessFile2.writeInt(n2);
            randomAccessFile2.writeInt(n3);
            randomAccessFile2.writeInt(n4);
            randomAccessFile2.writeInt(i3);
            for (int n13 = 0; n13 < i3; ++n13) {
                randomAccessFile2.writeInt(array5[n13]);
                randomAccessFile2.writeInt(array6[n13]);
            }
            randomAccessFile2.writeInt(i4);
            for (int n14 = 0; n14 < i4; ++n14) {
                randomAccessFile2.writeInt(array7[n14]);
                randomAccessFile2.writeInt(array8[n14]);
            }
            String str3 = "SCHOOL YEAR " + i + "-" + (i + 1) + "\n\nstart date: " + m + "-" + i2 + "\nlast PAYMENT month of school year: " + n2 + "\ntotal # of lessons in school year: " + n3 + "\ncost($) per lesson: " + n4 + "\ntotal vacation days in " + i + ": " + i3 + "\nvacation dates: ";
            for (int n15 = 0, n16 = 0; n15 < i3; ++n15, ++n16) {
                if (n16 == 4) {
                    str3 += "\n   ";
                    n16 = 0;
                }
                str3 = str3 + array5[n15] + "-" + array6[n15] + "-" + i + ", ";
            }
            String message = str3 + "\ntotal vacation days in " + (i + 1) + ": " + i4 + "\nvacation dates: ";
            for (int n17 = 0, n18 = 0; n17 < i4; ++n17, ++n18) {
                if (n18 == 4) {
                    message += "\n   ";
                    n18 = 0;
                }
                message = message + array7[n17] + "-" + array8[n17] + "-" + (i + 1) + ", ";
            }
            JOptionPane.showMessageDialog(this, message, "", 1);
        }
    }
    
    private void deleteRecord(final int n) throws IOException {
        final StudentRecord studentRecord = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        if (int1 == 0) {
            return;
        }
        this.output.seek(n * StudentRecord.size() + 10);
        studentRecord.read(this.output);
        final String firstName = studentRecord.getFirstName();
        final String lastName = studentRecord.getLastName();
        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + studentRecord.getFirstName() + " " + studentRecord.getLastName() + "?", "Delete Record Confirmation", 0) == 1) {
            return;
        }
        for (int i = n; i < int1 - 1; ++i) {
            this.output.seek((i + 1) * StudentRecord.size() + 10);
            studentRecord.read(this.output);
            this.output.seek(i * StudentRecord.size() + 10);
            studentRecord.write(this.output);
        }
        this.output.seek(0L);
        this.output.writeInt(int1 - 1);
        this.deleteFile(firstName, lastName);
    }
    
    private void deleteFile(final String str, final String str2) throws IOException {
        new File(str + "-" + str2 + ".txt").delete();
    }
    
    private int listByPaymentDue(final int n) throws IOException {
        int n2 = 0;
        final StudentRecord studentRecord = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        System.out.println("recordCount" + int1);
        final int[] array = new int[int1];
        if (int1 == 0) {
            JOptionPane.showMessageDialog(this, "No Records In File At This Time", "Message", 0);
            return 0;
        }
        for (int i = 0; i < int1; ++i) {
            studentRecord.resetAllFields();
            this.output.seek(i * StudentRecord.size() + 10);
            studentRecord.read(this.output);
            if (!studentRecord.getNextPaymentPaid()) {
                if (!studentRecord.getNextPaymentDiscontinued()) {
                    final int j = studentRecord.getNextPaymentYear() + 2008;
                    final int nextPaymentMonth = studentRecord.getNextPaymentMonth();
                    final int nextPaymentDay = studentRecord.getNextPaymentDay();
                    if (nextPaymentDay != 0) {
                        if (nextPaymentMonth != 0) {
                            System.out.println("Due year: " + j + "Due month: " + nextPaymentMonth + "Due day: " + nextPaymentDay);
                            System.out.println("Today year: " + this.todayYear + "Today month: " + this.todayMonth + "Today day: " + this.todayDay);
                            if (j < this.todayYear || (j <= this.todayYear && nextPaymentMonth < this.todayMonth) || (j <= this.todayYear && nextPaymentMonth <= this.todayMonth && nextPaymentDay <= this.todayDay)) {
                                array[n2] = i;
                                ++n2;
                            }
                        }
                    }
                }
            }
        }
        return n2;
    }
    
    private int listByIncompletePaymentAlertInfo(final int n) throws IOException {
        int n2 = 0;
        final StudentRecord studentRecord = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        System.out.println("recordCount" + int1);
        final int[] array = new int[int1];
        if (int1 == 0 && n != 0) {
            JOptionPane.showMessageDialog(this, "No Records In File At This Time", "Message", 0);
            return 0;
        }
        for (int i = 0; i < int1; ++i) {
            studentRecord.resetAllFields();
            this.output.seek(i * StudentRecord.size() + 10);
            studentRecord.read(this.output);
            if (studentRecord.getIsRegistered() && !studentRecord.getNextPaymentDiscontinued()) {
                if (!studentRecord.getNextPaymentPaid()) {
                    if (studentRecord.getNextPaymentMonth() == 0 || studentRecord.getNextPaymentDay() == 0) {
                        array[n2] = i;
                        ++n2;
                    }
                }
            }
        }
        return n2;
    }
    
    private void listByFirstName() throws IOException {
        final StudentRecord studentRecord = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        final int[] array = new int[int1];
        final String[] array2 = new String[int1];
        final String[] array3 = new String[int1];
        if (int1 == 0) {
            JOptionPane.showMessageDialog(this, "No Records In File At This Time", "Message", 0);
            return;
        }
        for (int i = 0; i < int1; ++i) {
            studentRecord.resetAllFields();
            this.output.seek(i * StudentRecord.size() + 10);
            studentRecord.read(this.output);
            if (i == 0) {
                array2[0] = studentRecord.getFirstName();
                array3[0] = studentRecord.getLastName();
                array[0] = 0;
            }
            else {
                for (int j = 0; j <= i; ++j) {
                    if (j == i) {
                        array2[j] = studentRecord.getFirstName();
                        array3[j] = studentRecord.getLastName();
                        array[j] = i;
                        break;
                    }
                    if (array2[j].compareTo(studentRecord.getFirstName()) >= 0) {
                        if (array2[j].compareTo(studentRecord.getFirstName()) != 0 || array3[j].compareTo(studentRecord.getLastName()) >= 0) {
                            for (int k = i - 1; k >= j; --k) {
                                array2[k + 1] = array2[k];
                                array3[k + 1] = array3[k];
                                array[k + 1] = array[k];
                            }
                            array2[j] = studentRecord.getFirstName();
                            array3[j] = studentRecord.getLastName();
                            array[j] = i;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("listbyfirstname");
    }
    
    private void listByBirthMonth() throws IOException {
        final StudentRecord studentRecord = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        final int[] array = new int[int1];
        final int[] array2 = new int[int1];
        final int[] array3 = new int[int1];
        if (int1 == 0) {
            JOptionPane.showMessageDialog(this, "No Records In File At This Time", "Message", 0);
            return;
        }
        for (int i = 0; i < int1; ++i) {
            studentRecord.resetAllFields();
            this.output.seek(i * StudentRecord.size() + 10);
            studentRecord.read(this.output);
            if (i == 0) {
                array2[0] = studentRecord.getBirthdayMonth();
                array3[0] = studentRecord.getBirthdayDay();
                array[0] = 0;
            }
            else {
                for (int j = 0; j <= i; ++j) {
                    if (j == i) {
                        array2[j] = studentRecord.getBirthdayMonth();
                        array3[j] = studentRecord.getBirthdayDay();
                        array[j] = i;
                        break;
                    }
                    if (array2[j] >= studentRecord.getBirthdayMonth()) {
                        if (array2[j] != studentRecord.getBirthdayMonth() || array3[j] >= studentRecord.getBirthdayDay()) {
                            for (int k = i - 1; k >= j; --k) {
                                array2[k + 1] = array2[k];
                                array3[k + 1] = array3[k];
                                array[k + 1] = array[k];
                            }
                            array2[j] = studentRecord.getBirthdayMonth();
                            array3[j] = studentRecord.getBirthdayDay();
                            array[j] = i;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    private void listByClassDay() throws IOException {
        final StudentRecord studentRecord = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        final int[] array = new int[int1];
        final int[] array2 = new int[int1];
        if (int1 == 0) {
            JOptionPane.showMessageDialog(this, "No Records In File At This Time", "Message", 0);
            return;
        }
        for (int i = 0; i < int1; ++i) {
            studentRecord.resetAllFields();
            this.output.seek(i * StudentRecord.size() + 10);
            studentRecord.read(this.output);
            if (i == 0) {
                array2[0] = studentRecord.getClassDay();
                array[0] = 0;
            }
            else {
                for (int j = 0; j <= i; ++j) {
                    if (j == i) {
                        array2[j] = studentRecord.getClassDay();
                        array[j] = i;
                        break;
                    }
                    if (array2[j] > studentRecord.getClassDay()) {
                        for (int k = i - 1; k >= j; --k) {
                            array2[k + 1] = array2[k];
                            array[k + 1] = array[k];
                        }
                        array2[j] = studentRecord.getClassDay();
                        array[j] = i;
                        break;
                    }
                }
            }
        }
    }
    
    private void listByClass() throws IOException {
        final StudentRecord studentRecord = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        final int[] array = new int[int1];
        final int[] array2 = new int[int1];
        final int[] array3 = new int[int1];
        final int[] array4 = new int[int1];
        if (int1 == 0) {
            JOptionPane.showMessageDialog(this, "No Records In File At This Time", "Message", 0);
            return;
        }
        for (int i = 0; i < int1; ++i) {
            studentRecord.resetAllFields();
            this.output.seek(i * StudentRecord.size() + 10);
            studentRecord.read(this.output);
            if (i == 0) {
                array2[0] = studentRecord.getClassType();
                array3[0] = studentRecord.getClassDay();
                array4[0] = studentRecord.getClassPeriod();
                array[0] = 0;
            }
            else {
                for (int j = 0; j <= i; ++j) {
                    if (j == i) {
                        array2[j] = studentRecord.getClassType();
                        array3[j] = studentRecord.getClassDay();
                        array4[j] = studentRecord.getClassPeriod();
                        array[j] = i;
                        break;
                    }
                    if (array2[j] >= studentRecord.getClassType()) {
                        if (array2[j] != studentRecord.getClassType() || array3[j] >= studentRecord.getClassDay()) {
                            if (array2[j] != studentRecord.getClassType() || array3[j] != studentRecord.getClassDay() || array4[j] >= studentRecord.getClassPeriod()) {
                                for (int k = i - 1; k >= j; --k) {
                                    array2[k + 1] = array2[k];
                                    array3[k + 1] = array3[k];
                                    array4[k + 1] = array4[k];
                                    array[k + 1] = array[k];
                                }
                                array2[j] = studentRecord.getClassType();
                                array3[j] = studentRecord.getClassDay();
                                array4[j] = studentRecord.getClassPeriod();
                                array[j] = i;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void listByInstructor() throws IOException {
        final StudentRecord studentRecord = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        final int[] array = new int[int1];
        final String[] array2 = new String[int1];
        if (int1 == 0) {
            JOptionPane.showMessageDialog(this, "No Records In File At This Time", "Message", 0);
            return;
        }
        for (int i = 0; i < int1; ++i) {
            studentRecord.resetAllFields();
            this.output.seek(i * StudentRecord.size() + 10);
            studentRecord.read(this.output);
            if (i == 0) {
                array2[0] = studentRecord.getInstructorName();
                array[0] = 0;
            }
            else {
                for (int j = 0; j <= i; ++j) {
                    if (j == i) {
                        array2[j] = studentRecord.getInstructorName();
                        array[j] = i;
                        break;
                    }
                    if (array2[j].compareTo(studentRecord.getInstructorName()) >= 0 && array2[j].compareTo(studentRecord.getInstructorName()) != 0) {
                        for (int k = i - 1; k >= j; --k) {
                            array2[k + 1] = array2[k];
                            array[k + 1] = array[k];
                        }
                        array2[j] = studentRecord.getInstructorName();
                        array[j] = i;
                        break;
                    }
                }
            }
        }
    }
    
    private void addTeacherButtonPressed() {
        this.nsip.teacherInfoSetup();
        this.setEnabled(false);
        this.setVisible(false);
        this.nsip.setVisible(true);
        this.nsip.fillBookBox("");
    }
    
    private void addStudentButtonPressed() {
        this.nsip.studentInfoSetup();
        this.setEnabled(false);
        this.setVisible(false);
        this.nsip.setVisible(true);
        this.nsip.fillBookBox("");
    }
    
    private void openFile() {
        try {
            this.output = new RandomAccessFile("SchoolData.txt", "rw");
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "File does not exist", "Invalid File Name", 0);
        }
    }
    
    private void closeFile() {
        try {
            this.output.close();
            System.exit(0);
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error closing file", "Error", 0);
            System.exit(1);
        }
    }
    
    public static void main(final String[] array) {
        new HomePage().addWindowListener(new WindowAdapter() {
            public void WindowClosing(final WindowEvent windowEvent) {
                System.out.println("System closing");
                System.exit(0);
            }
        });
    }
    
    private String listRecentBirthday() throws IOException {
        final int n = 16;
        final StudentRecord studentRecord = new StudentRecord();
        String string = "Search Birthday Failed";
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        final int dayofYear = this.ml.getDayofYear(new Date().getMonth() + 1, new Date().getDate());
        int n2 = 0;
        if (int1 == 0) {
            JOptionPane.showMessageDialog(this, "No Records In File At This Time", "Message", 0);
            return string;
        }
        final ArrayList list = new ArrayList();
        for (int i = 0; i < int1; ++i) {
            studentRecord.resetAllFields();
            this.output.seek(i * StudentRecord.size() + 10);
            studentRecord.read(this.output);
            if (!studentRecord.getIsWithdraw(this.todayYear, this.todayMonth, this.todayDay)) {
                final int dayofYear2 = this.ml.getDayofYear(studentRecord.getBirthdayMonth(), studentRecord.getBirthdayDay());
                if (dayofYear2 <= dayofYear + 7 && dayofYear2 >= dayofYear) {
                    if (n2 == 0) {
                        string = "Recent Birthdays: \n";
                    }
                    string = String.valueOf(string) + (dayofYear2 - dayofYear) + studentRecord.getBirthdayMonth() + "/" + studentRecord.getBirthdayDay() + "&nbsp;&nbsp;" + studentRecord.getFirstName() + " " + studentRecord.getLastName() + "\n";
                    list.add(String.valueOf(Integer.toString(dayofYear2 - dayofYear)) + studentRecord.getBirthdayMonth() + "/" + studentRecord.getBirthdayDay() + "&nbsp;&nbsp;" + studentRecord.getFirstName() + " " + studentRecord.getLastName());
                    ++n2;
                }
            }
        }
        Collections.sort(list);
        for (int j = 0; j < list.size(); ++j) {
            System.out.println(list.get(j));
            this.AddToBirthdayList(((String)list.get(j)).substring(1));
        }
        String string2 = "";
        for (int n3 = n - n2, k = 0; k < n3; ++k) {
            string2 = String.valueOf(string2) + "<br>";
        }
        System.out.println(string);
        this.mRecentBirthdays.setText("<html><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br><br>" + this.mRecentBirthdayList + string2 + "</html>");
        return string;
    }
    
    private void AddToBirthdayList(final String str) {
        this.mRecentBirthdayList = String.valueOf(this.mRecentBirthdayList) + "<br>&nbsp;&nbsp;" + str;
    }
    
    /*private class PasswordFieldHandler implements ActionListener
    {
        public void actionPerformed(final ActionEvent actionEvent) {
            if (actionEvent.getSource() == HomePage) {
                final char[] password = getPassword();
                String string = "";
                for (int i = 0; i < password.length; ++i) {
                    string += password[i];
                }
                if (string.trim().compareTo("henry2") == 0) {
                    HomePage.this.adminSignedIn = true;
                    HomePage.this.nct.setAdminSignedIn(true);
                    JOptionPane.showMessageDialog(null, "Sign-In Successful!", "Access", -1);
                    setVisible(false);
                    setText("");
                    remove(8);
                    validate();
                    HomePage.access$1900(HomePage.this).remove(7);
                    HomePage.access$1900(HomePage.this).validate();
                    HomePage.access$1900(HomePage.this).add(HomePage.access$2000(HomePage.this));
                    HomePage.access$1900(HomePage.this).validate();
                    HomePage.this.validate();
                    HomePage.this.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Password!", "Warning", 0);
                    HomePage.access$1800(HomePage.this).setVisible(false);
                    HomePage.access$1800(HomePage.this).setText("");
                    HomePage.access$1900(HomePage.this).remove(8);
                    HomePage.access$1900(HomePage.this).validate();
                }
            }
        }
    } */
    
    private class ScanFieldHandler implements ActionListener
    {
        public void actionPerformed(final ActionEvent actionEvent) {
            if (actionEvent.getSource() == HomePage.this.scanTextField) {
                final String text = HomePage.this.scanTextField.getText();
                try {
                    //HomePage.this.searchRecord(1, text, true);
                    searchStudents(text, true);
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "IOException @ School:SearchRecord()", "Error", 0);
                }
            }
        }
    }
}