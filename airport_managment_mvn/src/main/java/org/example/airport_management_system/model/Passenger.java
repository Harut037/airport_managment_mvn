package org.example.airport_management_system.model;

public class Passenger implements Comparable<Passenger>{

    private int id;
    private String name;
    private String phone;
    private String country;
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Passenger() {

    }


    public Passenger(int id, String name, String phone, String country, String city) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {



        return "Passenger [id = " + id + " name = " + name + " phone = " + phone + " country = " + country + " city = " + city
                + "]" + "\n";
    }

    @Override
    public int compareTo(Passenger o) {
        if (this.id > o.getId()){
            return 1;
        } else if (this.id < o.getId()){
            return -1;
        }
        return 0;
    }
}
