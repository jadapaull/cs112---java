public class NumberTable {
    
    static String toHex(int decimal){
        String hexVal = ""; // Empty String for Hex value
        int firstCounter = 0;

        // Adds first (left) digit to hexVal
        while (decimal >= 16){ // Finds how many times 16 goes into decimal number
            decimal -= 16;
            firstCounter++; 
        }
        if (firstCounter > 9){ // If greater than 9 (9 * 16), digit is A through F
            hexVal += (char)(55 + firstCounter); // firstCounter (10 through 15) + 55 (decimal ascii value). 65 is A, 70 is F. 
        }
        else { // If less than 9 (9 * 16), digit is number
            hexVal += firstCounter;
        }

        // Adds second (right) digit to hexVal
        if (decimal > 9){ // If remainder of decimal number is 10 or greater, digit is A through F
            hexVal += (char)(55 + decimal); // decimal remainder (10 through 15) + 55 (decimal ascii value). 65 is A, 70 is F. 
        }
        else { // If remainder ess than 9, digit is number
            hexVal += decimal;
        }

        return hexVal;
    }
    
    static String toBinary(int decimal){
        String binaryVal = "";
        int counter = 0;
        int power = 7;
        while (counter < 8){
            short powernum = (short) Math.pow(2, power);
            if (decimal >= powernum){
                binaryVal += 1;
                decimal -= powernum;
            }
            else {
                binaryVal += 0;
            }
            power--;
            counter++;
                
        }
        
        return binaryVal;
    }
    
    public static void main(String[] args) {
        int value = 100; // starting value 
        while (value <= 255){
            String hex = toHex(value);
            String binary = toBinary(value);
            System.out.printf(null);//make a print f statement for number table output 

            value++;
        }
        }
        
}

