import java.util.ArrayList;


public class Alphabet {
	
	ArrayList<letter> lets = new ArrayList<letter>();
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Alphabet(){	
		
	}
	
	public void incrementLetter(String a){
		for(int i =0;i<lets.size();i++){
			if(a.equalsIgnoreCase(lets.get(i).getLet())){
				lets.get(i).incrementCount();
			};
		}
	}

	public ArrayList<letter> getLets() {
		return lets;
	}

	public void setLets(ArrayList<letter> lets) {
		this.lets = lets;
	}
	
	public void loadEnglish(){
		this.lets.add(new letter("a",0));
		lets.add(new letter("b",0));
		lets.add(new letter("c",0));
		lets.add(new letter("d",0));
		lets.add(new letter("e",0));
		lets.add(new letter("f",0));
		lets.add(new letter("g",0));
		lets.add(new letter("h",0));
		lets.add(new letter("i",0));
		lets.add(new letter("j",0));
		lets.add(new letter("k",0));
		lets.add(new letter("l",0));
		lets.add(new letter("m",0));
		lets.add(new letter("n",0));
		lets.add(new letter("o",0));
		lets.add(new letter("p",0));
		lets.add(new letter("q",0));
		lets.add(new letter("r",0));
		lets.add(new letter("s",0));
		lets.add(new letter("t",0));
		lets.add(new letter("u",0));
		lets.add(new letter("v",0));
		lets.add(new letter("w",0));
		lets.add(new letter("x",0));
		lets.add(new letter("y",0));
		lets.add(new letter("z",0));
	}
	
	

}
