package org.example.airport_management_system_with_hibernate.connections;

import org.example.airport_management_system.connections.Connections;
import org.example.airport_management_system.model.Passenger;
import org.example.airport_management_system_with_hibernate.connections.service.CompanyService;
import org.example.airport_management_system_with_hibernate.connections.service.PassengerService;
import org.example.airport_management_system_with_hibernate.connections.service.TripService;

public class Main {
    public static void main(String[] args) {
        CompanyService cs = new CompanyService();
//        System.out.println(cs.getAll());

        TripService ts = new TripService();
        System.out.println(ts.getTripsTo("Paris"));

    }

}
