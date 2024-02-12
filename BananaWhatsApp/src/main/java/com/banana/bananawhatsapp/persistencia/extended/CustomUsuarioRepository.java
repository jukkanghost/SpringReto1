package com.banana.bananawhatsapp.persistencia.extended;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;
import java.util.Set;

public interface CustomUsuarioRepository {
    public boolean valido(Usuario user) throws UsuarioException;

    public Usuario crear(Usuario usuario) throws SQLException;

    public Usuario actualizar(Usuario usuario) throws SQLException;

    public boolean borrar(Usuario usuario) throws SQLException;

    public Usuario obtener(int id) throws SQLException;

    public Set<Usuario> obtenerPosiblesDestinatarios(Integer id, Integer max) throws SQLException;
}
