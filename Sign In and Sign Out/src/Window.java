import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

import com.opencsv.CSVReader;

import java.util.Scanner;

public class Window extends JFrame implements ActionListener{

	private static final long serialVersionUID = -7646024961195798763L;
	ArrayList<String> names;
	ArrayList<Person> people;
	JButton signIn;
	JButton signOut;
	JScrollPane scrollPane;
	JPanel panel;
	JList<String> list;
	JFrame confirm;
	JButton cancel;
	JButton ok;
	JPanel conp;
	JLabel mes;
	JButton read;
	CSV csv;
	boolean in;
	JFrame record;
	JPanel rec;
	JList<String> fileList;
	JScrollPane scrollFiles;
	JFrame readFrame;
	JPanel readPanel;
	JList<String> readData;
	JScrollPane displayData;
	JButton readFiles;
	JButton back;
	JButton readFileExit;
	JButton readAll;
	JFrame dateFrame;
	JPanel datePanel;
	JButton readAllFiles;
	JButton readBetweenDates;
	int[] startDates;
	int[] endDates;
	JTextField startDay;
	JTextField startMonth;
	JTextField startYear;
	JTextField endDay;
	JTextField endMonth;
	JTextField endYear;
	JButton readBack;
	JButton signOutAll;
	JFrame signOutAllFrame;
	JPanel signOutAllPanel;
	JButton signOutAllOK;
	JButton signOutAllBack;
	
	public static void main(String[] args) {
		new Window();

	}
	
	public Window() {
		setTitle("Sign In");
		setSize(1080,720);
		panel = new JPanel(null);
		
		signIn = new JButton("Sign In");
		signIn.setFont(new Font("arial", 1, 50));
		signIn.setSize(300,150);
		signIn.setLocation(200,450);
		signIn.setFocusable(false);
		signIn.addActionListener(this);
		
		signOut = new JButton("Sign Out");
		signOut.setFont(new Font("arial", 1, 50));
		signOut.setSize(300,150);
		signOut.setLocation(600,450);
		signOut.setFocusable(false);
		signOut.addActionListener(this);
		
		read = new JButton("Read Files");
		read.setFont(new Font("arial", 1, 50));
		read.setSize(300,150);
		read.setLocation(20,150);
		read.setFocusable(false);
		read.addActionListener(this);
		
		signOutAll = new JButton("Sign Out All");
		signOutAll.setFont(new Font("arial", 1, 40));
		signOutAll.setSize(300,150);
		signOutAll.setLocation(760,150);
		signOutAll.setFocusable(false);
		signOutAll.addActionListener(this);
		
		names = new ArrayList<String>();
		people = new ArrayList<Person>();
		
		Person Alec = new Person("Alec Levy");
		people.add(Alec);
		
		Person Andres = new Person("Andres Gonzalez");
		people.add(Andres);
		
		Person Baron = new Person("Baron Lemus");
		people.add(Baron);
		
		Person Brett = new Person("Brett Gomberg");
		people.add(Brett);
		
		Person Charles = new Person("Charles Villegas");
		people.add(Charles);
		
		Person Colin = new Person("Colin Murnane");
		people.add(Colin);
		
		Person Cooper = new Person("Cooper Tai");
		people.add(Cooper);
		
		Person Corey = new Person("Corey Sims");
		people.add(Corey);
		
		Person DanielM = new Person("Daniel Mastick");
		people.add(DanielM);
		
		Person Daniel = new Person("Daniel Wu");
		people.add(Daniel);
		
		Person David = new Person("David Wilson");
		people.add(David);
		
		Person Destry = new Person("Destry Smith");
		people.add(Destry);
		
		Person Dillon = new Person("Dillon Spilker");
		people.add(Dillon);
		
		Person Emily = new Person("Emily Gritchen");
		people.add(Emily);
		
		Person Fausto = new Person("Fausto Kang");
		people.add(Fausto);
		
		Person Garrett = new Person("Garrett Stilinovich");
		people.add(Garrett);
		
		Person Gina = new Person("Gina LeRow");
		people.add(Gina);
		
		Person Grant = new Person("Grant Fedre");
		people.add(Grant);
		
		Person Greg = new Person("Greg Wong");
		people.add(Greg);
		
		Person Isaiah = new Person("Isaiah Rabon");
		people.add(Isaiah);
		
		Person IsaacL = new Person("Isaac Lee");
		people.add(IsaacL);
		
		Person Isaac = new Person("Isaac Parhami");
		people.add(Isaac);
		
		Person Jaelyn = new Person("Jaelyn Miller");
		people.add(Jaelyn);
		
		Person Jayden = new Person("Jayden Marquez");
		people.add(Jayden);
		
		Person Jess = new Person("Jess Reid");
		people.add(Jess);
		
		Person Jordan = new Person("Jordan Jameson");
		people.add(Jordan);
		
		Person Juan = new Person("Juan Carrion");
		people.add(Juan);
		
		Person Kai = new Person("Kai Matsumoto");
		people.add(Kai);
		
		Person Kaiden = new Person("Kaiden St. Dennis");
		people.add(Kaiden);
		
		Person Liam = new Person("Liam Fallon");
		people.add(Liam);
		
		Person Lon = new Person("Lon Monk");
		people.add(Lon);
		
		Person Nathan = new Person("Nathan Tang");
		people.add(Nathan);
		
		Person Mark = new Person("Mark Maciel");
		people.add(Mark);
		
		Person Matthew = new Person("Matthew Lee");
		people.add(Matthew);
		
		Person MichaelL = new Person("Michael Lee");
		people.add(MichaelL);
		
		Person MatthewT = new Person("Matthew Tilley");
		people.add(MatthewT);
		
		Person Max = new Person("Maxwell Murase");
		people.add(Max);
		
		Person Mekhi = new Person("Mekhi Yanthis");
		people.add(Mekhi);
		
		Person Michael = new Person("Michael Yoon");
		people.add(Michael);
		
		Person Samuel = new Person("Samuel Li");
		people.add(Samuel);
		
		Person Sean = new Person("Sean Kelman");
		people.add(Sean);
		
		Person Zach = new Person("Zach Zonni");
		people.add(Zach);
		
		addNames();
		
		list = new JList<String>(names.toArray(new String[names.size()]));
		
		scrollPane = new JScrollPane(list);
	    list.setLayoutOrientation(JList.VERTICAL);
	    list.setFont(new Font("arial", 0, 30));
	    scrollPane.setLocation(350,20);
	    scrollPane.setSize(400,400);
	    
	    panel.add(signIn);
	    panel.add(signOut);
	    panel.add(signOutAll);
		panel.add(scrollPane);
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    add(panel);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    
	    csv = new CSV(names);
	    
	    long timer = System.currentTimeMillis();
	    
	    while(true) {
	    	timer++;
	    	if(timer - System.currentTimeMillis() >= 100000000) {
	    		signOutAll();
	    		timer = System.currentTimeMillis();
	    		
	    	}
	    }
	    
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==signIn && list.getSelectedValue() != null) {
			people.get(names.indexOf(list.getSelectedValue())).signIn();
		}
		if(e.getSource()==signOut && list.getSelectedValue() != null) {
			people.get(names.indexOf(list.getSelectedValue())).signOut();
			people.get(names.indexOf(list.getSelectedValue())).changeSignOut();
			if(csv==null) {
				System.out.println("csv is null");
			}
			csv = new CSV(names);
			csv.write(people);

		}
		
		if(e.getSource()==read) {
			record = new JFrame();
			rec = new JPanel(null);
			
			record.setSize(1080,720);
			record.setLocationRelativeTo(null);
			this.setFocusable(false);
			
			fileList = new JList<String>(csv.listFiles().toArray(new String[csv.listFiles().size()]));
			
			scrollFiles = new JScrollPane(fileList);
		    fileList.setLayoutOrientation(JList.VERTICAL);
		    fileList.setFont(new Font("arial", 0, 30));
		    scrollFiles.setLocation(350,20);
		    scrollFiles.setSize(400,400);
		    readFiles = new JButton("Read File");
		    readFiles.setFont(new Font("arial", 1, 40));
			readFiles.setSize(300,150);
			readFiles.setLocation(20,150);
			readFiles.setFocusable(false);
			readFiles.addActionListener(this);
			rec.add(readFiles);
			
			back = new JButton("Go Back");
		    back.setFont(new Font("arial", 1, 40));
			back.setSize(300,150);
			back.setLocation(600,450);
			back.setFocusable(false);
			back.addActionListener(this);
			rec.add(back);
			
			readAll = new JButton("Read All");
			readAll.setFont(new Font("arial", 1, 40));
			readAll.setSize(300,150);
			readAll.setLocation(200,450);
			readAll.setFocusable(false);
			readAll.addActionListener(this);
			rec.add(readAll);
		    
		    rec.add(scrollFiles);
		    
		    record.add(rec);
			record.setVisible(true);
			SwingUtilities.updateComponentTreeUI(this);
		}
		
		if(e.getSource()==readFiles && fileList.getSelectedValue()!=null) {
			readFrame = new JFrame();
			readPanel = new JPanel(null);
			
			readFrame.setSize(1080,720);
			readFrame.setLocationRelativeTo(null);
			this.setFocusable(false);
			
			String filename = System.getProperty("user.dir") + "\\" + fileList.getSelectedValue();
			
			ArrayList<String> data = csv.readFile(filename);
			
			readData = new JList<String>(data.toArray(new String[data.size()]));
			
			displayData = new JScrollPane(readData);
		    readData.setLayoutOrientation(JList.VERTICAL);
		    readData.setFont(new Font("arial", 0, 30));
		    displayData.setLocation(40,20);
		    displayData.setSize(1000,450);
		    readPanel.add(displayData);
		    
		    readFileExit = new JButton("Back");
		    readFileExit.setFont(new Font("arial", 1, 40));
		    readFileExit.setSize(300,150);
		    readFileExit.setLocation(390,500);
		    readFileExit.setFocusable(false);
		    readFileExit.addActionListener(this);
			readPanel.add(readFileExit);
			
			readFrame.add(readPanel);
			readFrame.setVisible(true);
		}
		
		if(e.getSource()==readAllFiles) {
			readFrame = new JFrame();
			readPanel = new JPanel(null);
			
			readFrame.setSize(1080,720);
			readFrame.setLocationRelativeTo(null);
			this.setFocusable(false);
			
			ArrayList<String> data = csv.readAll();
			
			readData = new JList<String>(data.toArray(new String[data.size()]));
			
			displayData = new JScrollPane(readData);
		    readData.setLayoutOrientation(JList.VERTICAL);
		    readData.setFont(new Font("arial", 0, 30));
		    displayData.setLocation(40,20);
		    displayData.setSize(1000,450);
		    readPanel.add(displayData);
		    
		    readFileExit = new JButton("Back");
		    readFileExit.setFont(new Font("arial", 1, 40));
		    readFileExit.setSize(300,150);
		    readFileExit.setLocation(390,500);
		    readFileExit.setFocusable(false);
		    readFileExit.addActionListener(this);
			readPanel.add(readFileExit);
			
			readFrame.add(readPanel);
			readFrame.setVisible(true);
		}
		
		if(e.getSource()==back) {
			record.dispose();
		}
		
		if(e.getSource()==readFileExit) {
			readFrame.dispose();
		}
		if(e.getSource()==readAll) {
			dateFrame = new JFrame();
			datePanel = new JPanel(null);
			
			dateFrame.setSize(1080,720);
			dateFrame.setLocationRelativeTo(null);
			this.setFocusable(false);
			
			readAllFiles = new JButton("Read All Files");
			readAllFiles.setFont(new Font("arial", 1, 40));
			readAllFiles.setSize(300,150);
			readAllFiles.setLocation(40,450);
			readAllFiles.setFocusable(false);
			readAllFiles.addActionListener(this);
			datePanel.add(readAllFiles);
			
			readBetweenDates = new JButton("Read");
			readBetweenDates.setFont(new Font("arial", 1, 40));
			readBetweenDates.setSize(300,150);
			readBetweenDates.setLocation(370,450);
			readBetweenDates.setFocusable(false);
			readBetweenDates.addActionListener(this);
			datePanel.add(readBetweenDates);
			
			readBack = new JButton("Back");
			readBack.setFont(new Font("arial", 1, 40));
			readBack.setSize(300,150);
			readBack.setLocation(700,450);
			readBack.setFocusable(false);
			readBack.addActionListener(this);
			datePanel.add(readBack);
			
			JLabel start = new JLabel("Start");
			start.setFont(new Font("arial", 1, 40));
			start.setSize(100,50);
			start.setLocation(240,50);
			start.setFocusable(false);
			datePanel.add(start);
			
			JLabel startDayText = new JLabel("Day:");
			startDayText.setFont(new Font("arial", 1, 30));
			startDayText.setSize(100,50);
			startDayText.setLocation(200,150);
			startDayText.setFocusable(false);
			datePanel.add(startDayText);
			
			startDay = new JTextField(16);
			startDay.setSize(100,50);
			startDay.setLocation(280,150);
			startDay.setFont(new Font("arial", 1, 30));
			datePanel.add(startDay);
			
			JLabel startMonthText = new JLabel("Month: ");
			startMonthText.setFont(new Font("arial", 1, 30));
			startMonthText.setSize(150,50);
			startMonthText.setLocation(160,250);
			startMonthText.setFocusable(false);
			datePanel.add(startMonthText);
			
			startMonth = new JTextField(16);
			startMonth.setSize(100,50);
			startMonth.setLocation(280,250);
			startMonth.setFont(new Font("arial", 1, 30));
			datePanel.add(startMonth);
			
			JLabel startYearText = new JLabel("Year: ");
			startYearText.setFont(new Font("arial", 1, 30));
			startYearText.setSize(150,50);
			startYearText.setLocation(190,350);
			startYearText.setFocusable(false);
			datePanel.add(startYearText);
			
			startYear = new JTextField(16);
			startYear.setSize(100,50);
			startYear.setLocation(280,350);
			startYear.setFont(new Font("arial", 1, 30));
			datePanel.add(startYear);
			
			JLabel end = new JLabel("End");
			end.setFont(new Font("arial", 1, 40));
			end.setSize(100,50);
			end.setLocation(650,50);
			end.setFocusable(false);
			datePanel.add(end);
			
			JLabel endDayText = new JLabel("Day:");
			endDayText.setFont(new Font("arial", 1, 30));
			endDayText.setSize(100,50);
			endDayText.setLocation(600,150);
			endDayText.setFocusable(false);
			datePanel.add(endDayText);
			
			endDay = new JTextField(16);
			endDay.setSize(100,50);
			endDay.setLocation(680,150);
			endDay.setFont(new Font("arial", 1, 30));
			datePanel.add(endDay);
			
			JLabel endMonthText = new JLabel("Month: ");
			endMonthText.setFont(new Font("arial", 1, 30));
			endMonthText.setSize(150,50);
			endMonthText.setLocation(560,250);
			endMonthText.setFocusable(false);
			datePanel.add(endMonthText);
			
			endMonth = new JTextField(16);
			endMonth.setSize(100,50);
			endMonth.setLocation(680,250);
			endMonth.setFont(new Font("arial", 1, 30));
			datePanel.add(endMonth);
			
			JLabel endYearText = new JLabel("Year: ");
			endYearText.setFont(new Font("arial", 1, 30));
			endYearText.setSize(150,50);
			endYearText.setLocation(590,350);
			endYearText.setFocusable(false);
			datePanel.add(endYearText);
			
			endYear = new JTextField(16);
			endYear.setSize(100,50);
			endYear.setLocation(680,350);
			endYear.setFont(new Font("arial", 1, 30));
			datePanel.add(endYear);
			
			dateFrame.add(datePanel);
			dateFrame.setVisible(true);
		}
		if(e.getSource()==readBetweenDates) {
			readFrame = new JFrame();
			readPanel = new JPanel(null);
			
			startDates = new int[3];
			endDates = new int[3];
			
			startDates[0] = Integer.parseInt(startMonth.getText());
			startDates[1] = Integer.parseInt(startDay.getText());
			startDates[2] = Integer.parseInt(startYear.getText());
			
			endDates[0] = Integer.parseInt(endMonth.getText());
			endDates[1] = Integer.parseInt(endDay.getText());
			endDates[2] = Integer.parseInt(endYear.getText());
			
			dateFrame.dispose();
			
			readFrame.setSize(1080,720);
			readFrame.setLocationRelativeTo(null);
			this.setFocusable(false);
			
			ArrayList<String> data = csv.readAll(startDates, endDates);
			
			readData = new JList<String>(data.toArray(new String[data.size()]));
			
			displayData = new JScrollPane(readData);
		    readData.setLayoutOrientation(JList.VERTICAL);
		    readData.setFont(new Font("arial", 0, 30));
		    displayData.setLocation(40,20);
		    displayData.setSize(1000,450);
		    readPanel.add(displayData);
		    
		    readFileExit = new JButton("Back");
		    readFileExit.setFont(new Font("arial", 1, 40));
		    readFileExit.setSize(300,150);
		    readFileExit.setLocation(390,500);
		    readFileExit.setFocusable(false);
		    readFileExit.addActionListener(this);
			readPanel.add(readFileExit);
			
			readFrame.add(readPanel);
			readFrame.setVisible(true);
		}
		if(e.getSource()==readBack) {
			dateFrame.dispose();
		}
		if(e.getSource() == signOutAll) {
			signOutAllFrame = new JFrame();
			signOutAllPanel = new JPanel(null);
			
			signOutAllFrame.setSize(600,300);
			signOutAllFrame.setLocationRelativeTo(null);
			this.setFocusable(false);
			
			signOutAllBack = new JButton("Cancel");
			signOutAllBack.setFont(new Font("arial", 1, 40));
			signOutAllBack.setSize(225,100);
			signOutAllBack.setLocation(50,125);
			signOutAllBack.setFocusable(false);
			signOutAllBack.addActionListener(this);
			signOutAllPanel.add(signOutAllBack);
			
			signOutAllOK = new JButton("Confirm");
			signOutAllOK.setFont(new Font("arial", 1, 40));
			signOutAllOK.setSize(225,100);
			signOutAllOK.setLocation(325,125);
			signOutAllOK.setFocusable(false);
			signOutAllOK.addActionListener(this);
			signOutAllPanel.add(signOutAllOK);
			
			mes = new JLabel("Are you sure?");
			mes.setFont(new Font("arial", 0, 30));
			mes.setSize(600,100);
			mes.setLocation(200,0);
			mes.setFocusable(false);
			signOutAllPanel.add(mes);
			
			signOutAllFrame.add(signOutAllPanel);
			
			signOutAllFrame.setVisible(true);
			SwingUtilities.updateComponentTreeUI(this);
		}
		if(e.getSource()==signOutAllOK) {
			signOutAll();
			signOutAllFrame.dispose();
		}
		if(e.getSource()==signOutAllBack) {
			signOutAllFrame.dispose();
		}
	}
	
	public void signOutAll() {
		for(int i = 0; i < people.size(); i++) {
			if(people.get(i).hasSignedOut() == false) {
				people.get(i).signOut();
			}
		}
		csv.write(people);
	}
	public void addNames() {
		for(int i = 0; i < people.size(); i++) {
			names.add(people.get(i).getName());
		}
	}
	
}
