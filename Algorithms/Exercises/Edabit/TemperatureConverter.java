package Edabit;

public class TemperatureConverter {
    /*
    Create a function that converts Celsius to Fahrenheit and vice versa.
     */

    public static String convert(String deg) {
        if (deg.endsWith("C")) {
            String[] tokens = deg.split("\\*");

            int degreesInCelsius = Integer.parseInt(tokens[0]);

            return String.format("%.0f*F", degreesInCelsius * 1.8 + 32);
        } else if (deg.endsWith("F")) {
            String[] tokens = deg.split("\\*");

            int degreesInFahrenheit = Integer.parseInt(tokens[0]);

            return String.format("%.0f*C", (degreesInFahrenheit - 32) / 1.8);
        }

        return "Error";
    }
}
