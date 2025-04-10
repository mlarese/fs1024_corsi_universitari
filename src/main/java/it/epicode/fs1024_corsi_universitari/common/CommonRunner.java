package it.epicode.fs1024_corsi_universitari.common;

import it.epicode.fs1024_corsi_universitari.corsi.Corso;
import it.epicode.fs1024_corsi_universitari.corsi.CorsoRepository;
import it.epicode.fs1024_corsi_universitari.iscrizioni.Iscrizione;
import it.epicode.fs1024_corsi_universitari.iscrizioni.IscrizioneRepository;
import it.epicode.fs1024_corsi_universitari.studenti.Studente;
import it.epicode.fs1024_corsi_universitari.studenti.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
public class CommonRunner  implements CommandLineRunner {
    @Autowired
    private CorsoRepository corsoRepository;
    @Autowired
    private IscrizioneRepository iscrizioneRepository;
    @Autowired
    private StudenteRepository studenteRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Corso matematica = new Corso();
        matematica.setNome("Matematica");
        matematica.setDescrizione("Corso di Matematica");
        matematica.setDataInizio(LocalDate.now());
        matematica.setCodiceCorso("MAT101");
        matematica.setDocente("Prof. Rossi");
        matematica.setNumeroMassimoPartecipanti(5);
        Corso corso = corsoRepository.save(matematica);

        Corso scienze = new Corso();
        scienze.setNome("Scienze");
        scienze.setDescrizione("Corso di Scienze");
        scienze.setDataInizio(LocalDate.now());
        scienze.setCodiceCorso("SCI101");
        scienze.setDocente("Prof. Bianchi");
        scienze.setNumeroMassimoPartecipanti(20);
        corsoRepository.save(scienze);

        Studente robertoScussel = new Studente();
        robertoScussel.setNome("Roberto");
        robertoScussel.setCognome("Scussel");
        robertoScussel.setEmail("0aH4e@example.com");
        robertoScussel.setMatricola("123456");
        Studente studente = studenteRepository.save(robertoScussel);

        Studente marcoPallini = new Studente();
        marcoPallini.setNome("Marco");
        marcoPallini.setCognome("Pallini");
        marcoPallini.setEmail("0aH4d@example.com");
        marcoPallini.setMatricola("123457");
        studenteRepository.save(marcoPallini);

        Iscrizione iscrizioneAMatematica = new Iscrizione();
        iscrizioneAMatematica.setCorso(matematica);
        iscrizioneAMatematica.getStudenti().add(robertoScussel);
        iscrizioneRepository.save(iscrizioneAMatematica);

        Iscrizione iscrizioneAScienze = new Iscrizione();
        iscrizioneAScienze.setCorso(scienze);
        iscrizioneAScienze.setStudenti(List.of(robertoScussel, marcoPallini));
        iscrizioneRepository.save(iscrizioneAScienze);

        // Trova il corso di matematica
        System.out.println("------------------");
        System.out.println("Corso di Matematica: " + corsoRepository.findByNome("Matematica"));

        // trova le scrizioni al corso di matematica
        System.out.println("------------------");
        System.out.println("Iscrizioni al corso di Matematica: " +
                iscrizioneRepository.findByCorso_Nome("Matematica"));

        // problema del lazily initialize
        // 1. iscrizioneRepository.findByCorso_Nome cerca tutte le icrizioni che corrispondono al criterio
        //        recupera un'iscrizione in cui il campo corso essendo in relazione ManyToOne (eager) viene subito valorizzato'
        // gli studenti invece sono in una relazione ManyToMany che di default è lazy per cui nel tostring cerca di caricarsi
        // gli studenti con un altra query


        // ricerca per cognome e nome dello studente
        System.out.println("------------------");
        System.out.println("Iscrizioni per cognome e nome dello studente: " +
                iscrizioneRepository.findByStudenti_CognomeAndStudenti_Nome("Scussel", "Roberto"));

        // trova corso per docente
        System.out.println("------------------");
        System.out.println("Corso per docente: "
                + corsoRepository.findByDocente("Prof. Rossi"));

        // trova corsi he hanno un docente in una lista di docenti
        System.out.println("------------------");
        System.out.println("Corsi con docenti in una lista di docenti: "
                + corsoRepository.findByDocenteIn(List.of("Prof. Rossi", "Prof. Bianchi")));

        // cerca i corsi per docente che contengono una certa stringa. E' case sensitive
        System.out.println("------------------");
        System.out.println("Corsi per docente che contengono una certa stringa: "
                + corsoRepository.findByDocenteContains("ossi"));

        // cerca i corsi per docente che contengono una certa stringa sbagliando maiuscole e minuscoleE' case sensitive
        System.out.println("------------------");
        System.out.println("Corsi per docente che contengono una certa stringa: "
                + corsoRepository.findByDocenteContains("rossi"));

        // cerca i corsi per docente che contengono una certa stringa non case sensitive
        System.out.println("------------------");
        System.out.println("Corsi per docente che contengono una certa stringa: "
                + corsoRepository.findByDocenteContainsIgnoreCase("rossi"));


        // trova i cori che hanno il numero massimo di partecipanti compreso tra x e y
        System.out.println("------------------");
        System.out.println("Corsi con numero massimo di partecipanti compreso tra 5 e 15: "
                + corsoRepository.findByNumeroMassimoPartecipantiBetween(5, 15));

        // trova i corsi in cui il numero massimo di partecipanti è minore di x
        System.out.println("------------------");
        System.out.println("Corsi con numero massimo di partecipanti minore di 10: "
                + corsoRepository.findByNumeroMassimoPartecipantiLessThan(10));

        // trova i corsi in cui il numero massimo di partecipanti è minore o uguale a x
        System.out.println("------------------");
        System.out.println("Corsi con numero massimo di partecipanti minore o uguale a 5: "
                + corsoRepository.findByNumeroMassimoPartecipantiLessThanEqual(5));

        // sezione conteggi
        // quanti corsi esistono in totale
        System.out.println("------------------");
        System.out.println("Corsi esistenti: " + corsoRepository.count());


        // conta quanti corsi sono tenuti dal docente "Prof. Rossi"
        System.out.println("------------------");
        System.out.println("Corsi tenuti dal docente Prof. Rossi: " +
                corsoRepository.countByDocente("Prof. Rossi"));

        // quanti corsi esistono con numero max partecipanti tra 5 e 15
        System.out.println("------------------");
        System.out.println("Corsi con numero massimo di partecipanti compreso tra 5 e 15: "
                + corsoRepository.countByNumeroMassimoPartecipantiBetween(5, 15));

        // SEZIONE EXISTS
        // verifica se esiste un corso con un certo nome
        System.out.println("------------------");
        System.out.println("Esiste un corso con nome Matematica: " +
                corsoRepository.existsByNomeIgnoreCase("matematica"));


        // SEZIONE QUERY CUSTOM
        // trova i corsi  con nome x tenuti e docente y
        System.out.println("------------------");
        System.out.println("Corsi con nome Matematica e docente Prof. Rossi: "
                + corsoRepository.findByDocAndNom("Matematica", "Prof. Rossi"));


    }
}
