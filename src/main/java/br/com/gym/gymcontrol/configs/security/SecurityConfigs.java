package br.com.gym.gymcontrol.configs.security;

import br.com.gym.gymcontrol.service.TokenService;
import br.com.gym.gymcontrol.service.UserService;
import br.com.gym.gymcontrol.service.impl.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfigs extends WebSecurityConfigurerAdapter {

    private final AuthenticationService authenticationService;
    private final TokenService tokenService;
    private final UserService userService;

    @Autowired
    public SecurityConfigs(AuthenticationService authenticationService, TokenService tokenService, @Lazy UserService userService) {
        this.authenticationService = authenticationService;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // configurar autenticacao
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // configurar autorizacao --por padrao qualquer recurso nao explicitado na
    // config fica bloqueado
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // config de endpoints e metodos que podem ser liberados
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new JwtTokenFilter(tokenService, userService), UsernamePasswordAuthenticationFilter.class);
    }

    // configuracao de recursos estaticos como css/js/imagens
    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui", "/configuration/security", "/swagger-ui.html", "/webjars/**", "/v3/api-docs/**", "/swagger-ui/**");

    }

}
