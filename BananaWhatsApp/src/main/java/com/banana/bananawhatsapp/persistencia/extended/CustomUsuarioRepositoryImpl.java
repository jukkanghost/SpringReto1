package com.banana.bananawhatsapp.persistencia.extended;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;

import java.sql.SQLException;
import java.util.Set;

public class CustomUsuarioRepositoryImpl implements CustomUsuarioRepository{

    @Override
    public boolean valido(Usuario user) throws UsuarioException {
        return  user.valido();
    }

    @Override
    public Usuario obtener(int id) throws SQLException {
        return null;
    }

    @Override
    public Usuario crear(Usuario usuario) throws SQLException {
        return null;
    }

    @Override
    public Usuario actualizar(Usuario usuario) throws SQLException {
        return null;
    }

    @Override
    public boolean borrar(Usuario usuario) throws SQLException {
        return false;
    }

    @Override
    public Set<Usuario> obtenerPosiblesDestinatarios(Integer id, Integer max) throws UsuarioException {
        return null;
    }


}
