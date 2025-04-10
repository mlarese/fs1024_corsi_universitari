package it.epicode.fs1024_corsi_universitari.corsi;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "corsi")

public class Corso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String descrizione;

    @Column(length = 50, nullable = false)
    private String codiceCorso;

    @Column(length = 50, nullable = false)
    private String docente;

    private LocalDate dataInizio;

    private int numeroMassimoPartecipanti;

}
