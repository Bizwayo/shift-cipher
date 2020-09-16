public class Vigenere {
	private String[] ciphertext;
	private int numChars;

	Vigenere(String[] ct, int l){
		ciphertext = ct;
		numChars = l;
	}

	public String[][] streams(){
		String[][] Ts = new String[numChars][numChars];
		int streamNum = 0;
		int increment = 1;
		
		for(streamNum=0;streamNum<numChars;streamNum++){
			Ts[streamNum][0] = ciphertext[0];
			int growth = 1;
			for(int i=increment;i<numChars;i += increment){
				Ts[streamNum][growth++] = ciphertext[i];
			}
			increment++;
		}
		/*
		while(streamNum <= numChars-1){
			i++;
			Ts[streamNum][0] = ciphertext[streamNum];
			while(i<numChars){
				Ts[streamNum][i] = ciphertext[i];
				i = i+growth;
			}
			streamNum++;
			growth++;
			i = increment;
			increment++;	
		}
		*/
		return Ts;
	}
}
