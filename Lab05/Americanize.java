public class Americanize {
    static String WordConvert(String printedargs){// brings in printed args and the prints out a new string 
            newstring.equalsIgnoreCase(printedargs);// ignores cases of the sentence 
            String newstring= printedargs.replaceAll("tea", "coffee"); // replaces all tea with coffee
            printedargs.equalsIgnoreCase(newstring);// ignore case 
            return newstring;
        }

    public static void main(String[] args){
        int numberOfArgs = args.length;
        int counter = 0;
        while (counter < numberOfArgs){
            String printedargs= args[counter];// stores user data
            counter++;
        String newstring = WordConvert(printedargs);// makes variable for new string in main
        System.out.println(newstring);// prints new string
    }
}
}
