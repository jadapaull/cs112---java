public class CollatzStart {
        static int runSteps(int n) {
            int numberOfSteps = 0;
            // STUDENT FILL IN HERE
            while (n != 1 ){        //keeps running until n is 1
                    if (n%2 == 0){      //if even divides by 2 and adds step
                    n= n/2;
                    numberOfSteps++;
                }
                else{   // if odd mutiplies by 3 adds one and adds a step
                    n=3*n+1;
                    numberOfSteps ++;
                }
            }
           
            return numberOfSteps;
        }
        
        public static void main(String args[]) {
            int currentNumber = 1;
            while (currentNumber <= 200) {
                System.out.println(currentNumber + " " + runSteps(currentNumber));
                currentNumber++;
            }
        } 
}
