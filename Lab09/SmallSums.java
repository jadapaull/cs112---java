public class SmallSums {
    public static void main(String[] args){
        final float CONSTANT = (float) 0.000001;// constant float
        float sum =(float) 0.0;// had to cast beacuse reads it as double 
        int counter = 0;//counter starts at 0 
        while (counter < 1000000){//counter goes to 999999
            sum = (float) sum  + CONSTANT;// had to cast and then add constant each time
            counter++;// counter adds each time while loop loops
        }

        System.out.println(sum);// prints the sum of the loop running 1000000 times

        final double DOUBLES = 0.000001;// constant double 
        double sumdouble = 0.0;
        int counterdouble = 0;
        while (counterdouble < 1000000){// counter goes to 999999
            sumdouble = sumdouble + DOUBLES;// had to cast and then add constant each time
            counterdouble ++;// counter adds each time while loop loops

        }
        System.out.println(sumdouble);// prints the sum of the loop running 1000000 times

    }
}
