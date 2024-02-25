public class ShortToText{
    public static void main(String[] args){
        // Take in the short value from the user 
        short value = Short.parseShort(args[0]);
        //Print out 16 1's and 0's 
        String startingvalue = "";
        int counter = 0;
        int power = 15;
        if (value >= 0){
            while (counter < 16){
                short powernum = (short) Math.pow(2, power);
                if (Math.abs(value) >= Math.abs(powernum)){
                    startingvalue += 1;
                    if(value > 0){
                        value -= powernum;
                    }
                }
                else {
                    startingvalue += 0;
                }
                power--;
                counter++;
                    
            }
        }
        else if (value < 0){
            while (counter < 16){
                short powernum = (short) Math.pow(2, power);
                if (Math.abs(value) >= powernum){
                    startingvalue += 1;
                    if(value < 0){
                        value += powernum;
                    }
                }
                else {
                    startingvalue += 0;
                }
                power--;
                counter++;
                    
            }
        }

        System.out.println(startingvalue);

    }
}