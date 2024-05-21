import java.util.Random;
abstract class Dessert{
    abstract String Ingredients();
    abstract String Names();
    abstract String Where(); 
    public String toString() {
        String string = Names() + " contains "+ Ingredients()+" and the best comes from "+ Where();
        return string;
    }       
}
class VanillaCupcake extends Dessert{
    String Names(){
        return "Vanilla Cupcake";
    }
String Ingredients(){
    return "all-purpose flour, butter, sugar, eggs, buttermilk, baking powder, salt and vanilla";
}
    String Where(){
        return "Kara's Cupcakes Marina.";
    } 

}
class CarrotCake extends Dessert{
    String Names(){
        return "Carrot Cake";}
    String Ingredients(){
        return "flour, eggs, sugar, carrots, and baking powder ,hazelnuts, lemon, kirsch, cinnamon, almonds, and walnuts";}
    String Where(){ 
        return  "SusieCakes - Laurel Village.";}

}
class AlmondCrossaint extends Dessert{
    String Names(){
        return "Almond Croissant";
    }
    String Ingredients(){
        return "butter, flour, yeast, sugar, salt, free range eggs, milk, and almonds";}
    String Where() {
        return "b.patisserie.";}

}
public class MyDesserts {
    public static void main(String[] args){
        Random random = new Random();
        int randomnum = random.nextInt(3);
        Dessert dessert1 =null;
        if (randomnum==0){
            dessert1= new VanillaCupcake();
        }
        if (randomnum == 1){
            dessert1 = new CarrotCake();
        }
        if (randomnum == 2){
            dessert1 = new AlmondCrossaint();
        }
        System.out.println(dessert1);
    }
}
