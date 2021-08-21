package br.com.gym.gymcontrol.model.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

    @NotEmpty(message = "E-mail obrigatório")
    private String email;
    @NotEmpty(message = "E-mail obrigatório")
    private String senha;

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public UsernamePasswordAuthenticationToken converter() {
	return new UsernamePasswordAuthenticationToken(email, senha);
    }

}
