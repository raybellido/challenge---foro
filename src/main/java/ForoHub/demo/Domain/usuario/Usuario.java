package ForoHub.demo.Domain.usuario;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Usuario implements UserDetails {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDateTime dateTime;

    public Usuario(DatosRegistroUsuario datos) {
        this.id = null;
        this.login = datos.login();
        this.contrasena = datos.contrasena();
        this.nombre = datos.nombre();
        this.apellido = datos.apellido();
        this.email=datos.email();
        this.role = Role.ROLE_USER;
    }

    @PrePersist
    public void prePersist() {
        this.dateTime = LocalDateTime.now();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public @Nullable String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void actualizarDatosInformacion(@Valid DatosActualizarUsuario datos) {
        if (datos.login() != null) {
            this.login = datos.login();
        }
        if (datos.nombre() != null) {
            this.nombre = datos.nombre();
        }
        if (datos.contrasena() != null){
            this.contrasena = datos.contrasena();
        }
        if(datos.email() != null){
          this.email = datos.email();
        }
        if(datos.apellido() != null){
            this.apellido = datos.apellido();
        }
    }
}