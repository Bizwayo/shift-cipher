import java.io.*;

class main{

    public static void main(String[] args) {
        String[] ciphertext = new String[100000];
        try{
            BufferedReader inFile = new BufferedReader(new FileReader("test.txt"));
            String line="";
            int i=0;

            while((line = inFile.readLine()) != null) {
                String[] words = line.trim().split("");
                for(int j=0;j<words.length;j++){
                    ciphertext[i++] = words[j];
                }
            }
            inFile.close();
        }
        catch(IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }
    }
}