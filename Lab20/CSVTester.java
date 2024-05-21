import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner; 
import java.lang.Exception;

class CSVWriter extends FileWriter{
    
    int numberofwords = 0;
    // CSV class extends or is derived from File Writter class
    public CSVWriter(File input) throws IOException{
        super(input);// gives to parent class
    }
    public CSVWriter(String pathname) throws IOException{
        
        super(new File(pathname));// gives to parent class

    }

    void writeln(String[] string) throws IOException, IOE{
        int counter = 0;//  counter for while loop
        int countertime =0; // how many times has this program run
        numberofwords = string.length;// how many words there are 
        if (string.length==0){
            throw new EmptyLineException();
            System.exit(0);
        }
        while (counter < string.length-1){
            write(string[counter]+ ",");// puts in commas for each word
            counter++;

        }
        write (string[counter]+"\n");// puts newline after each word
        countertime++;// how many times it runs
        if(countertime==1){
            numberofwords=counter;
        }
        else{
            if(numberofwords != counter){
                throw new IOE("Expected Number of strings: "+numberofwords + "\n"+"Words given: "+counter);//look at PDF
            }
        }
    }
}
class IOE extends Exception{
    // derived from Exception class 
    IOE(String messageString){
        super(messageString);// gives to parent class
    }

    
}
class EmptyLineException extends IOE {
EmptyLineException(String messageString){
    super(messageString);// gives to parent class
}
}


class CSVTester{
    public static void main(String[] args) throws IOException, IOE{
        CSVWriter CSV =new CSVWriter("CSVTester.csv");// new object 
        Scanner keyboardscan = new Scanner(System.in);// scanning from the keyboard
        while(keyboardscan.hasNextLine()){// keeps scanning until there is nothing left
           
            CSV.writeln(keyboardscan.nextLine().split(" "));
            // Adds it to array list creater
        }
        CSV.close();// closes CSV
        keyboardscan.close();// closes the keyboard scan 

    }

}