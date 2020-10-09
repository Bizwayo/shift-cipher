import java.io.*;
import java.util.*;

class main{

    public static void main(String[] args) {
        String[] ciphertext = new String[100000];
        int cLength = 0;
        try{
            BufferedReader inFile = new BufferedReader(new FileReader("test.txt"));
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

            //Vigenere cipher text
            Vigenere vArr = new Vigenere(test);
            ArrayList< ArrayList<String> > a = vArr.streams();
            for(int row=0;row<a.size();row++){
                System.out.print("T"+ (row+1) + ": "+ " {");
                ArrayList<String> h = a.get(row);
                for(int col=0;col<h.size();col++){
                    System.out.print(h.get(col)+",");
                }
                System.out.print("}");
                System.out.println();
            }

            ArrayList< ArrayList<Float> > freqs = vArr.streamFrequencies(a);

            ArrayList<Float> stScores = vArr.stScores(freqs);

            System.out.println("\nStScores: ");
            for(int i=0;i<stScores.size();i++){
                System.out.println("For T" + (i+1) + " St =" + stScores.get(i));
            }


            //STREAMS ARRAY
           /* String[][] a = vArr.streams();

            System.out.println("\nSTREAMS ARRAY: ");
            for(int row=0;row<a.length;row++){
                System.out.print("T"+ (row+1) + ": "+ " {");
                for(int col=0;col<a[0].length;col++){
                    System.out.print(a[row][col]+",");
                }
                System.out.print("}");
                System.out.println();
            }

            /*
            float[][] freqs = vArr.streamFrequencies(a);
            float[] stScores = vArr.stScores(freqs);

            /*System.out.println("\nStScores: ");
            for(int i=0;i<stScores.length;i++){
                System.out.println("For T" + (i+1) + " St =" + stScores[i]);
            }
            /*for(int row=0;row<freqs.length;row++){
                for(int col=0;col<freqs[0].length;col++){
                    System.out.print(freqs[row][col]+",");
                }
                System.out.println();
            }*/

            inFile.close();
        }
        catch(IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }
    }
}