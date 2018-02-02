package ua.glushko.model;

/**
 * Cargo helicopter class
 *
 * @author Mikhail Glushko
 * @version 1.0
 */
public class Helicopter extends Aircraft {

    public Helicopter() {
        setType(AircraftType.CARGO);
    }

    @Override
    public String toString() {
        return "Helicopter{" +
                "serialNumber='" + getSerialNumber() + '\'' +
                ", modelName='" + getModelName() + '\'' +
                ", capacity=" + getCapacity() +
                ", carrying=" + getCarrying() +
                ", flightRange=" + getFlightRange() +
                ", fuelConsumption=" + getFuelConsumption() +
                ", type=" + getType() +
                '}';
    }
}
