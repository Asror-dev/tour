package org.example.tour.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity(name = "enquiry")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotEmpty(message = "Firstname cannot be empty")
    private String firstName;
    private String lastName;
    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,15}$", message = "Phone number is not valid")
    private String phone;
    @NotEmpty(message = "Email cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email should be valid")
    private String email;
    private String text;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Tour tour;

    @OneToMany(mappedBy = "enquiry",fetch =FetchType.EAGER)
    @JsonIgnore
    private List<EmailMessage> tourDays;
}
