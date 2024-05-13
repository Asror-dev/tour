package org.example.tour.projection;

import java.util.UUID;

public interface TourDayProjection {
    UUID getId();
    String getTitle();
    String getDescription();
    String getPath();


}
