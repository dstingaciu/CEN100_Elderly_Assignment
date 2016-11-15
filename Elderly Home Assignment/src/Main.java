import java.io.IOException;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class Main {
	static JFrame frame,setup;
	static JLabel label;
	static JPanel menuP = new JPanel();
	static Main link = new Main();
	static int maxx=1920,maxy=1080;
	static JTextField name,ID;
	static String nameString, IDString;
	static boolean onState=true;
	DB database = new DB();

	public static void main(String[] args)throws IOException {

		link.displayFSetup();
		while(!onState){
			System.out.println();
		}
		


	}
	
	public void displayFSetup(){
		setup = new JFrame("First Time Setup!");
		setup.setDefaultLookAndFeelDecorated(true);

		
		JPanel blah = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		JLabel title=new JLabel("Enter Patient Information Below: ",SwingConstants.CENTER);
		title.setFont(new Font("Roboto",Font.PLAIN,50));
	
		
		JLabel nameText = new JLabel("Name: ");
		JLabel IDText = new JLabel("ID: ");
		JTextField name = new JTextField(30);
		JTextField ID = new JTextField(30);
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		
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
		
		setup.add(blah);
		setup.setVisible(true);
		setup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setup.setSize(maxx,maxy);

	}
	
	class NameEvent implements ActionListener{
		public void actionPerformed(ActionEvent event){
			nameString = name.getText();
		}
	}
	class IDEvent implements ActionListener{
		public void actionPerformed(ActionEvent event){
			IDString = ID.getText();
		}
	}

}
