
/**
 * Performs various mathematical methods.
 *
 * Ryan Barrett

 */

public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = minimum(data); // change this to a call to minimum method
        double max = maximum(data); // change this to a call to maximum method
        double mean = average(data); // change this to a call to average method
        double var = variance(data, mean); // change this to a call to variance method
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
        double min = x[0];
        for(int i = 1; i < x.length; i++)
            if(x[i] < min)
                min = x[i];
          
        return min;
        
    }
    
    // Add other methods here.
    public static double maximum(double[] x){
        double max = x[0];
        for(int i = 1; i < x.length; i++)
            if(x[i] > max)
                max = x[i];
        return max;
    }
    
    public static double average(double[] x){
        double total = 0;
        for(int i = 0; i < x.length; i++)
            total += x[i];
        return total / x.length;
    }
    
    public static double variance(double[] x, double avg)
    {
        double sum = 0;
        for(int i = 0; i < x.length; i++)
            sum += Math.pow(x[i] - avg, 2);
        
        return sum * (1.0 / x.length);
    }
}
