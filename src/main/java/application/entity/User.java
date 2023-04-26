package application.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 30)
    private String firstName;

    @Column
    private String lastName;

    @Column
    private boolean isActive;

    @Column
    private int daysRemained;

    public User() {
    }

    public User(String firstName, String lastName, boolean isActive, int daysRemained) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.daysRemained = daysRemained;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getDaysRemained() {
        return daysRemained;
    }

    public void setDaysRemained(int daysRemained) {
        this.daysRemained = daysRemained;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", daysRemained=" + daysRemained +
                '}';
    }
}
