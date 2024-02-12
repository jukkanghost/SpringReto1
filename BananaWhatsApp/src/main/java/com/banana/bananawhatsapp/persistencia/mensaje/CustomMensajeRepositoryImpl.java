package com.banana.bananawhatsapp.persistencia.mensaje;

import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

public class CustomMensajeRepositoryImpl implements CustomMensajeRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Mensaje crear(Mensaje mensaje) throws SQLException {
        if (mensaje.valido()) {
            em.persist(mensaje);
            return mensaje;
        } else return null;
    }

    @Override
    @Transactional
    public List<Mensaje> obtener(Usuario usuario) throws SQLException {
        if (usuario.valido()) {
            TypedQuery q = em.createNamedQuery("Mensaje.get", Mensaje.class);
            q.setParameter(1, usuario);
            return q.getResultList();
        } else return null;
    }

    @Override
    @Transactional
    public boolean borrarEntre(Usuario remitente, Usuario destinatario) throws Exception {
        if (remitente.valido() && destinatario.valido()) {
            Query q = em.createNamedQuery("Mensaje.borra");
            q.setParameter(1, remitente);
            q.setParameter(2, destinatario);
            q.executeUpdate();
            return true;
        } else return false;

    }

    @Override
    @Transactional
    public boolean borrarTodos(Usuario usuario) throws SQLException {
        if (usuario.valido()) {
            Query q = em.createNamedQuery("Mensaje.borraTodos");
            q.setParameter(1, usuario);
            q.executeUpdate();
            return true;
        } else return false;
    }
}
