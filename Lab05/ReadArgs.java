public class ReadArgs {
    public static void main(String[] args){
        int numberOfArgs = args.length;
        int counter = 0;
        System.out.println("Program called with "+numberOfArgs+" arguments:");
        while (counter < numberOfArgs){
            System.out.println(args[counter]);
            counter++;
        }
    }
}