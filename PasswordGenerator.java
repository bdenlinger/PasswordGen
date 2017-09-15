import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
	private static String filename = "/home/brian/eclipse/eclipse-workspace/PasswordGen/src/WordList.txt";
	private static List<String> records = new ArrayList<String>();
	//private static String filename = "WordList.txt";
	
	public static void main(String[] args) {

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
		Scanner keyboard = new Scanner(System.in);
		String result = "";
		
		System.out.println("Enter the number of words");
		int numWords = keyboard.nextInt();
		while(numWords < 1) {
			System.out.println("Must be greater than 0");
			numWords = keyboard.nextInt();
		}
		
		System.out.println("Max number");
		int maxNum = keyboard.nextInt();
		while(maxNum < 2) {
			System.out.println("Must be greater than 1");
			maxNum = keyboard.nextInt();
		}
		keyboard.close();
		for(int i = 0; i < numWords; i++) {
			result += makePart(maxNum);
		}
		System.out.println(result);
	}
	
	private static String makePart(int maxNum) {
		Random rand = new Random();
		String s = records.get(rand.nextInt(records.size()));
		int n = rand.nextInt(maxNum);
		Integer.toString(n);
		String numString = String.format("%0" + Integer.toString(maxNum).length() + "d", n);
		
		return s + numString;
	}
}
