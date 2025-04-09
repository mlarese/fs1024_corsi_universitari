package it.epicode.fs1024_corsi_universitari.studenti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "studenti")

public class Studente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(  length = 50, nullable = false)
    private String nome;
    @Column( length = 50, nullable = false)
    private String cognome;
    @Column( length = 50, nullable = false)
    private String email;

    @Column( length = 50, nullable = false, unique = true)
    private String matricola;

}
