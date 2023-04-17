package org.example.airport_management_system;

import org.example.airport_management_system.connections.Connections;
import org.example.airport_management_system.service.CompanyService;
import org.example.airport_management_system.model.Passenger;
import org.example.airport_management_system.service.PassengerService;
import org.example.airport_management_system.service.TripService;

public class Main {
    public static void main(String[] args) {
        Passenger passenger = new Passenger();
        Connections connections = new Connections();
        CompanyService cs = new CompanyService();
        PassengerService passengerService = new PassengerService();
        TripService ts = new TripService();
        System.out.println(ts.getAll());



    }

}
