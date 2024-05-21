public class DataConvert {
    static void inttofloatcast(){
        float var1 = (float) 2.5;
        int var2 = (int) var1;
        System.out.println("2.5 casted to int gives you " + var2);
    }
    static void floattoint(){
        float var1= (float) -4.5;
        int var2 = (int) var1;
        System.out.println("-4.5 casted to int gives you " + var2);
    }
    static void doubletofloat(){
        double var1 = (double) 1.0/3.0;
        float var2 = (float) var1;
        System.out.println("double 1/3 = " + var1 + " but float 1/3= " + var2);
    }
    static void inttobyte(){
        int var1 =256;
        byte var2 = (byte)var1;
        System.out.println("Byte value of 256 is "+ var2);
    }
    static void inttobytecast(){
        int var1 = 257;
        byte var2= (byte)var1;
        System.out.println("Byte value of 257 is "+ var2);  
    }
    static void inttobytecast3(){
        int var1 = 258;
        byte var2= (byte)var1;
        System.out.println("Byte value of 258 is "+ var2);    
    }
    static void inttobyte4(){
        int var1= 511;
        byte var2=(byte) var1;
        System.out.println("Byte value of 511 is "+ var2);    
    }
    public static void main(String[] args){
        inttofloatcast();
        floattoint();
        doubletofloat();
        inttobyte();
        inttobytecast();
        inttobytecast3();
        inttobyte4();
    }
}
