package org.example.airport_management_system_with_hibernate.connections.model;

import jakarta.persistence.*;


@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "founding_date")
    private String foundingDate;

    /**
     * Default Constructor
     */
    public Company() {

    }

    /**
     * @param companyName
     * @param foundingDate
     */
    public Company(String companyName, String foundingDate) {
        super();
        this.companyName = companyName;
        this.foundingDate = foundingDate;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the foundingDate
     */
    public String getFoundingDate() {
        return foundingDate;
    }

    /**
     * @param foundingDate the foundingData to set
     */
    public void setFoundingDate(String foundingDate) {
        this.foundingDate = foundingDate;
    }

    @Override
    public String toString() {
        return "Company [id = " + id + ", companyName = " + companyName + ", foundingDate = " + foundingDate + "]\n";
    }    }


