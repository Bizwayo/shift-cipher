import java.io.*;
import java.util.*;

class main{

    public static void main(String[] args) {
        String[] ciphertext = new String[100000];
        int cLength = 0;
        try{
            BufferedReader inFile = new BufferedReader(new FileReader("shiftsample.txt"));
            String line="";

            //file reading
            while((line = inFile.readLine()) != null) {
                String[] words = line.trim().split("");
                cLength = words.length;
                for(int j=0;j<words.length;j++){
                    ciphertext[j] = words[j];
                }
            }
            String[] test = new String[cLength];
            for(int i=0;i<cLength;i++){
                test[i] = ciphertext[i];
            }

            //Shift cipher text
            Shift shiftcipher = new Shift(test);

            System.out.println();
            double n = shiftcipher.totalN();
            ArrayList<Float> probs_p = shiftcipher.probability(n);
            System.out.println();

            ArrayList<Float> freqs = shiftcipher.getFrequencies();
            System.out.println();
            ArrayList<Float> keyOptions = shiftcipher.calculateKeyOptions(freqs,probs_p);

            //ArrayList< ArrayList<Float> > freqs = vArr.streamFrequencies(a);

            //ArrayList<Float> stScores = vArr.stScores(freqs);

            /*System.out.println("\nStScores: ");
            for(int i=0;i<stScores.size();i++){
                System.out.println("For T" + (i+1) + " St =" + stScores.get(i));
            }*/

            inFile.close();
        }
        catch(IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }
    }
}