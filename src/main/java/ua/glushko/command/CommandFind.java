package ua.glushko.command;

import ua.glushko.dao.AircraftDAO;
import ua.glushko.dao.AircraftGenericDAO;
import ua.glushko.model.Aircraft;
import ua.glushko.service.AircraftService;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Command to find aircraft corresponding to the specified range of fuel consumption parameters (liters per hour)
 * @author Mikhail Glushko
 * @version 1.0
 */
public class CommandFind implements Command {
    @Override
    public void execute() {
        AircraftGenericDAO dao = new AircraftDAO();
        AircraftService aircraftService = new AircraftService(dao);
        Scanner scanner = new Scanner(System.in);
        double start = getStartRange(scanner);
        double end = getEndRange(scanner);
        List<Aircraft> aircraftList = aircraftService.getAircraftList();
        if(Objects.nonNull(aircraftList)){
            aircraftService.sortAircraftByFlight(aircraftList);
            List<Aircraft> range = aircraftService.findAircraftByFlightRange(aircraftList, start, end);
            if(Objects.nonNull(range) && !range.isEmpty()){
                for (Aircraft aircraft : range) {
                    System.out.println(aircraft);
                }
            } else {
                System.out.println("No data by search criteria");
            }
        } else
            System.out.println("There are no data to find aircraft corresponding to the specified range of fuel consumption parameters (liters per hour)");
    }

    private double getEndRange(Scanner scanner) {
        double end   = 0.0; // input data from screen
        System.out.println("Please input maximum range of fuel consumption parameters");
        if(scanner.hasNextDouble())
            end = scanner.nextDouble();
        return end;
    }

    private double getStartRange(Scanner scanner) {
        double start = 0.0; // input data from screen
        System.out.println("Please input minimum range of fuel consumption parameters");
        if(scanner.hasNextDouble())
            start = scanner.nextDouble();
        return start;
    }
}
