package org.dmitriy.prack15.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class PostOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cityName;
    @OneToMany(mappedBy = "postOffice", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Departure> departures = new ArrayList<>();

    public PostOffice() {
    }

    public void AddDeparture(Departure departure) {
        departure.setPostOffice(this);
        departures.add(departure);
    }

    public List<Departure> getDepartures() {
        return departures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "PostOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cityName='" + cityName + '\'' + ' ' + departures.toString() +
                '}';
    }
}
