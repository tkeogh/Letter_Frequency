import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math;

public class Matcher {
	ArrayList<Alphabet> languages = new ArrayList<Alphabet>();

	public Matcher() {
		languages = loadLanguages();
	}

	/**
	 * 
	 * For expansion in future, if carried on.
	 */
	private ArrayList<Alphabet> loadLanguages() {

		BufferedReader br = null;
		ArrayList<Alphabet> alphas = new ArrayList<Alphabet>();

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("languages"));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println("Languages : " + sCurrentLine);
				int loops = Integer.parseInt(sCurrentLine);

				for (int k = 0; k < loops; k++) {
					Alphabet newAlpha = new Alphabet();
					
					
					newAlpha.setName(br.readLine());
					System.out.println("Language : "+newAlpha.getName());
					
					int charactersContained = Integer.parseInt(br.readLine());
					System.out.println("Char contained: " + charactersContained);

					
					ArrayList<letter> lets = new ArrayList<letter>();

					for (int i = 0; i < charactersContained; i++) {

						String line = br.readLine();
						String[] info = line.split(",");
						letter curr = new letter(info[0],
								Double.parseDouble(info[1]));
						lets.add(curr);

					}

					newAlpha.setLets(lets);
					alphas.add(newAlpha);

				}
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
		return alphas;
	}
	
	public void compareAlphabets(Alphabet fromFile){
		
		ArrayList<letter> curr = fromFile.getLets();
		double totalPercentDiff = 0;
		
		for(int i=0;i<languages.size();i++){
			Alphabet temp = languages.get(i);
	
			for(int j=0;j<curr.size();j++){
				
				letter now = curr.get(j);
				
				ArrayList<letter> matchThis = temp.getLets();
				
				for(int k=0;k<matchThis.size();k++){
					
					if(now.getLet().equalsIgnoreCase(matchThis.get(k).getLet())){
						double percentDiff = Math.abs(now.getPercent() - matchThis.get(k).getPercent());
						
						//System.out.println("Percent diff for "+now.getLet() +" : "+percentDiff);
						totalPercentDiff += percentDiff;
					}
					
				}
				
			}
			
			double averageDiff = totalPercentDiff/fromFile.getLets().size();
			System.out.println("Average Diff in letter frequency : "+averageDiff);
			
		}
		
		
	}

}
