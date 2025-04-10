package it.epicode.fs1024_corsi_universitari.corsi;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CorsoRepository extends JpaRepository<Corso, Long> {
    // cerca i corsi per nome
    Corso findByNome(String nome);

    // cerca i corsi per codice corso
    Corso findByCodiceCorso(String codiceCorso);

    // cerca i corsi per codice corso che contengono una certa stringa. E' case sensitive
    List<Corso> findByCodiceCorsoContains(String codiceCorso);
    // cerca i corsi per codice corso che contengono una certa stringa. Non è case sensitive
    List<Corso> findByCodiceCorsoContainsIgnoreCase(String codiceCorso);

    // cerca i corsi per docente
    List<Corso> findByDocente(String docente);

    // cerca i corsi per docente . Non è case sensitive
    List<Corso> findByDocenteIgnoreCase(String docente);

    // cerca i corsi per docente che contengono una certa stringa. E' case sensitive
    List<Corso> findByDocenteContains(String docente);

    // cerca i corsi per docente che contengono una certa stringa. non è case sensitive
    List<Corso> findByDocenteContainsIgnoreCase(String docente);


    // trova i corsi all'interno di un certo intervallo di date di inizio
    List<Corso> findByDataInizioBetween(LocalDate start, LocalDate end);

    // trova i corsi che hanno un docente in una lista di docenti
    List<Corso> findByDocenteIn(List<String> docenti);

    // trova i corsi che hanno un docente in una lista di docenti e ordina per docente
    List<Corso> findByDocenteInOrderByDocenteAsc(List<String> docenti);

    // trova i corsi che hanno un docente in una lista di docenti e ordina per docente decrescente
    List<Corso> findByDocenteInOrderByDocenteDesc(List<String> docenti);

    // trova i corsi che hanno un docente in una lista di docenti e ordina per nome
    List<Corso> findByDocenteInOrderByNomeAsc(List<String> docenti);

    // trova i corsi dove il numero di partecipanti e minore di num
    List<Corso> findByNumeroMassimoPartecipantiLessThan(int num);

    // trova i corsi dove il numero di partecipanti e maggiore di num
    List<Corso> findByNumeroMassimoPartecipantiGreaterThan(int num);

    // trova i corsi dove il numero di partecipanti e uguale a num
    List<Corso> findByNumeroMassimoPartecipantiEquals(int num);

    // trova i corsi dove il numero di partecipanti e minore o uguale a num
    List<Corso> findByNumeroMassimoPartecipantiLessThanEqual(int num);

    // trova i corsi dove il numero di partecipanti  è in un intervallo
    List<Corso> findByNumeroMassimoPartecipantiBetween(int start, int end);

    // trova i corsi dove il numero di partecipanti  è in un intervallo in ordine crescente di numero massimo partecipanti
    List<Corso> findByNumeroMassimoPartecipantiBetweenOrderByNumeroMassimoPartecipantiAsc(int start, int end);

    // sezione count

    // trova quanti corsi esistono del docente x
    int countByDocente(String docente);
    // trova quanti corsi esistono con numero partecipanti fra x e y
    int countByNumeroMassimoPartecipantiBetween(int start, int end);

    // verifica se esiste un corso con un certo nome
    boolean existsByNome(String nome);

    // verifica se esiste un corso con un certo nome non case sensitive
    boolean existsByNomeIgnoreCase(String nome);


    // verifica se esiste un corso con numero massimo partecipanti compreso tra x e y
    boolean existsByNumeroMassimoPartecipantiBetween(int start, int end);


    // QUERY CUSTOM
    // con una query custom trova i corsi che hanno un certo nome e un certo docente
    @Query("SELECT c FROM Corso c WHERE c.nome = :nome AND c.docente = :docente")
    List<Corso> findByDocAndNom(String nome, String docente);


}
