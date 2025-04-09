package it.epicode.fs1024_corsi_universitari.studenti;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudenteRepository extends JpaRepository<Studente, Long> {
    Studente findByEmail(String email);
    Studente findByMatricola(String matricola);
    List<Studente> findByNomeAndCognome(String nome, String cognome);
}
