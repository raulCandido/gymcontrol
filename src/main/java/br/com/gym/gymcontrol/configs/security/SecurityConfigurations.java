package br.com.gym.gymcontrol.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthService authService;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
	return super.authenticationManager();
    }

    // configurar autenticacao
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(authService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // configurar autorizacao --por padrao qualquer recurso nao explicitado na config fica bloqueado
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	// config de endpoints e metodos que podem ser liberados
	http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/pessoas").permitAll()
		.antMatchers("/*").permitAll()
		.antMatchers(HttpMethod.POST, "/login").permitAll()
		.antMatchers(HttpMethod.GET, "/pessoas/*").permitAll()
		.antMatchers(HttpMethod.POST, "/pessoas").permitAll()
		.antMatchers(HttpMethod.DELETE, "/pessoas/*").permitAll()
		.antMatchers(HttpMethod.POST, "/alunos").permitAll()
		.antMatchers(HttpMethod.PUT, "/professores/*").permitAll()
		.anyRequest().authenticated().and().csrf() // desabilitando csrf(Cross-site Request Forgery) -- login stateless nao precisa disso.
		.disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    // configuracao de recursos estaticos como css/js/imagens
    @Override
    public void configure(WebSecurity web) throws Exception {
    }

}
