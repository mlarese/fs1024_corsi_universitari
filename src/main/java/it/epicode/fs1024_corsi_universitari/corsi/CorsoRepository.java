package it.epicode.fs1024_corsi_universitari.corsi;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorsoRepository extends JpaRepository<Corso, Long> {
    Corso findByNome(String nome);
    Corso findByCodiceCorso(String codiceCorso);
    List<Corso> findByDocente(String docente);
}
