import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
	private static String filename = "/home/brian/eclipse/eclipse-workspace/PasswordGen/src/WordList.txt";
	//private static String filename = "WordList.txt";
	
	public static void main(String[] args) {
		List<String> records = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				records.add(line);
			}
			reader.close();
			}
		catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
			return;
		}
		Random rand = new Random();
		int firstString = rand.nextInt(records.size());
		int secondString = rand.nextInt(records.size());
		int firstNumber = rand.nextInt(99);
		int secondNumber = rand.nextInt(99);
		
		String output = records.get(firstString) + Integer.toString(firstNumber) + 
				records.get(secondString) + Integer.toString(secondNumber);
		
		System.out.println(output);
	}
}
