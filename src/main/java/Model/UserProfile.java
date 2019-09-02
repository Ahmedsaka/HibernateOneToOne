package Model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "User_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "up_id")
    private Long up_id;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String address;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "userProfile")
    private User user;

    public UserProfile() {}

    public UserProfile(String phoneNumber, String address,  LocalDate dateOfBirth) {
        this.phoneNumber = phoneNumber;
      //  this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Long getUp_id() {
        return up_id;
    }

    public void setUp_id(Long up_id) {
        this.up_id = up_id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
/*
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
*/
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    /*
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender; */

    @Override
    public String toString() {
        return "UserProfile{" +
                "up_id=" + up_id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
               ", dateOfBirth=" + dateOfBirth +
                ", user=" + user +
                '}';
    }
}
