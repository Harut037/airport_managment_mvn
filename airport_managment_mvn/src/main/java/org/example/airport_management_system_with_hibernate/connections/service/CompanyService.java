package org.example.airport_management_system_with_hibernate.connections.service;



import org.example.airport_management_system_with_hibernate.connections.configuration.Configurations;
import org.example.airport_management_system_with_hibernate.connections.model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;



import java.util.List;


import org.hibernate.query.Query;






public class CompanyService {

    Configuration config;
    SessionFactory sessionFactory;

    /**
     * Method init configs
     */
    public CompanyService() {
        config = Configurations.getConfiguration();
        sessionFactory = Configurations.getSessionFactory();
    }

    /**
     * Method gets Company by ID
     * @param id
     * @return
     */
    public Company getById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Company company = session.get(Company.class,id);
        session.getTransaction().commit();
        session.close();
        return company;
    }

    /**
     * Method get's all Companies from table
     * @return
     */
    public List<Company> getAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Company ");
        session.beginTransaction();
        List<Company> companyList = query.list();
        session.getTransaction().commit();
        session.close();
        return companyList;
    }

    /**
     * This method saving
     * @param company
     * @return
     */
    public Company companySave(Company company){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        session.close();
        return company;
    }

    /**
     * Method updates Company
     * @param id
     * @param company
     * @return
     */
public Company companyUpdate(Company company, int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        company.setId(id);
        session.update(company);
        session.getTransaction().commit();
        session.close();
        return company;
}


    /**
     * Method deletes Company by ID
     * @param id
     */
public void companyDelete(int id){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.delete(session.get(Company.class,id));
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


