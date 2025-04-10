package it.epicode.fs1024_corsi_universitari.iscrizioni;

import it.epicode.fs1024_corsi_universitari.corsi.Corso;
import it.epicode.fs1024_corsi_universitari.studenti.Studente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "iscrizioni")

public class Iscrizione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany
    private List<Studente> studenti = new ArrayList<>();

    @ManyToOne
    private Corso corso;

}
