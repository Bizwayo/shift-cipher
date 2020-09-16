import java.io.*;

class main{

    public static void main(String[] args) {
        String[] ciphertext = new String[100000];
        int cLength = 0;
        try{
            BufferedReader inFile = new BufferedReader(new FileReader("test.txt"));
            String line="";

            while((line = inFile.readLine()) != null) {
                String[] words = line.trim().split("");
                cLength = words.length;
                for(int j=0;j<words.length;j++){
                    ciphertext[j] = words[j];
                }
            }
            System.out.println("Array length: "+ cLength);

            String[] result = new String[cLength];
            for(int i=0;i<cLength;i++){
                result[i] = ciphertext[i];
            }
            inFile.close();
        }
        catch(IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }



        String[] test = {"A","B","C","D"};
        Vigenere vArr = new Vigenere(test,4);
        String[][] a = vArr.streams();
        
            for(int r=0;r<a.length;r++){
                for(int c=0;c<a[r].length;c++){
                    System.out.print(a[r][c] + ",");
                }
                System.out.println();
            }

    }
}