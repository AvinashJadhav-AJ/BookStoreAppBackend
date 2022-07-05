package com.bridgelabz.bookstore.model;

import com.bridgelabz.bookstore.dto.UserRegistrationDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="UserRegistration")
@Data
@NoArgsConstructor
public class UserRegistrationModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String fullName;
    private LocalDate registeredDate;
    private LocalDate updatedDate;
    @Column(name = "email")
    private String emailId;
    private String password;
    private String mobileNo;
    private boolean verify;


   // public UserRegistrationModel() {}

    public UserRegistrationModel(int Id, UserRegistrationDTO userRegistrationDTO)
    {
        this.mobileNo=userRegistrationDTO.getMobileNo();
        this.fullName = userRegistrationDTO.getFullName();
        this.emailId = userRegistrationDTO.getEmailId();
        this.password = userRegistrationDTO.getPassword();
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<AddressModel> addressModelList;
}
