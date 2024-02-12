package com.banana.bananawhatsapp.modelos;

import com.banana.bananawhatsapp.exceptions.MensajeException;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@NamedQuery(name = "Mensaje.get", query = "SELECT e FROM Mensaje e WHERE e.remitente = ?1 OR e.destinatario = ?1")
@NamedQuery(name = "Mensaje.borra", query = "DELETE FROM Mensaje e WHERE (e.remitente = ?1 AND e.destinatario = ?2) OR (e.remitente = ?2 AND e.destinatario = ?1)")
@NamedQuery(name = "Mensaje.borraTodos", query = "DELETE FROM Mensaje e WHERE e.remitente = ?1 OR e.destinatario = ?1")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "from_user")
    private Usuario remitente;

    @ManyToOne
    @JoinColumn(name = "to_user")
    private Usuario destinatario;

    private String cuerpo;
    private LocalDate fecha;

    private boolean validarFecha() {
        return this.fecha != null && this.fecha.compareTo(LocalDate.now()) <= 0;
    }

    public boolean valido() throws MensajeException {
        if (remitente != null
                && destinatario != null
                && remitente.valido()
                && destinatario.valido()
                && cuerpo != null
                && cuerpo.length() > 10
                && validarFecha()
        ) return true;
        else throw new MensajeException("Mensaje no valido");
    }


}
