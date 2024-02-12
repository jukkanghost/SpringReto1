package com.banana.bananawhatsapp.persistencia.usuario;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;

import java.sql.SQLException;
import java.util.Set;

public interface CustomUsuarioRepository {
    public Usuario crear(Usuario usuario) throws SQLException;

    public Usuario actualizar(Usuario usuario) throws SQLException;

    public boolean borrar(Usuario usuario) throws SQLException;

    public Usuario obtener(int id) throws SQLException;

    public Set<Usuario> obtenerPosiblesDestinatarios(Integer id, Integer max) throws SQLException;
}
