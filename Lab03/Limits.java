public class Limits{
    static void Maxbytevalue(){
        byte var1 = 0;
        byte var2 = var1;
        var1++;
        for (; var1> var2; var1 ++){
            var2= var1;
        }
        System.out.println("Maximum byte value is " + var2);}
    static void Minbytevalue(){
        byte var1 = 127;
        byte var2 = var1;
        var1--;
        for (; var1< var2; var1 --){
            var2= var1;
        }
        System.out.println("Minimum byte value is " + var2);}
    static void Maxshortvalue(){
        short var1 = 0;
        short var2 = var1;
        var1++;
        for (; var1> var2; var1 ++){
            var2= var1;
        }
            System.out.println("Maximum short value is " + var2);}
    static void Minshortvalue(){
        short var1 = 127;
        short var2 = var1;
        var1--;
        for (; var1< var2; var1 --){
            var2= var1;
            }
        System.out.println("Minimum short value is " + var2);}
    static void Maxintvalue(){
        int var1 = 0;
        int var2 = var1;
        var1++;
        for (; var1> var2; var1 ++){
            var2= var1;
        }
        System.out.println("Maximum int value is " + var2);}
    static void Minintvalue(){
        int var1 = 127;
        int var2 = var1;
        var1--;
        for (; var1< var2; var1 --){
            var2= var1;
        }
        System.out.println("Minimum int value is " + var2);}
    public static void main(String args[]){
        Maxbytevalue();
        Minbytevalue();
        Maxshortvalue();
        Minshortvalue();
        Maxintvalue();
        Minintvalue();
    }
   
}