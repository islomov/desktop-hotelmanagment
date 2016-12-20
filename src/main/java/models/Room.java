package main.java.models;

/**
 * Created by by_dingo on 20.12.2016.
 */
public class Room {

    int number;
    String type;
    int numberOfBadRoom;
    int numberOfKitchen;
    int numberOfBathRoom;
    String dayOfCreation;
    int cost;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfBadRoom() {
        return numberOfBadRoom;
    }

    public void setNumberOfBadRoom(int numberOfBadRoom) {
        this.numberOfBadRoom = numberOfBadRoom;
    }

    public int getNumberOfKitchen() {
        return numberOfKitchen;
    }

    public void setNumberOfKitchen(int numberOfKitchen) {
        this.numberOfKitchen = numberOfKitchen;
    }

    public int getNumberOfBathRoom() {
        return numberOfBathRoom;
    }

    public void setNumberOfBathRoom(int numberOfBathRoom) {
        this.numberOfBathRoom = numberOfBathRoom;
    }

    public String getDayOfCreation() {
        return dayOfCreation;
    }

    public void setDayOfCreation(String dayOfCreation) {
        this.dayOfCreation = dayOfCreation;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
