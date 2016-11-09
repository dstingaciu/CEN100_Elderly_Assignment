import java.io.IOException;

public class Main {

	public static void main(String[] args)throws IOException {
		DB database = new DB();
		database.addPatient("John");
		database.PatientFile();

	}

}
