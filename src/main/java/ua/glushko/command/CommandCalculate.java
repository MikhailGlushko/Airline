package ua.glushko.command;

import ua.glushko.dao.AircraftDAO;
import ua.glushko.dao.AircraftGenericDAO;
import ua.glushko.service.AircraftService;

import java.util.Objects;

/**
 * Command to calculate total capacity and carrying capacity of all the aircraft in the airline
 * @author Mikhail Glushko
 * @version 1.0
 */
public class CommandCalculate implements Command {
    @Override
    public void execute() {
        AircraftGenericDAO dao = new AircraftDAO();
        AircraftService aircraftService = new AircraftService(dao);
        Double[] calculate = aircraftService.calculate();
        if(Objects.nonNull(calculate) && calculate.length==2)
            System.out.printf("Total capacity = %f and carrying capacity = %f of all the aircraft in the airline",calculate[0],calculate[1]);
        else
            System.out.println("Error calculate total capacity and carrying capacity of all the aircraft in the airline");
        System.out.println();
    }
}
