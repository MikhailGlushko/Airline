package ua.glushko.model;

/**
 * Passenger Airplane class
 *
 * @author Mikhail Glushko
 * @version 1.0
 */
public class PassengerAirplane extends Airplane {

    public PassengerAirplane() {
        setType(AircraftType.PASSENGER);
    }

    @Override
    public String toString() {
        return "PassengerAirplane{" +
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
