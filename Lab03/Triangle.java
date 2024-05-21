public class Triangle {
    public static void main(String[] args){
        int row = 0;
        int column = 1;
        int multiple = 1;
        for(;row <16;){ //row increases by 1 until 15
            row = row+1;

            for(;column < row;){ //Column increases by 1 until row, after next for loop

                for(multiple=1;multiple<column;){ //Column val miltiplied by 1, 2, 3, etc. until 1 under square
                    System.out.print(column*multiple+" ");
                    multiple++;
                }
                System.out.println(column*column); //Column squared, new line
                column= column+1;
            }
        }
    }
}
