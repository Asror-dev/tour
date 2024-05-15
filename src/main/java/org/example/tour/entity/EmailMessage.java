package org.example.tour.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String textMessage;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Enquiry enquiry;
}
