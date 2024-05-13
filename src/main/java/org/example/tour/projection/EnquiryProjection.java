package org.example.tour.projection;

import java.util.UUID;

public interface EnquiryProjection {
    UUID getId();
    String getFirstName();
    String getLastName();
    String getPhone();
    String getEmail();
    String getText();
    UUID getTourId();
}
