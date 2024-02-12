package com.banana.bananawhatsapp.persistencia.mensaje;

import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;
import java.util.List;

public interface MensajeRepositoryData extends JpaRepository<Mensaje,Integer>, CustomMensajeRepository{
}
