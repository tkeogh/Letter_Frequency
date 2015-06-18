import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.lang.Math;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class main {

	static int wordcount;
	static int letterCount;
	static Alphabet alpha = new Alphabet();
	

	public static void main(String[] args) {

		File file;

		file = fileChoice();

		if (file != null) {
			analyseFile(file);
		}

		System.out.println("Letter Count : " + letterCount);
		System.out.println("Word Count : " + wordcount);
		
		System.out.println("----Starting Match-----");
		
		Matcher match = new Matcher();
		
		match.compareAlphabets(alpha);
		
		
		

	}



	private static File fileChoice() {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Text files", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(chooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: "
					+ chooser.getSelectedFile().getName());
			return chooser.getSelectedFile();
		}
		if (returnVal == JFileChooser.CANCEL_OPTION) {
			System.out.println("Cancel called");

		}
		return null;
	}

	private static void analyseFile(File file) {
		alpha.loadEnglish();

		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(file));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				String wordsInLine[] = sCurrentLine.split(" ");
				wordcount += wordsInLine.length;
				analyseLine(sCurrentLine);
			}
			
			ArrayList<letter> ending = alpha.getLets();
			
			DecimalFormat df = new DecimalFormat("#.##");

			for (int i = 0; i < ending.size(); i++) {
				double currPercent = 0;
				letter curr = ending.get(i);
				if (curr.getCount() != 0){
					double count = curr.getCount();
					currPercent = 100*(count/letterCount);
					curr.setPercent(currPercent);
					
				}
				System.out.println("Letter : " + curr.getLet() + " Count : "
						+ curr.getCount()+ " percent : "+curr.getPercent()+"%");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	private static void analyseLine(String line) {

		for (int i = 0; i < line.length(); i++) {
			String curr = Character.toString(line.charAt(i));
			if (!curr.equals(" "))
			{
				alpha.incrementLetter(curr);
				letterCount++;
			}
		}

	}
	
	
}
