public class ParseWords {
    static void Parse(String printedargs){
        char[] argArray = printedargs.toCharArray();
        String printString = ""; // init empty print string

        int charCounter = 0;
        if (argArray[0] == ':'){ // If first character is colon print BLANK and move to second character
            System.out.println("BLANK");
            charCounter += 1;
        }

        int argLength = argArray.length;
        while (charCounter < argLength){ // loop until end of argument
            char currentChar = argArray[charCounter];

            if (currentChar == ':'){

                if (printString.isEmpty()){ // if print string is empty, means that there's double colon. Print BLANK
                    System.out.println("BLANK");
                }

                else{ // Print out our print string
                    if (charCounter == argLength-1){ // Last character is colon. Print out the print string and BLANK
                        System.out.println(printString);
                        System.out.println("BLANK");
                        break; // Break loop to not print out print string again
                    }
                    System.out.println(printString);
                    printString = "";
                }

            }
    
            else { // Character is not a colon, adds current character to the print string
                printString += currentChar;
            }

            if (charCounter == argLength-1){ // Prints last word, in case that input doesn't end in colon
                if (argArray[charCounter] != ':'){ // If statement stops printing blank line for colon-only inputs
                    System.out.println(printString);
                    break;
                }
                
            }

            charCounter++;
        }
    }
    public static void main(String[] args){
        int numberOfArgs = args.length;
        int counter = 0;
        while (counter < numberOfArgs){
            String printedargs = args[counter];
            //System.out.println(printedargs);
            counter++;
            Parse(printedargs);
        }
    }
}

