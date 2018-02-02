package ua.glushko.service;

import org.junit.Before;
import org.junit.Test;
import ua.glushko.dao.AircraftDAO;
import ua.glushko.dao.AircraftGenericDAO;
import ua.glushko.model.Aircraft;
import ua.glushko.model.AircraftBuilder;
import ua.glushko.model.Airplane;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AircraftServiceTest {

    private AircraftService service;
    private AircraftGenericDAO dao;
    @Before
    public void init(){
        dao = new AircraftDAO();
        service = new AircraftService(dao);

        Aircraft boing = new AircraftBuilder(new Airplane()).setSerialNumber("1")
                .setModelName("BOING1")
                .setCapacity(100)
                .setCarrying(100)
                .setFlightRange(100)
                .setFuelConsumption(100)
                .build();
        assertNotNull(boing);
        dao.create(boing);
        Aircraft boing2 = new AircraftBuilder(new Airplane()).setSerialNumber("2")
                .setModelName("BOING2")
                .setCapacity(100)
                .setCarrying(100)
                .setFlightRange(200)
                .setFuelConsumption(100)
                .build();
        assertNotNull(boing2);
        dao.create(boing2);
        Aircraft boing3 = new AircraftBuilder(new Airplane()).setSerialNumber("3")
                .setModelName("BOING3")
                .setCapacity(100)
                .setCarrying(100)
                .setFlightRange(50)
                .setFuelConsumption(100)
                .build();
        assertNotNull(boing3);
        dao.create(boing3);
        dao.storeDataToFile();
    }

    @Test
    public void test(){
        List<Aircraft> aircraftList = service.getAircraftList();
        Aircraft firstBeforeSort = aircraftList.iterator().next();
        service.sortAircraftByFlight(aircraftList);
        Aircraft firstAfterSort = aircraftList.iterator().next();
        assertTrue(firstBeforeSort.getFlightRange()>=firstAfterSort.getFlightRange());
        List<Aircraft> result = service.findAircraftByFlightRange(aircraftList, 60, 90);
        System.out.println(result);
    }

}
