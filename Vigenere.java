import java.util.*;

public class Vigenere {
	private ArrayList<String> tester;
	//private String[] ciphertext;
	//private int numChars;

	Vigenere(String[] ct){
		tester = new ArrayList<String>();
		//ciphertext = ct;
		//numChars = l;

		for(int i=0;i<ct.length;i++){
			tester.add(ct[i]);
		}
		System.out.print("\nArrayList: ");
		for(int j=0;j<tester.size();j++){
			System.out.print( tester.get(j) );
		}
		System.out.println();
	}

	//ARRAYLIST
	public ArrayList< ArrayList<String> > streams(){
		ArrayList< ArrayList<String> > Ts = new ArrayList< ArrayList<String> >();
		int streamNum = 0;
		int increment = 1;

		for(streamNum=0;streamNum<tester.size();streamNum++){
			ArrayList<String> holder = new ArrayList<String>();
			holder.add(tester.get(0));
			for(int i=increment;i<tester.size(); i += increment){
				holder.add(tester.get(i));
			}
			Ts.add(holder);
			increment++;
		}
		return Ts;
	}

	public int count(String q,ArrayList<String> qList){
		int result = 0;
		for(int i=0;i<qList.size();i++){
			if( q.equals( qList.get(i) ) ){
				result++;
			}
		}
		return result;
	}

	public ArrayList< ArrayList<Float> > streamFrequencies(ArrayList< ArrayList<String> > Ts){
		ArrayList< ArrayList<Float> > qFrequencies = new ArrayList< ArrayList<Float> > ();

		for(int row=0;row<Ts.size();row++){
			ArrayList<String> holder = Ts.get(row);
			ArrayList<Float> res = new ArrayList<Float>();

			for(int col=0;col<holder.size();col++){
				String q = holder.get(col);
				int result = this.count(q,holder);
				int qLength = holder.size();
				float frequency = (float)result/qLength;
				//System.out.println( "String: " + q + " Count: " + result +" Array Length: " + qLength + " frequency: "+frequency);
				res.add(frequency);
			}
			qFrequencies.add(res);
		}
		return qFrequencies;
	}

	public ArrayList<Float> stScores(ArrayList< ArrayList<Float> > qFrequencies){
		ArrayList<Float> qScores = new ArrayList<Float>();
		ArrayList<Float> finalSt = new ArrayList<Float>();

		for(int row=0;row<qFrequencies.size();row++){
			ArrayList<Float> holder = qFrequencies.get(row);

			for(int col=0;col<holder.size();col++){
				float qSquared = holder.get(col);
				float qS = qSquared*qSquared;
				qScores.add(qS);
			}
			holder.clear();

			float finalS = 0;
			System.out.print("\nq Scores for T"+(row+1)+": {");
			for(int i=0;i<qScores.size();i++){
				finalS += qScores.get(i);
				System.out.print(qScores.get(i) +",");
			}
			System.out.print("}");
			qScores.clear();
			finalSt.add(finalS);
		}
		return finalSt;
	}



	/*
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
		return Ts;
	}

	public int count(String q,String[] qList){
		int result = 0;
		for(int i=0;i<qList.length;i++){
			if( (qList[i] != null) && q!=null ){
				if( q.equals(qList[i]) ){
					result++;
				}
			}
		}
		return result;
	}

	public int arrayLength(String[] qList){
		int result = 0;
		for(int i=0;i<qList.length;i++){
			if(qList[i] != null){
				result++;
			}
		}
		return result;
	}

	public float[][] streamFrequencies(String[][] Ts){
		float[][] qFrequencies = new float[numChars][numChars];

		for(int row=0;row<Ts.length;row++){
			for(int col=0;col<Ts[0].length;col++){
				String q = Ts[row][col];
				int result = this.count(q,Ts[row]);
				int qLength = this.arrayLength(Ts[row]);
				float frequency = (float)result/qLength;
				//System.out.println( "String: " + q + " Count: " + result +" Array Length: " + qLength + " frequency: "+frequency);
				qFrequencies[row][col] = frequency;
			}
		}
		return qFrequencies;
	}


	public float[] stScores(float[][] qFrequencies){
		float[] qScores = new float[numChars];
		float[] finalSt = new float[numChars];

		for(int row=0;row<qFrequencies.length;row++){
			for(int col=0;col<qFrequencies[0].length;col++){
				float qSquared = qFrequencies[row][col];
				qSquared = qSquared*qSquared;
				qScores[col] = qSquared;
			}

			float finalS = 0;
			for(int i=0;i<qScores.length;i++){
				finalS += qScores[i];
			}
			finalSt[row] = finalS;
		}
		return finalSt;
	}

	*/

}
