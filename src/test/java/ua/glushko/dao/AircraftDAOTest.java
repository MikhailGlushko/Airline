package ua.glushko.dao;

import org.junit.Before;
import org.junit.Test;
import ua.glushko.model.Aircraft;
import ua.glushko.model.AircraftBuilder;
import ua.glushko.model.Airplane;

import java.util.List;

import static org.junit.Assert.*;

public class AircraftDAOTest {

    private AircraftDAO dao;
    @Before
    public void init(){
        dao = new AircraftDAO();
        List<Aircraft> aircraftList = dao.read();
        assertNotNull(aircraftList);
        Aircraft boing = new AircraftBuilder(new Airplane()).setSerialNumber("1")
                .setModelName("BOING")
                .setCapacity(100)
                .setCarrying(100)
                .setFlightRange(100)
                .setFuelConsumption(100)
                .build();
        assertNotNull(boing);
        dao.create(boing);
    }

    @Test
    public void testReadOne() throws Exception {
        Aircraft aircraft = dao.read("1");
        assertNotNull(aircraft);
        assertEquals("1",aircraft.getSerialNumber());
    }

    @Test
    public void testReadList() throws Exception {
        List<Aircraft> aircraftList = dao.read();
        assertTrue(aircraftList.size()!=0);
    }

    @Test
    public void testUpdate() throws Exception {
        Aircraft aircraft = dao.read("1");
        Aircraft update = dao.update(aircraft);
        assertEquals(aircraft, update);
    }

    @Test
    public void testDelete() throws Exception {
        Aircraft aircraft = dao.delete("1");
        assertNotNull(aircraft);
        aircraft = dao.read("1");
        assertNull(aircraft);
    }

}
