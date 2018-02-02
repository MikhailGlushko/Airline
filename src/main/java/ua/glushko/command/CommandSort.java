package ua.glushko.command;

import ua.glushko.dao.AircraftDAO;
import ua.glushko.dao.AircraftGenericDAO;
import ua.glushko.model.Aircraft;
import ua.glushko.service.AircraftService;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Command to sort the aircrafts by flight range (from smaller to larger) and display it on screen
 * @author Mikhail Glushko
 * @version 1.0
 */
public class CommandSort implements Command {
    @Override
    public void execute() {
        AircraftGenericDAO dao = new AircraftDAO();
        AircraftService aircraftService = new AircraftService(dao);
        List<Aircraft> aircraftList = aircraftService.getAircraftList();
        if(Objects.nonNull(aircraftList)){
            aircraftService.sortAircraftByFlight(aircraftList);
            for (Aircraft aircraft : aircraftList) {
                System.out.println(aircraft);
            }
        } else
            System.out.println("There are no data to sort the aircrafts by flight range (from smaller to larger) and display it on screen");
        System.out.println();
    }
}
