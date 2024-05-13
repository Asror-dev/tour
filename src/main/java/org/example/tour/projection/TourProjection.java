package org.example.tour.projection;

import java.util.List;
import java.util.UUID;

public interface TourProjection {
    UUID getId();
    String getTitle();
    String getDescription();
    Double price();
    List<String> getImagesPath();
    String getVideoPath();
}
