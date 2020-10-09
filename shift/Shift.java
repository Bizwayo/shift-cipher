/*
NAME: BIZWAYO KASARO
STUDENT NUMBER: 7801809
ASSIGNMET: 1
DESCRIPTION: Implement improved attack on shift cipher
*/

import java.util.*;


public class Shift{
	private ArrayList<String> tester;
	private double[] p_i_List = {0.082,0.015,0.028,0.043,0.127,0.022,0.02,0.061,0.07,0.002,0.008,0.04,0.024,0.067,0.015,0.019,0.001,0.006,0.0063,.091,0.028,0.01,0.024,0.002,0.02,0.001};
	//private ArrayList<String> letters;
	private double[] list={8.2,1.5,2.8,4.3,12.7,2.2,2,6.1,7,0.2,0.8,4,2.4,6.7,1.5,1.9,0.1,6,6.3,9.1,2.8,1,2.4,0.2,2,0.1};

	Shift(String[] ct){
		tester = new ArrayList<String>();

		for(int i=0;i<ct.length;i++){
			tester.add(ct[i]);
		}
		//p_i_List={0.82,0.15,0.28,0.43,1.27,0.22,0.2,0.61,0.7,0.02,0.08,0.4,0.24,0.67,0.15,0.19,0.01,0.6,0.63,.91,0.28,0.1,0.24,0.02,0.2,0.01};
		//letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

	}

	public double totalN(){
		double result = 0;
		for(int i=0;i<list.length;i++){
			result += list[i];
		}
		return result;
	}

	public ArrayList<Float> probability(double N){
		ArrayList<Float> probs = new ArrayList<Float>();
		for(int i=0;i<list.length;i++){
			probs.add((float)list[i]/(float)N);
			System.out.println( "i = "+ i + " Probability = " + (float)list[i]/(float)N );
		}
		float pi = 0;
		for(int j=0;j<probs.size();j++){
			 pi += probs.get(j)*probs.get(j);
		}
		System.out.println();
		System.out.println("sum of pi = " + pi);
		return probs;
	}

	//qi - is simply the number of occurrences of the ith letter 
	// of the alphabet in the ciphertext divided by the length of the ciphertext. 
	public ArrayList<Float> getFrequencies(){
		ArrayList<Float> frequencies = new ArrayList<Float>();

		for(int i=0;i<tester.size();i++){
			String holder = tester.get(i);
			float occurrences = 0;
			for(int j=0;j<tester.size();j++){
				if(tester.get(j).equals(holder)){
					occurrences++;
				}
			}
			float freq = occurrences/tester.size();
			frequencies.add(freq);
			System.out.println( "String: " + holder + " Count: " + occurrences + " frequency: "+freq);
			}

		float result = 0;
		for(int i=0;i<frequencies.size();i++){
			result += frequencies.get(i);
		}
		System.out.println();
		System.out.println("Sum of Q frequencies = "+ result);

		System.out.println();
		ArrayList<Float> probs = new ArrayList<Float>();
		for(int i=0;i<frequencies.size();i++){
			probs.add(frequencies.get(i)/result);
			System.out.println( "i = "+ i + " Probability of Qs = " + frequencies.get(i)/result );
		}
		return probs;
	}




    //Calulate summation from i=0 to 25 of (pi * qi+j)
	public float helper(int j,ArrayList<Float> frequencies, ArrayList<Float> p_Freqs){
		float result = 0;

		for(int i=0;i<26;i++){
			int q = (i+j);
			int p = i;
			float q_ij = 0;
			float p_i = 0;

			if(q<frequencies.size()){
				q_ij = frequencies.get(q);
			}
			p_i = p_Freqs.get(p);
			result += (p_i + q_ij);
		}
		return result;
	}

	//For each value of j={0,....25} calculate I
	public ArrayList<Float> calculateKeyOptions(ArrayList<Float> frequencies,ArrayList<Float> p_Freqs ){
		ArrayList<Float> result = new ArrayList<Float>();

		for(int j=0;j<26;j++){
			float I_j = helper(j,frequencies,p_Freqs);
			result.add(I_j);
			System.out.println( "j = " + j + " I_j = " + I_j);
		}

		return result;
	}



}