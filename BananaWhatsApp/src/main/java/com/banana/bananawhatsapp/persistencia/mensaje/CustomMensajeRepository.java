package com.banana.bananawhatsapp.persistencia.mensaje;

import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface CustomMensajeRepository {
    public Mensaje crear(Mensaje mensaje) throws SQLException;

    public List<Mensaje> obtener(Usuario usuario) throws SQLException;

    public boolean borrarEntre(Usuario remitente, Usuario destinatario) throws Exception;

    public boolean borrarTodos(Usuario usuario) throws SQLException;
}
