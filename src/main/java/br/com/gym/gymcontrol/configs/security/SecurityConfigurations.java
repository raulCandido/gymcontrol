package br.com.gym.gymcontrol.configs.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    //configurar autenticacao
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	// TODO Auto-generated method stub
    }

    //configurar autorizacao
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	//config de endpoints e metodos que podem ser liberados
	http.authorizeRequests().antMatchers("/pessoas").permitAll();
    }

    //configuracao de recursos estaticos como css/js/imagens
    @Override
    public void configure(WebSecurity web) throws Exception {
	// TODO Auto-generated method stub
    }
}
