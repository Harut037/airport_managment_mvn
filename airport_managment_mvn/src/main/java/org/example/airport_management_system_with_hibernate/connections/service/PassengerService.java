package org.example.airport_management_system_with_hibernate.connections.service;


import jakarta.persistence.TypedQuery;
import org.example.airport_management_system_with_hibernate.connections.configuration.Configurations;
import org.example.airport_management_system_with_hibernate.connections.model.Company;
import org.example.airport_management_system_with_hibernate.connections.model.PassInTrip;
import org.example.airport_management_system_with_hibernate.connections.model.Passenger;
import org.example.airport_management_system_with_hibernate.connections.model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class PassengerService {
    Configuration configuration;
    SessionFactory sessionFactory;

    public PassengerService() {
        configuration = Configurations.getConfiguration();
        sessionFactory = Configurations.getSessionFactory();
    }

    /**
     * Method gets Passenger by ID
     * @param id
     * @return
     */

    public Passenger getById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Passenger passenger = session.get(Passenger.class, id);
        session.close();
        return passenger;
    }

    /**
     * Method get's all Passengers from table
     * @return
     */

    public List<Passenger> getAll(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Passenger ");
        session.beginTransaction();
        List<Passenger> listPassengers = query.list();
        session.getTransaction().commit();
        session.close();
        return listPassengers;

    }


    /**
     * Method deletes by ID
     * @param id
     */
    public void deletePassenger(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(session.get(Passenger.class,id));
        session.getTransaction().commit();
        session.close();

    }


    /**
     * This method saving
     * @param passenger
     * @return
     */
    public Passenger savePassenger(Passenger passenger){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(passenger);
        session.getTransaction().commit();
        session.close();
        return passenger;
    }


    /**
     * Method updates passenger table by ID
     * @param passenger
     * @param id
     * @return
     */
    public Passenger updatePassenger (Passenger passenger, int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        passenger.setId(id);
        session.update(passenger);
        session.getTransaction().commit();
        session.close();
        return passenger;
    }

    /**
     * Method register new Trip
     * @param tripId
     * @param trip
     * @param passenger
     */
    public void registerTrip(int tripId, Trip trip, Passenger passenger){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(passenger);
        trip.setId(tripId);
        session.save(trip);
        PassInTrip passInTrip = new PassInTrip(trip.getId(), passenger.getId(), "01.11.2002", "6a");
        session.save(passInTrip);
        session.getTransaction().commit();
        session.close();

    }



    /**
     * Method gets Passengers
     * @param offset
     * @param perPage
     * @param sort
     * @return
     */
    public	List<Passenger> get(int offset, int perPage, String sort) {
        Session session = sessionFactory.openSession();
        String jpqlQuery = "SELECT p FROM Passenger p WHERE p.id >= :offset ORDER BY p." + sort;
        session.beginTransaction();
        TypedQuery<Passenger> typedQuery = session.createQuery(jpqlQuery,Passenger.class);
        typedQuery.setParameter("offset", offset);
        typedQuery.setMaxResults(perPage);
        List<Passenger> passengersList = typedQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return passengersList;
    }

    /**
     * Method cancels Trip
     * @param passengerId
     * @param tripNumber
     */
    public void cancelTrip(int passengerId, int tripNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Trip trip = session.get(Trip.class, tripNumber);
        Passenger passenger = session.get(Passenger.class, passengerId);
        PassInTrip passInTrip = session.get(PassInTrip.class, tripNumber);
        session.delete(trip);
        session.delete(passenger);
        session.delete(passInTrip);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Method closes All Configs
     */
    public void closeAllConfigs() {
        Configurations.closeSessionFactory();
        Configurations.closeConfiguration();
    }

}





