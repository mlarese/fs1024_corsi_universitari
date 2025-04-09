package it.epicode.fs1024_corsi_universitari.corsi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CorsoServiceTest {
    @Autowired
    private CorsoService corsoService;

    @Autowired
    private CorsoRepository corsoRepository;

    @BeforeEach
    public void setUp() {
        corsoRepository.deleteAll();
    }

    @Test
    @DisplayName("Test di creazione e salvataggio di un Corso")
    public void testSave() {
        LocalDate dataInizio = LocalDate.now();

        Corso corso = new Corso();
        corso.setNome("Corso di Test");
        corso.setCodiceCorso("TEST123");
        corso.setDocente("Docente di Test");
        corso.setDescrizione("Descrizione del Corso di Test");
        corso.setDataInizio(dataInizio);

        corsoService.save(corso);

        assertNotNull(corso.getId());

        Corso savedCorso = corsoService.findById(corso.getId());
        assertNotNull(savedCorso);
        assertEquals( "Corso di Test" , savedCorso.getNome());
        assertEquals( "TEST123" , savedCorso.getCodiceCorso());
        assertEquals( "Docente di Test" , savedCorso.getDocente());
        assertEquals( "Descrizione del Corso di Test" , savedCorso.getDescrizione());
        assertEquals( dataInizio , savedCorso.getDataInizio());
    }

}
