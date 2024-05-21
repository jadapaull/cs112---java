import java.util.Scanner;
import java.util.ArrayList;
//import java

class BinarySearch {
    
    public static String recursion(ArrayList<String> names, String namegiven, int midpoint, int indexofarray, int startingindex){// recursion to fidn the name
        int midpointtemp = midpoint; 
        if (names.get(midpoint).equals(namegiven) == false ){
            if(names.get(midpoint).charAt(0) > namegiven.charAt(0)){
                //if names is bigger than name given
                midpoint = startingindex+ (indexofarray - startingindex)/2;// makes new midpoint
                indexofarray = midpoint;// makes the index equal to the midpoint
            }
            if (names.get(midpoint).charAt(0)< namegiven.charAt(0)){
                //if names is smaller than name given 
                startingindex = midpointtemp;
                midpoint = midpoint+(indexofarray-midpoint)/2;// makes new midpoint
            }
            if(midpoint>0){
            recursion(names, namegiven, midpoint, indexofarray, startingindex);}
        }
        if (names.get(midpoint).equals(namegiven)){
            return("MATCH");
        }
        else{
        return ("NOT FOUND");
        }
    }
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        // making a new scanner that reads from the keyboard
        ArrayList<String> names = new ArrayList<String>();
        while (keyboard.hasNextLine()){// while it has a next line then 
            names.add(keyboard.nextLine());// adding it to the array list
        }
        int indexofarray = names.size()-1;// the high point of the index
        int startingindex =0;// where all indexes start
        int midpoint = startingindex+(indexofarray-startingindex)/2;
        //finding the midpoint 
        String namegiven = args[0];
        if (names.get(midpoint).equals(namegiven) == false ){
            String name =recursion(names, namegiven, midpoint,indexofarray, startingindex);
            System.out.println(name);
        }
        else {
            System.out.println("MATCH"); 
            // if name given is in names print MATCH
        }
        keyboard.close();
    }
}