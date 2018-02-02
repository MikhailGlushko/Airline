package ua.glushko.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Base parent class AircraftGenericDAO
 *
 * @author Mikhail Glushko
 * @version 1.0
 */
abstract public class Aircraft implements Serializable{
    private static final long serialVersionUID = 1L;

    private String serialNumber;
    private String modelName;
    private double capacity;
    private double carrying;
    private double flightRange;
    private double fuelConsumption;
    private AircraftType type;

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getCarrying() {
        return carrying;
    }

    public double getFlightRange() {
        return flightRange;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setCarrying(double carrying) {
        this.carrying = carrying;
    }

    public void setFlightRange(double flightRange) {
        this.flightRange = flightRange;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    AircraftType getType() {
        return type;
    }

    void setType(AircraftType type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Aircraft{" +
                "serialNumber='" + serialNumber + '\'' +
                ", modelName='" + modelName + '\'' +
                ", capacity=" + capacity +
                ", carrying=" + carrying +
                ", flightRange=" + flightRange +
                ", fuelConsumption=" + fuelConsumption +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return Double.compare(aircraft.capacity, capacity) == 0 &&
                Double.compare(aircraft.carrying, carrying) == 0 &&
                Double.compare(aircraft.flightRange, flightRange) == 0 &&
                Double.compare(aircraft.fuelConsumption, fuelConsumption) == 0 &&
                Objects.equals(serialNumber, aircraft.serialNumber) &&
                Objects.equals(modelName, aircraft.modelName) &&
                type == aircraft.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, modelName, capacity, carrying, flightRange, fuelConsumption, type);
    }
}
