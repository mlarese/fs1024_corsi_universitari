package it.epicode.fs1024_corsi_universitari.iscrizioni;


import it.epicode.fs1024_corsi_universitari.corsi.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IscrizioneRepository extends JpaRepository<Iscrizione, Long> {
    Iscrizione findByCorso(Corso corso);
}
