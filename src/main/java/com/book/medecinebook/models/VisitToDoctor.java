package com.book.medecinebook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VisitToDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateOfVisit;
    private String timeOfVisit;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Doctor doctor;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Patient patient;


}
