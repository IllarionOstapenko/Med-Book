package com.book.medecinebook.models;


import com.book.medecinebook.enums.Gender;
import com.book.medecinebook.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("PATIENT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient extends User {
    @Column(length = 25)
    private String surname;
    @Column(length = 25)
    private String fatherName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String image;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patient")
    @JsonIgnore
    private List<VisitToDoctor> visitToDoctorList = new ArrayList<VisitToDoctor>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patient")
    @JsonIgnore
    private List<ResultOfAnalysis> resultOfAnalyses = new ArrayList<>();


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

    @Override
    public String toString() {
        return "Patient{" +
                "surname='" + surname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", gender=" + gender +
                ", image='" + image + '\'' +
                ", role=" + role +
                ", dateOfBirth=" + getDateOfBirth() +
                ", visitToDoctorList=" + visitToDoctorList +
                '}';
    }
}
