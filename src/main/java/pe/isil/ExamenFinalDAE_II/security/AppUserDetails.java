package pe.isil.ExamenFinalDAE_II.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pe.isil.ExamenFinalDAE_II.model.Usuario;

import java.util.Collection;
import java.util.Collections;

public class AppUserDetails implements UserDetails {

    public final String nombres;
    private final String apellidos;
    private final String email;
    private final String rol;
    private final Usuario usuario;

    public AppUserDetails(Usuario usuario){
        this.usuario = usuario;
        this.nombres = usuario.getNombres();
        this.apellidos = usuario.getApellidos();
        this.email = usuario.getEmail();
        this.rol = String.valueOf(usuario.getRol());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().name()));
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
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

    public String getNombres(){
        return nombres;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getEmail(){
        return email;
    }
    public String getRol(){
        return rol;
    }
}
