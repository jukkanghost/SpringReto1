package com.banana.bananawhatsapp.modelos;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@NamedQuery(name = "Usuario.get", query = "SELECT e FROM Usuario e WHERE e.id != ?1")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String email;
    private LocalDate alta;
    private boolean activo;

    @ToString.Exclude
    @OneToMany(mappedBy = "remitente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mensaje> enviados;

    @ToString.Exclude
    @OneToMany(mappedBy = "destinatario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mensaje> recibidos;

    public Usuario(Integer id, String nombre, String email, LocalDate alta, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.alta = alta;
        this.activo = activo;
    }

    private boolean validarNombre() {
        return this.nombre != null && this.nombre.length() >= 3;
    }

    private boolean validarEmail() {
        return this.email != null && this.email.indexOf("@") > 0 && this.email.indexOf(".") > 0;
    }

    private boolean validarAlta() {
        return this.alta != null && this.alta.compareTo(LocalDate.now()) <= 0;
    }

    public boolean valido() throws UsuarioException {
        if ((id != null && id > 0 || id == null)
                && activo
                && validarNombre()
                && validarEmail()
                && validarAlta()
        ) return true;
        else throw new UsuarioException("Usuario no valido");
    }
}
