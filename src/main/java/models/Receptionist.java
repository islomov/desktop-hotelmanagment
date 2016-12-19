package main.java.models;

/**
 * Created by by_dingo on 18.12.2016.
 */
public class Receptionist {
    String userName;
    String password;
    String firstName;
    String lastName;
    String gender;
    String experience;
    boolean isMarried;
    String birthday;
    String hash_id;
    String married;

    public Receptionist() {
        hash_id = String.valueOf(hashCode());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHash_id() {
        return hash_id;
    }

    public void setHash_id(String hash_id) {
        this.hash_id = hash_id;
    }

    public String getMarried() {
        if (isMarried())
            setMarried("Yes");
        else
            setMarried("No");
        return married;
    }

    private void setMarried(String married) {
        this.married = married;
    }
}
