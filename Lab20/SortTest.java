import java.io.File;// imports file class
import java.io.FileNotFoundException;// handles exceptions 
import java.util.ArrayList;
import java.util.Scanner;// read text files 

public class SortTest{

    public static void main(String[] args){
        String filename = args[0];// takes file name in args[0]
        File myFile = new File(filename);
        try {
            Scanner myFileRead = new Scanner(myFile);
            ArrayList<Integer> Array = new ArrayList<Integer>();
            while (myFileRead.hasNextInt()){// adds all of the things to the file in the array
                Array.add(myFileRead.nextInt());
            }
            int pass = 0;
            int fail=0;
            int wrongelementcount =0;
            //System.out.println(Array.size());
            for(int counter=0;counter+1<Array.size();counter++){
                if (Array.get(counter+1)>Array.get(counter)){// goes through the array and if they are in the correct order gives them a pass
                    pass++;

                }
                else if (Array.get(counter+1)<Array.get(counter)){// goes through array and if they are not gives them a fail 
                    fail++;

                }
                else if (Array.size()!= 10000)
                    wrongelementcount++;

            }

            if (fail >= 1){
                System.out.print ("FAIL Incorrect Sort");
            }            
            else if (10000==Array.size()){
                System.out.print("PASS");
            }
            else if (Array.size() != 10000){
                System.out.print("FAIL Incorect element Count");
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        



    }
}