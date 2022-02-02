package org.hibernate.tutorial.hbm;

import java.util.Date;

public class Event {
    private Long id;

    private String title;
    private Date date;

    public Event() {

    }

    public Event(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
