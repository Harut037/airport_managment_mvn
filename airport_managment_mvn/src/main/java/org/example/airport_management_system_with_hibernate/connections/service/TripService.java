package org.example.airport_management_system_with_hibernate.connections.service;

import org.example.airport_management_system.connections.Connections;
import org.example.airport_management_system_with_hibernate.connections.configuration.Configurations;
import org.example.airport_management_system_with_hibernate.connections.model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class TripService {

   Configuration configuration;
    SessionFactory sessionFactory;

    public TripService(){
        configuration = Configurations.getConfiguration();
        sessionFactory = Configurations.getSessionFactory();
    }

    /**
     * Method gets Trip by ID
     * @param id
     * @return
     */
    public Trip getById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Trip trip = session.get(Trip.class, id);
        session.getTransaction().commit();
        session.close();
        return trip;
    }

    /**
     * Method get's all Trips from table
     * @return
     */
    public List<Trip> getAll(){
        Session session = sessionFactory.openSession();
       Query query = session.createQuery("FROM Trip");
        session.beginTransaction();
        List<Trip> allTrip = query.list();
        session.getTransaction().commit();
        session.close();
        return allTrip;
    }


    /**
     * Method deletes Trip
     * @param id
     */
    public void deleteTrip(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(session.get(Trip.class,id));
        session.getTransaction().commit();
        session.close();
}


    /**
     * Method updates Trip
     * @param id
     * @param trip
     * @return
     */
public Trip update(Trip trip, int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        trip.setId(id);
        session.update(trip);
        session.getTransaction().commit();
        session.close();
        return trip;
}


    /**
     * Method saves new Trip
     * @param trip
     * @return
     */
public void saveTrip(Trip trip){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(trip);
        session.getTransaction().commit();
        session.close();

}

    /**
     * Method gets Trips From city
     * @param city
     * @return
     */
    public List<Trip> getTripsFrom(String city) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select trip FROM Trip trip WHERE trip.townFrom = ?1");
        session.beginTransaction();
        query.setParameter(1,city);
        List<Trip> tripList = query.list();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    /**
     * Method gets Trips To city
     * @param city
     * @return
     */
    public List<Trip> getTripsTo(String city){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT trip FROM Trip trip WHERE trip.townTo = ?1");
        session.beginTransaction();
        query.setParameter(1,city);
        List<Trip> trips = query.list();
        session.getTransaction().commit();
        session.close();
        return trips;

    }

    /**
     * Method closes All Configs
     */
    public void closeAllConfigs() {
        Configurations.closeSessionFactory();
        Configurations.closeConfiguration();
    }

    }

