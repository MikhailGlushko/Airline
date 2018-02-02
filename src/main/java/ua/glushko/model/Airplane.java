package ua.glushko.model;

/**
 * Cargo Airplane class
 *
 * @author Mikhail Glushko
 */
public class Airplane extends Aircraft {

    public Airplane() {
        setType(AircraftType.CARGO);
    }

    @Override
    public String toString() {
        return "Airplane{" +
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
