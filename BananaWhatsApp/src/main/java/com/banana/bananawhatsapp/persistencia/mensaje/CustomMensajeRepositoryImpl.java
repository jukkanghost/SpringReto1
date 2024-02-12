package com.banana.bananawhatsapp.persistencia.mensaje;

import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

public class CustomMensajeRepositoryImpl implements CustomMensajeRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Mensaje crear(Mensaje mensaje) throws SQLException {
        if(mensaje.valido()) {
            em.persist(mensaje);
            return mensaje;
        }
        else return null;
    }

    @Override
    public List<Mensaje> obtener(Usuario usuario) throws SQLException {
        return null;
    }

    @Override
    public boolean borrarEntre(Usuario remitente, Usuario destinatario) throws Exception {
        return false;
    }

    @Override
    public boolean borrarTodos(Usuario usuario) throws SQLException {
        return false;
    }
}
