public class FloatLimits {

    static void Minfloatvalue(){
        float var1 = 1;
        float var2 = 0;
        float var3 = var1;
        while (var1> var2){
            var3= var1;
            var1=var1/2;
        }
        System.out.println("Smallest positive float is " + var3);
    }

    static void Mindoublevalue(){
        double var1 = 1.0;
        double var2 = 0.0;
        double var3= var1;
        while (var1> var2){
            var3= var1;
            var1=var1/2;

        }
        System.out.println("Smallest positive double is "+ var3);
    }
    public static void main(String args[]){
        Minfloatvalue();       
        Mindoublevalue();               


    }
}
