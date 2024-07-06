package org.example.tour.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String firstName;
    @NotEmpty(message = "Lastname cannot be empty")
    @NotNull
    private String lastName;
    @NotNull(message = "Phone number cannot be null")
    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(
            regexp = "^(\\+\\d{1,3}[- ]?)?(\\(?\\d{1,4}\\)?[- ]?)?\\d{1,4}[- ]?\\d{1,4}[- ]?\\d{1,9}$",
            message = "Phone number is not valid"
    )
    private String phone;
    @NotNull
    @NotEmpty(message = "Email cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email should be valid")
    private String email;
    @NotNull
    @NotEmpty(message = "Text cannot be empty")
    @Column(length = 1000)
    private String text;


    @ManyToOne
    @PrimaryKeyJoinColumn
    private Tour tour;

    @OneToMany(mappedBy = "enquiry",fetch =FetchType.EAGER)
    @JsonManagedReference
    private List<EmailMessage> emails;
}
