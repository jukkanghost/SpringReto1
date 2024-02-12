package com.banana.bananawhatsapp.persistencia.extended;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;
import java.util.Set;

public interface CustomUsuarioRepository {
    public boolean valido(Usuario user) throws UsuarioException;

    public Usuario obtener(int id) throws SQLException;
    public Usuario crear(Usuario usuario) throws SQLException;

    public Usuario actualizar(Usuario usuario) throws SQLException;

    public boolean borrar(Usuario usuario) throws SQLException;
    @Query( nativeQuery = true, value = "SELECT * FROM Usuario s WHERE s.id != ?1 ORDER BY s.id LIMIT ?2")
    public Set<Usuario> obtenerPosiblesDestinatarios(Integer id, Integer max) throws SQLException;
}
