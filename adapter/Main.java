import Models.AdapterThermometer;
import Models.CelsiusThermometer;
import Models.CelsiusThermometerInstance;
import Models.FahrenheitThermometer;

public class Main {
    public static void main(String[] args) {



        // let assume that our client only supports celsius thermometer , but we want temperature in fahrenheit
        // but fahrenheit thermometer is compatible with our client.

        // how can we get fahrenheit temperature without using different kind of thermometer

        // we can define one adapter class which also implements celsius thermometer interface
        // it also have Fahrenheit thermometer reference
        // it will bypass request to fahrenheit thermometer ,
        // and our client still using implementation of celsius thermometer

        FahrenheitThermometer fahrenheitThermometer = new FahrenheitThermometer(); // fahrenheit thermometer
        CelsiusThermometer celsiusThermometer = new AdapterThermometer(fahrenheitThermometer); // adapter thermometer

        double temperature = celsiusThermometer.getTemperature();
        System.out.println("Temperature in Fahrenheit is : " + temperature);


    }
}
