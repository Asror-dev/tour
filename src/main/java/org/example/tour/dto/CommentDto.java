package org.example.tour.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CommentDto {
    private String text;
    private String firstName;
    private String lastName;
}
