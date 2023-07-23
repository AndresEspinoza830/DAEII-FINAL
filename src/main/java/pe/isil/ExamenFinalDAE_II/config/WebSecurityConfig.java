package pe.isil.ExamenFinalDAE_II.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pe.isil.ExamenFinalDAE_II.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //habilitacion del inicio de sesion para autenticacion
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .permitAll()

                .and()

                //definir los permisos con rutas especificas
                .authorizeRequests()

                .antMatchers("/admin/**") //admin/curso, admin/usuarios, admin/cursos/editar/1
                .hasAnyRole("ADMIN")

                .antMatchers("/estudiantes/**")
                .hasAnyRole("ESTUDIANTE")

                .antMatchers("/docentes/**")
                .hasAnyRole("DOCENTE")

                .antMatchers("/cursos/**", "/usuario/**", "/mis-cursos")
                .authenticated()

                .anyRequest()//para el resto de rutas son publica, acceso total
                .permitAll()

                .and()

                .rememberMe().key("rememberMeKey").tokenValiditySeconds(3600)
                .userDetailsService(userDetailsServiceImpl)

                .and()

                .exceptionHandling().accessDeniedPage("/403")

                .and()

                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")).logoutSuccessUrl("/"));
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
