package it.epicode.fs1024_corsi_universitari.studenti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudenteService {
    @Autowired
    private StudenteRepository studenteRepository;

}
