import java.math.BigDecimal;

public class Converter {
    int distance = 75;
    int calories = 50;

    double getDistance(int steps) {
        double distMonth = steps * distance;
        double stepsToDist = distMonth / 100000;
        return stepsToDist;
    }

    double getCalories(int steps) {
        double calorMonth = steps * calories;
        double stepsToCalories = calorMonth / 1000;
        return stepsToCalories;
    }

}
