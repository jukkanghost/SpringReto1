package com.banana.bananawhatsapp.persistencia.extended;

import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositoryData extends JpaRepository<Usuario, Integer>, CustomUsuarioRepository {
}