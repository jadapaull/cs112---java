// This program makes cubes lower than 2000
public class Cubes {
    public static void main(String args[]){
        int startvar = 0;
        startvar++;
        int cubed = startvar;
        for (;cubed <= 2000;startvar++){
            cubed = startvar;
            cubed*=cubed*cubed;
            if (cubed > 2000){
                break;
            }
            System.out.println(cubed);
        }
}
}
