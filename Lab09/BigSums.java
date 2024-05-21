public class BigSums {
    public static void main(String[] args){
        double d1 = 1024;
        double d2= d1;
        double d3 = d2+1.0;
        int counter = 0;
        while (d3-d2==1){
            d2*=d1;
            d3 =d2+1.0;
            counter++; // counts every time it goes through the loop
        }
        System.out.println(counter);// how may times did the loop run

        float f1= (float) 1024;
        float f2 =(float) f1;
        float f3 = (float) (f2+1.0);
        int counterfloat = 0;
        while (f3-f2==1){
            counterfloat++; // counts every time it goes through the loop
            f2*=f1;
            f3 =(float)(f2+1.0);
        }
        System.out.println(counterfloat);// how may times did the loop run
        

        
    }
}
