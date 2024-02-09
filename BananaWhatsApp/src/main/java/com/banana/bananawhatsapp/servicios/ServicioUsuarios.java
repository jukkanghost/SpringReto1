package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import com.banana.bananawhatsapp.persistencia.IUsuarioRepository;
import com.banana.bananawhatsapp.persistencia.UsuarioRepositoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServicioUsuarios implements IServicioUsuarios{

    @Autowired
    private UsuarioRepositoryData repoUsuario;

    @Override
    public Usuario obtener(int id) throws UsuarioException {
        return repoUsuario.findById(id).orElseThrow(() -> {
            throw new UsuarioException("excepcion de usuario");
        });
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) throws UsuarioException {
        return repoUsuario.save(usuario);
    }

    @Override
    public boolean borrarUsuario(Usuario usuario) throws UsuarioException {
        return false;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws UsuarioException {
        return null;
    }

    @Override
    public Set<Usuario> obtenerPosiblesDesinatarios(Usuario usuario, int max) throws UsuarioException {
        return null;
    }
}
