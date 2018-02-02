package ua.glushko.model;

/**
 * Passenger Helicopter class
 *
 * @author Mikhail Glushko
 * @version 1.0
 */
public class PassengerHelicopter extends Airplane {

    public PassengerHelicopter() {
        setType(AircraftType.PASSENGER);
    }

    @Override
    public String toString() {
        return "PassengerHelicopter{" +
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
