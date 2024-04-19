package org.dmitriy.prack15.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departure")
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private PostOffice postOffice;

    public Departure() {
    }

    public void setPostOffice(PostOffice postOffice) {
        this.postOffice = postOffice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Departure{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
