import java.awt.PrintJob;
import java.util.Properties;
import java.awt.Frame;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.SpringLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import java.io.File;
import javax.swing.JFileChooser;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.io.RandomAccessFile;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

public class NewStudentInfoPage extends JFrame
{
    private RandomAccessFile output;
    private JPanel[] panels;
    private JButton[] buttons;
    private JLabel[] labels;
    private JTextField[] textFields;
    private JTextField idTextField;
    private String[] classNames;
    private String[] dateMonths;
    private String[] dateDays;
    private String[] numberToData;
    private String[] yearToData;
    private String[] dateYears;
    private String[] birthdayYears;
    private JComboBox birthdayMonthComboBox;
    private JComboBox birthdayDayComboBox;
    private JComboBox birthdayYearComboBox;
    private JComboBox classDayComboBox;
    private JComboBox timeHourComboBox;
    private JComboBox timeMinComboBox;
    private JComboBox timeAMPMComboBox;
    private JComboBox classDayComboBox2;
    private JComboBox timeHourComboBox2;
    private JComboBox timeMinComboBox2;
    private JComboBox timeAMPMComboBox2;
    private String[] comboBoxNames;
    private String[] classDays;
    private String[] timeHours;
    private String[] timeMins;
    private String[] timeAMPM;
    private String[] labelNames;
    private String[] buttonNames;
    private String teacherNames;
    public StudentRecord sr;
    public NewClassTracker nct;
    private HomePage hp;
    public int newOrOld;
    public int teacherOrStudent;
    private Icon viewClassIcon;
    private Icon saveIcon;
    private Icon closeIcon;
    private Icon newStudentTopIcon;
    private Icon happyMozartIcon;
    private Icon clearAllIcon;
    private JLabel NewStudentTopLabel;
    private JLabel HappyMozartLabel;
    private JLabel pictureLabel;
    private Graphics g;
    private JTextArea tf;
    private JButton loadPixButton;
    private JButton deleteButton;
    private JButton printerButton;
    public int studentOrTeacher;
    private Booklist bl;
    private JComboBox[] studentBooks;
    private JTextField typeField;
    private String[] start;
    private JLabel booksLabel;
    private JScrollPane commentScroller;
    
    public NewStudentInfoPage() {
        super("Student Information");
        this.classNames = new String[] { " Music Together ", "Music 4 Young Children", " Private Lesson ", "  Semi-Private Lesson  " };
        this.dateMonths = new String[] { "", "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        this.dateDays = new String[] { "", " 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        this.numberToData = new String[] { "", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        this.yearToData = new String[] { "", "91", "92", "93", "94", "95", "96", "97", "98", "99", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" };
        this.dateYears = new String[] { "2008", "2009", "2010", "2011", "2012" };
        this.birthdayYears = new String[] { "", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" };
        this.comboBoxNames = new String[] { "     Music Together     ", "Music 4 Young Children", "     Private Lesson     " };
        this.classDays = new String[] { "", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        this.timeHours = new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
        this.timeMins = new String[] { "00", "15", "30", "45" };
        this.timeAMPM = new String[] { "AM", "PM" };
        this.labelNames = new String[] { "First Name", "Last Name", "Phone#", "Address", "City", "Zip", "Birthday", "Class Day", "Class Time", "Duration", "Instrument", "Teacher's Name", "Class Information                                            ", "Parent Information", "Parent Name", "Cell Phone Number", "E-mail", "E-mail", "Cell#", "Comment (**500 letters max**)", "2nd Class Day", "Class Time", "Duration" };
        this.buttonNames = new String[] { "Add Class", "Class Information", "Delete Class", "Save Info", "Close w/o Save", "View Credit Card#" };
        this.teacherNames = "";
        this.start = new String[] { "", "" };
        this.sr = new StudentRecord();
        final Container contentPane = this.getContentPane();
        this.panels = new JPanel[19];
        this.buttons = new JButton[5];
        this.labels = new JLabel[this.labelNames.length];
        this.textFields = new JTextField[23];
        this.birthdayMonthComboBox = new JComboBox(this.dateMonths);
        this.birthdayDayComboBox = new JComboBox(this.dateDays);
        this.birthdayYearComboBox = new JComboBox(this.birthdayYears);
        this.classDayComboBox = new JComboBox(this.classDays);
        this.timeHourComboBox = new JComboBox(this.timeHours);
        this.timeMinComboBox = new JComboBox(this.timeMins);
        this.timeAMPMComboBox = new JComboBox(this.timeAMPM);
        this.classDayComboBox2 = new JComboBox(this.classDays);
        this.timeHourComboBox2 = new JComboBox(this.timeHours);
        this.timeMinComboBox2 = new JComboBox(this.timeMins);
        this.timeAMPMComboBox2 = new JComboBox(this.timeAMPM);
        this.closeIcon = new ImageIcon("cancel_icon.jpg");
        this.saveIcon = new ImageIcon("new_save_icon.jpg");
        this.clearAllIcon = new ImageIcon("clear_all_icon.jpg");
        this.viewClassIcon = new ImageIcon("view_class_icon.jpg");
        this.newStudentTopIcon = new ImageIcon("new_student_top_icon.jpg");
        this.NewStudentTopLabel = new JLabel(this.newStudentTopIcon);
        this.HappyMozartLabel = new JLabel(new ImageIcon("happy_mozart_icon2.jpg"));
        this.tf = new JTextArea();
        this.loadPixButton = new JButton(new ImageIcon("load_pix_icon.jpg"));
        this.idTextField = new JTextField();
        this.studentOrTeacher = 1;
        this.deleteButton = new JButton(new ImageIcon("delete_record_icon.jpg"));
        this.printerButton = new JButton(new ImageIcon("file-print-icon.png"));
        final JPanel c1 = new JPanel();
        final JPanel panel = new JPanel();
        final ImageIcon imageIcon = new ImageIcon("pictures\\load_pix_icon2.jpg");
        final BufferedImage image = new BufferedImage(110, 125, 2);
        image.getGraphics().drawImage(imageIcon.getImage(), 0, 0, 110, 125, null);
        this.pictureLabel = new JLabel(new ImageIcon(image));
        this.studentBooks = new JComboBox[4];
        for (int i = 0; i < this.studentBooks.length; ++i) {
            this.studentBooks[i] = new JComboBox(this.start);
        }
        (this.typeField = new JTextField(22)).setText("");
        this.booksLabel = new JLabel("Books");
        this.commentScroller = new JScrollPane(this.tf);
        this.buttons[0] = new JButton(this.buttonNames[0]);
        this.buttons[2] = new JButton(this.clearAllIcon);
        this.buttons[1] = new JButton(this.buttonNames[1], this.viewClassIcon);
        this.buttons[3] = new JButton(this.saveIcon);
        this.buttons[4] = new JButton(this.closeIcon);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent windowEvent) {
                if (NewStudentInfoPage.this.newOrOld == -1) {
                    NewStudentInfoPage.this.clearFields();
                    NewStudentInfoPage.this.setVisible(false);
                    NewStudentInfoPage.this.hp.setEnabled(true);
                    NewStudentInfoPage.this.hp.setVisible(true);
                }
                else {
                    NewStudentInfoPage.this.clearFields();
                    NewStudentInfoPage.this.setVisible(false);
                    NewStudentInfoPage.this.nct.setEnabled(true);
                    NewStudentInfoPage.this.nct.setVisible(true);
                }
                NewStudentInfoPage.this.fillBookBox("");
            }
        });
        this.typeField.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent keyEvent) {
                NewStudentInfoPage.this.fillBookBox(NewStudentInfoPage.this.typeField.getText());
            }
        });
        this.printerButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                try {
                    NewStudentInfoPage.this.doPrint();
                }
                catch (IOException ex) {}
            }
        });
        this.loadPixButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                final JFileChooser fileChooser = new JFileChooser("C:\\StudentCheckList\\bin\\pictures");
                fileChooser.setFileSelectionMode(0);
                if (fileChooser.showOpenDialog(null) == 1) {
                    return;
                }
                final File selectedFile = fileChooser.getSelectedFile();
                System.out.println(selectedFile.getName());
                final ImageIcon imageIcon = new ImageIcon("pictures\\" + selectedFile.getName());
                final BufferedImage image = new BufferedImage(110, 125, 2);
                image.getGraphics().drawImage(imageIcon.getImage(), 0, 0, 110, 125, null);
                NewStudentInfoPage.this.pictureLabel.setIcon(new ImageIcon(image));
                NewStudentInfoPage.this.sr.setPictureName(selectedFile.getName());
            }
        });
        this.buttons[3].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                try {
                    if (NewStudentInfoPage.this.newOrOld == -1) {
                        NewStudentInfoPage.this.addNewStudent();
                        
                    }
                    else if (NewStudentInfoPage.this.saveOldStudent(1) != -1) {
                        NewStudentInfoPage.this.nct.viewNewClassTracker(NewStudentInfoPage.this.newOrOld);
                        NewStudentInfoPage.this.nct.setEnabled(true);
                        NewStudentInfoPage.this.nct.setVisible(true);
                        NewStudentInfoPage.this.clearFields();
                        NewStudentInfoPage.this.setVisible(false);
                    }
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error At StudentInfoPage.AddNewStudent", "Error Thrown", 0);
                }
            }
        });
        this.buttons[4].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                if (NewStudentInfoPage.this.newOrOld == -1) {
                    int showConfirmDialog = 0;
                    if (NewStudentInfoPage.this.changesMade()) {
                        showConfirmDialog = JOptionPane.showConfirmDialog(null, "Changes Have Been Made.  Exit w/o Saving Changes?", "Exit Confirmation", 0);
                    }
                    if (showConfirmDialog == 0) {
                        NewStudentInfoPage.this.clearFields();
                        NewStudentInfoPage.this.setVisible(false);
                        NewStudentInfoPage.this.hp.setEnabled(true);
                        NewStudentInfoPage.this.hp.setVisible(true);
                    }
                }
                else {
                    NewStudentInfoPage.this.clearFields();
                    NewStudentInfoPage.this.setVisible(false);
                    NewStudentInfoPage.this.nct.setEnabled(true);
                    NewStudentInfoPage.this.nct.setVisible(true);
                }
            }
        });
        this.buttons[2].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                NewStudentInfoPage.this.clearFields();
            }
        });
        this.birthdayMonthComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent itemEvent) {
                if (NewStudentInfoPage.this.newOrOld == -1) {
                    NewStudentInfoPage.this.createID();
                }
                else if (NewStudentInfoPage.this.newOrOld != -1 && NewStudentInfoPage.this.sr.getBirthdayMonth() != NewStudentInfoPage.this.birthdayMonthComboBox.getSelectedIndex()) {
                    NewStudentInfoPage.this.createID();
                }
            }
        });
        this.birthdayDayComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent itemEvent) {
                if (NewStudentInfoPage.this.newOrOld == -1) {
                    NewStudentInfoPage.this.createID();
                }
                else if (NewStudentInfoPage.this.newOrOld != -1 && NewStudentInfoPage.this.sr.getBirthdayDay() != NewStudentInfoPage.this.birthdayDayComboBox.getSelectedIndex()) {
                    NewStudentInfoPage.this.createID();
                }
            }
        });
        this.birthdayYearComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent itemEvent) {
                if (NewStudentInfoPage.this.newOrOld == -1) {
                    NewStudentInfoPage.this.createID();
                }
                else if (NewStudentInfoPage.this.newOrOld != -1 && NewStudentInfoPage.this.sr.getBirthdayYear() != NewStudentInfoPage.this.birthdayYearComboBox.getSelectedIndex()) {
                    NewStudentInfoPage.this.createID();
                }
            }
        });
        for (int j = 0; j < this.panels.length; ++j) {
            this.panels[j] = new JPanel();
        }
        for (int k = 0; k < this.labels.length; ++k) {
            this.labels[k] = new JLabel(this.labelNames[k]);
        }
        this.textFields[0] = new JTextField(13);
        this.textFields[1] = new JTextField(14);
        this.textFields[2] = new JTextField(27);
        this.textFields[3] = new JTextField(13);
        this.textFields[4] = new JTextField(9);
        this.textFields[5] = new JTextField(3);
        this.textFields[6] = new JTextField(3);
        this.textFields[7] = new JTextField(4);
        this.textFields[8] = new JTextField(23);
        this.textFields[9] = new JTextField(20);
        this.textFields[10] = new JTextField(10);
        this.textFields[11] = new JTextField(20);
        this.textFields[12] = new JTextField(3);
        this.textFields[13] = new JTextField(3);
        this.textFields[14] = new JTextField(4);
        this.textFields[15] = new JTextField(32);
        this.textFields[16] = new JTextField(3);
        this.textFields[17] = new JTextField(3);
        this.textFields[18] = new JTextField(4);
        this.textFields[19] = new JTextField(13);
        this.textFields[20] = new JTextField(16);
        this.textFields[21] = new JTextField(5);
        this.textFields[22] = new JTextField(5);
        this.textFields[5].setText("650");
        this.textFields[4].setText("94402");
        for (int l = 0; l < 23; ++l) {
            this.textFields[l].setText("");
        }
        final SpringLayout layout = new SpringLayout();
        final JPanel panel2 = new JPanel(layout);
        final Font font = new Font("", 1, 11);
        for (int n = 0; n < this.labels.length; ++n) {
            this.labels[n].setFont(font);
        }
        for (int n2 = 0; n2 < 23; ++n2) {
            this.textFields[n2].setFont(font);
            this.textFields[n2].setBackground(Color.LIGHT_GRAY);
        }
        this.tf.setFont(font);
        this.tf.setBackground(Color.LIGHT_GRAY);
        panel2.add(this.NewStudentTopLabel);
        layout.putConstraint("West", this.NewStudentTopLabel, 0, "West", panel2);
        layout.putConstraint("North", this.NewStudentTopLabel, 0, "North", panel2);
        panel2.add(this.HappyMozartLabel);
        layout.putConstraint("West", this.HappyMozartLabel, 40, "West", panel2);
        layout.putConstraint("North", this.HappyMozartLabel, 5, "South", this.NewStudentTopLabel);
        panel2.add(this.pictureLabel);
        layout.putConstraint("West", this.pictureLabel, 10, "West", panel2);
        layout.putConstraint("North", this.pictureLabel, 20, "South", this.HappyMozartLabel);
        panel2.add(this.printerButton);
        this.printerButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("East", this.printerButton, -60, "East", panel2);
        layout.putConstraint("North", this.printerButton, -30, "South", this.NewStudentTopLabel);
        panel2.add(this.loadPixButton);
        this.loadPixButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("West", this.loadPixButton, 30, "West", panel2);
        layout.putConstraint("North", this.loadPixButton, 5, "South", this.pictureLabel);
        panel2.add(this.idTextField);
        this.idTextField.setFont(font);
        this.idTextField.setPreferredSize(new Dimension(100, 16));
        this.idTextField.setBackground(Color.WHITE);
        this.idTextField.setForeground(Color.RED);
        this.idTextField.setEditable(false);
        this.idTextField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("West", this.idTextField, 0, "West", this.pictureLabel);
        layout.putConstraint("South", this.idTextField, -1, "North", this.pictureLabel);
        panel2.add(this.labels[0]);
        panel2.add(this.labels[1]);
        panel2.add(this.labels[6]);
        layout.putConstraint("West", this.labels[0], 130, "West", panel2);
        layout.putConstraint("North", this.labels[0], 4, "South", this.HappyMozartLabel);
        layout.putConstraint("West", this.labels[1], 65, "East", this.labels[0]);
        layout.putConstraint("North", this.labels[1], 4, "South", this.HappyMozartLabel);
        layout.putConstraint("West", this.labels[6], 75, "East", this.labels[1]);
        layout.putConstraint("North", this.labels[6], 4, "South", this.HappyMozartLabel);
        panel2.add(this.textFields[0]);
        panel2.add(this.textFields[1]);
        layout.putConstraint("West", this.textFields[0], 130, "West", panel2);
        layout.putConstraint("North", this.textFields[0], 1, "South", this.labels[0]);
        layout.putConstraint("West", this.textFields[1], 65, "East", this.labels[0]);
        layout.putConstraint("North", this.textFields[1], 1, "South", this.labels[0]);
        panel2.add(this.birthdayMonthComboBox);
        panel2.add(this.birthdayDayComboBox);
        panel2.add(this.birthdayYearComboBox);
        this.birthdayMonthComboBox.setFont(font);
        this.birthdayDayComboBox.setFont(font);
        this.birthdayYearComboBox.setFont(font);
        this.birthdayMonthComboBox.setPreferredSize(new Dimension(90, 18));
        this.birthdayDayComboBox.setPreferredSize(new Dimension(43, 18));
        this.birthdayYearComboBox.setPreferredSize(new Dimension(60, 18));
        this.birthdayMonthComboBox.setBackground(Color.LIGHT_GRAY);
        this.birthdayDayComboBox.setBackground(Color.LIGHT_GRAY);
        this.birthdayYearComboBox.setBackground(Color.LIGHT_GRAY);
        layout.putConstraint("West", this.birthdayMonthComboBox, 75, "East", this.labels[1]);
        layout.putConstraint("North", this.birthdayMonthComboBox, 1, "South", this.labels[6]);
        layout.putConstraint("West", this.birthdayDayComboBox, 4, "East", this.birthdayMonthComboBox);
        layout.putConstraint("North", this.birthdayDayComboBox, 1, "South", this.labels[6]);
        layout.putConstraint("West", this.birthdayYearComboBox, 4, "East", this.birthdayDayComboBox);
        layout.putConstraint("North", this.birthdayYearComboBox, 1, "South", this.labels[6]);
        for (int n3 = 0; n3 < this.studentBooks.length; ++n3) {
            panel2.add(this.studentBooks[n3]);
            this.studentBooks[n3].setFont(font);
            this.studentBooks[n3].setPreferredSize(new Dimension(200, 18));
            this.studentBooks[n3].setBackground(Color.LIGHT_GRAY);
            layout.putConstraint("North", this.studentBooks[n3], n3 * 22 + 52, "South", this.commentScroller);
            layout.putConstraint("West", this.studentBooks[n3], 0, "West", this.commentScroller);
        }
        this.typeField.setFont(font);
        this.typeField.setBackground(Color.LIGHT_GRAY);
        panel2.add(this.typeField);
        layout.putConstraint("South", this.typeField, -15, "North", this.studentBooks[0]);
        layout.putConstraint("West", this.typeField, 0, "West", this.commentScroller);
        panel2.add(this.booksLabel);
        this.booksLabel.setFont(font);
        layout.putConstraint("North", this.booksLabel, 3, "South", this.commentScroller);
        layout.putConstraint("West", this.booksLabel, 0, "West", this.commentScroller);
        panel2.add(this.labels[3]);
        panel2.add(this.labels[4]);
        panel2.add(this.labels[5]);
        layout.putConstraint("West", this.labels[3], 130, "West", panel2);
        layout.putConstraint("North", this.labels[3], 5, "South", this.textFields[0]);
        layout.putConstraint("West", this.labels[4], 0, "West", this.textFields[3]);
        layout.putConstraint("North", this.labels[4], 5, "South", this.textFields[0]);
        layout.putConstraint("West", this.labels[5], 121, "East", this.labels[4]);
        layout.putConstraint("North", this.labels[5], 5, "South", this.textFields[0]);
        panel2.add(this.textFields[2]);
        panel2.add(this.textFields[3]);
        panel2.add(this.textFields[4]);
        layout.putConstraint("West", this.textFields[2], 130, "West", panel2);
        layout.putConstraint("North", this.textFields[2], 1, "South", this.labels[3]);
        layout.putConstraint("West", this.textFields[3], 5, "East", this.textFields[2]);
        layout.putConstraint("North", this.textFields[3], 1, "South", this.labels[3]);
        layout.putConstraint("West", this.textFields[4], 5, "East", this.textFields[3]);
        layout.putConstraint("North", this.textFields[4], 1, "South", this.labels[3]);
        panel2.add(this.labels[2]);
        panel2.add(this.labels[18]);
        panel2.add(this.labels[17]);
        layout.putConstraint("West", this.labels[2], 130, "West", panel2);
        layout.putConstraint("North", this.labels[2], 5, "South", this.textFields[2]);
        layout.putConstraint("West", this.labels[18], 83, "East", this.labels[2]);
        layout.putConstraint("North", this.labels[18], 5, "South", this.textFields[2]);
        layout.putConstraint("West", this.labels[17], 95, "East", this.labels[18]);
        layout.putConstraint("North", this.labels[17], 5, "South", this.textFields[2]);
        panel2.add(this.textFields[5]);
        panel2.add(this.textFields[6]);
        panel2.add(this.textFields[7]);
        panel2.add(this.textFields[12]);
        panel2.add(this.textFields[13]);
        panel2.add(this.textFields[14]);
        panel2.add(this.textFields[8]);
        layout.putConstraint("West", this.textFields[5], 130, "West", panel2);
        layout.putConstraint("North", this.textFields[5], 1, "South", this.labels[2]);
        layout.putConstraint("West", this.textFields[6], 4, "East", this.textFields[5]);
        layout.putConstraint("North", this.textFields[6], 1, "South", this.labels[2]);
        layout.putConstraint("West", this.textFields[7], 4, "East", this.textFields[6]);
        layout.putConstraint("North", this.textFields[7], 1, "South", this.labels[2]);
        layout.putConstraint("West", this.textFields[12], 85, "East", this.labels[2]);
        layout.putConstraint("North", this.textFields[12], 1, "South", this.labels[2]);
        layout.putConstraint("West", this.textFields[13], 4, "East", this.textFields[12]);
        layout.putConstraint("North", this.textFields[13], 1, "South", this.labels[2]);
        layout.putConstraint("West", this.textFields[14], 4, "East", this.textFields[13]);
        layout.putConstraint("North", this.textFields[14], 1, "South", this.labels[2]);
        layout.putConstraint("West", this.textFields[8], 98, "East", this.labels[18]);
        layout.putConstraint("North", this.textFields[8], 1, "South", this.labels[2]);
        panel2.add(this.labels[19]);
        panel2.add(this.commentScroller);
        this.tf.setLineWrap(true);
        this.tf.setWrapStyleWord(true);
        this.commentScroller.setPreferredSize(new Dimension(200, 360));
        layout.putConstraint("West", this.labels[19], 620, "West", panel2);
        layout.putConstraint("North", this.labels[19], 50, "North", panel2);
        layout.putConstraint("West", this.commentScroller, 600, "West", panel2);
        layout.putConstraint("North", this.commentScroller, 65, "North", panel2);
        this.commentScroller.setHorizontalScrollBarPolicy(31);
        final Font font2 = new Font("", 1, 13);
        panel2.add(this.labels[12]);
        this.labels[12].setFont(font2);
        this.labels[12].setForeground(new Color(150, 77, 41));
        layout.putConstraint("West", this.labels[12], 30, "West", panel2);
        layout.putConstraint("North", this.labels[12], 247, "North", panel2);
        panel2.add(this.labels[10]);
        panel2.add(this.textFields[19]);
        layout.putConstraint("West", this.labels[10], 30, "West", panel2);
        layout.putConstraint("North", this.labels[10], 5, "South", this.labels[12]);
        layout.putConstraint("West", this.textFields[19], 30, "West", panel2);
        layout.putConstraint("North", this.textFields[19], 1, "South", this.labels[10]);
        panel2.add(this.labels[11]);
        panel2.add(this.textFields[20]);
        layout.putConstraint("West", this.labels[11], 10, "East", this.textFields[19]);
        layout.putConstraint("North", this.labels[11], 5, "South", this.labels[12]);
        layout.putConstraint("West", this.textFields[20], 10, "East", this.textFields[19]);
        layout.putConstraint("North", this.textFields[20], 1, "South", this.labels[10]);
        panel2.add(this.labels[7]);
        panel2.add(this.classDayComboBox);
        this.classDayComboBox.setPreferredSize(new Dimension(100, 18));
        this.classDayComboBox.setFont(font);
        this.classDayComboBox.setSize(100, 100);
        layout.putConstraint("West", this.labels[7], 30, "West", panel2);
        layout.putConstraint("North", this.labels[7], 5, "South", this.textFields[19]);
        layout.putConstraint("West", this.classDayComboBox, 30, "West", panel2);
        layout.putConstraint("North", this.classDayComboBox, 1, "South", this.labels[7]);
        panel2.add(this.labels[8]);
        this.timeHourComboBox.setPreferredSize(new Dimension(45, 18));
        this.timeMinComboBox.setPreferredSize(new Dimension(45, 18));
        this.timeAMPMComboBox.setPreferredSize(new Dimension(50, 18));
        panel2.add(this.timeHourComboBox);
        panel2.add(this.timeMinComboBox);
        panel2.add(this.timeAMPMComboBox);
        this.timeHourComboBox.setFont(font);
        this.timeMinComboBox.setFont(font);
        this.timeAMPMComboBox.setFont(font);
        layout.putConstraint("West", this.labels[8], 10, "East", this.classDayComboBox);
        layout.putConstraint("North", this.labels[8], 5, "South", this.textFields[19]);
        layout.putConstraint("West", this.timeHourComboBox, 10, "East", this.classDayComboBox);
        layout.putConstraint("North", this.timeHourComboBox, 1, "South", this.labels[8]);
        layout.putConstraint("West", this.timeMinComboBox, 2, "East", this.timeHourComboBox);
        layout.putConstraint("North", this.timeMinComboBox, 1, "South", this.labels[8]);
        layout.putConstraint("West", this.timeAMPMComboBox, 2, "East", this.timeMinComboBox);
        layout.putConstraint("North", this.timeAMPMComboBox, 1, "South", this.labels[8]);
        panel2.add(this.labels[9]);
        panel2.add(this.textFields[21]);
        layout.putConstraint("West", this.labels[9], 10, "East", this.timeAMPMComboBox);
        layout.putConstraint("North", this.labels[9], 5, "South", this.textFields[19]);
        layout.putConstraint("West", this.textFields[21], 10, "East", this.timeAMPMComboBox);
        layout.putConstraint("North", this.textFields[21], 1, "South", this.labels[9]);
        panel2.add(this.labels[20]);
        panel2.add(this.classDayComboBox2);
        this.classDayComboBox2.setPreferredSize(new Dimension(100, 18));
        this.classDayComboBox2.setFont(font);
        this.classDayComboBox2.setSize(100, 100);
        layout.putConstraint("West", this.labels[20], 30, "West", panel2);
        layout.putConstraint("North", this.labels[20], 5, "South", this.classDayComboBox);
        layout.putConstraint("West", this.classDayComboBox2, 30, "West", panel2);
        layout.putConstraint("North", this.classDayComboBox2, 1, "South", this.labels[20]);
        panel2.add(this.labels[21]);
        this.timeHourComboBox2.setPreferredSize(new Dimension(45, 18));
        this.timeMinComboBox2.setPreferredSize(new Dimension(45, 18));
        this.timeAMPMComboBox2.setPreferredSize(new Dimension(50, 18));
        panel2.add(this.timeHourComboBox2);
        panel2.add(this.timeMinComboBox2);
        panel2.add(this.timeAMPMComboBox2);
        this.timeHourComboBox2.setFont(font);
        this.timeMinComboBox2.setFont(font);
        this.timeAMPMComboBox2.setFont(font);
        layout.putConstraint("West", this.labels[21], 10, "East", this.classDayComboBox2);
        layout.putConstraint("North", this.labels[21], 5, "South", this.classDayComboBox);
        layout.putConstraint("West", this.timeHourComboBox2, 10, "East", this.classDayComboBox2);
        layout.putConstraint("North", this.timeHourComboBox2, 1, "South", this.labels[21]);
        layout.putConstraint("West", this.timeMinComboBox2, 2, "East", this.timeHourComboBox2);
        layout.putConstraint("North", this.timeMinComboBox2, 1, "South", this.labels[21]);
        layout.putConstraint("West", this.timeAMPMComboBox2, 2, "East", this.timeMinComboBox2);
        layout.putConstraint("North", this.timeAMPMComboBox2, 1, "South", this.labels[21]);
        panel2.add(this.labels[22]);
        panel2.add(this.textFields[22]);
        layout.putConstraint("West", this.labels[22], 10, "East", this.timeAMPMComboBox2);
        layout.putConstraint("North", this.labels[22], 5, "South", this.classDayComboBox);
        layout.putConstraint("West", this.textFields[22], 10, "East", this.timeAMPMComboBox2);
        layout.putConstraint("North", this.textFields[22], 1, "South", this.labels[22]);
        panel2.add(this.labels[13]);
        this.labels[13].setFont(font2);
        this.labels[13].setForeground(new Color(13, 115, 46));
        layout.putConstraint("West", this.labels[13], 385, "West", panel2);
        layout.putConstraint("North", this.labels[13], 10, "North", panel);
        panel2.add(this.labels[14]);
        panel2.add(this.textFields[9]);
        layout.putConstraint("West", this.labels[14], 0, "West", this.labels[13]);
        layout.putConstraint("North", this.labels[14], 10, "South", this.labels[13]);
        layout.putConstraint("West", this.textFields[9], 0, "West", this.labels[13]);
        layout.putConstraint("North", this.textFields[9], 1, "South", this.labels[14]);
        panel2.add(this.labels[16]);
        panel2.add(this.textFields[11]);
        layout.putConstraint("West", this.labels[16], 0, "West", this.labels[13]);
        layout.putConstraint("North", this.labels[16], 10, "South", this.textFields[9]);
        layout.putConstraint("West", this.textFields[11], 0, "West", this.labels[13]);
        layout.putConstraint("North", this.textFields[11], 1, "South", this.labels[16]);
        panel2.add(this.labels[15]);
        panel2.add(this.textFields[16]);
        panel2.add(this.textFields[17]);
        panel2.add(this.textFields[18]);
        layout.putConstraint("West", this.labels[15], 30, "West", this.labels[13]);
        layout.putConstraint("North", this.labels[15], 10, "South", this.textFields[11]);
        layout.putConstraint("West", this.textFields[16], 30, "West", this.labels[13]);
        layout.putConstraint("North", this.textFields[16], 1, "South", this.labels[15]);
        layout.putConstraint("West", this.textFields[17], 4, "East", this.textFields[16]);
        layout.putConstraint("North", this.textFields[17], 1, "South", this.labels[15]);
        layout.putConstraint("West", this.textFields[18], 4, "East", this.textFields[17]);
        layout.putConstraint("North", this.textFields[18], 1, "South", this.labels[15]);
        c1.setPreferredSize(new Dimension(340, 150));
        panel.setPreferredSize(new Dimension(220, 185));
        panel2.add(c1);
        layout.putConstraint("West", c1, 20, "West", panel2);
        layout.putConstraint("North", c1, 245, "North", panel2);
        c1.setBackground(new Color(243, 189, 186));
        panel2.add(panel);
        layout.putConstraint("West", panel, 375, "West", panel2);
        layout.putConstraint("North", panel, 210, "North", panel2);
        panel.setBackground(new Color(193, 233, 145));
        panel2.add(this.buttons[3]);
        this.buttons[3].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("West", this.buttons[3], 260, "West", panel2);
        layout.putConstraint("North", this.buttons[3], 400, "North", panel2);
        panel2.add(this.buttons[2]);
        this.buttons[2].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("East", this.buttons[2], -60, "West", this.buttons[3]);
        layout.putConstraint("North", this.buttons[2], 400, "North", panel2);
        panel2.add(this.buttons[4]);
        this.buttons[4].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("West", this.buttons[4], 60, "East", this.buttons[3]);
        layout.putConstraint("North", this.buttons[4], 400, "North", panel2);
        panel2.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
        contentPane.add(panel2);
        this.clearFields();
        this.setSize(820, 460);
        this.setResizable(false);
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
    
    public void doPrint() throws IOException {
        if (this.newOrOld == -1) {
            JOptionPane.showMessageDialog(null, "Must Be A Current Student!", "Error Thrown", 0);
            return;
        }
        final PrintJob printJob = this.getToolkit().getPrintJob(this, "My Print Job", null);
        if (this.newOrOld == -1) {
            JOptionPane.showMessageDialog(null, "Must Be A Current Student!", "Error Thrown", 0);
            return;
        }
        if (printJob != null) {
            final Graphics graphics = printJob.getGraphics();
            final RandomAccessFile output = this.output;
            final int newOrOld = this.newOrOld;
            final StudentRecord sr = this.sr;
            output.seek(newOrOld * StudentRecord.size() + 10);
            this.sr.read(this.output);
            graphics.drawString(this.sr.getFirstName() + " " + this.sr.getLastName(), 100, 172);
            graphics.drawString(this.sr.getAddress(), 160, 290);
            graphics.drawString(this.sr.getCity(), 130, 310);
            graphics.drawString("CA", 390, 309);
            graphics.drawString(this.sr.getZipCode(), 510, 310);
            if (this.sr.getTelephoneNumber().length() == 10) {
                graphics.drawString(this.sr.getTelephoneNumber().substring(0, 3), 110, 372);
                graphics.drawString(this.sr.getTelephoneNumber().substring(3, 6) + "-" + this.sr.getTelephoneNumber().substring(6), 170, 372);
            }
            if (this.sr.getCellPhoneNumber().length() == 10) {
                graphics.drawString(this.sr.getCellPhoneNumber().substring(0, 3), 390, 372);
                graphics.drawString(this.sr.getCellPhoneNumber().substring(3, 6) + "-" + this.sr.getCellPhoneNumber().substring(6), 460, 372);
            }
            graphics.drawString(this.sr.getFirstName() + ":" + this.sr.getEMail(), 110, 420);
            graphics.drawString(this.sr.getDadName(), 100, 240);
            graphics.drawString(Integer.toString(this.sr.getBirthdayMonth()), 390, 172);
            graphics.drawString(Integer.toString(this.sr.getBirthdayDay()), 450, 172);
            graphics.drawString(Integer.toString(this.sr.getBirthdayYear() + 1991), 510, 172);
            graphics.dispose();
            printJob.end();
        }
    }
    
    public void teacherInfoSetup() {
        this.textFields[9].setEditable(false);
        this.textFields[10].setEditable(false);
        this.textFields[11].setEditable(false);
        this.textFields[16].setEditable(false);
        this.textFields[17].setEditable(false);
        this.textFields[18].setEditable(false);
        this.textFields[20].setEditable(false);
        this.textFields[21].setEditable(false);
        this.sr.resetAllFields();
        this.sr.setPictureName("load_pix_icon2.jpg");
        this.clearFields();
        this.newOrOld = -1;
        this.studentOrTeacher = 2;
    }
    
    public void studentInfoSetup() {
        for (int i = 0; i < this.textFields.length; ++i) {
            this.textFields[i].setEditable(true);
        }
        this.sr.resetAllFields();
        this.sr.setPictureName("load_pix_icon2.jpg");
        this.clearFields();
        this.newOrOld = -1;
        this.studentOrTeacher = 1;
    }
    
    public void createID() {
        if (this.birthdayMonthComboBox.getSelectedIndex() != 0 && this.birthdayDayComboBox.getSelectedIndex() != 0 && this.birthdayYearComboBox.getSelectedIndex() != 0) {
            int int1 = Integer.parseInt(this.studentOrTeacher + this.numberToData[this.birthdayMonthComboBox.getSelectedIndex()] + this.numberToData[this.birthdayDayComboBox.getSelectedIndex()] + this.yearToData[this.birthdayYearComboBox.getSelectedIndex()] + "01");
            try {
                while (!this.checkAvailability(Integer.toString(int1))) {
                    ++int1;
                }
            }
            catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error At StudentInfoPage:CreateIDNumber", "Error Thrown", 0);
            }
            this.sr.setStudentTeacherId(Integer.toString(int1));
            this.idTextField.setText("ID: " + Integer.toString(int1));
        }
    }
    
    public void createTrackerFileCurrentStudent() throws IOException {
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        for (int int1 = this.output.readInt(), i = 0; i < int1; ++i) {
            final RandomAccessFile output = this.output;
            final int n = i;
            final StudentRecord sr = this.sr;
            output.seek(n * StudentRecord.size() + 10);
            this.sr.read(this.output);
            this.createTrackerFile();
        }
        this.sr.resetAllFields();
    }
    
    public void viewEditStudent(final int newOrOld) throws IOException {
        if (this.output == null) {
            this.openFile();
        }
        this.sr.resetAllFields();
        final RandomAccessFile output = this.output;
        final StudentRecord sr = this.sr;
        output.seek(newOrOld * StudentRecord.size() + 10);
        this.sr.read(this.output);
        this.newOrOld = newOrOld;
        this.textFields[0].setText(this.sr.getFirstName());
        this.textFields[1].setText(this.sr.getLastName());
        this.textFields[2].setText(this.sr.getAddress());
        this.textFields[3].setText(this.sr.getCity());
        this.textFields[4].setText(this.sr.getZipCode());
        if (this.sr.getTelephoneNumber().length() == 10) {
            this.textFields[5].setText(this.sr.getTelephoneNumber().substring(0, 3));
            this.textFields[6].setText(this.sr.getTelephoneNumber().substring(3, 6));
            this.textFields[7].setText(this.sr.getTelephoneNumber().substring(6));
        }
        this.textFields[8].setText(this.sr.getEMail());
        this.textFields[9].setText(this.sr.getDadName());
        this.textFields[10].setText(this.sr.getMomName());
        this.textFields[11].setText(this.sr.getParentEMail());
        if (this.sr.getCellPhoneNumber().length() == 10) {
            this.textFields[12].setText(this.sr.getCellPhoneNumber().substring(0, 3));
            this.textFields[13].setText(this.sr.getCellPhoneNumber().substring(3, 6));
            this.textFields[14].setText(this.sr.getCellPhoneNumber().substring(6));
        }
        if (this.sr.getParentCellPhoneNumber().length() == 10) {
            this.textFields[16].setText(this.sr.getParentCellPhoneNumber().substring(0, 3));
            this.textFields[17].setText(this.sr.getParentCellPhoneNumber().substring(3, 6));
            this.textFields[18].setText(this.sr.getParentCellPhoneNumber().substring(6));
        }
        this.tf.setText(this.sr.getComment());
        this.birthdayMonthComboBox.setSelectedIndex(this.sr.getBirthdayMonth());
        this.birthdayDayComboBox.setSelectedIndex(this.sr.getBirthdayDay());
        this.birthdayYearComboBox.setSelectedIndex(this.sr.getBirthdayYear());
        this.textFields[20].setText(this.sr.getInstructorName());
        this.classDayComboBox.setSelectedIndex(this.sr.getClassDay());
        this.timeHourComboBox.setSelectedIndex(this.sr.getClassTimeHour());
        this.timeMinComboBox.setSelectedIndex(this.sr.getClassTimeMin());
        this.timeAMPMComboBox.setSelectedIndex(this.sr.getClassTimeAMPM());
        this.classDayComboBox2.setSelectedIndex(this.sr.getClassDay2());
        this.timeHourComboBox2.setSelectedIndex(this.sr.getClassTimeHour2());
        this.timeMinComboBox2.setSelectedIndex(this.sr.getClassTimeMin2());
        this.timeAMPMComboBox2.setSelectedIndex(this.sr.getClassTimeAMPM2());
        this.textFields[21].setText(Integer.toString(this.sr.getClassDuration()));
        this.textFields[22].setText(Integer.toString(this.sr.getClassDuration2()));
        this.textFields[19].setText(this.sr.getClassName());
        this.idTextField.setText("ID: " + this.sr.getStudentTeacherId());
        this.studentBooks[0].setSelectedItem(this.sr.getBook1());
        this.studentBooks[1].setSelectedItem(this.sr.getBook2());
        this.studentBooks[2].setSelectedItem(this.sr.getBook3());
        this.studentBooks[3].setSelectedItem(this.sr.getBook4());
        final ImageIcon imageIcon = new ImageIcon("pictures\\" + this.sr.getPictureName());
        final BufferedImage image = new BufferedImage(110, 125, 2);
        image.getGraphics().drawImage(imageIcon.getImage(), 0, 0, 110, 125, null);
        this.pictureLabel.setIcon(new ImageIcon(image));
        this.setVisible(true);
    }
    
    public void setHomePage(final HomePage hp, final NewClassTracker nct, final Booklist bl) {
        this.hp = hp;
        this.nct = nct;
        this.bl = bl;
    }
    
    public void newRecord() {
        this.sr = new StudentRecord();
    }
    
    public int saveOldStudent(final int n) throws IOException {
        if ((this.textFields[0].getText().equals("") || this.textFields[1].getText().equals("")) && this.studentOrTeacher == 1) {
            JOptionPane.showMessageDialog(this, "First and Last name of student must be declared", "Not Enough Information", 0);
            return -1;
        }
        if ((this.textFields[0].getText().equals("") || this.textFields[1].getText().equals("")) && this.studentOrTeacher == 2) {
            JOptionPane.showMessageDialog(this, "First and Last name of teacher must be declared", "Not Enough Information", 0);
            return -1;
        }
        if ((this.textFields[5].getText().equals("") || this.textFields[6].getText().equals("") || this.textFields[7].getText().equals("")) && this.textFields[8].getText().equals("") && (this.textFields[12].getText().equals("") || this.textFields[13].getText().equals("") || this.textFields[14].getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "Either Phone number or E-mail address has to be declared", "Not Enough Information", 0);
            return -1;
        }
        if (this.tf.getText().trim().length() > 499) {
            JOptionPane.showMessageDialog(this, "Comments Too Long", "Invalid Comment", 0);
            return -1;
        }
        try {
            if ((this.textFields[5].getText().trim().length() != 3 || this.textFields[6].getText().trim().length() != 3 || this.textFields[7].getText().trim().length() != 4) && (this.textFields[12].getText().trim().length() != 3 || this.textFields[13].getText().trim().length() != 3 || this.textFields[14].getText().trim().length() != 4)) {
                JOptionPane.showMessageDialog(null, "Incorrect Telephone Number Format.  Please Check The Telephone Numbers You've Entered.", "Wrong Format", 0);
                return -1;
            }
            for (int i = 5; i < 8; ++i) {
                if (this.textFields[i].getText().compareTo("") != 0) {
                    Integer.parseInt(this.textFields[i].getText());
                }
            }
            for (int j = 12; j < 19; ++j) {
                if (j != 15) {
                    if (this.textFields[j].getText().compareTo("") != 0) {
                        Integer.parseInt(this.textFields[j].getText());
                    }
                }
            }
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Incorrect Telephone Number Format.  Please Check The Telephone Number You've Entered.", "Wrong Format", 0);
            return -1;
        }
        try {
            if (this.textFields[21].getText().compareTo("") != 0) {
                Integer.parseInt(this.textFields[21].getText());
            }
        }
        catch (NumberFormatException ex2) {
            JOptionPane.showMessageDialog(this, "Incorrect Class Duration Format.  Must Enter An Integer.", "Wrong Format", 0);
            return -1;
        }
        final String upperCase = this.textFields[0].getText().trim().toUpperCase();
        final String upperCase2 = this.textFields[1].getText().trim().toUpperCase();
        if (upperCase.compareTo(this.sr.getFirstName()) != 0 || upperCase2.compareTo(this.sr.getLastName()) != 0) {
            System.out.println("name change");
            this.changeTrackerFileName(upperCase, upperCase2, this.sr.getFirstName(), this.sr.getLastName());
        }
        this.sr.setFirstName(this.textFields[0].getText().trim().toUpperCase());
        this.sr.setLastName(this.textFields[1].getText().trim().toUpperCase());
        this.sr.setAddress(this.textFields[2].getText().trim().toUpperCase());
        this.sr.setCity(this.textFields[3].getText().trim().toUpperCase());
        this.sr.setZipCode(this.textFields[4].getText().trim());
        final String string = this.textFields[5].getText().trim() + this.textFields[6].getText().trim() + this.textFields[7].getText().trim();
        if (string.length() == 10) {
            this.sr.setTelephoneNumber(string);
        }
        this.sr.setEMail(this.textFields[8].getText().trim());
        this.sr.setDadName(this.textFields[9].getText().trim().toUpperCase());
        this.sr.setMomName(this.textFields[10].getText().trim().toUpperCase());
        this.sr.setParentEMail(this.textFields[11].getText().trim());
        final String string2 = this.textFields[12].getText().trim() + this.textFields[13].getText().trim() + this.textFields[14].getText().trim();
        if (string2.length() == 10) {
            this.sr.setCellPhoneNumber(string2);
        }
        final String string3 = this.textFields[16].getText().trim() + this.textFields[17].getText().trim() + this.textFields[18].getText().trim();
        if (string3.length() == 10) {
            this.sr.setParentCellPhoneNumber(string3);
        }
        this.sr.setComment(this.tf.getText().trim());
        this.sr.setBirthdayMonth(this.birthdayMonthComboBox.getSelectedIndex());
        this.sr.setBirthdayDay(this.birthdayDayComboBox.getSelectedIndex());
        this.sr.setBirthdayYear(this.birthdayYearComboBox.getSelectedIndex());
        this.sr.setInstructorName(this.textFields[20].getText().toUpperCase().trim());
        this.sr.setClassDay(this.classDayComboBox.getSelectedIndex());
        this.sr.setClassTimeHour(this.timeHourComboBox.getSelectedIndex());
        this.sr.setClassTimeMin(this.timeMinComboBox.getSelectedIndex());
        this.sr.setClassTimeAMPM(this.timeAMPMComboBox.getSelectedIndex());
        this.sr.setClassDay2(this.classDayComboBox2.getSelectedIndex());
        this.sr.setClassTimeHour2(this.timeHourComboBox2.getSelectedIndex());
        this.sr.setClassTimeMin2(this.timeMinComboBox2.getSelectedIndex());
        this.sr.setClassTimeAMPM2(this.timeAMPMComboBox2.getSelectedIndex());
        if (this.textFields[21].getText().trim().compareTo("") != 0) {
            this.sr.setClassDuration(Integer.parseInt(this.textFields[21].getText().trim()));
        }
        if (this.textFields[22].getText().trim().compareTo("") != 0) {
            this.sr.setClassDuration2(Integer.parseInt(this.textFields[22].getText().trim()));
        }
        this.sr.setClassName(this.textFields[19].getText().trim().toUpperCase());
        this.sr.setBook1(this.studentBooks[0].getSelectedItem().toString());
        this.sr.setBook2(this.studentBooks[1].getSelectedItem().toString());
        this.sr.setBook3(this.studentBooks[2].getSelectedItem().toString());
        this.sr.setBook4(this.studentBooks[3].getSelectedItem().toString());
        if (this.output == null) {
            this.openFile();
        }
        final RandomAccessFile output = this.output;
        final int newOrOld = this.newOrOld;
        final StudentRecord sr = this.sr;
        output.seek(newOrOld * StudentRecord.size() + 10);
        this.sr.write(this.output);
        System.out.println("HERE IN SAVEOLDSTUDENT");
        return 1;
    }
    
    public boolean changesMade() {
        return this.textFields[0].getText().trim().compareTo(this.sr.getFirstName()) != 0 || this.textFields[1].getText().trim().compareTo(this.sr.getLastName()) != 0 || this.textFields[2].getText().trim().compareTo(this.sr.getAddress()) != 0 || this.textFields[3].getText().trim().compareTo(this.sr.getCity()) != 0 || this.textFields[4].getText().trim().compareTo(this.sr.getZipCode()) != 0 || (this.textFields[5].getText().trim() + this.textFields[6].getText().trim() + this.textFields[7].getText().trim()).compareTo(this.sr.getTelephoneNumber()) != 0 || this.textFields[8].getText().trim().compareTo(this.sr.getEMail()) != 0 || this.textFields[9].getText().trim().compareTo(this.sr.getDadName()) != 0 || this.textFields[10].getText().trim().compareTo(this.sr.getMomName()) != 0 || this.textFields[11].getText().trim().compareTo(this.sr.getParentEMail()) != 0 || this.tf.getText().trim().compareTo(this.sr.getComment()) != 0 || this.birthdayMonthComboBox.getSelectedIndex() != this.sr.getBirthdayMonth() || this.birthdayDayComboBox.getSelectedIndex() != this.sr.getBirthdayDay() || this.birthdayYearComboBox.getSelectedIndex() != this.sr.getBirthdayYear();
    }
    
    public void addNewStudent() throws IOException {
        if ((this.textFields[0].getText().equals("") || this.textFields[1].getText().equals("")) && this.studentOrTeacher == 1) {
            JOptionPane.showMessageDialog(this, "First and Last name of student must be declared", "Not Enough Information", 0);
            return;
        }
        if ((this.textFields[0].getText().equals("") || this.textFields[1].getText().equals("")) && this.studentOrTeacher == 2) {
            JOptionPane.showMessageDialog(this, "First and Last name of teacher must be declared", "Not Enough Information", 0);
            return;
        }
        if ((this.textFields[5].getText().equals("") || this.textFields[6].getText().equals("") || this.textFields[7].getText().equals("")) && this.textFields[8].getText().equals("") && (this.textFields[12].getText().equals("") || this.textFields[13].getText().equals("") || this.textFields[14].getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "Either Phone number or E-mail address has to be declared", "Not Enough Information", 0);
            return;
        }
        try {
            if ((this.textFields[5].getText().trim().length() != 3 || this.textFields[6].getText().trim().length() != 3 || this.textFields[7].getText().trim().length() != 4) && (this.textFields[12].getText().trim().length() != 3 || this.textFields[13].getText().trim().length() != 3 || this.textFields[14].getText().trim().length() != 4)) {
                JOptionPane.showMessageDialog(null, "Incorrect Telephone Number Format.  Please Check The Telephone Numbers You've Entered.", "Wrong Format", 0);
                return;
            }
            for (int i = 5; i < 8; ++i) {
                if (this.textFields[i].getText().compareTo("") != 0) {
                    Integer.parseInt(this.textFields[i].getText());
                }
            }
            for (int j = 12; j < 19; ++j) {
                if (j != 15) {
                    if (this.textFields[j].getText().compareTo("") != 0) {
                        Integer.parseInt(this.textFields[j].getText());
                    }
                }
            }
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Incorrect Telephone Number Format.  Please Check The Telephone Number You've Entered.", "Wrong Format", 0);
            return;
        }
        try {
            if (this.textFields[21].getText().trim().compareTo("") != 0) {
                Integer.parseInt(this.textFields[21].getText());
            }
        }
        catch (NumberFormatException ex2) {
            JOptionPane.showMessageDialog(this, "Incorrect Class Duration Format.  Must Enter An Integer.", "Wrong Format", 0);
            return;
        }
        this.sr.setFirstName(this.textFields[0].getText().trim().toUpperCase());
        this.sr.setLastName(this.textFields[1].getText().trim().toUpperCase());
        this.sr.setAddress(this.textFields[2].getText().trim().toUpperCase());
        this.sr.setCity(this.textFields[3].getText().trim().toUpperCase());
        this.sr.setZipCode(this.textFields[4].getText().trim());
        final String string = this.textFields[5].getText().trim() + this.textFields[6].getText().trim() + this.textFields[7].getText().trim();
        if (string.length() == 10) {
            this.sr.setTelephoneNumber(string);
        }
        this.sr.setEMail(this.textFields[8].getText().trim());
        this.sr.setDadName(this.textFields[9].getText().trim().toUpperCase());
        this.sr.setMomName(this.textFields[10].getText().trim().toUpperCase());
        this.sr.setParentEMail(this.textFields[11].getText().trim());
        final String string2 = this.textFields[12].getText().trim() + this.textFields[13].getText().trim() + this.textFields[14].getText().trim();
        if (string2.length() == 10) {
            this.sr.setCellPhoneNumber(string2);
        }
        final String string3 = this.textFields[16].getText().trim() + this.textFields[17].getText().trim() + this.textFields[18].getText().trim();
        if (string3.length() == 10) {
            this.sr.setParentCellPhoneNumber(string3);
        }
        this.sr.setComment(this.tf.getText().trim());
        this.sr.setBirthdayMonth(this.birthdayMonthComboBox.getSelectedIndex());
        this.sr.setBirthdayDay(this.birthdayDayComboBox.getSelectedIndex());
        this.sr.setBirthdayYear(this.birthdayYearComboBox.getSelectedIndex());
        this.sr.setInstructorName(this.textFields[20].getText().toUpperCase().trim());
        this.sr.setClassDay(this.classDayComboBox.getSelectedIndex());
        this.sr.setClassTimeHour(this.timeHourComboBox.getSelectedIndex());
        this.sr.setClassTimeMin(this.timeMinComboBox.getSelectedIndex());
        this.sr.setClassTimeAMPM(this.timeAMPMComboBox.getSelectedIndex());
        this.sr.setClassDay2(this.classDayComboBox2.getSelectedIndex());
        this.sr.setClassTimeHour2(this.timeHourComboBox2.getSelectedIndex());
        this.sr.setClassTimeMin2(this.timeMinComboBox2.getSelectedIndex());
        this.sr.setClassTimeAMPM2(this.timeAMPMComboBox2.getSelectedIndex());
        if (this.textFields[21].getText().trim().compareTo("") != 0) {
            this.sr.setClassDuration(Integer.parseInt(this.textFields[21].getText().trim()));
        }
        if (this.textFields[22].getText().trim().compareTo("") != 0) {
            this.sr.setClassDuration2(Integer.parseInt(this.textFields[22].getText().trim()));
        }
        this.sr.setClassName(this.textFields[19].getText().trim().toUpperCase());
        if (this.sr.getPictureName().compareTo("") == 0) {
            this.sr.setPictureName("load_pix_icon2.jpg");
        }
        this.sr.setBook1(this.studentBooks[0].getSelectedItem().toString());
        this.sr.setBook2(this.studentBooks[1].getSelectedItem().toString());
        this.sr.setBook3(this.studentBooks[2].getSelectedItem().toString());
        this.sr.setBook4(this.studentBooks[3].getSelectedItem().toString());
        final StudentRecord studentRecord = new StudentRecord();
        final StudentRecord studentRecord2 = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        if (int1 == 0) {
            this.output.seek(10L);
            this.sr.write(this.output);
            this.createTrackerFile();
            this.output.seek(0L);
            this.output.writeInt(1);
            this.clearFields();
            this.setVisible(false);
            this.hp.setEnabled(true);
            this.hp.setVisible(true);
            return;
        }
        int k;
        for (k = 0; k < int1; ++k) {
            final RandomAccessFile output = this.output;
            final StudentRecord sr = this.sr;
            output.seek(StudentRecord.size() * k + 10);
            studentRecord.read(this.output);
            if (studentRecord.getLastName().compareTo(this.sr.getLastName()) > 0) {
                break;
            }
            if (studentRecord.getLastName().compareTo(this.sr.getLastName()) == 0) {
                if (studentRecord.getFirstName().compareTo(this.sr.getFirstName()) > 0) {
                    break;
                }
                if (studentRecord.getFirstName().compareTo(this.sr.getFirstName()) == 0) {
                    JOptionPane.showMessageDialog(this, "Same First and Last Name!! Name already Existed.", "Wrong Format", 0);
                    System.out.println("Same First and Last Name!! Name already Exist");
                    return;
                }
            }
        }
        if (k == int1) {
            final RandomAccessFile output2 = this.output;
            final StudentRecord sr2 = this.sr;
            output2.seek(StudentRecord.size() * k + 10);
            this.sr.write(this.output);
            this.createTrackerFile();
            this.sr.resetAllFields();
            this.output.seek(0L);
            this.output.writeInt(int1 + 1);
            this.clearFields();
            this.setVisible(false);
            this.hp.setEnabled(true);
            this.hp.setVisible(true);
            return;
        }
        final RandomAccessFile output3 = this.output;
        final StudentRecord sr3 = this.sr;
        output3.seek(StudentRecord.size() * k + 10);
        this.sr.write(this.output);
        while (k + 1 < int1) {
            final RandomAccessFile output4 = this.output;
            final StudentRecord sr4 = this.sr;
            output4.seek(StudentRecord.size() * (k + 1) + 10);
            studentRecord2.read(this.output);
            final RandomAccessFile output5 = this.output;
            final StudentRecord sr5 = this.sr;
            output5.seek(StudentRecord.size() * (k + 1) + 10);
            studentRecord.write(this.output);
            studentRecord.copyAllFields(studentRecord2);
            studentRecord2.resetAllFields();
            ++k;
        }
        final RandomAccessFile output6 = this.output;
        final StudentRecord sr6 = this.sr;
        output6.seek(StudentRecord.size() * (k + 1) + 10);
        studentRecord.write(this.output);
        this.output.seek(0L);
        this.output.writeInt(int1 + 1);
        this.clearFields();
        this.createTrackerFile();
        hp.setStudentArray();
        this.setVisible(false);
        this.hp.setEnabled(true);
        this.hp.setVisible(true);
    }
    
    private void changeTrackerFileName(final String str, final String str2, final String str3, final String str4) throws IOException {
        final String string = str3 + "-" + str4 + ".txt";
        final String string2 = str + "-" + str2 + ".txt";
        final File file = new File(string);
        file.getAbsoluteFile();
        file.renameTo(new File(string2));
        new File(string).delete();
    }
    
    private boolean checkAvailability(final String s) throws IOException {
        final StudentRecord studentRecord = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        if (int1 == 0) {
            return true;
        }
        for (int i = 0; i < int1; ++i) {
            final RandomAccessFile output = this.output;
            final StudentRecord sr = this.sr;
            output.seek(StudentRecord.size() * i + 10);
            studentRecord.read(this.output);
            if (studentRecord.getStudentTeacherId().compareTo(s.trim()) == 0) {
                return false;
            }
        }
        return true;
    }
    
    private void createTrackerFile() throws IOException {
        final String string = this.sr.getFirstName() + "-" + this.sr.getLastName() + ".txt";
        final File file = new File(string);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("New file " + string + " has been created to the current directory");
        }
        final RandomAccessFile randomAccessFile = new RandomAccessFile(string, "rw");
        randomAccessFile.seek(0L);
        randomAccessFile.writeInt(0);
        randomAccessFile.close();
    }
    
    private int nameCompare(final String s, final String s2) {
        return 0;
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
    
    public void clearFields() {
        for (int i = 0; i < 23; ++i) {
            this.textFields[i].setText("");
        }
        this.tf.setText("");
        this.idTextField.setText("");
        this.birthdayMonthComboBox.setSelectedIndex(0);
        this.birthdayYearComboBox.setSelectedIndex(0);
        this.birthdayDayComboBox.setSelectedIndex(0);
        this.classDayComboBox.setSelectedIndex(0);
        this.timeHourComboBox.setSelectedIndex(0);
        this.timeMinComboBox.setSelectedIndex(0);
        this.timeAMPMComboBox.setSelectedIndex(0);
        this.classDayComboBox2.setSelectedIndex(0);
        this.timeHourComboBox2.setSelectedIndex(0);
        this.timeMinComboBox2.setSelectedIndex(0);
        this.timeAMPMComboBox2.setSelectedIndex(0);
        this.textFields[5].setText("650");
        this.textFields[4].setText("94402");
        this.textFields[3].setText("SAN MATEO");
        final ImageIcon imageIcon = new ImageIcon("pictures\\load_pix_icon2.jpg");
        final BufferedImage image = new BufferedImage(110, 125, 2);
        image.getGraphics().drawImage(imageIcon.getImage(), 0, 0, 110, 125, null);
        this.pictureLabel.setIcon(new ImageIcon(image));
        for (int j = 0; j < this.studentBooks.length; ++j) {
            this.studentBooks[j].setSelectedItem("");
        }
        this.typeField.setText("");
    }
}