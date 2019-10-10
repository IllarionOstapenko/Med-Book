package com.book.medecinebook.models;

import com.book.medecinebook.enums.Gender;
import com.book.medecinebook.enums.Role;
import com.book.medecinebook.enums.Speciality;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("DOCTOR")

public class Doctor extends User {
    @Column(length = 25)
    private String surname;
    @Column(length = 25)
    private String fatherName;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String image;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "doctor")
    @JsonIgnore
    private List<VisitToDoctor> visitToDoctorList = new ArrayList<VisitToDoctor>();



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
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
