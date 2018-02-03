package ua.glushko.dao;

import ua.glushko.model.Aircraft;

import java.util.List;

/**
 * Aircraft DAO interface
 * @author Mikhail Glushko
 * @version 1.0
 */
public interface AircraftGenericDAO {
    Aircraft read(String serialNumber);
    List<Aircraft> read();
    Aircraft update(Aircraft aircraft);
    Aircraft delete(String serialNumber);
    void create(Aircraft aircraft);
    void storeDataToFile();
}
