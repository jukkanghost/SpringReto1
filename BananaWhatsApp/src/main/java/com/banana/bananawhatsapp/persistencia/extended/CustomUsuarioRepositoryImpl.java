package com.banana.bananawhatsapp.persistencia.extended;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CustomUsuarioRepositoryImpl implements CustomUsuarioRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public boolean valido(Usuario user) throws UsuarioException {
        return user.valido();
    }

    @Override
    @Transactional
    public Usuario crear(Usuario usuario) throws SQLException {
       if(valido(usuario)) {
            em.persist(usuario);
            return usuario;
        }
        else return null;
    }

    @Override
    @Transactional
    public Usuario actualizar(Usuario usuario) throws SQLException {
       if(valido(usuario)) {

           Usuario currUsuario = em.find(Usuario.class, usuario.getId());

           currUsuario.setNombre(usuario.getNombre());
           currUsuario.setEmail(usuario.getEmail());
           currUsuario.setAlta(usuario.getAlta());
           currUsuario.setActivo(usuario.isActivo());

           return currUsuario;
       }
        else return null;
    }

    @Override
    @Transactional
    public boolean borrar(Usuario usuario) throws SQLException {
        Usuario removeUsuario = obtener(usuario.getId());
        if(removeUsuario.valido()){
            em.remove(removeUsuario);
            return true;
        }
        else return false;
    }

    @Override
    @Transactional
    public Usuario obtener(int id) throws SQLException {
        Usuario user = em.find(Usuario.class, id);
        if(user != null) {
            return user;
        }
        else throw new UsuarioException("usario no encontrado");
    }


    @Override
    public Set<Usuario> obtenerPosiblesDestinatarios(Integer id, Integer max) throws UsuarioException, SQLException {
        if ((id != null && id > 0 || id == null)) {
            Usuario user = obtener(id);

            TypedQuery q = em.createNamedQuery("Usuario.get", Usuario.class);
            q.setParameter(1, id);
            q.setMaxResults(max);
            return new HashSet<Usuario>(q.getResultList());
        }
        else throw new UsuarioException("id no valido");
    }


}
