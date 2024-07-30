package DSA_1.Financial_Forecasting;

public class FinancialForecasting {

    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        double futureValue = currentValue;
        for (int i = 0; i < years; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static double predictFutureValueOptimized(double currentValue, double growthRate, int years) {
        Double[] memo = new Double[years + 1];
        memo[0] = currentValue;
        for (int i = 1; i <= years; i++) {
            memo[i] = memo[i - 1] * (1 + growthRate);
        }
        return memo[years];
    }

    public static void main(String[] args) {
        double currentValue = 1000.0;
        double growthRate = 0.05;
        int years = 10;

        // Iterative approach
        double futureValue = predictFutureValue(currentValue, growthRate, years);
        System.out.println("Predicted future value (iterative): " + futureValue);

        // Optimized approach using dynamic programming
        double futureValueOptimized = predictFutureValueOptimized(currentValue, growthRate, years);
        System.out.println("Predicted future value (optimized): " + futureValueOptimized);
    }
}
