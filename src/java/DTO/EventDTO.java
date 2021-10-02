/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;



/**
 *
 * @author Admin
 */
public class EventDTO {
    private int eventId;
    private UserDTO user;
    private String title;
    private String description;
    private LocationDTO location;
    private Date createDatetime;
    private Date startDatetime;

    @Override
    public String toString() {
        return "EventDTO{" + "eventId=" + eventId + ", user=" + user + ", title=" + title + ", description=" + description + ", location=" + location + ", createDatetime=" + createDatetime + ", startDatetime=" + startDatetime + ", endDatetime=" + endDatetime + ", status=" + status + ", picture=" + picture + '}';
    }
    private Date endDatetime;
    private String status;
    private String picture;

    public EventDTO(int eventId, UserDTO user, String title, String description, LocationDTO location, Date createDatetime, Date startDatetime, Date endDatetime, String status, String picture) {
        this.eventId = eventId;
        this.user = user;
        this.title = title;
        this.description = description;
        this.location = location;
        this.createDatetime = createDatetime;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.status = status;
        this.picture = picture;
    }

    

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String statusId) {
        this.status = statusId;
    }
 
    
}