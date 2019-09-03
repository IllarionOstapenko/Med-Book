//package com.book.medecinebook.models;
//
//import com.book.medecinebook.constants.gender.Gender;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.joda.time.DateTime;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class Patient implements UserDetails {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String name;
//    private String surname;
//    private String fatherName;
//    private String image;
//    @Column(unique = true)
//    private String username;
//    private String password;
//    private int phone;
//    private DateTime dateOfBirth;
//    //    @ElementCollection
//    @Enumerated(EnumType.STRING)
//    private Gender gender;
//    @Enumerated(EnumType.STRING)
//    private Role role;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(Role.ROLE_DOCTOR.name()));
//        return authorities;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
