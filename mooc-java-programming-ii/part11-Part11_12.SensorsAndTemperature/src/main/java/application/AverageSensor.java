package application;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor {

    private LinkedList<Sensor> sensors;
    private LinkedList<Integer> readings;

    public AverageSensor() {
        this.sensors = new LinkedList<>();
        this.readings = new LinkedList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    
    public List<Integer> readings() {
        return this.readings;
    }

    @Override
    public boolean isOn() {
        return this.sensors.stream().allMatch(s -> s.isOn());
    }

    @Override
    public void setOn() {
        this.sensors.forEach(s -> s.setOn());
    }

    @Override
    public void setOff() {
        this.sensors.forEach(s -> s.setOff());
    }

    @Override
    public int read() throws IllegalStateException {
        if (!this.isOn() || this.sensors.isEmpty()) {
            throw new IllegalStateException();
        }

        int reading = (int) this.sensors.stream()
                .mapToInt(s -> s.read())
                .average()
                .getAsDouble();
        
        this.readings.add(reading);
        return reading;
    }
}
