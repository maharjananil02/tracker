package com.tracker.domain;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Table(name = "tracker")
@Entity
public class Tracker {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="time")
    private long time;



    public void setTitle(String title) {
        this.title = title;
    }


    public void setTime(long time) {
        this.time = time;
    }
}
