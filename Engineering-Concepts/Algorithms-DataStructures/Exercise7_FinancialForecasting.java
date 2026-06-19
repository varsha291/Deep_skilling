public class Exercise7_FinancialForecasting {
    public static double futureValueRecursive(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return futureValueRecursive(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static double futureValueIterative(double presentValue, double growthRate, int years) {
        double value = presentValue;
        for (int year = 1; year <= years; year++) {
            value *= 1 + growthRate;
        }
        return value;
    }

    public static void main(String[] args) {
        double presentValue = 10000;
        double annualGrowthRate = 0.08;
        int years = 5;

        double recursiveForecast = futureValueRecursive(presentValue, annualGrowthRate, years);
        double iterativeForecast = futureValueIterative(presentValue, annualGrowthRate, years);

        System.out.printf("Recursive forecast after %d years: Rs.%.2f%n", years, recursiveForecast);
        System.out.printf("Iterative forecast after %d years: Rs.%.2f%n", years, iterativeForecast);

        System.out.println("\nComplexity:");
        System.out.println("The recursive solution is O(n) time and O(n) stack space. The iterative version keeps O(n) time but uses O(1) space.");
    }
}
