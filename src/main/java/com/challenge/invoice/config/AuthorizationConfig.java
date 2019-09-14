package com.challenge.invoice.config;

import com.challenge.invoice.entity.User;
import com.challenge.invoice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.GET, //
                "/", //
                "/webjars/**", //
                "/*.html", //
                "/favicon.ico", //
                "/**/*.html", //
                "/v2/api-docs", //
                "/configuration/ui", //
                "/swagger-resources/**", //
                "/configuration/**", //
                "/swagger-ui.html", //
                "/webjars/**", //
                "/**/*.css", //
                "/**/*.js"//
        );
    }


    @Autowired
    protected void configure(AuthenticationManagerBuilder auth, UserRepository repository) throws Exception {
        User usuario = new User();
        usuario.setPassword("adminadmin");
        usuario.setEmail("admin@admin.com");

        if (repository.count() == 0)
            repository.saveAndFlush(usuario);
        auth.userDetailsService(email -> repository.findByEmail(email).orElse(null));
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
//Teste git!!!