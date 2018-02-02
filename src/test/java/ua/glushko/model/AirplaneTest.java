package ua.glushko.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AirplaneTest {

    @Test
    public void createAircraft() {
        Aircraft boing = new AircraftBuilder(new Airplane()).setSerialNumber("1")
                .setModelName("BOING")
                .setCapacity(100)
                .setCarrying(100)
                .setFlightRange(100)
                .setFuelConsumption(100)
                .build();
        assertNotNull(boing);
    }
}