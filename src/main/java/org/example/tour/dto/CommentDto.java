package org.example.tour.dto;

import lombok.Data;


@Data
public class CommentDto {
    private String text;
    private String title;
    private String firstName;
    private String lastName;
    private int stars;

}
