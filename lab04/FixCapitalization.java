public class FixCapitalization {
    static void Fixit(String printedargs){
        String lowercase =printedargs.toLowerCase();
        char lowerchar[] = lowercase.toCharArray();
        //System.out.println(lowerchar);

        int k = 0;
        while (lowerchar[k] == ' '){
            k++;
        }
        lowerchar[k] = Character.toUpperCase(lowerchar[k]);

        for (int i=0; i< lowerchar.length; i++){
            if (i+1 < lowerchar.length){
                if (lowerchar[i] == '.'){
                    int j = 1;
                    while (lowerchar[i+j] == ' '){
                        j++;
                    }
                    lowerchar[i+j] = Character.toUpperCase(lowerchar[j+i]);
                }
                if (lowerchar[i] == '?'){
                    int j = 1;
                    while (lowerchar[i+j] == ' '){
                        j++;
                    }
                    lowerchar[i+j] = Character.toUpperCase(lowerchar[j+i]);
                }
                if (lowerchar[i] == '!'){
                    int j = 1;
                    while (lowerchar[i+j] == ' '){
                        j++;
                    }
                    lowerchar[i+j] = Character.toUpperCase(lowerchar[j+i]);
                }
            }
        }
        System.out.print(lowerchar);

    }    
    
    public static void main(String[] args){
        int numberOfArgs = args.length;
        int counter = 0;
        while (counter < numberOfArgs){
            String printedargs= args[counter];
            counter++;
            Fixit(printedargs);
        }
    }
}