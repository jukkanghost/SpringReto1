package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepositoryData extends JpaRepository<Mensaje,Integer> {
}
