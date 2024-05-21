import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
public class Merge {
    public static void main (String[] args){
        try{
        String textfile1 = args[0];
        String textfile2= args[1];
        String textfile3 = args[2];// takes in three text files 
        File myfile1 = new File(textfile1);
        File myfile2 = new File(textfile2);
        File myfile3 = new File(textfile3);// makes them into files 
        Scanner myfilescan1 = new Scanner(myfile1);
        Scanner myfilescan2 = new Scanner(myfile2);
        Scanner myfilescan3 = new Scanner(myfile3);// makes a new scanner for them 
        ArrayList<Integer> Intarray1= new ArrayList<Integer>();
        ArrayList<Integer> Intarray2= new ArrayList<Integer>();
        ArrayList<Integer> Intarray3= new ArrayList<Integer>();// makes new array lists
        while (myfilescan1.hasNextLine()){
            int data = myfilescan1.nextInt();
            Intarray1.add(data);
        }// adds integers to array 1
        while (myfilescan2.hasNextLine()){
            int data = myfilescan2.nextInt();
            Intarray2.add(data);
        }// add integers to array 2
        while (myfilescan3.hasNextLine()){
            int data = myfilescan3.nextInt();
            Intarray3.add(data);
        }// add integers to array 3
        int counter =0;
        int counter2=0;
        int counter3 = 0;// counters for each array
        ArrayList<Integer> newlist = new ArrayList<Integer>();
        // making a new arra to store the numbers i
        while (newlist.size()<= (Intarray1.size()+Intarray2.size()+Intarray3.size())){
            // while the new list is smaller than or equal to the three lists that I am taking in combined the while loop keeps going 
        if (Intarray1.get(counter)>Intarray2.get(counter2) && Intarray2.get(counter2)<Intarray3.get(counter3)){
            newlist.add(Intarray2.get(counter2));
            counter2++;
            // if array list 2 is the smallest then you put it in first and bring counter up one to move to the next index
        }
        if(Intarray2.get(counter2)> Intarray1.get(counter) && Intarray3.get(counter3)> Intarray1.get(counter)){
            newlist.add(Intarray1.get(counter));
            counter++;
            // if array list 1 in the smallest add it in and bring counter up one to move to the next index

        }
        if (Intarray2.get(counter2)>Intarray3.get(counter3) && Intarray3.get(counter3) <Intarray1.get(counter)){
            newlist.add(Intarray3.get(counter3));
            counter3++;
            // if array list 3 is the smallest add the number in and bring counter up one to move to the next index
        }
        else {
            newlist.add(Intarray2.get(counter2));
            newlist.add(Intarray1.get(counter));
            newlist.add(Intarray3.get(counter3));
            // if non of that is true then it will add all of the numbers together becaus ethat means they have the same number
        }
    }
    System.out.println(newlist);// prints out the new list made
    myfilescan1.close();
    myfilescan2.close();
    myfilescan3.close();
    // closes all of the files
    }
catch(Exception IOE){
    System.err.println("Error"+IOE.getMessage());
    System.err.println(IOE.getStackTrace());
    // if something goes wrong it prints an error message and shows the stack trace for the error 
}
    }
}