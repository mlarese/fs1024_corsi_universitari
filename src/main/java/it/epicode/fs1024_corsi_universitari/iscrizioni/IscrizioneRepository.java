package it.epicode.fs1024_corsi_universitari.iscrizioni;


import it.epicode.fs1024_corsi_universitari.corsi.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IscrizioneRepository extends JpaRepository<Iscrizione, Long> {
    // trova tutte le iscrizioni ad un certo corso
    List<Iscrizione> findByCorso(Corso corso);
    // fa una ricerca per nome del corso
    List<Iscrizione> findByCorso_Nome(String nomeCorso);
    List<Iscrizione> findByStudenti_CognomeAndStudenti_Nome(String cognome, String nome);
}
