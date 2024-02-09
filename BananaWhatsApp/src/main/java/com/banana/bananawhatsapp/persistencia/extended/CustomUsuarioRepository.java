package com.banana.bananawhatsapp.persistencia.extended;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;

public interface CustomUsuarioRepository {
    public boolean valido(Usuario user) throws UsuarioException;
}
