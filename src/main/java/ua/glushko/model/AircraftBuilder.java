package ua.glushko.model;

import java.util.Objects;

/**
 * AircraftGenericDAO builder
 *
 * @author Mikhail Glushko
 * @version 1.0
 */
public class AircraftBuilder {

    private final Aircraft aircraft;

    public AircraftBuilder(Aircraft aircraft){
        this.aircraft = aircraft;
    }
    public AircraftBuilder setSerialNumber(String serialNumber){
        aircraft.setSerialNumber(serialNumber);
        return this;
    }
    public AircraftBuilder setModelName(String modelName){
        aircraft.setModelName(modelName);
        return this;
    }
    public AircraftBuilder setCapacity(double capacity){
        aircraft.setCapacity(capacity);
        return this;
    }

    public AircraftBuilder setCarrying(double carrying){
        aircraft.setCarrying(carrying);
        return this;
    }

    public AircraftBuilder setFlightRange(double flightRange){
        aircraft.setFlightRange(flightRange);
        return this;
    }

    public AircraftBuilder setFuelConsumption(double fuelConsumption){
        aircraft.setFuelConsumption(fuelConsumption);
        return this;
    }

    public Aircraft build(){
        if (Objects.isNull(aircraft.getSerialNumber()) || Objects.isNull(aircraft.getModelName()) ||
                aircraft.getCapacity()<=0.0 || aircraft.getCarrying()<=0.0 || aircraft.getFlightRange()<=0.0 || aircraft.getFuelConsumption()<=0.0)
            throw new IllegalArgumentException("All required parameters were not supplied.");
        return aircraft;
    }
}
