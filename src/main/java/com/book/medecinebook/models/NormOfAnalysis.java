package com.book.medecinebook.models;


import com.book.medecinebook.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class NormOfAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Analysis analysis;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int minAge;
    private int maxAge;
    private double minNorm;
    private double maxNorm;
}
