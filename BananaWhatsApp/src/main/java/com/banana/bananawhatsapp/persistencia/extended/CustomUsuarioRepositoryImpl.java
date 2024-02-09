package com.banana.bananawhatsapp.persistencia.extended;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;

public class CustomUsuarioRepositoryImpl implements CustomUsuarioRepository{

    @Override
    public boolean valido(Usuario user) throws UsuarioException {
        return  user.valido();
    }
}
