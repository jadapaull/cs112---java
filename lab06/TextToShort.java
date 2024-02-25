public class TextToShort {
    public static void main(String[] args){
        String valueuncleaned = args[0];// gets args from reader
        String valuehalf = valueuncleaned.replaceAll(" ",""); //cleaning the value of spaces
        String value = valuehalf.replaceAll(",","");//cleaning the value given of commas
        if (value.length() > 16 || value.length() == 0){// needs to print error if nothing is entered
            System.err.println("ERROR");
            System.exit(0);// ends the program after printing error
        }
        if (value.length() <= 16){
            int length = value.length();
            int counter = length ;// starting from the back
            short power = 0; //  power goes up each time gone through
            short total = 0; // total counter
            while (counter > 0){
                if (value.charAt(counter-1)== '0'){// if character is 0 dont do anything 

                }
                if (value.charAt(counter-1)== '1'){// if charachter is 1 give number and add to total
                    short powers= (short) Math.pow(2,power);// converting to short
                    total= (short) (total+powers);// conoverting to short 
                }
                counter--;//each time counter goes down
                power++;// each time power goes up 
            }
            System.out.println(total);// prints the total 
            }
        }
        }
    

