package org.launchcode.demobackend.models;

import javax.persistence.Entity;

@Entity
public class Project extends NamedEntity {

    private String roomType;
    private double roomLength;
    private double roomWidth;
    private double roomHeight;

    public Project() {}

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getRoomLength() {
        return roomLength;
    }

    public void setRoomLength(double roomLength) {
        this.roomLength = roomLength;
    }

    public double getRoomWidth() {
        return roomWidth;
    }

    public void setRoomWidth(double roomWidth) {
        this.roomWidth = roomWidth;
    }

    public double getRoomHeight() {
        return roomHeight;
    }

    public void setRoomHeight(double roomHeight) {
        this.roomHeight = roomHeight;
    }
}
