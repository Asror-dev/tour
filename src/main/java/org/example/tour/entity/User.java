package org.example.tour.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tour.entity.enums.Language;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @NotEmpty(message = "Firstname cannot be empty")
    private String firstName;
    @NotEmpty
    @NotNull
    private String lastName;
    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,15}$", message = "Phone number is not valid")
    private String phone;
    @NotEmpty
    @NotNull
    private String password;
    @Enumerated(EnumType.STRING)
    private Language language;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return phone;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
