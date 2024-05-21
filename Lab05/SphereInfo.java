public class SphereInfo {
   public class Sphere{
        private static double setDiameter(double printeddiameter){// takes in user diameter and then returns diameter
            double diameter = printeddiameter;
            return diameter;

        }
        static double diameter(double printeddiameter){// takes in set diameter and puts it in as the diamete
            double diameter = setDiameter(printeddiameter);
            return diameter;
        }

        static double radius(double diameter){ //has diameter returns radius
             double radius =  (diameter/2);// radius math 
             return radius;

        }
        static double surfaceArea(double radius){// has radius returns surface area
            double pinumber= Math.PI ;
            double surfaceArea = 4*pinumber*(radius*radius);// surface area math 
            return surfaceArea;


        }
        static double volume(double radius){// has radius returns volume 
            double volume = 4 * Math.PI * Math.pow(radius, 3) / 3;// volume math 
            return volume; 

        }
    }
    public static void main(String[] args){
        int counter = 0;
        String printedargs= args[counter];// takes in number 
        double printeddiameter=Double.parseDouble(printedargs); // turns it in to double 
        Sphere.setDiameter(printeddiameter);// call set diameter
        double diameter = Sphere.diameter(printeddiameter);// call and give value 
        double radius= Sphere.radius(diameter);// call and store value
        double surfaceArea = Sphere.surfaceArea(radius);// call and store value
        double volume = Sphere.volume(radius); // call and store value 
        // prints out ending sentence 
        System.out.println("A sphere of radius "+ radius + " has surface area of " + surfaceArea + " and volume of "+ volume+ "." );
    }
    
}
