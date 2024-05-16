package org.example.tour.services.userService;







import org.example.tour.dto.LoginDto;
import org.example.tour.dto.RegisterDto;
import org.example.tour.entity.User;
import org.example.tour.entity.enums.Language;


import java.util.Map;
import java.util.UUID;

public interface UserService {
    User getUserByPhone(String phone);
    Map<?,?> login(LoginDto loginDto);
    void addUser(RegisterDto registerDto);

    void changeUserLanguage(Language language, UUID userId);

}
