package org.example.tour.services.userService;


import lombok.RequiredArgsConstructor;

import org.example.tour.dto.LoginDto;
import org.example.tour.dto.RegisterDto;
import org.example.tour.entity.Role;
import org.example.tour.entity.User;
import org.example.tour.repository.RoleRepo;
import org.example.tour.repository.UserRepo;
import org.example.tour.security.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;



    @Override
    public User getUserByPhone(String phone) {
        Optional<User> byPhone = userRepo.findByPhone(phone);
        return byPhone.orElseThrow();
    }

    @Override
    public Map<?, ?> login(LoginDto loginDto) {
        User user = userRepo.findByPhone(loginDto.getPhone()).orElseThrow();
        UUID id = user.getId();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getPhone(),
                        loginDto.getPassword()
                )
        );
        String jwt = jwtService.generateJwt(id.toString());
        String refreshJwt = jwtService.generateRefreshJwt(id.toString());
        return Map.of("access_token", jwt, "refresh_token", refreshJwt);
    }



    //Hozircha kerak emas addUser function
    @Override
    public void addUser(RegisterDto registerDto) {
        Role roleUser = roleRepo.findByName("ROLE_USER").orElseThrow();
        User user = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setPhone(registerDto.getPhone());
        user.setRoles(List.of(roleUser));
        userRepo.save(user);

    }







}
