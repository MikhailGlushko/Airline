package ua.glushko.service;

import ua.glushko.dao.AircraftGenericDAO;
import ua.glushko.model.Aircraft;

import java.util.*;

/**
 * Aircraft Service
 * @author Mikhail Glushko
 * @version 1.0
 */
public class AircraftService {

    private final AircraftGenericDAO dao;

    private final Comparator<Aircraft> aircraftFlightRangeComparator = (o1, o2) -> Double.compare(o1.getFlightRange(), o2.getFlightRange());

    public AircraftService(AircraftGenericDAO dao) {
        this.dao = dao;
    }

    public List<Aircraft> getAircraftList() {
        return dao.read();
    }

    public void sortAircraftByFlight(List<Aircraft> aircraftList) {
        aircraftList.sort(aircraftFlightRangeComparator);
    }

    public List<Aircraft> findAircraftByFlightRange(List<Aircraft> aircraftList, double start, double end) {
        List<Aircraft> result = new ArrayList<>();
        int i = Collections.binarySearch(aircraftList, new Aircraft() {{
            setFlightRange(start);
        }}, aircraftFlightRangeComparator);
        int j = Collections.binarySearch(aircraftList, new Aircraft() {{
            setFlightRange(end);
        }}, aircraftFlightRangeComparator);
        if(i==j && i<0)
            return result;
        i = (i < 0) ? Math.abs(i + 1) : i;
        j = (j < 0) ? Math.abs(j + 2) : j;
        j = (j >= aircraftList.size()) ? aircraftList.size() - 1 : j;
        while (i <= j)
            result.add(aircraftList.get(i++));
        return result;
    }

    public Double[] calculate() {
        double capacity = 0.0;
        double carrying = 0.0;
        List<Aircraft> aircraftList = dao.read();
        if (Objects.nonNull(aircraftList) && !aircraftList.isEmpty()) {
            for (Aircraft aircraft : aircraftList) {
                capacity += aircraft.getCapacity();
                carrying += aircraft.getCarrying();
            }
        }
        return new Double[]{capacity, carrying};
    }
}
