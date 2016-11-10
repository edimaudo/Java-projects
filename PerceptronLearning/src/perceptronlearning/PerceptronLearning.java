/*
Implementing a simple neural network in Java

*/
package perceptronlearning;

/**
 *
 * @author edima
 */
public class PerceptronLearning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    double threshold = 1;
    double learningRate = 0.1;
    double [] weight = {0.0,0.0};
    
    // Training data
    int [][][] trainingData = {
        {{0,0},{0}},
        {{0, 1}, {0}},
        {{1, 0}, {0}},
        {{1, 1}, {1}},
    };
    }
    
    // Training data loop
    while(True){
        int errorCount = 0;
        for (int value = 0; value < trainingData.Length; value++){
          System.out.println("The starting weights are " + Array.toString(weight));  
        }
    }
}
