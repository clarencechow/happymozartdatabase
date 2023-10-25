import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.io.File;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Icon;
import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.RandomAccessFile;
import javax.swing.SpringLayout;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

public class NewClassTracker extends JFrame implements MouseListener, KeyListener
{
    private SpringLayout layout;
    private RandomAccessFile output;
    private RandomAccessFile history;
    private RandomAccessFile list;
    private JTextField[] textFields;
    private JTextField absentCountTF;
    private JPanel[] panels;
    private JPanel p;
    private JLabel[] labels;
    private JLabel[] l;
    public StudentRecord sr;
    public MakeupList ml;
    public NewStudentInfoPage nsip;
    public HomePage hp;
    public JButton[] buttons;
    private JComboBox[] combo;
    private String[] classDays;
    private String[] timeHours;
    private String[] timeMins;
    private String[] timeQuarterlyMins;
    private String[] timeAMPM;
    private String[] selectInput;
    private String[] dateMonths;
    private String[] birthdayYears;
    private String[] dateDays;
    private String[] dateYears;
    private String[] labelNames;
    private JLabel[] timeLabel;
    private int todayMonth;
    private int todayDay;
    private int todayYear;
    private int recordNumber;
    private int nowHour;
    private int nowMinute;
    private int nowAMPM;
    private String todayDayOfWeek;
    private Container c;
    private TrackerHistory th;
    private Icon trackerHistoryIcon;
    private Icon saveIcon;
    private Icon closeIcon;
    private Icon inputIcon;
    private Icon happyMozartIcon;
    private JLabel pictureLabel;
    private JLabel happyMozartLabel;
    private JLabel withdrewLabel;
    private JTextArea studentTA;
    private JTextArea parentTA;
    private JTextArea classTA;
    private JTextArea commentTA;
    private JTextArea makeupListTA;
    private JScrollPane scroller;
    private JScrollPane commentScroller;
    private JPanel timeStampPanel;
    private JButton pictureButton;
    private JButton editInfoButton;
    private JButton deleteButton;
    private JButton backwardButton;
    private JButton forwardButton;
    private JButton makeupBackwardButton;
    private JButton makeupForwardButton;
    private boolean adminSignedIn;
    private WithdrawPage wp;
    private JTextField[] mlist;
    private int makeupCounter;
    private int makeupPointer;
    private int[] makeupListPosition;
    private String makeupMonth;
    private String makeupYear;
    private String makeupDay;
    private boolean withdraw;
    private boolean MLSaved;
    private JTextField[] m3;
    private JScrollPane bookShow;
    private JTextArea bookArea;
    private JButton adminButton;
    private Icon adminNormal;
    private Icon adminSmile;
    private JButton updateButton;
    private Icon updateIcon;
    private Booklist bl;
    private JComboBox[] studentBooks;
    private JTextField typeField;
    private String[] start;
    private JLabel booksLabel;
    
    public NewClassTracker() {
        super("Class Tracker");
        this.classDays = new String[] { "", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        this.timeHours = new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
        this.timeMins = new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" };
        this.timeQuarterlyMins = new String[] { "00", "15", "30", "45" };
        this.timeAMPM = new String[] { "AM", "PM" };
        this.selectInput = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" };
        this.dateMonths = new String[] { "", "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        this.birthdayYears = new String[] { "", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" };
        this.dateDays = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        this.dateYears = new String[] { "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033" };
        this.labelNames = new String[] { "Student Name: ", "Class Name:   ", " 1.", " 2.", " 3.", " 4.", " 5.", " 6.", "          7.", "          8.", "          9.", "        10.", "        11.", "        12.", "Missed                                               Make-up", " 1.", " ------------->", " 2.", " ------------->", "(     MM-DD-YY     )", "(     MM-DD(XX)     )", "  Day: ", "            ", "(A)-Absent       (C)-Charged       (W)-Absent w/o Notice       (N)-No Show", "           " };
        this.c = this.getContentPane();
        this.adminSignedIn = false;
        this.start = new String[] { "", "" };
        this.sr = new StudentRecord();
        this.th = new TrackerHistory();
        (this.wp = new WithdrawPage()).setNewClassTracker(this);
        this.timeLabel = new JLabel[4];
        this.panels = new JPanel[18];
        this.buttons = new JButton[7];
        this.combo = new JComboBox[8];
        this.labels = new JLabel[this.labelNames.length];
        this.textFields = new JTextField[50];
        this.mlist = new JTextField[35];
        this.m3 = new JTextField[5];
        this.bookArea = new JTextArea();
        this.bookShow = new JScrollPane(this.bookArea);
        this.studentBooks = new JComboBox[4];
        for (int i = 0; i < this.studentBooks.length; ++i) {
            this.studentBooks[i] = new JComboBox(this.start);
        }
        (this.typeField = new JTextField(40)).setText("");
        this.booksLabel = new JLabel("Add Books");
        this.adminNormal = new ImageIcon("administrator_icon.jpg");
        this.adminSmile = new ImageIcon("administrator_smile_icon.jpg");
        if (!this.adminSignedIn) {
            this.adminButton = new JButton(this.adminNormal);
        }
        else {
            this.adminButton = new JButton(this.adminSmile);
        }
        this.adminButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.updateIcon = new ImageIcon("update_icon.jpg");
        (this.updateButton = new JButton(this.updateIcon)).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.l = new JLabel[50];
        this.getDateTime();
        this.trackerHistoryIcon = new ImageIcon("tracker_history_icon1.jpg");
        this.closeIcon = new ImageIcon("close_icon.jpg");
        this.saveIcon = new ImageIcon("save_book_icon.jpg");
        this.inputIcon = new ImageIcon("input_icon.jpg");
        this.pictureButton = new JButton();
        this.happyMozartLabel = new JLabel(new ImageIcon("happy_mozart_icon4.jpg"));
        final Font font = new Font("", 1, 10);
        this.studentTA = new JTextArea();
        this.classTA = new JTextArea();
        this.parentTA = new JTextArea();
        this.timeStampPanel = new JPanel();
        this.commentTA = new JTextArea();
        this.commentScroller = new JScrollPane(this.commentTA);
        this.makeupListTA = new JTextArea();
        this.scroller = new JScrollPane(this.makeupListTA);
        this.editInfoButton = new JButton(new ImageIcon("edit_info_icon.jpg"));
        this.deleteButton = new JButton(new ImageIcon("delete_record2_icon.jpg"));
        this.withdrewLabel = new JLabel(new ImageIcon("withdrew.png"));
        this.forwardButton = new JButton(new ImageIcon("forward2.jpg"));
        this.backwardButton = new JButton(new ImageIcon("backward2.jpg"));
        this.makeupBackwardButton = new JButton(new ImageIcon("backward_icon.png"));
        this.makeupForwardButton = new JButton(new ImageIcon("forward_icon.png"));
        final int n = 0;
        this.makeupPointer = n;
        this.makeupCounter = n;
        this.makeupListPosition = new int[49];
        final String makeupMonth = "";
        this.makeupDay = makeupMonth;
        this.makeupYear = makeupMonth;
        this.makeupMonth = makeupMonth;
        this.timeLabel[0] = new JLabel("Input");
        this.timeLabel[1] = new JLabel("Date");
        this.timeLabel[2] = new JLabel("Day");
        this.timeLabel[3] = new JLabel("Time");
        for (int j = 0; j < this.timeLabel.length; ++j) {
            this.timeLabel[j].setFont(new Font("", 1, 12));
            this.timeLabel[j].setForeground(new Color(255, 102, 0));
        }
        this.combo[0] = new JComboBox(this.selectInput);
        this.combo[1] = new JComboBox(this.dateMonths);
        this.combo[2] = new JComboBox(this.dateDays);
        this.combo[3] = new JComboBox(this.dateYears);
        this.combo[4] = new JComboBox(this.classDays);
        this.combo[5] = new JComboBox(this.timeHours);
        this.combo[6] = new JComboBox(this.timeMins);
        this.combo[7] = new JComboBox(this.timeAMPM);
        this.buttons[0] = new JButton(new ImageIcon("clock-icon.png"));
        this.buttons[1] = new JButton(new ImageIcon("home_page_icon.jpg"));
        this.buttons[2] = new JButton(new ImageIcon("save_book_icon.jpg"));
        this.buttons[3] = new JButton(new ImageIcon("view_history_icon.jpg"));
        this.buttons[4] = new JButton(new ImageIcon("renew_year_icon.jpg"));
        this.buttons[5] = new JButton(new ImageIcon("withdraw_icon.jpg"));
        this.buttons[6] = new JButton(new ImageIcon("clipboard_icon.jpg"));
        for (int k = 0; k < this.buttons.length; ++k) {
            this.buttons[k].setBackground(Color.WHITE);
            this.buttons[k].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        }
        this.deleteButton.setBackground(Color.WHITE);
        this.deleteButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        for (int l = 0; l < this.labelNames.length; ++l) {
            this.labels[l] = new JLabel(this.labelNames[l]);
        }
        for (int n2 = 0; n2 < this.panels.length; ++n2) {
            this.panels[n2] = new JPanel();
        }
        (this.absentCountTF = new JTextField(2)).setEditable(false);
        this.textFields[0] = new JTextField(10);
        this.textFields[1] = new JTextField(10);
        for (int n3 = 0; n3 < this.mlist.length; ++n3) {
            if (n3 % 7 == 0) {
                this.mlist[n3] = new JTextField(2);
            }
            else if (n3 % 7 == 4) {
                this.mlist[n3] = new JTextField(8);
            }
            else {
                this.mlist[n3] = new JTextField(6);
            }
        }
        for (int n4 = 0; n4 < this.m3.length; ++n4) {
            this.m3[n4] = new JTextField(6);
        }
        for (int n5 = 2; n5 < this.textFields.length; ++n5) {
            this.textFields[n5] = new JTextField(15);
        }
        this.textFields[0].setEditable(false);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent windowEvent) {
                try {
                    NewClassTracker.this.saveMakeupList();
                }
                catch (IOException ex) {
                    System.out.println("saving error");
                }
                NewClassTracker.this.clearFields();
                NewClassTracker.this.setVisible(false);
                NewClassTracker.this.hp.setEnabled(true);
                NewClassTracker.this.hp.setVisible(true);
            }
        });
        this.adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                if (NewClassTracker.this.adminSignedIn) {
                    NewClassTracker.this.adminSignedIn = false;
                    NewClassTracker.this.hp.setAdminSignedIn(false);
                    NewClassTracker.this.adminButton.setIcon(NewClassTracker.this.adminNormal);
                    NewClassTracker.this.backwardButton.setVisible(false);
                    NewClassTracker.this.backwardButton.setEnabled(false);
                    NewClassTracker.this.forwardButton.setVisible(false);
                    NewClassTracker.this.forwardButton.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Administrator Signed Out", "Access", -1);
                }
                else if (JOptionPane.showInputDialog(null, "Enter Password", null).trim().equals("henry2")) {
                    NewClassTracker.this.adminSignedIn = true;
                    NewClassTracker.this.hp.setAdminSignedIn(true);
                    NewClassTracker.this.backwardButton.setVisible(true);
                    NewClassTracker.this.backwardButton.setEnabled(true);
                    NewClassTracker.this.forwardButton.setVisible(true);
                    NewClassTracker.this.forwardButton.setEnabled(true);
                    NewClassTracker.this.adminButton.setIcon(NewClassTracker.this.adminSmile);
                }
                else {
                    JOptionPane.showMessageDialog(null, "INCORRECT PASSWORD", "Access", -1);
                }
            }
        });
        this.updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                try {
                    NewClassTracker.this.saveTracker();
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error At ClassTracker.saveTracker", "Error Thrown", 0);
                }
            }
        });
        this.typeField.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent keyEvent) {
                NewClassTracker.this.fillBookBox(NewClassTracker.this.typeField.getText());
            }
        });
        this.pictureButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                System.out.println("in pictureButton");
                final JFileChooser fileChooser = new JFileChooser("C:\\StudentCheckList\\bin\\pictures");
                fileChooser.setFileSelectionMode(0);
                if (fileChooser.showOpenDialog(null) == 1) {
                    return;
                }
                final File selectedFile = fileChooser.getSelectedFile();
                System.out.println(selectedFile.getName());
                final ImageIcon imageIcon = new ImageIcon("pictures\\" + selectedFile.getName());
                final BufferedImage image = new BufferedImage(120, 145, 2);
                image.getGraphics().drawImage(imageIcon.getImage(), 0, 0, 120, 145, null);
                NewClassTracker.this.pictureButton.setIcon(new ImageIcon(image));
                NewClassTracker.this.sr.setPictureName(selectedFile.getName());
                try {
                    NewClassTracker.this.saveTracker();
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error At ClassTracker.saveTracker", "Error Thrown", 0);
                }
            }
        });
        this.editInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                if (!NewClassTracker.this.adminSignedIn) {
                    JOptionPane.showMessageDialog(null, "Must Be An Administrator To Edit Record..", "Warning", 0);
                    return;
                }
                try {
                    NewClassTracker.this.nsip.fillBookBox("");
                    NewClassTracker.this.nsip.viewEditStudent(NewClassTracker.this.recordNumber);
                    NewClassTracker.this.nsip.setVisible(true);
                    NewClassTracker.this.nsip.setEnabled(true);
                    NewClassTracker.this.setEnabled(false);
                    NewClassTracker.this.setVisible(false);
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error At ClassTracker.saveTracker", "Error Thrown", 0);
                }
            }
        });
        this.buttons[2].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                try {
                    NewClassTracker.this.saveBooks();
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error At ClassTracker.saveTracker", "Error Thrown", 0);
                }
            }
        });
        this.buttons[5].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                try {
                    NewClassTracker.this.wp.openWithdrawPage(NewClassTracker.this.recordNumber);
                    NewClassTracker.this.wp.setVisible(true);
                    NewClassTracker.this.setVisible(false);
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error At NewClassTracker:WithdrawPage", "Error Thrown", 0);
                }
            }
        });
        this.buttons[1].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                NewClassTracker.this.MLSaved = true;
                try {
                    NewClassTracker.this.saveMakeupList();
                }
                catch (IOException ex) {
                    System.out.println("saving error");
                }
                if (NewClassTracker.this.MLSaved) {
                    int showConfirmDialog = 0;
                    if (NewClassTracker.this.changesMade()) {
                        showConfirmDialog = JOptionPane.showConfirmDialog(null, "Changes Have Been Made.  Exit w/o Saving Changes?", "Exit Confirmation", 0);
                    }
                    if (showConfirmDialog == 0) {
                        NewClassTracker.this.clearFields();
                        NewClassTracker.this.setVisible(false);
                        NewClassTracker.this.closeFile();
                        NewClassTracker.this.hp.setEnabled(true);
                        NewClassTracker.this.hp.setVisible(true);
                    }
                }
            }
        });
        this.buttons[0].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                NewClassTracker.this.textFields[NewClassTracker.this.combo[0].getSelectedIndex()].setText(NewClassTracker.this.combo[1].getSelectedIndex() + "-" + NewClassTracker.this.combo[2].getSelectedIndex() + "-" + (NewClassTracker.this.combo[3].getSelectedIndex() + 2021) + " " + NewClassTracker.this.dayOfWeekIntToString(NewClassTracker.this.combo[4].getSelectedIndex()) + ". " + NewClassTracker.this.combo[5].getSelectedIndex() + ":" + NewClassTracker.this.timeMins[NewClassTracker.this.combo[6].getSelectedIndex()] + " " + NewClassTracker.this.timeAMPM[NewClassTracker.this.combo[7].getSelectedIndex()]);
                try {
                    NewClassTracker.this.saveTracker();
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error At ClassTracker.saveTracker", "Error Thrown", 0);
                }
            }
        });
        this.buttons[3].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                try {
                    NewClassTracker.this.th.printTrackerHistory(NewClassTracker.this.sr.getFirstName(), NewClassTracker.this.sr.getLastName());
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error At ClassTracker.printTrackerHistory()", "Error Thrown", 0);
                }
            }
        });
        this.buttons[4].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                if (!NewClassTracker.this.adminSignedIn) {
                    JOptionPane.showMessageDialog(null, "Must Be An Administrator To Edit Record..", "Warning", 0);
                    return;
                }
                try {
                    NewClassTracker.this.saveTracker();
                    NewClassTracker.this.saveToHistory();
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error At NewClassTracker.SaveHistory()", "Error Thrown", 0);
                }
            }
        });
        this.buttons[6].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                try {
                    NewClassTracker.this.clearFields();
                    NewClassTracker.this.setVisible(false);
                    NewClassTracker.this.ml.setVisible(true);
                    NewClassTracker.this.ml.searchList(NewClassTracker.this.sr.getFirstName() + " " + NewClassTracker.this.sr.getLastName());
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error At NewClassTracker.SaveHistory()", "Error Thrown", 0);
                }
            }
        });
        this.deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                if (!NewClassTracker.this.adminSignedIn) {
                    JOptionPane.showMessageDialog(null, "Must Be An Administrator To Delete Record..", "Warning", 0);
                    return;
                }
                try {
                    NewClassTracker.this.deleteRecord(NewClassTracker.this.recordNumber);
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error At NewClassTracker.SaveHistory()", "Error Thrown", 0);
                }
            }
        });
        this.forwardButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                NewClassTracker.this.MLSaved = true;
                try {
                    NewClassTracker.this.saveMakeupList();
                }
                catch (IOException ex) {
                    System.out.println("saving error");
                }
                if (NewClassTracker.this.MLSaved) {
                    if (!NewClassTracker.this.withdraw) {
                        NewClassTracker.this.withdraw = true;
                        while (NewClassTracker.this.withdraw) {
                            try {
                                NewClassTracker.this.clearFields();
                                NewClassTracker.this.viewNewClassTracker(NewClassTracker.this.recordNumber + 1);
                            }
                            catch (IOException ex2) {
                                JOptionPane.showMessageDialog(null, "Error At ClassTracker.saveTracker", "Error Thrown", 0);
                                NewClassTracker.this.withdraw = false;
                            }
                        }
                    }
                    else {
                        NewClassTracker.this.withdraw = false;
                        while (!NewClassTracker.this.withdraw) {
                            try {
                                NewClassTracker.this.clearFields();
                                NewClassTracker.this.viewNewClassTracker(NewClassTracker.this.recordNumber + 1);
                            }
                            catch (IOException ex3) {
                                JOptionPane.showMessageDialog(null, "Error At ClassTracker.saveTracker", "Error Thrown", 0);
                                NewClassTracker.this.withdraw = true;
                            }
                        }
                    }
                }
            }
        });
        this.backwardButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                NewClassTracker.this.MLSaved = true;
                try {
                    NewClassTracker.this.saveMakeupList();
                }
                catch (IOException ex) {
                    System.out.println("saving error");
                }
                if (NewClassTracker.this.MLSaved) {
                    if (!NewClassTracker.this.withdraw) {
                        NewClassTracker.this.withdraw = true;
                        while (NewClassTracker.this.withdraw) {
                            try {
                                NewClassTracker.this.clearFields();
                                NewClassTracker.this.viewNewClassTracker(NewClassTracker.this.recordNumber - 1);
                            }
                            catch (IOException ex2) {
                                JOptionPane.showMessageDialog(null, "Error At ClassTracker.saveTracker", "Error Thrown", 0);
                                NewClassTracker.this.withdraw = false;
                            }
                        }
                    }
                    else {
                        NewClassTracker.this.withdraw = false;
                        while (!NewClassTracker.this.withdraw) {
                            try {
                                NewClassTracker.this.clearFields();
                                NewClassTracker.this.viewNewClassTracker(NewClassTracker.this.recordNumber - 1);
                            }
                            catch (IOException ex3) {
                                JOptionPane.showMessageDialog(null, "Error At ClassTracker.saveTracker", "Error Thrown", 0);
                                NewClassTracker.this.withdraw = true;
                            }
                        }
                    }
                }
            }
        });
        this.makeupForwardButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                NewClassTracker.this.MLSaved = true;
                try {
                    NewClassTracker.this.saveMakeupList();
                }
                catch (IOException ex) {
                    System.out.println("saving error");
                }
                if (NewClassTracker.this.MLSaved) {
                    try {
                        if (NewClassTracker.this.makeupCounter >= (NewClassTracker.this.makeupPointer + 1) * 5) {
                            ++NewClassTracker.this.makeupPointer;
                            NewClassTracker.this.clearDisplayMakeups();
                            NewClassTracker.this.DisplayMakeups(NewClassTracker.this.makeupPointer);
                        }
                    }
                    catch (IOException ex2) {
                        JOptionPane.showMessageDialog(null, "Error At NewClassTracker:DisplayMakeups", "Error Thrown", 0);
                    }
                }
            }
        });
        this.makeupBackwardButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                NewClassTracker.this.MLSaved = true;
                try {
                    NewClassTracker.this.saveMakeupList();
                }
                catch (IOException ex) {
                    System.out.println("saving error");
                }
                if (NewClassTracker.this.MLSaved) {
                    try {
                        if (NewClassTracker.this.makeupPointer > 0) {
                            --NewClassTracker.this.makeupPointer;
                            NewClassTracker.this.clearDisplayMakeups();
                            NewClassTracker.this.DisplayMakeups(NewClassTracker.this.makeupPointer);
                        }
                    }
                    catch (IOException ex2) {
                        JOptionPane.showMessageDialog(null, "Error At NewClassTracker:DisplayMakeups", "Error Thrown", 0);
                    }
                }
            }
        });
        this.layout = new SpringLayout();
        (this.p = new JPanel(this.layout)).add(this.withdrewLabel);
        this.layout.putConstraint("North", this.withdrewLabel, 280, "North", this.p);
        this.layout.putConstraint("West", this.withdrewLabel, 550, "West", this.p);
        this.withdrewLabel.setVisible(false);
        this.p.add(this.forwardButton);
        this.forwardButton.setBackground(Color.WHITE);
        this.forwardButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.layout.putConstraint("North", this.forwardButton, 50, "North", this.p);
        this.layout.putConstraint("East", this.forwardButton, 0, "East", this.p);
        this.forwardButton.setVisible(false);
        this.forwardButton.setEnabled(false);
        this.p.add(this.backwardButton);
        this.backwardButton.setBackground(Color.WHITE);
        this.backwardButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.layout.putConstraint("North", this.backwardButton, 50, "North", this.p);
        this.layout.putConstraint("West", this.backwardButton, 0, "West", this.p);
        this.backwardButton.setVisible(false);
        this.backwardButton.setEnabled(false);
        this.p.add(this.makeupBackwardButton);
        this.makeupBackwardButton.setBackground(Color.WHITE);
        this.makeupBackwardButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.layout.putConstraint("North", this.makeupBackwardButton, 55, "North", this.timeStampPanel);
        this.layout.putConstraint("West", this.makeupBackwardButton, 5, "West", this.timeStampPanel);
        this.makeupBackwardButton.setVisible(true);
        this.makeupBackwardButton.setEnabled(true);
        this.p.add(this.makeupForwardButton);
        this.makeupForwardButton.setBackground(Color.WHITE);
        this.makeupForwardButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.layout.putConstraint("North", this.makeupForwardButton, 55, "North", this.timeStampPanel);
        this.layout.putConstraint("East", this.makeupForwardButton, -5, "East", this.timeStampPanel);
        this.makeupForwardButton.setVisible(true);
        this.makeupForwardButton.setEnabled(true);
        this.p.add(this.adminButton);
        this.layout.putConstraint("North", this.adminButton, 0, "South", this.timeStampPanel);
        this.layout.putConstraint("West", this.adminButton, 20, "West", this.p);
        this.adminButton.setVisible(true);
        this.adminButton.setEnabled(true);
        for (int n6 = 0; n6 < this.studentBooks.length; ++n6) {
            this.p.add(this.studentBooks[n6]);
            this.studentBooks[n6].setFont(font);
            this.studentBooks[n6].setPreferredSize(new Dimension(400, 18));
            this.studentBooks[n6].setBackground(Color.LIGHT_GRAY);
            this.layout.putConstraint("North", this.studentBooks[n6], n6 * 22 + 40, "South", this.timeStampPanel);
            this.layout.putConstraint("East", this.studentBooks[n6], -20, "East", this.timeStampPanel);
        }
        this.typeField.setFont(font);
        this.typeField.setBackground(Color.LIGHT_GRAY);
        this.p.add(this.typeField);
        this.layout.putConstraint("South", this.typeField, -7, "North", this.studentBooks[0]);
        this.layout.putConstraint("West", this.typeField, 0, "West", this.studentBooks[0]);
        this.p.add(this.booksLabel);
        this.booksLabel.setFont(font);
        this.layout.putConstraint("South", this.booksLabel, 0, "North", this.typeField);
        this.layout.putConstraint("West", this.booksLabel, 0, "West", this.typeField);
        final Font font2 = new Font("", 1, 9);
        for (int n7 = 0; n7 < 50; ++n7) {
            this.l[n7] = new JLabel(Integer.toString(n7 + 1) + ".");
            this.p.add(this.l[n7]);
            (this.textFields[n7] = new JTextField(16)).addKeyListener(this);
            this.l[n7].setLabelFor(this.textFields[n7]);
            this.p.add(this.textFields[n7]);
            this.textFields[n7].setFont(font);
            this.l[n7].setFont(font);
            if (n7 < 35) {
                this.p.add(this.mlist[n7]);
                this.mlist[n7].setFont(font2);
                this.mlist[n7].addKeyListener(this);
                if (n7 % 7 == 0) {
                    this.mlist[n7].setEditable(false);
                    this.mlist[n7].setBackground(Color.WHITE);
                }
            }
        }
        for (int n8 = 0; n8 < 5; ++n8) {
            this.p.add(this.m3[n8]);
            this.m3[n8].setFont(font2);
            this.m3[n8].addKeyListener(this);
        }
        for (int n9 = 0; n9 < 50; ++n9) {
            if (n9 == 0 || n9 % 4 == 0) {
                if (n9 < 9) {
                    this.layout.putConstraint("West", this.l[n9], 28, "West", this.p);
                }
                else {
                    this.layout.putConstraint("West", this.l[n9], 21, "West", this.p);
                }
            }
            else if (n9 < 9) {
                this.layout.putConstraint("West", this.l[n9], 28, "East", this.textFields[n9 - 1]);
            }
            else {
                this.layout.putConstraint("West", this.l[n9], 21, "East", this.textFields[n9 - 1]);
            }
            this.layout.putConstraint("West", this.textFields[n9], 5, "East", this.l[n9]);
            if (n9 < 4) {
                this.layout.putConstraint("North", this.l[n9], 5, "South", this.studentTA);
                this.layout.putConstraint("North", this.textFields[n9], 5, "South", this.studentTA);
            }
            else {
                this.layout.putConstraint("North", this.l[n9], 7, "South", this.textFields[n9 - 4]);
                this.layout.putConstraint("North", this.textFields[n9], 5, "South", this.textFields[n9 - 4]);
            }
        }
        for (int n10 = 0; n10 < 35; ++n10) {
            if (n10 == 0 || n10 % 7 == 0) {
                this.layout.putConstraint("West", this.mlist[n10], 22, "West", this.timeStampPanel);
            }
            else if (n10 % 7 == 5 || n10 % 7 == 1 || n10 % 7 == 2) {
                this.layout.putConstraint("West", this.mlist[n10], 10, "East", this.mlist[n10 - 1]);
            }
            else {
                this.layout.putConstraint("West", this.mlist[n10], 5, "East", this.mlist[n10 - 1]);
            }
            if (n10 < 7) {
                this.layout.putConstraint("North", this.mlist[n10], 30, "South", this.textFields[49]);
            }
            else {
                this.layout.putConstraint("North", this.mlist[n10], 3, "South", this.mlist[n10 - 7]);
            }
        }
        for (int n11 = 0; n11 < 5; ++n11) {
            this.layout.putConstraint("West", this.mlist[n11 * 7 + 5], 70, "East", this.mlist[n11 * 7 + 3]);
            this.layout.putConstraint("West", this.mlist[n11 * 7 + 4], 5, "East", this.mlist[n11 * 7 + 6]);
        }
        for (int n12 = 0; n12 < 5; ++n12) {
            this.layout.putConstraint("West", this.m3[n12], 5, "East", this.mlist[n12 * 7 + 3]);
            if (n12 == 0) {
                this.layout.putConstraint("North", this.m3[n12], 30, "South", this.textFields[49]);
            }
            else {
                this.layout.putConstraint("North", this.m3[n12], 3, "South", this.m3[n12 - 1]);
            }
        }
        final ImageIcon imageIcon = new ImageIcon("pictures\\load_pix_icon2.jpg");
        final BufferedImage image = new BufferedImage(120, 145, 2);
        image.getGraphics().drawImage(imageIcon.getImage(), 0, 0, 120, 145, null);
        this.pictureButton.setIcon(new ImageIcon(image));
        this.pictureButton.setBackground(Color.WHITE);
        this.pictureButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.p.add(this.pictureButton);
        this.layout.putConstraint("North", this.pictureButton, 5, "North", this.p);
        this.layout.putConstraint("West", this.pictureButton, 30, "West", this.p);
        this.p.add(this.studentTA);
        this.studentTA.setPreferredSize(new Dimension(240, 145));
        this.studentTA.setBackground(new Color(147, 216, 236));
        this.studentTA.setForeground(new Color(0, 102, 255));
        this.studentTA.setEditable(false);
        this.studentTA.setFont(font);
        this.layout.putConstraint("North", this.studentTA, 5, "North", this.p);
        this.layout.putConstraint("West", this.studentTA, 50, "East", this.pictureButton);
        this.p.add(this.classTA);
        this.classTA.setPreferredSize(new Dimension(180, 90));
        this.classTA.setBackground(new Color(243, 198, 196));
        this.classTA.setForeground(new Color(150, 77, 41));
        this.classTA.setEditable(false);
        this.classTA.setFont(font);
        this.layout.putConstraint("North", this.classTA, 5, "North", this.p);
        this.layout.putConstraint("West", this.classTA, 10, "East", this.studentTA);
        this.p.add(this.parentTA);
        this.parentTA.setPreferredSize(new Dimension(185, 90));
        this.parentTA.setBackground(new Color(193, 233, 145));
        this.parentTA.setForeground(new Color(13, 115, 46));
        this.parentTA.setEditable(false);
        this.parentTA.setFont(font);
        this.layout.putConstraint("North", this.parentTA, 5, "North", this.p);
        this.layout.putConstraint("West", this.parentTA, 10, "East", this.classTA);
        this.p.add(this.commentScroller);
        this.commentScroller.setPreferredSize(new Dimension(250, 50));
        this.commentTA.setBackground(new Color(155, 168, 227));
        this.commentTA.setForeground(new Color(104, 1, 126));
        this.commentTA.setFont(font);
        this.commentTA.setEditable(false);
        this.layout.putConstraint("North", this.commentScroller, 5, "South", this.classTA);
        this.layout.putConstraint("West", this.commentScroller, 0, "West", this.classTA);
        this.commentScroller.setHorizontalScrollBarPolicy(31);
        this.p.add(this.scroller);
        this.scroller.setPreferredSize(new Dimension(300, 120));
        this.makeupListTA.setBackground(new Color(112, 154, 209));
        this.makeupListTA.setForeground(new Color(32, 73, 240));
        this.scroller.setBackground(new Color(112, 154, 209));
        final TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "   Completed Makeups   ");
        titledBorder.setTitleJustification(2);
        this.scroller.setBorder(titledBorder);
        this.makeupListTA.setFont(new Font("", 1, 11));
        this.makeupListTA.setEditable(false);
        this.layout.putConstraint("North", this.scroller, 0, "North", this.timeStampPanel);
        this.layout.putConstraint("West", this.scroller, 0, "East", this.timeStampPanel);
        this.p.add(this.bookShow);
        this.bookArea.setFont(new Font("", 1, 15));
        this.bookArea.setEditable(false);
        this.bookArea.setBackground(new Color(178, 102, 255));
        this.bookShow.setPreferredSize(new Dimension(300, 120));
        this.layout.putConstraint("North", this.bookShow, 0, "South", this.scroller);
        this.layout.putConstraint("East", this.bookShow, 0, "East", this.scroller);
        this.bookShow.setBackground(new Color(178, 102, 255));
        this.bookShow.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.p.add(this.updateButton);
        this.layout.putConstraint("North", this.updateButton, 0, "South", this.adminButton);
        this.layout.putConstraint("West", this.updateButton, 5, "West", this.p);
        this.updateButton.setVisible(true);
        this.updateButton.setEnabled(true);
        this.p.add(this.editInfoButton);
        this.editInfoButton.setBackground(Color.WHITE);
        this.editInfoButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.layout.putConstraint("North", this.editInfoButton, -2, "North", this.commentScroller);
        this.layout.putConstraint("West", this.editInfoButton, 3, "East", this.commentScroller);
        this.p.add(this.happyMozartLabel);
        this.layout.putConstraint("North", this.happyMozartLabel, 0, "North", this.p);
        this.layout.putConstraint("West", this.happyMozartLabel, 5, "East", this.pictureButton);
        for (int n13 = 0; n13 < this.buttons.length - 1; ++n13) {
            this.p.add(this.buttons[n13]);
        }
        this.p.add(this.deleteButton);
        this.layout.putConstraint("North", this.buttons[0], 30, "North", this.timeStampPanel);
        this.layout.putConstraint("West", this.buttons[0], -70, "East", this.timeStampPanel);
        this.layout.putConstraint("North", this.buttons[1], 140, "South", this.timeStampPanel);
        this.layout.putConstraint("West", this.buttons[1], 25, "West", this.p);
        this.layout.putConstraint("North", this.buttons[2], 140, "South", this.timeStampPanel);
        this.layout.putConstraint("West", this.buttons[2], 45, "East", this.buttons[1]);
        this.layout.putConstraint("North", this.buttons[3], 140, "South", this.timeStampPanel);
        this.layout.putConstraint("West", this.buttons[3], 45, "East", this.buttons[2]);
        this.layout.putConstraint("North", this.buttons[5], 140, "South", this.timeStampPanel);
        this.layout.putConstraint("West", this.buttons[5], 45, "East", this.buttons[3]);
        this.layout.putConstraint("North", this.buttons[4], 140, "South", this.timeStampPanel);
        this.layout.putConstraint("West", this.buttons[4], 45, "East", this.buttons[5]);
        this.layout.putConstraint("North", this.deleteButton, -2, "North", this.commentScroller);
        this.layout.putConstraint("West", this.deleteButton, 3, "East", this.editInfoButton);
        this.p.add(this.timeStampPanel);
        this.timeStampPanel.setBackground(new Color(255, 204, 1));
        this.timeStampPanel.setPreferredSize(new Dimension(540, 120));
        this.layout.putConstraint("North", this.timeStampPanel, 10, "South", this.textFields[49]);
        this.layout.putConstraint("West", this.timeStampPanel, 5, "West", this.p);
        final TitledBorder titledBorder2 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "  #       Absent          Makeup1   Makeup2   Makeup3    Contact1    Contact2    Makeup Time ");
        titledBorder2.setTitleJustification(2);
        this.timeStampPanel.setBorder(titledBorder2);
        this.p.setBackground(Color.WHITE);
        this.c.setBackground(Color.WHITE);
        this.c.add(this.p);
        this.addMouseListener(this);
        this.setSize(860, 780);
        this.setResizable(false);
    }
    
    public void keyPressed(final KeyEvent keyEvent) {
        System.out.println("action performed");
        for (int i = 0; i < 35; ++i) {
            if (keyEvent.getSource() == this.mlist[i]) {
                this.mlist[i].setForeground(new Color(109, 207, 254));
            }
        }
        for (int j = 0; j < 50; ++j) {
            if (keyEvent.getSource() == this.textFields[j]) {
                this.textFields[j].setBackground(Color.white);
            }
        }
    }
    
    public void keyTyped(final KeyEvent keyEvent) {
    }
    
    public void keyReleased(final KeyEvent keyEvent) {
    }
    
    public void setBookShow() throws IOException {
        String string = "**************BOOKS**************";
        this.openHistoryFile(this.sr.getFirstName() + "-" + this.sr.getLastName() + ".txt");
        this.history.seek(1000000L);
        int int1;
        try {
            int1 = this.history.readInt();
        }
        catch (IOException ex) {
            System.out.println("no int at 1mil");
            int1 = 0;
        }
        this.history.seek(1000010L);
        for (int i = 0; i < int1; ++i) {
            string = string + "\n(" + (i + 1) + ")" + this.readString(this.history, 40);
        }
        this.bookArea.setText(string);
    }
    
    public void retriveMakeupListEntries(final String str) throws IOException {
        this.makeupPointer = 0;
        this.makeupCounter = 0;
        int makeupCounter = 0;
        if (str.length() == 0) {
            JOptionPane.showMessageDialog(null, "Error @ NewClassTracker Please Contact JC", "Error", 0);
            return;
        }
        if (this.list == null) {
            this.openMakeupFile();
        }
        this.list.seek(0L);
        final int int1 = this.list.readInt();
        if (int1 == 0) {
            this.DisplayMakeups(0);
            return;
        }
        for (int i = 0; i < int1; ++i) {
            this.list.seek(i * 300 + 10);
            if (this.readString(this.list, 25).indexOf(str) != -1) {
                this.makeupListPosition[makeupCounter] = i;
                ++makeupCounter;
            }
        }
        if ((this.makeupCounter = makeupCounter) == 0) {
            this.DisplayMakeups(0);
            return;
        }
        this.DisplayMakeups(0);
    }
    
    public void DisplayMakeups(final int n) throws IOException {
        final int n2 = n * 5;
        int n3 = 0;
        for (int n4 = n2, n5 = 0; n4 < this.makeupCounter && n4 < n2 + 5; ++n4, ++n5) {
            this.list.seek(this.makeupListPosition[n4] * 300 + 10);
            this.mlist[n3].setText(Integer.toString(this.makeupListPosition[n4] + 1));
            this.readString(this.list, 25).trim();
            final String trim = this.readString(this.list, 15).trim();
            for (int i = 1; i < 8; ++i) {
                if (i == 4) {
                    if (trim.length() != 0) {
                        this.mlist[n3 + i].setForeground(Color.black);
                        this.mlist[n3 + i].setText(trim);
                    }
                    else {
                        this.mlist[n3 + i].setForeground(new Color(109, 207, 254));
                    }
                }
                else if (i == 7) {
                    final String trim2 = this.readString(this.list, 10).trim();
                    if (trim2.length() != 0) {
                        this.m3[n3 / 7].setForeground(Color.black);
                        this.m3[n3 / 7].setText(trim2);
                    }
                    else {
                        this.m3[n3 / 7].setForeground(new Color(109, 207, 254));
                        this.m3[n3 / 7].setText(this.makeupMonth + "-??-" + this.makeupYear);
                    }
                }
                else {
                    final String trim3 = this.readString(this.list, 10).trim();
                    if (trim3.length() != 0) {
                        this.mlist[n3 + i].setForeground(Color.black);
                        this.mlist[n3 + i].setText(trim3);
                    }
                    else {
                        this.mlist[n3 + i].setForeground(new Color(109, 207, 254));
                        if (i < 4) {
                            this.mlist[n3 + i].setText(this.makeupMonth + "-??-" + this.makeupYear);
                        }
                        else {
                            this.mlist[n3 + i].setText(this.makeupMonth + "-" + this.makeupDay + "(??)");
                        }
                    }
                }
            }
            n3 = 7 * (n5 + 1);
        }
        if (this.makeupCounter < n2 + 5) {
            for (int j = this.makeupCounter % 5; j < 5; ++j) {
                this.mlist[j * 7].setText("N");
                for (int k = 1; k < 7; ++k) {
                    this.mlist[j * 7 + k].setForeground(new Color(109, 207, 254));
                    if (k < 4) {
                        this.mlist[j * 7 + k].setText(this.makeupMonth + "-??-" + this.makeupYear);
                    }
                    else if (k > 4) {
                        this.mlist[j * 7 + k].setText(this.makeupMonth + "-" + this.makeupDay + "(??)");
                    }
                }
                this.m3[j].setForeground(new Color(109, 207, 254));
                this.m3[j].setText(this.makeupMonth + "-??-" + this.makeupYear);
            }
        }
    }
    
    public void mouseClicked(final MouseEvent mouseEvent) {
        System.out.println("mouseclicked");
        try {
            this.absentCountTF.setText(Integer.toString(this.ml.searchList2(this.sr.getFirstName() + " " + this.sr.getLastName())));
            this.makeupListTA.setText(this.ml.searchList3(this.sr.getFirstName() + " " + this.sr.getLastName()));
            this.repaint();
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error At NewClassTracker.mouseClicked()", "Error Thrown", 0);
        }
    }
    
    public void mousePressed(final MouseEvent mouseEvent) {
    }
    
    public void mouseReleased(final MouseEvent mouseEvent) {
    }
    
    public void mouseEntered(final MouseEvent mouseEvent) {
    }
    
    public void mouseExited(final MouseEvent mouseEvent) {
    }
    
    public void setAdminSignedIn(final boolean adminSignedIn) {
        this.adminSignedIn = adminSignedIn;
        if (this.adminSignedIn) {
            this.backwardButton.setVisible(true);
            this.forwardButton.setVisible(true);
            this.backwardButton.setEnabled(true);
            this.forwardButton.setEnabled(true);
            this.adminButton.setIcon(this.adminSmile);
        }
        else {
            this.backwardButton.setVisible(false);
            this.forwardButton.setVisible(false);
            this.backwardButton.setEnabled(false);
            this.forwardButton.setEnabled(false);
            this.adminButton.setIcon(this.adminNormal);
        }
    }
    
    public void setHomePage(HomePage hp, NewStudentInfoPage nsip, MakeupList ml, Booklist bl) {
        this.hp = hp;
        this.nsip = nsip;
        this.ml = ml;
        this.bl = bl;
    }
    
    public void clearFields() {
        for (int i = 0; i < this.textFields.length; ++i) {
            this.textFields[i].setText("");
        }
        for (int j = 0; j < this.combo.length; ++j) {
            this.combo[j].setSelectedIndex(0);
        }
        this.makeupListTA.setText("");
        for (int k = 0; k < this.mlist.length; ++k) {
            this.mlist[k].setText("");
        }
        this.bookArea.setText("");
        for (int l = 0; l < this.studentBooks.length; ++l) {
            this.studentBooks[l].setSelectedItem("");
        }
        this.typeField.setText("");
    }
    
    private boolean changesMade() {
        final String[] input = this.sr.getInput();
        for (int i = 0; i < input.length; ++i) {
            if (input[i].compareTo(this.textFields[i].getText().trim()) != 0) {
                return true;
            }
        }
        return false;
    }
    
    private void getDateTime() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM");
        final SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("dd");
        final SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("EEE");
        final Date date = new Date();
        this.todayMonth = Integer.parseInt(simpleDateFormat2.format(date));
        this.todayYear = Integer.parseInt(simpleDateFormat.format(date));
        this.todayDay = Integer.parseInt(simpleDateFormat3.format(date));
        this.todayDayOfWeek = simpleDateFormat4.format(date);
        this.nowAMPM = 0;
        final String string = date.toString();
        this.nowHour = Integer.parseInt(string.substring(11, 13));
        this.nowMinute = Integer.parseInt(string.substring(14, 16));
        this.nowHour = this.nowHour;
        if (this.nowHour > 12) {
            this.nowHour -= 12;
            this.nowAMPM = 1;
        }
        this.makeupMonth = simpleDateFormat2.format(date);
        this.makeupYear = simpleDateFormat.format(date).substring(2);
        this.makeupDay = simpleDateFormat3.format(date);
    }
    
    public void deleteRecord(final int n) throws IOException {
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
        hp.setStudentArray();
        this.setVisible(false);
        this.hp.setEnabled(true);
        this.hp.setVisible(true);
    }
    
    private void deleteFile(final String str, final String str2) throws IOException {
        new File(str + "-" + str2 + ".txt").delete();
    }
    
    public void viewNewClassTracker(final int n) throws IOException {
        final String[] array = new String[50];
        int selectedIndex = 0;
        int n2 = 0;
        this.getDateTime();
        this.pictureButton.removeAll();
        if (this.output == null) {
            this.openFile();
        }
        System.out.println("rNumber: " + n);
        this.sr.resetAllFields();
        final RandomAccessFile output = this.output;
        final StudentRecord sr = this.sr;
        output.seek(n * StudentRecord.size() + 10);
        this.sr.read(this.output);
        final String[] input = this.sr.getInput();
        System.out.println("pix name: " + this.sr.getPictureName());
        final ImageIcon imageIcon = new ImageIcon("pictures\\" + this.sr.getPictureName());
        final BufferedImage image = new BufferedImage(120, 145, 2);
        image.getGraphics().drawImage(imageIcon.getImage(), 0, 0, 120, 145, null);
        this.pictureButton.setIcon(new ImageIcon(image));
        this.pictureButton.setBackground(Color.WHITE);
        this.pictureButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        for (int i = 0; i < 50; ++i) {
            if (input[i].trim().length() != 0) {
                this.textFields[i].setBackground(new Color(183, 203, 255));
                this.textFields[i].setText(input[i].trim());
            }
            else {
                this.textFields[i].setBackground(Color.white);
            }
            if (input[i].compareTo("") == 0 && n2 == 0) {
                selectedIndex = i;
                n2 = 1;
            }
        }
        this.layout.putConstraint("North", this.buttons[0], 0, "North", this.textFields[selectedIndex]);
        this.layout.putConstraint("West", this.buttons[0], 1, "East", this.textFields[selectedIndex]);
        this.combo[0].setSelectedIndex(selectedIndex);
        this.combo[4].setSelectedIndex(this.getDayOfWeek());
        this.combo[1].setSelectedIndex(this.todayMonth);
        this.combo[2].setSelectedIndex(this.todayDay);
        this.combo[3].setSelectedIndex(this.getYear());
        this.combo[5].setSelectedIndex(this.nowHour);
        this.combo[6].setSelectedIndex(this.nowMinute);
        this.combo[7].setSelectedIndex(this.nowAMPM);
        this.studentTA.setText("*************** STUDENT INFO *****************\n  " + this.sr.getFirstName() + "   " + this.sr.getLastName() + "\n\n");
        if (this.sr.getTelephoneNumber().length() == 10) {
            this.studentTA.append("  " + this.sr.getTelephoneNumber().substring(0, 3) + "-" + this.sr.getTelephoneNumber().substring(3, 6) + "-" + this.sr.getTelephoneNumber().substring(6) + ", ");
        }
        if (this.sr.getCellPhoneNumber().length() == 10) {
            this.studentTA.append("(C)" + this.sr.getCellPhoneNumber().substring(0, 3) + "-" + this.sr.getCellPhoneNumber().substring(3, 6) + "-" + this.sr.getCellPhoneNumber().substring(6));
        }
        
        this.studentTA.append("\n  " 
        + this.sr.getEMail() + "\n\n"
         + "  " + this.sr.getAddress() + "\n" + "  " 
         + this.sr.getCity()
         + ", " 
         + this.sr.getZipCode() + "\n\n" + "  " 
         + this.dateMonths[this.sr.getBirthdayMonth()] 
         + "-" + this.dateDays[this.sr.getBirthdayDay()] + "-" 
         + this.birthdayYears[this.sr.getBirthdayYear()] 
         + ",     ID: " + this.sr.getStudentTeacherId());
         
        this.classTA.setText("********** CLASS INFO ************\n  " + this.sr.getClassName() + "\n\n  " + this.sr.getInstructorName() + "\n\n  " + this.classDays[this.sr.getClassDay()] + ", " + this.sr.getClassTimeHour() + ":" + this.timeQuarterlyMins[this.sr.getClassTimeMin()] + this.timeAMPM[this.sr.getClassTimeAMPM()] + "(" + this.sr.getClassDuration() + "min)");
        if (this.sr.getClassDay2() != 0) {
            this.classTA.append("\n  " + this.classDays[this.sr.getClassDay2()] + ", " + this.sr.getClassTimeHour2() + ":" + this.timeQuarterlyMins[this.sr.getClassTimeMin2()] + this.timeAMPM[this.sr.getClassTimeAMPM2()] + "(" + this.sr.getClassDuration2() + "min)");
        }
        this.parentTA.setText("********* PARENT INFO ***********\n  " + this.sr.getDadName() + "\n\n  " + "(C)");
        if (this.sr.getParentCellPhoneNumber().length() == 10) {
            this.parentTA.append(this.sr.getParentCellPhoneNumber().substring(0, 3) + "-" + this.sr.getParentCellPhoneNumber().substring(3, 6) + "-" + this.sr.getParentCellPhoneNumber().substring(6));
        }
        this.parentTA.append("\n\n  " + this.sr.getParentEMail());
        System.out.println("comment: " + this.sr.getComment());
        if (this.sr.getComment().length() < 30) {
            this.commentTA.setText("******************** COMMENT ***************************\n " + this.sr.getComment());
        }
        else {
            final int lastIndex = this.sr.getComment().substring(0, 30).lastIndexOf(" ");
            this.commentTA.setText("******************** COMMENT ***************************\n " + this.sr.getComment().substring(0, lastIndex) + "\n" + this.sr.getComment().substring(lastIndex));
        }
        try {
            this.setBookShow();
        }
        catch (IOException ex) {
            System.out.println("ERROR SETTING BOOKS");
        }
        this.absentCountTF.setText(Integer.toString(this.ml.searchList2(this.sr.getFirstName() + " " + this.sr.getLastName())));
        this.makeupListTA.setText(this.ml.searchList3(this.sr.getFirstName() + " " + this.sr.getLastName()));
        this.makeupListTA.setCaretPosition(0);
        this.withdraw = false;
        final String lastdayDate = this.sr.getLastdayDate();
        if (lastdayDate.length() == 6) {
            final int int1 = Integer.parseInt(lastdayDate.substring(2, 4));
            final int int2 = Integer.parseInt(lastdayDate.substring(0, 2));
            final int j = Integer.parseInt(lastdayDate.substring(4)) + 2000;
            if (int1 != 0 && (int2 != 0 & j != 2007)) {
                System.out.println(int2 + " " + int1 + " " + j);
                System.out.println(this.todayMonth + " " + this.todayDay + " " + this.todayYear);
                if (j < this.todayYear || (j == this.todayYear && int2 < this.todayMonth) || (j == this.todayYear && int2 == this.todayMonth && int1 < this.todayDay)) {
                    this.withdrewLabel.setVisible(true);
                    this.withdraw = true;
                }
            }
        }
        if (!this.withdraw) {
            this.withdrewLabel.setVisible(false);
        }
        this.recordNumber = n;
        this.retriveMakeupListEntries(this.sr.getFirstName() + " " + this.sr.getLastName());
        this.DisplayMakeups(0);
        this.setVisible(true);
        if (this.withdraw) {
            this.p.repaint();
        }
        this.fillBookBox("");
    }
    
    public void saveTracker() throws IOException {
        final String[] input = new String[50];
        if (this.output == null) {
            this.openFile();
        }
        for (int i = 0; i < 50; ++i) {
            input[i] = this.textFields[i].getText().trim();
        }
        this.sr.setInput(input);
        final RandomAccessFile output = this.output;
        final int recordNumber = this.recordNumber;
        final StudentRecord sr = this.sr;
        output.seek(recordNumber * StudentRecord.size() + 10);
        this.sr.write(this.output);
        this.saveMakeupList();
        this.viewNewClassTracker(this.recordNumber);
        this.closeFile();
    }
    
    private boolean checkDateFormat(final String s) {
        try {
            if (s.compareTo(this.makeupMonth + "-??-" + this.makeupYear) == 0) {
                return true;
            }
            if (s.length() != 8) {
                JOptionPane.showMessageDialog(null, "Incorrect Date Format Found @ Absent & Makeup!!  Correct format is: MM-DD-YY", "Invalid Format", 0);
                return false;
            }
            Integer.parseInt(s.substring(0, 2));
            Integer.parseInt(s.substring(3, 5));
            Integer.parseInt(s.substring(6));
            if (s.substring(2, 3).compareTo("-") != 0 || s.substring(5, 6).compareTo("-") != 0) {
                JOptionPane.showMessageDialog(null, "Incorrect Date Format Found @ Absent & Makeup!!  Correct format is: MM-DD-YY", "Invalid Format", 0);
                return false;
            }
            return true;
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Incorrect Date Format Found @ Absent & Makeup!!  Correct format is: MM-DD-YY", "Invalid Format", 0);
            return false;
        }
    }
    
    private boolean checkContactFormat(final String s) {
        try {
            if (s.compareTo(this.todayMonth + "-" + this.todayDay + "(??)") == 0) {
                return true;
            }
            if (s.length() != 9) {
                JOptionPane.showMessageDialog(null, "Incorrect Date Format Found @ Contact!!  Correct format is: MM-DD(XX) \n **XX is for the initials of current recorder", "Invalid Format", 0);
                return false;
            }
            if (s.substring(5, 6).compareTo("(") != 0 || s.substring(8, 9).compareTo(")") != 0) {
                JOptionPane.showMessageDialog(null, "Incorrect Date Format Found @ Contact!!  Correct format is: MM-DD(XX) \n **XX is for the initials of current recorder", "Invalid Format", 0);
                return false;
            }
            if (s.length() != 0) {
                Integer.parseInt(s.substring(0, 2));
                Integer.parseInt(s.substring(3, 5));
            }
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Incorrect Date Format Found @ Contact!!  Correct format is: MM-DD(XX) \n **XX is for the initials of current recorder", "Invalid Format", 0);
            return false;
        }
        return true;
    }
    
    private void saveMakeupList() throws IOException {
        final String[] array = new String[7];
        final String string = this.makeupMonth + "-??-" + this.makeupYear;
        final String string2 = this.makeupMonth + "-" + this.makeupDay + "(??)";
        for (int i = 0; i < 5; ++i) {
            int n = 0;
            array[0] = this.mlist[i * 7].getText().trim();
            for (int j = 1; j < 7; ++j) {
                if (j < 4) {
                    if (this.mlist[i * 7 + j].getText().trim().compareTo(string) == 0) {
                        System.out.println("matched");
                        array[j] = "";
                    }
                    else {
                        array[j] = this.mlist[i * 7 + j].getText().trim();
                        System.out.println("not matched");
                    }
                }
                else if (j > 4) {
                    if (this.mlist[i * 7 + j].getText().trim().compareTo(string2) == 0) {
                        array[j] = "";
                    }
                    else {
                        array[j] = this.mlist[i * 7 + j].getText().trim();
                    }
                }
                else {
                    array[j] = this.mlist[i * 7 + j].getText().trim();
                }
            }
            String trim;
            if (this.m3[i].getText().trim().compareTo(string) == 0) {
                trim = "";
            }
            else {
                trim = this.m3[i].getText().trim();
            }
            if (array[2].length() == 0 && array[3].length() != 0) {
                JOptionPane.showMessageDialog(null, "Fill in date for Makeup1 before continuing to Makeup2", "Invalid Format", 0);
                this.MLSaved = false;
                return;
            }
            if (array[3].length() == 0 && trim.length() != 0) {
                JOptionPane.showMessageDialog(null, "Fill in date for Makeup2 before continuing to Makeup3", "Invalid Format", 0);
                this.MLSaved = false;
                return;
            }
            for (int k = 1; k < 4; ++k) {
                if (array[k].length() != 0) {
                    if (!this.checkDateFormat(array[k])) {
                        this.MLSaved = false;
                        return;
                    }
                    ++n;
                }
            }
            if (trim.length() != 0) {
                if (!this.checkDateFormat(trim)) {
                    this.MLSaved = false;
                    return;
                }
                ++n;
            }
            for (int l = 5; l < 7; ++l) {
                if (array[l].length() != 0) {
                    if (!this.checkContactFormat(array[l])) {
                        this.MLSaved = false;
                        return;
                    }
                    ++n;
                }
            }
            if (n > 0 && array[1].length() == 0) {
                JOptionPane.showMessageDialog(null, "Must Include A Absent Date To Create&Save A Makeup List Entry!", "Invalid Format", 0);
                this.MLSaved = false;
                return;
            }
            if (n > 0 && array[1].length() != 0) {
                this.saveMakeupListEntry(array, trim);
            }
        }
        this.clearDisplayMakeups();
        this.retriveMakeupListEntries(this.sr.getFirstName() + " " + this.sr.getLastName());
    }
    
    private void saveMakeupListEntry(final String[] array, final String s) throws IOException {
        if (this.list == null) {
            this.openMakeupFile();
        }
        this.list.seek(0L);
        final int int1 = this.list.readInt();
        System.out.println("here1");
        int int2;
        String s2;
        if (array[0].compareTo("N") == 0) {
            int2 = int1;
            s2 = this.sr.getFirstName() + " " + this.sr.getLastName();
        }
        else {
            int2 = Integer.parseInt(array[0].trim());
            --int2;
            this.list.seek(int2 * 300 + 10);
            s2 = this.readString(this.list, 25);
            this.readString(this.list, 15);
        }
        System.out.println("here2");
        this.list.seek(int2 * 300 + 10);
        this.writeString(this.list, s2, 25);
        this.writeString(this.list, array[4], 15);
        this.writeString(this.list, array[1], 10);
        this.writeString(this.list, array[2], 10);
        this.writeString(this.list, array[3], 10);
        this.writeString(this.list, array[5], 10);
        this.writeString(this.list, array[6], 10);
        this.writeString(this.list, s, 10);
        System.out.println("here3");
        if (array[0].compareTo("N") == 0) {
            this.list.seek(0L);
            this.list.writeInt(int1 + 1);
            ++this.makeupCounter;
        }
        System.out.println("here4");
    }
    
    private void clearDisplayMakeups() {
        for (int i = 0; i < 35; ++i) {
            this.mlist[i].setText("");
        }
    }
    
    private int getYear() {
        if (this.todayYear == 2021) {
            return 0;
        }
        if (this.todayYear == 2022) {
            return 1;
        }
        if (this.todayYear == 2023) {
            return 2;
        }
        if (this.todayYear == 2024) {
            return 3;
        }
        if (this.todayYear == 2025) {
            return 4;
        }
        if (this.todayYear == 2026) {
            return 5;
        }
        if (this.todayYear == 2027) {
            return 6;
        }
        if (this.todayYear == 2028) {
            return 7;
        }
        if (this.todayYear == 2029) {
            return 8;
        }
        if (this.todayYear == 2030) {
            return 9;
        }
        if (this.todayYear == 2031) {
            return 10;
        }
        if (this.todayYear == 2032) {
            return 11;
        }
        if (this.todayYear == 2033) {
            return 12;
        }
        return 0;
    }
    
    private String dayOfWeekIntToString(final int n) {
        final String s = "";
        if (n == 0) {
            return s;
        }
        if (n == 1) {
            return "Mon";
        }
        if (n == 2) {
            return "Tue";
        }
        if (n == 3) {
            return "Wed";
        }
        if (n == 4) {
            return "Thu";
        }
        if (n == 5) {
            return "Fri";
        }
        if (n == 6) {
            return "Sat";
        }
        if (n == 7) {
            return "Sun";
        }
        return s;
    }
    
    private int getDayOfWeek() {
        if (this.todayDayOfWeek.equals("Mon")) {
            return 1;
        }
        if (this.todayDayOfWeek.equals("Tue")) {
            return 2;
        }
        if (this.todayDayOfWeek.equals("Wed")) {
            return 3;
        }
        if (this.todayDayOfWeek.equals("Thu")) {
            return 4;
        }
        if (this.todayDayOfWeek.equals("Fri")) {
            return 5;
        }
        if (this.todayDayOfWeek.equals("Sat")) {
            return 6;
        }
        if (this.todayDayOfWeek.equals("Sun")) {
            return 7;
        }
        return 0;
    }
    
    public void saveToHistory() throws IOException {
        this.openHistoryFile(this.sr.getFirstName() + "-" + this.sr.getLastName() + ".txt");
        this.history.seek(0L);
        final int int1 = this.history.readInt();
        final RandomAccessFile history = this.history;
        final int n = int1;
        final StudentRecord sr = this.sr;
        history.seek(n * StudentRecord.trackerSize() + 10);
        final String[] input = this.sr.getInput();
        for (int i = 0; i < input.length; ++i) {
            for (int n2 = 25 - input[i].length(), j = 0; j < n2; ++j) {
                final StringBuffer sb = new StringBuffer();
                final String[] array = input;
                final int n3 = i;
                array[n3] = sb.append(array[n3]).append(" ").toString();
            }
        }
        String s = "     Instructor: " + this.sr.getInstructorName().trim() + "   Day: " + this.classDays[this.sr.getClassDay()] + "\n" + "     Time: " + this.timeHours[this.sr.getClassTimeHour()] + ":" + this.timeMins[this.sr.getClassTimeMin()] + this.timeAMPM[this.sr.getClassTimeAMPM()] + "\n";
        for (int k = 0; k < 50; ++k) {
            if (k % 3 == 0) {
                s += "\n";
            }
            if (k + 1 < 10) {
                s = s + "(" + (k + 1) + ")  " + input[k] + "  ";
            }
            else {
                s = s + "(" + (k + 1) + ") " + input[k] + "  ";
            }
        }
        this.writeString(this.history, s + "\n--MAKEUP LIST INFO--\n" + this.ml.printAndRemoveCompletedEntry(this.sr.getFirstName() + " " + this.sr.getLastName()), 2000);
        this.history.seek(0L);
        this.history.writeInt(int1 + 1);
        this.closeHistoryFile();
        this.viewNewClassTracker(this.recordNumber);
        this.th.printTrackerHistory(this.sr.getFirstName(), this.sr.getLastName());
        for (int l = 0; l < 50; ++l) {
            this.textFields[l].setText("");
        }
        this.saveTracker();
        this.combo[0].setSelectedIndex(0);
    }
    
    private void saveBooks() throws IOException {
        int i = 0;
        this.openHistoryFile(this.sr.getFirstName() + "-" + this.sr.getLastName() + ".txt");
        this.history.seek(1000000L);
        int int1;
        try {
            int1 = this.history.readInt();
        }
        catch (IOException ex) {
            System.out.println("no int at 1mil");
            int1 = 0;
        }
        this.history.seek(1000010L);
        for (int j = 0; j < int1; ++j) {
            this.readString(this.history, 40);
        }
        for (int k = 0; k < this.studentBooks.length; ++k) {
            if (this.studentBooks[k].getSelectedItem().toString().length() > 0) {
                this.writeString(this.history, this.studentBooks[k].getSelectedItem().toString().trim(), 40);
                ++i;
            }
        }
        this.history.seek(1000000L);
        this.history.writeInt(int1 + i);
        System.out.println("total books: " + int1 + i);
        this.closeHistoryFile();
        this.setBookShow();
        for (int l = 0; l < this.studentBooks.length; ++l) {
            this.studentBooks[l].setSelectedItem("");
        }
        this.typeField.setText("");
        JOptionPane.showMessageDialog(this, "Books Saved", null, -1);
    }
    
    public void fillBookBox(final String s) {
        for (int i = 0; i < this.studentBooks.length; ++i) {
            final String string = this.studentBooks[i].getSelectedItem().toString();
            this.studentBooks[i].removeAllItems();
            this.studentBooks[i].addItem(string);
            this.studentBooks[i].addItem("");
        }
        if (s.length() == 0) {
            for (int j = 0; j < this.bl.getBookCount(); ++j) {
                this.studentBooks[0].addItem(this.bl.getBook(j));
                this.studentBooks[1].addItem(this.bl.getBook(j));
                this.studentBooks[2].addItem(this.bl.getBook(j));
                this.studentBooks[3].addItem(this.bl.getBook(j));
            }
        }
        else {
            for (int k = 0; k < this.bl.getBookCount(); ++k) {
                if (this.bl.getBook(k).toLowerCase().indexOf(s.toLowerCase()) != -1) {
                    this.studentBooks[0].addItem(this.bl.getBook(k));
                    this.studentBooks[1].addItem(this.bl.getBook(k));
                    this.studentBooks[2].addItem(this.bl.getBook(k));
                    this.studentBooks[3].addItem(this.bl.getBook(k));
                }
            }
        }
    }
    
    private void openHistoryFile(final String name) {
        try {
            this.history = new RandomAccessFile(name, "rw");
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "ClassInfoPage:OpenFile File does not exist", "Invalid File Name", 0);
        }
    }
    
    private void closeHistoryFile() {
        try {
            this.history.close();
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error closing file", "Error", 0);
        }
    }
    
    private String readString(final RandomAccessFile randomAccessFile, final int n) throws IOException {
        final char[] value = new char[n];
        for (int i = 0; i < value.length; ++i) {
            value[i] = randomAccessFile.readChar();
        }
        return new String(value).replace('\0', ' ');
    }
    
    private void writeString(final RandomAccessFile randomAccessFile, final String str, final int n) throws IOException {
        StringBuffer sb;
        if (str != null) {
            sb = new StringBuffer(str);
        }
        else {
            sb = new StringBuffer(n);
        }
        sb.setLength(n);
        randomAccessFile.writeChars(sb.toString());
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
            if (this.output != null) {
                this.output.close();
            }
            this.output = null;
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error closing file", "Error", 0);
        }
    }
    
    private void openMakeupFile() {
        try {
            this.list = new RandomAccessFile("MakupList.txt", "rw");
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "File does not exist", "Invalid File Name", 0);
        }
    }
    
    private void closeMakeupFile() {
        try {
            this.list.close();
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error closing file", "Error", 0);
            System.exit(1);
        }
    }
    
    public static void main(final String[] array) {
        new NewClassTracker().addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}