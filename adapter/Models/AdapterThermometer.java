package Models;

public class AdapterThermometer implements CelsiusThermometer {

    private final FahrenheitThermometer fahrenheitThermometer;

    public AdapterThermometer(FahrenheitThermometer fahrenheitThermometer) {
        this.fahrenheitThermometer = fahrenheitThermometer;
    }

    @Override
    public double getTemperature() {
        return fahrenheitThermometer.getTemperature();
    }
}
