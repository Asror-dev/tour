package org.example.tour.projection;

import java.util.UUID;

public interface CommentProjection {
    UUID getId();
    String getFirstName();
    String getLastName();
    Boolean getVisible();
    String getText();
    UUID getTourId();
}
