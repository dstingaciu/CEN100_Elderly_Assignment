import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.text.SimpleDateFormat;

public class Main {
	static JFrame frame,setup,chat;
	static JLabel label;
	static Main link = new Main();
	static int maxx=1920,maxy=1080;
	static JTextField name,ID;
	static String nameString, IDString;
	static boolean onState=false,exit = false;
	static String userName = "Dan";
	static Font dankM = new Font("Roboto",Font.PLAIN,100);
	static Font dankB = new Font("Roboto", Font.PLAIN,150);
    static SimpleDateFormat date = new SimpleDateFormat ("E yyyy.MM.dd");
    static SimpleDateFormat hour = new SimpleDateFormat ("");
    static Date day = new Date();
	DB database = new DB();

    


	public static void main(String[] args)throws IOException {


		link.displayFSetup();

		while(!onState&&!exit){
			day = new Date();
			
		}
		


	}
	
	public void chatUI(){
		chat = new JFrame ("Chat UI");
		chat.setDefaultLookAndFeelDecorated(true);
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(new Color(169, 50, 38));
		GridBagConstraints gbc = new GridBagConstraints();
		JButton p1 = new JButton ();
		JButton p2 = new JButton ();
		JButton p3 = new JButton ();
		JLabel p1L = new JLabel("John");
		JLabel p2L = new JLabel ("Bob");
		JLabel p3L = new JLabel ("Mary");
		p1.setBackground(new Color(169, 50, 38));
		p2.setBackground(new Color(169, 50, 38));
		p3.setBackground(new Color(169, 50, 38));
		
		p1L.setForeground(new Color(52,152,219));
		p1L.setFont(dankM);
		p2L.setForeground(new Color(52,152,219));
		p2L.setFont(dankM);
		p3L.setForeground(new Color(52,152,219));
		p3L.setFont(dankM);

		try {
			Image img = ImageIO.read(getClass().getResource("Elder1.jpg"));
			Image img2 = ImageIO.read(getClass().getResource("Elder2.jpg"));
			Image img3 = ImageIO.read(getClass().getResource("Elder3.jpg"));
			p1.setIcon(new ImageIcon(img));
			p2.setIcon(new ImageIcon(img2));
			p3.setIcon(new ImageIcon(img3));
		}catch (IOException e) {
			System.out.println("ERROR");
				  
		}
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		panel.add(p1,gbc);
		gbc.weighty = 0.5;
		gbc.weightx = 0;
		gbc.gridx = 1;
		panel.add(p2,gbc);
		gbc.gridx = 2;
		panel.add(p3,gbc);
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0,40,0,0);
		panel.add(p1L,gbc);
		gbc.weightx = 0;
		gbc.gridx = 1;
		panel.add(p2L, gbc);
		gbc.gridx = 2;
		panel.add(p3L, gbc);
		chat.add(panel);
		chat.setVisible(true);
		chat.setSize(maxx,maxy);

		  
	}
	
	public void mainUI(){
		frame = new JFrame("Main UI");
		frame.setDefaultLookAndFeelDecorated(true);
		JPanel panel = new JPanel(new GridBagLayout()){
		private static final long serialVersionUID = 1L;			
		};
		panel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel welcomeMessage = new JLabel("Hello "+userName);
		JLabel displayDay = new JLabel(date.format(day));
		JLabel displayTime = new JLabel(hour.format(day));
		JButton chat = new JButton ("Chat");
		JButton news = new JButton ("News");
		JButton games = new JButton ("Games");
		
		welcomeMessage.setForeground(Color.orange);
		chat.setBackground(Color.RED);
		chat.setForeground(Color.WHITE);
	    chat.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e){
	            	chatUI();
	            }
	        });
		news.setBackground(new Color(43,183,7));
		news.setForeground(Color.WHITE);
		games.setBackground(Color.BLUE);
		games.setForeground(Color.WHITE);
		displayDay.setBackground(Color.GRAY);
		displayDay.setForeground(Color.orange);
		displayTime.setBackground(Color.GRAY);
		displayTime.setForeground(Color.orange);
		
		panel.setPreferredSize(new Dimension(maxx,maxy));
		
		welcomeMessage.setFont(dankM);
		chat.setFont(dankB);
		news.setFont(dankB);
		games.setFont(dankB);
		displayDay.setFont(dankM);
		displayTime.setFont(dankM);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.weighty =0.5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		panel.add(news,gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.anchor = GridBagConstraints.NORTHEAST;
		panel.add(games, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.5;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(welcomeMessage,gbc);
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(chat,gbc);
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		panel.add(displayTime,gbc);
		gbc.anchor = GridBagConstraints.ABOVE_BASELINE;
		panel.add(displayDay, gbc);
		
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(maxx,maxy);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	
	public void displayFSetup(){
		setup = new JFrame("Login");
		setup.setDefaultLookAndFeelDecorated(true);

		
		JPanel blah = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints butt = new GridBagConstraints();
		
		
		JLabel title=new JLabel("Enter Patient Information Below: ",SwingConstants.CENTER);
		title.setFont(new Font("Roboto",Font.PLAIN,30));
	
		
		JLabel nameText = new JLabel("Name: ");
		JLabel IDText = new JLabel("ID: ");
		name = new JTextField("",30);
		ID = new JTextField("",40);
		JButton next = new JButton("Next");
		next.setFont(new Font("Roboto",Font.PLAIN,25));
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		
		next.addActionListener(new NextEvent());

		
		blah.add(title,c);
		c.gridy++;
		blah.add(nameText,c);
		c.gridy++;
		blah.add(name,c);
		c.gridx=0;
		c.gridy++;
		blah.add(IDText,c);
		c.gridy++;
		blah.add(ID,c);
		
		butt.anchor = GridBagConstraints.EAST;
		butt.gridx=0;
		butt.gridy=5;
		butt.insets=new Insets(2,2,2,2);
		blah.add(next,butt);
		
		setup.add(blah);
		setup.setVisible(true);
		setup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setup.setSize(900,450);

	}
	
	public void AssignNew(String name){
		System.out.println("ADDING!");
		userName = name;
			try {
				database.addPatient(name);
			} catch (IOException e) {
				System.out.println("ERROR COMMUNICATING WITH DATABASE CLASS!");
			}
	}
	public void getName(String idS){
		try {
			userName = database.searchList(idS);
			if(userName.equalsIgnoreCase("nothing")){
				System.out.println("Not found");
				AssignNew(name.getText());
			}
		} catch (IOException e) {
			System.out.println("Top kek");
		}

	}
	
	class NextEvent implements ActionListener{
		public void actionPerformed(ActionEvent event){
			nameString = name.getText();
			IDString = ID.getText();
			if(IDString.equals("")){
				AssignNew(nameString);
			}else{
				getName(IDString);
			}
			onState=true;
			setup.setVisible(false);
			setup.dispose();
			frame.setDefaultLookAndFeelDecorated(true);
			mainUI();
		}
	}
	class chatEvent implements ActionListener{
		public void actionPerformed(ActionEvent event){
			chatUI();
			
		}
	}

}

