package com.backOffice_electric_cooperative.demo.infastructure.entities;

import com.backOffice_electric_cooperative.demo.domain.models.Client;
import com.backOffice_electric_cooperative.demo.domain.models.Role;
import com.backOffice_electric_cooperative.demo.domain.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserEntity(long id, String name, String email, String password) {
    }

    public User toDomainModel(){
        return new User(id,name,email,password, role);
    }

    public static UserEntity fromDomainInModel(User user){
        return new UserEntity(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.getEmail();
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
