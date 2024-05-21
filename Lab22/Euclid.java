// this is going to be a recursive program 
class Euclid{

    public static int recursion(int firstnum, int secondnum) {// making a recursive  class to do calculations
            if (firstnum == 0){// i did if A==0
            return secondnum;}// return B
 
        return recursion(secondnum % firstnum, firstnum); // here it is( B%A,A)

        }
    
    public static void main(String[] args){// main class
        try {
            Integer firstnum =Integer.parseInt(args[0]);// takes first number from first args statement
            Integer secondnum =Integer.parseInt(args[1]);// takes second number from second ars statement
            int gcf = recursion(firstnum, secondnum);//assigns thegreatest common factor to variable
            System.out.println("GCD(" + firstnum + " , " + secondnum
            + ") = " + gcf);// I just followed the examples for the prints on the Lab22.pdf
            
        } catch (Exception EIO) {
            System.err.println("Error!");// prints error
            EIO.getMessage();// prints message of what was wrong
            EIO.printStackTrace();// shows where the error is 

        }

    }
} 