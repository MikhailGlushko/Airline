package ua.glushko.dao;

import ua.glushko.model.Aircraft;

import java.io.*;
import java.util.*;

/**
 * Aircraft DAO implementation
 */
public class AircraftDAO implements AircraftGenericDAO {

    private static final String databaseName = "airline.db";
    private static final Map<String, Aircraft> database = restoreDataFromFile();

    @Override
    public Aircraft read(String serialNumber) {
        if(Objects.nonNull(database) && Objects.nonNull(serialNumber) && database.size()!=0)
            return database.get(serialNumber);
        return null;
    }

    @Override
    public List<Aircraft> read() {
        if(Objects.nonNull(database) && database.size()!=0)
            return new ArrayList<>(database.values());
        return null;
    }

    @Override
    public Aircraft update(Aircraft aircraft) {
        if(Objects.nonNull(database) && Objects.nonNull(aircraft) && database.size()!=0 && database.containsKey(aircraft.getSerialNumber())){
            Aircraft old = database.get(aircraft.getSerialNumber());
            database.put(aircraft.getSerialNumber(), aircraft);
            return old;
        }
        return null;
    }

    @Override
    public Aircraft delete(String serialNumber) {
        if(Objects.nonNull(database) && Objects.nonNull(serialNumber) && database.size()!=0 && database.containsKey(serialNumber)){
            Aircraft old = database.get(serialNumber);
            database.remove(serialNumber);
            return old;
        }
        return null;
    }

    @Override
    public void create(Aircraft aircraft) {
        if(Objects.nonNull(database) && Objects.nonNull(aircraft) && !database.containsKey(aircraft.getSerialNumber())){
            database.put(aircraft.getSerialNumber(), aircraft);
            return;
        }
    }

    public void storeDataToFile() {
        List<Aircraft> aircraftList = read();
        if (Objects.nonNull(aircraftList) && !aircraftList.isEmpty()) {
            File f = new File(databaseName);
            try (FileOutputStream fos = new FileOutputStream(f); ObjectOutputStream oos =  new ObjectOutputStream(fos) ){
                for (Aircraft aircraft : aircraftList) {
                    oos.writeObject(aircraft);
                }
            } catch (IOException e) {
            }
        }
    }

    private static Map<String, Aircraft> restoreDataFromFile(){
        Map<String, Aircraft> database = new HashMap<>();
        File f = new File(databaseName);
        try(FileInputStream fis = new FileInputStream(f); ObjectInputStream ois = new ObjectInputStream(fis)){
            Object object;
            while ((object = ois.readObject()) !=null){
                if(object instanceof Aircraft){
                    Aircraft aircraft = (Aircraft) object;
                    database.put(aircraft.getSerialNumber(),aircraft);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            return database;
        }
        return database;
    }
}
