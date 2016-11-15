import java.io.IOException;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Main {
	static JFrame frame;
	static JLabel label;
	static JPanel menuP = new JPanel();
	static Main link = new Main(); 
	

	public static void main(String[] args)throws IOException {
		DB database = new DB();
		database.addPatient("John");
		database.PatientFile();
		Set Patients=database.returnPatients(); 
		Iterator i = Patients.iterator();
		

	}
	
	public void displayFSetup(){
		
	}

}
