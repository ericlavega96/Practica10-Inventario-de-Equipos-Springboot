package com.pucmm.sistemaalquilerspringboot.sistemaalquiler.config;

import com.pucmm.sistemaalquilerspringboot.sistemaalquiler.servicios.serviciosEntidades.seguridad.ServiciosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurable
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
    //Modo configuracion JPA
    @Autowired
    private ServiciosUsuario serviciosUsuario;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Metodo para encriptar
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        //Configuración JPA.
        auth
                .userDetailsService(serviciosUsuario)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Marcando las reglas de autorizacion
        http
                .authorizeRequests()
                .antMatchers("/","/css/**","/lib/**").permitAll() //permitiendo llamadas a esas urls.
                .antMatchers("/dbconsole/**").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .loginPage("/login") //indicando la ruta que estaremos utilizando.
                .defaultSuccessUrl("/index")
                .failureUrl("/login?error") //en caso de fallar puedo indicar otra pagina.
                .permitAll()
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .rememberMe().key("sisalerad").tokenValiditySeconds(86400); //Activando opcion de recordar sesion



        //deshabilitando las seguridad contra los frame internos.
        //Necesario para H2.
        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

    @Configuration
    public class AdditionalResourceWebConfiguration implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(final ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
        }
    }


}
