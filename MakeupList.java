import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.Dimension;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.SpringLayout;
import java.io.IOException;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.Icon;
import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.RandomAccessFile;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

public class MakeupList extends JFrame
{
    private RandomAccessFile output;
    private RandomAccessFile list;
    private RandomAccessFile completedList;
    private JPanel backgroundPanel;
    private JPanel editBoxPanel;
    private JLabel[] labels;
    private JButton[] buttons;
    private JComboBox[] combo;
    private Container c;
    private Icon trackerHistoryIcon;
    private Icon saveIcon;
    private Icon closeIcon;
    private Icon inputIcon;
    private Icon pictureIcon;
    private Icon happyMozartIcon;
    private JLabel pictureLabel;
    private JLabel makeupListLabel;
    private JTextArea[] textArea;
    private StudentRecord sr;
    private int pointer;
    private String[] classDays;
    private String[] timeHours;
    private String[] timeMins;
    private String[] timeAMPM;
    private Object[] names;
    private String[] numbers;
    private HomePage hp;
    private NewClassTracker nct;
    private int[] srArray;
    private int[] matches;
    private JButton forwardButton;
    private JButton backwardButton;
    private JButton cancelButton;
    private JButton newEntryButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JButton searchButton;
    private JButton retrieveButton;
    private JButton switchListButton;
    private int matchCount;
    private int searchCount;
    private JTextField[] textFields;
    private JLabel editLabel;
    private String todayMonth;
    private String todayYear;
    private String todayDay;
    private boolean searching;
    private boolean complete;
    private TitledBorder title1;
    private RandomAccessFile makeup3List;
    private ArrayList makeup3;
    private int numberOfEntries;
    private JTextField[] deleteFields;
    private boolean failure;
    private JButton expireButton;
    private boolean expireFailure;
    
    public MakeupList() {
        super("Select Screen");
        this.c = this.getContentPane();
        this.pointer = 0;
        this.classDays = new String[] { "", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        this.timeHours = new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
        this.timeMins = new String[] { "00", "15", "30", "45" };
        this.timeAMPM = new String[] { "AM", "PM" };
        this.textArea = new JTextArea[2];
        this.textFields = new JTextField[109];
        this.buttons = new JButton[6];
        this.labels = new JLabel[6];
        this.backgroundPanel = new JPanel();
        this.editBoxPanel = new JPanel();
        this.sr = new StudentRecord();
        this.editLabel = new JLabel("Edit Entry");
        this.makeupListLabel = new JLabel(new ImageIcon("makeup_list_top_icon.jpg"));
        this.forwardButton = new JButton(new ImageIcon("next.jpg"));
        this.backwardButton = new JButton(new ImageIcon("previous.jpg"));
        this.cancelButton = new JButton(new ImageIcon("home_page_icon.jpg"));
        this.newEntryButton = new JButton(new ImageIcon("new_entry_icon.jpg"));
        this.deleteButton = new JButton(new ImageIcon("delete_entry_icon.jpg"));
        this.saveButton = new JButton(new ImageIcon("small_pen.jpg"));
        this.searchButton = new JButton(new ImageIcon("search_icon3.jpg"));
        this.retrieveButton = new JButton(new ImageIcon("retrieve.jpg"));
        this.switchListButton = new JButton(new ImageIcon("switch_list.jpg"));
        final boolean b = false;
        this.complete = b;
        this.searching = b;
        this.getDateTime();
        (this.buttons[0] = new JButton(new ImageIcon("absent.jpg"))).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        (this.buttons[1] = new JButton(new ImageIcon("makeup.jpg"))).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        (this.buttons[2] = new JButton(new ImageIcon("makeup.jpg"))).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        for (int i = 3; i < 5; ++i) {
            (this.buttons[i] = new JButton(new ImageIcon("Date.jpg"))).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        }
        (this.buttons[5] = new JButton(new ImageIcon("makeup.jpg"))).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        (this.expireButton = new JButton(new ImageIcon("expire_icon.jpg"))).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.deleteFields = new JTextField[3];
        for (int j = 0; j < this.deleteFields.length; ++j) {
            this.deleteFields[j] = new JTextField(3);
            if (j != 2) {
                this.deleteFields[j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            }
            else {
                this.deleteFields[j].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            }
        }
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent windowEvent) {
                MakeupList.this.setVisible(false);
                MakeupList.this.hp.setVisible(true);
                MakeupList.this.hp.setEnabled(true);
                MakeupList.this.clearFields();
            }
        });
        this.retrieveButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                if (MakeupList.this.complete) {
                    JOptionPane.showMessageDialog(null, "Can Not Retrieve From Completed Entry List", "Warning", 0);
                    return;
                }
                MakeupList.this.retrieve();
            }
        });
        this.switchListButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                if (!MakeupList.this.complete) {
                    MakeupList.this.title1.setTitle("COMPLETED LIST");
                    MakeupList.this.title1.setTitleColor(new Color(43, 43, 255));
                    MakeupList.this.backgroundPanel.setBackground(new Color(155, 155, 255));
                    for (int i = 0; i < 9; ++i) {
                        MakeupList.this.textFields[i].setBackground(new Color(81, 81, 255));
                    }
                    MakeupList.this.complete = true;
                    MakeupList.this.pointer = 0;
                    try {
                        MakeupList.this.displayCompletedList();
                    }
                    catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "IOException @ switchListButton::displayCompletedList()", "Invalid Format", 0);
                        return;
                    }
                    MakeupList.this.repaint();
                }
                else {
                    MakeupList.this.title1.setTitle("CURRENT LIST");
                    MakeupList.this.title1.setTitleColor(new Color(45, 86, 20));
                    MakeupList.this.backgroundPanel.setBackground(new Color(122, 182, 41));
                    for (int j = 0; j < 9; ++j) {
                        MakeupList.this.textFields[j].setBackground(new Color(45, 86, 20));
                    }
                    MakeupList.this.complete = false;
                    MakeupList.this.pointer = 0;
                    try {
                        MakeupList.this.displayList();
                    }
                    catch (IOException ex2) {
                        JOptionPane.showMessageDialog(null, "IOException @ switchListButton::displayList()", "Invalid Format", 0);
                        return;
                    }
                    MakeupList.this.repaint();
                }
                for (int k = 99; k < 108; ++k) {
                    MakeupList.this.textFields[k].setText("");
                }
            }
        });
        this.forwardButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                try {
                    if (MakeupList.this.pointer + 10 < MakeupList.this.searchCount && MakeupList.this.searching) {
                        MakeupList.this.pointer += 10;
                        MakeupList.this.searchDisplayList();
                    }
                    else if (MakeupList.this.pointer + 10 < MakeupList.this.matchCount && MakeupList.this.complete) {
                        MakeupList.this.pointer += 10;
                        MakeupList.this.displayCompletedList();
                    }
                    else if (MakeupList.this.pointer + 10 < MakeupList.this.matchCount && !MakeupList.this.searching) {
                        MakeupList.this.pointer += 10;
                        MakeupList.this.displayList();
                    }
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "IOException @ Selections:SelectScreen", "Invalid Format", 0);
                }
            }
        });
        this.backwardButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                try {
                    if (MakeupList.this.pointer - 10 >= 0 && MakeupList.this.searching) {
                        MakeupList.this.pointer -= 10;
                        MakeupList.this.searchDisplayList();
                    }
                    else if (MakeupList.this.pointer - 10 >= 0 && MakeupList.this.complete) {
                        MakeupList.this.pointer -= 10;
                        MakeupList.this.displayCompletedList();
                    }
                    else if (MakeupList.this.pointer - 10 >= 0 && !MakeupList.this.searching && !MakeupList.this.complete) {
                        MakeupList.this.pointer -= 10;
                        MakeupList.this.displayList();
                    }
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "IOException @ Selections:SelectScreen", "Invalid Format", 0);
                }
            }
        });
        this.saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                if (MakeupList.this.complete) {
                    JOptionPane.showMessageDialog(null, "Can Not Save To Completed Entry List", "Warning", 0);
                    return;
                }
                try {
                    MakeupList.this.saveEntry();
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "IOException @ MakeupList:saveEntry()", "Invalid Format", 0);
                }
            }
        });
        this.searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                final String showInputDialog = JOptionPane.showInputDialog("Enter Name To Be Searched..");
                if (showInputDialog == null) {
                    return;
                }
                if (showInputDialog.compareTo("") == 0) {
                    JOptionPane.showMessageDialog(null, "You Must Enter Name Or Part Of A Name", "Entry Not Removed", -1);
                    return;
                }
                try {
                    MakeupList.this.searchList(showInputDialog.toUpperCase().trim());
                    for (int i = 99; i < 108; ++i) {
                        MakeupList.this.textFields[i].setText("");
                    }
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "IOException @ MakeupList:searchList()", "Invalid Format", 0);
                }
            }
        });
        this.deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                try {
                    MakeupList.this.deleteButtonMethod(MakeupList.this.deleteFields[0].getText(), MakeupList.this.deleteFields[1].getText());
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "MUST ENTER A NUMBER", "Invalid Format", 0);
                }
                try {
                    if (!MakeupList.this.complete) {
                        MakeupList.this.displayList();
                    }
                    else {
                        MakeupList.this.displayCompletedList();
                    }
                }
                catch (IOException ex2) {
                    JOptionPane.showMessageDialog(null, "IOEXCEPTION DURING DISPLAY", "Error", 0);
                }
                MakeupList.this.deleteFields[0].setText("");
                MakeupList.this.deleteFields[1].setText("");
            }
        });
        this.expireButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                if (!MakeupList.this.complete) {
                    try {
                        MakeupList.this.expireButtonMethod(MakeupList.this.deleteFields[0].getText(), MakeupList.this.deleteFields[1].getText());
                    }
                    catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "MUST ENTER A NUMBER", "Invalid Format", 0);
                    }
                    try {
                        MakeupList.this.displayList();
                    }
                    catch (IOException ex2) {
                        JOptionPane.showMessageDialog(null, "IOEXCEPTION DURING DISPLAY", "Error", 0);
                    }
                    MakeupList.this.deleteFields[0].setText("");
                    MakeupList.this.deleteFields[1].setText("");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Can't Expire From Completed List", "Invalid Method", 0);
                }
            }
        });
        this.newEntryButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                if (MakeupList.this.complete) {
                    JOptionPane.showMessageDialog(null, "Can Not Add Entry To Completed Entry List", "Warning", 0);
                    return;
                }
                try {
                    MakeupList.this.newEntry();
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "IOException @ MakeupList:saveEntry()", "Invalid Format", 0);
                }
            }
        });
        this.cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                MakeupList.this.setVisible(false);
                MakeupList.this.hp.setVisible(true);
                MakeupList.this.hp.setEnabled(true);
                MakeupList.this.clearFields();
            }
        });
        this.buttons[0].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                MakeupList.this.textFields[101].setText(MakeupList.this.todayMonth + "-DD-" + MakeupList.this.todayYear);
            }
        });
        this.buttons[1].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                MakeupList.this.textFields[102].setText(MakeupList.this.todayMonth + "-DD-" + MakeupList.this.todayYear);
            }
        });
        this.buttons[2].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                MakeupList.this.textFields[103].setText(MakeupList.this.todayMonth + "-DD-" + MakeupList.this.todayYear);
            }
        });
        this.buttons[3].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                MakeupList.this.textFields[105].setText(MakeupList.this.todayMonth + "-" + MakeupList.this.todayDay + "(XX)");
            }
        });
        this.buttons[4].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                MakeupList.this.textFields[106].setText(MakeupList.this.todayMonth + "-" + MakeupList.this.todayDay + "(XX)");
            }
        });
        this.buttons[5].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                MakeupList.this.textFields[104].setText(MakeupList.this.todayMonth + "-DD-" + MakeupList.this.todayYear);
            }
        });
        final SpringLayout layout = new SpringLayout();
        final JPanel comp = new JPanel(layout);
        final Font font = new Font("", 1, 11);
        for (int k = 0; k < 108; ++k) {
            if (k % 9 == 0) {
                this.textFields[k] = new JTextField(3);
            }
            else if (k % 9 == 1) {
                this.textFields[k] = new JTextField(17);
            }
            else if (k % 9 == 8) {
                this.textFields[k] = new JTextField(10);
            }
            else {
                this.textFields[k] = new JTextField(7);
            }
            if (k < 9) {
                this.textFields[k].setBackground(new Color(54, 103, 24));
            }
            else {
                this.textFields[k].setBackground(Color.WHITE);
            }
            comp.add(this.textFields[k]);
            this.textFields[k].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            this.textFields[k].setFont(font);
            if (k < 99 || k == 100) {
                this.textFields[k].setEditable(false);
            }
        }
        for (int l = 0; l < 108; ++l) {
            if (l == 0 || l % 9 == 0) {
                layout.putConstraint("West", this.textFields[l], 10, "West", this.backgroundPanel);
            }
            else if (l % 9 == 6) {
                layout.putConstraint("West", this.textFields[l], 10, "East", this.textFields[l - 1]);
            }
            else {
                layout.putConstraint("West", this.textFields[l], 5, "East", this.textFields[l - 1]);
            }
            if (l < 9) {
                layout.putConstraint("North", this.textFields[l], 15, "North", this.backgroundPanel);
            }
            else if (l >= 99) {
                layout.putConstraint("North", this.textFields[l], 41, "South", this.textFields[l - 9]);
            }
            else {
                layout.putConstraint("North", this.textFields[l], 5, "South", this.textFields[l - 9]);
            }
        }
        for (int n = 0; n < 5; ++n) {
            comp.add(this.buttons[n]);
            if (n < 3) {
                layout.putConstraint("West", this.buttons[n], -1, "West", this.textFields[101 + n]);
            }
            else {
                layout.putConstraint("West", this.buttons[n], -1, "West", this.textFields[102 + n]);
            }
            layout.putConstraint("North", this.buttons[n], 13, "North", this.editBoxPanel);
        }
        comp.add(this.buttons[5]);
        layout.putConstraint("West", this.buttons[5], -1, "West", this.textFields[104]);
        layout.putConstraint("North", this.buttons[5], 13, "North", this.editBoxPanel);
        for (int n2 = 0; n2 < this.deleteFields.length; ++n2) {
            this.deleteFields[n2].setFont(font);
            this.deleteFields[n2].setBackground(Color.WHITE);
            comp.add(this.deleteFields[n2]);
            layout.putConstraint("North", this.deleteFields[n2], 5, "South", this.deleteButton);
        }
        layout.putConstraint("West", this.deleteFields[0], -5, "West", this.deleteButton);
        layout.putConstraint("East", this.deleteFields[1], 5, "East", this.deleteButton);
        layout.putConstraint("West", this.deleteFields[2], 5, "East", this.deleteFields[0]);
        this.deleteFields[2].setText(" to");
        comp.add(this.expireButton);
        layout.putConstraint("North", this.expireButton, 2, "South", this.deleteFields[0]);
        layout.putConstraint("West", this.expireButton, 0, "West", this.deleteButton);
        this.textFields[1].setText("Student Name");
        this.textFields[2].setText("Absent");
        this.textFields[3].setText("Makeup1");
        this.textFields[4].setText("Makeup2");
        this.textFields[5].setText("Makeup3");
        this.textFields[6].setText("Contact1");
        this.textFields[7].setText("Contact2");
        this.textFields[8].setText("Makeup Time");
        (this.textFields[108] = new JTextField(15)).setEditable(false);
        this.textFields[108].setBackground(Color.WHITE);
        comp.add(this.textFields[108]);
        this.textFields[108].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.textFields[108].setFont(font);
        layout.putConstraint("East", this.textFields[108], 0, "East", this.backgroundPanel);
        layout.putConstraint("South", this.textFields[108], 0, "North", this.backgroundPanel);
        comp.add(this.makeupListLabel);
        layout.putConstraint("West", this.makeupListLabel, 0, "West", comp);
        layout.putConstraint("North", this.makeupListLabel, 0, "North", comp);
        comp.add(this.switchListButton);
        this.switchListButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("East", this.switchListButton, -1, "West", this.backgroundPanel);
        layout.putConstraint("North", this.switchListButton, 0, "North", this.backgroundPanel);
        comp.add(this.forwardButton);
        this.forwardButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("West", this.forwardButton, 5, "East", this.backgroundPanel);
        layout.putConstraint("North", this.forwardButton, 150, "North", comp);
        comp.add(this.backwardButton);
        this.backwardButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("East", this.backwardButton, -5, "West", this.backgroundPanel);
        layout.putConstraint("North", this.backwardButton, 150, "North", comp);
        comp.add(this.newEntryButton);
        this.newEntryButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("West", this.newEntryButton, 70, "West", comp);
        layout.putConstraint("North", this.newEntryButton, 10, "South", this.editBoxPanel);
        comp.add(this.searchButton);
        this.searchButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("West", this.searchButton, 70, "East", this.newEntryButton);
        layout.putConstraint("North", this.searchButton, 10, "South", this.editBoxPanel);
        comp.add(this.deleteButton);
        this.deleteButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("West", this.deleteButton, 70, "East", this.searchButton);
        layout.putConstraint("North", this.deleteButton, 10, "South", this.editBoxPanel);
        comp.add(this.cancelButton);
        this.cancelButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("West", this.cancelButton, 70, "East", this.deleteButton);
        layout.putConstraint("North", this.cancelButton, 10, "South", this.editBoxPanel);
        comp.add(this.saveButton);
        this.saveButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("East", this.saveButton, -10, "East", this.editBoxPanel);
        layout.putConstraint("North", this.saveButton, 1, "South", this.textFields[107]);
        comp.add(this.retrieveButton);
        this.retrieveButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        layout.putConstraint("West", this.retrieveButton, 3, "West", this.editBoxPanel);
        layout.putConstraint("North", this.retrieveButton, 2, "South", this.textFields[101]);
        (this.title1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(45, 86, 20)), "CURRENT LIST")).setTitleJustification(1);
        this.title1.setTitleColor(new Color(45, 86, 20));
        this.backgroundPanel.setBorder(this.title1);
        this.backgroundPanel.setBackground(new Color(122, 182, 41));
        this.backgroundPanel.setPreferredSize(new Dimension(715, 240));
        comp.add(this.backgroundPanel);
        layout.putConstraint("West", this.backgroundPanel, 30, "West", comp);
        layout.putConstraint("North", this.backgroundPanel, 40, "North", comp);
        final TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(221, 94, 0)), "EDIT ENTRY");
        titledBorder.setTitleJustification(1);
        titledBorder.setTitleColor(new Color(221, 94, 0));
        this.editBoxPanel.setBorder(titledBorder);
        this.editBoxPanel.setBackground(new Color(255, 204, 1));
        this.editBoxPanel.setPreferredSize(new Dimension(715, 70));
        comp.add(this.editBoxPanel);
        layout.putConstraint("West", this.editBoxPanel, 30, "West", comp);
        layout.putConstraint("North", this.editBoxPanel, 5, "South", this.backgroundPanel);
        comp.setBackground(Color.WHITE);
        this.c.setBackground(Color.WHITE);
        this.c.add(comp);
        this.setSize(785, 485);
        try {
            if (this.list == null) {
                this.openMakeupFile();
            }
            this.list.seek(0L);
            this.matchCount = this.list.readInt();
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error When Editing MakeupList!!", "IOException Thrown", 0);
            return;
        }
        try {
            System.out.println("here1");
            this.listByFirstName();
            System.out.println("here2");
            this.completedEntries();
        }
        catch (IOException ex2) {
            JOptionPane.showMessageDialog(null, "Error When Collecting Student Names!!", "IOException Thrown", 0);
            return;
        }
        this.textFields[99].addActionListener(new EntryFieldHandler());
        this.setResizable(false);
    }
    
    private void listByFirstName() throws IOException {
        final StudentRecord studentRecord = new StudentRecord();
        if (this.output == null) {
            this.openFile();
        }
        this.output.seek(0L);
        final int int1 = this.output.readInt();
        this.names = new String[int1];
        this.numbers = new String[int1];
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
                this.names[0] = studentRecord.getFirstName() + " " + studentRecord.getLastName();
                this.numbers[0] = studentRecord.getTelephoneNumber();
            }
            else {
                for (int j = 0; j <= i; ++j) {
                    if (j == i) {
                        array2[j] = studentRecord.getFirstName();
                        array3[j] = studentRecord.getLastName();
                        this.names[j] = studentRecord.getFirstName() + " " + studentRecord.getLastName();
                        this.numbers[j] = studentRecord.getTelephoneNumber();
                        break;
                    }
                    if (array2[j].compareTo(studentRecord.getFirstName()) >= 0) {
                        if (array2[j].compareTo(studentRecord.getFirstName()) != 0 || array3[j].compareTo(studentRecord.getLastName()) >= 0) {
                            for (int k = i - 1; k >= j; --k) {
                                array2[k + 1] = array2[k];
                                array3[k + 1] = array3[k];
                                this.names[k + 1] = this.names[k];
                                this.numbers[k + 1] = this.numbers[k];
                            }
                            array2[j] = studentRecord.getFirstName();
                            array3[j] = studentRecord.getLastName();
                            this.names[j] = studentRecord.getFirstName() + " " + studentRecord.getLastName();
                            this.numbers[j] = studentRecord.getTelephoneNumber();
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public void completedEntries() throws IOException {
        final StudentRecord studentRecord = new StudentRecord();
        if (this.list == null) {
            this.openMakeupFile();
        }
        if (this.output == null) {
            this.openFile();
        }
        System.out.println("Here 1");
        this.list.seek(0L);
        final int int1 = this.list.readInt();
        this.output.seek(0L);
        final int int2 = this.output.readInt();
        System.out.println("MakeupListCount: " + int1);
        System.out.println("studentCount: " + int2);
        for (int i = int1 - 1; i >= 0; --i) {
            this.list.seek(i * 300 + 10);
            System.out.println("1");
            final String trim = this.readString(this.list, 25).trim();
            System.out.println("2");
            this.readString(this.list, 15).trim();
            System.out.println("3");
            final String trim2 = this.readString(this.list, 10).trim();
            System.out.println("4");
            final String trim3 = this.readString(this.list, 10).trim();
            System.out.println("5");
            final String trim4 = this.readString(this.list, 10).trim();
            System.out.println("6");
            final String trim5 = this.readString(this.list, 10).trim();
            System.out.println("7");
            final String trim6 = this.readString(this.list, 10).trim();
            System.out.println("8");
            final String trim7 = this.readString(this.list, 10).trim();
            System.out.println("9");
            System.out.println("Name: " + trim);
            if (trim2.length() != 0 && trim3.length() != 0 && trim4.length() == 0 && trim7.length() == 0) {
                if (this.datePassed(trim3, i)) {
                    System.out.println("Complete2");
                    this.saveCompletedEntry(i);
                    System.out.println("Complete3");
                    this.deleteEntry(i + 1);
                    System.out.println("Complete4");
                }
            }
            else if (trim2.length() != 0 && trim3.length() != 0 && trim4.length() != 0 && trim7.length() == 0) {
                if (this.datePassed(trim3, i) && this.datePassed(trim4, i)) {
                    System.out.println("Complete2");
                    this.saveCompletedEntry(i);
                    System.out.println("Complete3");
                    this.deleteEntry(i + 1);
                    System.out.println("Complete4");
                }
            }
            else if (trim2.length() != 0 && trim3.length() != 0 && trim4.length() != 0 && trim7.length() != 0) {
                if (this.datePassed(trim3, i) && this.datePassed(trim4, i) && this.datePassed(trim7, i)) {
                    System.out.println("Complete2");
                    this.saveCompletedEntry(i);
                    System.out.println("Complete3");
                    this.deleteEntry(i + 1);
                    System.out.println("Complete4");
                }
            }
            else if (trim5.length() != 0 && trim6.length() != 0) {
                this.saveCompletedEntry(i);
                this.deleteEntry(i + 1);
            }
        }
    }
    
    public boolean datePassed(final String s, final int i) {
        if (s.length() != 8) {
            return false;
        }
        int int1;
        int int2;
        int int3;
        int int4;
        int int5;
        int int6;
        try {
            int1 = Integer.parseInt(s.substring(0, 2));
            int2 = Integer.parseInt(s.substring(3, 5));
            int3 = Integer.parseInt(s.substring(6));
            int4 = Integer.parseInt(this.todayMonth);
            int5 = Integer.parseInt(this.todayYear);
            int6 = Integer.parseInt(this.todayDay);
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Illegal Format At Entry Number: " + i, "Error", 0);
            return false;
        }
        return int5 > int3 || (int5 == int3 && int4 > int1) || (int5 == int3 && int4 == int1 && int6 > int2);
    }
    
    public void setHomePage(final HomePage hp) {
        this.hp = hp;
    }
    
    public void retrieve() {
        final String trim = this.textFields[99].getText().trim();
        int int1;
        try {
            int1 = Integer.parseInt(trim);
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Retrieving Entry Using Illegal Number Format.  Please Try Again.", "Error", 0);
            return;
        }
        try {
            this.retrieveEntry(int1);
        }
        catch (IOException ex2) {
            JOptionPane.showMessageDialog(null, "IOException @ MakeupList:retrieve()", "Error", 0);
        }
    }
    
    public String printAndRemoveCompletedEntry(final String str) throws IOException {
        final String searchList3 = this.searchList3(str);
        if (this.completedList == null) {
            this.openCompletedMakeupFile();
        }
        this.completedList.seek(0L);
        for (int i = this.completedList.readInt() - 1; i >= 0; --i) {
            this.completedList.seek(i * 300 + 10);
            if (this.readString(this.completedList, 25).indexOf(str) != -1) {
                this.deleteCompletedEntry(i + 1);
            }
        }
        return searchList3;
    }
    
    public String searchList3(final String str) throws IOException {
        int n = 0;
        final String s = "";
        String s2 = "";
        if (str.length() == 0) {
            return s;
        }
        if (this.list == null) {
            this.openMakeupFile();
        }
        if (this.completedList == null) {
            this.openCompletedMakeupFile();
        }
        this.list.seek(0L);
        this.list.readInt();
        this.completedList.seek(0L);
        final int int1 = this.completedList.readInt();
        int n2 = 1;
        final String[] array = new String[5];
        for (int i = 0; i < int1; ++i) {
            this.completedList.seek(i * 300 + 10);
            if (this.readString(this.completedList, 25).indexOf(str) != -1) {
                array[3] = this.readString(this.completedList, 15).trim();
                array[0] = this.readString(this.completedList, 10).trim();
                array[1] = this.readString(this.completedList, 10).trim();
                array[2] = this.readString(this.completedList, 10).trim();
                this.readString(this.completedList, 10).trim();
                this.readString(this.completedList, 10).trim();
                array[4] = this.readString(this.completedList, 10).trim();
                if (array[1].length() == 0) {
                    s2 = s2 + "   (" + n2 + ")    " + array[0] + "   ---->    4 Contacts" + "\n";
                }
                else if (array[2].length() != 0 && array[4].length() == 0) {
                    s2 = s2 + "   (" + n2 + ")    " + array[0] + "   ---->    " + array[1] + ", " + array[2] + " ; " + array[3] + "\n";
                }
                else if (array[4].length() != 0) {
                    s2 = s2 + "   (" + n2 + ")    " + array[0] + "   ---->    " + array[1] + ", " + array[2] + ", " + array[4] + " ; " + array[3] + "\n";
                }
                else {
                    s2 = s2 + "   (" + n2 + ")    " + array[0] + "   ---->    " + array[1] + " ; " + array[3] + "\n";
                }
                ++n;
                ++n2;
            }
        }
        if (n > 0) {
            return s2;
        }
        return "\n\n                   NO COMPLETED MAKEUPS";
    }
    
    public int searchList2(final String str) throws IOException {
        int n = 0;
        this.pointer = 0;
        final int[] array = new int[this.matchCount];
        if (str.length() == 0) {
            return 0;
        }
        if (this.list == null) {
            this.openMakeupFile();
        }
        this.list.seek(0L);
        final int int1 = this.list.readInt();
        if (int1 == 0) {
            return 0;
        }
        for (int i = 0; i < int1; ++i) {
            this.list.seek(i * 300 + 10);
            if (this.readString(this.list, 25).indexOf(str) != -1) {
                array[n] = i;
                ++n;
            }
        }
        return n;
    }
    
    public int searchList(final String s) throws IOException {
        int searchCount = 0;
        this.pointer = 0;
        final int[] matches = new int[this.matchCount];
        if (s.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid Input", "Error", 0);
            return 0;
        }
        int n;
        if (!this.complete) {
            if (this.list == null) {
                this.openMakeupFile();
            }
            this.list.seek(0L);
            n = this.list.readInt();
        }
        else {
            if (this.completedList == null) {
                this.openCompletedMakeupFile();
            }
            this.completedList.seek(0L);
            n = this.completedList.readInt();
        }
        if (n == 0) {
            JOptionPane.showMessageDialog(null, "There Are No Records In List At This Time", "Not Enough Informaion", 0);
            return 0;
        }
        if (!this.complete) {
            for (int i = 0; i < n; ++i) {
                this.list.seek(i * 300 + 10);
                if (this.readString(this.list, 25).indexOf(s) != -1) {
                    matches[searchCount] = i;
                    ++searchCount;
                }
            }
        }
        else {
            for (int j = 0; j < n; ++j) {
                this.completedList.seek(j * 300 + 10);
                if (this.readString(this.completedList, 25).indexOf(s) != -1) {
                    matches[searchCount] = j;
                    ++searchCount;
                }
            }
        }
        if (searchCount == 0) {
            JOptionPane.showMessageDialog(null, "No Match Found In Makeup List", "Information", 0);
            this.displayList();
            return 0;
        }
        this.matches = new int[searchCount];
        this.matches = matches;
        this.searchCount = searchCount;
        this.searchDisplayList();
        this.searching = true;
        return searchCount;
    }
    
    private void getDateTime() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM");
        final SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("dd");
        final SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("EEE");
        final Date date = new Date();
        this.todayMonth = simpleDateFormat2.format(date);
        this.todayYear = simpleDateFormat.format(date).substring(2);
        this.todayDay = simpleDateFormat3.format(date);
    }
    
    private void retrieveEntry(final int n) throws IOException {
        this.textFields[100].setText("");
        this.textFields[101].setText("");
        this.textFields[102].setText("");
        this.textFields[103].setText("");
        this.textFields[104].setText("");
        this.textFields[105].setText("");
        this.textFields[106].setText("");
        this.textFields[107].setText("");
        if (this.list == null) {
            this.openMakeupFile();
        }
        this.list.seek(0L);
        final int int1 = this.list.readInt();
        if (int1 == 0 || n > int1 || n < 1) {
            JOptionPane.showMessageDialog(null, "Unable To Retrieve Entry.  Please Try Again With Correct Entry Number.", "Entry Not Removed", -1);
            return;
        }
        this.list.seek((n - 1) * 300 + 10);
        this.textFields[100].setText(this.readString(this.list, 25).trim());
        this.textFields[107].setText(this.readString(this.list, 15).trim());
        this.textFields[101].setText(this.readString(this.list, 10).trim());
        this.textFields[102].setText(this.readString(this.list, 10).trim());
        this.textFields[103].setText(this.readString(this.list, 10).trim());
        this.textFields[105].setText(this.readString(this.list, 10).trim());
        this.textFields[106].setText(this.readString(this.list, 10).trim());
        this.textFields[104].setText(this.readString(this.list, 10).trim());
    }
    
    private void newEntry() throws IOException {
        final String s = (String)JOptionPane.showInputDialog(null, "Choose A Student..", "Customized Dialog", -1, null, this.names, "");
        this.textFields[99].setText("");
        this.textFields[100].setText("");
        this.textFields[101].setText("");
        this.textFields[102].setText("");
        this.textFields[103].setText("");
        this.textFields[104].setText("");
        this.textFields[105].setText("");
        this.textFields[106].setText("");
        this.textFields[107].setText("");
        if (s != null && s.length() > 0) {
            this.textFields[100].setText(s.substring(0, s.indexOf(" ")) + " " + s.substring(s.indexOf(" ") + 1));
        }
    }
    
    public void searchDisplayList() throws IOException {
        int n = 9;
        if (!this.complete) {
            if (this.list == null) {
                this.openMakeupFile();
            }
        }
        else if (this.completedList == null) {
            this.openCompletedMakeupFile();
        }
        for (int i = 9; i < 99; ++i) {
            this.textFields[i].setText("");
        }
        if (!this.complete) {
            for (int pointer = this.pointer, n2 = 1; pointer < this.searchCount && pointer < this.pointer + 10; ++pointer, ++n2) {
                this.list.seek(this.matches[pointer] * 300 + 10);
                this.textFields[n].setText(Integer.toString(this.matches[pointer] + 1));
                this.textFields[n + 1].setText(this.readString(this.list, 25).trim());
                this.textFields[n + 8].setText(this.readString(this.list, 15).trim());
                this.textFields[n + 2].setText(this.readString(this.list, 10).trim());
                this.textFields[n + 3].setText(this.readString(this.list, 10).trim());
                this.textFields[n + 4].setText(this.readString(this.list, 10).trim());
                this.textFields[n + 6].setText(this.readString(this.list, 10).trim());
                this.textFields[n + 7].setText(this.readString(this.list, 10).trim());
                this.textFields[n + 5].setText(this.readString(this.list, 10).trim());
                n = 9 * (n2 + 1);
            }
        }
        else {
            for (int pointer2 = this.pointer, n3 = 1; pointer2 < this.searchCount && pointer2 < this.pointer + 10; ++pointer2, ++n3) {
                this.completedList.seek(this.matches[pointer2] * 300 + 10);
                this.textFields[n].setText(Integer.toString(this.matches[pointer2] + 1));
                this.textFields[n + 1].setText(this.readString(this.completedList, 25).trim());
                this.textFields[n + 8].setText(this.readString(this.completedList, 15).trim());
                this.textFields[n + 2].setText(this.readString(this.completedList, 10).trim());
                this.textFields[n + 3].setText(this.readString(this.completedList, 10).trim());
                this.textFields[n + 4].setText(this.readString(this.completedList, 10).trim());
                this.textFields[n + 6].setText(this.readString(this.completedList, 10).trim());
                this.textFields[n + 7].setText(this.readString(this.completedList, 10).trim());
                this.textFields[n + 5].setText(this.readString(this.completedList, 10).trim());
                n = 9 * (n3 + 1);
            }
        }
        this.textFields[108].setText("Entry Count = " + this.searchCount);
    }
    
    public void displayList() throws IOException {
        int n = 9;
        this.searching = false;
        if (this.list == null) {
            this.openMakeupFile();
        }
        this.list.seek(0L);
        final int int1 = this.list.readInt();
        this.matchCount = int1;
        for (int i = 9; i < 99; ++i) {
            this.textFields[i].setText("");
        }
        for (int pointer = this.pointer, n2 = 1; pointer < int1 && pointer < this.pointer + 10; ++pointer, ++n2) {
            this.list.seek(pointer * 300 + 10);
            this.textFields[n].setText(Integer.toString(pointer + 1));
            this.textFields[n + 1].setText(this.readString(this.list, 25).trim());
            this.textFields[n + 8].setText(this.readString(this.list, 15).trim());
            this.textFields[n + 2].setText(this.readString(this.list, 10).trim());
            this.textFields[n + 3].setText(this.readString(this.list, 10).trim());
            this.textFields[n + 4].setText(this.readString(this.list, 10).trim());
            this.textFields[n + 6].setText(this.readString(this.list, 10).trim());
            this.textFields[n + 7].setText(this.readString(this.list, 10).trim());
            this.textFields[n + 5].setText(this.readString(this.list, 10).trim());
            n = 9 * (n2 + 1);
        }
        this.textFields[108].setText("Entry Count = " + int1);
    }
    
    public void displayCompletedList() throws IOException {
        int n = 9;
        this.searching = false;
        if (this.completedList == null) {
            this.openCompletedMakeupFile();
        }
        this.completedList.seek(0L);
        final int int1 = this.completedList.readInt();
        this.matchCount = int1;
        for (int i = 9; i < 99; ++i) {
            this.textFields[i].setText("");
        }
        for (int pointer = this.pointer, n2 = 1; pointer < int1 && pointer < this.pointer + 10; ++pointer, ++n2) {
            this.completedList.seek(pointer * 300 + 10);
            this.textFields[n].setText(Integer.toString(pointer + 1));
            this.textFields[n + 1].setText(this.readString(this.completedList, 25).trim());
            this.textFields[n + 8].setText(this.readString(this.completedList, 15).trim());
            this.textFields[n + 2].setText(this.readString(this.completedList, 10).trim());
            this.textFields[n + 3].setText(this.readString(this.completedList, 10).trim());
            this.textFields[n + 4].setText(this.readString(this.completedList, 10).trim());
            this.textFields[n + 6].setText(this.readString(this.completedList, 10).trim());
            this.textFields[n + 7].setText(this.readString(this.completedList, 10).trim());
            this.textFields[n + 5].setText(this.readString(this.completedList, 10).trim());
            n = 9 * (n2 + 1);
        }
        this.textFields[108].setText("Entry Count = " + int1);
    }
    
    public void deleteCompletedEntry(final int n) throws IOException {
        final String[] array = new String[8];
        System.out.println("entry = " + n);
        if (this.completedList == null) {
            this.openCompletedMakeupFile();
        }
        System.out.println("entry = " + n);
        this.completedList.seek(0L);
        System.out.println("entry = " + n);
        final int int1 = this.completedList.readInt();
        System.out.println("recordCount = " + int1);
        System.out.println("entry = " + n);
        if (int1 == 0 || n > int1 || n < 1) {
            JOptionPane.showMessageDialog(null, "Unable To Remove Entry.  Please Try Again With Correct Entry Number.", "Entry Not Removed", -1);
            this.failure = true;
            return;
        }
        if (n == 1 && int1 == 1) {
            this.completedList.seek(0L);
            this.completedList.writeInt(0);
            return;
        }
        if (n == int1) {
            this.completedList.seek(0L);
            this.completedList.writeInt(int1 - 1);
            return;
        }
        for (int i = n; i < int1; ++i) {
            this.completedList.seek(i * 300 + 10);
            array[0] = this.readString(this.completedList, 25);
            array[1] = this.readString(this.completedList, 15);
            array[2] = this.readString(this.completedList, 10);
            array[3] = this.readString(this.completedList, 10);
            array[4] = this.readString(this.completedList, 10);
            array[5] = this.readString(this.completedList, 10);
            array[6] = this.readString(this.completedList, 10);
            array[7] = this.readString(this.completedList, 10);
            this.completedList.seek((i - 1) * 300 + 10);
            this.writeString(this.completedList, array[0], 25);
            this.writeString(this.completedList, array[1], 15);
            this.writeString(this.completedList, array[2], 10);
            this.writeString(this.completedList, array[3], 10);
            this.writeString(this.completedList, array[4], 10);
            this.writeString(this.completedList, array[5], 10);
            this.writeString(this.completedList, array[6], 10);
            this.writeString(this.completedList, array[7], 10);
        }
        this.completedList.seek(0L);
        this.completedList.writeInt(int1 - 1);
    }
    
    public void deleteButtonMethod(final String s, final String s2) throws NumberFormatException {
        this.failure = false;
        if (!this.complete) {
            if (s.length() > 0 && s2.length() > 0) {
                final int int1 = Integer.parseInt(s);
                final int int2 = Integer.parseInt(s2);
                if (int1 > int2) {
                    JOptionPane.showMessageDialog(null, "1ST ENTRY CANNOT BE LARGER THAN 2ND", "Error", 0);
                    return;
                }
                if (int1 > 0) {
                    for (int i = int2; i >= int1; --i) {
                        try {
                            this.deleteEntry(i);
                            if (this.failure) {
                                return;
                            }
                        }
                        catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "IOEXCEPTION WHEN DELETING", "Error", 0);
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Unable To Remove Entry.  Please Try Again With Correct Entry Number.", "Entry Not Removed", -1);
                }
            }
            else if (s.length() > 0) {
                final int int3 = Integer.parseInt(s);
                try {
                    this.deleteEntry(int3);
                }
                catch (IOException ex2) {
                    JOptionPane.showMessageDialog(null, "IOEXCEPTION WHEN DELETING", "Error", 0);
                }
            }
            else if (s2.length() > 0) {
                final int int4 = Integer.parseInt(s2);
                try {
                    this.deleteEntry(int4);
                }
                catch (IOException ex3) {
                    JOptionPane.showMessageDialog(null, "IOEXCEPTION WHEN DELETING", "Error", 0);
                }
            }
        }
        else if (s.length() > 0 && s2.length() > 0) {
            final int int5 = Integer.parseInt(s);
            final int int6 = Integer.parseInt(s2);
            if (int5 > int6) {
                JOptionPane.showMessageDialog(null, "1ST ENTRY CANNOT BE LARGER THAN 2ND", "Error", 0);
                return;
            }
            if (int5 > 0) {
                for (int j = int6; j >= int5; --j) {
                    try {
                        this.deleteCompletedEntry(j);
                        if (this.failure) {
                            return;
                        }
                    }
                    catch (IOException ex4) {
                        JOptionPane.showMessageDialog(null, "IOEXCEPTION WHEN DELETING", "Error", 0);
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Unable To Remove Entry.  Please Try Again With Correct Entry Number.", "Entry Not Removed", -1);
            }
        }
        else if (s.length() > 0) {
            final int int7 = Integer.parseInt(s);
            try {
                this.deleteCompletedEntry(int7);
            }
            catch (IOException ex5) {
                JOptionPane.showMessageDialog(null, "IOEXCEPTION WHEN DELETING", "Error", 0);
            }
        }
        else if (s2.length() > 0) {
            final int int8 = Integer.parseInt(s2);
            try {
                this.deleteCompletedEntry(int8);
            }
            catch (IOException ex6) {
                JOptionPane.showMessageDialog(null, "IOEXCEPTION WHEN DELETING", "Error", 0);
            }
        }
    }
    
    public void deleteEntry(final int n) throws IOException {
        final String[] array = new String[8];
        System.out.println("entry = " + n);
        if (this.list == null) {
            this.openMakeupFile();
        }
        System.out.println("entry = " + n);
        this.list.seek(0L);
        System.out.println("entry = " + n);
        final int int1 = this.list.readInt();
        System.out.println("recordCount = " + int1);
        System.out.println("entry = " + n);
        if (int1 == 0 || n > int1 || n < 1) {
            JOptionPane.showMessageDialog(null, "Unable To Remove Entry.  Please Try Again With Correct Entry Number.", "Entry Not Removed", -1);
            this.failure = true;
            return;
        }
        if (n == 1 && int1 == 1) {
            this.list.seek(0L);
            this.list.writeInt(0);
            return;
        }
        if (n == int1) {
            this.list.seek(0L);
            this.list.writeInt(int1 - 1);
            return;
        }
        for (int i = n; i < int1; ++i) {
            this.list.seek(i * 300 + 10);
            array[0] = this.readString(this.list, 25);
            array[1] = this.readString(this.list, 15);
            array[2] = this.readString(this.list, 10);
            array[3] = this.readString(this.list, 10);
            array[4] = this.readString(this.list, 10);
            array[5] = this.readString(this.list, 10);
            array[6] = this.readString(this.list, 10);
            array[7] = this.readString(this.list, 10);
            this.list.seek((i - 1) * 300 + 10);
            this.writeString(this.list, array[0], 25);
            this.writeString(this.list, array[1], 15);
            this.writeString(this.list, array[2], 10);
            this.writeString(this.list, array[3], 10);
            this.writeString(this.list, array[4], 10);
            this.writeString(this.list, array[5], 10);
            this.writeString(this.list, array[6], 10);
            this.writeString(this.list, array[7], 10);
        }
        this.list.seek(0L);
        this.list.writeInt(int1 - 1);
    }
    
    public void deleteEntry() throws IOException {
        final int n = 0;
        final String[] array = new String[8];
        String s;
        if (!this.complete) {
            s = JOptionPane.showInputDialog("Enter The Entry Number To Be Removed From Makeup List");
        }
        else {
            s = JOptionPane.showInputDialog("Enter The Entry Number To Be Removed From 'Completed' List");
        }
        if (s == null) {
            return;
        }
        if (s.compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "You Must Enter A Number", "Entry Not Removed", -1);
            return;
        }
        int int1;
        try {
            int1 = Integer.parseInt(s);
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "You Must Enter A Number", "Entry Not Removed", 0);
            return;
        }
        if (this.complete) {
            this.deleteCompletedEntry(int1);
            this.displayCompletedList();
            return;
        }
        this.deleteEntry(int1);
        this.matchCount = n - 1;
        int n2;
        if (int1 == 1) {
            n2 = 0;
        }
        else {
            n2 = int1 - 1;
        }
        this.pointer = n2 / 10 * 10;
        this.displayList();
        this.textFields[100].setText("");
        this.textFields[101].setText("");
        this.textFields[102].setText("");
        this.textFields[103].setText("");
        this.textFields[104].setText("");
        this.textFields[105].setText("");
        this.textFields[106].setText("");
        this.textFields[107].setText("");
    }
    
    private void saveCompletedEntry(final int n) throws IOException {
        final String[] array = new String[8];
        if (this.completedList == null) {
            this.openCompletedMakeupFile();
        }
        if (this.list == null) {
            this.openMakeupFile();
        }
        this.completedList.seek(0L);
        final int int1 = this.completedList.readInt();
        this.list.seek(n * 300 + 10);
        this.completedList.seek(int1 * 300 + 10);
        array[0] = this.readString(this.list, 25);
        array[1] = this.readString(this.list, 15);
        array[2] = this.readString(this.list, 10);
        array[3] = this.readString(this.list, 10);
        array[4] = this.readString(this.list, 10);
        array[5] = this.readString(this.list, 10);
        array[6] = this.readString(this.list, 10);
        array[7] = this.readString(this.list, 10);
        for (int i = 0; i < 8; ++i) {
            System.out.println("tmp=" + array[i]);
        }
        this.writeString(this.completedList, array[0], 25);
        this.writeString(this.completedList, array[1], 15);
        this.writeString(this.completedList, array[2], 10);
        this.writeString(this.completedList, array[3], 10);
        this.writeString(this.completedList, array[4], 10);
        this.writeString(this.completedList, array[5], 10);
        this.writeString(this.completedList, array[6], 10);
        this.writeString(this.completedList, array[7], 10);
        this.completedList.seek(0L);
        this.completedList.writeInt(int1 + 1);
    }
    
    private void expireEntry(final int n) throws IOException {
        final String[] array = new String[8];
        if (this.completedList == null) {
            this.openCompletedMakeupFile();
        }
        if (this.list == null) {
            this.openMakeupFile();
        }
        this.completedList.seek(0L);
        final int int1 = this.completedList.readInt();
        this.list.seek(0L);
        final int int2 = this.list.readInt();
        if (int2 == 0 || n >= int2 || n < 0) {
            JOptionPane.showMessageDialog(null, "Unable To Expire Entry.  Please Try Again With Correct Entry Number.", "Entry Not Expired", -1);
            this.expireFailure = true;
            return;
        }
        this.list.seek(n * 300 + 10);
        this.completedList.seek(int1 * 300 + 10);
        array[0] = this.readString(this.list, 25);
        array[1] = this.readString(this.list, 15);
        array[2] = this.readString(this.list, 10);
        array[3] = this.readString(this.list, 10);
        array[4] = this.readString(this.list, 10);
        array[5] = this.readString(this.list, 10);
        array[6] = this.readString(this.list, 10);
        array[7] = this.readString(this.list, 10);
        for (int i = 0; i < 8; ++i) {
            System.out.println("tmp=" + array[i]);
        }
        this.writeString(this.completedList, array[0], 25);
        this.writeString(this.completedList, "Expired", 15);
        this.writeString(this.completedList, array[2], 10);
        this.writeString(this.completedList, this.todayMonth + "-" + this.todayDay + "-" + this.todayYear, 10);
        this.writeString(this.completedList, "", 10);
        this.writeString(this.completedList, array[5], 10);
        this.writeString(this.completedList, array[6], 10);
        this.writeString(this.completedList, "", 10);
        this.completedList.seek(0L);
        this.completedList.writeInt(int1 + 1);
    }
    
    private void expireButtonMethod(final String s, final String s2) throws NumberFormatException {
        this.expireFailure = false;
        if (!this.complete) {
            if (s.length() > 0 && s2.length() > 0) {
                final int int1 = Integer.parseInt(s);
                final int int2 = Integer.parseInt(s2);
                if (int1 > int2) {
                    JOptionPane.showMessageDialog(null, "1ST ENTRY CANNOT BE LARGER THAN 2ND", "Error", 0);
                    return;
                }
                if (int1 > 0) {
                    for (int i = int2; i >= int1; --i) {
                        try {
                            this.expireEntry(i - 1);
                            if (this.expireFailure) {
                                return;
                            }
                            this.deleteEntry(i);
                        }
                        catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "IOEXCEPTION WHEN EXPIRING", "Error", 0);
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Unable To Remove Entry.  Please Try Again With Correct Entry Number.", "Entry Not Removed", -1);
                }
            }
            else if (s.length() > 0) {
                final int int3 = Integer.parseInt(s);
                try {
                    this.expireEntry(int3 - 1);
                    if (this.expireFailure) {
                        return;
                    }
                    this.deleteEntry(int3);
                }
                catch (IOException ex2) {
                    JOptionPane.showMessageDialog(null, "IOEXCEPTION WHEN EXPIRING", "Error", 0);
                }
            }
            else if (s2.length() > 0) {
                final int int4 = Integer.parseInt(s2);
                try {
                    this.expireEntry(int4 - 1);
                    if (this.expireFailure) {
                        return;
                    }
                    this.deleteEntry(int4);
                }
                catch (IOException ex3) {
                    JOptionPane.showMessageDialog(null, "IOEXCEPTION WHEN EXPIRING", "Error", 0);
                }
            }
        }
        else if (s.length() > 0 && s2.length() > 0) {
            final int int5 = Integer.parseInt(s);
            final int int6 = Integer.parseInt(s2);
            if (int5 > int6) {
                JOptionPane.showMessageDialog(null, "1ST ENTRY CANNOT BE LARGER THAN 2ND", "Error", 0);
                return;
            }
            if (int5 > 0) {
                for (int j = int6; j >= int5; --j) {
                    try {
                        this.deleteCompletedEntry(j);
                        if (this.failure) {
                            return;
                        }
                    }
                    catch (IOException ex4) {
                        JOptionPane.showMessageDialog(null, "IOEXCEPTION WHEN DELETING", "Error", 0);
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Unable To Remove Entry.  Please Try Again With Correct Entry Number.", "Entry Not Removed", -1);
            }
        }
        else if (s.length() > 0) {
            final int int7 = Integer.parseInt(s);
            try {
                this.deleteCompletedEntry(int7);
            }
            catch (IOException ex5) {
                JOptionPane.showMessageDialog(null, "IOEXCEPTION WHEN DELETING", "Error", 0);
            }
        }
        else if (s2.length() > 0) {
            final int int8 = Integer.parseInt(s2);
            try {
                this.deleteCompletedEntry(int8);
            }
            catch (IOException ex6) {
                JOptionPane.showMessageDialog(null, "IOEXCEPTION WHEN DELETING", "Error", 0);
            }
        }
    }
    
    private void saveEntry() throws IOException {
        if (this.textFields[100].getText().compareTo("") == 0 || this.textFields[101].getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Name, Phone Number, Absent Date Must Be Entered!!", "Invalid Format", 0);
            return;
        }
        try {
            for (int i = 101; i <= 104; ++i) {
                final String trim = this.textFields[i].getText().trim();
                System.out.println("tmp: " + trim);
                if (trim.length() != 0 && trim.length() != 8) {
                    JOptionPane.showMessageDialog(null, "Incorrect Date Format Found @ Absent & Makeup!!  Correct format is: MM-DD-YY", "Invalid Format", 0);
                    return;
                }
                if (trim.length() != 0) {
                    Integer.parseInt(trim.substring(0, 2));
                    Integer.parseInt(trim.substring(3, 5));
                    Integer.parseInt(trim.substring(6));
                }
            }
            for (int j = 105; j <= 106; ++j) {
                final String trim2 = this.textFields[j].getText().trim();
                System.out.println("tmp: " + trim2);
                if (trim2.length() != 0 && trim2.length() != 9) {
                    JOptionPane.showMessageDialog(null, "Incorrect Date Format Found @ Contact!!  Correct format is: MM-DD(XX) \n **XX is for the first and last initials of current recorder", "Invalid Format", 0);
                    return;
                }
                if (trim2.length() == 9 && (trim2.substring(5, 6).compareTo("(") != 0 || trim2.substring(8, 9).compareTo(")") != 0)) {
                    JOptionPane.showMessageDialog(null, "Incorrect Date Format Found @ Contact!!  Correct format is: MM-DD(XX) \n **XX is for the first and last initials of current recorder", "Invalid Format", 0);
                    return;
                }
                if (trim2.length() != 0) {
                    Integer.parseInt(trim2.substring(0, 2));
                    Integer.parseInt(trim2.substring(3, 5));
                }
            }
            if (this.textFields[103].getText().trim().length() != 0 && this.textFields[102].getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Fill in date for Makeup1 before continuing to Makeup2", "Invalid Format", 0);
                return;
            }
            if (this.textFields[104].getText().trim().length() != 0 && this.textFields[103].getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Fill in date for Makeup2 before continuing to Makeup3", "Invalid Format", 0);
                return;
            }
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Incorrect Date Format Found!!  Correct Format is: MM-DD-YY", "Invalid Format", 0);
            return;
        }
        if (this.list == null) {
            this.openMakeupFile();
        }
        this.list.seek(0L);
        final int int1 = this.list.readInt();
        this.matchCount = int1;
        int int2 = 0;
        if (this.output == null) {
            this.openFile();
        }
        if (this.textFields[99].getText().compareTo("") != 0) {
            int2 = Integer.parseInt(this.textFields[99].getText());
        }
        if (int1 < int2) {
            JOptionPane.showMessageDialog(null, "Incorrect Record Number Entered!!", "Invalid Format", 0);
            return;
        }
        if (this.textFields[99].getText().compareTo("") != 0) {
            this.list.seek((int2 - 1) * 300 + 10);
            if (this.readString(this.list, 25).trim().compareTo(this.textFields[100].getText().toUpperCase().trim()) != 0) {
                JOptionPane.showMessageDialog(null, "Name And List Number Do Not Match!!", "Invalid Format", 0);
                return;
            }
        }
        int int3;
        if (this.textFields[99].getText().trim().compareTo("") == 0) {
            int3 = int1;
        }
        else {
            int3 = Integer.parseInt(this.textFields[99].getText().trim());
            --int3;
        }
        this.list.seek(int3 * 300 + 10);
        this.writeString(this.list, this.textFields[100].getText().toUpperCase().trim(), 25);
        this.writeString(this.list, this.textFields[107].getText().trim(), 15);
        this.writeString(this.list, this.textFields[101].getText().trim(), 10);
        this.writeString(this.list, this.textFields[102].getText().trim(), 10);
        this.writeString(this.list, this.textFields[103].getText().trim(), 10);
        this.writeString(this.list, this.textFields[105].getText().trim(), 10);
        this.writeString(this.list, this.textFields[106].getText().trim(), 10);
        this.writeString(this.list, this.textFields[104].getText().trim(), 10);
        if (this.textFields[99].getText().trim().compareTo("") == 0) {
            this.list.seek(0L);
            this.list.writeInt(int1 + 1);
            this.matchCount = int1 + 1;
            this.pointer = int1 / 10 * 10;
        }
        else {
            this.pointer = (int2 - 1) / 10 * 10;
        }
        for (int k = 99; k < 108; ++k) {
            this.textFields[k].setText("");
        }
        this.displayList();
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
    
    private String readString(final RandomAccessFile randomAccessFile, final int n) throws IOException {
        final char[] value = new char[n];
        for (int i = 0; i < value.length; ++i) {
            value[i] = randomAccessFile.readChar();
        }
        return new String(value).replace('\0', ' ');
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
    
    private void openCompletedMakeupFile() {
        try {
            this.completedList = new RandomAccessFile("MakeupListCompleted.txt", "rw");
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "File does not exist", "Invalid File Name", 0);
        }
    }
    
    private void closeCompletedMakeupFile() {
        try {
            this.completedList.close();
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error closing file", "Error", 0);
            System.exit(1);
        }
    }
    
    public void clearFields() {
        this.pointer = 0;
        this.searching = false;
        for (int i = 9; i < 109; ++i) {
            this.textFields[i].setText("");
        }
        this.title1.setTitle("CURRENT LIST");
        this.title1.setTitleColor(new Color(45, 86, 20));
        this.backgroundPanel.setBackground(new Color(122, 182, 41));
        for (int j = 0; j < 9; ++j) {
            this.textFields[j].setBackground(new Color(45, 86, 20));
        }
        for (int k = 0; k < 2; ++k) {
            this.deleteFields[k].setText("");
        }
        this.complete = false;
    }
    
    public static void main(final String[] array) {
        new MakeupList().addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
    
    public int getDayofYear(final int n, final int n2) {
        if (n <= 0 || n2 <= 0 || n > 12 || n2 > 31) {
            return -1;
        }
        return (new int[] { 0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 })[n] + n2;
    }
    
    private class EntryFieldHandler implements ActionListener
    {
        public void actionPerformed(final ActionEvent actionEvent) {
            if (actionEvent.getSource() == MakeupList.this.textFields[99]) {
                if (MakeupList.this.complete) {
                    JOptionPane.showMessageDialog(null, "Can Not Save To Completed Entry List", "Warning", 0);
                    return;
                }
                MakeupList.this.retrieve();
            }
        }
    }
}