package it.epicode.fs1024_corsi_universitari.corsi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorsoService {
    @Autowired
    private CorsoRepository corsoRepository;

    public Corso findById(Long id) {
        return corsoRepository.findById(id).orElse(null);
    }

    public Corso findByNome(String nome) {
        return corsoRepository.findByNome(nome);
    }
    public Corso findByCodiceCorso(String codiceCorso) {
        return corsoRepository.findByCodiceCorso(codiceCorso);
    }

    public List<Corso> findByDocente(String docente) {
        return corsoRepository.findByDocente(docente);
    }

    public void save(Corso corso) {
        if(corso.getNome() == null) {
            throw new IllegalArgumentException("Il nome del corso non può essere nullo");
        }

        if(corso.getCodiceCorso() == null) {
            throw new IllegalArgumentException("Il codice del corso non può essere nullo");
        }

        if(corso.getDocente() == null) {
            throw new IllegalArgumentException("Il nome del docente non può essere nullo");
        }

        corsoRepository.save(corso);
    }


}
