package org.example.tour.projection;

import java.time.LocalDate;
import java.util.UUID;

public interface UserProjection {
   UUID getId();
   String getFirstName();
   String getPhone();
   String getChaqiruv();
   LocalDate getRegisterTime();


}
