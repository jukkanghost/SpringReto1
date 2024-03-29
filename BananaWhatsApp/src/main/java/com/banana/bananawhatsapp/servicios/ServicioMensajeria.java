package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.MensajeException;
import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import com.banana.bananawhatsapp.persistencia.mensaje.MensajeRepositoryData;
import com.banana.bananawhatsapp.persistencia.usuario.UsuarioRepositoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
@Service
public class ServicioMensajeria implements IServicioMensajeria{

    @Autowired
    private UsuarioRepositoryData repoUsuario;
    @Autowired
    private MensajeRepositoryData repoMensaje;
    @Override
    public Mensaje enviarMensaje(Usuario remitente, Usuario destinatario, String texto) throws UsuarioException, MensajeException {
        Usuario remi = repoUsuario.findById(remitente.getId()).get();
        Usuario dest = repoUsuario.findById(destinatario.getId()).get();
        Mensaje mensaje = new Mensaje(null, remi, dest, texto, LocalDate.now());
        if (mensaje.valido()) {
            return repoMensaje.save(mensaje);
        } else return null;
    }

    @Override
    public List<Mensaje> mostrarChatConUsuario(Usuario remitente, Usuario destinatario) throws UsuarioException, MensajeException {
//        Usuario remi = repoUsuario.findById(remitente.getId()).get();
//        Usuario dest = repoUsuario.findById(destinatario.getId()).get();
        if (remitente.valido() && destinatario.valido()){
            return repoMensaje.findByRemitenteAndDestinatario(remitente, destinatario);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean borrarChatConUsuario(Usuario remitente, Usuario destinatario) throws UsuarioException, MensajeException {
//        Usuario remi = repoUsuario.findById(remitente.getId()).get();
//        Usuario dest = repoUsuario.findById(destinatario.getId()).get();
        if (remitente.valido() && destinatario.valido()){
            repoMensaje.deleteByRemitenteAndDestinatario(remitente, destinatario);
            //repoMensaje.deleteByRemitenteAndDestinatario(dest, remi);
            return true;
        }
        return false;
    }
}
