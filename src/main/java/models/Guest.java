package main.java.models;

/**
 * Created by by_dingo on 20.12.2016.
 */
public class Guest {

    String hashId;
    String receptionistHasId;
    String name;
    String gender;
    String birthday;
    String arrivalDay;
    String roomType;
    int countDay;
    int totalPrice;
    int roomNumber;
    Room room;

    public Guest() {
        this.hashId = String.valueOf(hashCode());
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getReceptionistHasId() {
        return receptionistHasId;
    }

    public void setReceptionistHasId(String receptionistHasId) {
        this.receptionistHasId = receptionistHasId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getArrivalDay() {
        return arrivalDay;
    }

    public void setArrivalDay(String arrivalDay) {
        this.arrivalDay = arrivalDay;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getCountDay() {
        return countDay;
    }

    public void setCountDay(int countDay) {
        this.countDay = countDay;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
